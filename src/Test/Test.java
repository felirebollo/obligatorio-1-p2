import dominio.*;

public class Test {
    
   public static void main(String[] args){
   
    Sistema unSistema = new Sistema();
      
     Tablero unTablero = new Tablero();
     
     Tester testerElegido = new Tester ("Martin", 18 ,6);
       
       System.out.println(unTablero.toString());
   
      System.out.println(Testeo.validarMovimientoGrupal(unSistema, unTablero, testerElegido)); 
      
      
   }
          
    
   
}
/*{'V','V','N','N','V','V','N','N','V','V'},
                              {'N','N','N','N','N','N','N','N','N','N'},
                              {'V','N','N','V','V','N','N','V','V','N'},
                              {'V','V','V','V','V','V','V','V','V','V'},
                              {'V','V','V','V','V','V','V','V','V','V'},
                              {'V','B','B','V','V','B','B','V','V','B'},
                              {'B','B','B','B','B','B','B','B','B','B'},
                              {'V','V','B','B','V','V','B','B','V','V'}*/