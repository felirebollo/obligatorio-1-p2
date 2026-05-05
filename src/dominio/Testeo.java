
package dominio;
import java.util.Scanner;

public class Testeo {
    private int numero;
    private Tester tester;
    private String tipo;
    private String resultado;
    private String comentario;  
    private Tablero tableroInicial;
    private Tablero tableroFinal;
    private String parametro;

    public Testeo(int unNumero, Tester unTester, String unTipo, String unResultado, Tablero tableroInicial, Tablero tableroFinal, String parametro) {
        this.setNumero(unNumero);
        this.setTester(unTester);
        this.setTipo(unTipo);
        this.setResultado(unResultado);
        this.setTableroInicial(tableroInicial);
        this.setTableroFinal(tableroFinal);
        this.setParametro(parametro);
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int unNumero) {
        numero = unNumero;
    }

    public Tester getTester() {
        return tester;
    }
    public void setTester(Tester unTester) {
        tester = unTester;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String unTipo) {
        tipo = unTipo;
    }

    public String getResultado() {
        return resultado;
    }
    public void setResultado(String unResultado) {
        resultado = unResultado;
    }
    
    public Tablero getTableroInicial () {
      return tableroInicial;
    }
    
    public Tablero getTableroFinal() {
     return tableroFinal;
    }
    
    public String getComentario () {
     return comentario;
    }
    
    public void setCometario (String unComentario){
      comentario = unComentario;
    }
    public void setTableroInicial (Tablero unTablero){
      tableroInicial = unTablero;
    }
    
    public void setTableroFinal (Tablero unTablero){
      tableroFinal = unTablero;
    }
   public void setParametro (String unParametro){
    parametro = unParametro;
   }
   
   public String getParametro (){
    return parametro;
   }
 
    @Override
    public String toString() {
        return "Testeo Nro: " + this.getNumero() + " -  Tipo de testeo: " + this.getTipo() + " - Tester: " + this.getTester().getNombre() + " - Resultado: " + this.getResultado() +" - "+ this.getParametro() + " - Comentario: " + this.getComentario() ;
    }

    
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
    
    
    
    // Agregar comentario
    
    public static String agregaComentario ()
    {   
        String comentario = "";
        Scanner in = new Scanner(System.in);
       
        System.out.println("Desde agregar un comentario? (Si / No)" );
        String respuesta = in.nextLine();
       
       while (!respuesta.equalsIgnoreCase("si") && !respuesta.equalsIgnoreCase("no")) 
       {
        System.out.println("");
        System.out.println("Debe ingresar SI o NO:");  
        respuesta = in.nextLine();
        }
       
       if (respuesta.equalsIgnoreCase("si"))
         {   
             System.out.println("");
             System.out.println("Ingrese su comentario:");
             comentario = in.nextLine();
         } 
         else {comentario = "Sin comentarios";}
       
         return comentario;
    
    }
    
}
