
package dominio;
import java.util.Scanner;

public class Testeo {
    
    
    public static int contarFichas (Tablero unTablero)
     {  
        Scanner in = new Scanner (System.in); 
        int contador = 0 ;
        char letra;
        
        System.out.println("Ingrese el valor a buscar:");
        letra = Character.toUpperCase(in.nextLine().charAt(0));
        
        for (int i = 0 ; i < 8 ; i++) 
          {
           for (int j = 0 ; j < 10 ; j++)
             {
               if (unTablero.getValorCelda(i,j) == letra){contador++;}
             }
          }
        
        return contador;
     }
    
}
