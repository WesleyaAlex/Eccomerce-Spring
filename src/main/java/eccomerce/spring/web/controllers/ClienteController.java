package eccomerce.spring.web.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eccomerce.spring.web.models.Cliente;
import eccomerce.spring.web.models.ClienteEnderecos;
import eccomerce.spring.web.repositories.ClienteEnderecosRepositorio;
import eccomerce.spring.web.repositories.ClienteRepositorio;

@Controller
public class ClienteController {

	@Autowired
	private ClienteRepositorio clienteRepo;
	
	@Autowired
	private ClienteEnderecosRepositorio clienteEnderecosRepo;
	
	public ClienteController(ClienteRepositorio clienteRepo) {
		this.clienteRepo = clienteRepo;
	}
	
	@GetMapping("/loja/clientes")
	public String clientes(Model model) {
		model.addAttribute("listaClientes", clienteRepo.findAll());
		return "loja/cliente/clientes";
	}
	
	@GetMapping("/loja/cliente/meu-cadastro/{id}")
	public String meuCadastro(@PathVariable("id") long id, Model model) {
		Optional<Cliente> cliente = clienteRepo.findById(id);
		if (cliente.isEmpty()) {
			throw new IllegalArgumentException("Cliente inválido!");
		}
		
		model.addAttribute("cliente", cliente.get());
		return "loja/cliente/meuCadastro";
	}
	
	@GetMapping("/loja/cliente/enderecos/{id}")
	public String enderecos(@PathVariable("id") long id, Model model) {
		Optional<Cliente> cliente = clienteRepo.findById(id);
		if (cliente.isEmpty()) {
			throw new IllegalArgumentException("Cliente inválido!");
		}
		
		List<ClienteEnderecos> endereco = clienteEnderecosRepo.findAll();
		model.addAttribute("cliente", cliente.get());
		model.addAttribute("enderecos", endereco);
		return "loja/cliente/enderecos";
	}
	
	@GetMapping("/loja/cliente/logar")
	public String telaLogin(Model model) {
		return "loja/login/index";
	}
	
	@PostMapping("/loja/cliente/logando")
	public String logar(Model model, @RequestParam("email") String email, @RequestParam("senha") String senha, HttpSession session) {
		Cliente cliente = clienteRepo.findByEmail(email);
		if (cliente != null) {
			boolean senhaAtualValida = BCrypt.checkpw(senha, cliente.getSenha());
			if (senhaAtualValida) {
				session.setAttribute("cliente", cliente);
				return "redirect:/";
			}
		}

		model.addAttribute("msgLogin", "Erro ao efetuar o login, cliente inválido!");
		return "loja/login/index";
	}
	
	@GetMapping("/loja/cliente/deslogar")
	public String deslogar(Model model, HttpSession session) {
		session.removeAttribute("cliente");
		return "redirect:/";
	}
	
	@GetMapping("/loja/cliente/cadastrar")
	public String cadastrar(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		return "loja/cliente/cadastrar";
	}
	
	@GetMapping("/loja/cliente/conta/{id}")
	public String minhaConta(@PathVariable("id") long id, Model model) {
		Optional<Cliente> cliente = clienteRepo.findById(id);
		if (cliente.isEmpty()) {
			throw new IllegalArgumentException("Cliente inválido!");
		}
		
		model.addAttribute("cliente", cliente.get());
		return "loja/cliente/minhaConta";
	}
	
	@GetMapping("/loja/cliente/{id}")
	public String alterarCliente(@PathVariable("id") long id, Model model) {
		Optional<Cliente> cliente = clienteRepo.findById(id);
		if (cliente.isEmpty()) {
			throw new IllegalArgumentException("Cliente inválido!");
		}

		model.addAttribute("cliente", cliente.get());
		return "loja/cliente/alterar";
	}
	
	@PostMapping("/loja/cliente/salvar")
	public String salvarCliente(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult bindingResult, Model model, @RequestParam("endereco_check") List<String> endereco_check) {
		if (bindingResult.hasErrors()) {
			
			return "loja/cliente/cadastrar";
		}
		
		String senha = new BCryptPasswordEncoder().encode(cliente.getSenha());
		cliente.setSenha(senha);
		cliente.setConfirmSenha(senha);
		
		if(endereco_check.size() > 1) {
			ClienteEnderecos endereco = new ClienteEnderecos(cliente.getCep(), cliente.getLogradouro(), cliente.getBairro(), cliente.getCidade(), cliente.getUf(), true);
			clienteEnderecosRepo.save(endereco);
		}
		
		clienteRepo.save(cliente);
		
		return "redirect:/loja/cliente/logar";
	}
	
	@GetMapping("/loja/cliente/excluir/{id}")
	public String excluirCliente(@PathVariable("id") long id) {
		Optional<Cliente> cliente = clienteRepo.findById(id);
		if (cliente.isEmpty()) {
			throw new IllegalArgumentException("Cliente inválido!");
		}
		
		clienteRepo.delete(cliente.get());
		return "redirect:/";
	}
}