package aplication;

import control.Controle_jogador;
import model.Jogador;

public class Main {

	public static void main(String[] args) {
		Controle_jogador con_jog = new Controle_jogador();
		
		Jogador jog = new Jogador(null, "Jean", 13, "MDD", "A");
		
		if(con_jog.inserir(jog)) {
			System.out.println("Comando executado com sucesso!");
		}else {
			System.out.println("Erro!");
		}
		
		for(Jogador jog8 : con_jog.obterTodos()){
			System.out.println(jog8);
		}
		
		//Jogador jog9 = con_jog.obterPorId(9);
		
		//System.out.println("\nResultado: " + jog9);

	}
}
