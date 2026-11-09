package fag4;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import fag4.objetos.Produtos;
public class Principal {
	static Scanner scan = new Scanner(System.in);
	static List<Produtos> estoque = new ArrayList<Produtos>();
	static int proxId = 1;
	public static void main(String[] args) {
		mostrarMenu();
	}
	private static void mostrarMenu() {
	int escolha = 1;
	do {
		System.out.println("Menu:");
		System.out.println("1 - Cadastrar produto");
		System.out.println("2 - Listar produto");
		System.out.println("3 - Buscar produto pelo ID");
		System.out.println("4 - Alterar produto");
		System.out.println("5 - Deletar produto");
		System.out.println("0 - Sair");
		escolha = scan.nextInt();
		scan.nextLine();
		validarEscolha(escolha);
	}while (escolha != 0);	
	}
	private static void validarEscolha(int escolha) {
		if (escolha == 1) {
			cadastrarProduto();
			return;
		}
		if (escolha == 2) {
			listarProduto();
			return;
		}
		if (escolha == 3) {
			buscarProduto();
			return;
		}
		if (escolha == 4) {
			alterarProduto();
			return;
		}
		if (escolha == 5) {
			deletarProduto();
			return;
		}
		if (escolha == 0) {
			System.out.println("Menu encerrado");
			return;
		}
	}
	private static void deletarProduto() {
		if (estoque.isEmpty()) {
			System.out.println("Não foi possível deletar o produto");
			return;
		}
		System.out.println("Digite o ID do produto que deseja deletar: ");
		int id = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < estoque.size(); i++) {
			if (estoque.get(i).getId()==id) {
				estoque.remove(i);
				System.out.println("Produto removido");
				return;
			}
		}
		System.out.println("Produto não encontrado");
	}
	private static void alterarProduto() {
		if (estoque.isEmpty()) {
			System.out.println("Não foi possível alterar o produto");
			return;
		}
		System.out.println("Digite o ID do produto que deseja alterar: ");
		int id = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i< estoque.size(); i++) {
			if (estoque.get(i).getId() == id) {
				Produtos produtos = estoque.get(i);
				System.out.println("Digite o novo nome: ");
				produtos.setNome(scan.nextLine());
				System.out.println("Digite o novo valor: ");
				produtos.setPreco(scan.nextDouble());
				scan.nextLine();
				System.out.println("Produto alterado");
				return;
			}
		}
		System.out.println("Produto não encontrado");
	}
	private static void buscarProduto() {
		if (estoque.isEmpty()) {
			System.out.println("Não foi possível buscar o produto");
			return;
		}
		System.out.println("Digite o ID do produto que você deseja buscar: ");
		int id = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < estoque.size(); i++) {
			if (estoque.get(i).getId() == id) {
				estoque.get(i).mostrarDados();
			}
		}
	}
	private static void listarProduto() {
		if(estoque.isEmpty()) {
			System.out.println("Não há nada na lista");
			return;
		}
		for (int i = 0; i< estoque.size(); i++) {
			estoque.get(i).mostrarDados();
		}
	}
	private static void cadastrarProduto() {
		Produtos produtos = new Produtos();
		System.out.println("Digite o nome do produto: ");
		produtos.setNome(scan.nextLine());
		System.out.println("Digite o preço do produto: ");
		produtos.setPreco(scan.nextDouble());
		if (produtos.getNome().isBlank() || produtos.getPreco()<0) {
			System.out.println("Dados inválidos");
			return;
		}
		produtos.setId(proxId);
		proxId++;
		estoque.add(produtos);
	}
}
