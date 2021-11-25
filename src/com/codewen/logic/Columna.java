package com.codewen.logic;

public class Columna {
	
	private Carta[] cartas;
	private int posUltima;
	private int posicion;

	public Columna(int posicion, Baraja baraja) {
		this.posicion = posicion;
		posUltima = 0;
		cartas = new Carta[this.posicion + Klondike.CAN_CARTAS_POR_PALO-1];	
		for (int i = 0; i < this.posicion; i++) {
			Carta carta = baraja.sacar();
			if(i== this.posicion -1) {
				carta.voltear();
			}
			this.poner(carta);			
		}
	}

	public void mostrar() {
		System.out.println("Columna "+this.posicion+": ");
		if(this.vacio()) {
			System.out.println("Vacio");
		}else {
			for (int i = 0; i < this.posUltima; i++) {
				cartas[i].mostrar();
				
			}
		}
		
	}
	
	private boolean vacio() {
		return this.posUltima == 0;
	}
	
	private Carta cima() {		 
		return this.cartas[this.posUltima-1];
	}


	public void moverAPalo(Palo palo) {
		assert palo != null;
		if(this.vacio()) {
			System.out.println("Vacio");
		}else {
			Carta carta = this.sacar();
			if(palo.isApilable(carta)) {
				palo.poner(carta);
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

	public void poner(Carta carta) {
		assert carta != null;
		this.cartas[this.posUltima]= carta;
		this.posUltima++;
	}

	public void voltear() {
        if (this.vacio()) {
            System.out.println("Error!!! No hay carta que voltear");
        } else if (this.cima().bocaArriba()) {
            System.out.println("Error!!! No hay carta boca abajo en la cima");
        } else {
            this.cima().voltear();
        }
    }

    public boolean isApilable(Carta carta) {
        assert carta != null;
        return this.vacio() && carta.esRey() || 
                !this.vacio() && this.cima().bocaArriba() && 
                this.cima().siguiente(carta) && 
                this.cima().distintoColor(carta);
    }

}
