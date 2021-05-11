import java.util.Scanner;

public class teste {

	

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		System.out.print("\nInsira  dimensão da matriz: ");
		int dim = entrada.nextInt();
		double A[][] = new double[dim][dim];
		jacobi matrix = new jacobi(A);
		matrix.matrizdePreenchimento();
		System.out.println("\ninsira o vetor de a: ");
		matrix.imprimirMatriz();

		double b[] = new double[dim];
		System.out.println("\n Insira o vetor b: ");
		matrix.preencherVetor(b);
		double epsilon;
		System.out.print("\nInsira os critérios de parada: ");
		epsilon = entrada.nextDouble();

		System.out.println("\nAproximando a solução do sistema de equações pelo método de Jacobi ... ");
		matrix.jacobi(b, epsilon);
	}
}