package exercicios;
class Pedido
{
	String nomeCliente;
	int quantidadeLanches;
	double precoLanche;
	double taxaEntrega;
	String status;
public Pedido (String nomeCliente)
{
	this.nomeCliente = nomeCliente;
	this.quantidadeLanches = 0;
	this.precoLanche = 18.0;
	this.taxaEntrega = 7.0;
	this.status = "Aberto";
}
public void adicionarLanches(int quantidade)
{
	if (status.equals("Finalizado"))
	{
		System.out.println("O pedido já foi finalizado!");
	}
	else if (quantidade<=0)
	{
		System.out.println("Não é possível adicionar essa quantidade");
	}
	else
	{
		quantidadeLanches += quantidade;
		System.out.println("Lanche adicionado!");
	}
}
public double calcularTotal()
{
	double subtotal = quantidadeLanches * precoLanche;
	if (quantidadeLanches >= 3)
	{
		subtotal = subtotal - (subtotal * 0.10);
	}
	return subtotal + taxaEntrega;
}
public void finalizarPedido()
{
	status = "Finalizado";
	System.out.println("Pedido finalizado com sucesso!");
}
public void exibirPedido()
{
	System.out.println("Resumo do pedido: ");
	System.out.println("Cliente: " + nomeCliente);
	System.out.println("Quantidade de lanches: " + quantidadeLanches);
	System.out.println("Status: " + status);
	System.out.println("Total: " + calcularTotal());
}
}
public class ex25 {
	public static void main(String[]args) {
		Pedido pedido = new Pedido("João");
		pedido.adicionarLanches(2);
		pedido.adicionarLanches(3);
		pedido.exibirPedido();
		pedido.finalizarPedido();
		pedido.adicionarLanches(1);
		pedido.exibirPedido();
	}
}
