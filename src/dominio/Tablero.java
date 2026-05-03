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
  
  // Este metodo lo vi con chatGpt. Me dijo que es lo que se acostumbra para la salida de la matriz
  // hay que ver si lo mantenemos o encontramos uno mas a nivel de la clase.
  
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
    for (int i = 0 ; i < 10 ; i++)
      {
        tablero [numeroLinea][i] = nuevaLinea.charAt(i);
      }
  
  }



}
