package aplication;



import control.Controle_jogador;
import model.Jogador;

import java.util.Scanner;


public class Main2 {
	
	public static void Menu() {
		System.out.println("Digite uma opção:\n"
						+ "1 = adicionar jogador (Nome/Idade/Posicao/Pe Dominante) \n"
						+ "2 = remover jogador(Id Jogador)\n"
						+ "3 = alterar jogador (Nome/Idade/Posicao/Pe Dominante) \n"
						+ "4 = buscar jogador(Id Jogador)\n"
						+ "5 = mostrar jogadores\n"
						+ "0 = Para sair do programa \n");
	}

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		Controle_jogador con_jog = new Controle_jogador();
		String opx = "comecar"; 
		String op;
		
		Menu();
		
		while(opx != "sair") {
			opx = ler.next();
			switch(opx) {
			case "1":
				ler.nextLine();
				System.out.println("Digite o nome do jogador: ");
				String nome = ler.nextLine();
				System.out.println("Digite o idade: ");
				Integer idade = ler.nextInt();
				System.out.println("Digite a posicao: ");
				String posicao = ler.next().trim();
				System.out.println("Digite o pe dominante: ");
				String pe = ler.next().trim();
				
				Jogador jog = new Jogador(null, nome, idade, posicao, pe);
				
				if(con_jog.inserir(jog)) {
					System.out.println("Comando executado com sucesso!");
				}else {
					System.out.println("Erro!");
				}
			break;
			case "2":
				System.out.println("\n->Excluir jogador: \n");
				ler.nextLine();
				System.out.println("Digite o id do jogador: ");
				Integer id = ler.nextInt();
				
				Jogador jog2 = new Jogador(id, null, null, null, null);
				
				if(con_jog.excluir(jog2)) {
					System.out.println("Comando executado com sucesso!");
				}else {
					System.out.println("Erro!");
				}
				break;
			case "3":
				System.out.println("\n->Alterar jogador: \n");
				ler.nextLine();
				System.out.println("Digite o id do jogador: ");
				id = ler.nextInt();
				System.out.println("Digite o nome do jogador: ");
				nome = ler.nextLine();
				System.out.println("Digite o idade: ");
				idade = ler.nextInt();
				System.out.println("Digite a posicao: ");
				posicao = ler.next().trim();
				System.out.println("Digite o pe dominante: ");
				pe = ler.next().trim();
				
				Jogador jog3 = new Jogador(id, nome, idade, posicao, pe);
				
				if(con_jog.alterar(jog3)) {
					System.out.println("Comando executado com sucesso!");
				}else {
					System.out.println("Erro!");
				}
				break;
			case "4":
				System.out.println("\n->Buscar por id: \n");
				ler.nextLine();
				System.out.println("Digite o id do jogador: ");
				id = ler.nextInt();
				
				Jogador jog4 = con_jog.obterPorId(id);
				
				System.out.println("\nResultado: " + jog4);
				break;		
			case "5":
				System.out.println("\n->Mostrar todos: \n");
				
				for(Jogador jog5 : con_jog.obterTodos()){
					System.out.println(jog5);
				}
				break;		
			case "0":
				System.out.println("Parando programa"); 
				op = "sair";
				break;
			}
		}
	}
}
