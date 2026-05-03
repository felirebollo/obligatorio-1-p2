
package dominio;
import java.util.Scanner;

public class Testeo {
    
    //Cuenta cuantas fichas hay de un tipo en el tablero
    public static int contarFichas (Tablero unTablero, char letra){  
        int contador = 0 ;
        
        for (int i = 0 ; i < 8 ; i++) {
           for (int j = 0 ; j < 10 ; j++){
               if (unTablero.getValorCelda(i,j) == letra){
                   contador++;
               }
             }
          }
        
        return contador;
     }
    
}
