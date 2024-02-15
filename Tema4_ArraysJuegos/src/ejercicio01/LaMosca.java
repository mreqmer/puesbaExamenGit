package ejercicio01;

import java.util.Random;

public class LaMosca {
	// clase Random para generar posiciones aleatorias
	static Random rand = new Random();
	// constante que marca el tamaño del tablero
	static final int TAM_TABLERO = 8;
	// tabla que será el tablero de juego
	static String[] tablero = new String[TAM_TABLERO];
	// guarda la posición del jugador, se inicializa en -2 para que no aparezca al
	// principio del juego
	int posJugador = -2;
	// guarda la posición de la mosca
	static int posMosca;

	// se encarga de pintar el tablero de juego
	void pintaTablero() {
		// rellena el tablero con números para que el jugador sepa donde moverse
		for (int i = 1; i <= tablero.length; i++) {
			System.out.print(" " + i + " ");
		}

		System.out.println("");

		for (int j = 0; j < tablero.length; j++) {
			if (posJugador == j + 1) {
				tablero[j] = "[X]";
				System.out.print(tablero[j]);
			} else {
				tablero[j] = "[ ]";
				System.out.print(tablero[j]);
			}

		}

		System.out.println("");
	}

	// mueve al jugador a la posición del array deseada y devuelve un código
	// dependiendo de si el mov fue válido o no
	int movJugador(int movimiento) {
		// código, si devuelve 0 el mov fue correcto, si devuelve -1 es oob.
		int resJ;
		// comprueba que el movimiento esté dentro de los límites del tablero
		if (movimiento > 0 && movimiento <= TAM_TABLERO) {
			posJugador = movimiento;
			resJ = 0;
		} else {
			resJ = -1;
		}

		return resJ;
	}

	// genera la posición de la mosca
	void generaMosca() {
		posMosca = rand.nextInt(1, TAM_TABLERO + 1);

	}

	// mueve a la mosca en caso de que haya estado adyacente a la posción donde se
	// movió el jugador. Devuelve un código, 0 no se movió y -1 se movió
	int movMosca() {
		// codigo
		int resM;

		if (posMosca + 1 == posJugador || posMosca - 1 == posJugador) {
			posMosca = rand.nextInt(1, TAM_TABLERO + 1);
			resM = -1;
		} else {
			resM = 0;
		}

		return resM;
	}
	
	//comprueba si el jugador ha ganado o no, devuelve un boleano dependiendo de si ganó o no
	boolean juegoGanado() {
		//guarda si el jugador está o no en la misma pos que la mosca
		boolean ganado = false;
		
		if(posJugador == posMosca) {
			ganado = true;
		}else {
			ganado = false;
		}
		return ganado;
	}
	
	
}
