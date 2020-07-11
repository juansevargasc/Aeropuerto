/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;


import datastructures.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author juansevargas
 */
public class Aeropuerto 
{
    //Or DataStructures that applie
    private MyArrayList<Aerolinea> aerolineas;
    private MyArrayList<Establecimiento> establecimientos;
    private MyQueue<Vuelo> vuelos;
    private MyLinkedList2<Cliente> clientes;
    private String ciudad;
    private int numVuelosSalida;
    private int numVuelosLlegada;

       
    public Aeropuerto(String ciudad)
    {
        this.aerolineas = new MyArrayList<>();
        this.establecimientos = new MyArrayList<>();
        this.vuelos = new MyQueue<>();
        this.ciudad = ciudad;
        this.numVuelosLlegada = 0;
        this.numVuelosSalida = 0;
    }
    
    public Aeropuerto() 
    {
        this.aerolineas = new MyArrayList<>();
        this.establecimientos = new MyArrayList<>();
        this.vuelos = new MyQueue<>();
        this.ciudad = null;
        this.numVuelosLlegada = 0;
        this.numVuelosSalida = 0;
    }

    public MyLinkedList2<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(MyLinkedList2<Cliente> clientes) {
        this.clientes = clientes;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    public void addAerolinea(Aerolinea ar)
    {
        this.aerolineas.add(ar);
    }
    /**
     * Encolar vuelo
     * @param v 
     */
    public void encolarVuelo(Vuelo v)
    {
        this.vuelos.enqueue(v);
    } 

    public MyArrayList<Aerolinea> getAerolineas() 
    {
        return aerolineas;
    }

    public int getNumeroAerolineas()
    {
        return this.aerolineas.getTam();
    }
    
    public MyArrayList<Establecimiento> getEstablecimientos() 
    {
        return establecimientos;
    }

    public MyQueue<Vuelo> getVuelos() {
        return vuelos;
    }
    
    
    
    public boolean hayVuelos()
    {
        return !(this.vuelos.isEmpty());
    }
    
    //Setters
    public void setAerolineas(MyArrayList<Aerolinea> aerolineas) {
        this.aerolineas = aerolineas;
    }

    public void setEstablecimientos(MyArrayList<Establecimiento> establecimientos) {
        this.establecimientos = establecimientos;
    }

    public int getNumVuelosSalida() {
        return numVuelosSalida;
    }

    public void setNumVuelosSalida(int numVuelosSalida) {
        this.numVuelosSalida = numVuelosSalida;
    }

    public int getNumVuelosLlegada() {
        return numVuelosLlegada;
    }

    public void setNumVuelosLlegada(int numVuelosLlegada) {
        this.numVuelosLlegada = numVuelosLlegada;
    }
    
    
    
    
    
    
    
    /**
     * Encolar vuelos en cola de aeropuerto.
     * @param vuelos 
     */
    public void encolarVuelos(MyArrayList<Vuelo> vuelos)
    {
        //Añadir vuelos a cola
        for (Vuelo v: vuelos) 
        {
            encolarVuelo(v);
        }
    }
    
    //Codigo ANdrés
    public static MyLinkedList2<Cliente> leerClientes(String archivo) throws FileNotFoundException 
    {
    	
    	File fichero = new File(archivo);
        Scanner s = new Scanner(fichero);
    	MyLinkedList2<Cliente> clientes = new MyLinkedList2<>();
    	
        int cont = 1000001;
    	while(s.hasNextLine()) 
        {
    		
    		String nombre = s.nextLine();
    		Cliente cliente = new Cliente(nombre, cont);
    		
    		clientes.agregarAlFinal(cliente);
    		cont++;
    	}
   
		s.close();
    	return clientes;
    	
    }
    
    
    public Aerolinea getAerolineaPorCodigo(String codigo) 
    {
        //Aerolinea aero = new Aerolinea();
        for (Aerolinea aerolinea : this.aerolineas) 
        {
            if( codigo.equals(aerolinea.getCodigoIdentificador()) )
                return aerolinea;
        }
        return null;
        
    }

    public void setVuelos(MyQueue<Vuelo> vuelos) 
    {
        this.vuelos = vuelos;
    }
    
    
    
    //IMPRESION
    //Imprimir aerolineas de aeropuerto
    public void imprimirAerolineas()
    {
        for (Aerolinea aerolinea : this.aerolineas) 
        {
            System.out.println(aerolinea.toString());
        }
    } 
    
    //Imprimir vuelos
    public void imprimirVuelos() throws Exception
    {
        System.out.println("Vuelos: " + this.vuelos.tam());
        for (Vuelo v : this.vuelos) {
            System.out.println(v.toString());
            v.getPasajeros().printArray();
            System.out. println("#Pasajeros: " + v.getPasajeros().getTam() + "\n");
        }
    }
    
    public void impVuelos2() throws Exception
    {
        int tamCola = this.vuelos.tam();
        for (int i = 0; i < tamCola; i++) {
            System.out.println( this.vuelos.dequeue().toString() );
        }
    }
    
    
}
