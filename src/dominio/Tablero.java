package dominio;

// Autores: Felipe Rebollo Nro: 366552 - Martin Arismendi Nro: 353787


public class Tablero
{ 
  private char[][] tablero;
  
  
  public Tablero () 
   {
    tablero =  new char [][] {{'V','V','N','N','V','V','N','N','V','V'},
                              {'N','N','N','N','N','N','N','N','N','N'},
                              {'N','N','V','V','N','N','V','V','N','N'},
                              {'V','V','V','V','V','V','V','V','V','V'},
                              {'V','V','V','V','V','V','V','V','V','V'},
                              {'B','B','V','V','B','B','V','V','B','B'},
                              {'B','B','B','B','B','B','B','B','B','B'},
                              {'V','V','B','B','V','V','B','B','V','V'}};
   }
  
   // Constructor para hacer un nuevo tablero en memoria a partir del tablero inicial
  public Tablero(Tablero otro)
{
    tablero = new char[8][10];

    for (int i = 0; i < 8; i++)
    {
        for (int j = 0; j < 10; j++)
        {
            tablero[i][j] = otro.getValorCelda(i, j);
        }
    }
}
  
  @Override
  public String toString() {

    String salida = "";

    String linea = "+---+---+---+---+---+---+---+---+---+---+\n";

    for (int i = 0; i < tablero.length; i++) {

        salida += linea;

        for (int j = 0; j < tablero[i].length; j++) {

            char valor = getValorCelda(i, j);

            if (valor == 'V') {
                salida += "|   ";
            } else {
                salida += "| " + valor + " ";
            }
        }

        salida += "|\n";
    }

    salida += linea;

    return salida;
}

  
  
  public void setTablero (String nuevaLinea, int numeroLinea) 
  { 
    /*El metodo aca quedo para que se solicite en Programa para cada linea, 
     no se si es lo mejor o directamente poner como parametro una matriz nueva
     y hacer todo el for completo en programa */
      
    for (int i = 0 ; i < 10 ; i++)
      {
        tablero [numeroLinea][i] = nuevaLinea.charAt(i);
      }
  
  }

  public char getValorCelda (int fila, int columna)
    {
      return tablero[fila][columna];
    }
  
  
  public boolean mismoTablero (Tablero unTablero)
{
 boolean sonIguales = true;
 
 for (int i = 0 ; i < 8 && sonIguales ; i++)
   {
    for (int j = 0 ; j < 10 && sonIguales; j ++)
     {
       if (this.getValorCelda (i,j) != unTablero.getValorCelda(i, j)){sonIguales = false;}
     
     }
   
   }
 return sonIguales;

  }



public void moverFichaIndividual (int filaOrigen, int colOrigen, int movFilas , int movCols, int pasos)
 { 
   int filaDest = 0;
   int colDest = 0;
     
   if (movFilas == 0){filaDest = filaOrigen;} else {filaDest = filaOrigen + movFilas * pasos;}
   if (movCols == 0){colDest = colOrigen;} else {colDest = colOrigen + movCols * pasos;}
   
   tablero [filaDest][colDest] = tablero [filaOrigen][colOrigen];
   
         
   tablero [filaOrigen][colOrigen] = 'V';
    

 }
   
  
  

}

