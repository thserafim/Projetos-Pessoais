package calculadora;

import java.util.Scanner;

public class Calculadora {
	public static void main (String args []) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite o primeiro numero: ");
		double num1 = input.nextDouble();
		System.out.println("Digite o sinal da operacao: ");
		char sinal = input.next().charAt(0);  //CHARAT CAPTURA UM CARACTER E O ZERO É O INDICE 
		System.out.println("Digite o segundo numero: ");
		double num2 = input.nextDouble();
		
		switch (sinal) {
		case '+':
			System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
			break;
			
		case '-':
			System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
			break;
			
		case '/':
			System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
			break;
		
		case '*':
			System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
			break;
		default:
			System.out.println("Operacao invalida");
			break;
			
		}
		input.close();
	} 

}
