package futebolistas;

public class Jogador {
	Integer id_jogador, idade;
	String nome, posicao, pe_dominante;
	
	public Jogador() {
	}
	
	public Jogador(Integer id_jogador, String nome, Integer idade, String posicao, String pe_dominante){
		this.id_jogador = id_jogador;
		this.nome = nome;
		this.idade = idade;
		this.posicao = posicao;
		this.pe_dominante = pe_dominante;
	}

	public int getId_jogador() {
		return id_jogador;
	}

	public void setId_jogador(Integer id_jogador) {
		this.id_jogador = id_jogador;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public String getPe_dominante() {
		return pe_dominante;
	}

	public void setPe_dominante(String pe_dominante) {
		this.pe_dominante = pe_dominante;
	}

	@Override
	public String toString() {
		return id_jogador + " - " + idade + " - " + nome + " - " + posicao
				+ " - " + pe_dominante;
	}
	
	
}
