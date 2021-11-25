package com.codewen.logic;

import java.util.Scanner;

public class Klondike {
	
	private Baraja baraja;
	private Descarte descarte;
	private Palo[] palos;
	private Columna [] columnas;
	
	public static final int NUM_PALOS = 4;
	public static final int CAN_CARTAS_POR_PALO = 13;
	public static final int CAN_CARTAS_POR_BARAJA = NUM_PALOS*CAN_CARTAS_POR_PALO;
	public static final int CAN_CARTAS_POR_DESCARTE = CAN_CARTAS_POR_BARAJA-28;
	public static final int NUM_COLUMNAS =7;
	
	private Klondike() {
		baraja = new Baraja();
		descarte = new Descarte();
		palos = new Palo[NUM_PALOS];
		for(int i=0; i < palos.length;i++) {
			palos[i]=new Palo();
		}
		columnas = new Columna[NUM_COLUMNAS];
		for(int i=0; i < columnas.length;i++) {
			columnas[i] = new Columna(i+1, baraja);
		}
	}
	
	private void mostrar() {
		baraja.mostrar();
		descarte.mostrar();
		for(Palo palo: palos) {
			palo.mostrar();
		}
		for(Columna columna : columnas) {
			columna.mostrar();
		}
	}
	
	private void jugar() {
				
		Menu menu = new Menu();
		int option;
		Palo palo;
		Columna columna;
		Columna columnaAux;
		do {
			this.mostrar();
			palo = null;
			columna = null;		
			columnaAux = null;
			option = menu.getOption();	
			
			switch(option) {
				case 1:
					baraja.moverADescarte(descarte);
					break;
				case 2:
					palo = palos[menu.elegirPalo()-1];
					descarte.moverAPalo(palo);
					break;
				case 3:
					columna = columnas[menu.elegirColumna()-1];
					descarte.moverAColumna(columna);
					break;
				case 4:
					palo = palos[menu.elegirPalo()-1];
					columna = columnas[menu.elegirColumna()-1];
					palo.moverAColumna(columna);
					break;
				case 5:
					palo = palos[menu.elegirPalo()-1];
					columna = columnas[menu.elegirColumna()-1];
					columna.moverAPalo(palo);
					break;
				case 6:
					columna = columnas[menu.elegirColumna()-1];
					columnaAux = columnas[menu.elegirColumna()-1];
					columna.moverAColumna(columnaAux);
					break;
				case 7:
					break;
				case 8:
					descarte.voltear(baraja);
					break;
				case 9:
					break;
			}		
		}while (option != 9);
		
		
	}
	
	public static void main(String[] args) {
		new Klondike().jugar();
	}

	
}
