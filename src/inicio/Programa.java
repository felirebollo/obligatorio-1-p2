/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inicio;
import dominio.Sistema;
import dominio.Tester;
/**
 *
 * @author felir
 */
public class Programa {

    public static void main(String[] args) {

        Sistema sistema = new Sistema();

        Tester tester1 = new Tester("Juan", 22, 3);

        sistema.agregarTester(tester1);

        System.out.println(sistema);
        s
    }
}
