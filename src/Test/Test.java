import dominio.*;

public class Test {
    
   public static void main(String[] args){
   
    Sistema programa = new Sistema();
       
     Tester martin = new Tester ("Martin" , 18, 4);
       System.out.println(martin);
      
  

     
      programa.agregarTester(martin);
      
       
       System.out.println(programa.getListaTester());
       
   }
           
           
    
   
    
}
