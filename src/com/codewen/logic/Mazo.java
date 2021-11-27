package com.codewen.logic;

public abstract class Mazo {

	protected Carta[] cartas;
	protected int posUltima;
	protected String titulo;
	
	protected Mazo(int cantidad, String titulo) {
		this.posUltima = 0;
		this.cartas = new Carta[cantidad];
		this.titulo = titulo;
	}
	
	public String getTitulo() {
        return titulo;
    }
	
	protected boolean vacia() {
		return this.posUltima == 0;
	}
	
	protected boolean completa() {
		return this.posUltima > Klondike.CAN_CARTAS_POR_BARAJA;
	}
	
	protected Carta cima() {
		assert !this.vacia();
		return this.cartas[this.posUltima-1];
	}
	
	protected Carta sacar() {
		assert !this.vacia();
		this.posUltima--;
		return this.cartas[this.posUltima];
	}

	protected void poner(Carta carta) {
		assert carta != null;
		assert !carta.bocaArriba();
		assert !this.completa();
		cartas[posUltima]=carta;
		this.posUltima++;
		
	}
	
	protected void mostrar() {
		System.out.println(this.titulo+": ");
		if(this.vacia()) {
			System.out.println("Vacia");
		}else {
			this.mostrarContenido();
		}
	}	
	
	public abstract void mostrarContenido();
	
	public abstract boolean isApilable(Carta carta);
	
}
