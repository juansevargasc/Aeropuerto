/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import datastructures.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author juansevargas
 */
public class Cliente 
{
    private String nombre;
    private int identificacion;
    private Silla sillaVuelo;
    //Or DataStructure that applies
    private MyArrayList<Registro> registroPasajero; //Es de composición
    
    //public MyLinkedList
    
    //Constructores
    public Cliente() 
    {
        this.nombre = null;
        this.identificacion = 0;
        this.sillaVuelo = null;
        this.registroPasajero = new MyArrayList<>();
    }

    public Cliente(String nombre, int identificacion) 
    {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.registroPasajero = new MyArrayList<>();
        
    }

    public Cliente(String nombre, int identificacion, Silla sillaVuelo)
    {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.sillaVuelo = sillaVuelo;
        this.registroPasajero = new MyArrayList<>();
    }
    
    //Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public Silla getSillaVuelo() {
        return sillaVuelo;
    }

    public void setSillaVuelo(Silla sillaVuelo) {
        this.sillaVuelo = sillaVuelo;
    }
    
    
    //Métodos de adición, reduccion etc.
    public void anadirRegistro(Registro registro)
    {
        this.registroPasajero.add(registro);
    }
    
    public void removerRegistro(int i)
    {
        this.registroPasajero.remove(i);
    }
    
    //Pendiente
    public void setRegistro(Silla silla, Vuelo vuelo, Calendar fechacompra)
    {
        int id = this.registroPasajero.getTam() + 1;
        Registro r = new Registro(id, silla, vuelo, fechacompra);
        this.registroPasajero.add(r);
    }
    
    //Getters Datos del registro
    public int sizeRegistros()
    {
        return this.registroPasajero.getTam();
    }
    
    public int getRegistroId(int numeroRegistro)
    {
        return registroPasajero.getData(numeroRegistro).getRegistroId();
    }  
    
    public Silla getSillaRegistro(int numeroRegistro)
    {
        return registroPasajero.getData(numeroRegistro).getSilla();
    }
    
    public Vuelo getVueloRegistro(int numeroRegistro)
    {
        return registroPasajero.getData(numeroRegistro).getVuelo();
    }
    
    public Calendar getFechaDeCompraRegistro(int numeroRegistro)
    {
        return registroPasajero.getData(numeroRegistro).getFechaDeCompra();
    }

    public void addRegistro(int registroId, Vuelo v, Calendar fechaDeCompra)
    {
        Registro r = new Registro(registroId, this.sillaVuelo, v, fechaDeCompra);
        this.registroPasajero.add(r);
    }
    
    public void printRegistro()
    {
        for (Registro registro : registroPasajero) 
        {
            System.out.println(registro.toString());
            
        }
    } 
    
    
    public String registroToString(int numeroRegistro)
    {
        return this.registroPasajero.getData(numeroRegistro).toString();
    } 
    
  

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", identificacion=" + identificacion + ", sillaVuelo=" + sillaVuelo + '}';
    }
    
    
    
    
    
    
}
