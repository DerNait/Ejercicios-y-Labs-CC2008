/*
Kevin Josué Villagrán Mérida
Ejercicio #1 
Fecha de creación: 13/08/2023 17:44
Fecha de ultima modificación: 13/08/2023
*/
import java.util.*;
import java.text.DecimalFormat;

public class Driver{
    public static void main(String args[]){
        Comprador comprador = null;
        Localidad localidad1 = new Localidad(100);
        Localidad localidad2 = new Localidad(500);
        Localidad localidad3 = new Localidad(1000);

        menu(comprador, localidad1, localidad2, localidad3);
    }

    public static void menu(Comprador comprador, Localidad localidad1, Localidad localidad2, Localidad localidad3){
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        String seleccion = "";
        String nombre;
        String correo;
        int tickets;
        int ticketsComprados;
        int localidadActual;

        boolean salir = false;
        boolean anException = true;
        float presupuesto;

        while(salir == false){
            System.out.println("\n==== ERAS TOUR ====");
            System.out.println("Bienvenido al programa de Eras Tour, ¿que desea hacer?");
            System.out.println("1. Nuevo comprador");
            System.out.println("2. Nueva solicitud de boletos");
            System.out.println("3. Consultar disponibilidad total");
            System.out.println("4. Consultar disponibilidad individual");
            System.out.println("5. Reporte de caja");
            System.out.println("6. Salir\n");

            seleccion = scan.nextLine();
            switch(seleccion){
            case "1":
                System.out.println("\n=== NUEVO COMPRADOR ===");
                System.out.println("Ingrese su nombre:");
                nombre = scan.nextLine();
                System.out.println("Ingrese su correo");
                correo = scan.nextLine();
                System.out.println("Ingrese su presupuesto");
                presupuesto = Float.parseFloat(scan.nextLine());

                comprador = new Comprador(nombre, correo, presupuesto);
                System.out.println(comprador.toString());
                break;
            case "2":
                System.out.println("\n=== SOLICITUD DE BOLETOS ===");
                if(comprador == null){
                    System.out.println("\n=== NUEVO COMPRADOR ===");
                    System.out.println("Ingrese su nombre:");
                    nombre = scan.nextLine();
                    System.out.println("Ingrese su correo");
                    correo = scan.nextLine();
                    System.out.println("Ingrese su presupuesto");
                    presupuesto = Float.parseFloat(scan.nextLine());

                    comprador = new Comprador(nombre, correo, presupuesto);
                    System.out.println(comprador.toString());
                }
                
                do{
                System.out.println("\nIngrese la cantidad de tickets que desea comprar");
                    try{
                        tickets = Integer.parseInt(scan.nextLine());
                        comprador.setTickets(tickets);
                        anException = false;
                    }catch(Exception e){
                        System.out.println("\nIntroduzca un valor numerico valido");
                        anException = true;
                    }
                } while(anException);

                if(comprador.comprar() != true){
                    System.out.println("No se pudo comprar");

                    System.out.println("\nPresione enter para continuar...");
                    scan.nextLine();
                    break;
                }
                System.out.println("Procediendo a comprar...");

                localidadActual = rand.nextInt(3)+1;
                switch(localidadActual){
                    case 1:
                        System.out.println("Sera asignado a la localidad 1");
                        if(localidad1.validarEspacio() == true && localidad1.validarPrecio(comprador.getPresupuesto(), comprador.getTickets()) == true){
                            ticketsComprados = localidad1.validarDisponibilidad(comprador.getTickets());
                            System.out.println("Se han comprado exitosamente " + ticketsComprados + " tickets en la localidad 1");
                            localidad1.setTicketsVendidos(localidad1.getTicketsVendidos()+ticketsComprados);
                            comprador.setPresupuesto(comprador.getPresupuesto()-(localidad1.getPrecio()*ticketsComprados));
                        }else
                        System.out.println("No se han cumplido las condiciones para comprar en esta localidad, compra fallida");

                        System.out.println("\nPresione enter para continuar...");
                        scan.nextLine();
                        break;
                    case 2:
                        System.out.println("Sera asignado a la localidad 2");
                        if(localidad2.validarEspacio() == true && localidad2.validarPrecio(comprador.getPresupuesto(), comprador.getTickets()) == true){
                            ticketsComprados = localidad2.validarDisponibilidad(comprador.getTickets());
                            System.out.println("Se han comprado exitosamente " + ticketsComprados + " tickets en la localidad 2");
                            localidad2.setTicketsVendidos(localidad2.getTicketsVendidos()+ticketsComprados);
                            comprador.setPresupuesto(comprador.getPresupuesto()-(localidad2.getPrecio()*ticketsComprados));
                        }else
                        System.out.println("No se han cumplido las condiciones para comprar en esta localidad, compra fallida");

                        System.out.println("\nPresione enter para continuar...");
                        scan.nextLine();
                        break;
                    case 3:
                        System.out.println("Sera asignado a la localidad 3");
                        if(localidad3.validarEspacio() == true && localidad3.validarPrecio(comprador.getPresupuesto(), comprador.getTickets()) == true){
                            ticketsComprados = localidad3.validarDisponibilidad(comprador.getTickets());
                            System.out.println("Se han comprado exitosamente " + ticketsComprados + " tickets en la localidad 3");
                            localidad3.setTicketsVendidos(localidad3.getTicketsVendidos()+ticketsComprados);
                            comprador.setPresupuesto(comprador.getPresupuesto()-(localidad3.getPrecio()*ticketsComprados));
                        }else
                        System.out.println("No se han cumplido las condiciones para comprar en esta localidad, compra fallida");

                        System.out.println("\nPresione enter para continuar...");
                        scan.nextLine();
                        break;
                }

                break;
            case "3":
                System.out.println("\n=== DISPONIBILIDAD TOTAL ===");
                System.out.println("\n==>LOCALIDAD 1:");
                System.out.println("Cantidad de boletos vendidos en total: " + localidad1.getTicketsVendidos());
                System.out.println("Cantidad de boletos disponibles: " + (localidad1.getEspacio() - localidad1.getTicketsVendidos()));

                System.out.println("\n==>LOCALIDAD 2:");
                System.out.println("Cantidad de boletos vendidos en total: " + localidad2.getTicketsVendidos());
                System.out.println("Cantidad de boletos disponibles: " + (localidad2.getEspacio() - localidad2.getTicketsVendidos()));

                System.out.println("\n==>LOCALIDAD 3:");
                System.out.println("Cantidad de boletos vendidos en total: " + localidad3.getTicketsVendidos());
                System.out.println("Cantidad de boletos disponibles: " + (localidad3.getEspacio() - localidad3.getTicketsVendidos()));

                System.out.println("\nPresione enter para continuar...");
                scan.nextLine();
                break;
            case "4":
                int seleccionarLocalidad = 0;
                System.out.println("\n=== DISPONIBILIDAD INDIVIDUAL ===");
                do{
                System.out.println("\nIngrese el numero de la localidad que desea ver su disponibilidad");
                System.out.println("\n1. Localidad 1");
                System.out.println("\n2. Localidad 2");
                System.out.println("\n3. Localidad 3");
                    try{
                        seleccionarLocalidad = Integer.parseInt(scan.nextLine());
                        anException = false;
                    }catch(Exception e){
                        System.out.println("\nIntroduzca un valor numerico valido");
                        anException = true;
                    }
                } while(anException);

                switch(seleccionarLocalidad){
                    case 1:
                        System.out.println("\n==>LOCALIDAD 1:");
                        System.out.println("Cantidad de boletos disponibles: " + (localidad1.getEspacio() - localidad1.getTicketsVendidos()));

                        System.out.println("\nPresione enter para continuar...");
                        scan.nextLine();
                        break;
                    case 2:
                        System.out.println("\n==>LOCALIDAD 2:");
                        System.out.println("Cantidad de boletos disponibles: " + (localidad2.getEspacio() - localidad2.getTicketsVendidos()));

                        System.out.println("\nPresione enter para continuar...");
                        scan.nextLine();
                        break;
                    case 3:
                        System.out.println("\n==>LOCALIDAD 3:");
                        System.out.println("Cantidad de boletos disponibles: " + (localidad3.getEspacio() - localidad3.getTicketsVendidos()));

                        System.out.println("\nPresione enter para continuar...");
                        scan.nextLine();
                        break;
                }
                break;
            case "5":
                DecimalFormat decimalF = new DecimalFormat("$###,###.00");
                String totalVendidoFormat = decimalF.format(localidad1.getDineroGenerado()+localidad2.getDineroGenerado()+localidad3.getDineroGenerado());
                System.out.println("\n=== REPORTE DE CAJA ===");
                System.out.println("Se ha vendido un total de: " + totalVendidoFormat);

                System.out.println("\nPresione enter para continuar...");
                scan.nextLine();
                break;
            case "6":
                System.out.println("¡Hasta pronto!");
                salir = true;
                break;
            default:
                System.out.println("Por favor introduzca un valor numerico valido entre 1 a 6");
            }
        }
    }
}
