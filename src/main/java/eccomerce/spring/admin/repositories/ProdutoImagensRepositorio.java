package eccomerce.spring.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eccomerce.spring.admin.models.ProdutoImagens;

@Repository
public interface ProdutoImagensRepositorio extends JpaRepository<ProdutoImagens, Long> {

}