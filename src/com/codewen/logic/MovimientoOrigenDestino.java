package com.codewen.logic;
public class MovimientoOrigenDestino extends OpcionKlondike {

    protected Mazo origen;
    
    protected Mazo destino;
    
    protected MovimientoOrigenDestino(String titulo, Tapete tapete) {
        super(titulo, tapete);
    }

    @Override
    public void ejecutar() {
        if (origen.vacia()) {
            this.error("No hay cartas en " + origen.getTitulo());
        } else {
            Carta carta = origen.sacar();
            if (destino.isApilable(carta)) {
                destino.poner(carta);
            } else {
                origen.poner(carta);
                this.error("No se puede realizar ese movimiento");
            }
        } 
    }

}
