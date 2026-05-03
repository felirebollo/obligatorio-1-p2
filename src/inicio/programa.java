
package inicio;
import java.util.Scanner;
import dominio.*;


public class programa {
   
    
      public static void main(String[] args) {
       
      Scanner in = new Scanner (System.in);

      Sistema sistema = new Sistema();
      Tablero unTablero = new Tablero();
      
      System.out.println("Inicio del obligatorio");
      System.out.println("");
      char opcion ;
      
      do 
      {   
          System.out.println("Eliga una de las siguientes opciones:");
          System.out.println("");
          System.out.println("a) Registrar tester");
          System.out.println("b) Registar tablero");
          System.out.println("c) Registrar testeo");
          System.out.println("d) Consulta de testers");
          System.out.println("e) Estadisticas");
          System.out.println("f) Terminar programa");
          System.out.println("");
          
          opcion = Character.toLowerCase(in.nextLine().charAt(0));
          
          switch (opcion)
          {
             
              case 'a': registrarTester (sistema);break;
              case 'b': registrarTablero();break;
              case 'c': registrarTesteo(unTablero);break;
              case 'd':
              case 'e':
          } 
      
      } while (opcion != 'f');
     
      
      
      }
//--------------------------------OPCION A) REGISTRAR TESTER--------------------------------------------------------
   
      public static void registrarTester (Sistema unSistema){
      
      Scanner in = new Scanner (System.in);
      String permanecer = "si";
      
      while (permanecer.equalsIgnoreCase("si")){
      
      
      System.out.println("Ingrese el nombre del nuevo tester:");
      String nombre = in.nextLine();
      
      while (unSistema.nombreRepetido(nombre))
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
      
      unSistema.agregarTester(nuevo);
          
      System.out.println("Desea agregar un nuevo tester:");
      permanecer = in.nextLine();
      
      }}
      
//-----------------------------------B) REGISTRAR MATRIZ---------------------------------------------------
    
      
      public static void registrarTablero (){
    Scanner in = new Scanner (System.in);
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
       System.out.println("");
       for (int i = 1 ; i <= 8 ; i++)
         {
           System.out.println("Ingrese la linea " + i + ":");
           linea = in.nextLine();
           
           nuevoTablero.setTablero(linea, i-1);
           
         } 
          System.out.println("");
          System.out.println("El nuevo tablero es el siguiente:");
          System.out.println("");
          System.out.println(nuevoTablero.toString());
       }}
    
 //---------------------------------C) REGISTRAR TESTEO--------------------------------------
 
 public static void registrarTesteo (Tablero unTablero)
  {
    int numero = 0;
    do 
     {
         System.out.println("");
         System.out.println("Ingrese el test a realizar:");
         System.out.println("1");
         System.out.println("2");
         System.out.println("3");
         System.out.println("4");
         System.out.println("5");
         System.out.println("6) Volver al menu anterior");
     
     switch (numero)
       {
         case 1: Testeo.contarFichas(unTablero);break;
         case 2:
         case 3:
         case 4:
         case 5:
     
       }
     } while (numero != 6);
  
  
  
  }
 
    
    











    















}
