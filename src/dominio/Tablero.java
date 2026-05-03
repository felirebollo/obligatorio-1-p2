package dominio;

public class Tablero
{ 
  private char[][] tablero = 
  {
    {'V','V','N','N','V','V','N','N','V','V'},
    {'N','N','N','N','N','N','N','N','N','N'},
    {'V','N','N','V','V','N','N','V','V','N'},
    {'V','V','V','V','V','V','V','V','V','V'},
    {'V','V','V','V','V','V','V','V','V','V'},
    {'V','B','B','V','V','B','B','V','V','B'},
    {'B','B','B','B','B','B','B','B','B','B'},
    {'V','V','B','B','V','V','B','B','V','V'}
  };
  
  
  @Override
  public String toString () {
    String salida = "";

    for (int i = 0; i < tablero.length; i++) {
        for (int j = 0; j < tablero[i].length; j++) {
            salida += tablero[i][j] + " ";
        }
        salida += "\n";
    }

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
   return tablero [fila][columna]; 
 }
 
}
