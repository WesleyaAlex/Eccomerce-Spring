package eccomerce.spring.admin.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import eccomerce.spring.admin.models.ProdutoImagens;

@Repository
public interface ProdutoImagensRepositorio extends JpaRepository<ProdutoImagens, Long> {

	@Query(value = "FROM ProdutoImagens WHERE produtoId = ?1")
	List<ProdutoImagens> findAllByProdutoId(long produtoId);
}