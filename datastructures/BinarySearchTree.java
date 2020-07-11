package datastructures;

/**
 *
 * @author juansevargas
 */
public class BinarySearchTree<T extends Comparable<? super T>>
{
    private static class BinaryNode<T>
    {
        T element; //The data in the node
        BinaryNode<T> left;
        BinaryNode<T> right;

        public BinaryNode() 
        {
            this.element = null;
            this.left = null;
            this.right = null;
        }

        //Getters Setters
        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public BinaryNode<T> getLeft() {
            return left;
        }

        public void setLeft(BinaryNode<T> left) {
            this.left = left;
        }

        public BinaryNode<T> getRight() {
            return right;
        }

        public void setRight(BinaryNode<T> right) {
            this.right = right;
        }
        
        
        
    }
    
    private BinaryNode<T> root; //Raiz
    
    
}
