package Banco;

/**
 * Clase Principal. Contiene el método main y el código de interacción con el usuario.
 * Muestra un menú para gestionar cuentas bancarias, por teclado se introduce lo que se desea hacer.
 * Permite abrir cuentas de diferentes tipo, consultar su información, y añadir y retirar dinero.
 */

import Util.Validaciones;
import java.util.*;

/**
 *
 * @author Laura
 */
public class Principal {
    
    static Scanner entrada= new Scanner(System.in);
    
    /**
     * Método para mostrar el menú y devolver la opción que se ha introducido por teclado.
     * @return número del 1 al 7 según la opción del menú elegida.
     */
    public static int mostrarMenu(){
        
        System.out.println("GESTIÓN DE CUENTAS BANCARIAS"); 
       
        System.out.println("1.Abrir una nueva cuenta.");
        System.out.println("2.Ver un listado de las cuentas disponibles");
        System.out.println("3.Obtener los datos de una cuenta concreta.");
        System.out.println("4.Realizar un ingreso en una cuenta.");
        System.out.println("5.Retirar efectivo de una cuenta.");
        System.out.println("6.Consultar el saldo actual de una cuenta.");
        System.out.println("7.Eliminar cuenta bancaria.");
        System.out.println("8.Salir de la aplicación.");
       
       int menu=entrada.nextInt();
       entrada.nextLine();
       
       return menu;
    }
    
    /**
     * Método main con el que se va a interaccionar con el ususario.
     * @param args 
     */
    public static void main(String[] args) {
        
        int menu; //variable para almacenar la opción seleccionada en el menú
        
        //variables para guardar la información que se va a usar para crear los objetos:
        String nombre, apellidos, dni, iban, interesRem, interesDesc, entidadesAutorizadas;
        
        double saldo, comisionMant, descubierto, comisionDesc;
        
        Banco banco=new Banco(); //se crea un objeto de tipo Banco
        
        do{//Se mostrará el menú mientras no se pulse la opción 7(Salir de la aplicación)
            
            menu=mostrarMenu();//se almacena el valor introducido en el menú en la variable menu
            
            switch (menu){
                
                case 1://Opción "Abrir una nueva cuenta"
                    
                    //Se solicita el nombre y apellidos del titular:
                    System.out.println("DATOS PERSONALES:");
                    System.out.println("Nombre:");
                    nombre=entrada.nextLine();
                    
                    System.out.println("Apellidos:");
                    apellidos=entrada.nextLine();
                    
                    //Se solicida el DNI del titular hasta que no sea válido:
                    do{
                        
                        System.out.println("DNI:");
                        dni=entrada.nextLine();
                    
                    }while(Validaciones.validarDni(dni)==false);
                    
                    //Como ya se tienen los datos personales se crea un objeto de tipo Persona:
                    Persona p=new Persona(nombre, apellidos, dni);
                    
                    //Se solicita el saldo de la cuenta hasta que sea válido (el valor no puede ser negativo)
                    do{
                        
                        System.out.println("Saldo de la cuenta:");
                        saldo=entrada.nextDouble();
                        entrada.nextLine();
                        
                    }while(Validaciones.validarSaldo(saldo)==false);
                    
                    //Se solicita el IBAN hasta que sea válido(cumpla el formato):
                    do{
                        
                        System.out.println("Número de cuenta(IBAN):");
                        iban=entrada.nextLine();
                    
                    }while(Validaciones.validarIban(iban)==false);
                    
                    /*Ahora se pregunta qué tipo de cuenta se desea abrir, según la opción se creará un tipo de
                    objeto CuentaBancaria de una subclase diferente a través del polimorfismo, pidiendo
                    los datos específicos de cada tipo de cuenta*/ 
                    System.out.println("¿Que tipo de cuenta que desea abrir? (Pulse 1, 2 o 3)");
                    System.out.println("1.Cuenta de ahorro.\n2.Cuenta corriente personal.\n3.Cuenta corriente de empresa.");
                    
                    int tipo=entrada.nextInt();
                    
                    switch(tipo){
                        case 1://Opción cuenta de ahorro
                            
                            //Se pide el dato de tipo específico para las cuentas de ahorro:
                            System.out.println("Tipo de interes de remuneración:");
                            interesRem=entrada.next();
                            
                            //Se crea el abjeto del tipo CuentaBancaria de la subclase CuentaAhorro gracias al polimorfismo:
                            CuentaBancaria cAhorro=new CuentaAhorro(p, saldo, iban, interesRem);
                            
                            //se llama al método y se manda el objeto para añadirlo al array
                            boolean b=banco.abrirCuenta(cAhorro);
                            
                            //Si la cuenta se crea correctamente (devuelve true el método) se devuelve un mensaje.
                            if(b==true){
                                System.out.println("Cuenta creada correctamente.\n");
                            }
                           
                           break;
                            
                        case 2://cuenta corriente personal
                            
                            //Se piden los datos específicos para las cuentas corrientes personales:
                            System.out.println("Entidades autorizadas:");
                            entidadesAutorizadas=entrada.next();
                            
                            System.out.println("Comisión de mantenimiento:");
                            comisionMant=entrada.nextDouble();
                            entrada.nextLine();
                            
                            //Se crea el objeto de tipo CuentaBancaria de subclase CuentaCorrientePersonal:
                            CuentaBancaria cCorrientep=new CuentaCorrientePersonal(comisionMant, entidadesAutorizadas, p, saldo, iban);
                            
                            //Se llama al método para insertarlo en la estructura
                            b=banco.abrirCuenta(cCorrientep);
                            
                            //Devuelve mensaje si se ha introducido correctamente:
                            if(b==true){
                                
                                System.out.println("Cuenta creada correctamente.\n");
                            }
                            
                            break;
                            
                        case 3://cuenta corriente de empresa
                            
                            //Se piden los datos específicos para las cuentas corriente de empresa
                            System.out.println("Entidades autorizadas:");
                            entidadesAutorizadas=entrada.next();
                            
                            System.out.println("Máximo descubierto permitido:");
                            descubierto=entrada.nextDouble();
                            entrada.nextLine();
                            
                            System.out.println("Tipo de interés por descubierto:");
                            interesDesc=entrada.nextLine();
                            
                            System.out.println("Comisión fija por cada descubierto:");
                            comisionDesc=entrada.nextDouble();
                            entrada.nextLine();
                            
                            //Se crea el objeto de tipo CuentaBancara, subtipo CuentaCorrienteEmpresa gracias al polimorfismo:
                            CuentaBancaria cCorrientee=new CuentaCorrienteEmpresa(p, saldo, iban, entidadesAutorizadas,descubierto, interesDesc, comisionDesc);
                            
                            //Se llama al método para insertar el objeto en el array:
                            b=banco.abrirCuenta(cCorrientee);
                            
                            //Devuelve mensaje de confirmación si se ha introducido correctamente:
                            if(b==true){
                                System.out.println("Cuenta creada correctamente.\n");
                            }
                            
                            break;    
                    }
                    
                    break;
                    
                    
                case 2://Ver un listado de las cuentas disponibles
                    
                    //Se llama al método para mostrar la información de todas las cuentas:
                    banco.listadoCuentas();

                    break;
                    
                case 3://Obtener los datos de una cuenta concreta.
                    
                    //Se pide el IBAN de la cuenta que se quiere saber los datos:
                    System.out.println("Introduzca IBAN:"); 
                    String buscar_iban=entrada.nextLine();
                    
                    /*Se llama al método pasando por parámetro el número IBAN introducido
                    y lo que retorna el método se almacena en la variable info*/
                    String info=banco.informacionCuenta(buscar_iban);
                    
                    /*Si devuelve null es que la cuenta no existe, se muestra un mensaje
                    para informar de ello, en caso contrario se muestra la información obtenida:*/
                    if(info==null){
                        
                        System.out.println("Cuenta no encontrada.\n");
                        
                    }else{
                        
                        System.out.println(info);
                    }

                    break;
                    
                case 4://Realizar un ingreso en una cuenta.
                    
                    //Se pide el IBAN de la cuenta en la que se quiere introducir dinero
                    System.out.println("Introduzca IBAN:");
                    buscar_iban=entrada.nextLine();
                    
                    //Se pide la cantidad que se desea introducir en la cuenta:
                    System.out.println("Introduzca cantidad a introducir:");
                    double cantidad=entrada.nextDouble();
                    entrada.nextLine();
                    
                    /*Se llama al método correspondiente pasando por parámetro el IBAN y la cantidad.
                    El valor que retorna se guarda en la variable ing. Si retorna true se muestra
                    un mensaje indicando que se ha realizado correctamente, en caso contrario avisa de 
                    que la cuenta no existe:*/
                    boolean ing=banco.ingresoCuenta(buscar_iban, cantidad);
                    
                    if(ing==true){
                        
                        System.out.println("El ingreso se ha realizado correctamente.\n");
                        
                    }else if(ing==false){
                        
                        System.out.println("El IBAN introducido no está asociado a ninguna cuenta.\n");
                    }
                    
                    break;
                      
                case 5://Retirar efectivo de una cuenta.
                    
                    //Se pide el IBAN de la cuenta en la que se desea retirar dinero
                    System.out.println("Introduzca IBAN:");
                    buscar_iban=entrada.nextLine();
                    
                    //Se pide la cantidad que se desea retirar de la cuenta:
                    System.out.println("Introduzca cantidad a retirar:");
                    cantidad=entrada.nextDouble();
                    entrada.nextLine();
                    
                    /*Se llama al método correspondiente pasando por parámetro el IBAN y la cantidad,
                    el valor que retorna se guarda en la variable ret. Si retorna true se muestra
                    un mensaje indicando que se ha realizado correctamente, en caso contrario avisa de 
                    que la cuenta no existe:*/
                    boolean ret=banco.retiradaCuenta(buscar_iban, cantidad);
                    
                        if(ret==true){
                            
                            System.out.println("La retirada se ha realizado correctamente.\n");
                        
                        }else if(ret==false){
                            
                            System.out.println("El IBAN introducido no está asociado a ninguna cuenta.\n");
                        }
                    
                    break;
                    
                case 6://Consultar el saldo actual de una cuenta.
                    
                    //Se pide el IBAN de la cuenta que se quiere consultar:
                    System.out.println("Introduzca IBAN:");
                    buscar_iban=entrada.nextLine();
                    
                    /*Se llama al método correspondiente pasando por parámetro el IBAN,
                    el valor que retorna se guarda en la variable sal. Si retorna -1 se muestra
                    un mensaje indicando que la cuenta no existe, en caso contrario muestra
                    un mensaje indicando el saldo de la cuenta:*/
                    double sal=banco.obtenerSaldo(buscar_iban);
                    
                        if(sal==-1){
                            
                            System.out.println("El IBAN introducido no está asociado a ninguna cuenta.\n");
                        
                        }else{
                            
                            System.out.println("El saldo de la cuenta con IBAN " + buscar_iban + " es de " + sal + "€\n");
                        }
                        
                        break;
                    
                case 7://Elimina una cuenta
                    
                    //Se pide el IBAN de la cuenta que se quiere eliminar:
                    System.out.println("Introduzca IBAN:");
                    buscar_iban=entrada.nextLine();
                    
                    /*Se llama al método correspondiente pasando por parámetro el IBAN,
                    el valor que retorna se guarda en la variable elim. Si retorna 1 se muestra
                    un mensaje indicando que la cuenta se ha eliminado correctamente, si retorna 0
                    avisa de que la cuenta no contiene saldo 0, si devuelve -1 informa de que la cuenta no existe.*/
                    int elim=banco.eliminaCuenta(buscar_iban);
                    
                    if(elim==1){
                        
                        System.out.println("Cuenta eliminada correctamente.\n");
                        
                    }else if (elim==0){
                        
                        System.out.println("La cuenta debe contener un saldo de 0 euros.\n");
                                                                       
                    }else if (elim==-1){
                        
                        System.out.println("El IBAN introducido no está asociado a ninguna cuenta.\n");
                    }
                    
                    break;
                    
                case 8: //Finaliza la aplicación
                    
                    System.out.println("Aplicación finalizada.");
            }
            
        }while (menu!=8);
    }
}
