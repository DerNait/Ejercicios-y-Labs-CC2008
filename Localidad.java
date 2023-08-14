/*
Kevin Josué Villagrán Mérida
Ejercicio #1 
Fecha de creación: 13/08/2023 17:49
Fecha de ultima modificación: 13/08/2023
*/

public class Localidad{
    private int ticketsVendidos;
    private final int espacio = 20;

    private float precio;
    private float dineroGenerado; 

    public void setTicketsVendidos(int ticketsVendidos){
        this.ticketsVendidos = ticketsVendidos;
    }

    public int getTicketsVendidos(){
        return ticketsVendidos;
    }

    public int getEspacio(){
        return espacio;
    }

    public void setPrecio(float precio){
        this.precio = precio;
    }

    public float getPrecio(){
        return precio;
    }

    public void setDineroGenerado(float dineroGenerado){
        this.dineroGenerado = dineroGenerado;
    }

    public float getDineroGenerado(){
        dineroGenerado = ticketsVendidos * precio;
        return dineroGenerado;
    }

    public boolean validarEspacio(){
        if(ticketsVendidos >= espacio){
            System.out.println("No hay espacio disponible en esta localidad");
            return false;
        }
        else{
            System.out.println("Espacio validado");
            return true;
        }   
    }

    public int validarDisponibilidad(int tickets){
        int ticketsDisponibles = espacio - ticketsVendidos;
        if(tickets > ticketsDisponibles){
            System.out.println("Solo quedan " + ticketsDisponibles + " tickets disponibles, asi que unicamente esos le venderemos");
            return ticketsDisponibles;
        }
        else
            return tickets;
    }

    public boolean validarPrecio(float presupuesto, int tickets){
        if(presupuesto >= precio * tickets){
            System.out.println("Presupuesto valido");
            return true;
        }
        
        else{
            System.out.println("Presupuesto insuficiente");
            return false; 
        }
    }

    public Localidad(float precio){
        this.precio = precio;
    }
}