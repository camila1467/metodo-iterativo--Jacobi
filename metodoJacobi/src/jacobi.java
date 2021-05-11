


import java.util.Arrays;
import java.util.Scanner;

public class jacobi {

	int filas;
	int colunas;
	double matriz[][];

	public jacobi(double m[][]) {
		this.matriz = m;

		this.filas = m.length;
		this.colunas = m[0].length;
	}

	// metodos set e getter
	public void setFilas(int filas) {
		this.filas = filas;
	}

	public void setColunas(int colunas) {
		this.colunas = colunas;
	}

	public int getFilas() {
		return this.filas;
	}

	public int getColunas() {
		return this.colunas;
	}

	// imprimi os valores da matriz inicial
	public void imprimirMatriz() {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] >= 0) {
					System.out.printf("\t%s%.2f", " ", matriz[i][j]);
				} else {
					System.out.printf("\t%.2f", matriz[i][j]);
				}

			}
			System.out.println("");
		}
		System.out.println("");
		System.out.println("");
	}

	// metodo que vai preencher a matriz de A
	public void matrizdePreenchimento() {
		Scanner entrada = new Scanner(System.in);
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print("Insira um Elemento [" + (i + 1) + "," + (j + 1) + "]: ");
				matriz[i][j] = entrada.nextInt();
			}
		}

		System.out.println("");
	}

	// le o vetor de b
	public void preencherVetor(double v[]) {
		Scanner entrada = new Scanner(System.in);
		for (int i = 0; i < v.length; i++) {
			System.out.print("Insira um Elemento [" + (i + 1) + "]: ");
			v[i] = entrada.nextDouble();
		}
		System.out.println("");
	}
   // substrai os valores de dentro do modulo 
	public double[] restaVetores(double v1[], double v2[]) {
		double resto[] = new double[v1.length];
		for (int i = 0; i < resto.length; i++) {
			resto[i] = v1[i] - v2[i];// aqui ele pega a interacao Xn¹ e subtrai pela Xn° 
		}
		return resto;
	}
   //Faz o modulo do criterio de parada
	public double regraVetor(double v[]) {
		double regra = 0.0;
		double soma = 0.0;

		for (int i = 0; i < v.length; i++) {
			soma += Math.pow(v[i], 2); //ele retorna a base elevada ao expoente e soma a cada passada

		}

		regra = Math.sqrt(soma); // aqui ele faz a raiz quadrada do parametro que foi passado a soma
		return regra;
	}

	// metodo
	public double[] jacobi(double b[], double erro) {
		int N = matriz.length;

		//// Inicializamos o vetor de aproximação inicial em 0,0.
		double X_Anterior[] = new double[N];
		for (int i = 0; i < X_Anterior.length; i++) {
			X_Anterior[i] = 0.0;
		}

		double X_Atual[] = new double[N];
		for (int i = 0; i < X_Atual.length; i++) {
			X_Atual[i] = 0.0;
		}

		double norma = 1.0;
		double somaAux;
		int contadorInteracao = -1; //contador inicia em -1, para que a primeira iteração seja 0

		// Verifique se o critério de parada é atendido
		while ((norma /regraVetor(X_Atual)) >= erro) {//aqui ele divide a raiz quadrada do numero passado no norma pelo vetor b
			somaAux = 0.0;
			contadorInteracao++;

			System.out.println("Interação: " + contadorInteracao + ":");

			// atualizamos o vetor de aproximacao inicial
			for (int i = 0; i < X_Anterior.length; i++) {
				X_Anterior[i] = X_Atual[i];
			}

			for (int i = 0; i <= N - 1; i++) {
				for (int j = 0; j <= N - 1; j++) {
					if (j != i) {
						somaAux += matriz[i][j] * X_Anterior[j]; // multiplica a matriz com a iteração
					}
				}

				X_Atual[i] = (b[i] - somaAux) / matriz[i][i];  //Resolve a formula Dx = b-Rx

				System.out.println("X[" + (i + 1) + "]: " + X_Atual[i]); //imprime a iteração
				somaAux = 0.0;
			}
			System.out.println("");

			norma = regraVetor(restaVetores(X_Atual, X_Anterior)); //atualiza o valor do criterio de parada
		}
		 System.out.println("Número de Iterações = "+contadorInteracao);//imprime o total de iterações
		return X_Atual;

	}
}


