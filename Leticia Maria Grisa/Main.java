import java.util.Scanner;
public class Main {

	public static Scanner ler = new Scanner (System.in);

	public static void conferir(int idade){
		if(idade >= 18){
			System.out.println("Voce e maior de idade");

		} else if(idade>=0 && idade <=18){
			System.out.println("Voce e menor de idade");

		}
	}
	
	public static void main(String[] args){
		int idade;
		String nome;
		System.out.println("Qual seu nome?");
		nome = ler.nextLine();
		System.out.println("Qual a sua idade?");
		idade = ler.nextInt();
	
		conferir(idade);
		System.out.printf("Seu nome e %s, e voce tem %d anos\n", nome, idade);
	
	}

}