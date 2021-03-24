package Banco;

/**
 * Clase abstracta que hereda de Cuenta Bancaria. Proporciona atributos y métodos
 * para crear cualquier tipo de cuenta corriente genérica (podrá ser personal o de empresa).
 * Todas las cuentas corrientes no son remuneradas, y tienen asociada una lista de 
 * entidades autorizadas para cobrar recibos domiciliados.
 */

/**
 *
 * @author Laura
 */
public abstract class CuentaCorriente extends CuentaBancaria {
    
    //Variable tipo String para almacenar la lista de entidades autorizadas:
    protected String entidadesAutorizadas;
    
    /**
     * Método constructor que recibe los atributos de la clase base y los de la propia clase
     * @param p: objeto tipo persona
     * @param saldo: dinero en al cuenta
     * @param iban: número de cuenta
     * @param entidadesAutorizadas: entidades autorizadas para cobrar recibos 
     */
    public CuentaCorriente(Persona p, double saldo, String iban, String entidadesAutorizadas) {
        
        //Se llama al constructor de la clase base CuentaBancaria para inicializar los atributos heredados:
        super(p, saldo, iban);
        
        this.entidadesAutorizadas = entidadesAutorizadas;
    }
    
    //Métodos getter y setter:
    
    /**
     * Método getter para obtener la lista de las entidades autorizadas
     * @return entidades autorizadas
     */
    public String getEntidadesAutorizadas() {
        return entidadesAutorizadas;
    }
    
    /**
     * Método setter para establecer las entidades autorizadas
     * @param entidadesAutorizadas 
     */
    public void setEntidadesAutorizadas(String entidadesAutorizadas) {
        this.entidadesAutorizadas = entidadesAutorizadas;
    }

     /**
     * Implementación del método de la interfaz Imprimible. Usa el mismo método para
     * obtener el contenido de la clase base y suma la información de esta clase.
     * @return contenido de un objeto tipo CuentaCorriente
     */
        @Override
     public String devolverInfoString() {

        String contenido=super.devolverInfoString();
        
        contenido=contenido + "\nEntidades autorizadas: " + this.entidadesAutorizadas;
                 
        return contenido;
     }   
}
