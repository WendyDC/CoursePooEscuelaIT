package com.codewen.logic;

public class Columna extends Mazo{

	public Columna(int posicion, Baraja baraja) {
		super(posicion + Klondike.CAN_CARTAS_POR_PALO-1, "Columna "+posicion);			
		for (int i = 0; i < posicion; i++) {
			Carta carta = baraja.sacar();
			if(i== posicion -1) {
				carta.voltear();
			}
			this.poner(carta);			
		}
	}

    public boolean isApilable(Carta carta) {
        assert carta != null;
        return this.vacia() && carta.esRey() || 
                !this.vacia() && this.cima().bocaArriba() && 
                this.cima().siguiente(carta) && 
                this.cima().distintoColor(carta);
    }

	@Override
	public void mostrarContenido() {
		for (int i = 0; i < this.posUltima; i++) {
			cartas[i].mostrar();
			
		}
	}

}
