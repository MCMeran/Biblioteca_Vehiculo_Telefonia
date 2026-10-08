/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vehiculo;


public class Vehiculo {
     private String placa;
    private String marca;
    private String modelo;

    // ===== Constructores sobrecargados =====

    // 1. Básico: solo la placa
    public Vehiculo(String placa) {
        this.placa = placa;
        this.marca = "Desconocida";
        this.modelo = "Desconocido";
    }

    // 2. Con valores por defecto: placa y marca
    public Vehiculo(String placa, String marca) {
        this(placa, marca, "Estandar"); // reutiliza el constructor completo
    }

    // 3. Completo: todos los atributos
    public Vehiculo(String placa, String marca, String modelo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
    }

    // ===== Métodos sobrecargados =====

    // Versión 1: solo por kilometraje
    public double calcularMantenimiento(int km) {
        return 1000 + (km * 0.05);
    }

    // Versión 2: kilometraje + tipo de servicio
    public double calcularMantenimiento(int km, String tipoServicio) {
        double base = calcularMantenimiento(km);
        switch (tipoServicio.toLowerCase()) {
            case "completo":
                return base * 1.5;
            case "premium":
                return base * 2;
            case "basico":
            default:
                return base;
        }
    }

    // Versión 3: kilometraje + tipo de servicio + años de antigüedad
    public double calcularMantenimiento(int km, String tipoServicio, int anios) {
        double costo = calcularMantenimiento(km, tipoServicio);
        return costo + (anios * 200); // recargo por antigüedad
    }

    // ===== Getters y toString =====

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    @Override
    public String toString() {
        return "Vehiculo [placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + "]";
    }
        }



