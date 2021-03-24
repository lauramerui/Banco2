package Banco;

/**
 * Clase que proporciona los atributos y métodos necesarios para trabajar con una 
 * cuenta de corriente personal. Hereda de la clase CuentaCorriente (que a la vez 
 * hereda de la clase CuentaBancaria). 
 * Las cuentas corrientes personales tienen una comisión de mantenimiento (una cantidad
 * fija anual)
 */

/**
 *
 * @author Laura
 */
public class CuentaCorrientePersonal extends CuentaCorriente {
    
    //variable que almacena la comisión de mantenimiento:
    protected double comisionMant; 
    
    /**
     * Método constructor que recibe los atributos de las superclases y de la propia clase
     * @param comisionMant: comisión de mantenimiento
     * @param entidadesAutorizadas: entidades autorizadas para cobrar recibos 
     * @param p: objeto tipo persona (incluye datos personales del titular)
     * @param saldo: dinero en la cuenta
     * @param iban: número de cuenta
     */
    public CuentaCorrientePersonal(double comisionMant, String entidadesAutorizadas, Persona p, double saldo, String iban) {
        
        //Se llama al constructor de las superclases (CuentaBancaria y CuentaCorriente) para inicializar los atributos heredados:
        super(p, saldo, iban, entidadesAutorizadas);
        
        this.comisionMant = comisionMant;
    }
    
    //Métodos getter y setter:
    
    /**
     * Método getter para obtener la comisión de mantenimiento
     * @return comisión de mantenimiento
     */
    public double getComisionMant() {
        return comisionMant;
    }
    
    /**
     * Método setter para establecer la comisión de mantenimiento
     * @param comisionMant 
     */
    public void setComisionMant(double comisionMant) {
        this.comisionMant = comisionMant;
    }
    
     /**
     * Implementación del método de la interfaz Imprimible. Usa el mismo método para
     * obtener el contenido de las superclases y suma la información de esta clase.
     * @return contenido de un objeto tipo CuentaCorrientePersonal
     */
    @Override
    public String devolverInfoString() {

        String contenido = super.devolverInfoString();
        
        contenido= contenido + "\nComisión de mantenimiento: " + this.comisionMant + ".\n";
                 
         return contenido;
    }
}
