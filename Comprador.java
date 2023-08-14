/*
Kevin Josué Villagrán Mérida
Ejercicio #1 
Fecha de creación: 13/08/2023 17:46
Fecha de ultima modificación: 13/08/2023
*/
import java.util.*;

public class Comprador{
    private String nombre;
    private String correo;
    private float presupuesto;
    private int tickets;
    private int ticketsTotal;

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }

    public String getCorreo(){
        return correo;
    }

    public void setPresupuesto(float presupuesto){
        this.presupuesto = presupuesto;
    }

    public float getPresupuesto(){
        return presupuesto;
    }

    public void setTickets(int tickets){
        this.tickets = tickets;
    }

    public int getTickets(){
        return tickets;
    }

    public void setTicketsTotal(int ticketsTotal){
        this.ticketsTotal = ticketsTotal;
    }

    public int getTicketsTotal(){
        return ticketsTotal;
    }

    public Comprador(String nombre, String correo, float presupuesto){
        this.nombre = nombre;
        this.correo = correo;
        this.presupuesto = presupuesto;
    }
    
    public boolean comprar(){
        Random rand = new Random();

        int num1 = 0;
        int num2 = 0;
        int num3 = 0;

        num1 = rand.nextInt(15000)+1;
        System.out.println("Su numero de orden es de: " + num1);
        num2 = rand.nextInt(15000)+1;
        num3 = rand.nextInt(15000)+1;
        System.out.println("El rango para comprar es de: " + num2 + " y " + num3);

        if(num1 >= num2 && num1 <= num3 || num1 <= num2 && num1 >= num3)
            return true;
        else
            return false;
    }

    public String toString(){
        return "Nombre del comprador: " + nombre + ", correo: " + correo + ", presupuesto: " + presupuesto + ", tickets totales: " + ticketsTotal;
    }
}