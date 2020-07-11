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
public class Avion 
{
    //ArrayList or the DataStructure that applies
    private MyArrayList<Silla> sillas;
    private int numSillas;
    private String aeronave; //Marca y nave: AIRBUS A320

    public Avion() 
    {
        this.aeronave = null;
        this.numSillas = 0;
        this.sillas = new MyArrayList<>();
    }
    
    public Avion(int numSillas, String marca) 
    {
        this.numSillas = numSillas;
        this.aeronave = marca;
        this.sillas = new MyArrayList<>();
    }
    
    public Avion(MyArrayList<Silla> sillas, int numSillas, String marca) 
    {
        this.sillas = sillas;
        this.numSillas = numSillas;
        this.aeronave = marca;
    }

    public MyArrayList<Silla> getSillas() {
        return sillas;
    }

    public void setSillas(MyArrayList<Silla> sillas) {
        this.sillas = sillas;
    }

    public int getNumSillas() {
        return numSillas;
    }

    public void setNumSillas(int numSillas) {
        this.numSillas = numSillas;
    }

    public String getAeronave() {
        return aeronave;
    }

    public void setAeronave(String aeronave) {
        this.aeronave = aeronave;
    }

    
    
    @Override
    public String toString() {
        return "Avion{"  + "Numero de Sillas=" + numSillas + ", aeronave=" + aeronave + '}';
    }
    
    
    
}
