/*
Kevin Josué Villagrán Mérida
Ejercicio #1 
Fecha de creación: 11/08/2023 17:46
Fecha de ultima modificación: 14/08/2023 7:40
*/
import java.util.*;//Se importa java.util, que incluye Scanner y Random

public class Comprador{
    //Se definen los atributos
    private String nombre;
    private String correo;
    private float presupuesto;
    private int tickets;
    private int ticketsTotal;

    public void setNombre(String nombre){//Se define o modifica el valor del nombre
        this.nombre = nombre;
    }

    public String getNombre(){//Se obtiene el valor de nombre
        return nombre;
    }

    public void setCorreo(String correo){//Se define o modifica el valor del correo
        this.correo = correo;
    }

    public String getCorreo(){//Se obtiene el valor de correo
        return correo;
    }

    public void setPresupuesto(float presupuesto){//Se define o modifica el valor del presupuesto
        this.presupuesto = presupuesto;
    }

    public float getPresupuesto(){//Se obtiene el valor de presupuesto
        return presupuesto;
    }

    public void setTickets(int tickets){//Se define o modifica el valor de los tickets
        this.tickets = tickets;
    }

    public int getTickets(){//Se obtiene el valor de tickets
        return tickets;
    }

    public void setTicketsTotal(int ticketsTotal){//Se define o modifica el valor de los tickets totales comprados
        this.ticketsTotal = ticketsTotal;
    }

    public int getTicketsTotal(){//Se obtiene el valor de tickets totales
        return ticketsTotal;
    }

    public Comprador(String nombre, String correo, float presupuesto){//Metodo constructor donde se definen los valores de este comprador
        this.nombre = nombre;
        this.correo = correo;
        this.presupuesto = presupuesto;
    }
    
    //Decidi cambiar el tipo de este metodo de void a boolean, porque es mejor que al validar el rango me retorne un valor true para ser usado en el driver program
    public boolean comprar(){//Aqui valida si es apto o no para comprar dependiendo si el numero generado esta en el rango generado. 
        Random rand = new Random();//Se crea el objeto random para generar un numero "aleatorio"

        int num1 = 0;
        int num2 = 0;
        int num3 = 0;

        num1 = rand.nextInt(15000)+1;
        System.out.println("Su numero de orden es de: " + num1);//Se genera el numero de orden
        num2 = rand.nextInt(15000)+1;
        num3 = rand.nextInt(15000)+1;
        System.out.println("El rango para comprar es de: " + num2 + " y " + num3);//Se genera el rango

        if(num1 >= num2 && num1 <= num3 || num1 <= num2 && num1 >= num3)//Se verifica que el numero de orden este en el rango
            return true;
        else
            return false;
    }

    //Un cambio que no esta en el analisis, es este metodo, que agregue nada mas como debuggin para saber que los datos introducidos por el usuario se almacenen en la instancia
    public String toString(){//Muestra los datos del comprador
        return "Nombre del comprador: " + nombre + ", correo: " + correo + ", presupuesto: " + presupuesto + ", tickets totales: " + ticketsTotal;
    }
}