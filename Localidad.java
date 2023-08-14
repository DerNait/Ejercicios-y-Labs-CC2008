/*
Kevin Josué Villagrán Mérida
Ejercicio #1 
Fecha de creación: 11/08/2023 17:49
Fecha de ultima modificación: 14/08/2023 7:40
*/

public class Localidad{
    //Atributos
    private int ticketsVendidos;
    private final int espacio = 20;

    private float precio;
    private float dineroGenerado; 

    public void setTicketsVendidos(int ticketsVendidos){//Se define o modifica el valor de tickets vendidos
        this.ticketsVendidos = ticketsVendidos;
    }

    public int getTicketsVendidos(){//Se obtiene el valor de tickets vendidos
        return ticketsVendidos;
    }

    public int getEspacio(){
        return espacio;
    }

    public void setPrecio(float precio){//Se define o modifica el valor de precio
        this.precio = precio;
    }

    public float getPrecio(){//Se obtiene el valor del precio
        return precio;
    }

    public void setDineroGenerado(float dineroGenerado){//Se define o modifica el valor del dinero generado
        this.dineroGenerado = dineroGenerado;
    }

    public float getDineroGenerado(){//Se obtiene el valor de dinero generado
        dineroGenerado = ticketsVendidos * precio;//Segun los tickets vendidos, se multiplica por el precio para el dinero generado
        return dineroGenerado;
    }

    public boolean validarEspacio(){//Se valida si hay espacio en esta localidad
        if(ticketsVendidos >= espacio){
            System.out.println("No hay espacio disponible en esta localidad");
            return false;
        }
        else{
            System.out.println("Espacio validado");
            return true;
        }   
    }

    public int validarDisponibilidad(int tickets){//Se valida si hay tickets disponibles. Segun la disponibilidad seran los tickets que se venderan
        int ticketsDisponibles = espacio - ticketsVendidos;
        if(tickets > ticketsDisponibles){
            System.out.println("Solo quedan " + ticketsDisponibles + " tickets disponibles, asi que unicamente esos le venderemos");
            return ticketsDisponibles;
        }
        else
            return tickets;
    }

    public boolean validarPrecio(float presupuesto, int tickets){//Se valida que el presupuesto sea el adecuado para comprar los tickets
        if(presupuesto >= precio * tickets){
            System.out.println("Presupuesto valido");
            return true;
        }
        
        else{
            System.out.println("Presupuesto insuficiente");
            return false; 
        }
    }

    //Otro cambio que hice del analisis, es colocar un constructor de localidad, pero nada mas es para que se me facilite agregarle el precio en lugar de llamar el setPrecio a cada instancia
    public Localidad(float precio){//Constructor de localidad donde se define el precio
        this.precio = precio;
    }
}