package br.com.db1.model;

public class CidadeJava {
	private Integer id;
	private UfJava uf_id;
	private String nome;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public UfJava getUf_id() {
		return uf_id;
	}
	
	public void setUf_id(UfJava uf_id) {
		this.uf_id = uf_id;
	}
}
