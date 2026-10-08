/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vehiculo;


public class Prueba {

    public static void main(String[] args) {
        // Probando los 3 constructores
        Vehiculo v1 = new Vehiculo("A123456");
        Vehiculo v2 = new Vehiculo("B789012", "Toyota");
        Vehiculo v3 = new Vehiculo("C345678", "Honda", "Civic");
        
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println();
        
         // Probando los métodos sobrecargados
        System.out.println("Solo km (20000): "
                + v3.calcularMantenimiento(20000));
        System.out.println("Km + servicio completo: "
                + v3.calcularMantenimiento(20000, "completo"));
        System.out.println("Km + premium + 5 años: "
                + v3.calcularMantenimiento(20000, "premium", 5));
    }

}