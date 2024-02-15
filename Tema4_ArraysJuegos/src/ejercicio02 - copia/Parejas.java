package ejercicio02;

import java.util.Random;

public class Parejas {

	static Random rand = new Random();
	
	
	// array que servirá de tablero para el juego
	static String[] tablero;
	// array que servirá de tablero invisible donde se guardan los números generados
	int[] tableroNumero;
	//movimiento del jugador
	int movimiento = -1;

	// pinta una tablero de un tamaño elegido por el jugador
	void pintaTablero(int tamaño) {
		tablero = new String[tamaño];

		// encargado de pintar la parte superior del tablero, en el cual aparecen
		// números para que el jugador sepa a dónde se mueve
		for (int i = 1; i <= tamaño; i++) {
			System.out.print(" " + i + " ");
		}
		System.out.println("");
		// encargado de pintar las casillas de juego
		for (int j = 0; j < tablero.length; j++) {
			if(movimiento==j+1 && tablero[j]!="[ ]" ) {
				tablero[j] = "["+ String.valueOf(tableroNumero[movimiento-1]) + "]";
				System.out.print(tablero[j]);
			}else if(tablero[j]=="[ ]") {
				tablero[j] = "[ ]";
				System.out.print(tablero[j]);
			}
			
			
		}

	}

	// genera los números de juego
	void genNum(int tamaño) {
		int posicion;
		int j = 0;
		tableroNumero = new int[tamaño];

		// for principal controla el número que se imprime y el while interior controla
		// que se muestren 2 en posiciones aleatorias
		for (int i = 1; i <= (tamaño / 2); i++) {
			while (j < 2) {
				posicion = rand.nextInt(0, tamaño);
				// solo se guarda el número si en la posición generada aleatoria había un 0, en
				// tal caso aumenta el contador
				if (tableroNumero[posicion] == 0) {
					tableroNumero[posicion] = i;
					j++;
				}
			}
			j = 0;
		}
	}

	// mueve al jugador y devuelve un código
	// 0 movimiento correcto, -1 movimiento oob
	int movJ(int input, int tamaño) {
		int cod;
		
		
		if(input > tamaño || input < 1) {
			cod = -1;
		}else {
			movimiento = input;
			cod = 0;
		}
		return cod;
	}

}
