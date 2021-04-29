import java.util.Scanner;

/**
 * @author Beatriz Tranche Robles
 *
 */
public class Matriz {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// Variables que almacenan las filas y columnas de la matriz
		int filas1, filas2, columnas1, columnas2;
		// Variable que controla si la calculadora está funcionando
		int start = 0;
		// Permite al usuario elegir entre las opciones del menú
		int opcion;

		// Creación de matrices con datos introducidos por el usuario
		System.out.print("MATRIZ 1" + "\n" + "Introduce numero de filas: ");
		filas1 = sc.nextInt();
		System.out.print("Introduce numero de columnas: ");
		columnas1 = sc.nextInt();
		int[][] matriz1 = new int[filas1][columnas1];
		System.out.print("MATRIZ 2" + "\n" + "Introduce número de filas: ");
		filas2 = sc.nextInt();
		System.out.print("Introduce número de columnas: ");
		columnas2 = sc.nextInt();
		int[][] matriz2 = new int[filas2][columnas2];

		// Inicialización y visualización de las matrices introducidas por el usuario
		inicializar(matriz1);
		inicializar(matriz2);
		System.out.println("MATRIZ 1");
		visualizar(matriz1);
		System.out.println("MATRIZ 2");
		visualizar(matriz2);

		// Este bucle mantendra la calculadora funcionando mientras la variable start
		// sea true.
		while (start == 0) {
			// Menú de la calculadora
			System.out.println("CALCULADORA DE MATRICES" + "\n" + "Menu de opciones: " + "\n" + "1.- Suma de Matrices "
					+ "\n" + "2.- Producto de un escalar por una matriz" + "\n" + "3.- Producto de dos matrices" + "\n"
					+ "4.- Transponer una matriz" + "\n" + "5.- Diagonal principal" + "\n" + "6.- Matriz simétrica "
					+ "\n" + "7.- Potencia matriz cuadrada" + "\n" + "8.- Resta matrices" + "\n" + "9.- Salir");
			opcion = sc.nextInt();

			switch (opcion) {
			// Se ejecuta y visualiza resultado del método sumaMatrices
			case 1:
				int[][] matrizSuma = sumaMatrices(matriz1, matriz2);
				if (matrizSuma == null) {
					System.out.println(
							"No se puede realizar la suma de las matrices. Introduce dos matrices con las mismas dimensiones");
				} else {
					System.out.println("MATRIZ SUMA");
					visualizar(matrizSuma);
				}
				// Comprobación para continuar con el programa
				System.out.println("¿Quieres realizar otra operacion? SI = 0 / NO = 1");
				start = sc.nextInt();
				break;
			// Se ejecuta y visualiza el resultado del método multiplicarEscalar
			case 2:
				System.out.print("Introduce escalar: ");
				int num = sc.nextInt();
				System.out.println("\nMatriz1 multiplicada por el escalar " + num);
				int[][] matrizEscalar1 = multiplicarEscalar(matriz1, num);
				visualizar(matrizEscalar1);
				System.out.println("Matriz2 multiplicada por el escalar " + num);
				int[][] matrizEscalar2 = multiplicarEscalar(matriz2, num);
				visualizar(matrizEscalar2);
				System.out.println("¿Quieres realizar otra operacion? SI = 0 / NO = 1");
				start = sc.nextInt();
				break;
			// Se ejecuta y visualiza el resultado del método productoMatrices
			case 3:
				int[][] matrizProducto = new int[matriz1.length][matriz2[0].length];
				if (matriz1.length != matriz2[0].length) {
					matrizProducto = productoMatrices(matriz1, matriz2);
					System.out.println("MATRIZ PRODUCTO\n");
					visualizar(matrizProducto);
				}else {
					System.out.println("No se puede realizar la operacion");
				}
				System.out.println("¿Quieres realizar otra operacion? SI = 0 / NO = 1");
				start = sc.nextInt();
				break;
			// Se ejecuta y visualiza el resultado del método transponerMatriz
			case 4:
				int[][] matrizTranspuesta = transponerMatriz(matriz1);
				System.out.println("MATRIZ 1 TRANSPUESTA\n");
				visualizar(matrizTranspuesta);
				matrizTranspuesta = transponerMatriz(matriz2);
				System.out.println("MATRIZ 2 TRANSPUESTA\n");
				visualizar(matrizTranspuesta);
				System.out.println("¿Quieres realizar otra operacion? SI = 0 / NO = 1");
				start = sc.nextInt();
				break;
			// Se ejecuta y visualiza el resultado del método diagonalPrincipal
			case 5:
				System.out.println("\nDiagonal Matriz 1 ");
				int[] diagonalMatriz = diagonalPrincipal(matriz1);
				visualizarArray(diagonalMatriz);
				System.out.println("\nDiagonal Matriz 2 ");
				diagonalMatriz = diagonalPrincipal(matriz2);
				visualizarArray(diagonalMatriz);
				System.out.println("¿Quieres realizar otra operacion? SI = 0 / NO = 1");
				start = sc.nextInt();
				break;
			// Se ejecuta y visualiza el resultado del método matrizSimetrica
			case 6:
				System.out.println("\nMatriz simétrica");
				if (matrizSimetrica(matriz1)) {
					System.out.println("\n· La MATRIZ 1 es simétrica\n");
				} else {
					System.out.println("\n· La MATRIZ 1 no es simétrica\n");
				}
				if (matrizSimetrica(matriz2)) {
					System.out.println("\n· La MATRIZ 2 es simétrica\n");
				} else {
					System.out.println("\n· La MATRIZ 2 no es simétrica\n");
				}
				System.out.println("¿Quieres realizar otra operacion? SI = 0 / NO = 1");
				start = sc.nextInt();
				break;
			case 9:
				System.out.println("Adios");
				start = 1;
			}
		}
	}

	/**
	 * Metodo para inicializar matriz con valores dados por el usuario
	 * 
	 * @param matriz
	 */
	public static void inicializar(int[][] matriz) {
		// Variable que almacena los valores que tomara cada posición de la matriz
		int valor;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print("Introduce valor para fila " + (i + 1) + " columna " + (j + 1) + ": ");
				valor = sc.nextInt();
				matriz[i][j] = valor;
			}
		}
	}

	/**
	 * Método para visualizar matriz
	 * 
	 * @param matriz
	 */
	public static void visualizar(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + "\t");
			}
			System.out.println();
		}
	}

	/**
	 * Método para visualizar arrays
	 * 
	 * @param array
	 */
	public static void visualizarArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
		}
		System.out.println();

	}

	/**
	 * Método para sumar matrices
	 * 
	 * @param sMatriz1
	 * @param sMatriz2
	 * @return int[][] matrizSuma
	 */
	public static int[][] sumaMatrices(int[][] sMatriz1, int[][] sMatriz2) {
		int[][] matrizSuma;
		int filas1 = sMatriz1.length;
		int columnas1 = sMatriz1[0].length;
		int filas2 = sMatriz2.length;
		int columnas2 = sMatriz2[0].length;

		if (filas1 == filas2 && columnas1 == columnas2) {
			matrizSuma = new int[filas1][columnas1];
			for (int i = 0; i < sMatriz1.length; i++) {
				for (int j = 0; j < sMatriz1[0].length; j++) {
					matrizSuma[i][j] = sMatriz1[i][j] + sMatriz2[i][j];
				}
			}
			return matrizSuma;
		} else {
			return null;
		}
	}

	/**
	 * Método para mostrar el producto de un escalar por una matriz
	 * 
	 * @param eMatriz
	 * @param escalar
	 * @return int[][] matrizEscalar
	 */
	public static int[][] multiplicarEscalar(int[][] eMatriz, int escalar) {
		int filas = eMatriz.length;
		int columnas = eMatriz[0].length;
		int[][] matrizEscalar = new int[filas][columnas];
		for (int i = 0; i < eMatriz.length; i++) {
			for (int j = 0; j < eMatriz[i].length; j++) {
				matrizEscalar[i][j] = eMatriz[i][j] *= escalar;
			}
		}
		return matrizEscalar;
	}

	/**
	 * Método para multiplicar matrices
	 * 
	 * @param pMatriz1
	 * @param pMatriz2
	 * @return int[][] matrizProducto
	 */
	public static int[][] productoMatrices(int[][] pMatriz1, int[][] pMatriz2) {
		int[][] matrizProducto;
		int filas1 = pMatriz1.length;
		int columnas1 = pMatriz1[0].length;
		int filas2 = pMatriz2.length;
		int columnas2 = pMatriz2[0].length;
		int suma = 0;
		matrizProducto = new int[filas1][columnas2];
		for (int i = 0; i < pMatriz1.length; i++) {
			for (int j = 0; j < pMatriz2.length; j++) {
				suma = 0;
				for (int k = 0; k < pMatriz2.length; k++) {
					suma += pMatriz1[i][k] * pMatriz2[k][j];
				}
				matrizProducto[i][j] = suma;
			}
		}
		return matrizProducto;
	}

	/**
	 * Metodo para transponer matrices
	 * 
	 * @param tMatriz
	 * @return int[][] matrizTranspuesta
	 */
	public static int[][] transponerMatriz(int[][] tMatriz) {
		int[][] matrizTranspuesta;
		int filas = tMatriz.length;
		int columnas = tMatriz[0].length;
		matrizTranspuesta = new int[columnas][filas];
		for (int i = 0; i < tMatriz.length; i++) {
			for (int j = 0; j < tMatriz[0].length; j++) {
				matrizTranspuesta[j][i] = tMatriz[i][j];
			}
		}
		return matrizTranspuesta;
	}

	/**
	 * Método para hallar la diagonal de una matriz
	 * 
	 * @param dMatriz
	 * @return int[] diagonalMatriz
	 */
	public static int[] diagonalPrincipal(int[][] dMatriz) {

		int dimension = dMatriz.length;
		int[] diagonalMatriz = new int[dimension];
		for (int i = 0; i < dMatriz.length; i++) {
			for (int j = 0; j < dMatriz[i].length; j++) {
				if (i == j) {
					diagonalMatriz[i] = dMatriz[i][j];
				}
			}
		}

		return diagonalMatriz;
	}

	/**
	 * Método para comprobar si una matriz es símetrica
	 * 
	 * @param sMatriz
	 * @return boolean
	 */
	static boolean matrizSimetrica(int[][] sMatriz) {
		for (int i = 0; i < sMatriz.length; i++) {
			for (int j = 0; j < sMatriz[i].length; j++) {
				if (sMatriz[i][j] != sMatriz[j][i]) {
					return false;
				}
			}
		}
		return true;
	}
	
}

