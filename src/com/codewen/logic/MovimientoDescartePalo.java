package com.codewen.logic;
public class MovimientoDescartePalo extends MovimientoOrigenDestino {

    protected MovimientoDescartePalo(Tapete tapete) {
        super("Mover de descarte a palo", tapete);
    }

    @Override
    public void ejecutar() {
        origen = tapete.getDescarte();
        destino = tapete.getPalo(this.recoger("A qu� palo", Klondike.NUM_PALOS));
        super.ejecutar();
    }

}
