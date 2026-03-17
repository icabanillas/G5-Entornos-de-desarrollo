/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.List;

public class GestionUsuarios {
    public List<String> usuarios = new ArrayList<>();
    
    // REFACTORIZACIÓN (Principio SRP): 
    // Creamos instancias de las clases especializadas.
    private GestionarEmail gestorEmail = new GestionarEmail();
    private GestionarLogs gestorLogs = new GestionarLogs();

    /**
     REFACTORIZACIÓN (Principio DRY):
     Mantenemos el método centralizado de validación para evitar código duplicado.
     */
    private boolean esEmailValido(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }

    public void registrarUsuario(String nombre, String email, String password, int edad) {
        if (nombre == null || nombre.isEmpty()) return;

        if (!esEmailValido(email)) {
            System.out.println("Error: Email inválido");
            return;
        }

        if (edad >= 18) {
            usuarios.add(nombre);
            System.out.println("Usuario " + nombre + " registrado.");
            
            // REFACTORIZACIÓN (SRP): En lugar de un System.out local, llamamos a la clase especialista en comunicaciones.
            gestorEmail.enviarBienvenida(email);
        }
    }

    public void actualizarEmail(String nombre, String nuevoEmail) {
        if (!esEmailValido(nuevoEmail)) {
            System.out.println("Error: Email inválido");
            return;
        }

        for (String u : usuarios) {
            if (u.equals(nombre)) {
                System.out.println("Email actualizado para " + nombre);
            }
        }
    }

    /**
     REFACTORIZACIÓN (SRP): 
     El método original se mantiene para no romper el programa, pero ahora la lógica real está en la clase GestionarLogs.*/
    
    public void exportarLogs() {
        gestorLogs.exportarLogs();
    }
}