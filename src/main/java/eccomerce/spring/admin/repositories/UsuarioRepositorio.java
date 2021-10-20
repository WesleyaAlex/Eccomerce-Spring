package eccomerce.spring.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import eccomerce.spring.admin.models.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>  {
	
	@Query(value = "FROM Usuario WHERE email = ?1")
    Usuario findByEmail(String email);
}