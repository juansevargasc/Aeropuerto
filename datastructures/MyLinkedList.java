/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import java.util.Iterator;

/**
 *
 * @author Juanse
 */
public class MyLinkedList<E> implements Iterable<E> 
{
    // Clase Nodo implicita 
    private static class Node <E> 
    {
        public E data;
        public Node <E> preview;
        public Node <E> next;

        public Node(E data, Node<E> next) 
        {
            this.data = data;
            this.preview = preview;
            this.next = next;
        }
  
    }
    
        // Definicion de metodos clase MylLinkedList
        private int theSize;
        private Node <E> beginMarker;
        private Node <E> endMarker;
    
        // Costructor de Lista encadenada
        public MyLinkedList() 
        {
            doClear();
        }
    
        // Metodo para crear una lista encadenada vacia
        private void doClear()
        {
            beginMarker  = new Node <E> (null, endMarker);
            endMarker = new Node <E> (null , beginMarker);
            beginMarker.next = endMarker;
            theSize = 0;
        }
    
        // Metodos setter y getter 
        public E get (int idx)
        {
            return getNode ( idx ).data;
        }
    
        public E set (int idx, E newVal)
        {
            this.theSize++;
            Node <E> p = getNode ( idx );
            E oldVal = p.data;
            p.data = newVal;
            return oldVal;
        }
        
        public void add(E newVal)
        {
            if(this.theSize == 0)
            {
                this.theSize++;
                Node<E> a = new Node<>(newVal, this.endMarker);
                a.preview = this.beginMarker;
                //Actualización de nodos centinelas
                this.beginMarker.next = a;
                this.endMarker.preview = a;
            }else
            { 
                this.theSize++;
                Node<E> q = getNode(this.theSize - 1);
                Node <E> p = new Node<>(newVal, this.endMarker);
                
                //Actualización del penúltimo nodo
                q.next = p;
                //Actualización del último nodo
                p.preview = q;
                //Actualización de nodo centinela
                this.endMarker.preview = p;
                
                
                return;
            }
        }
    
        private Node <E> getNode(int idx)
        {
            return getNode (idx, 0, theSize - 1);
        }
    
        private Node <E> getNode (int idx, int lower, int upper)
        {
            if (idx < lower || idx > upper)
            {
                throw new IndexOutOfBoundsException();
            }
            Node <E> p;
            if (idx < theSize / 2)
            {
                p = beginMarker.next;
                for (int i = 0; i < idx; i++)
                {
                    p = p.next;
                }
            }else 
             {
                p = endMarker;
                for (int i = theSize; i > idx; i--)
                {
                    p = p.preview;
                }
             }
             return p;
        }
    
    public E nextValue (int idx)
    {
        return getNode(idx).next.data;
    }
    
    
    
    // Metodo para saber si existe un objedo dentro de la lista encadenada
    public boolean contains (E item)
    {
        Node <E> p;
        p = beginMarker.next;
        for ( int i = 0; i < theSize; i++)
        {
            if  (p.data.equals(item))
            {
                return true;
            }else 
            {
                p = p.next;  
            }
            
        }
        return false;
    }

    //Obtener tamaño
    public int size() 
    {
        return theSize;
    }
    
    
    
    
    @Override
    public Iterator<E> iterator() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
