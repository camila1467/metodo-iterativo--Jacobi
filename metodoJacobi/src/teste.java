import java.io.IOException;
import java.util.Scanner;



	public class teste {

		

		public static void main(String[] args) throws IOException{

			Scanner entrada = new Scanner(System.in);
			System.out.println("\n** ATENÇÃO! VOCÊ DEVE FAZER O CRITÉRIO DE CONVERGÊNCIA ANTES DE UTILIZAR ESTE PROGRAMA, \n      POIS O PROGRAMA NÃO REALIZA ESTE CRITÉRIO! ** \n");
			System.out.print("\nInsira a Dimensão da Matriz: ");
			int dim = entrada.nextInt();
			double A[][] = new double[dim][dim];
			jacobi matriz = new jacobi(A);
			matriz.matrizdePreenchimento();
			System.out.println("\nExibindo os Valores da Matriz: ");
			matriz.imprimirMatriz();

			double b[] = new double[dim];
			System.out.println("\n Insira o Vetor b (coeficientes): ");
			matriz.preencherVetor(b);
			double erro;
			System.out.print("\nInsira o Critério de Parada: ");
			erro = entrada.nextDouble();

			System.out.println("\nAproximando a Solução do Sistema de Equações pelo Método de Jacobi ... ");
			System.out.println("\n O Vetor de Aproximação Inicial é [0, 0, 0]\n");
			matriz.jacobi(b, erro);
		}
	}