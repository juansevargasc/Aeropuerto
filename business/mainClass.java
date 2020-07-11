/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import Data.*;
import GUI.Ventana;
import GUI.VentanaDirectorio;
import GUI.VentanaVuelos;
import GUI.ventanaInicio;
import datastructures.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



/**
 *
 * @author juansevargas
 */
public class mainClass 
{
    //Instancia de Hub. La clase que administra los aeropuertos
    static Hub hubApp = new Hub();

    public Hub getHubApp() {
        return hubApp;
    }

    public void setHubApp(Hub hubApp) {
        this.hubApp = hubApp;
    }
    
    
    
    /**
     * Cargar aerolineas con código. A partir de un archivo de texto con formato.
     * @param nombreArchivo
     * @param a
     * @throws FileNotFoundException 
     */
    public static void cargarAerolineas(String nombreArchivo, Aeropuerto a) throws FileNotFoundException
    {
        //Objetos de archivos
        File fichero = new File(nombreArchivo);
        Scanner s = new Scanner(fichero);
        
        //Contador de lineas del archivo
        int cont = 0;
        
        while(s.hasNextLine())
        {
            if(cont == 0)
            {
                //Si es la primera linea, corresponde entonces al nombre de la ciudad del aeropuerto.
                String nombreCiudad = s.nextLine();
                //Determina el nombre de la ciudad
                a.setCiudad(nombreCiudad);
                cont++;
            }else
            {
                //Guardar la linea del archivo
                String linea = s.nextLine();
                String[] splitLinea = linea.split(" ");

                //Posición 0: Código
                String codigo = splitLinea[0];
                //Posición 1 en adelante: Nombre
                String nombre = "";
                for (int i = 1; i < splitLinea.length; i++) 
                {
                    nombre = nombre + splitLinea[i] + " ";
                }

                //Agregación
                Aerolinea aerolinea = new Aerolinea(nombre, codigo);
                a.addAerolinea(aerolinea);
                cont++;
            }
        }
        s.close();
    }
    /**
     * Generar Sillas. Genera una lista de sillas donde hay 6 columnas con 30 filas. De la fila 0 a la 7 es clase ejectiva, el resto es económica
     * @return sillas
     */
    public static MyArrayList<Silla> generarSillas()
    {
        MyArrayList<Silla> sillas = new MyArrayList<>();
        //Estado de silla: false. Desocupado por defecto
        boolean estado = false;
        String clase;
        
        for(int i = 0; i < 30; i++){
            
            if(i < 7){
                clase = "Ejecutiva";
                }else{
                    clase = "Econonomica";
                }
            
            for(int j = 65; j < 71; j++)
            {
                int fila = i+1;
                char columna = (char) j;
                
                Silla silla = new Silla(fila, columna, clase, estado);
                sillas.add(silla);
            }
        }
        
        
        return sillas;
    }
    /**
     * Generar aviones. Genera una lista (cola) de aviones, con una lista de sillas que se agregan a cada avión.
     * @param numVuelos
     * @return aviones
     */
    public static MyQueue<Avion> generarAviones(int numVuelos)
    {
        //1. Generar arreglo de sillas
        MyArrayList<Silla> sillas = generarSillas();
        //2. Crear el objeto avión con los datos que son fijos.
        Avion avion = new Avion(sillas, sillas.getTam(), "AIRBUS A320");
        
        //Determinar numero de aviones a partir de número de vuelos
        int numeroAviones = numVuelos;
        
        
        MyQueue<Avion> aviones = new MyQueue<>();
        for(int i = 0; i < numeroAviones; i++){
            aviones.enqueue(avion);
        }
        return aviones;
        
    }
    /**
     * Asignar aviones a vuelos. Asigna un avión a cada vuelo en el aeropuerto
     * @param a
     * @throws Exception 
     */
    public static void asignarAvionesAVuelos(Aeropuerto a) throws Exception
    {
        int numAviones = a.getVuelos().tam();
        MyQueue<Avion> aviones = generarAviones(numAviones);
        for (Vuelo v : a.getVuelos())
        {
            v.setAvion(aviones.dequeue());
        }
    }
    /**
     * Leer información vuelos y derterminar la ciudad del aeropuerto. 
     * @param nombre
     * @throws FileNotFoundException 
     */
    public static MyArrayList<Vuelo> leerInformacionVuelos(String nombre, Aeropuerto a) throws FileNotFoundException, Exception
    {
        //Objetos de lectura
        File fichero = new File(nombre);
        Scanner s = new Scanner(fichero);
        
        //Estructura de datos para guardar vuelos
        MyArrayList<Vuelo> vuelos = new MyArrayList<>();
        
        //Auxiliares
        int comienzoDeHora = 0;
        int cambioDeHora = 0;
        int numVuelosSalida = 0;
        int numVuelosLlegada = 0;
        int idVuelo = 1;
        
        //Lectura archivo de texto linea por linea
        while(s.hasNextLine())
        {
            //Capturar datos. Los dos primeros caracteres son el código de la aerolinea. 
            String infoLinea = s.nextLine();
            String[] infoSplit = infoLinea.split(" ");
        
            //Posición 0: Código aerolinea
            String codigoAerolinea = infoSplit[0];
            //Obtiene la aerolinea a partir del código encontrado en el archivo de texto.
            Aerolinea aerolineaDeVuelo = a.getAerolineaPorCodigo(codigoAerolinea);
            
            //Posición 1: Número de vuelo
            String codigoDeVuelo = infoSplit[1];
            
            //Posición 2: Número de horas de duracion de vuelo.
            int duracionVuelo = Integer.parseInt(infoSplit[2]);
            
                    
            //Posición 3 en adelante(excepto la última): Nombre de la ciudad con uno o más palabras.
            //Ultima posición: Tipo de vuelo
            String ciudad = "";
            String tipoVuelo = "";
            
            //Recorrer las posiciones restantes
            for (int i = 3; i < infoSplit.length; i++) 
            {
                //Última posición donde se encuentra el tipo de vuelo
                if(infoSplit[i].equals("S") || infoSplit[i].equals("L"))
                {
                    tipoVuelo = infoSplit[i];
                    break;
                }
                //Guardar el nombre de la ciudad, y unirlo si consta de varias palabras.
                ciudad = ciudad + infoSplit[i] + " ";
                
            }
            
            //INSTANCIA VUELO
            //Instancia de vuelo según tipo. 'S' significa salida. 'L' significa llegada.
            if(tipoVuelo.equals("S"))
            {
                //Instancia de vuelo con valores capturados
                Vuelo vuelo = new Vuelo(aerolineaDeVuelo, codigoDeVuelo, a.getCiudad(), ciudad, tipoVuelo);
                
                //Instancia de horas
                Calendar horaSalida = Calendar.getInstance(); //Hora actual
                //Cambio de solo de hora, la fecha se mantiene, los minutos igualmente
                
                //La hora de llegada por default es la hora actual pero cambiara segun duracion de vuelo
                Calendar horaLlegada = Calendar.getInstance(); //Hora actual
                
                    int random = random(24);
                    //Cambio de horas
                    //Cambio de Salida
                    horaSalida.set(Calendar.HOUR_OF_DAY, random);
                    int hora2 = horaSalida.get(Calendar.HOUR_OF_DAY);
                    //hora2 += cambioDeHora;
                    
                    //Cambio de llegada (duración de vuelo)
                    int hora1 = hora2;
                    hora1 += duracionVuelo;
                    
                //Actualizar hora
                horaLlegada.set(Calendar.HOUR_OF_DAY, hora1);
                horaSalida.set(Calendar.HOUR_OF_DAY, hora2);
                
                //Actualizar los atributos de tipo Calendar
                vuelo.setHoraSalida(horaSalida);
                vuelo.setHoraLlegada(horaLlegada);
                
                //Actualizacion
                numVuelosSalida++;
                
                //Añadir idVuelo
                vuelo.setIdVuelo(idVuelo);
                //Añadir vuelo a lista de vuelos 
                vuelos.add(vuelo);
            }
            if(tipoVuelo.equals("L"))
            {
                //Instancia de vuelo con valores capturados
                Vuelo vuelo = new Vuelo(aerolineaDeVuelo, codigoDeVuelo, ciudad, a.getCiudad(), tipoVuelo);
                
                //Instancia de horas
                Calendar horaLlegada = Calendar.getInstance();
                //Cambio de solo de hora, la fecha se mantiene, los minutos igualmente
                //horaLlegada.set(Calendar.HOUR_OF_DAY, comienzoDeHora);
                //La hora de salida por defecto es la hora actual pero despues cambiara segun la duración del vuelo.
                Calendar horaSalida = Calendar.getInstance();
                
                    int random = random(24);
                    //Cambio de Salida
                    horaLlegada.set(Calendar.HOUR_OF_DAY, random);
                    int hora2 = horaLlegada.get(Calendar.HOUR_OF_DAY);
                    //hora2 += cambioDeHora;
                    
                    //Cambio de horas
                    int hora1 = hora2;
                    hora1 -= duracionVuelo;
                    
                //Actualizar hora
                horaSalida.set(Calendar.HOUR_OF_DAY, hora1);
                horaLlegada.set(Calendar.HOUR_OF_DAY, hora2);
                
                //Actualizar los atributos de tipo Calendar
                vuelo.setHoraSalida(horaSalida);
                vuelo.setHoraLlegada(horaLlegada);
                
                //Actualizacion
                numVuelosLlegada++;
                //Añadir idVuelo
                vuelo.setIdVuelo(idVuelo);
                //Añadir a la lista de vuelos
                vuelos.add(vuelo);
            }
            
            //Cambio de hora
            //cambioDeHora += 2;
            //Actualización de id
            idVuelo++;
            
        }
        
        //Actualización de numero de vuelos
        a.setNumVuelosSalida(numVuelosSalida);
        a.setNumVuelosLlegada(numVuelosLlegada);
        
        //Encolar vuelos en la cola del aeropuerto
        //a.encolarVuelos(vuelos);
        
        //Añadir a partir de una lista, los vuelos a cada aerolinea en el aeropuerto a.
        addVuelosAerolineas(vuelos, a);
        
        s.close();
        return vuelos;
    }
    /**
     * Añadir vuelos a cada aerolinea en un aeropuerto.
     * @param vuelos
     * @param a 
     */
    public static void addVuelosAerolineas( MyArrayList<Vuelo> vuelos, Aeropuerto a )
    {
        //AÑADIR VUELOS A CADA AEROLINEA
        //Los vuelos están en una lista que el método devuelve. Sin embargo aún no están guardados en el aeropuerto
        //Aquí se guardan los vuelos asignandolos a cada aerolinea, las aerolineas ya están cargadas al aeropuerto. Los vuelos ya estarán guardados indirectamente en el aeropuerto entonces, dentro de las aerolineas.
        
        
        for (Aerolinea aerolinea: a.getAerolineas())
        {
            //Guardar el código de la aerolinea en cuestión
            String codigoAero = aerolinea.getCodigoIdentificador();
            
            
            //Se recorren todos los vuelos en la lista y los que coincidan con el codigo de aerolinea se guardan en la lista de ala aerolinea
            for (Vuelo vuelo: vuelos) 
            {
                String codigoAerolineaEnVuelo = vuelo.getAerolinea().getCodigoIdentificador();
                if(codigoAero.equals(codigoAerolineaEnVuelo))
                {
                    //Añadir vuelo a la lista de la aerolinea
                    aerolinea.addVuelo(vuelo);
                    
                }                                                                     
            }
        }
        
        
    }
    
    /**
     * Leer clientes a partir de un archivo. Es función auxiliar para cargarClientes
     * @param archivo
     * @return clientes
     * @throws FileNotFoundException 
     */
    public static MyLinkedList2<Cliente> leerClientes(String archivo) throws FileNotFoundException 
    {
        //Objetos de lectura
    	File fichero = new File(archivo);
        Scanner s = new Scanner(fichero);
        
        //Estructura para guardar clientes
        MyLinkedList2<Cliente> clientes = new MyLinkedList2<>();
    	
        //Contador para idCliente
        int cont = 1000001;
        
    	while(s.hasNextLine()) 
        {
    		
    		String nombre = s.nextLine();
    		Cliente cliente = new Cliente(nombre, cont);
    		
                //Añade el cliente a la estructura
    		clientes.agregarAlFinal(cliente);
                //Aumenta el id.
    		cont++;
    	}
        s.close();
    	return clientes;
    	
    }
    
    /**
     * Carga los clientes a un aeropuerto a, a partir de un archivo.
     * @param nombreArchivo
     * @param a
     * @throws FileNotFoundException
     * @throws Exception 
     */
    public static void cargarClientes(String nombreArchivo, Aeropuerto a) throws FileNotFoundException, Exception 
    {
        //Los clientes se guardan en una LinkedList.
        MyLinkedList2<Cliente> clientes = leerClientes(nombreArchivo);
        //Asignar clientes en lista del aeropuerto
    	a.setClientes( clientes );
        
    	
    }
    
    public static String formatoHora(Calendar calendar)
    {
        String hora = "";
        Date date =  calendar.getTime();
        //SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        //String fecha = sdf.format(new Date()); 
        hora = date.getHours() + ":" + date.getMinutes();
        //System.out.println(fecha + " " + date.getHours() + ":" + date.getMinutes());
        return hora;
    }
    
    public static void pruebaFechas()
    {
        Calendar calendar = Calendar.getInstance();
        Date date =  calendar.getTime();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String fecha = sdf.format(new Date()); 
        System.out.println(fecha + " " + date.getHours() + ":" + date.getMinutes()); // 27/01/2016
        
        Calendar cal = new GregorianCalendar(2016, Calendar.AUGUST, 1, 15, 00);
        int anio = cal.get(Calendar.YEAR);
        int mes = cal.get(Calendar.MONTH);
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        int hora = cal.get(Calendar.HOUR_OF_DAY);
        int minuto = cal.get(Calendar.MINUTE);
        System.out.println("Día: " + dia + " Mes: " + (mes + 1) + " Hora: " + hora + ":" + minuto + "  Anio:" + anio);
        System.out.println("");
        Calendar cal2 = Calendar.getInstance();
        System.out.println("Hora: " + cal2.get(Calendar.HOUR_OF_DAY) + "  Mes y año y dia: " + cal2.get(Calendar.DAY_OF_MONTH));
        
    }
    
    public static void cargarEstablecimientos(String nombre, Aeropuerto a) throws FileNotFoundException{
    	
    	File fichero = new File(nombre);
        Scanner s = new Scanner(fichero);
        
        MyArrayList<Establecimiento> establecimientos = new MyArrayList<>();
        
        
        while(s.hasNextLine()) {
        	String linea = s.nextLine();
        	String[] argumentos = linea.split(" / ");
        	
        	String name = argumentos[0];
        	String tipo = argumentos[1];
        	String descripcion = argumentos[2];
        	String telefono = argumentos[3];
        	String pagina = argumentos[4];
        	
        	Establecimiento e = new Establecimiento(name, tipo, descripcion, telefono, pagina);
        	establecimientos.add(e);
        }
        s.close();
        a.setEstablecimientos(establecimientos);
    	
    }
    
    /**
     * Cargar vuelos.
     * @param nombre
     * @param a
     * @throws Exception 
     */
    public static void cargarVuelos(String nombre, Aeropuerto a) throws Exception
    {
        //Arreglo interno
        MyArrayList<Vuelo> arrayVuelos = leerInformacionVuelos(nombre, a);
        
        //LinkedList de clientes
        MyLinkedList2 linkedClientes = a.getClientes();
        
        //Carga los vuelos a la cola sin información de cliente(Información del cleinte estará null). Esto es necesario para saber cuantos vuelos habrá.
        a.encolarVuelos(arrayVuelos);
        
        //Asigna objetos de tipo avión (un avión a cada vuelo en el aeropuerto)
        asignarAvionesAVuelos(a);
        
        for (int i = 0; i < linkedClientes.getTamanio(); i++) 
        {
            //Random para vuelo (Desde 0 hasta número de vuelos)
            int r = random(arrayVuelos.getTam() - 1);
            //Random para silla  (Desde 0 hasta número de Sillas en este vuelo)
            int s = random((arrayVuelos.getData(r).getAvion().getNumSillas()) - 1);
            
            
            //Añadir cada pasajero en linkedClientes a un vuelo aleatorio
            arrayVuelos.getData(r).addCliente(a.getClientes().getValor(i));
            
            //Sillas
            MyArrayList<Silla> sillas = arrayVuelos.getData(r).getAvion().getSillas();
            Silla sillaRandom = sillas.getData(s);
            
            //Asignar silla
            a.getClientes().getValor(i).setSillaVuelo(sillaRandom);
            //Tamanio registro
            int tamanioRegistro = a.getClientes().getValor(i).sizeRegistros();
            //Fecha de compra
            Calendar fechaActual = Calendar.getInstance();
            
            //REGISTRO
            //Llenar el registro de este vuelo que acabamos de asignar
            a.getClientes().getValor(i).addRegistro(tamanioRegistro + 1, arrayVuelos.getData(r), fechaActual);
          
        }
        
        //Actualizar numero de pasajeros
        for (Vuelo vu : arrayVuelos) 
        {
            vu.actualizarNumeroClientes();
        }
        
        //Carga los vuelos a la cola con toda la información actualizada
        a.encolarVuelos(arrayVuelos);
        
        

    } 
    
    public static void cargarVuelos2(String nombre, Aeropuerto a) throws Exception
    {
        //Arreglo interno
        MyArrayList<Vuelo> arrayVuelos = leerInformacionVuelos(nombre, a);
        
        //LinkedList de clientes
        MyLinkedList2 linkedClientes = a.getClientes();
        
        //Carga los vuelos a la cola sin información de cliente(Información del cleinte estará null). Esto es necesario para saber cuantos vuelos habrá.
        a.encolarVuelos(arrayVuelos);
        
        //Asigna objetos de tipo avión (un avión a cada vuelo en el aeropuerto)
        asignarAvionesAVuelos(a);
        
        //Llenar registro
        llenarRegistro(arrayVuelos, a);

    }
    
    public static void llenarRegistro(MyArrayList<Vuelo> vuelos, Aeropuerto a) throws Exception
    {
        //Cargar información al registro de cliente según su vuelo
        for (int i = 0; i < a.getClientes().getTamanio(); i++) 
        {
            //Random para vuelo (Desde 0 hasta número de vuelos)
            int r = random(vuelos.getTam() - 1);
            //Número de sillas
            int numSillas = vuelos.getData(r).getAvion().getNumSillas();
            //Random para silla  (Desde 0 hasta número de Sillas en este vuelo)
            int s = random(numSillas - 1);
            
            //Cliente en cuestión
            Cliente c = a.getClientes().getValor(i);
            //Añadir cada pasajero en linkedClientes a un vuelo aleatorio
            vuelos.getData(r).addCliente(c);
            
            //Sillas de la aeronave del vuelo ( vuelo.getData(r) )
            MyArrayList<Silla> sillas = vuelos.getData(r).getAvion().getSillas();
            //Escoger una silla aleatoriamente
            Silla sillaRandom = sillas.getData(s);
            //Si la silla estaba ocupada, el estado es true. Mientras una silla esté ocupada, el ciclo seguirá buscando
            for (int j = 0; j <= numSillas; j++) 
            {
                if(sillaRandom.getEstado() == false)
                {
                    break;
                }else
                {
                    sillaRandom = sillas.getData(j);
                }
            }
            
            //Si no hay sillas desocupadas, se asigna null al objeto
            if(sillaRandom.getEstado() == true)
            {
                sillaRandom = null;
                
            }else
            {
                //Asignar silla
                //Asignar estado true a la silla
                sillaRandom.setEstado(true);
                c.setSillaVuelo(sillaRandom);

                //Tamanio registro
                int tamanioRegistro = c.sizeRegistros();

                //Fecha de compra
                Calendar fechaActual = Calendar.getInstance();

                //REGISTRO
                //Llenar el registro de este vuelo que acabamos de asignar en el cliente
                //c funciona?
                c.addRegistro(tamanioRegistro + 1, vuelos.getData(r), fechaActual);
            }

        }

        //Actualizar numero de pasajeros (atributo de vuelo)
        for (Vuelo vu : vuelos) 
        {
            vu.actualizarNumeroClientes();
        }
    }

    private static Silla encontrarSillaDesocuapada() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //Funcionalidades
    public MyLinkedList2<Vuelo> vuelosDeSalida()
    {
        return null;
    }
    
    public static MyQueue<Vuelo> ordenarVuelosSalida(Aeropuerto a) throws Exception
    {
        BinaryHeap<Integer> vuelosSalidaOrdenados = new BinaryHeap<>(a.getNumVuelosSalida());
        MyQueue<Vuelo> vuelosSalida = new MyQueue<>();
        
        //Recorrer vuelos
        for(Vuelo vuelo: a.getVuelos())
        {
            if(vuelo.getTipoVuelo().equals("S"))
            {
                
                int horaSalida = vuelo.getHoraSalida().get(Calendar.HOUR_OF_DAY);
                
                vuelosSalidaOrdenados.insert(horaSalida);
                
            }
        }
        
        //Ordenar vuelos por medio de BinaryHeap
        for(int i = 0; i < a.getNumVuelosSalida() ; i++)
        {
            int minHora = vuelosSalidaOrdenados.deleteMin();
            
            
            for(Vuelo vuelo: a.getVuelos()){
               if(vuelo.getTipoVuelo().equals("S")){
                   if(vuelo.getHoraSalida().get(Calendar.HOUR_OF_DAY) == minHora)
                   {
                       vuelosSalida.enqueue(vuelo);
                   }
               }
           } 
        }
        
        return vuelosSalida;
        
    }
    
    public static MyQueue<Vuelo> ordenarVuelosLlegada(Aeropuerto a) throws Exception
    {
        BinaryHeap<Integer> vuelosLlegadaOrdenados = new BinaryHeap<>(a.getNumVuelosLlegada());
        MyQueue<Vuelo> vuelosLlegada = new MyQueue<>();
        
        //Recorrer vuelos
        for(Vuelo vuelo: a.getVuelos())
        {
            if(vuelo.getTipoVuelo().equals("L"))
            {
                
                
                int horaLlegada = vuelo.getHoraLlegada().get(Calendar.HOUR_OF_DAY);
                
                vuelosLlegadaOrdenados.insert(horaLlegada);
            }
        }
        
        //Ordenar vuelos por medio de BinaryHeap
        for(int i = 0; i < a.getNumVuelosLlegada(); i++)
        {
           int minHora = vuelosLlegadaOrdenados.deleteMin();
           
           for(Vuelo vuelo: a.getVuelos()){
               if(vuelo.getTipoVuelo().equals("L"))
               {
                   if(vuelo.getHoraLlegada().get(Calendar.HOUR_OF_DAY) == minHora)
                   {
                       vuelosLlegada.enqueue(vuelo);
                   }
               }
           } 
        }
        
        return vuelosLlegada;
        
    }
    
    //No usar
    public static void ordenarVuelos(Aeropuerto a) throws Exception
    {
        //Variables internas
        MyQueue<Vuelo> llegadas = ordenarVuelosLlegada(a);
        MyQueue<Vuelo> salidas = ordenarVuelosSalida(a);
        
        //Recorrer vuelos
        for (int i = 0; i < a.getVuelos().tam(); i++) 
        {
            a.getVuelos().dequeue();
        }
        System.out.println("IsEmptyVuelos? " + a.getVuelos().isEmpty());
        for(int i = 0; i < a.getNumVuelosSalida() ; i++)
        {
            Vuelo vu = llegadas.dequeue();
            a.getVuelos().enqueue(vu);
        }
        for(int i = 0; i < a.getNumVuelosLlegada(); i++)
        {
            Vuelo vu = salidas.dequeue();
            a.getVuelos().enqueue(vu);
        }
        //a.getVuelos().
               
    }
    
    
    public static int random(int max)
    {
        int numero = (int) (Math.random() * (max + 1));
        return numero;
    }
    
    public static void imprimirTodosPasajeros(Aeropuerto a) throws Exception
    {
        for (int i = 0; i < a.getClientes().getTamanio(); i++) 
        {
            System.out.println( a.getClientes().getValor(i).toString() );
            a.getClientes().getValor(i).printRegistro();
        }

    }
    
    public static void timerApp()
    {
        
        Timer timer = new Timer();
        TimerTask tt = new TimerTask() 
        {
            public void run() 
            {
                Calendar cal = Calendar.getInstance();

                int hour = cal.get(Calendar.HOUR_OF_DAY);
                int min = cal.get(Calendar.MINUTE);
                System.out.println(hour + ":" + min);
                
            
            }   
        };
        timer.schedule(tt, 1000, 30000);
    }
    
    public static void timerAeropuerto(MyQueue<Vuelo> vuelos, VentanaVuelos vent)
    {
        
        Timer timer = new Timer();
        TimerTask tt = new TimerTask() 
        {
            public void run() 
            {
                try {
                    Vuelo v = vuelos.dequeue();
                    JOptionPane.showMessageDialog(null, "Vuelo desencolado" + "\n" + v.toString(), "Vuelo desencolado", JOptionPane.PLAIN_MESSAGE);
                    vent.rellenarTablaOrdenada(vuelos);
                    
                } catch (Exception ex) 
                {
                    Logger.getLogger(mainClass.class.getName()).log(Level.SEVERE, null, ex);
                }
            }   
        };
        timer.schedule(tt, 1000, 15000);
    }
    
    
    
    /**
     * Métodos para obtener la ubicación de aruchivos
     * @return 
     */
    public static MyArrayList<String> archivosBogota()
    {
        //1. Codigos aerolineas
        String codigosAerolinea = "/Users/juansevargas/NetBeansProjects/BorradorProyecto/src/ProjectResources/codigosAerolineas.txt";
        //2. Nombres de personas
        String nombres = "/Users/juansevargas/NetBeansProjects/BorradorProyecto/src/ProjectResources/nombres.txt";
        //3. Vuelos
        String vuelos = "/Users/juansevargas/NetBeansProjects/BorradorProyecto/src/ProjectResources/infoVuelos.txt";
        //4. Directorio
        String directorio = "/Users/juansevargas/NetBeansProjects/BorradorProyecto/src/ProjectResources/directorio.txt";
        
        MyArrayList<String> rutas = new MyArrayList<>();
        rutas.add(codigosAerolinea);
        rutas.add(nombres);
        rutas.add(vuelos);
        rutas.add(directorio);
        return rutas;
    }
    
    //Métodos para GUI
    //Métodos para Cargar Ventan Vuelos
    public static void cargarVentanaVuelos(int numeroAeropuerto)
    {
        Aeropuerto a = hubApp.getAeropuertos().getData(numeroAeropuerto);
        VentanaVuelos vent = new VentanaVuelos();
        vent.rellenarTablaVuelo(a);
        vent.setVisible(true);
    }
    
    public static void cargarVuelosOrdenadosSalida(int numeroAeropuerto) throws Exception
    {
        Aeropuerto a = hubApp.getAeropuertos().getData(numeroAeropuerto);
        VentanaVuelos vent = new VentanaVuelos();
        MyQueue<Vuelo> vuelosOrd = ordenarVuelosSalida(a);
        vent.rellenarTablaOrdenada(vuelosOrd);
        //Simular dequeue
        timerAeropuerto(vuelosOrd, vent);
 
        vent.setVisible(true);
    }
    public static void cargarVuelosOrdenadosLlegada(int numeroAeropuerto) throws Exception
    {
        Aeropuerto a = hubApp.getAeropuertos().getData(numeroAeropuerto);
        VentanaVuelos vent = new VentanaVuelos();
        MyQueue<Vuelo> vuelosOrd = ordenarVuelosLlegada(a);
        vent.rellenarTablaOrdenada(vuelosOrd);
        vent.setVisible(true);
    }
    //Metodos para cargar ventana directorio
    public static void cargarVentanaDirectorio(int numeroAeropuerto)
    {
        Aeropuerto a = hubApp.getAeropuertos().getData(numeroAeropuerto);
        
        VentanaDirectorio vent = new VentanaDirectorio();
        vent.rellenarTablaDirectorio(a);
        vent.setVisible(true);
    }
    
    //Metodos para mostrar en Ventana Usuario 
    public static String mostrarRegistro(int documento, int numeroAeropuerto) throws Exception
    {
        //Por ahora solo mostramos último registro
        Aeropuerto a = hubApp.getAeropuertos().getData(numeroAeropuerto);
        MyLinkedList2<Cliente> c = a.getClientes();
        
        for (int i = 0; i < c.getTamanio(); i++)
        {
            if(documento == c.getValor(i).getIdentificacion())
            {
                String resultado = c.getValor(i).registroToString(c.getValor(i).sizeRegistros() - 1);
                return resultado;
            }
        }
        return "0";
    }
    
    public static void motor() throws FileNotFoundException, Exception
    {
        
        //Intancia del primer Aeropuerto (Aeropuerto 0)
        Aeropuerto aeropuerto0 = new Aeropuerto();
        //Rutas de Archivos del aeropuerto 0 (Bogota)
        MyArrayList<String> rutas = archivosBogota();
        
        //Instancia del segundo Aeropuerto (Aeropuerto 1)
        Aeropuerto aeropuerto1 = new Aeropuerto();
        
        
        //1. Cargar aerolineas y determina la ciudad correspondiente a este aeropuerto. Va primero este método antes que el de cargar vuelos.
        cargarAerolineas(rutas.getData(0), aeropuerto0);
        //2. Cargar clientes
        cargarClientes(rutas.getData(1), aeropuerto0);
        //3. Cargar los vuelos -> AsinarVuelos (Carga y asigna vuelos)
        cargarVuelos2(rutas.getData(2), aeropuerto0);
        //4. Cargar establecimientos
        cargarEstablecimientos(rutas.getData(3), aeropuerto0);
        
        
        
        //Añadir aeropuerto con sus datos cargados
        hubApp.addAeropuerto(aeropuerto0);
       
        //GUI 
        //Inicio
        ventanaInicio inicio = new ventanaInicio();
        inicio.setVisible(true);
        
    }
    
    
    
    public static void main(String[] args) throws Exception
    {
        motor();
    }  
       
}
