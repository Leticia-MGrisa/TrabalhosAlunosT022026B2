package exercicios;
class Estacionamento
{
	String placa;
	String modelo;
	int minutosEstacionado;
	double valorPago;
	public Estacionamento (String placa, String modelo)
	{
		this.placa = placa;
		this.modelo = modelo;
		this.minutosEstacionado = 0;
		this.valorPago = 0;
	}
	public void adicionarTempo (int minutos)
	{
		if (minutos<=0)
		{
			System.out.println("O tempo não é o suficiente!");
		}
		else 
		{
			minutosEstacionado += minutos;
		}
	}
	public void calcularValor()
	{
		if(minutosEstacionado<0)
		{
			System.out.println("Esse valor não é possível!");
		}
		if (minutosEstacionado>0 && minutosEstacionado<=30)
		{
			valorPago = 5.0;
		}
		else
		{
			valorPago = 5.0 + (minutosEstacionado - 30) * 0.10;
		}
		if (valorPago > 30.0)
		{
			valorPago = 30.0;
		}
	}
	public void exibirResumo()
	{
		System.out.println("Modelo: " + modelo);
		System.out.println("Placa: " + placa);
		System.out.println("Tempo estacionado: " + minutosEstacionado + " minutos");
		System.out.println("Valor pago: " + valorPago);
	}
}

public class Ex6 {
	public static void main(String[]args) {
		Estacionamento estacionamento = new Estacionamento("BBT-1235","hb20");
		estacionamento.adicionarTempo(60);
		estacionamento.calcularValor();
		estacionamento.exibirResumo();
	}
}
