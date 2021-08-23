package futebolistas;

public class Tecnico {
	int id_tecnico, idade;
	String nome, licenca;
	
	public Tecnico(int id_tecnico, String nome, int idade, String licenca) {
		super();
		this.id_tecnico = id_tecnico;
		this.idade = idade;
		this.nome = nome;
		this.licenca = licenca;
	}

	public int getId_tecnico() {
		return id_tecnico;
	}

	public void setId_tecnico(int id_tecnico) {
		this.id_tecnico = id_tecnico;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLicenca() {
		return licenca;
	}

	public void setLicenca(String licenca) {
		this.licenca = licenca;
	}
}
