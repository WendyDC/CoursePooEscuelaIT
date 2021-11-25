package com.codewen.logic;

import java.util.Scanner;

public class Menu {
	
	private static final String[] MENU_PRINCIPAL = new String []{"1. Mover de baraja a descarte\n",
																 "2. Mover de descarte a palo\n",
																 "3. Mover de descarte a columna\n",
																 "4. Mover de palo a columna\n",
																 "5. Mover de columna a palo\n",
																 "6. Mover de columna a columna\n",
																 "7. Voltear carta en columna\n",
																 "8. Voltear descarte en baraja\n",
																 "9. Salir\n"};
	
	private static final String MENU_PALO = "Elija el palo del 1 al "+Klondike.NUM_PALOS+"\n";
			
	private static final String MENU_COLUMNA = "Elija la columna del 1 al "+Klondike.NUM_COLUMNAS+"\n";

	private boolean validarOpcion(int option, int varMin, int varMAx) {
		if(option < varMin || option > varMAx) {
			System.out.println("Error: Opción correcta entre "+varMin+"-"+varMAx);
			return false;
		}
		return true;
	}
	
	public int getOption() {
		String cadena = "";
		int option = 0;
		do {
			if(cadena.isEmpty()) {
				cadena = "Menu:\n";
				for (String menu : MENU_PRINCIPAL) {
					cadena += menu;
				}
			}
			System.out.println(cadena);
			Scanner scan = new Scanner(System.in);
			option = scan.nextInt();			
			
		}while(!validarOpcion(option, 1, MENU_PRINCIPAL.length));
		
		return option;
	}

	public int elegirPalo() {
		int option = 0;
		do {
			System.out.println(MENU_PALO);
			Scanner scan = new Scanner(System.in);		
			option = scan.nextInt();
		}while(!validarOpcion(option, 1, Klondike.NUM_PALOS));
		
		return option;
	}

	public int elegirColumna() {
		int option = 0;
		do {
			System.out.println(MENU_COLUMNA);
			Scanner scan = new Scanner(System.in);		
			option = scan.nextInt();
		}while(!validarOpcion(option, 1, Klondike.NUM_COLUMNAS));
		
		return option;
	}


}
