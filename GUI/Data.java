/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JOptionPane;

/**
 *
 * @author juansevargas
 */
public class Data 
{
    String name;
    Integer age;
    
    
    public Data()
    {
        this.name = "";
        this.age = 0;
    }
    
    public void capturarDatos()
    {
        this.name = Ventana.Nombre.getText();
        this.age = Integer.parseInt( Ventana.Edad.getText() );
    }
    
    public void imprimirDatos()
    {
        JOptionPane.showMessageDialog(null, "El nombre capturado es: " + this.name + 
                "\nLa edad de la persona es: " + this.age, "Message", JOptionPane.PLAIN_MESSAGE);
        
    }
}
