package fag;
import java.util.Scanner;
import fag.obejtos.Jogo;
import fag.obejtos.GerenciadorJogos;
public class Principal {
	static Scanner scan = new Scanner(System.in);
	static GerenciadorJogos gerenciador = new GerenciadorJogos();
	public static void main(String[]args) {
		System.out.println("Sistema de jogos iniciado!");
		MostrarMenu();
	}
	public static void MostrarMenu() {
		int escolhaUsuario;
		do {
			System.out.println("Sistema de jogos: ");
			System.out.println("1- Cadastrar jogo");
			System.out.println("2- Listar jogos");
			System.out.println("3- Buscar jogo por ID");
			System.out.println("4- Atualizar jogo");
			System.out.println("5- Excluir jogo");
			System.out.println("0- Sair");
			System.out.println("Escolha: ");
			escolhaUsuario = scan.nextInt();
			scan.nextLine();
			validarEscolha(escolhaUsuario);
		} while (escolhaUsuario != 0);
	}
public static void validarEscolha(int escolhaUsuario) {
	switch (escolhaUsuario) {
	case 0:
		System.out.println("Sistema encerrado");
		break;
	case 1:
		CadastrarJogo();
		break;
	case 2:
		gerenciador.ListarJogos();
		break;
	case 3:
		BuscarJogos();
		break;
	case 4:
		AtualizarJogo();
		break;
	case 5:
		ExcluirJogo();
		break;
	default:
	System.out.println("Digite uma opção válida");
	}
}
private static void CadastrarJogo() {
	System.out.println("Cadastrar jogo:");
	System.out.println("Nome do jogo: ");
	String nome = scan.nextLine();
	System.out.println("Gênero: ");
	String genero = scan.nextLine();
	gerenciador.CadastrarJogo(nome, genero);
}
private static void BuscarJogos() {
	System.out.println("Buscar jogos: ");
	System.out.println("Digite o ID do jogo: ");
	int id = scan.nextInt();
	scan.nextLine();
	Jogo jogo = gerenciador.BuscarJogos(id);
	if (jogo == null) {
		System.out.println("Jogo não encontrado");
	}
	else {
		System.out.println("ID: " + jogo.getId());
		System.out.println("Nome: " + jogo.getNome());
		System.out.println("Gênero: " + jogo.getGenero());
	}
}
private static void AtualizarJogo() {
	System.out.println("Atualizar jogo: ");
	System.out.println("Digite o ID do jogo: ");
	int id = scan.nextInt();
	scan.nextLine();
	Jogo jogo = gerenciador.BuscarJogos(id);
	if (jogo == null) {
		System.out.println("Jogo não encontrado");
		return;
	}
	System.out.println("Digite o novo nome: ");
	String nome = scan.nextLine();
	System.out.println("Digite o novo genero: ");
	String genero = scan.nextLine();
	gerenciador.AtualizarJogo(id, nome, genero);
	}
private static void ExcluirJogo() {
	System.out.println("Excluir jogo: ");
	System.out.println("Digite o ID do jogo: ");
	int id = scan.nextInt();
	scan.nextLine();
	gerenciador.ExcluirJogo(id);
}
}
