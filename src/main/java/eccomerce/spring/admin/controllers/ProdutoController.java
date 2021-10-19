package eccomerce.spring.admin.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import eccomerce.spring.admin.models.Produto;
import eccomerce.spring.admin.models.ProdutoImagens;
import eccomerce.spring.admin.repositories.ProdutoImagensRepositorio;
import eccomerce.spring.admin.repositories.ProdutoRepositorio;

@Controller
public class ProdutoController {

	private ProdutoRepositorio produtoRepo;
	@Autowired
	private ProdutoImagensRepositorio produtoImagensRepo;
	public static String uploadDirectory = "src\\main\\resources\\static\\uploads\\";
	
	public ProdutoController(ProdutoRepositorio produtoRepo) {
		this.produtoRepo = produtoRepo;
	}
	
	@GetMapping("/backoffice/produtos")
	public String produtos(Model model) {
		model.addAttribute("listaProdutos", produtoRepo.findAll());
		return "backoffice/produto/index";
	}
	
	@GetMapping("/backoffice/produto/{id}")
	public String alterarProduto(@PathVariable("id") long id, Model model) {
		Optional<Produto> produto = produtoRepo.findById(id);
		if (produto.isEmpty()) {
			throw new IllegalArgumentException("Produto inválido!");
		}
		
		model.addAttribute("produto", produto.get());
		return "backoffice/produto/form";
	}
	
	@GetMapping("/backoffice/produto/cadastrar")
	public String cadastrarProduto(@ModelAttribute("produto") Produto produto) {
		return "backoffice/produto/form";
	}
	
	@PostMapping("/backoffice/produto/salvar")
	public String salvarProduto(@Valid @ModelAttribute("produto") Produto produto, BindingResult bindingResult, @RequestParam("files") MultipartFile[] files) {
		if (bindingResult.hasErrors()) {
			return "backoffice/produto/form";
		}
		produto.setImg(files[0].getOriginalFilename());
		produtoRepo.save(produto);
		
		StringBuilder fileNames = new StringBuilder();
		for(MultipartFile file : files) {
			Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
			fileNames.append(file.getOriginalFilename());
			ProdutoImagens prodImg = new ProdutoImagens(file.getOriginalFilename(), produto.getId());
			try {
				Files.write(fileNameAndPath, file.getBytes());
				produtoImagensRepo.save(prodImg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return "redirect:/backoffice/produtos";
	}
	
	@GetMapping("/backoffice/produto/excluir/{id}")
	public String excluirProduto(@PathVariable("id") long id) {
		Optional<Produto> produto = produtoRepo.findById(id);
		if (produto.isEmpty()) {
			throw new IllegalArgumentException("Produto inválido!");
		}
		
		produtoRepo.delete(produto.get());
		return "redirect:/backoffice/produtos";
	}
	
	@GetMapping("/backoffice/produto/detalhes/{id}")
	public String detalhesProduto(@PathVariable("id") long id, Model model) {
		Optional<Produto> produto = produtoRepo.findById(id);
		if (produto==null) {
			throw new IllegalArgumentException("Produto inválido!");
		}
		
		model.addAttribute("produto", produto.get());
		model.addAttribute("imagens", produtoImagensRepo.findAll());
		return "backoffice/produto/detalhesProduto";
	}
	
	@GetMapping("/backoffice/produto/mostrarImagem/{imagem}")
	@ResponseBody
	public byte[] retornarImagem(@PathVariable("imagem") String imagem) throws IOException {
		File imagemArquivo = new File(uploadDirectory + imagem);
		System.out.println(uploadDirectory + imagem);
		if (imagem != null || imagem.trim().length() > 0) {
			return Files.readAllBytes(imagemArquivo.toPath());
		}
		return null;
	}
}