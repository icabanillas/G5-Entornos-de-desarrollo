/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.List;

public class GestionUsuarios {
    public List<String> usuarios = new ArrayList<>();

    /*
     REFACTORIZACIÓN (Principio DRY): 
     Se pasa la validación del email a un método privado.
     Antes (!email.contains("@") || !email.contains(".")) estaba repetida 
     en registrar y actualizar, lo cual dificultaba el mantenimiento.
     */
    
    private boolean esEmailValido(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }

    public void registrarUsuario(String nombre, String email, String password, int edad) {
        if (nombre == null || nombre.isEmpty()) return;

        // Llamada al método centralizado (Elimina duplicidad)
        if (!esEmailValido(email)) {
            System.out.println("Error: Email inválido");
            return;
        }

        if (edad >= 18) {
            usuarios.add(nombre);
            System.out.println("Usuario " + nombre + " registrado.");
            System.out.println("Enviando correo a: " + email);
        }
    }

    public void actualizarEmail(String nombre, String nuevoEmail) {
        // Reutilización del método de validación
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

    public void exportarLogs() {
        System.out.println("Exportando logs de actividad a un archivo...");
    }
}