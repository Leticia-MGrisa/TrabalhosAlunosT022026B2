package exercicios;
class MaquinaRefrigerante
{
	int quantidadeEstoque;
	double preco;
	double dinheiroArrecadado;
public  MaquinaRefrigerante(int quantidadeEstoque)
{
	this.quantidadeEstoque = quantidadeEstoque;
	this.preco = 4.50;
	this.dinheiroArrecadado = 0.0;
}
	public void comprar(int quantidade, double valorPago) {
		if (quantidade<=0)
		{
			System.out.println("Quantidade inválida");
			return;
		}
		else if (quantidade>quantidadeEstoque)
		{
			System.out.println("Não há estoque para a compra!");
			return;
		}
		double total = quantidade * preco;
		if (valorPago < total)
		{
			System.out.println("Dinheiro insuficiente!");
			System.out.println("Valor necessário: " + total);
		}
		quantidadeEstoque -= quantidade;
		dinheiroArrecadado += total;
		double troco = valorPago - total;
		System.out.println("Compra realizada com sucesso!");
		System.out.println("Valor total: " + total);
		System.out.println("Troco: " + troco);
	}
	public void reporEstoque(int quantidade)
	{
		if (quantidade <=0)
		{
			System.out.println("Quantidade insuficiente!");
			return;
		}
		else
		{
			quantidadeEstoque += quantidade;
			System.out.println("Estoque reabastecido");
		}
	}
	public void exibirResultado()
	{
		System.out.println("Quantidade de refrigerante: " + quantidadeEstoque);
		System.out.println("Valor do refrigerante: " + preco);
		System.out.println("Dinheiro arrecadado: " + dinheiroArrecadado);
	}
}
public class ex22 {
	public static void main (String[]args) {
		MaquinaRefrigerante maquina = new MaquinaRefrigerante(10);
		System.out.println("Primeira compra:");
		maquina.comprar(2,10.00);
		System.out.println("Segunda compra: ");
		maquina.comprar(4, 8.00);
		maquina.exibirResultado();
	}
}
