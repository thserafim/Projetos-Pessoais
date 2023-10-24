
package gerenciaBanco;

import java.util.Scanner;

import java.util.ArrayList;

public class Main {
	public static void main (String args []) {            // CLASSE PRINCIPAL
		Scanner input = new Scanner (System.in);
		ArrayList<Conta> contas = new ArrayList<>();
		
		
		do {
			System.out.println("---------------Bem vindo ao Banco Flamboyant---------------");
			System.out.println("Menu: ");
			System.out.println("1- Abrir conta");
			System.out.println("2 - Depositar");
			System.out.println("3 - Sacar");                        // MENU
			System.out.println("4 - Consultar saldo");
			System.out.println("5 - Listar contas");
			System.out.println("6 - Finalizar atndimento");
			
			int opcao = input.nextInt();
			
			switch(opcao) {
			case 1:
				System.out.println("Digite seu primeiro nome: ");
				String nomeCliente = input.next();
				System.out.println("Digite o Sobre nome: ");                               //ESTRUTURA DE REPETICAO
				String sobrenomeCliente = input.next();
				System.out.println("Digite seu CPF: ");
				String cpfCliente = input.next();
				contas.add(new Conta(nomeCliente, sobrenomeCliente, cpfCliente));
				System.out.println("CONTA CRIADA COM SUCESSO!\n O BANCO FLAMBOYANT AGRADECE PELA CONFIACA. ");
				break;
				
			case 2:
				System.out.println("Digite o CPF da conta: ");
				String cpfDeposito = input.next();
				for(Conta conta : contas) {
					if(conta.getcpfCliente().equals(cpfDeposito)) {
						System.out.println("Digite o valor do deposito: R$");
						double ValorDeposito = input.nextDouble();
						conta.depositar(ValorDeposito);
						break;
					}
				}
				break;
				
			case 3:
				System.out.println("Digite o CPF da conta: ");
				String cpfSaque = input.next();
				for(Conta conta : contas) {
					if(conta.getcpfCliente().equals(cpfSaque)) {
						System.out.print("Digite o valor do saque: R$");
						double valorSaque = input.nextDouble();
						conta.sacar(valorSaque);
						break;
					}
					
				}
				break;
			case 4:
				System.out.println("Digite o CPF da conta: ");
				String cpfConsulta = input.next();
				for(Conta conta : contas) {
					if(conta.getcpfCliente().equals(cpfConsulta)) {
						double saldo = conta.consultarSaldo();
						System.out.println("Saldo atual: R$" + saldo);
						break;
			}
			
		}
		break;
		
			case 5:
				System.out.println("Lista de contas: ");
				for(Conta conta : contas) {
					System.out.println("Nome: " + conta.getNomeCompleto() + ", CPF: " + conta.getcpfCliente());
				}
				break;
				
			case 6:
				System.out.println("Atendimento Finalizado. \n Obrigado por utilizar o Banco Flamboyant! ");
				input.close();
				System.exit(0);
				break;
			
			default:
				System.out.println("Opccao invalida. Tente novamente ");   //TRATAMENTO DE ERROS COM OPCOES INVALIDAS			
				
	}                       
	
  }while(true);
 }
}