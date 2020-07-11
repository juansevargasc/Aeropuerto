/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import datastructures.*;

/**
 *
 * @author juansevargas
 */
public class Aerolinea 
{
    private String nombre;
    private String codigoIdentificador;
    private MyArrayList<Vuelo> vuelos;
    //Logo
    private String logo;

    public Aerolinea() 
    {
        this.codigoIdentificador = null;
        this.logo = null;
        this.vuelos = new MyArrayList<>();
        this.nombre = null;
    }

    public Aerolinea(String nombre, String codigoIdentificador) 
    {
        this.nombre = nombre;
        this.codigoIdentificador = codigoIdentificador;
        this.vuelos = new MyArrayList<>();
        this.logo = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoIdentificador() {
        return codigoIdentificador;
    }

    public void setCodigoIdentificador(String codigoIdentificador) {
        this.codigoIdentificador = codigoIdentificador;
    }
    
    public void addVuelo(Vuelo v)
    {
        this.vuelos.add(v);
    }

    public MyArrayList<Vuelo> getVuelos() 
    {
        return vuelos;
    }
    
    

    public void imprimirVuelos()
    {
        for (Vuelo v: this.vuelos) 
        {
            System.out.println(v.toString());
        }
    }
    
    //Métodos getVuelos Llegada Salida
    public MyArrayList<Vuelo> vuelosLlegada () {
    	MyArrayList<Vuelo> llegadas = new MyArrayList<>();
    	
    	for(Vuelo vuelo: this.vuelos) {
    		if(vuelo.getTipoVuelo().equals("L")) {
    			llegadas.add(vuelo);
    		}
    	}
    	
		return llegadas;
    	
    }
    
    public MyArrayList<Vuelo> vuelosSalida () {
    	MyArrayList<Vuelo> salidas = new MyArrayList<>();
    	
    	for(Vuelo vuelo: this.vuelos) {
    		if(vuelo.getTipoVuelo().equals("S")) {
    			salidas.add(vuelo);
    		}
    	}
    	
		return salidas;
    	
    }
    
    @Override
    public String toString() 
    {
        return "Aerolinea{" + "nombre=" + nombre + ", codigoIdentificador=" + codigoIdentificador + '}';
    }
    
    
    
    
    
    
}
