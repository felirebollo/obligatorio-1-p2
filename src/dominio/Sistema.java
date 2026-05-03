package dominio;

import java.util.ArrayList;

// ULTIMO PUSH 03/05 A LAS 15:13

public class Sistema {
     private ArrayList <Tester> listaTesters = new ArrayList <>();  
       
    
    
    public void agregarTester (Tester nuevoTester){
       listaTesters.add(nuevoTester);
     }
    
    public boolean nombreRepetido (String nuevoNombre){
       boolean repetido = false;
       
       for (int i = 0 ; i < listaTesters.size() ; i++){
          String nombre = listaTesters.get(i).getNombre();
          if (nombre.equalsIgnoreCase(nuevoNombre)){
               repetido = true;
          }
              
        } 
       return repetido;
      }
    
    public ArrayList<Tester> getListaTester(){ 
         return listaTesters;
    }
    
    
    
    
    
   }




