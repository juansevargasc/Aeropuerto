/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import datastructures.*;
import java.util.Calendar;


/**
 *
 * @author juansevargas
 */
public class Vuelo 
{
    private String codigo;
    private String origen;
    private String destino;
    private String tipoVuelo; //Llegada o Salida (L O S)
    private Calendar horaSalida;
    private Calendar horaLlegada;
    private int numeroPasajeros;
    private Avion avion; //Código
    private Aerolinea aerolinea; //Asociación con Aerolinea 
    //Or DataStructure that applies
    private MyArrayList<Cliente> pasajeros;
    private int idVuelo;

    //Constructores
    public Vuelo() 
    {
        this.codigo = null;
        this.origen = null;
        this.destino = null;
        this.tipoVuelo = null;
        this.horaSalida = null;
        this.horaLlegada = null;
        this.numeroPasajeros = 0;
        this.avion = null;
        this.pasajeros = new MyArrayList<>();
        this.aerolinea = null;
        this.idVuelo = 0;
    }

    
    
    
    public Vuelo(Aerolinea aerolinea, String codigo, String origen, String destino, String tipoVuelo) 
    {
        this.codigo = codigo;
        this.origen = origen;
        this.destino = destino;
        this.tipoVuelo = tipoVuelo;
        this.aerolinea = aerolinea;
        this.pasajeros = new MyArrayList<>();
    }
    
    //Getters and Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getTipoVuelo() {
        return tipoVuelo;
    }

    public void setTipoVuelo(String tipoVuelo) {
        this.tipoVuelo = tipoVuelo;
    }

    public Calendar getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Calendar horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Calendar getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(Calendar horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public int getNumeroPasajeros() {
        return numeroPasajeros;
    }

    public void setNumeroPasajeros(int numeroPasajeros) {
        this.numeroPasajeros = numeroPasajeros;
    }

    public Aerolinea getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(Aerolinea aerolinea) {
        this.aerolinea = aerolinea;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public MyArrayList<Cliente> getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(MyArrayList<Cliente> pasajeros) {
        this.pasajeros = pasajeros;
    }
    
    //Metodos de adición y sustracción
    /**
     * 
     * @param c 
     */
    public void addCliente(Cliente c)
    {
        this.pasajeros.add(c);
    }
    
    public void removeCliente(Cliente c)
    {
        
    }
    
    public void actualizarNumeroClientes()
    {
        this.numeroPasajeros = this.pasajeros.getTam();
    }

    @Override
    public String toString() 
    {
        return "Vuelo{" + "\ncodigo=" + codigo + ", origen=" + origen + ", destino=" + destino + ", tipoVuelo=" + tipoVuelo + ", \nhoraSalida=" + (horaSalida.get(Calendar.HOUR_OF_DAY) + ":" +horaSalida.get(Calendar.MINUTE)) + ", horaLlegada=" + (horaLlegada.get(Calendar.HOUR_OF_DAY) + ":" + horaLlegada.get(Calendar.MINUTE)) + ", numeroPasajeros=" + numeroPasajeros + ",\n avion=" + avion + ",\n aerolinea=" + aerolinea + ", idVuelo=" + idVuelo + '}';
    }

   
    
    
    
}
