// Autores: Felipe Rebollo Nro: 366552 - Martin Arismendi Nro: 353787

package inicio;
import java.util.*;
import dominio.*;


public class programa {

public static void main(String[] args) {
       
   Scanner in = new Scanner (System.in);

   Sistema unSistema = new Sistema();
   Tablero unTablero = new Tablero();
    
    System.out.println("Autores: Felipe Rebollo Nro: 366552 - Martin Arismendi Nro: 353787" + "\n");
      
   System.out.println("Inicio del obligatorio" + "\n");
   char opcion ;
      
   do {   
      System.out.println("");
      System.out.println("Eliga una de las siguientes opciones:" + "\n");
      System.out.println("a) Registrar tester");
      System.out.println("b) Registar tablero");
      System.out.println("c) Registrar testeo");
      System.out.println("d) Consulta de testers");
      System.out.println("e) Estadisticas");
      System.out.println("f) Terminar programa" + "\n");
               
      String texto = in.nextLine();

      while (texto.length() == 0) {
             System.out.println("Debe ingresar una opcion:");
             texto = in.nextLine();
      }

      opcion = Character.toLowerCase(texto.charAt(0));
          
      switch (opcion){
             
         case 'a': registrarTester (unSistema);break;
         case 'b': registrarTablero(unSistema);break;
         case 'c': registrarTesteo(unSistema);break;
         case 'd': consultaDeTesters (unSistema);break;
         case 'e': estadisticas(unSistema);break;
      } 
      
   }while (opcion != 'f');
     
      
      
      }
//--------------------------------OPCION A) REGISTRAR TESTER--------------------------------------------------------
   
public static void registrarTester (Sistema unSistema){
      
   Scanner in = new Scanner (System.in);
   String permanecer = "si";
      
   while (permanecer.equalsIgnoreCase("si"))
   {

      //Se solicita el nombree
      System.out.println("Ingrese el nombre del nuevo tester:" + "\n");
      String nombre = in.nextLine();
         
      //valido el nombre si no esta vacio y no esta respetido
      while(nombre.length() == 0|| unSistema.nombreRepetido(nombre)){
         System.out.println("El nombre esta vacio o repetido, intente nuevamente:" + "\n");
         nombre = in.nextLine();
      }

      //Se solicita la edad
      
      int edad = 0;
      boolean valido1 = false;

     while (!valido1) {
     try {
        System.out.println("Ingrese la edad del nuevo tester:"+ "\n");
        edad = in.nextInt();

         if (edad > 0) {
            valido1 = true; 
        } else {
            System.out.println("La edad debe ser positiva. Reingrese:" + "\n");
        }

    } catch (Exception e) {
        System.out.println("Debe ingresar un numero valido" + "\n");
        in.nextLine(); // 
    }
}
     //Se solicita la experiencia
      int experiencia  = 0;
      boolean valido2 = false;

     while (!valido2) {
     try {
        System.out.println("Ingrese la experiencia del nuevo tester:" + "\n");
        experiencia = in.nextInt();
        in.nextLine();

         if (experiencia >= 0 && experiencia < edad) {
            valido2 = true; 
        } else {
            System.out.println("La experiencia debe ser positiva y menor a la edad. Reingrese:" + "\n");
        }

    } catch (Exception e) {
        System.out.println("Debe ingresar un numero valido" + "\n");
        in.nextLine(); // 
    }
} 
     
     Tester nuevo = new Tester(nombre, edad, experiencia);
     unSistema.agregarTester(nuevo);
      
      System.out.println("Desea agregar un nuevo tester: (SI/NO)" + "\n");
      permanecer = in.nextLine();
      
      while (!permanecer.equalsIgnoreCase("SI") && !permanecer.equalsIgnoreCase("NO"))
      {
        System.out.println("Debe ingresar SI o NO." + "\n");
        permanecer = in.nextLine();
      }
  }
}
   
   
      
//-----------------------------------B) REGISTRAR MATRIZ---------------------------------------------------
    
      
public static void registrarTablero (Sistema unSistema){
   Scanner in = new Scanner (System.in);
   System.out.println("El tablero cargado es el siguiente:");
   System.out.println("");
   
   Tablero nuevoTablero = new Tablero (unSistema.getUltimoTablero());
           
   System.out.println(nuevoTablero.toString());
   System.out.println("");
       
   String ingresaNuevo = "";
   System.out.println("Desea ingresar un tablero diferente? (SI/NO)" );
   ingresaNuevo = in.nextLine();
   
   while (!ingresaNuevo.equalsIgnoreCase("SI") && !ingresaNuevo.equalsIgnoreCase("NO"))
    {
        System.out.println("Debe ingresar SI o NO:");
        ingresaNuevo = in.nextLine();
    }
       
   if(ingresaNuevo.equalsIgnoreCase("si")){
      String linea = "";
      System.out.println("");
      for (int i = 1 ; i <= 8 ; i++){
         System.out.println("Ingrese la linea " + i + ":");
         linea = in.nextLine().toUpperCase();

         //Valida que la linea tenga 10 caracteres y solo use B N o V
         while (!lineaValida(linea)) {
            System.out.println("Linea invalida. Debe tener 10 caracteres y solo usar B, N o V.");
            System.out.println("Ingrese la linea " + i + ":");
            linea = in.nextLine().toUpperCase();
         }
                
         nuevoTablero.setTablero(linea, i-1);
              
      } 
      unSistema.setUltimoTablero(nuevoTablero);
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
 
public static void registrarTesteo (Sistema unSistema){
   
   Scanner in = new Scanner (System.in);
   int numero = 0;
   
   Tablero unTablero = new Tablero ();
   
   // Se valida que haya testers registrados antes de hacer un testeo
   if (unSistema.getListaTester().size() == 0) {
      System.out.println("No hay testers registrados. Debe registrar un tester primero." + "\n");
   } else {
       System.out.println("Testers disponibles:" + "\n");
       
      //Se muestran los testers registrados para elegir quien realiza el testeo
      for(int i = 0; i < unSistema.getListaTester().size(); i++) {
         System.out.println( (i + 1) + " - " + unSistema.getListaTester().get(i));
      }

      //Se pide el numero del tester
       System.out.println("");
      System.out.println("Ingrese el numero del tester:" + "\n");
      int numeroTester = in.nextInt() - 1 ;

      //Se valida el numero
      while(numeroTester < 0 || numeroTester >= unSistema.getListaTester().size()) {
         System.out.println("Numero invalido. Reingrese:" + "\n");
         numeroTester = in.nextInt() - 1;  
      }

      Tester testerElegido = unSistema.getListaTester().get(numeroTester);

      do {
         System.out.println("Testeos disponibles:" + "\n");
         System.out.println("1) Contar fichas");
         System.out.println("2) Validar movimiento individual");
         System.out.println("3) Validar movimiento en grupo");
         System.out.println("4) Preparar tablero");
         System.out.println("5) Verifiar conexion");
         System.out.println("6) Volver al menu anterior" + "\n");
         System.out.println("Ingrese el numero de testeo a realizar:" + "\n");
         
         numero = in.nextInt();
         in.nextLine();
     
         switch (numero){
            case 1: 
               // Se solicita la letra
               System.out.println("Ingrese el valor a buscar (B, N o V):" + "\n");
               String aux = in.nextLine().toUpperCase();
               
               while ((!aux.equals("B") && !aux.equals("N") && !aux.equals("V")) || (aux.length() != 1))
               {
               System.out.println("Debe ingresar los valores B, N o V:" + "\n");
               aux = in.nextLine().toUpperCase();
               }
               
               char letra = aux.charAt(0);
               
               // Se calcula el resultado y se muestra
               int cantidad = Testeo.contarFichas(unTablero, letra, unSistema);
               System.out.println("El valor buscado se encuentra en " + cantidad + " celdas" + "\n");
                             
               // Se crea el testeo y se guarda en el sistema
               Testeo nuevoTesteo = new Testeo(unSistema.obtenerProximoNumeroTesteo(), testerElegido, "Contar fichas", "" + cantidad , unTablero , unTablero, "Parametro: " + letra );
               nuevoTesteo.setCometario(Testeo.agregaComentario());
               unSistema.agregarTesteo(nuevoTesteo);
               System.out.println("");
               System.out.println("Testeo agregado exitosamente." + "\n");
               break;   
               
            case 2: 
                System.out.println("");
                System.out.println("La matriz de inicio es la siguiente: " + "\n");
                System.out.println(unSistema.getUltimoTablero().toString());
                System.out.println("");
                if(Testeo.validarMovimientoIndividual(unSistema, unTablero, testerElegido))
                     {   System.out.println("");
                         System.out.println("Su movimiento es valido" + "\n");}
                      else {System.out.println("");
                            System.out.println("Su movimiento no es valido" + "\n");} 
                System.out.println("La matriz final es la siguiente: " + "\n");
                System.out.println(unSistema.getUltimoTablero().toString());
            ;break;
                      
            case 3: 
                System.out.println("");
                System.out.println("La matriz de inicio es la siguiente: " + "\n");
                System.out.println(unSistema.getUltimoTablero().toString());
                if(Testeo.validarMovimientoGrupal(unSistema, unTablero, testerElegido)){System.out.println("Su movimiento es valido. " +"\n");} 
                else {System.out.println("Su movimiento no es valido." + "\n");}
                System.out.println("La matriz final es la siguiente: " + "\n");
                System.out.println(unSistema.getUltimoTablero().toString());break;
                       
            case 4:
                 // Se muestra el tablero actual
                 System.out.println("Tablero actual:");
                 System.out.println(unSistema.getUltimoTablero().toString());
              
                 // Se guarda el testeo realizado
                 Testeo testeoTablero = new Testeo(
                 unSistema.obtenerProximoNumeroTesteo(),
                 testerElegido,
                 "Preparar tablero",
                  "Tablero mostrado",
                  unSistema.getUltimoTablero(),
                  unSistema.getUltimoTablero(),
                  "Sin parametros"
                 );
              
                 testeoTablero.setCometario(Testeo.agregaComentario());
                 unSistema.agregarTesteo(testeoTablero);
              
                 System.out.println("Testeo agregado exitosamente." + "\n");
                 break;
            case 5:
                  // Se solicita el color a verificar
                 System.out.println("Ingrese el color a verificar (B/N):");
                 String colorConexion = in.nextLine().toUpperCase();
              
                 // Valida ingreso
                 while (!colorConexion.equals("B") && !colorConexion.equals("N")) {
                    System.out.println("Debe ingresar B o N:");
                    colorConexion = in.nextLine().toUpperCase();
                 }
              
                 char color = colorConexion.charAt(0);
              
                 // Se verifica la conexion
                 boolean conectado = Testeo.verificarConexion(unSistema, color);
              
                 // Se muestra resultado
                 if (conectado){System.out.println("El color " + color + " esta conectado");} 
                 else {System.out.println("El color " + color + " no esta conectado");}
              
                 // Se guarda el testeo
                 Testeo nuevoTesteoConexion = new Testeo(
                    unSistema.obtenerProximoNumeroTesteo(),
                    testerElegido,
                    "Verificar conexion",
                    ""+ conectado,
                    unSistema.getUltimoTablero(),
                    unSistema.getUltimoTablero(),
                    "Parametro: " + color
                 );

                 nuevoTesteoConexion.setCometario(Testeo.agregaComentario());

                 unSistema.agregarTesteo(nuevoTesteoConexion);

                 break;
         }
      } while (numero != 6);
   }
}


//------------------------------D) CONSULTA DE TESTERS------------------------------------

public static void consultaDeTesters (Sistema unSistema)
 {  
    Scanner in = new Scanner (System.in);

   if (unSistema.getListaTester().size() == 0)
   {
      System.out.println("No hay testers registrados.");
   }
   else
   {
     
     // Ordena alfabeticamente el arrayLista
     Collections.sort
        (unSistema.getListaTester(), new Comparator<Tester>() 
          {
            public int compare(Tester a, Tester b) 
            {
             return a.getNombre().compareToIgnoreCase(b.getNombre());
            }
         }
        );
     
     System.out.println("Testers registrados: " + "\n");
         
    // Imprime la lista ordenada 
     for (int i = 0 ; i < unSistema.getListaTester().size(); i++)
    {
       System.out.println(i + 1 + ") " + unSistema.getListaTester().get(i).getNombre());
    }
     
     
     System.out.println("Ingrese el numero del tester a consultar: " + "\n");
     int indice  = in.nextInt() -1;
     while (indice < 0 || indice >= unSistema.getListaTester().size()) {
            System.out.println("Numero invalido. Reingrese:");
            indice = in.nextInt() - 1;
           in.nextLine();
     }
     
     
     // Del indice ingresado obtenemos el nombre del tester
     String nombre = unSistema.getListaTester().get(indice).getNombre();
      
     ArrayList <Testeo>  auxListaTesteos = new ArrayList<>();
     
     // Confeccionamos el arrayList auxiliar con los testeos del tester especificado
     for (int i = 0 ; i < unSistema.getListaTesteos().size() ; i++)
       {
         if (nombre.equals(unSistema.getListaTesteos().get(i).getTester().getNombre()))
           {
             auxListaTesteos.add(unSistema.getListaTesteos().get(i));
           
           }
       }

          if (auxListaTesteos.size() == 0)
       {
          System.out.println("El tester no tiene testeos registrados.");
       }
       else {
            System.out.println("Los testeos realizados por el tester elegido son:" + "\n");
       
     for (int i = 0 ; i < auxListaTesteos.size(); i++)
    {
       System.out.println("Testeo Nro " + auxListaTesteos.get(i).getNumero() + " - " + auxListaTesteos.get(i).getTipo() + "\n");
    }           
            
       System.out.println("Ingrese el numero de test a consultar (Numero entero):"+ "\n");
       int consulta = in.nextInt();
       in.nextLine();
       
       int indice2 = 0;
       boolean existe = false;
       
       for (int i = 0 ; i < unSistema.getListaTesteos().size() ; i++)
       {
          if (unSistema.getListaTesteos().get(i).getNumero() == consulta && unSistema.getListaTesteos().get(i).getTester().getNombre().equals(nombre))
          {
             indice2 = i;
             existe = true;
          }
       }
       
       while (!existe) {
       
          System.out.println("El testeo no pertenece al tester o no existe.");
       
          consulta = in.nextInt();
          in.nextLine();
       
          for (int i = 0 ; i < unSistema.getListaTesteos().size() ; i++)
          {
             if (unSistema.getListaTesteos().get(i).getNumero() == consulta && unSistema.getListaTesteos().get(i).getTester().getNombre().equals(nombre))
             {
                indice2 = i;
                existe = true;
             }
          }
       }
     
     System.out.println("Los datos del testeo son los siguiente:" + "\n");
     System.out.println(unSistema.getListaTesteos().get(indice2).toString());
     
             
     if (unSistema.getListaTesteos().get(indice2).getTableroInicial().mismoTablero(unSistema.getListaTesteos().get(indice2).getTableroFinal()))
      {
        System.out.println("La matriz utilizada no tuvo modificaciones y es la siguiente:" + "\n");
        System.out.println(unSistema.getListaTesteos().get(indice2).getTableroInicial().toString() + "\n");
      
      }
         
     else {
            System.out.println("El tablero inicial es: " + "\n");
            System.out.println(unSistema.getListaTesteos().get(indice2).getTableroInicial().toString() + "\n");
            System.out.println("El tablero final es: " + "\n");      
            System.out.println(unSistema.getListaTesteos().get(indice2).getTableroFinal().toString() + "\n");

                  
          }

       }
        }
       }
}

         // Muestra estadisticas de los testeos realizados
       public static void estadisticas(Sistema unSistema) {
       
          int mayorCantidad = 0;
       
      if (unSistema.getListaTester().size() >0)
      {
          // Busca la mayor cantidad de testeos realizados por un tester
          for (int i = 0; i < unSistema.getListaTester().size(); i++) {
             Tester tester = unSistema.getListaTester().get(i);
             int cantidad = 0;
       
             for (int j = 0; j < unSistema.getListaTesteos().size(); j++) {
                if (unSistema.getListaTesteos().get(j).getTester().getNombre().equalsIgnoreCase(tester.getNombre())) {
                   cantidad = cantidad + 1;
                }
             }
       
             if (cantidad > mayorCantidad) {
                mayorCantidad = cantidad;
             }
          }
       
          // Muestra los testers con mayor cantidad de testeos
          
          if (mayorCantidad > 0){
          System.out.println("Tester/s con mayor cantidad de testeos:" + "\n");
          for (int i = 0; i < unSistema.getListaTester().size(); i++) {
             Tester tester = unSistema.getListaTester().get(i);
             int cantidad = 0;
       
             for (int j = 0; j < unSistema.getListaTesteos().size(); j++) {
                if (unSistema.getListaTesteos().get(j).getTester().getNombre().equalsIgnoreCase(tester.getNombre())) {
                   cantidad = cantidad + 1;
                }
             }
       
             if (cantidad == mayorCantidad) {
                System.out.println(tester + " - Testeos: " + cantidad);
             }
          }} else {System.out.println("No se registraron testeos" + "\n");}
       
          // Muestra los testers que no realizaron testeos
          boolean noHay = true;
          System.out.println("");
          System.out.println("Tester/s sin testeos:");
          for (int i = 0; i < unSistema.getListaTester().size(); i++) {
             Tester tester = unSistema.getListaTester().get(i);
             int cantidad = 0;
       
             for (int j = 0; j < unSistema.getListaTesteos().size(); j++) {
                if (unSistema.getListaTesteos().get(j).getTester().getNombre().equalsIgnoreCase(tester.getNombre())) {
                   cantidad = cantidad + 1;
                }
             }
       
             if (cantidad == 0) {
                System.out.println(tester);
                noHay = false;
             }
          } if (noHay){
              System.out.println("");
              System.out.println("No hay registros de testers sin testeos");}
        } else {System.out.println("No hay testers registrados " + "\n");}
       }
     
    
 
 







    











}
