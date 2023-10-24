package gerenciaBanco;

public class Conta {
	
	private String nomeCliente;
	private String sobreNomeCliente;                               // ENCAPSULAMENTO
	private String cpfCliente;
	private double saldoConta;
	
	
	public Conta(String nomeCliente, String sobreNomeCliente, String cpfCliente) {

		this.nomeCliente = nomeCliente;
		this.sobreNomeCliente = sobreNomeCliente;                //CONSTRUTOR
		this.cpfCliente = cpfCliente;
		this.saldoConta = 0.0; 
		
	}
	
	public double consultarSaldo() {                              //METODOS
		return saldoConta;
	}
	
	public void depositar(double valor) {
		saldoConta = saldoConta + valor;
		System.out.println("Deposito de R$ " + valor + " realizado com sucesso!");
	
	}
	
	public void sacar(double valor) {
		if(valor <= saldoConta){
			saldoConta = saldoConta - valor;
			System.out.println("Saque de R$ " + valor + "realizado com sucesso!");
		}else {
			System.out.println("Saldo Insuficiente");
		}
	}
	
	public String getcpfCliente() {
		return cpfCliente;
	}
	
	public String getNomeCompleto() {
		return nomeCliente + " " + sobreNomeCliente;
	}
	

}
