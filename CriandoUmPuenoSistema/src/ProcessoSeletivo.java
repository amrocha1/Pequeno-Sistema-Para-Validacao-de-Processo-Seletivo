
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class ProcessoSeletivo {
	public static void main(String[] args) {
		String [] candidatos = {"Felipe","Marcia","Julia","Paulo","Augusto"};
		for(String candidato: candidatos){
			entrandoEmContato(candidato);
		}
		//selecaoCandidatos();
		//ImprimirSelecionados();
		/*analisarCandidato(1900.0);
		analisarCandidato(2200.0);
		analisarCandidato(2000.0);*/
	}
	static void entrandoEmContato (String candidato){
		int tentativasRealizadas = 1;
		boolean continuarTentando = true;
		boolean atendeu=false;
		do{
			atendeu= atender();
			continuarTentando =!atendeu;
			if(continuarTentando)
				tentativasRealizadas++;
			else
			System.out.println("Contato Realizado Com Sucesso");

		}while(continuarTentando && tentativasRealizadas<3);

		if(atendeu)
		System.out.println("Conseguimos Contato Com "+ candidato + " Na " + tentativasRealizadas + " Tentantiva");
		else
		System.out.println("Não Conseguimos Contato Com " + candidato + ", Número Maximo de Tentativas " + tentativasRealizadas + " Realizadas");

	}
	static boolean atender(){
		return new Random().nextInt(3)==1;
	}

	static void ImprimirSelecionados(){
		String [] candidatos = {"Felipe","Marcia","Julia","Paulo","Augusto"};
		System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");

		for(int indice=0; indice < candidatos.length;indice++){
			System.out.println("O Candito n "+ (indice+1) + " é o " + candidatos[indice]);
		}
		System.out.println("Forma abrevida de interação for each");
		for(String candidato: candidatos){
			System.out.println("O Candidato Selecionado foi " + candidato);
		}
		
		
	}

	static void selecaoCandidatos(){
		String [] candidatos = {"Felipe","Marcia","Julia","Paulo","Augusto", "Monica", "Fabricio","Mirela", "Daniela", "Jorge"};
		int candidatosSelecionados = 0;
		int candidatoAtual=0;
		double salarioBase=2000.0;
		while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
			String candidato = candidatos[candidatoAtual];
			double salarioPretendido = valorPretendido();
			System.out.println("O candidato "+ candidato + " Solicitou este valor de salario" + salarioPretendido);
			if(salarioBase > salarioPretendido){
				System.out.println("O candidato "+ candidato + " foi selecionado para a vaga");
				candidatosSelecionados++;
			}
			candidatoAtual++;
		}
	}	
	static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800, 2200);
	}
	
	static void analisarCandidato(double salarioPretendido){
		double salarioBase = 2000.0;
		if(salarioBase > salarioPretendido){
			System.out.println("LIGAR PARA CANDIDATO");
	}else if(salarioBase==salarioPretendido) 
		System.out.println("LIGAR PARA CANDIDATO COM CONTRA PROPOSTA");
	else{
		System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
	}
	}

}

