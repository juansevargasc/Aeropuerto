/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author juansevargas
 */
public class Establecimiento 
{
    private String nombre;
    private String tipo;
    private String descripcion;
    private String telefono;
    private String paginaWeb;
    private int codigoId;

    public Establecimiento() 
    {
        this.codigoId = 0;
        this.nombre = null;
        this.tipo = null;
        this.descripcion = null;
        this.telefono = null;
        this.paginaWeb = null;
    }
    
    public Establecimiento(String name, String type, String description, String tel, String page) 
    {
        this.nombre = name;
        this.tipo = type;
        this.descripcion = description;
        this.telefono = tel;
        this.paginaWeb = page;
        this.codigoId = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public int getCodigoId() {
        return codigoId;
    }

    public void setCodigoId(int codigoId) {
        this.codigoId = codigoId;
    }

    @Override
    public String toString() {
        return "Establecimiento{" + "nombre=" + nombre + ", tipo=" + tipo + ", descripcion=" + descripcion + ", telefono=" + telefono + ", paginaWeb=" + paginaWeb + ", codigoId=" + codigoId + '}';
    }
    
    
    
    
    
    
    
}
