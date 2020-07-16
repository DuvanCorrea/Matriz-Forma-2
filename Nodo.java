
package trabajoa.p_punto2;


public class Nodo {
    
    private int dato, fila, columna;
    private Nodo LF, LC;

    public Nodo() {
        this.dato = 0;
        this.fila = 0;
        this.columna = 0;
        this.LF = null;
        this.LC = null;
    }

    public Nodo(int dato, int fila, int columna, Nodo LI, Nodo LD) {
        this.dato = dato;
        this.fila = fila;
        this.columna = columna;
        this.LF = LF;
        this.LC = LC;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public Nodo getLF() {
        return LF;
    }

    public void setLF(Nodo LF) {
        this.LF = LF;
    }

    public Nodo getLC() {
        return LC;
    }

    public void setLC(Nodo LC) {
        this.LC = LC;
    }

   
    
}
