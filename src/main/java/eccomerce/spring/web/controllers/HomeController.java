package eccomerce.spring.web.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import eccomerce.spring.admin.models.Produto;
import eccomerce.spring.admin.repositories.ProdutoImagensRepositorio;
import eccomerce.spring.admin.repositories.ProdutoRepositorio;

@Controller
public class HomeController {

	@Autowired
	private ProdutoRepositorio produtoRepo;
	@Autowired
	private ProdutoImagensRepositorio produtoImagensRepo;
	
	public HomeController(ProdutoRepositorio produtoRepo) {
		this.produtoRepo = produtoRepo;
	}
	
	@GetMapping
	public String produtos(Model model) {
		model.addAttribute("listaProdutos", produtoRepo.findAll());
		return "index";
	}
	
	@GetMapping("/produto/detalhes-eccomerce/{id}")
	public String detalhesProduto(@PathVariable("id") long id, Model model) {
		Optional<Produto> produto = produtoRepo.findById(id);
		if (produto ==null) {
			throw new IllegalArgumentException("Produto inválido!");
		}
		
		model.addAttribute("produto", produto.get());
		model.addAttribute("imagens", produtoImagensRepo.findAll());
		return "detalhesProduto";
	}
}