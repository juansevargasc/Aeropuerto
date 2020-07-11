/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

/**
 *
 * @author juansevargas
 */

public class BinaryHeap<AnyType extends Comparable<? super AnyType>>
{
        private static final int DEFAULT_CAPACITY = 10;
        private int currentSize; // Number of elements in heap private AnyType [ ] array; // The heap array
        private AnyType[ ]array; // The heap array
        
        public BinaryHeap( )
        { 
            this( DEFAULT_CAPACITY ); 
        }
            public BinaryHeap( int capacity ) { currentSize = 0;
            array = (AnyType[]) new Comparable[ capacity + 1 ]; 
        }
            
        public void enlargeArray(int newSize)
        {
            if (newSize < currentSize)
            {
                return;
            }

            AnyType[] oldSequence = array;
            AnyType[] newSequence = (AnyType[]) new Object[newSize]; 

            for (int index = 0; index < currentSize; index++)
            {
                newSequence[index] = oldSequence[index];
            }  

            this.array = newSequence;
        }
            
        public void insert( AnyType x )
        {
            if( currentSize == array.length - 1 )
            {
                enlargeArray( array.length * 2 + 1 );
            }
                
            // Percolate up
            int hole = ++currentSize;
            for( array[ 0 ] = x; x.compareTo( array[hole/2] )<0; hole/=2 )
            array[ hole ] = array[ hole / 2 ]; array[ hole ] = x;
             
        }
        
        /**
        * Find the smallest item in the priority queue. * @return the smallest item,
        * or throw an UnderflowException if empty.
        */
        public AnyType findMin( ) throws Exception
        {
                if( isEmpty( ) )
                    throw new Exception("UnderFlowException"); 
                
                return array[ 1 ];
        }
        
        /**
        * Remove the smallest item from the priority queue.
        * @return the smallest item, throw UnderflowException if empty. */
        public AnyType deleteMin( ) throws Exception
        {
                if( isEmpty( ) )
                {
                    
                    throw new Exception("UnderFlowException");
                }
                    
                AnyType minItem = findMin( );
                array[ 1 ] = array[ currentSize-- ]; 
                percolateDown( 1 );
                return minItem;
                
         }

        public int getSize()
        {
            return this.currentSize;
        }
        
        
        /* Internal method to percolate down in the heap.
        * @param hole the index at which the percolate begins.*/
        private void percolateDown( int hole ) 
        { 
            int child;
            AnyType tmp = array[ hole ];
            for( ; hole * 2 <= currentSize; hole = child ) 
            {
                child = hole * 2;
                if(child!=currentSize && array[child+1].compareTo(array[child])<0)
                    child++;
                    if( array[ child ].compareTo( tmp ) < 0 )
                        array[ hole ] = array[ child ];
                        else break;
            }
            array[ hole ] = tmp;
        }
        
        private boolean isEmpty() 
        {
            if(this.currentSize == 0)
            {
                return true;
            }else
                return false;
        }

}

