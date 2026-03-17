/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication5;
import java.util.ArrayList;
import java.util.List;

 
public class GestionUsuarios {
    public List<String> usuarios = new ArrayList<>();   //Convertimos List por un ArrayList y agregaremos un objeto llamado usuarios
    
    //Agregamos las nuevas clases
    private EmailService CorreoBienvenida = new EmailService();
    private Logger logger = new Logger();

   
    public void registrarUsuario(String nombre, String email, String password, int edad) {                    
     
        if (nombre == null || nombre.isEmpty()) {                      
            System.out.println("Error: Nombre inválido");
            return;
        }

       if (!validarEmail(email)) {                                 //Se utiliza el metodo para la validacion del email
            System.out.println("Error: Email inválido");
            return;
        }

        if (edad >= 18) {
            usuarios.add(nombre);
            System.out.println("Usuario " + nombre + " se ha registrado con éxito.");
            CorreoBienvenida.enviarCorreo(email);                 //Se llama a la clase ServicioDeBienvenida para que solamente se especialice esa clase en enviar el correo de bienvenida, utilizando la Responsabilidad Única (SRP)
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

