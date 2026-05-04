import dominio.*;

public class Test {
    
   public static void main(String[] args){
   
    Sistema programa = new Sistema();
      
     Tablero nuevo = new Tablero();
    
       System.out.println(nuevo.toString());
    
       Tester martin = new Tester ("Martin", 27, 6);
           
   // Testeo prueba = new Testeo(2, martin, "Prueb", "resultado");
   
       
       
     Testeo prueba = new Testeo(1, martin, "S", "unResultado", nuevo, nuevo);
     
     prueba.setCometario(Testeo.agregaComentario());
     
     System.out.println(prueba.getComentario());
       
       
     
   
   }
          
    
   
}
