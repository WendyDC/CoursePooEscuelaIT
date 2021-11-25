package com.codewen.logic;

public class Palo {
	
	private Carta[] cartas;
	private int posUltima;

	public Palo() {
		cartas = new Carta[Klondike.CAN_CARTAS_POR_PALO];
		posUltima = 0;
	}
	
	public void mostrar() {
		System.out.println("Palo: ");
		if(this.vacio()) {
			System.out.println("Vacio");
		}else {
			this.cima().mostrar();
		}		
	}

	private Carta cima() {		 
		return this.cartas[this.posUltima-1];
	}

	public void moverAColumna(Columna columna) {
		assert columna != null;
		if(this.vacio()) {
			System.out.println("Vacio");
		}else {
			Carta carta = this.sacar();
			if(columna.isApilable(carta)) {
				columna.poner(carta);
			}else {
				this.poner(carta);
				System.out.println("Error no se puede realizar movimiento");
			}
		}		
	}

	private Carta sacar() {
		this.posUltima--;
		return cartas[this.posUltima];
	}

	private boolean vacio() {
		return this.posUltima == 0;
	}

	public boolean isApilable(Carta carta) {
		assert carta != null;
		return this.vacio() && carta.esAs() ||
			  !this.vacio() && carta.siguiente(this.cima()) && carta.pertenecePalo(this.cima());
	}

	public void poner(Carta carta) {
		assert carta != null;
		this.cartas[this.posUltima]= carta;
		this.posUltima++;
	}

}
