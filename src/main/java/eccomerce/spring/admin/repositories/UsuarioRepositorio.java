package eccomerce.spring.admin.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import eccomerce.spring.admin.models.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>  {
	
	@Query("FROM Usuario WHERE email like ?1")
    List<Usuario> findByEmail(String email);
}