package eccomerce.spring.admin.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProdutoImagens {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String url;
	
	private long produtoId;

	public ProdutoImagens() {}
	
	public ProdutoImagens(String url, long produtoId) {
		this.url = url;
		this.produtoId = produtoId;
	}

	public Long getImagemId() {
		return id;
	}

	public void setImagemId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(long produtoId) {
		this.produtoId = produtoId;
	}
}