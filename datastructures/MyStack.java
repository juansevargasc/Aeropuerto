/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

/**
 *
 * @author Estudiante
 */
public class MyStack<E> 
{
    
    private E dato;
    private MyArrayList lista;

    public MyStack() 
    {
        lista = new MyArrayList();
    }

    public E getDato() {
        return dato;
    }

    public void setDato(E dato) {
        this.dato = dato;
    }
    
    public void push(E dato){
        lista.add(0,dato);
    }
    
    public E pop ()
    {
        E aux = (E) lista.getData(0);
        lista.remove(0);
        return aux;
        
    }
    
    
    
}
