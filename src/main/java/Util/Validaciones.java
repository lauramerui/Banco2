/**
 *Clase para validar los datos introducidos en la clase Principal. 
 */
package Util;

import java.util.regex.*;

/**
 *
 * @author Laura
 */
public class Validaciones {
    
    /**
     * Método que valida el formato del IBAN, debe contener "ES" + 20 números
     * @param iban: número de cuenta
     * @return true si el IBAN es válido, false en caso contrario
     */
    public static boolean validarIban (String iban){
        
        boolean validarIban=true;
        
        Pattern a=Pattern.compile("ES[0-9]{20}");
                    
            Matcher b=a.matcher(iban);
                    
            if (b.matches()){ 
                        
                return validarIban;
                    
            }else{ 
                    
                validarIban=false;
                    
                System.out.println("Error: número IBAN incorrecto.");
                    
            }return validarIban;             
    }
    
    /**
    * Método que valida que el formato del DNI es correcto.
    * @param numDni: número de DNI introducido al crear el vehículo
    * @return true si es válido, false en caso contrario.
    */
    public static boolean validarDni (String numDni){
        
        boolean validarDni;
        
            Pattern p=Pattern.compile("[0-9]{8}[A-Za-z]"); //expresión regular que determina el formato.
                    
            Matcher m=p.matcher(numDni);//se compara el valor introducido con el patrón.
                    
                if (m.matches()){ 
                        
                    validarDni=true;
                    
                }else{ 
                    
                    validarDni=false;
                            
                    System.out.println("Error: DNI incorrecto.");
                }
                
            return validarDni;
    }
    
    /**
     * Método que valida el saldo de una nueva cuenta bancaria (no puede tener un valor negativo)
     * @param saldo: dinero de la cuenta
     * @return true si es válido, false en caso contrario
     */
    public static boolean validarSaldo (double saldo){
        
        boolean validarSaldo=true;
        
        if(saldo<0){
            
            validarSaldo=false;
            
            System.out.println("Error: el saldo no puede ser negativo.");
        }

            return validarSaldo;
    }
}
