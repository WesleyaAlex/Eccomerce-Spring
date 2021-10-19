package eccomerce.spring.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eccomerce.spring.admin.models.Produto;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {

}