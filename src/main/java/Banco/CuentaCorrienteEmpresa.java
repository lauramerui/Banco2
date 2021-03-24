package Banco;

/**
 * Clase que propociona los atributos y métodos necesarios para trabajar con una 
 * cuenta de corriente de empresa. Este tipo de cuenta no tiene comisión de mantenimiento
 * y permiten tener una cantidad de descubierto, y por tanto un tipo de interés 
 * por descubierto y una comisión fija por cada descubierto. 
 * Hereda de la clase CuentaCorriente (que hereda de la clase CuentaBancaria)
 */

/**
 *
 * @author Laura
 */
public class CuentaCorrienteEmpresa extends CuentaCorriente {
    
    protected double descubierto;//máximo descubierto permitido
    
    protected String interesDesc; //tipo de interés por descubierto
    
    protected double comisionDesc;//comisión fija por cada descubierto que se tenga
    
    /**
     * Método constructor que recibe los atributos de las superclases y de la propia clase
     * @param p: objeto tipo persona (incluye datos personales del titular)
     * @param saldo: dinero en la cuenta
     * @param iban: número de cuenta
     * @param entidadesAutorizadas: : entidades autorizadas para cobrar recibos 
     * @param descubierto: máximo descubierto permitido
     * @param interesDesc: tipo de interés por descubierto
     * @param comisionDesc: comisión fija por descubierto
     */
    public CuentaCorrienteEmpresa(Persona p, double saldo, String iban, String entidadesAutorizadas, 
            double descubierto, String interesDesc, double comisionDesc) {
        
//Se llama al constructor de las superclases (CuentaBancaria y CuentaCorriente) para inicializar los atributos heredados:
        super(p, saldo, iban, entidadesAutorizadas);
        
        this.descubierto = descubierto;
        this.interesDesc = interesDesc;
        this.comisionDesc = comisionDesc;
    }
    
    //Métodos getter y setter:
    
    /**
     * Método getter para obtener el máximo descubierto permitido
     * @return máximo descubierto permitido
     */
    public double getDescubierto() {
        return descubierto;
    }
    
    /**
     * Método setter para establecer el máximo descubierto permitido
     * @param descubierto 
     */
    public void setDescubierto(double descubierto) {
        this.descubierto = descubierto;
    }
    
    /**
     * Método getter para obtener el tipo de interés por descubierto
     * @return tipo de interés por descubierto
     */
    public String getInteresDesc() {
        return interesDesc;
    }
    
    /**
     * Método setter para establecer el tipo de interés por descubierto
     * @param interesDesc 
     */
    public void setInteresDesc(String interesDesc) {
        this.interesDesc = interesDesc;
    }
    
    /**
     * Método getter para obtener la comisión fija por descubierto
     * @return comisión fija por descubierto
     */
    public double getComisionDesc() {
        return comisionDesc;
    }
    
    /**
     * Método setter para establecer la comisión fija por descubierto
     * @param comisionDesc 
     */
    public void setComisionDesc(double comisionDesc) {
        this.comisionDesc = comisionDesc;
    }

    /**
    * Implementación del método de la interfaz Imprimible. Usa el mismo método para
    * obtener el contenido de las superclases y suma la información de esta clase.
    * @return contenido de un objeto tipo CuentaCorrienteEmpresa
    */
    @Override
    public String devolverInfoString() {

        String contenido = super.devolverInfoString();
        
        contenido= contenido + "\nMáximo descubierto permitido " + this.descubierto + "\nTipo de interés por descubierto: " 
               + this.interesDesc + "\nComisión fija por descubierto: " + this.comisionDesc + ".\n";
                 
         return contenido;
    } 
}
