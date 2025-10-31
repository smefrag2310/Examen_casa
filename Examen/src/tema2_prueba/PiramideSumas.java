package tema2_prueba;

import java.util.Scanner;

public class PiramideSumas {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String resp;

		do {
			// SMR20251031 no se ha cerrado con ;
			int num = leerEntero(sc, "Introduzca un número: ");

			/*
			 * SMR20251031 condicional incorrecto, && hace que ambas condiciones se deban
			 * cumplir, || es el adecuado para este bucle pues hace que se haga siempre y
			 * cuando se cumpla una de las condiciones
			 */
			while (num < 0 || num > 20) {
				num = leerEntero(sc, "**Valor fuera de rango** Introduzca un número entre 0 y 20: ");
			}

			System.out.println("\nSu pirámide de sumas es la siguiente:\n" + piramide(num));

			System.out.print("¿Quiere hacer otra pirámide? (s/n) ");
			// SMR20251031 se había declarado la variable dos veces
			resp = sc.next().trim().toUpperCase();
			// SMR20251031 Le faltaba un ) para cerrar el while
		} while (resp.equals("S"));

		borrarConsola();
		System.out.println("¡¡¡PROGRAMA FINALIZADO!!!");

		sc.close();
	}

	private static int leerEntero(Scanner sc, String mensaje) {
		System.out.print(mensaje);
		while (!sc.hasNextInt()) {
			System.out.print("**Valor no válido** Introduzca un número entero: ");
			sc.next();
		}
		return sc.nextInt();
	}

	public static void borrarConsola() {
		// SMR20251031 se había puesto , en vez de ; en la función for
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}

	public static String piramide(int numero) {
		String res = "";
		int n = numero;

		while (n >= 0) {
			int cont = 1;
			int total = 0;
			res += n + " => 0 ";
			// SMR20251031 el while no tenia las llaves correspondientes.
			while (cont <= n) {
				res += "+ " + cont + " ";
				total += cont;
				cont += 1;
			}
			if (n != 0) {
				res += "= " + total;
			}

			res += "\n";
			n -= 1;
		}
		// SMR20251031 variable resultado no definida, se quiere poner res
		return res;
	}

}
