package com.codewen.logic;

import java.util.Random;

public class Baraja extends Mazo{
	
	public Baraja() {
		super(Klondike.CAN_CARTAS_POR_BARAJA, "Baraja");
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

	@Override
    public void mostrarContenido() {
        this.cima().mostrar();
    }

    @Override
    public boolean isApilable(Carta carta) {
        return true;
    }
}
