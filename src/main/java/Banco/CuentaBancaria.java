package Banco;

/**
 * Clase abstracta que proporciona los atributos necesarios para cualquier tipo
 * de cuenta bancaria genérica. Además implementa la interfaz Imprimible.
 */

/**
 *
 * @author Laura
 */
public abstract class CuentaBancaria implements Imprimible {
    
    //Se hace uso de la composición, la clase contiene un objeto de tipo Persona:
    protected Persona p;
    
    protected double saldo;//saldo que se va a introducir en la cuenta
    
    protected String iban;//número de cuenta
    
    /**
     * Método constructor
     * @param p: objeto de tipo persona
     * @param saldo: dinero que contiene la cuenta
     * @param iban: número de cuenta
     */
    public CuentaBancaria(Persona p, double saldo, String iban) {
        this.p = p;
        this.saldo = saldo;
        this.iban = iban;
    }
    
    //A continuación se han creado los métodos getter y setter:
    
    /**
     * Método getter del obtejo P de tipo Persona
     * @return objeto tipo persona
     */
    public Persona getP() {
        return p;
    }
    
    /**
     * Método getter para obtener el saldo
     * @return saldo
     */
    public double getSaldo() {
        return saldo;
    }
    
    /**
     * Método getter para obtener el IBAN
     * @return iban
     */
    public String getIban() {
        return iban;
    }
    
    /**
     * Método setter para establecer una persona
     * @param p: objeto tipo persona
     */
    public void setP(Persona p) {
        this.p = p;
    }
    
    /**
     * Método setter para establecer el saldo
     * @param saldo 
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    /**
     * Método setter para establecer el IBAN
     * @param iban 
     */
    public void setIban(String iban) {
        this.iban = iban;
    }
    
    /**
     * Implementación del método de la interfaz Imprimible. Usa el mismo método para
     * obtener el contenido del objeto tipo persona y suma la información de esta clase.
     * @return contenido de la clase CuentaBancaria (persona, saldo e IBAN)
     */
        @Override
    public String devolverInfoString() {
        
        //Se obtiene el contenido del método en la clase Persona:
        String contenido=p.devolverInfoString();
        
        contenido = contenido + "\nSaldo: " + this.saldo + "\nIBAN: " + this.iban;
                 
        return contenido;
    }
}
