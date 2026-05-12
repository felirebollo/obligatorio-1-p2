package dominio;

import java.util.ArrayList;

// ULTIMO PUSH 03/05 A LAS 15:13
// ULTIMO PUSH 3/05 A LAS 17:52
// ULTIMO Push 04/05 A LAS 20:27
// ULTIMO Push 05/05 A LAS 09:25
// ULTIMO Push 05/05 A LAS 11:32


public class Sistema {
     private ArrayList<Tester> listaTesters = new ArrayList<>();  
     private ArrayList<Testeo> listaTesteos = new ArrayList<>();
     private Tablero ultimoTablero = new Tablero ();

     
     public void setUltimoTablero (Tablero unTablero)
      {ultimoTablero = unTablero;}
     
     public Tablero getUltimoTablero ()
      {
       return ultimoTablero;
      }
     
     // Guarda el proximo numero de testeo
     private int proximoNumeroTesteo = 1;
     
     public void agregarTester (Tester nuevoTester){
          listaTesters.add(nuevoTester);
     }
    
    // Detecta si el nombre ingresado para el tester ya existe 
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
     public boolean existeTester (String nombre)
      {
         boolean existe = false;
         
         for (int i = 0 ; i < this.getListaTester().size() ; i++)
         {
                if(this.getListaTester().get(i).getNombre().equalsIgnoreCase(nombre)){existe = true;}
         }
         return existe;
      }
     
        
   /* 
     VER PARA BORRRAR
     public Tablero getUltimoTablero ()
     {
       Tablero salida = new Tablero ();
       int ultimo = this.getListaTesteos().size();
       
       if (ultimo > 0)
       {
         salida = this.getListaTesteos().get(ultimo-1).getTableroFinal();
       } 
       
        return salida;
     }
    */ 
     
   }




