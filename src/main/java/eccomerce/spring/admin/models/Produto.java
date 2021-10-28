package eccomerce.spring.admin.models;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Size(max = 200, message = "O nome deve ter no máximo 200 caracteres!")
	@NotBlank(message = "O campo nome não pode estar vazio!")
	private String nome;

	@Size(max = 2000, message = "A descrição deve ter no máximo 2000 caracteres!")
	@NotBlank(message = "O campo descrição não pode estar vazio!")
	private String descricao;

	@NotNull(message = "O campo preço não pode estar vazio!")
	@Min(value = 1, message = "O campo preço não pode estar vazio!")
	private double preco;

	@NotNull(message = "O campo quantidade não pode estar vazio!")
	@Min(value = 1, message = "O campo preço não pode estar vazio!")
	private int quantidade;
	
	private String img;

	private boolean status;
	
	public Produto() {}

	public Produto(String nome, String descricao, double preco, int quantidade, boolean status, String img) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.quantidade = quantidade;
		this.status = status;
		this.img = img;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}
}