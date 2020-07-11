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
public class Hub 
{
    //Or DataStructures that applie
    MyArrayList<Aeropuerto> aeropuertos;

    public Hub()
    {
        this.aeropuertos = new MyArrayList<>();
    }
    
    public Hub(MyArrayList<Aeropuerto> aeropuertos) 
    {
        this.aeropuertos = aeropuertos;
    }

    public MyArrayList<Aeropuerto> getAeropuertos() {
        return aeropuertos;
    }

    public void setAeropuertos(MyArrayList<Aeropuerto> aeropuertos) {
        this.aeropuertos = aeropuertos;
    }
    
    public void addAeropuerto(Aeropuerto a)
    {
        this.aeropuertos.add(a);
    }
    
    public void removeAeropuerto(int posicion)
    {
        this.aeropuertos.remove(posicion);
    }
    
    public int getNumeroAeropuertos()
    {
        return this.aeropuertos.getTam();
    }
}
