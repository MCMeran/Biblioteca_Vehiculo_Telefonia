/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telefonia;

public class Telefonia {
  
    public static void main(String[] args) {
        Plan planBasico = new Plan(300, 5, 800.00);
        Cliente cliente = new Cliente("Juan Pérez", "809-555-1234", planBasico);
 
        // Consumo que excede el plan
        Factura factura1 = new Factura(cliente, 350, 6.5);
        factura1.generarFactura();
 
        System.out.println();
 
        // Consumo dentro del plan
        Factura factura2 = new Factura(cliente, 200, 3.0);
        factura2.generarFactura();
    }
}
