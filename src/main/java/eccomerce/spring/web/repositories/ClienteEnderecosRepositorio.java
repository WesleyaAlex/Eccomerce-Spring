package eccomerce.spring.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import eccomerce.spring.web.models.ClienteEnderecos;

@Repository
public interface ClienteEnderecosRepositorio extends JpaRepository<ClienteEnderecos, Long> {

}