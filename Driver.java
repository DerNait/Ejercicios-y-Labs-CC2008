/*
Kevin Josué Villagrán Mérida
Ejercicio #1 
Fecha de creación: 11/08/2023 17:44
Fecha de ultima modificación: 14/08/2023 7:40
*/
import java.util.*; //Se importa toda la libreria de java.util, que incluye Scanner y Random
import java.text.DecimalFormat; //Se importa DecimalFormat para poder colocar el dinero en el formato de dolares

public class Driver{
    public static void main(String args[]){//Programa principal
        Comprador comprador = null; //Declaramos la variable que posteriormente almacenara al objeto comprador. (Todavia no esta instanciado)
        //Creamos las 3 localidades
        Localidad localidad1 = new Localidad(100); 
        Localidad localidad2 = new Localidad(500);
        Localidad localidad3 = new Localidad(1000);

        menu(comprador, localidad1, localidad2, localidad3);//Llamamos al metodo menu para iniciar
    }

    public static void menu(Comprador comprador, Localidad localidad1, Localidad localidad2, Localidad localidad3){
        Scanner scan = new Scanner(System.in);//Creamos el scanner para que el usuario introduzca
        Random rand = new Random();//Creamos el objeto random para hacer calculos "Aleatorios"

        String seleccion = "";//Variable que servira para que el usuario escoja una opcion en el menu
        String nombre;//Nombre del comprador
        String correo;//Correo del comprador
        int tickets;//Tickets que el usuario solicita
        int ticketsComprados;//Tickets que se terminan comprando por el usuario
        int localidadActual;//Localidad a la cual sera asignado el comprador

        boolean salir = false;//Variable para el ciclo del menu que servira para salir
        boolean anException = true;//Variable que sirve para que en caso de que el usuario introduzca un valor incorrecto, se repita un ciclo hasta que introduzca el valor correcto.
        float presupuesto;//Presupuesto del comprador

        while(salir == false){//Menu
            System.out.println("\n==== ERAS TOUR ====");
            System.out.println("Bienvenido al programa de Eras Tour, ¿que desea hacer?");
            System.out.println("1. Nuevo comprador");
            System.out.println("2. Nueva solicitud de boletos");
            System.out.println("3. Consultar disponibilidad total");
            System.out.println("4. Consultar disponibilidad individual");
            System.out.println("5. Reporte de caja");
            System.out.println("6. Salir\n");

            seleccion = scan.nextLine();//Seleccion almacena la entrada del teclado del usuario
            switch(seleccion){//Depende de lo que el usuario escoja, se haran diferentes cosas
            case "1"://Opcion 1
                System.out.println("\n=== NUEVO COMPRADOR ===");
                System.out.println("Ingrese su nombre:");
                nombre = scan.nextLine();//El usuario introduce su nombre
                System.out.println("Ingrese su correo");
                correo = scan.nextLine();//El usuario introduce su correo
                System.out.println("Ingrese su presupuesto (dolares)");
                presupuesto = Float.parseFloat(scan.nextLine());//El usuario ingresa su presupuesto

                comprador = new Comprador(nombre, correo, presupuesto);//Se crea el comprador con base a los datos introducidos anteriormente
                System.out.println(comprador.toString());//Se muestra los datos de este comprador registrado
                break;
            case "2"://Opcion 2
                System.out.println("\n=== SOLICITUD DE BOLETOS ===");
                if(comprador == null){//Si el comprador todavia no existe, se le piden sus datos y se crea el comprador
                    System.out.println("\n=== NUEVO COMPRADOR ===");
                    System.out.println("Ingrese su nombre:");
                    nombre = scan.nextLine();
                    System.out.println("Ingrese su correo");
                    correo = scan.nextLine();
                    System.out.println("Ingrese su presupuesto (dolares)");
                    presupuesto = Float.parseFloat(scan.nextLine());

                    comprador = new Comprador(nombre, correo, presupuesto);
                    System.out.println(comprador.toString());
                }
                
                do{
                System.out.println("\nIngrese la cantidad de tickets que desea comprar");//Se le pide al comprador cuantos tickets desea comprar
                    try{//Se asegura que el valor introducido sea un valor numerico y no algo mas
                        tickets = Integer.parseInt(scan.nextLine());
                        comprador.setTickets(tickets);
                        anException = false;
                    }catch(Exception e){//Si el usuario introduce un valor incorrecto, el ciclo se repetira hasta que coloque un valor valido.
                        System.out.println("\nIntroduzca un valor numerico valido");
                        anException = true;
                    }
                } while(anException);

                if(comprador.comprar() != true){//Si el numero del usuario no esta en el rango generado, no se puede comprar
                    System.out.println("No se pudo comprar");

                    System.out.println("\nPresione enter para continuar...");
                    scan.nextLine();//El programa continua hasta que el usuario presiona enter
                    break;
                }
                System.out.println("Procediendo a comprar...");//Si el numero del usuario esta en el rango generado, procedemos a las otras validaciones

                localidadActual = rand.nextInt(3)+1;//Se escoge una localidad aleatoria
                switch(localidadActual){
                    case 1://Localidad 1
                        System.out.println("Sera asignado a la localidad 1");
                        if(localidad1.validarEspacio() == true && localidad1.validarPrecio(comprador.getPresupuesto(), comprador.getTickets()) == true){//Si pasa las validaciones, procede a ver cuantos tickets comprar
                            ticketsComprados = localidad1.validarDisponibilidad(comprador.getTickets());//Segun la disponibilidad, sera la cantidad de tickets a comprar
                            System.out.println("Se han comprado exitosamente " + ticketsComprados + " tickets en la localidad 1");//Se compra exitosamente
                            localidad1.setTicketsVendidos(localidad1.getTicketsVendidos()+ticketsComprados);//Se agregan los tickets vendidos a la localidad
                            comprador.setPresupuesto(comprador.getPresupuesto()-(localidad1.getPrecio()*ticketsComprados)); //Se le resta presupuesto al usuario
                        }else
                        System.out.println("No se han cumplido las condiciones para comprar en esta localidad, compra fallida");//Si falla, no continua con la compra

                        System.out.println("\nPresione enter para continuar...");
                        scan.nextLine();//El programa continua hasta que el usuario presiona enter
                        break;
                    case 2://Localidad 2
                        System.out.println("Sera asignado a la localidad 2");
                        if(localidad2.validarEspacio() == true && localidad2.validarPrecio(comprador.getPresupuesto(), comprador.getTickets()) == true){//Si pasa las validaciones, procede a ver cuantos tickets comprar
                            ticketsComprados = localidad2.validarDisponibilidad(comprador.getTickets());//Segun la disponibilidad, sera la cantidad de tickets a comprar
                            System.out.println("Se han comprado exitosamente " + ticketsComprados + " tickets en la localidad 2");//Se compra exitosamente
                            localidad2.setTicketsVendidos(localidad2.getTicketsVendidos()+ticketsComprados);//Se agregan los tickets vendidos a la localidad
                            comprador.setPresupuesto(comprador.getPresupuesto()-(localidad2.getPrecio()*ticketsComprados));//Se le resta presupuesto al usuario
                        }else
                        System.out.println("No se han cumplido las condiciones para comprar en esta localidad, compra fallida");//Si falla, no continua con la compra

                        System.out.println("\nPresione enter para continuar...");
                        scan.nextLine();//El programa continua hasta que el usuario presiona enter
                        break;
                    case 3://Localidad 3
                        System.out.println("Sera asignado a la localidad 3");
                        if(localidad3.validarEspacio() == true && localidad3.validarPrecio(comprador.getPresupuesto(), comprador.getTickets()) == true){//Si pasa las validaciones, procede a ver cuantos tickets comprar
                            ticketsComprados = localidad3.validarDisponibilidad(comprador.getTickets());//Segun la disponibilidad, sera la cantidad de tickets a comprar
                            System.out.println("Se han comprado exitosamente " + ticketsComprados + " tickets en la localidad 3");//Se compra exitosamente
                            localidad3.setTicketsVendidos(localidad3.getTicketsVendidos()+ticketsComprados);//Se agregan los tickets vendidos a la localidad
                            comprador.setPresupuesto(comprador.getPresupuesto()-(localidad3.getPrecio()*ticketsComprados));//Se le resta presupuesto al usuario
                        }else
                        System.out.println("No se han cumplido las condiciones para comprar en esta localidad, compra fallida");//Si falla, no continua con la compra

                        System.out.println("\nPresione enter para continuar...");
                        scan.nextLine();//El programa continua hasta que el usuario presiona enter
                        break;
                }

                break;
            case "3":
                System.out.println("\n=== DISPONIBILIDAD TOTAL ===");//Se muestra las disponibilidad total de cada localidad
                System.out.println("\n==>LOCALIDAD 1:");//Localidad 1
                System.out.println("Cantidad de boletos vendidos en total: " + localidad1.getTicketsVendidos());//Se muestran la cantidad de boletos vendidos en total de localidad 1
                System.out.println("Cantidad de boletos disponibles: " + (localidad1.getEspacio() - localidad1.getTicketsVendidos()));//Se muestran la cantidad de boletos disponibles de localidad 1

                System.out.println("\n==>LOCALIDAD 2:");//Localidad 2
                System.out.println("Cantidad de boletos vendidos en total: " + localidad2.getTicketsVendidos());//Se muestran la cantidad de boletos vendidos en total de localidad 2
                System.out.println("Cantidad de boletos disponibles: " + (localidad2.getEspacio() - localidad2.getTicketsVendidos()));//Se muestran la cantidad de boletos disponibles de localidad 2

                System.out.println("\n==>LOCALIDAD 3:");//Localidad 3
                System.out.println("Cantidad de boletos vendidos en total: " + localidad3.getTicketsVendidos());//Se muestran la cantidad de boletos vendidos en total de localidad 3
                System.out.println("Cantidad de boletos disponibles: " + (localidad3.getEspacio() - localidad3.getTicketsVendidos()));//Se muestran la cantidad de boletos disponibles de localidad 3

                System.out.println("\nPresione enter para continuar...");
                scan.nextLine();//El programa continua hasta que el usuario presiona enter
                break;
            case "4":
                int seleccionarLocalidad = 0;//Variable que permitira al usuario escoger una localidad
                System.out.println("\n=== DISPONIBILIDAD INDIVIDUAL ===");//Se muestra la disponibilidad individual segun la localidad escogida
                do{
                System.out.println("\nIngrese el numero de la localidad que desea ver su disponibilidad");//Menu para escoger localidad
                System.out.println("\n1. Localidad 1");
                System.out.println("2. Localidad 2");
                System.out.println("3. Localidad 3");
                    try{
                        seleccionarLocalidad = Integer.parseInt(scan.nextLine());
                        anException = false;
                    }catch(Exception e){
                        System.out.println("\nIntroduzca un valor numerico valido");
                        anException = true;
                    }
                } while(anException);//El ciclo se repite hasta que el usuario ingrese un valor numerico valido

                switch(seleccionarLocalidad){
                    case 1:
                        System.out.println("\n==>LOCALIDAD 1:");
                        System.out.println("Cantidad de boletos disponibles: " + (localidad1.getEspacio() - localidad1.getTicketsVendidos()));//Se muestran la cantidad de boletos disponibles de localidad 1

                        System.out.println("\nPresione enter para continuar...");
                        scan.nextLine();//El programa continua hasta que el usuario presiona enter
                        break;
                    case 2:
                        System.out.println("\n==>LOCALIDAD 2:");
                        System.out.println("Cantidad de boletos disponibles: " + (localidad2.getEspacio() - localidad2.getTicketsVendidos()));//Se muestran la cantidad de boletos disponibles de localidad 2

                        System.out.println("\nPresione enter para continuar...");
                        scan.nextLine();//El programa continua hasta que el usuario presiona enter
                        break;
                    case 3:
                        System.out.println("\n==>LOCALIDAD 3:");
                        System.out.println("Cantidad de boletos disponibles: " + (localidad3.getEspacio() - localidad3.getTicketsVendidos()));//Se muestran la cantidad de boletos disponibles de localidad 3

                        System.out.println("\nPresione enter para continuar...");
                        scan.nextLine();//El programa continua hasta que el usuario presiona enter
                        break;
                    default:
                        System.out.println("Ingrese un valor numerico valido entre 1 a 3, regresando al menu...");

                        System.out.println("\nPresione enter para continuar...");
                        scan.nextLine();//El programa continua hasta que el usuario presiona enter
                }
                break;
            case "5":
                DecimalFormat decimalF = new DecimalFormat("$###,###.00");//Se define el formato de como se mostrara el dinero generado
                String totalVendidoFormat = decimalF.format(localidad1.getDineroGenerado()+localidad2.getDineroGenerado()+localidad3.getDineroGenerado());//Se suma la cantidad de dinero generado en cada localidad
                System.out.println("\n=== REPORTE DE CAJA ===");
                System.out.println("Se ha vendido un total de: " + totalVendidoFormat);//Se muestra el reporte de caja de la cantidad de dinero total generado por las 3 localidades juntas

                System.out.println("\nPresione enter para continuar...");
                scan.nextLine();//El programa continua hasta que el usuario presiona enter
                break;
            case "6"://Salir
                System.out.println("¡Hasta pronto!");//Despedidda
                salir = true;//Se termina el ciclo
                break;
            default:
                System.out.println("Por favor introduzca un valor numerico valido entre 1 a 6");//En caso de que introduzca un valor fuera del rango de 1 a 6.
            }
        }
    }
}
