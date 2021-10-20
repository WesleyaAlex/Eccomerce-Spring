package eccomerce.spring.admin.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
//@Table(name = "Usuario", uniqueConstraints= { @UniqueConstraint(columnNames ={"email"})})
public class Usuario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message = "O campo email não pode estar vazio!")
	@Email(message = "O campo email deve estar no formato correto!")
    private String email;
    
	@NotBlank(message = "O campo email não pode estar vazio!")
    private String senha;
    
	@NotBlank(message = "O campo email não pode estar vazio!")
    private String confirmSenha;

	@NotBlank(message = "O campo email não pode estar vazio!")
    private String nome;
    
	@NotBlank(message = "O campo email não pode estar vazio!")
    private String cpf;
    
	@NotBlank(message = "O campo email não pode estar vazio!")
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
}