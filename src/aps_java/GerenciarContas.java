package aps_java;
/**
Classe gerenciarContas � re�ne todas as contas criadas

Atributos:

ArrayList de objetos da classe conta;
M�todos:

public void adicionarConta(Conta c);

public boolean removerConta(int numeroConta) � retorna true se conseguir encontrar e
remover a conta, false em caso contr�rio;

public String buscarContasEspeciais() � busca todas as contas especiais,

guardando os dados dessas contas em uma String e ent�o retornando o resultado da busca;

public String buscarClientesUsandoLimite() � busca todos os clientes de conta corrente que 
estejam utilizando o limite, guardando os dados dessas contas em uma String e ent�o 
retornando o resultado da busca;

public Conta buscarConta(int numeroConta) � busca uma conta pelo seu n�mero, e a 
retorna se encontrar. Caso a conta n�o exista, deve retornar null;

public boolean transferirValor(int numeroContaFonte, int numeroContaDestino, double valor)

public boolean sacar(int numeroConta, double valorSacado) � deve buscar a conta indicada
pelo n�mero e ent�o sacar o valor especificado, usando o m�todo de sacar da conta.
Se a conta n�o for encontrada, ou o valor n�o puder ser sacado, retorna false;

public boolean depositar(int numeroConta, double valorDepositado) � deve buscar a conta 
indicada e realizar o dep�sito. Caso n�o encontre o n�mero da conta, ou o dep�sito falhe,
retornar false;

public String listarContas() � retorna uma String com os dados de todas as contas;
 */

import java.util.ArrayList;

public class GerenciarContas {
private ArrayList<Conta> contas = new ArrayList<Conta>();

	//metodos:
	
	//adiciona uma conta � lista. 
	public void adicionarConta(Conta c) {
		contas.add(c);
	}
	
	public boolean removerConta(int numeroConta) {
		for(int i=0; i<contas.size();i++) {
			if(contas.get(i).getNumConta() == numeroConta) {
			contas.remove(i);
			return true;
			}
		}
		return false;
	}
	
	public String buscarContasEspeciais() {
		String string="";
		for(int i=0; i<contas.size();i++) {
			if(contas.get(i) instanceof ContaEspecial) {					
					string+= contas.get(i).getNumConta();//refatorar quando o metodo imprimir da classe ContaEspecial estiver pronto Deveria retornar todos os dados e nao so o numero da conta.
			}		
		}
		return string;
	}
	
	public String buscarClientesUsandoLimite() {
		return "Precisa refatorar";		//Atributo limite ainda nao foi implementado na classe ContaCorrente.
	}
	
	public Conta buscarConta(int numeroConta) {
		for(int i=0; i<contas.size();i++) {
			if(contas.get(i).getNumConta() == numeroConta) {			
			return contas.get(i);
			}
		}
		return null;	
	}
	
	public boolean transferirValor(int numeroContaFonte, int numeroContaDestino, double valor) {//� necessario checar o limite. Conta corrente ainda nao foi implementada. 
		Conta tempContaFonte = buscarConta(numeroContaFonte);
		Conta tempContaDestino = buscarConta(numeroContaDestino);
		if(tempContaFonte.getSaldo()>=valor && valor >0) { //nao � uma boa ideia fazer saques iguais a zero, o cliente pode perder dinheiro se houver taxa sobre saques. 
		return tempContaFonte.sacar(valor)&&tempContaDestino.depositar(valor)?true:false; //retorna verdadeiro se tanto o saque quanto o deposito ocorrerem e retornarem true.			
		}		
		return false;//retorna falso se nao houver saldo para saque na conta fonte. 
	}
	
	public boolean sacar(int numeroConta, double valorSacado) {//� necessario checar o limite.
		Conta tempConta = buscarConta(numeroConta);
		return tempConta.sacar(valorSacado);
	}
	public boolean depositar(int numeroConta, double valorDepositado) {
		Conta tempConta = buscarConta(numeroConta);
		return tempConta.depositar(valorDepositado);
	}
	public String listarContas() {
		return "";//refatorar
	}
}
