/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;
import java.util.ArrayList;
/**
 *
 * @author felipe
 */
public class Sistema {
    private ArrayList<Tester> listaTesters;
    
    public Sistema(){
        listaTesters = new ArrayList<Tester>();
    }
    
    public ArrayList<Tester> getListaTesters() {
        return listaTesters;
    }
    
    public boolean existeTester(String unNombre){
        boolean existe = false;
        
        int i = 0;
        while(i < this.getListaTesters().size()){
            Tester aux = this.getListaTesters().get(i);
            
            if(aux.getNombre().equals(unNombre)) {
                existe = true;
            }
            i=i+1;
        }
        return existe;
    }
    
    public void agregarTester(Tester unTester) {
        if(!this.existeTester(unTester.getNombre())) {
            this.getListaTesters().add(unTester);
        }
    }
}
