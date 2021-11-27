package com.codewen.logic;

public class Palo extends Mazo{

	public Palo() {
		super(Klondike.CAN_CARTAS_POR_PALO, "Palo");
	}

	public boolean isApilable(Carta carta) {
		assert carta != null;
		return this.vacia() && carta.esAs() ||
			  !this.vacia() && carta.siguiente(this.cima()) && carta.pertenecePalo(this.cima());
	}

	@Override
	public void mostrarContenido() {
		this.cima().mostrar();
	}

}
