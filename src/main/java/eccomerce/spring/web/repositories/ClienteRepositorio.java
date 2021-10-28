package eccomerce.spring.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import eccomerce.spring.web.models.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long>  {

	@Query(value = "FROM Cliente WHERE email = ?1")
	Cliente findByEmail(String email);
}