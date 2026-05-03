
package inicio;
import java.util.Scanner;
import dominio.*;
import java.awt.BorderLayout;


public class programa {
   
//-----------------------------------TESTER--------------------------------------------------------
    
      public static void main(String[] args) {
       
      Sistema sistema = new Sistema();
      
      Scanner in = new Scanner (System.in);
      System.out.println("Inicio del obligatorio");
      System.out.println("");
      String permanecer = "si";
      
      while (permanecer.equalsIgnoreCase("si")){
      
      
      System.out.println("Ingrese el nombre del nuevo tester:");
      String nombre = in.nextLine();
      
      while (sistema.nombreRepetido(nombre))
      {
          System.out.println("El nombre esta repetido, intente nuevamente:");
          nombre = in.nextLine();
      }
      
      System.out.println("Ingrese la edad del nuevo tester:");
      int edad = in.nextInt();
      
      System.out.println("Ingrese la experiencia del nuevo tester:");
      int experiencia = in.nextInt();
      in.nextLine();
      
      Tester nuevo = new Tester(nombre, edad, experiencia);
      
      sistema.agregarTester(nuevo);
          
      System.out.println("Desea agregar un nuevo tester:");
      permanecer = in.nextLine();
      
      }
      
//------------------------------------MATRIZ---------------------------------------------------
    
    Tablero nuevoTablero = new Tablero (); // Se debe crear la instancia para acceder a ToString
    System.out.println("El tablero cargado por defecto es el siguiente:");
    System.out.println("");
    System.out.println(nuevoTablero.toString());
    System.out.println("");
    
    String ingresaNuevo = "";
    System.out.println("Desea ingresar un tablero diferente?");
    ingresaNuevo = in.nextLine();
    
    if(ingresaNuevo.equalsIgnoreCase("si"))
      {
       String linea = "";
       for (int i = 1 ; i <= 8 ; i++)
         {
           System.out.println("Ingrese la linea " + i + ":");
           linea = in.nextLine();
           
           nuevoTablero.setTablero(linea, i-1);
           
         } 
          System.out.println("");
          System.out.println(nuevoTablero.toString());
       }
    
    
    
    











    }















}
