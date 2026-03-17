/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication5;
import java.util.ArrayList;
import java.util.List;

 
public class GestionUsuarios {
    public List<String> usuarios = new ArrayList<>();   //Convertimos List por un ArrayList y agregaremos un objeto llamado usuarios

    // Este método es demasiado grande y hace de todo (God Object / Long Method)
    public void registrarUsuario(String nombre, String email, String password, int edad) {                    
        // Validación de nombre
        if (nombre == null || nombre.isEmpty()) {                      
            System.out.println("Error: Nombre inválido");
            return;
        }

       if (!validarEmail(email)) {                                 //Se utiliza el metodo para la validacion del email
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
       
       if (!validarEmail(nuevoEmail)) {                            //Se utiliza el metodo para la validacion del email     
            System.out.println("Error: Email inválido");
            return;
        }

        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).equals(nombre)) {
                System.out.println("Email actualizado para " + nombre + " a " + nuevoEmail);
            }
        }
    }                           
    
    private boolean validarEmail(String email) {                            //Creamos el metodo validarEmail y eliminar codigo duplicado
        return email != null && email.contains("@") && email.contains(".");
    }
}

