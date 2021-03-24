package Banco;

/**
 * Clase que proporciona los atributos y métodos para trabajar con
 * una cuenta de ahorro. Este tipo de cuenta son remuneradas y tienen un
 * determinado tipo de interés. Hereda de la clase CuentaBancaria.
 */

/**
 *
 * @author Laura
 */
public class CuentaAhorro extends CuentaBancaria {
    
    protected String interesRem;//variable para almacenar el tipo de interés de remuneración
    
    /**
     * Método constructor que recibe los atributos de la case base y el de esta clase
     * @param p: objeto tipo persona
     * @param saldo: dinero en la cuenta
     * @param iban: número de cuenta
     * @param interesRem: tipo de interés de remuneración
     */
    public CuentaAhorro(Persona p, double saldo, String iban, String interesRem) {
        
        //Se llama al constructor de la superclase CuentaBancaria para inicializar los atributos heredados
        super(p, saldo, iban);
        
        this.interesRem = interesRem;
    }
    
    //Métodos getter y setter:
    
    /**
     * Método getter para obtener el tipo de interés
     * @return tipo de interés de remuneración
     */
    public String getInteresRem() {
        return interesRem;
    }
    
    /**
     * Método setter para establecer el tipo de interés
     * @param interesRem: tipo de interés de remuneración
     */
    public void setInteresRem(String interesRem) {
        this.interesRem = interesRem;
    }
    
    /**
     * Implementación del método de la interfaz Imprimible. Usa el mismo método para
     * obtener el contenido de la superclase y suma la información de esta clase.
     * @return contenido de un objeto tipo CuentaAhorro
     */
    @Override
     public String devolverInfoString() {
        
        //llamada al método de la clase base para sumarlo al contenido de esta
        String contenido=super.devolverInfoString();
        
        contenido=contenido + "\nTipo de interés de remuneración: " + this.interesRem + ".\n";
                 
        return contenido;
     }
}
