/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;
import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 *
 * @author Estudiante
 */
public class MyArrayList <E> implements Iterable <E>
{
    
    /* Definicion de variables */
    private int DEFAULT_SIZE = 10;
    public int sequenceSize;
    private E[] sequence = (E[]) new Object[10];
    
    /* Costructor */
    public MyArrayList() 
    {
        this.sequenceSize = 0;
        ensureCapacity(DEFAULT_SIZE);
    }
    
    /* Metodo para asegurar la capacidad del tamaño por defecto el cual sera 10 */
    private void  ensureCapacity (int newSize)
    {
        if (newSize < sequenceSize)
        {
            return;
        }
        
        E[] oldSequence = sequence;
        E[] newSequence = (E[]) new Object[newSize]; 
        
        for (int index=0; index<sequenceSize; index++)
        {
            newSequence[index] = oldSequence[index];
        }  
        
        this.sequence = newSequence;
    }
    
    public boolean isEmpty()
    {
        return sequenceSize == 0? true:false;
    }
    
    public void add(int idx, E element)
    {
        
        if(sequence.length == sequenceSize)
        {
            ensureCapacity(sequenceSize * 2 + 1);
        }
        
        for(int index = sequenceSize; index > idx; index--)
        {
            sequence[index] = sequence[index - 1];
        }
        
        this.sequence[idx] = element;
        this.sequenceSize++;
          
    }
    
    public void add(E element)
    {
        if(sequence.length == this.sequenceSize)
        {
            ensureCapacity(this.sequenceSize * 2 + 1);
        }
        
        this.sequence[this.sequenceSize] = element;
        this.sequenceSize++;
    }
    
    public E getData(int idx)
    {
        return this.sequence[idx];
    }
    
    public void remove(int idx)
    {
        if(idx >= this.sequenceSize)
        {
            throw new ArrayIndexOutOfBoundsException();
        }else
        {   
            for (int i = idx; i < this.sequenceSize - 1; i++)
            {
                sequence[i] = sequence[i + 1];
            }
            this.sequenceSize--;
        }    
    }
    
    public int getTam()
    {
        return sequenceSize;
    }
    
    public void printArray()
    {
        for (int i = 0; i < this.sequenceSize; i++) 
        {
             System.out.println(this.getData(i));  
        }
  
        
    } 
    
    @Override 
    public Iterator iterator()
    {
        return new MyArrayListIterator();
    }
    
    /**
     * Clase MyArrayListIterator
     */
    public class MyArrayListIterator implements Iterator<E> 
    {
        private int currentPos = 0;
        
        @Override 
        public boolean hasNext()
        {
            return currentPos < sequenceSize;
        }
        
        @Override 
        public E next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException();
            }
            return sequence[currentPos++];
        }
    }
    
                
}
