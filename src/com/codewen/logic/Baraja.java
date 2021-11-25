package com.codewen.logic;

import java.util.Random;

public class Baraja {
	
	private Carta[] cartas;
	private int posUltima;
	
	public Baraja() {
		cartas = new Carta[Klondike.CAN_CARTAS_POR_BARAJA];
		for (int i = 0; i < Klondike.NUM_PALOS; i++) {
			for (int j = 0; j < Klondike.CAN_CARTAS_POR_PALO; j++) {
				this.poner(new Carta(i,j));
			}
		}
		this.barajar();
	}

	private void barajar() {
		int ori;
		int des;
		Carta carta;
		Random aleatorio = new Random();
		for (int i = 0; i < 1000; i++) {
			ori = aleatorio.nextInt(Klondike.CAN_CARTAS_POR_BARAJA);
			des = aleatorio.nextInt(Klondike.CAN_CARTAS_POR_BARAJA);
			carta = cartas[ori];
			cartas[ori] =cartas[des];
			cartas[des] = carta;
			
		}
	}

	public void poner(Carta carta) {
		assert carta != null;
		assert !carta.bocaArriba();
		assert !this.completa();
		cartas[posUltima]=carta;
		this.posUltima++;
		
	}

	private boolean completa() {
		return this.posUltima > Klondike.CAN_CARTAS_POR_BARAJA;
	}

	public void mostrar() {
		System.out.println("Baraja: ");
		if(this.vacia()) {
			System.out.println("Vacia");
		}else {
			this.cima().mostrar();
		}
	}

	private Carta cima() {
		assert !this.vacia();
		return this.cartas[this.posUltima-1];
	}

	private boolean vacia() {
		return this.posUltima == 0;
	}

	public void moverADescarte(Descarte descarte) {
		if(this.vacia()) {
			System.out.println("Error. Esta vacia la baraja");
		} else {
			int contador =3;
			while (contador > 0 && !this.vacia()) {
				Carta carta = this.sacar();
				carta.voltear();
				descarte.poner(carta);
				contador--;
			}
		}
	}

	public Carta sacar() {
		assert !this.vacia();
		this.posUltima--;
		return this.cartas[this.posUltima];
	}



}
