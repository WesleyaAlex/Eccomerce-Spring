package eccomerce.spring.web.models;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;
import eccomerce.spring.web.validation.SenhasIguais;

@SenhasIguais
@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Size(max = 200, message = "O nome deve ter no máximo 200 caracteres!")
	@NotBlank(message = "O campo nome não pode estar vazio!")
	private String nome;

	@NotBlank(message = "O campo email não pode estar vazio!")
	@Email
	private String email;
	
	@NotBlank(message = "O campo gênero não pode estar vazio!")
	private String genero;
	
	@NotNull(message = "O campo dataNascimento não pode estar vazio!")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) // ISO-8601
    private LocalDate dataNascimento;

	@NotBlank(message = "O campo senha não pode estar vazio!")
	private String senha;
	
	@NotBlank(message = "O campo confirme a senha não pode estar vazio!")
	private String confirmSenha;
	
	@NotBlank(message = "O campo CPF não pode estar vazio!")
	@CPF(message = "O campo CPF precisa estar no formato correto!")
	private String cpf;
	
	@NotBlank(message = "O campo CEP não pode estar vazio!")
	private String cep;
	
	@NotBlank(message = "O campo logradouro não pode estar vazio!")
	private String logradouro;

	@NotBlank(message = "O campo bairro não pode estar vazio!")
    private String bairro;

	@NotBlank(message = "O campo cidade não pode estar vazio!")
    private String cidade;

	@NotBlank(message = "O campo uf não pode estar vazio!")
    private String uf;
	
	public Cliente() {}
	
	public Cliente(
			@Size(max = 200, message = "O nome deve ter no máximo 200 caracteres!") @NotBlank(message = "O campo nome não pode estar vazio!") String nome,
			@NotBlank(message = "O campo email não pode estar vazio!") @Email String email,
			@NotBlank(message = "O campo CEP não pode estar vazio!") String cep,
			@NotBlank(message = "O campo gênero não pode estar vazio!") String genero,
			@NotNull(message = "O campo dataNascimento não pode estar vazio!") LocalDate dataNascimento,
			@NotBlank(message = "O campo senha não pode estar vazio!") String senha,
			@NotBlank(message = "O campo confirme a senha não pode estar vazio!") String confirmSenha,
			@NotBlank(message = "O campo CPF não pode estar vazio!") @CPF(message = "O campo CPF precisa estar no formato correto!") String cpf,
			String logradouro, String bairro, String cidade, String uf) {
		this.nome = nome;
		this.email = email;
		this.cep = cep;
		this.genero = genero;
		this.dataNascimento = dataNascimento;
		this.senha = senha;
		this.confirmSenha = confirmSenha;
		this.cpf = cpf;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
}