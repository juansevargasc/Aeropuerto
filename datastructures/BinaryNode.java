/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

/**
 *
 * @author juansevargas
 *
 */
public class BinaryNode<E> implements Comparable<BinaryNode>
{

    private E dato;
    private BinaryNode<E> hijoIzq;
    private BinaryNode<E> hijoDer;

    public BinaryNode() {
        this.dato = null;
        this.hijoIzq = null;
        this.hijoDer = null;
    }

    public BinaryNode(E dato, BinaryNode<E> hijoIzq, BinaryNode<E> hijoDer) {
        this.dato = dato;
        this.hijoIzq = hijoIzq;
        this.hijoDer = hijoDer;
    }

    //Getters
    public E getDato() {
        return dato;
    }

    public BinaryNode<E> getHijoIzq() {
        return hijoIzq;
    }

    public BinaryNode<E> getHijoDer() {
        return hijoDer;
    }

    //Setters
    public void setDato(E dato) {
        this.dato = dato;
    }

    public void setHijoIzq(BinaryNode<E> hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public void setHijoDer(BinaryNode<E> hijoDer) {
        this.hijoDer = hijoDer;
    }

    //toString

    @Override
    public String toString() 
    {
        return "BinaryNode{" + "dato=" + dato + ", hijoIzq=" + hijoIzq + ", hijoDer=" + hijoDer + '}';
    }


    @Override
    public int compareTo(BinaryNode otherNode) 
    {
        if(( (String)otherNode.dato).equals(otherNode) )
        {
            return 0;
        }else
        {
            return 1;
        }
    }
    
    
}
