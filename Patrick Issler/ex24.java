package exercicios;
class Cofrinho
{
	String dono;
	double saldo;
	double metaEconomia;
	public Cofrinho(String dono, double metaEconomia)
	{
		this.dono = dono;
		this.saldo = 0.0;
		this.metaEconomia = metaEconomia;
	}
	public void depositar(double valor)
	{
		if (valor>0)
		{
			saldo += valor;
			System.out.println("O depósito de " + valor + " foi realizado");
		}
		else
		{
			System.out.println("Não foi possível realizar o depósito nesse valor");
		}
	}
	public void retirar(double valor)
	{
		if (valor<=0)
		{
			System.out.println("Não é possível realizar saque de valores negativos!");
		}
		else if (valor<=saldo)
		{
			saldo -= valor;
			System.out.println("Depósito realizado!");
		}
		else
		{
			System.out.println("Não foi possível realizar o saque!");
		}
	}
	public void verificarMeta()
	{
		if (saldo>=metaEconomia)
		{
			System.out.println("Meta atingida!");
		}
		else
		{
			double falta = metaEconomia - saldo;
			System.out.println("Falta " + falta +" para atingir a meta");
		}
	}
	public void exibirSaldo()
	{
		System.out.println("Dono: " + dono);
		System.out.println("Saldo: " + saldo);
		System.out.println("Meta de economia: " + metaEconomia);
	}
}
public class ex24 {
	public static void main(String[]args)
	{
		Cofrinho cofrinho = new Cofrinho ("João", 650.00);
		cofrinho.depositar(500.00);
		cofrinho.retirar(200.00);
		cofrinho.exibirSaldo();
		cofrinho.verificarMeta();
	}
}
