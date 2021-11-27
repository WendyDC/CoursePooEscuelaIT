package com.codewen.logic;

public class Descarte extends Mazo{
	
	public Descarte() {
		super(Klondike.CAN_CARTAS_POR_DESCARTE, "Descarte");
	}

	@Override
	public void mostrarContenido() {
		int primeraVisible = posUltima -3;
		if(primeraVisible <0) {
			primeraVisible = 0;
		}
		for (int i = primeraVisible; i < posUltima; i++) {
			cartas[i].mostrar();
		}
	}
	
	@Override
    public boolean isApilable(Carta carta) {
        return true;
    }
}
