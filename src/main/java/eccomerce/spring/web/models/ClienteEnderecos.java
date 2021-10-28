package eccomerce.spring.web.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class ClienteEnderecos {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
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
	
	public ClienteEnderecos() {};
	
	public ClienteEnderecos(@NotBlank(message = "O campo CEP não pode estar vazio!") String cep,
			@NotBlank(message = "O campo logradouro não pode estar vazio!") String logradouro,
			@NotBlank(message = "O campo bairro não pode estar vazio!") String bairro,
			@NotBlank(message = "O campo cidade não pode estar vazio!") String cidade,
			@NotBlank(message = "O campo uf não pode estar vazio!") String uf) {
		this.cep = cep;
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