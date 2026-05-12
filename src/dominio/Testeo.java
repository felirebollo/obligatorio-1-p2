
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
    public void setCometario (String unComentario){
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

    //Cuenta cuantas fichas hay de un tipo en el tablero
    public static int contarFichas (Tablero unTablero, char letra, Sistema unSistema){  
       
        int contador = 0 ;
        
        unTablero = new Tablero (unSistema.getUltimoTablero());
        
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
    
    // Agregar comentario
    
    public static String agregaComentario ()
    {   
        String comentario = "";
        Scanner in = new Scanner(System.in);
       
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

                 if ((0 <= columna) && ( columna <= 7)){validaColumna = true;} 
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
    
     String otroColor = "B";
     
     if (color.equals("B")){otroColor = "N";}
     
     int mueveFilas = 0;
     int mueveCols = 0;
     
     if (sentido.indexOf("S") != -1){mueveFilas = 1;}
     if (sentido.indexOf("N") != -1){mueveFilas = -1;}
     if (sentido.indexOf("O") != -1){mueveCols = -1;}
     if (sentido.indexOf("E") != -1){mueveCols = 1;}
     
     for (int i = 0 ; i < 8 ; i++)
     {
        for (int j = 0 ; j < 10 ; j++)
         {
            if ((sentido.equals("S")) && (i > fila) && (i <= fila + pasos) && (columna == j) && (unTablero.getValorCelda(i,j) != 'V') )
               {if( i == fila + pasos && unTablero.getValorCelda(i,j) == otroColor.charAt(0)){} else {valido = false;}}                       
           
            if ((sentido.equals("N")) && (i < fila) && (i >= fila - pasos) && (columna == j) && (unTablero.getValorCelda(i,j) != 'V') )
               {if( i == fila - pasos && unTablero.getValorCelda(i,j) == otroColor.charAt(0)) {} else {valido = false;}}                       
           
            if ((sentido.equals("O")) && (j < columna) && (j >= columna - pasos) && (fila == i) && (unTablero.getValorCelda(i,j) != 'V') )
               {if( j == columna - pasos && unTablero.getValorCelda(i,j) == otroColor.charAt(0)){} else {valido = false;}}                       
           
            if ((sentido.equals("E")) && (j > columna) && (j <= columna + pasos) && (fila == i) && (unTablero.getValorCelda(i,j) != 'V') )
               {if( j == columna + pasos && unTablero.getValorCelda(i,j) == otroColor.charAt(0)){} else {valido = false;}}                       
           
            if ((sentido.equals("NO")) && (j < columna) && (i < fila) && (i-j == fila-columna) && (j >= columna - pasos) && (i >= fila - pasos) && (unTablero.getValorCelda(i,j) != 'V') )
               {if( j == columna - pasos && i == fila - pasos && unTablero.getValorCelda(i,j) == otroColor.charAt(0)){} else {valido = false;}}                       
            
            if ((sentido.equals("NE")) && (j > columna) && (i < fila) && (i+j == fila+columna) && (j <= columna + pasos) && (i >= fila - pasos) && (unTablero.getValorCelda(i,j) != 'V') )
               {if( j == columna + pasos && i == fila - pasos && unTablero.getValorCelda(i,j) == otroColor.charAt(0)){} else {valido = false;}}                       
            
            if ((sentido.equals("SO")) && (j < columna) && (i > fila) && (i+j == fila+columna) && (j >= columna - pasos) && (i <= fila + pasos) && (unTablero.getValorCelda(i,j) != 'V') )
               {if( j == columna - pasos && i == fila + pasos && unTablero.getValorCelda(i,j) == otroColor.charAt(0)){} else {valido = false;}}                       
            
            if ((sentido.equals("SE")) && (j > columna) && (i > fila) && (i-j == fila-columna) && (j <= columna + pasos) && (i <= fila + pasos) && (unTablero.getValorCelda(i,j) != 'V') )
               {if( j == columna + pasos && i == fila + pasos && unTablero.getValorCelda(i,j) == otroColor.charAt(0)){} else {valido = false;}}                       
            
         }  
      }
     
     Tablero tableroFinal = new Tablero(unTablero);
        System.out.println("aun funciona");
        
         System.out.println("color " + color);
     System.out.println("sentido: " + sentido);
     
     
     tableroFinal.moverFichaIndividual(fila, columna, mueveFilas , mueveCols , pasos);
    
     System.out.println(unTablero.toString());
     System.out.println(tableroFinal.toString());
     
     Testeo nuevoTesteo = new Testeo(unSistema.obtenerProximoNumeroTesteo(), testerElegido, "Validar movimiento individual", "Resultado: " + valido , unTablero , tableroFinal, "Parametros: (Color: " + color + " Sentido: " + sentido + " Fila: " + fila + " Columna: " + columna + " Pasos: " + pasos );
     nuevoTesteo.setCometario(Testeo.agregaComentario());
     unSistema.agregarTesteo(nuevoTesteo);
     unSistema.setUltimoTablero(tableroFinal);

      return valido;
    }
 
    
    public static boolean validarMovimientoGrupal (Sistema unSistema, Tablero unTablero, Tester testerElegido)
    {
    
    // Defino variables 
        
    Scanner in = new Scanner (System.in);
    boolean valido = true;
    
    unTablero = new Tablero (unSistema.getUltimoTablero());
    
    String color = "";
    String forma = "";
    String sentido = "";
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
     System.out.println("Ingrese la forma del grupo: (B / N):" + "\n");
    forma = in.nextLine().toUpperCase();
     
     while (!forma.equals("V") && !color.equals("H")) 
     {
        System.out.println("Debe ingresar el valor V o H :" + "\n");
        forma = in.nextLine().toUpperCase();
     }

    // Valido ingreso de sentido
     System.out.println("Eligio el color: " + color + " y la forma: " + forma + "\n");
     
     if (forma.equalsIgnoreCase("V"))
      {
          
        System.out.println("Ingrese el sentido de la jugada: (E/O");
        sentido = in.nextLine();
           
        while (!sentido.equalsIgnoreCase("E") && !sentido.equalsIgnoreCase("O"))
         {
           System.out.println("Debe ingresar los valores E o O");
           sentido = in.nextLine();
         }
      }
     
    // Valido ingreso de sentido
     if (forma.equalsIgnoreCase("H")) 
     {
       if (color.equalsIgnoreCase("B"))
       {
         System.out.println("Ingrese el sentido de la jugada: (N/E/O");
        sentido = in.nextLine();
           
        while (!sentido.equalsIgnoreCase("N") && !sentido.equalsIgnoreCase("E") && !sentido.equalsIgnoreCase("O"))
         {
           System.out.println("Debe ingresar los valores N, E o O");
           sentido = in.nextLine();
         }
       }
       
        if (color.equalsIgnoreCase("N"))
       {
         System.out.println("Ingrese el sentido de la jugada: (S/E/O");
         sentido = in.nextLine();
           
        while (!sentido.equalsIgnoreCase("S") && !sentido.equalsIgnoreCase("E") && !sentido.equalsIgnoreCase("O"))
         {
           System.out.println("Debe ingresar los valores S, E o O");
           sentido = in.nextLine();
         }
       }
     }
    // Valida el ingreso de la celda extremo, que el color de la celda coincida con el ingresado
    boolean coinciden = false; 
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

                 if ((0 <= columna) && ( columna <= 7)){validaColumna = true;} 
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
      
      // Valida el largo del grupo, que en todas las celdas del grupo coincida con el color elegido
      boolean validaGrupo = false;
      int largoMaximo = 0;
      if (forma.equalsIgnoreCase("V")){largoMaximo = 8;} else {largoMaximo = 10;}
      
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
                      else { System.out.println("Ingreso valores fuera de rango: "); }
                      
                   }

              catch (Exception e) 
              {
                 System.out.println("Debe ingresar un numero entero:" + "\n");
                 in.nextLine(); // 
              }
        }
          
         
         validaGrupo = true;
         
         for (int i = 0 ; i <= largo ; i++)
          {
             if (forma.equalsIgnoreCase("V"))
              {
                int auxFila = fila + i;
                             
                 if (unTablero.getValorCelda(auxFila, columna) != color.charAt(0)){validaGrupo = false;}
              
              }
             
             if (forma.equalsIgnoreCase("H"))
              {
                int auxCol = columna + 1;
                
                if (unTablero.getValorCelda(fila, auxCol) != color.charAt(0)){validaGrupo = false;}
              
              }
          }
            if (validaGrupo){System.out.println("coincicen");} else {System.out.println("no coinciden");} 
        }
        
      return valido;
       }
    }
    
       

      
    
   
     
 