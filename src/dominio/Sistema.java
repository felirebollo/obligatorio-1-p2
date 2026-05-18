// Autores: Felipe Rebollo Nro: 366552 - Martin Arismendi Nro: 353787

package dominio;

import java.util.ArrayList;

public class Sistema {

    private ArrayList<Tester> listaTesters = new ArrayList<>();
    private ArrayList<Testeo> listaTesteos = new ArrayList<>();
    private Tablero ultimoTablero = new Tablero();
    private int proximoNumeroTesteo = 1; // Guarda el proximo numero de testeo

    public void setUltimoTablero(Tablero unTablero) {
        ultimoTablero = unTablero;
    }

    public Tablero getUltimoTablero() {
        return ultimoTablero;
    }

    public void agregarTester(Tester nuevoTester) {
        listaTesters.add(nuevoTester);
    }

    // Detecta si el nombre ingresado para el tester ya existe 
    public boolean nombreRepetido(String nuevoNombre) {
        boolean repetido = false;

        for (int i = 0; i < listaTesters.size(); i++) {
            String nombre = listaTesters.get(i).getNombre();
            if (nombre.equalsIgnoreCase(nuevoNombre)) {
                repetido = true;
            }

        }
        return repetido;
    }

    public ArrayList<Tester> getListaTester() {
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

    public boolean existeTester(String nombre) {
        boolean existe = false;

        for (int i = 0; i < this.getListaTester().size(); i++) {
            if (this.getListaTester().get(i).getNombre().equalsIgnoreCase(nombre)) {
                existe = true;
            }
        }
        return existe;
    }

    
}
