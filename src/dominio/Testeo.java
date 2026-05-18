// Autores: Felipe Rebollo Nro: 366552 - Martin Arismendi Nro: 353787

package dominio;

import java.util.Scanner;

public class Testeo {
    private int numero;
    private Tester tester;
    private String tipo;
    private String resultado;
    private String comentario;  
    private Tablero tableroInicial;
    private Tablero tableroFinal;
    private String parametro;

    public Testeo(int unNumero, Tester unTester, String unTipo, String unResultado, Tablero tableroInicial, Tablero tableroFinal, String parametro) {
        this.setNumero(unNumero);
        this.setTester(unTester);
        this.setTipo(unTipo);
        this.setResultado(unResultado);
        this.setTableroInicial(tableroInicial);
        this.setTableroFinal(tableroFinal);
        this.setParametro(parametro);
    }

    
    public int getNumero() {
        return numero;
    }
    
    public void setNumero(int unNumero) {
        numero = unNumero;
    }
    
    public Tester getTester() {
        return tester;
    }
    
    public void setTester(Tester unTester) {
        tester = unTester;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String unTipo) {
        tipo = unTipo;
    }
    
    public String getResultado() {
        return resultado;
    }
    
    public void setResultado(String unResultado) {
        resultado = unResultado;
    }
    
    public Tablero getTableroInicial () {
      return tableroInicial;
    }
    
    public Tablero getTableroFinal() {
     return tableroFinal;
    }
    
    public String getComentario () {
     return comentario;
    }
    
    public void setComentario (String unComentario){
      comentario = unComentario;
    }
    
    public void setTableroInicial (Tablero unTablero){
      tableroInicial = unTablero;
    }
    
    public void setTableroFinal (Tablero unTablero){
      tableroFinal = unTablero;
    }
    
    public void setParametro (String unParametro){
    parametro = unParametro;
   }
    
    public String getParametro (){
    return parametro;
   }
    
    @Override
    public String toString() {
        return "Testeo Nro: " + this.getNumero() + " -  Tipo de testeo: " + this.getTipo() + " - Tester: " + this.getTester().getNombre() + " - Resultado: " + this.getResultado() +" - "+ this.getParametro() + " - Comentario: " + this.getComentario() ;
    }
    
    public static int contarFichas (char letra, Sistema unSistema){  
       
        int contador = 0 ;
        
        Tablero unTablero = new Tablero(unSistema.getUltimoTablero());
        
        System.out.println(unTablero.toString());
        for (int i = 0 ; i < 8 ; i++) {
           for (int j = 0 ; j < 10 ; j++){
               if (unTablero.getValorCelda(i,j) == letra){
                   contador++;
               }
             }
          }
        
             
        return contador;
     }
    
    public static String agregaComentario(){   
        Scanner in = new Scanner (System.in);
        String comentario = "";
       
        System.out.println("");
        System.out.println("Desde agregar un comentario? (Si / No)" );
        String respuesta = in.nextLine();
       
       while (!respuesta.equalsIgnoreCase("si") && !respuesta.equalsIgnoreCase("no")) 
       {
        System.out.println("");
        System.out.println("Debe ingresar SI o NO:");  
        respuesta = in.nextLine();
        }
       
       if (respuesta.equalsIgnoreCase("si"))
         {   
             System.out.println("");
             System.out.println("Ingrese su comentario:");
             comentario = in.nextLine();
         } 
         else {comentario = "Sin comentarios";}
       
         return comentario;
    
    }
    
    public static boolean validarMovimientoIndividual(Sistema unSistema, Tablero unTablero, Tester testerElegido){
    
    Scanner in = new Scanner (System.in);
    boolean valido = true;
    
    unTablero = new Tablero (unSistema.getUltimoTablero());
    
    String color = "";
    String sentido = "";
    int fila = 0;
    int columna = 0;
    int pasos = 0;
        
     
    
    System.out.println("Ingrese el color de la ficha a mover (B / N):" + "\n");
    color = in.nextLine().toUpperCase();
     
     while (!color.equals("B") && !color.equals("N")) 
     {
        System.out.println("Debe ingresar el valor B o N :" + "\n");
        color = in.nextLine().toUpperCase();
     }

         
    
     String sentidos = "";
     if (color.equals("B")){sentidos = "(N, NE, NO, E, O)";} else {sentidos = " (S, SO, SE, E, O)";}
     
     System.out.println("Ingrese el sentido del movimiento" + sentidos);
     sentido = in.nextLine().toUpperCase();
     
     boolean validoSentido = false;
     while (!validoSentido) 
     {
        if (((color.equals("B")) && (sentido.equals("N") || sentido.equals("NE") || sentido.equals("NO") || sentido.equals("E") || sentido.equals("O"))) || 
            ((color.equals("N")) && (sentido.equals("S") || sentido.equals("SO") || sentido.equals("SE") || sentido.equals("E") || sentido.equals("O"))) )
             {validoSentido = true;} 
           else {System.out.println("Debe ingresar los valores " + sentidos);
                 sentido = in.nextLine().toUpperCase();}
             
      }
         
        
      
    boolean coinciden = false; // Detecta si coincide el color indicado con el color de la ficha de la celda indicada
    while (!coinciden)
    {
            
        boolean validaFila = false;
        while (!validaFila) 

        {
               try {
                 System.out.println("Ingrese fila de la ficha a mover (0-7) " + "\n");
                 fila = in.nextInt();
                 in.nextLine();

                    if ((0 <= fila) && ( fila <= 7)){validaFila = true;} 
                      else { System.out.println("Debe ingresar valores entre 0-7:"); }
                    
                      
                    }

              catch (Exception e) 
              {
                 System.out.println("Debe ingresar un numero entero:" + "\n");
                 in.nextLine(); // 
              }
        }

        boolean validaColumna = false;
        while (!validaColumna) 
        {
               try {
                 System.out.println("Ingrese columna de la ficha a mover (0-9): " + "\n");
                 columna = in.nextInt();
                 in.nextLine();

                 if ((0 <= columna) && ( columna <= 9)){validaColumna = true;} 
                      else { System.out.println("Debe ingresar valores entre 0-9:"); }
                      
                   }

              catch (Exception e) 
              {
                 System.out.println("Debe ingresar un numero entero:" + "\n");
                 in.nextLine(); // 
              }
        }
        
       if (unTablero.getValorCelda(fila, columna) == color.charAt(0)){coinciden = true;}
       
       else {System.out.println("El color de la ficha hallada en la celda y columna"
                                  + " indicada no coinciden con el color indicado");}
    
    }
      
      boolean validaPasos = false;
      while (!validaPasos) 
        {
               try 
               {
                 System.out.println("Ingrese la cantidad de pasos a dar: " + "\n");
                 pasos = in.nextInt();
                 in.nextLine();

                 validaPasos = true;
                }

              catch (Exception e) 
              {
                 System.out.println("Debe ingresar un numero entero:" + "\n");
                 in.nextLine(); // 
              }
        }
    
     String otroColor = "";

    if (color.equals("B"))
    {
       otroColor = "N";
    }
    else
    {
       otroColor = "B";
    }
     
     int mueveFilas = 0;
     int mueveCols = 0;
     
     if (sentido.indexOf("S") != -1){mueveFilas = 1;}
     if (sentido.indexOf("N") != -1){mueveFilas = -1;}
     if (sentido.indexOf("O") != -1){mueveCols = -1;}
     if (sentido.indexOf("E") != -1){mueveCols = 1;}
     
     for (int i = 0 ; i < 8 ; i++)
     {
       for (int j = 0; j < 10; j++) {
                if ((sentido.equals("S")) && (i > fila) && (i <= fila + pasos) && (columna == j) && (unTablero.getValorCelda(i, j) != 'V')) {
                    if (!(i == fila + pasos && unTablero.getValorCelda(i, j) == otroColor.charAt(0))) {
                        valido = false;
                    }
                }
            
                if ((sentido.equals("N")) && (i < fila) && (i >= fila - pasos) && (columna == j) && (unTablero.getValorCelda(i, j) != 'V')) {
                    if (!(i == fila - pasos && unTablero.getValorCelda(i, j) == otroColor.charAt(0))) {
                        valido = false;
                    }
                }
            
                if ((sentido.equals("O")) && (j < columna) && (j >= columna - pasos) && (fila == i) && (unTablero.getValorCelda(i, j) != 'V')) {
                    if (!(j == columna - pasos && unTablero.getValorCelda(i, j) == otroColor.charAt(0))) {
                        valido = false;
                    }
                }
            
                if ((sentido.equals("E")) && (j > columna) && (j <= columna + pasos) && (fila == i) && (unTablero.getValorCelda(i, j) != 'V')) {
                    if (!(j == columna + pasos && unTablero.getValorCelda(i, j) == otroColor.charAt(0))) {
                        valido = false;
                    }
                }
            
                if ((sentido.equals("NO")) && (j < columna) && (i < fila) && (i - j == fila - columna) && (j >= columna - pasos) && (i >= fila - pasos) && (unTablero.getValorCelda(i, j) != 'V')) {
                    if (!(j == columna - pasos && i == fila - pasos && unTablero.getValorCelda(i, j) == otroColor.charAt(0))) {
                        valido = false;
                    }
                }
            
                if ((sentido.equals("NE")) && (j > columna) && (i < fila) && (i + j == fila + columna) && (j <= columna + pasos) && (i >= fila - pasos) && (unTablero.getValorCelda(i, j) != 'V')) {
                    if (!(j == columna + pasos && i == fila - pasos && unTablero.getValorCelda(i, j) == otroColor.charAt(0))) {
                        valido = false;
                    }
                }
            
                if ((sentido.equals("SO")) && (j < columna) && (i > fila) && (i + j == fila + columna) && (j >= columna - pasos) && (i <= fila + pasos) && (unTablero.getValorCelda(i, j) != 'V')) {
                    if (!(j == columna - pasos && i == fila + pasos && unTablero.getValorCelda(i, j) == otroColor.charAt(0))) {
                        valido = false;
                    }
                }
            
                if ((sentido.equals("SE")) && (j > columna) && (i > fila) && (i - j == fila - columna) && (j <= columna + pasos) && (i <= fila + pasos) && (unTablero.getValorCelda(i, j) != 'V')) {
                    if (!(j == columna + pasos && i == fila + pasos && unTablero.getValorCelda(i, j) == otroColor.charAt(0))) {
                        valido = false;
                    }
                }
}
      }
     
     Tablero tableroFinal = new Tablero(unTablero);
        
     if (valido)
     {tableroFinal.moverFichaIndividual(fila, columna, mueveFilas , mueveCols , pasos);}
    
      
     Testeo nuevoTesteo = new Testeo(unSistema.obtenerProximoNumeroTesteo(), testerElegido, "Validar movimiento individual", "Resultado: " + valido , unTablero , tableroFinal, "Parametros: (Color: " + color + " Sentido: " + sentido + " Fila: " + fila + " Columna: " + columna + " Pasos: " + pasos );
     nuevoTesteo.setCometario(Testeo.agregaComentario());
     unSistema.agregarTesteo(nuevoTesteo);
     unSistema.setUltimoTablero(tableroFinal);

      return valido;
    }
    
    public static boolean validarMovimientoGrupal (Sistema unSistema, Tablero unTablero, Tester testerElegido){
    
    // Defino variables 
        
    Scanner in = new Scanner (System.in);
    boolean valido = true;
    
    unTablero = new Tablero (unSistema.getUltimoTablero());
    
    String color = "";
    String forma = "";
    String sentido = "";
    int pasos = 0;
    int fila = 0;
    int columna = 0;
    int largo = 0;
    
    // Valido ingreso de color
    
    System.out.println("Ingrese el color de la ficha a mover (B / N):" + "\n");
    color = in.nextLine().toUpperCase();
     
     while (!color.equals("B") && !color.equals("N")) 
     {
        System.out.println("Debe ingresar el valor B o N :" + "\n");
        color = in.nextLine().toUpperCase();
     }
     
     
     // Valido ingreso de forma
     System.out.println("Ingrese la forma del grupo: (V / H):" + "\n");
    forma = in.nextLine().toUpperCase();
     
     while (!forma.equals("V") && !forma.equals("H")) 
     {
        System.out.println("Debe ingresar el valor V o H :" + "\n");
        forma = in.nextLine().toUpperCase();
     }

    // Valido ingreso de sentido
     System.out.println("Eligio el color: " + color + " y la forma: " + forma + "\n");
     
     if (forma.equalsIgnoreCase("V"))
      {
          
        System.out.println("Ingrese el sentido de la jugada: (E/O)");
        sentido = in.nextLine().toUpperCase();
           
        while (!sentido.equalsIgnoreCase("E") && !sentido.equalsIgnoreCase("O"))
         {
           System.out.println("Debe ingresar los valores E o O");
           sentido = in.nextLine().toUpperCase();
         }
      }
     
    // Valido ingreso de sentido
     if (forma.equalsIgnoreCase("H")) 
     {
       if (color.equalsIgnoreCase("B"))
       {
         System.out.println("Ingrese el sentido de la jugada: (N)");
         sentido = in.nextLine().toUpperCase();
           
        while (!sentido.equalsIgnoreCase("N"))
         {
           System.out.println("Debe ingresar el valor N");
           sentido = in.nextLine().toUpperCase();
         }
       }
       
        if (color.equalsIgnoreCase("N"))
       {
         System.out.println("Ingrese el sentido de la jugada: (S)");
         sentido = in.nextLine().toUpperCase();
           
        while (!sentido.equalsIgnoreCase("S"))
         {
           System.out.println("Debe ingresar el valor S");
           sentido = in.nextLine().toUpperCase();
         }
       }
     }
     
     // Esto es para despues usar el metodo mueveFilasIndividual de la clase Tablero al final de este metodo
     int mueveFilas = 0;
     int mueveCols = 0;
     
     if (sentido.indexOf("S") != -1){mueveFilas = 1;}
     if (sentido.indexOf("N") != -1){mueveFilas = -1;}
     if (sentido.indexOf("O") != -1){mueveCols = -1;}
     if (sentido.indexOf("E") != -1){mueveCols = 1;}
    
   // Valida el ingreso de la celda extremo, que el color de la celda coincida con el ingresado
    boolean coinciden = false; 
    while (!coinciden)
    {
            
        boolean validaFila = false;
        while (!validaFila) 

        {
               try {
                 System.out.println("");
                 System.out.println("Ingrese fila de la ficha a mover (0-7) " + "\n");
                 fila = in.nextInt();
                 in.nextLine();

                    if ((0 <= fila) && ( fila <= 7)){validaFila = true;} 
                      else { System.out.println("Debe ingresar valores entre 0-7:"); }
                    
                      
                    }

              catch (Exception e) 
              {
                 System.out.println("Debe ingresar un numero entero:" + "\n");
                 in.nextLine(); // 
              }
        }

        boolean validaColumna = false;
        while (!validaColumna) 
        {
               try {
                 System.out.println("Ingrese columna de la ficha a mover (0-9): " + "\n");
                 columna = in.nextInt();
                 in.nextLine();

                 if ((0 <= columna) && ( columna <= 9)){
                     validaColumna = true;
                 } else { System.out.println("Debe ingresar valores entre 0-9:"); }
                      
                   }

              catch (Exception e) 
              {
                 System.out.println("Debe ingresar un numero entero:" + "\n");
                 in.nextLine(); // 
              }
        }
        
         if (unTablero.getValorCelda(fila, columna) == color.charAt(0)){coinciden = true;}
       
       else {System.out.println("El color de la ficha hallada en la celda y columna"
                                  + " indicada no coinciden con el color indicado");}
    
    }
      
      // Valida el largo del grupo, que en todas las celdas del grupo coincida con el color elegido
     
      boolean validaGrupo = false;
      int largoMaximo = 0;
      
      if (forma.equalsIgnoreCase("V")){largoMaximo = 8 - fila;} else {largoMaximo = 10 - columna;}
      
      while (!validaGrupo)
       {
           
         boolean validaLargo = false;
         while (!validaLargo) 
        {   
            
               try {
                 System.out.println("Ingrese el largo del grupo: " + "\n");
                 largo = in.nextInt();
                 in.nextLine();

                 if (largo > 0 && largo <= largoMaximo){validaLargo = true;} 
                      else { System.out.println("Ingreso valores fuera de rango." + "\n" + 
                                                "Largo maximo posible sin salir del tablero " + largoMaximo);}
                      
                   }

              catch (Exception e) 
              {
                 System.out.println("Debe ingresar un numero entero:" + "\n");
                 in.nextLine(); // 
              }
        }
          
         int largoMaxColor = 0;
         validaGrupo = true;
         
         for (int i = 0 ; i < largo && validaGrupo; i++)
          {
             if (forma.equalsIgnoreCase("V"))
              {
                int auxFila = fila + i;
                             
                if (unTablero.getValorCelda(auxFila, columna) != color.charAt(0)){validaGrupo = false; largoMaxColor = i;}
                      
              }
             
             if (forma.equalsIgnoreCase("H"))
              {
                int auxCol = columna + i;
                
                if (unTablero.getValorCelda(fila, auxCol) != color.charAt(0)){validaGrupo = false; largoMaxColor = i;}
              
              }
          }
            if (validaGrupo)
              {   
                  System.out.println("");
                  System.out.println ("El grupo ingresado es valido");
              }
                    
            else {
                   System.out.println
                  
                    ("Parametros ingresados: " + "\n" +
                     "Color: " + color +  "\n" +
                     "Fila: " + fila +  "\n" +
                     "Columna: " + columna + "\n" +  "\n" + 
                     "Las celdas que quedan abarcadas en el largo ingresado son diferentes al color del grupo " +  "\n" +
                     "El largo maximo posible del grupo es " + largoMaxColor);
                  } 
        }
         boolean puedeDarPasos = true;
       
         int pasosMaximo = 0;
         if (forma.equals("V"))
           {
              if (sentido.equals("O")){pasosMaximo = columna;} else {pasosMaximo = 9 - columna;}
           }
         
         else 
           {
             if (sentido.equals("N")){pasosMaximo = fila;} else {pasosMaximo = 7 - fila;}
               
           }
         
         if (pasosMaximo == 0){
             puedeDarPasos = false; 
             valido = false;
             System.out.println("El grupo no puede desplazarse en ese sentido.");
         }
         
         /*La logica del codigo es que controle el ingreso de parametros (color, sentido, fila, columna y largo)
           hasta la consitucion del grupo, una vez creado el grupo, si este no puede dar pasos directamente 
           retorna falso, si puede dar pasos, controla que el usuario ingrese la cantidad de pasos permitida,
           y retorna true*/
         
         boolean validaPasos = false;
         while (!validaPasos && puedeDarPasos) 
        {   
            
               try {
                 System.out.println("");
                 System.out.println("Ingrese el numero de pasos. Pasos maximos dentro del rango del tablero: " + pasosMaximo + "\n");
                 pasos = in.nextInt();
                 in.nextLine();

                 if (pasos > 0 && pasos <= pasosMaximo){validaPasos = true;} 
                      else { System.out.println("Ingreso valores fuera de lo permitido." + "\n" + 
                                                "Los pasos maximos posible son: " + pasosMaximo);}
                      
                   }

              catch (Exception e) 
              {
                 System.out.println("Debe ingresar un numero entero:" + "\n");
                 in.nextLine(); // 
              }
        }
       
         for (int i = 0 ; i < 8 ; i++)
           {
            for (int j = 0 ; j < 10 ; j++)
             {
               if (sentido.equals("N") && j >= columna && j < columna + largo && i >= fila - pasos && i < fila)
                 {if (unTablero.getValorCelda(i,j) != 'V') {valido = false;}}
              
               if (sentido.equals("S") && j >= columna && j < columna + largo && i <= fila + pasos && i > fila )
                 {if (unTablero.getValorCelda(i,j) != 'V') {valido = false;}}
               
               if (sentido.equals("O") && i >= fila && i < fila + largo && j < columna  &&  j >= columna - pasos )
                 {if (unTablero.getValorCelda(i,j) != 'V') {valido = false;}}
               
               if (sentido.equals("E") && i >= fila && i < fila + largo && j > columna  &&  j <= columna + pasos )
                 {if (unTablero.getValorCelda(i,j) != 'V') {valido = false;}}
               
             }
           
           }
         
         Tablero tableroFinal = new Tablero(unTablero);
         
         if (valido) 
           {
             for (int i = 0 ; i < 8 ; i++)
              {
                for (int j = 0 ; j < 10 ; j++)
                  {
                    if (forma.equals("V") && j == columna &&  i >= fila && i < fila + largo)
                     {tableroFinal.moverFichaIndividual(i, j, mueveFilas, mueveCols, pasos); }
                    
                    if (forma.equals("H") && i == fila &&  j >= columna && j < columna + largo)
                     {tableroFinal.moverFichaIndividual(i, j, mueveFilas, mueveCols, pasos); }
                  
                  }
              }
           
           }
         
       
     Testeo nuevoTesteo = new Testeo(unSistema.obtenerProximoNumeroTesteo(), testerElegido, "Validar movimiento grupal", "Resultado: " + valido , unTablero , tableroFinal, "Parametros: (Color: " + color + " Sentido: " + sentido + "Forma: " + forma + "Fila: " + fila + " Columna: " + columna + " Pasos: " + pasos );
     nuevoTesteo.setCometario(Testeo.agregaComentario());
     unSistema.agregarTesteo(nuevoTesteo);
     unSistema.setUltimoTablero(tableroFinal);
         
         
       
      return valido;
       }
  
    public static boolean verificarConexion(Sistema unSistema, char color) {
    boolean conectado = false;

    Tablero unTablero = new Tablero(unSistema.getUltimoTablero());

    int cantidadTotal = contarFichas(color, unSistema);

    if (cantidadTotal > 0) {
        boolean[][] visitadas = new boolean[8][10];

        int filaInicio = -1;
        int columnaInicio = -1;

        // Busca la primera ficha del color indicado
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
                if (filaInicio == -1 && unTablero.getValorCelda(i, j) == color) {
                    filaInicio = i;
                    columnaInicio = j;
                }
            }
        }

        int cantidadConectada = recorrerConexion(unTablero, color, visitadas, filaInicio, columnaInicio);

        if (cantidadConectada == cantidadTotal) {
            conectado = true;
        }
    }

    return conectado;
    }

    // Recorre las fichas conectadas del mismo color
    public static int recorrerConexion(Tablero unTablero, char color, boolean[][] visitadas, int fila, int columna) {

    int cantidad = 0;

    // Valida limites del tablero
    if (fila >= 0 && fila < 8 && columna >= 0 && columna < 10) {

        // Valida que no este visitada y que sea del color buscado
        if (!visitadas[fila][columna] && unTablero.getValorCelda(fila, columna) == color) {

            visitadas[fila][columna] = true;

            cantidad = 1;

            // Arriba
            cantidad = cantidad + recorrerConexion(unTablero, color, visitadas, fila - 1, columna);

            // Abajo
            cantidad = cantidad + recorrerConexion(unTablero, color, visitadas, fila + 1, columna);

            // Izquierda
            cantidad = cantidad + recorrerConexion(unTablero, color, visitadas, fila, columna - 1);

            // derecha
            cantidad = cantidad + recorrerConexion(unTablero, color, visitadas, fila, columna + 1);

            // Diagonales
            cantidad = cantidad + recorrerConexion(unTablero, color, visitadas, fila - 1, columna - 1);
            cantidad = cantidad + recorrerConexion(unTablero, color, visitadas, fila - 1, columna + 1);
            cantidad = cantidad + recorrerConexion(unTablero, color, visitadas, fila + 1, columna - 1);
            cantidad = cantidad + recorrerConexion(unTablero, color, visitadas, fila + 1, columna + 1);
        }
    }

    return cantidad;
}
    
}
    
       

      
    
   
     
 
