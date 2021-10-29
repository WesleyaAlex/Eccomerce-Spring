package eccomerce.spring.web.controllers;

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
import eccomerce.spring.web.models.ClienteEnderecos;
import eccomerce.spring.web.repositories.ClienteEnderecosRepositorio;

@Controller
public class ClienteEnderecosController {

	@Autowired
	private ClienteEnderecosRepositorio clienteEnderecosRepo;
	
	public ClienteEnderecosController(ClienteEnderecosRepositorio clienteEnderecosRepo) {
		this.clienteEnderecosRepo = clienteEnderecosRepo;
	}
	
	@GetMapping("/loja/endereco/cadastrar")
	public String cadastrar(Model model) {
		ClienteEnderecos endereco = new ClienteEnderecos();
		model.addAttribute("endereco", endereco);
		return "loja/cliente/endereco/form";
	}
	
	@PostMapping("/loja/endereco/salvar")
	public String salvarEndereco(@Valid @ModelAttribute("endereco") ClienteEnderecos clienteEndereco, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			
			return "loja/cliente/endereco/form";
		}
		
		clienteEndereco.setStatus(true);
		clienteEnderecosRepo.save(clienteEndereco);
		
		return "redirect:/";
	}
	
	@GetMapping("/loja/endereco/excluir/{id}")
	public String excluirEndereco(@PathVariable("id") long id) {
		Optional<ClienteEnderecos> endereco = clienteEnderecosRepo.findById(id);
		if (endereco.isEmpty()) {
			throw new IllegalArgumentException("Endereço inválido!");
		}
		
		endereco.get().setStatus(false);
		clienteEnderecosRepo.save(endereco.get());
		return "redirect:/";
	}
}