package eccomerce.spring;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import eccomerce.spring.admin.models.Produto;
import eccomerce.spring.admin.repositories.ProdutoRepositorio;

@Component
@Transactional
public class PopulacaoInicialBanco implements CommandLineRunner {

	@Autowired
	private ProdutoRepositorio produtoRepo;
	
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
	}
}