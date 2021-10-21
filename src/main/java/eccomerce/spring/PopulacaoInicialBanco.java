package eccomerce.spring;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import eccomerce.spring.admin.models.Produto;
import eccomerce.spring.admin.models.Usuario;
import eccomerce.spring.admin.repositories.ProdutoRepositorio;
import eccomerce.spring.admin.repositories.UsuarioRepositorio;

@Component
@Transactional
public class PopulacaoInicialBanco implements CommandLineRunner {

	@Autowired
	private ProdutoRepositorio produtoRepo;
	
	@Autowired
	private UsuarioRepositorio userRepo;
	
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
	}
}