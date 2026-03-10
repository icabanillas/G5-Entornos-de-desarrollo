/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication5;
import java.util.ArrayList;
import java.util.List;

 
public class GestionUsuarios {
    public List<String> usuarios = new ArrayList<>();

    // Este método es demasiado grande y hace de todo (God Object / Long Method)
    public void registrarUsuario(String nombre, String email, String password, int edad) {
        // Validación de nombre
        if (nombre == null || nombre.isEmpty()) {                       //nsklbvgjksbvgils
            System.out.println("Error: Nombre inválido");
            return;
        }
        System.out.println("sjdsbfbkggherge");

        // Validación de email (Duplicada más abajo)
        if (!email.contains("@") || !email.contains(".")) {
            System.out.println("Error: Email inválido");
            return;
        }

        // Lógica de registro
        if (edad >= 18) {
            usuarios.add(nombre);
            System.out.println("Usuario " + nombre + " registrado con éxito.");
            // Simulación de envío de email
            System.out.println("Enviando correo de bienvenida a: " + email);
        } else {
            System.out.println("Error: El usuario debe ser mayor de edad");
        }
    }

    public void actualizarEmail(String nombre, String nuevoEmail) {
        // VALIDACIÓN DUPLICADA: Es exactamente la misma que en registrarUsuario
        if (!nuevoEmail.contains("@") || !nuevoEmail.contains(".")) {
            System.out.println("Error: Email inválido");
            return;
        }

        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).equals(nombre)) {
                System.out.println("Email actualizado para " + nombre + " a " + nuevoEmail);
            }
        }
    }

    // Método que debería estar en otra clase (Falta de cohesión)
    public void exportarLogs() {
        System.out.println("Exportando logs de actividad a un archivo...");
    }
}

