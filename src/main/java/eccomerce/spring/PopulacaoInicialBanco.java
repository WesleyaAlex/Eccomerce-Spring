package eccomerce.spring;

import java.time.LocalDate;

import javax.transaction.Transactional;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import eccomerce.spring.admin.models.Produto;
import eccomerce.spring.admin.models.Usuario;
import eccomerce.spring.admin.repositories.ProdutoRepositorio;
import eccomerce.spring.admin.repositories.UsuarioRepositorio;
import eccomerce.spring.web.models.Cliente;
import eccomerce.spring.web.models.ClienteEnderecos;
import eccomerce.spring.web.repositories.ClienteEnderecosRepositorio;
import eccomerce.spring.web.repositories.ClienteRepositorio;

@Component
@Transactional
public class PopulacaoInicialBanco implements CommandLineRunner {

	@Autowired
	private ProdutoRepositorio produtoRepo;
	
	@Autowired
	private UsuarioRepositorio userRepo;
	
	@Autowired
	private ClienteRepositorio clienteRepo;
	
	@Autowired
	private ClienteEnderecosRepositorio clientEnderecosRepo;
	
	@Override
	public void run(String... args) throws Exception {
		Produto produto1 = new Produto("Xbox", "Esse é mais barato", 399.99, 10, true,"circulo.jpg");
		Produto produto2 = new Produto("PS4", "Esse é mais caro", 1299.99, 5, true,"circulo.jpg");
		Produto produto3 = new Produto("Xbox", "Esse é mais barato", 399.99, 10, true,"circulo.jpg");
		Produto produto4 = new Produto("PS4", "Esse é mais caro", 1299.99, 5, true,"circulo.jpg");
		Produto produto5 = new Produto("Xbox", "Esse é mais barato", 399.99, 10, true,"circulo.jpg");
		Produto produto6 = new Produto("PS4", "Esse é mais caro", 1299.99, 5, true,"circulo.jpg");
		Produto produto7 = new Produto("Xbox", "Esse é mais barato", 399.99, 10, true,"circulo.jpg");
		Produto produto8 = new Produto("PS4", "Esse é mais caro", 1299.99, 5, true,"circulo.jpg");
		produtoRepo.save(produto1);
		produtoRepo.save(produto2);
		produtoRepo.save(produto3);
		produtoRepo.save(produto4);
		produtoRepo.save(produto5);
		produtoRepo.save(produto6);
		produtoRepo.save(produto7);
		produtoRepo.save(produto8);
		
		Usuario user1 = new Usuario("admin@email.com", "$2a$10$F4jLqv83pLKFgmi81frTJuAhZT7pn0xNkLxxhnRebVK0rQxjfifcW", "$2a$10$F4jLqv83pLKFgmi81frTJuAhZT7pn0xNkLxxhnRebVK0rQxjfifcW", "Wesley", "50501985859", "Admin", true);
		Usuario user2 = new Usuario("estoquista@email.com", "$2a$10$reR1mTPLT9qu/TfF2cvI0e1H9W4Bg3EgHGYlmcw7huEiji7KnAi2K", "$2a$10$reR1mTPLT9qu/TfF2cvI0e1H9W4Bg3EgHGYlmcw7huEiji7KnAi2K", "Wesley", "50501985859", "Estoquista", true);
		Usuario user3 = new Usuario("cliente@email.com", "$2a$10$k2.akx231FErOhgfGqmDa.sEYPamM8h/SGuGXvwazJv4mgxkDlw/.", "$2a$10$k2.akx231FErOhgfGqmDa.sEYPamM8h/SGuGXvwazJv4mgxkDlw/.", "Wesley", "50501985859", "Cliente", true);
		userRepo.save(user1);
		userRepo.save(user2);
		userRepo.save(user3);
		
		LocalDate date = LocalDate.of(2020, 1, 8);
		Cliente cliente1 = new Cliente("Wesley", "cliente@gmail.com", "05819370", "masculino", date, "$2a$10$Udqav1CQFuD19ve4QSTld.FAZnqzxoJTBDakvbUT8Oi/CL8TO1VTu","$2a$10$Udqav1CQFuD19ve4QSTld.FAZnqzxoJTBDakvbUT8Oi/CL8TO1VTu", "50501985859", "Rua Antonio Aranha", "Santa Josefina", "São Paulo", "SP");
		clienteRepo.save(cliente1);
		
		ClienteEnderecos endereco1 = new ClienteEnderecos("50501985859", "Rua Antonio Aranha", "Santa Josefina", "São Paulo", "SP");
		clientEnderecosRepo.save(endereco1);
	}
}