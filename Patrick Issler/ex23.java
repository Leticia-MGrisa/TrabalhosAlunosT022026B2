package exercicios;
class Time
{
	String nome;
	int vitorias;
	int empates;
	int derrotas;
	int pontos;
	public  Time (String nome)
	{
		this.nome = nome;
		this.vitorias = 0;
		this.empates = 0;
		this.derrotas = 0;
		this.pontos = 0;
	}
	public void registrarVitoria()
	{
		vitorias++;
		pontos += 3;
	}
	public void registrarEmpate()
	{
		empates++;
		pontos += 1;
	}
	public void registrarDerrota()
	{
		derrotas++;
	}
	public void exibirEstatisticas()
	{
		System.out.println(" " + nome);
		System.out.println("Vitórias: " + vitorias);
		System.out.println("Derrotas: " + derrotas);
		System.out.println("Empates: " + empates);
		System.out.println("Pontos totais: " + pontos);
	}
}
public class ex23 {
	public static void main(String[]args) {
		Time time1 = new Time ("Flamengo");
		Time time2 = new Time ("Corinthians");
		time1.registrarVitoria();
		time1.registrarDerrota();
		time2.registrarVitoria();
		time2.registrarDerrota();
		time2.registrarEmpate();
		time1.exibirEstatisticas();
		time2.exibirEstatisticas();
		System.out.println("Classificação:");
		if (time1.pontos>time2.pontos)
		{
			System.out.println("O time 1 foi o campeão!");
		}
		else if (time2.pontos>time1.pontos)
		{
			System.out.println("O time 2 foi o campeão!");
		}
		else
		{
			System.out.println("Hove empate!");
		}
	}
}
