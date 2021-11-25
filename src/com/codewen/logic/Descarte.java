package com.codewen.logic;

public class Descarte {
	
	private Carta[] cartas;
	private int posUltima;
	
	
	public Descarte() {
		cartas = new Carta[Klondike.CAN_CARTAS_POR_DESCARTE];
		posUltima = 0;
	}
	
	public void mostrar() {
		System.out.println("Descarte: ");
		if(this.vacia()) {
			System.out.println("Vacio");
		}else {
			int primeraVisible = posUltima -3;
			if(primeraVisible <0) {
				primeraVisible = 0;
			}
			for (int i = primeraVisible; i < posUltima; i++) {
				cartas[i].mostrar();
			}
		}
	}

	private boolean vacia() {
		return this.posUltima == 0;
	}

	public void moverAPalo(Palo palo) {
		assert palo != null;
		
		if(this.vacia()) {
			System.out.println("Error. No hay cartas para sacar.");
		}else {
			Carta carta = this.sacar();
			if(palo.isApilable(carta)) {
				palo.poner(carta);
			}else {
				this.poner(carta);
				System.out.println("Error. No se puede realizar el moviemiento");
			}				
		}
	}

	private Carta sacar() {
		this.posUltima--;
		return cartas[this.posUltima];
	}

	public void moverAColumna(Columna columna) {
		assert columna != null;
		
		if(this.vacia()) {
			System.out.println("Error. No hay cartas para sacar.");
		}else {
			Carta carta = this.sacar();
			if(columna.isApilable(carta)) {
				columna.poner(carta);
			}else {
				this.poner(carta);
				System.out.println("Error. No se puede realizar el moviemiento");
			}				
		}		
	}

	public void voltear(Baraja baraja) {
        if (this.vacia()) {
            System.out.println("Error!!! No hay cartas en descarte");
        } else {
            while (!this.vacia()) {
                Carta carta = this.sacar();
                carta.voltear();
                baraja.poner(carta);
            }
        }
    }

	public void poner(Carta carta) {
		assert carta != null;
		this.cartas[this.posUltima]= carta;
		this.posUltima++;
		
	}

}
