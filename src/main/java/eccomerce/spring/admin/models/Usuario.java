package eccomerce.spring.admin.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import eccomerce.spring.admin.validation.SenhasIguais;

@SenhasIguais
@Entity
public class Usuario implements UserDetails {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message = "O campo email não pode estar vazio!")
	@Email(message = "O campo email deve estar no formato correto!")
    private String email;
    
	@NotBlank(message = "O campo senha não pode estar vazio!")
    private String senha;
    
	@NotBlank(message = "O campo confirme a senha não pode estar vazio!")
    private String confirmSenha;

	@NotBlank(message = "O campo nome não pode estar vazio!")
    private String nome;
    
	@NotBlank(message = "O campo cpf não pode estar vazio!")
    private String cpf;
    
	@NotBlank(message = "O campo grupo não pode estar vazio!")
    private String grupo;
    
    private boolean status;
    
    public Usuario() {}

    public Usuario(String email, String senha, String confirmSenha, String nome, String cpf, String grupo, boolean status) {
        this.email = email;
        this.senha = senha;
        this.confirmSenha = confirmSenha;
        this.nome = nome;
        this.cpf = cpf;
        this.grupo = grupo;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmSenha() {
        return confirmSenha;
    }

    public void setConfirmSenha(String confirmSenha) {
        this.confirmSenha = confirmSenha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String ROLE_PREFIX = "ROLE_";
		
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        list.add(new SimpleGrantedAuthority(ROLE_PREFIX + this.grupo.toUpperCase()));
        return list;
	}

	@Override
	public String getPassword() {
		return this.getSenha();
	}

	@Override
	public String getUsername() {
		return this.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}