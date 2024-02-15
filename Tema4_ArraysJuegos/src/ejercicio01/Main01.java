package ejercicio01;

import java.util.Scanner;

public class Main01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//
		LaMosca juegoMosca;
		juegoMosca = new LaMosca();
		// var
		// guarda el input de movimiento del jugador
		int movJugador;
		// guarda los códigos de error del mov del jugador
		int codJ;
		// guarda los códigos de error del mov de la mosca
		int codM;
		// boleano que guarda si el juego se ha ganado o no
		boolean juegoGanado = false;
		// guarda si el jugador volverá a jugar o no
		String repetir;
		// es la copia de repetir pero en minuscula
		String repetirMin;

		System.out.println("LA MOSCA");
		System.out.println("\n\n\n");

		do {
			// inicializa el movimiento del jugador en -2 para que siempre que se vuelva a
			// jugar la posición salga del tablero y empieze sin aparecer en el tablero
			juegoMosca.posJugador = -2;
			movJugador = juegoMosca.posJugador;

			juegoMosca.movJugador(movJugador);
			// vuelve a inicializar el estado de juegoGanado a false
			juegoGanado = false;
			// se genera la posición de la mosca llamando a la función
			juegoMosca.generaMosca();
			// muestra el tablero
			juegoMosca.pintaTablero();
			do {
				
//				HACKS
//				int posicionMosca;
//				posicionMosca = LaMosca.posMosca;
//				System.out.println(posicionMosca);

				// bucle encargado de preguntar al jugador la posición hasta que introduzca una
				// válida
				do {
					// Mensaje para el movimiento del jugador
					System.out.println("Introduzca movimiento: ");
					movJugador = sc.nextInt();
					// función que mueve al jugador
					codJ = juegoMosca.movJugador(movJugador);
					// si está oob muestra mensaje de error
					switch (codJ) {
					case -1 -> System.out.println("Fuera de rango de juego");
					}
					;

				} while (codJ != 0);
				// vuelve a mostrar el tablero con el jugador movido
				juegoMosca.pintaTablero();
				// comprueba que la mosca se tenga que mover o no (si el jugador se movió a una
				// adyacente a la mosca)
				codM = juegoMosca.movMosca();
				// si se movió la mosca devuelve mensaje
				switch (codM) {
				case -1 -> System.out.println("¡Casi! La mosca se ha movido.");
				}
				;
				// comprueba si el jugador ganó o no
				juegoGanado = juegoMosca.juegoGanado();
			} while (!juegoGanado);
			System.out.println("¡¡¡HAS GANADO!!!");
			System.out.println("¿Quieres volver a jugar? S/N");
			repetir = sc.next();
			repetirMin = repetir.toLowerCase();

		} while (repetirMin.equals("s"));
		
		sc.close();
	}

}
