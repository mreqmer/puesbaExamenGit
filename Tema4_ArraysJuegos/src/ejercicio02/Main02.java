package ejercicio02;

import java.util.Arrays;
import java.util.Scanner;

public class Main02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Parejas juegoParejas;
		juegoParejas = new Parejas();
		//var
		int tamTablero;
		int[] tableroNumero;
		int movimiento;
		
		System.out.println("Introduce el tamaño del tablero (debe ser par):");
		tamTablero = sc.nextInt();
		
		tableroNumero = new int[tamTablero];
		
		juegoParejas.pintaTablero(tamTablero);
		
		juegoParejas.genNum(tamTablero);
		tableroNumero = juegoParejas.tableroNumero;
		System.out.println(Arrays.toString(tableroNumero));
		
		System.out.println("¿Que posición quieres dar la vuelta?");
		movimiento = sc.nextInt();
		
		juegoParejas.movJ(movimiento, tamTablero);
		
		juegoParejas.pintaTablero(tamTablero);
		
		System.out.println("¿Que otra posición quieres dar la vuelta?");
		movimiento = sc.nextInt();
		
juegoParejas.movJ(movimiento, tamTablero);
		
		juegoParejas.pintaTablero(tamTablero);
		
		
		
		sc.close();
	}
}
