package fag4.objetos;

public class Produtos {
	private int id;
	private String nome;
	private double preco;

public Produtos() {
}
public Produtos(int id, String nome, double preco) {
	setId(id);
	setNome(nome);
	setPreco(preco);
}
public int getId() {
	return id;
}
public void setId(int id){
	if (id < 1) {
		System.out.println("ID inválido");
		return;
	}
	this.id = id;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	if (nome.isBlank()) {
		System.out.println("Nome inválido");
		return;
	}
	this.nome = nome;
}
public double getPreco() {
	return preco;
}
public void setPreco(double preco) {
	if (preco < 0) {
		System.out.println("Preço inválido");
		return;
	}
	this.preco = preco;
}
public void mostrarDados() {
	System.out.printf("ID: %d | Nome: %s | Preço: %.2f%n",getId(),getNome(),getPreco());
}
}
