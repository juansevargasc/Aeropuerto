/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author juansevargas
 */
public class Silla 
{
    private int fila;
    private char columna;
    private String cabina; //Cabina es la clase: Economica, Ejecutiva, etc.
    private Boolean estado; //Si está ocupada o no. TRUE Ocuapdo. FALSE Desocupado

    public Silla() 
    {
        this.cabina = null;
        this.columna = 0;
        this.fila = 0;
        this.estado = false;
    }

    public Silla(int fila, char columna, String cabina, Boolean estado) {
        this.fila = fila;
        this.columna = columna;
        this.cabina = cabina;
        this.estado = estado;
    }
    
    

    //Getters Setters
    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public char getColumna() {
        return columna;
    }

    public void setColumna(char columna) {
        this.columna = columna;
    }

    public String getCabina() {
        return cabina;
    }

    public void setCabina(String cabina) {
        this.cabina = cabina;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Silla{" + "fila=" + fila + ", columna=" + columna + ", cabina=" + cabina + ", estado=" + estado + '}';
    }

    
    
    
    
    
}
