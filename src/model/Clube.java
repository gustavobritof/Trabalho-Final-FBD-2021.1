package model;

public class Clube {
	int id_clube;
	String nome, localizacao;
	
	public Clube(int id_clube, String nome, String localizacao) {
		super();
		this.id_clube = id_clube;
		this.nome = nome;
		this.localizacao = localizacao;
	}

	public int getId_clube() {
		return id_clube;
	}

	public void setId_clube(int id_clube) {
		this.id_clube = id_clube;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
}
