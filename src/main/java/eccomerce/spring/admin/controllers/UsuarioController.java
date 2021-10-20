package eccomerce.spring.admin.controllers;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import eccomerce.spring.admin.models.Usuario;
import eccomerce.spring.admin.repositories.UsuarioRepositorio;

@Controller
public class UsuarioController {

	private UsuarioRepositorio usuarioRepo;
	
	public UsuarioController(UsuarioRepositorio usuarioRepo) {
		this.usuarioRepo = usuarioRepo;
	}
	
	@GetMapping("/backoffice/usuarios")
	public String usuarios(Model model) {
		model.addAttribute("listaUsuarios", usuarioRepo.findAll());
		return "backoffice/usuario/index";
	}
	
	@GetMapping("/backoffice/usuario/{id}")
	public String alterarUsuario(@PathVariable("id") long id, Model model) {
		Optional<Usuario> usuario = usuarioRepo.findById(id);
		if (usuario.isEmpty()) {
			throw new IllegalArgumentException("Usuario inválido!");
		}
		
		model.addAttribute("usuario", usuario.get());
		return "backoffice/usuario/form";
	}
	
	@GetMapping("/backoffice/usuario/cadastrar")
	public String cadastrarUsuario(@ModelAttribute("usuario") Usuario usuario) {
		return "backoffice/usuario/form";
	}
	
	@PostMapping("/backoffice/usuario/salvar")
	public String salvarUsuario(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "backoffice/usuario/form";
		}
		
		usuario.setStatus(true);
		usuarioRepo.save(usuario);
		
		return "redirect:/backoffice/usuarios";
	}
	
	@GetMapping("/backoffice/usuario/excluir/{id}")
	public String excluirUsuario(@PathVariable("id") long id) {
		Optional<Usuario> usuario = usuarioRepo.findById(id);
		if (usuario.isEmpty()) {
			throw new IllegalArgumentException("usuario inválido!");
		}
		
		if (usuario.get().getStatus()) {
			usuario.get().setStatus(false);
		} else {
			usuario.get().setStatus(true);
		}
		usuarioRepo.save(usuario.get());
		return "redirect:/backoffice/usuarios";
	}
}