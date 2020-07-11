/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.Calendar;

/**
 *
 * @author juansevargas
 */
public class Registro 
{
    private int registroId;
    private Silla silla;
    private Vuelo vuelo;
    private Calendar fechaDeCompra;

    public Registro() 
    {
        this.fechaDeCompra = null;
        this.vuelo = null;
        this.silla = null;
        this.registroId = 0;
    }

    public Registro(int registroId, Silla silla, Vuelo vuelo, Calendar fechaDeCompra) 
    {
        this.silla = silla;
        this.vuelo = vuelo;
        this.fechaDeCompra = fechaDeCompra;
        this.registroId = registroId;
    }

    //Getter and Setter
    public Silla getSilla() {
        return silla;
    }

    public void setSilla(Silla silla) {
        this.silla = silla;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public Calendar getFechaDeCompra() {
        return fechaDeCompra;
    }

    public void setFechaDeCompra(Calendar fechaDeCompra) {
        this.fechaDeCompra = fechaDeCompra;
    }

    public int getRegistroId() {
        return registroId;
    }

    public void setRegistroId(int registroId) {
        this.registroId = registroId;
    }
    
    
    
    @Override
    public String toString() {
        return "Registro"
                + "\n" + "Silla=" + silla + "\n Vuelo=" + vuelo.getIdVuelo() + " " +  vuelo.getCodigo() + " Origen/Destino " +  vuelo.getOrigen() + "/" + vuelo.getDestino() + ", FechaDeCompra=" + fechaDeCompra.get(Calendar.HOUR_OF_DAY) + ":" +fechaDeCompra.get(Calendar.MINUTE);
    }
    
                      
    
    
}
