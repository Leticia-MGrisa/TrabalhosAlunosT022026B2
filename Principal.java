
package fag;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import fag.obejtos.Livro;
import fag.obejtos.Pessoa;

public class Principal {

    static Scanner scan = new Scanner(System.in);
    static List<Livro> listaLivros = new ArrayList<Livro>();
    static List<Pessoa> listaUsuarios = new ArrayList<Pessoa>();

    public static void main(String[] args) {
        popularTabela();

        System.out.println("Sistema da biblioteca iniciado!");
        mostrarMenu();
    }

    private static void popularTabela() {
        listaUsuarios.add(new Pessoa("Ana"));
        listaUsuarios.add(new Pessoa("Pedro"));
        listaUsuarios.add(new Pessoa("Maria"));

        listaLivros.add(new Livro("Dom Casmurro", "Machado de Assis", "Romance"));
        listaLivros.add(new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", "Infantil"));
        listaLivros.add(new Livro("Harry Potter", "J. K. Rowling", "Fantasia"));
        listaLivros.add(new Livro("O Hobbit", "J. R. R. Tolkien", "Fantasia"));
        listaLivros.add(new Livro("It: A Coisa", "Stephen King", "Terror"));
    }

    public static void mostrarMenu() {
        int escolhaUsuario;

        do {
            System.out.println("\n------ BIBLIOTECA ------");
            System.out.println("1 - Listar livros");
            System.out.println("2 - Cadastrar livro");
            System.out.println("3 - Excluir livro");
            System.out.println("4 - Emprestar livro");
            System.out.println("5 - Devolver livro");
            System.out.println("6 - Cadastrar usuário");
            System.out.println("7 - Listar usuários");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            escolhaUsuario = scan.nextInt();
            scan.nextLine();

            validarEscolha(escolhaUsuario);

        } while (escolhaUsuario != 0);
    }

    public static void validarEscolha(int escolhaUsuario) {
        switch (escolhaUsuario) {
            case 0:
                System.out.println("Sistema encerrado!");
                break;
            case 1:
                listarLivros();
                break;
            case 2:
                cadastrarLivro();
                break;
            case 3:
                excluirLivro();
                break;
            case 4:
                emprestarLivro();
                break;
            case 5:
                devolverLivro();
                break;
            case 6:
                cadastrarUsuario();
                break;
            case 7:
                listarUsuarios();
                break;
            default:
                System.out.println("Digite uma opção válida!");
        }
    }

    private static void listarLivros() {
        System.out.println("\n------ LIVROS ------");

        if (listaLivros.isEmpty()) {
            System.out.println("Não existem livros cadastrados.");
            return;
        }

        for (int i = 0; i < listaLivros.size(); i++) {
            Livro livro = listaLivros.get(i);

            System.out.printf("%d) %s - %s - %s%n",
                    i + 1,
                    livro.getTitulo(),
                    livro.getAutor(),
                    livro.validarDisponibilidade());
        }
    }

    private static void cadastrarLivro() {
        System.out.print("Título do livro: ");
        String titulo = scan.nextLine();

        System.out.print("Autor: ");
        String autor = scan.nextLine();

        System.out.print("Gênero: ");
        String genero = scan.nextLine();

        listaLivros.add(new Livro(titulo, autor, genero));

        System.out.println("Livro cadastrado com sucesso!");
    }

    private static void excluirLivro() {
        listarLivros();

        if (listaLivros.isEmpty()) {
            return;
        }

        System.out.print("Número do livro que deseja excluir: ");
        int escolha = scan.nextInt() - 1;
        scan.nextLine();

        if (escolha < 0 || escolha >= listaLivros.size()) {
            System.out.println("Número inválido!");
            return;
        }

        Livro livro = listaLivros.get(escolha);

        if (livro.getDataEmprestimo() != null) {
            System.out.println("O livro está emprestado e não pode ser excluído!");
            return;
        }

        listaLivros.remove(escolha);
        System.out.println("Livro excluído com sucesso!");
    }

    private static void emprestarLivro() {
        if (listaUsuarios.isEmpty() || listaLivros.isEmpty()) {
            System.out.println("Cadastre pelo menos um usuário e um livro.");
            return;
        }

        listarUsuarios();

        System.out.print("Número do usuário: ");
        int usuario = scan.nextInt() - 1;
        scan.nextLine();

        if (usuario < 0 || usuario >= listaUsuarios.size()) {
            System.out.println("Usuário inválido!");
            return;
        }

        if (listaUsuarios.get(usuario).getLivrosEmprestados().size() >= 3) {
            System.out.println("O usuário já atingiu o limite de 3 livros.");
            return;
        }

        listarLivros();

        System.out.print("Número do livro que deseja emprestar: ");
        int livro = scan.nextInt() - 1;
        scan.nextLine();

        if (livro < 0 || livro >= listaLivros.size()) {
            System.out.println("Livro inválido!");
            return;
        }

        Livro livroEscolhido = listaLivros.get(livro);

        if (livroEscolhido.getDataEmprestimo() != null) {
            System.out.println("Este livro já está emprestado!");
            return;
        }

        listaUsuarios.get(usuario).getLivrosEmprestados().add(livroEscolhido);
        livroEscolhido.setDataEmprestimo(new Date());

        System.out.println("Livro emprestado com sucesso!");
    }

    private static void devolverLivro() {
        if (listaUsuarios.isEmpty()) {
            System.out.println("Não existem usuários cadastrados.");
            return;
        }

        listarUsuarios();

        System.out.print("Número do usuário: ");
        int usuario = scan.nextInt() - 1;
        scan.nextLine();

        if (usuario < 0 || usuario >= listaUsuarios.size()) {
            System.out.println("Usuário inválido!");
            return;
        }

        Pessoa pessoa = listaUsuarios.get(usuario);

        if (pessoa.getLivrosEmprestados().isEmpty()) {
            System.out.println("Este usuário não possui livros emprestados!");
            return;
        }

        System.out.println("\nLivros emprestados por " + pessoa.getNome() + ":");

        for (int i = 0; i < pessoa.getLivrosEmprestados().size(); i++) {
            System.out.printf("%d) %s%n",
                    i + 1,
                    pessoa.getLivrosEmprestados().get(i).getTitulo());
        }

        System.out.print("Número do livro que deseja devolver: ");
        int livro = scan.nextInt() - 1;
        scan.nextLine();

        if (livro < 0 || livro >= pessoa.getLivrosEmprestados().size()) {
            System.out.println("Número de livro inválido!");
            return;
        }

        Livro livroDevolvido = pessoa.getLivrosEmprestados().remove(livro);
        livroDevolvido.setDataEmprestimo(null);

        System.out.println("Livro devolvido com sucesso!");
    }

    private static void cadastrarUsuario() {
        System.out.print("Nome do usuário: ");
        String nome = scan.nextLine();

        if (nome.trim().isEmpty()) {
            System.out.println("O nome não pode ficar vazio!");
            return;
        }

        listaUsuarios.add(new Pessoa(nome));
        System.out.println("Usuário cadastrado com sucesso!");
    }

    private static void listarUsuarios() {
        System.out.println("\n------ USUÁRIOS ------");

        if (listaUsuarios.isEmpty()) {
            System.out.println("Não existem usuários cadastrados.");
            return;
        }

        for (int i = 0; i < listaUsuarios.size(); i++) {
            Pessoa pessoa = listaUsuarios.get(i);

            System.out.printf("%d) %s%n", i + 1, pessoa.getNome());

            if (!pessoa.getLivrosEmprestados().isEmpty()) {
                for (Livro livro : pessoa.getLivrosEmprestados()) {
                    System.out.println("   - " + livro.getTitulo());
                }
            } else {
                System.out.println("   Nenhum livro emprestado.");
            }
        }
    }
}
