package fag.obejtos;
import java.util.ArrayList;
import java.util.List;
public class GerenciadorJogos {
	private List <Jogo> listajogos;
	private int proximoId;
	public GerenciadorJogos() {
		listajogos = new ArrayList<Jogo>();
		proximoId = 1;
	}
	public void CadastrarJogo(String nome, String genero) {
		Jogo jogo = new Jogo(proximoId, nome, genero);
		listajogos.add(jogo);
		proximoId++;
		System.out.println("Jogo cadastrado com sucesso!");
	}
	public void ListarJogos() {
		if (listajogos.isEmpty()) {
			System.out.println("Não existem jogois cadastrados");
			return;
		}
		for (Jogo jogo : listajogos) {
			System.out.println("ID: " + jogo.getId());
			System.out.println("Nome: " + jogo.getNome());
			System.out.println("Gênero: " + jogo.getGenero());
		}
	}
	public Jogo BuscarJogos (int id) {
		for (Jogo jogo : listajogos) {
			if (jogo.getId()== id) {
				return jogo;
			}
		}
		return null;
	}
	public void AtualizarJogo(int id, String nome, String genero) {
		Jogo jogo = BuscarJogos(id);
		if (jogo == null) {
			System.out.println("Jogo não encontrado");
			return;
		}
		jogo.setNome(nome);
		jogo.setGenero(genero);
		System.out.println("Jogo atualizado com sucesso!");
	}
	public void ExcluirJogo(int id) {
		Jogo jogo = BuscarJogos(id);
		if (jogo == null) {
			System.out.println("Jogo não encontrado");
			return;
	}
		listajogos.remove(jogo);
		System.out.println("Jogo excluído com sucesso");
}
}