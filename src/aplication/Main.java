package aplication;

import control.Controle_jogador;
import futebolistas.Jogador;

public class Main {

	public static void main(String[] args) {
		
		Controle_jogador con_jog = new Controle_jogador();
		//Inserir
		/*Jogador jog = new Jogador(null, "Ulisses", 16, "DEF", "D");
		
		if(con_jog.inserir(jog)) {
			System.out.println("Comando executado com sucesso!");
		}else {
			System.out.println("Erro!");
		}*/
		
		/*//Excluir
		Controle_jogador con_jog = new Controle_jogador();
		Jogador jog = new Jogador(6, null, null, null, null);
		
		if(con_jog.excluir(jog)) {
			System.out.println("Jogador excluido com sucesso!");
		}else {
			System.out.println("ERRO!");
		}*/
		
		//Alterar
		Jogador jog2 = new Jogador(5, "Gustavo", 18, "MD", "D");
		
		if(con_jog.alterar(jog2)) {
			System.out.println("Jogador alterado com sucesso!");
		}else {
			System.out.println("ERRO!");
		}
		
		
		for(Jogador jog4 : con_jog.obterTodos()){
			System.out.println(jog4);
		}
		
		Jogador jog1 = con_jog.obterPorId(2);
		
		System.out.println(jog1);
	}
}
