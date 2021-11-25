package com.codewen.logic;

public class Carta {
	
	private int palo;
    
    private int numero;
    
    private boolean bocaArriba;
    
    private static final String[] PALOS = {"Picas", "Treboles", "Diamantes", "Corazones"};
    
    private static final Intervalo NEGROS = new Intervalo(0,1);
    
    private static final Intervalo ROJOS = new Intervalo(2,3);
    
    private static final String[] NUMEROS = {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}; 


    public Carta(int palo, int numero) {
        assert new Intervalo(0,Klondike.NUM_PALOS-1).incluye(palo);
        assert new Intervalo(0,Klondike.CAN_CARTAS_POR_PALO-1).incluye(numero);
        this.palo = palo;
        this.numero = numero;
        bocaArriba = false;
    }

    public boolean bocaArriba() {
        return bocaArriba;
    }

    public void voltear() {
        bocaArriba = !bocaArriba;        
    }

    public void mostrar() {
        String numero = "???";
        String palo= "???";
        if (this.bocaArriba()){
            numero = NUMEROS[this.numero];
            palo = PALOS[this.palo];
        }
        System.out.println("(" + numero + " de " + palo + ")");       
    }

	public boolean esAs() {
        return numero == 0;
    }

	public boolean igualPalo(Carta carta) {
        return palo == carta.palo;
    }

	public boolean siguiente(Carta carta) {
        return numero == carta.numero+1;
    }

	public boolean esRey() {
        return numero == 12;
    } 

	public boolean distintoColor(Carta carta) {
        return this.rojo() && carta.negro() ||
                this.negro() && carta.rojo();
    } 
	
	private boolean rojo() {
        return ROJOS.incluye(palo);
    }
    
    private boolean negro() {
        return NEGROS.incluye(palo);
    }

	public boolean pertenecePalo(Carta carta) {
		 return palo == carta.palo;
	}


}
