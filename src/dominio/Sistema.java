package dominio;

import java.util.ArrayList;

// ULTIMO PUSH 03/05 A LAS 15:13

public class Sistema {
     private ArrayList<Tester> listaTesters = new ArrayList<>();  
     private ArrayList<Testeo> listaTesteos = new ArrayList<>();

     // Guarda el proximo numero de testeo
     private int proximoNumeroTesteo = 1;
     
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


     // Agrega un testeo realizado al sistema
     public void agregarTesteo(Testeo unTesteo) {
         listaTesteos.add(unTesteo);
     }
     
     // Retorna la lista de testeos realizados
     public ArrayList<Testeo> getListaTesteos() {
          return listaTesteos;
     }

     // Devuelve el proximo numero de testeo y lo incrementa
     public int obtenerProximoNumeroTesteo() {
     int numero = proximoNumeroTesteo;
     proximoNumeroTesteo = proximoNumeroTesteo + 1;
     return numero;
}
    
    
    
   }




