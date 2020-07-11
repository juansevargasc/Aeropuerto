/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Estudiante
 * @param <E>
 */
public class MyQueue<E> implements Iterable<E>
{
    MyLinkedList2 cola;
    private int tam = 0;

    public MyQueue() 
    {
        this.cola = new MyLinkedList2();
    }
    
    public int tam (){
        return this.tam;
    }
    
    public void enqueue(E dato){
        cola.agregarAlFinal(dato);
        tam++;
    }
    
    public E dequeue () throws Exception
    {
        if (!cola.esVacia())
        {
            return dequeue(0);
        }else 
        {
           return (E)"Ya no hay mas datos"; 
        }
        
    }
    
    public E dequeue(int valor) throws Exception
    {
        E a = (E) cola.getValor(valor);
        
        if (!cola.esVacia())
        {
            cola.removerPorPosicion(valor);
        }
        tam--;
        return a;
    }
    
    public E peek() throws Exception
    {
        E a = (E) cola.getValor(0);
        return a;
    }

    public boolean isEmpty()
    {
        return (this.tam == 0);
    }
    
    
    @Override
    public Iterator<E> iterator() 
    {
        return new MyQueueListIterator();
    }
    

    /**
     * Clase 
     */
    public class MyQueueListIterator implements Iterator<E> 
    {
        private int currentPos = 0;
        
        @Override 
        public boolean hasNext()
        {
            return currentPos < tam;
        }
        
        @Override 
        public E next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException();
            }
            try 
            {
                return (E) cola.getValor(currentPos++);
            }catch (Exception ex) 
            {
                Logger.getLogger(MyQueue.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {
            Iterator.super.forEachRemaining(action); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void remove() {
            Iterator.super.remove(); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
