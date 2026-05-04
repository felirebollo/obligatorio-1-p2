
package inicio;
import java.util.*;
import dominio.*;


public class programa {

public static void main(String[] args) {
       
   Scanner in = new Scanner (System.in);

   Sistema sistema = new Sistema();
   Tablero unTablero = new Tablero();
      
      
   System.out.println("Inicio del obligatorio");
   System.out.println("");
   char opcion ;
      
   do {   
      System.out.println("");
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
          
      switch (opcion){
             
         case 'a': registrarTester (sistema);break;
         case 'b': registrarTablero(unTablero);break;
         case 'c': registrarTesteo(sistema, unTablero);break;
         case 'd': consultaDeTesters (sistema);break;
         case 'e':
      } 
      
   }while (opcion != 'f');
     
      
      
      }
//--------------------------------OPCION A) REGISTRAR TESTER--------------------------------------------------------
   
public static void registrarTester (Sistema unSistema){
      
   Scanner in = new Scanner (System.in);
   String permanecer = "si";
      
   while (permanecer.equalsIgnoreCase("si")){

      //Se solicita el nombree
      System.out.println("Ingrese el nombre del nuevo tester:");
      String nombre = in.nextLine();
         
      //valido el nombre si no esta vacio y no esta respetido
      while(nombre.length() == 0|| unSistema.nombreRepetido(nombre)){
         System.out.println("El nombre esta vacio o repetido, intente nuevamente:");
         nombre = in.nextLine();
      }

      //Se eolicita la edada
      System.out.println("Ingrese la edad del nuevo tester:");
      int edad = in.nextInt();

      //Se valida la edad
      while (edad <= 0) {
         System.out.println("La edad debe ser positiva. Reingrese:");
         edad = in.nextInt();
      }

      //Se solicita la experiencia
      System.out.println("Ingrese la experiencia del nuevo tester:");
      int experiencia = in.nextInt();
         
      //Se valida que sea positica y que sea mayor o igual a la edad(lo aclara en la rubrica )
      while(experiencia < 0 || experiencia >= edad){
         System.out.println("Edad invalida, ingrese nuevamente:");
         experiencia = in.nextInt();
      }

      in.nextLine();

      Tester nuevo = new Tester(nombre, edad, experiencia);
      unSistema.agregarTester(nuevo);
             
      System.out.println("Desea agregar un nuevo tester:");
      permanecer = in.nextLine();
         
      }
}
   
   
      
//-----------------------------------B) REGISTRAR MATRIZ---------------------------------------------------
    
      
public static void registrarTablero (Tablero nuevoTablero){
   Scanner in = new Scanner (System.in);
   System.out.println("El tablero cargado por defecto es el siguiente:");
   System.out.println("");
   System.out.println(nuevoTablero.toString());
   System.out.println("");
       
   String ingresaNuevo = "";
   System.out.println("Desea ingresar un tablero diferente?");
   ingresaNuevo = in.nextLine();
       
   if(ingresaNuevo.equalsIgnoreCase("si")){
      String linea = "";
      System.out.println("");
      for (int i = 1 ; i <= 8 ; i++){
         System.out.println("Ingrese la linea " + i + ":");
         linea = in.nextLine();

         //Valida que la linea tenga 10 caracteres y solo use B N o V
         while (!lineaValida(linea)) {
            System.out.println("Linea invalida. Debe tener 10 caracteres y solo usar B, N o V.");
            System.out.println("Ingrese la linea " + i + ":");
            linea = in.nextLine();
         }
                
         nuevoTablero.setTablero(linea, i-1);
              
      } 
      System.out.println("");
      System.out.println("El nuevo tablero es el siguiente:");
      System.out.println("");
      System.out.println(nuevoTablero.toString());
   }
}

// Verifica que una linea de la matriz sea valida
public static boolean lineaValida(String linea) {
   boolean esValida = true;

   if (linea.length() != 10) {
      esValida = false;
   } else {
      for(int i = 0; i < linea.length(); i++) {
         char letra = Character.toUpperCase(linea.charAt(i));

         if (letra != 'B' && letra != 'N' && letra != 'V') {
            esValida = false;
         } 
      }
   }
   return esValida;
}
    
 //---------------------------------C) REGISTRAR TESTEO--------------------------------------
 
public static void registrarTesteo (Sistema unSistema, Tablero unTablero){
   Scanner in = new Scanner (System.in);
   int numero = 0;
   
   // Se valida que haya testers registrados antes de hacer un testeo
   if (unSistema.getListaTester().size() == 0) {
      System.out.println("No hay testers registrados. Debe registrar un tester primero.");
   } else {

      //Se muestran los testers registrados para elgir quien realiza el testeo
      for(int i = 0; i < unSistema.getListaTester().size(); i++) {
         System.out.println(i + " - " + unSistema.getListaTester().get(i));
      }

      //Se pide el numero del tester
      System.out.println("Ingrese el numero del tester:");
      int numeroTester = in.nextInt();

      //Se valida el numero
      while(numeroTester < 0 || numeroTester >= unSistema.getListaTester().size()) {
         System.out.println("Numero invalido. Reingrese:");
         numeroTester = in.nextInt();  
      }

      Tester testerElegido = unSistema.getListaTester().get(numeroTester);

      do {
         System.out.println("");
         System.out.println("Ingrese el test a realizar:");
         System.out.println("1) Contar fichas");
         System.out.println("2) Validar movimiento individual");
         System.out.println("3) Validar movimiento en grupo");
         System.out.println("4) Preparar tablero");
         System.out.println("5) Verifiar conexion");
         System.out.println("6) Volver al menu anterior");
         System.out.println("");
         
         numero = in.nextInt();
         in.nextLine();
     
         switch (numero){
            case 1: 
               // Se solicita la letra
               System.out.println("Ingrese el valor a buscar (B, N o V):");
               char letra = Character.toUpperCase(in.nextLine().charAt(0));
               
               // Se calcula el resultado y se muestra
               int cantidad = Testeo.contarFichas(unTablero, letra);
               System.out.println("El valor buscado se encuentra en " + cantidad + " celdas");
               
               // Se crea el testeo y se guarda en el sistema
               Testeo nuevoTesteo = new Testeo(unSistema.obtenerProximoNumeroTesteo(), testerElegido, "Contar fichas", "" + cantidad , unTablero , unTablero);
               nuevoTesteo.setCometario(Testeo.agregaComentario());
               unSistema.agregarTesteo(nuevoTesteo);
              
               break;   
               
            case 2:
            case 3:
            case 4:
            case 5:
         }
      } while (numero != 6);
   }
}


//------------------------------D) CONSULTA DE TESTERS------------------------------------

public static void consultaDeTesters (Sistema unSistema)
 {  
     Scanner in = new Scanner (System.in);
     Collections.sort
        (unSistema.getListaTester(), new Comparator<Tester>() 
          {
            public int compare(Tester a, Tester b) 
            {
             return a.getNombre().compareToIgnoreCase(b.getNombre());
            }
         }
        );
     
     System.out.println("Testers registrados: ");
     System.out.println("");
   
     for (int i = 0 ; i < unSistema.getListaTester().size(); i++)
    {
       System.out.println(i + ") " + unSistema.getListaTester().get(i).getNombre());
    }
     
     
     System.out.println("Ingrese el numero del tester a consultar: ");
     
     int indice  = in.nextInt();
     String nombre = unSistema.getListaTester().get(indice).getNombre();
      
     ArrayList <Testeo>  auxListaTesteos = new ArrayList<>();
     
     for (int i = 0 ; i < unSistema.getListaTesteos().size() ; i++)
       {
         if (nombre.equals(unSistema.getListaTesteos().get(i).getTester().getNombre()))
           {
             auxListaTesteos.add(unSistema.getListaTesteos().get(i));
           
           }
       }
     
     Collections.sort
        (auxListaTesteos, new Comparator<Testeo>() 
          {
            public int compare(Testeo a, Testeo b) 
            {
             return a.getNumero() - b.getNumero();
            }
         }
        );
     System.out.println("Los testeos realizdos por el tester elegido son:");
     System.out.println("");
     
     for (int i = 0 ; i < auxListaTesteos.size(); i++)
    {
       System.out.println("Testeo Nro " + auxListaTesteos.get(i).getNumero() + " - " + auxListaTesteos.get(i).getTipo());
    }           
      
     System.out.println("Ingrese el numero de teste a consultar (Numero entero):");
     int consulta = in.nextInt();
     int indice2 = 0;
     
     for (int i = 0 ; i < auxListaTesteos.size() ; i++)
       {
         if (auxListaTesteos.get(i).getNumero() == consulta){indice2 = i;}
       
       } 
     
     System.out.println(auxListaTesteos.get(indice2).toString());
     
    
 
 
 }










    











}
