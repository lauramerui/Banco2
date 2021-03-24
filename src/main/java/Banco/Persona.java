package Banco;

/**
 * Clase para trabajar con los datos personales, contiene los datos personales 
 * básicos del cliente (nombre, apellidos, DNI). Esta clase se usará para crear 
 * objetos que se incluirán en los objetos de tipo CuentaBancaria.
 */

/**
 *
 * @author Laura
 */
public class Persona implements Imprimible {
    
    String nombre;
    
    String apellidos;
    
    String dni;

    /**
     * Método constructor que inicializa los atributos
     * @param nombre: nombre del cliente
     * @param apellidos: apellidos del cliente
     * @param dni: DNI del cliente
     */
    public Persona(String nombre, String apellidos, String dni) {
        
        this.nombre = nombre;
        
        this.apellidos = apellidos;
        
        this.dni = dni;
    }

    //Métodos getter y setter:
    
    /**
     * Método getter para obtener el nombre
     * @return nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Método setter para establecer el nombre del usuario
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Método getter para obtener los apellidos del usuario
     * @return apellidos del usuario 
     */
    public String getApellidos() {
        return apellidos;
    }
    
    /**
     * Método setter para establecer los apellidos del cliente
     * @param apellidos 
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    /**
     * Método getter para obtener el DNI del cliente
     * @return 
     */
    public String getDni() {
        return dni;
    }
    
    /**
     * Método setter para establecer el DNI del cliente
     * @param dni 
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
    * Implementación del método de la interfaz Imprimible. 
    * Devuelve una cadena de carácteres con la información de la persona (nombre, apellidos, dni)
    * @return contenido de la clase Persona (nombre, apellidos, dni)
    */
    @Override
    public String devolverInfoString() {
        
        String contenido="Nombre: " + this.nombre + " Apellidos: " + this.apellidos + " DNI: " + this.dni;
        
        return contenido;
    }    
}
