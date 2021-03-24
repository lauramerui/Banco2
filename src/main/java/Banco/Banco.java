package Banco;

import java.util.*;

/**
 * Esta clase contiene como atributo la estructura de datos dinámica que almacena 
 * diferentes cuentas bancarias. Se decide usar una LISTA, ya que estas permiten
 * acceder y buscar elementos de la lista, concretamente se elige usar LINKEDIST,
 * pues son más eficientes cuando se van a realizar eliminaciones en la aplicación
 * (este es el caso pues se pide implementar la opción eliminar cuenta) 
 */

/**
 *
 * @author Laura
 */
public class Banco {
    
    LinkedList<CuentaBancaria> c;
    
    /**
     * Constructor de la clase Banco. Inicializa la estructura de datos.
     */
    public Banco(){
        
        c=new LinkedList<>();//se inicializa el LinkedList

    }
    
    /**
     * Método para añadir nuevas cuentas bancarias. Recibe por parámetro un objeto 
     * CuentaBancaria y lo almacena en la estructura.
     * @param cb: objeto CuentaBancaria recibido desde la clase Principal.
     * @return true si se ha creado correctamente.
     */
    public boolean abrirCuenta(CuentaBancaria cb){
        
        c.add(cb);//se añade a la lista el objeto recibido desde la clase Principal
        
        return true;
    }

    /**
     * Devuelve un array con cadenas de texto con la información de cada cuenta(código, titular y DNI)
     */
    void listadoCuentas(){
        
        for (CuentaBancaria i: c ){//bucle para recorrer todos los objetos de la lista
      
            System.out.println("\nCódigo de cuenta: " + i.getIban() + 
                "\nTitular: " + (i.getP()).getNombre() + " " + (i.getP()).getApellidos() 
                + " con DNI: " + (i.getP()).getDni() + "\nSaldo actual: " + i.getSaldo() + "€\n");

        }
    }
    

    /**
     * Recibe un IBAN para devolver la información de dicha cuenta. Para ello compara
     * el IBAN recibido por parámetro con los de todas las cuentas creadas con un bucle
     * de tipo while. Si encuentra la coincidencia devuelve la información a través de
     * la interfaz Imprimible.
     * @param iban: número de cuenta.
     * @return información si se encuentra el IBAN en el banco, null si no se encuentra el IBAN.
     */
    String informacionCuenta(String iban){
        
        for (CuentaBancaria i: c){//bucle para recorrer los objetos de la lista
            
            if(i.getIban().equals(iban)){//se comparan los IBAN
                
                String informacion= "\nInformación de la cuenta con IBAN " + i.getIban() + ":\n" + i.devolverInfoString();
                
                return informacion;//se devuelve la información si existe la cuenta con el IBAN recibido
            }
        } 
        
        return null; //si no se encuentra el IBAN devuelve null.
    }
    
    /**
     * Recibe un IBAN y una cantidad, si encuentra una cuenta con dicho IBAN, suma
     * la cantidad al saldo de la cuenta.
     * @param iban: número de cuenta.
     * @param cantidad: cantidad de dinero que se desea ingresar en la cuenta.
     * @return true si el ingreso se ha realizado correctamente, false en caso contrario.
     */
    boolean ingresoCuenta(String iban, double cantidad){
        
        for (CuentaBancaria i: c){//bucle para recorrer todos los objetos de la lista
            
            if (i.getIban().equals(iban)){//se comparan los IBAN
                
                i.setSaldo(i.getSaldo() + cantidad);//se suma la cantidad al saldo de la cuenta encontrada
          
                return true;
            }
        }

        return false; //si no se encuentra una cuenta con el IBAN recibido devuelve false
    }
    
    /**
     * Recibe un IBAN y una cantidad, si encuentra dicho IBAN resta la cantidad al saldo de la cuenta.
     * @param iban: número de cuenta.
     * @param cantidad: cantidad de dinero que se quiere retirar de la cuenta.
     * @return true si se retira el dinero correctamente, false en caso contrario.
     */
    boolean retiradaCuenta(String iban, double cantidad){
        
        for (CuentaBancaria i: c){
            
            if(i.getIban().equals(iban)){
                
                i.setSaldo(i.getSaldo() - cantidad);//se resta la cantidad al saldo de la cuenta encontrada
                
                return true;
            }
        }
        
        return false;   
    }
    
    /**
     * Recibe un IBAN y si encuentra una cuenta con dicho IBAN devuelve su saldo.
     * @param iban
     * @return el saldo de la cuenta si es encontrada, -1 si la cuenta no existe.
     */
    double obtenerSaldo(String iban){
        
        for(CuentaBancaria i: c){
            
            if(i.getIban().equals(iban)){
                
                return i.getSaldo();//obtiene el saldo de la cuenta encontrada
            }
        
        }return -1;//devuelve valor -1 si no se ha encontrado cuenta con el IBAN introducido
    }
    
    /**
     * Método para eliminar cuenta cuyo IBAN coincide con el IBAN introducido,
     * con la condición de que el saldo de la cuenta sea 0.
     * @param iban: número de cuenta 
     * @return 1 si se elimina correctamente, 0 si no se puede eliminar porque 
     * la cuenta no tiene saldo 0 y -1 si no existe cuenta con el IBAN introducido.
     */
    int eliminaCuenta (String iban){

        for (int i=0; i<c.size();i++){
            
            if(c.get(i).getIban().equals(iban) && c.get(i).getSaldo()==0){
                
                c.remove(i);
                
                return 1;
                
            }else if(c.get(i).getIban().equals(iban) && c.get(i).getSaldo()!=0){
                
                return 0;
            }
        }
        
        return -1;
    }
       
}