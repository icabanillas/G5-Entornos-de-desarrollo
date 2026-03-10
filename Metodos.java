/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ent_Des;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author inteltg
 */
public class Metodos {

    public List<Usuario> usuarios = new ArrayList<>();
    
    /**
     * 
     * @param nombre
     * @param email
     * @param password
     * @param edad 
     */
    public void registrarUsuario(String nombre, String email, String password, int edad) {
        try { //intentamos crear el usuario
            Usuario user = new Usuario(nombre, email, password, edad);
            usuarios.add(user); //si el usuario es creado exictosamente se guarda

            enviarEmail(usuarios, edad); //metodo para enviar el email si cumple con mayoria de edad
        } catch (Error_Des e) { //si algun dato falla, no se crea al usuario y se muestra el primer error
            System.out.println(e);
        }
    }
    
    /**
     * 
     * @param data
     * @param edad 
     */
    public void enviarEmail(List<Usuario> data, int edad) {
        if (edad >= 18) { //si la edad es 18 o mas, simula el envio de un email
            System.out.println("Enviando correo a " + data.getLast());
        } else { //si no es mayor de edad, se informa al usuario que es menor de edad
            System.out.println("El usuario es demasiado joven (-18)");
        }
    }
    
    /**
     * 
     * @param data
     * @param nombre
     * @param nuevoEmail 
     */
    public void actualizarEmail(List<Usuario> data, String nombre, String nuevoEmail) {
        boolean encontrado = false;
        if (!data.isEmpty()) { //si la lista de usuarios esta vacio se informa si no continua la busqueda del usuario
            for (int ini = 0; ini < data.size() && !encontrado; ini++) { //for para recorrer la lista, solo la recorre si hay un next y no se ha encontrado al usuario
                Usuario user = data.get(ini);
                if (user.getNombre().equalsIgnoreCase(nombre)) { //si el nombre coincide (ignorando mayusculsa y minusculas)
                    try { //intentamos el cambio de email
                        user.setEmail(nuevoEmail);
                        encontrado = true; //informamos que ya lo hemos encontrado para terminar el for
                    } catch (Error_Des e) { //si da error, atrapamos la excepcion
                        System.out.println(e); //mostramos por pantalla cual ha sido el problema
                    }
                }
            }
        } else { //si la lista esta vacia lo informamos
            System.out.println("Error, lista vacia");
        }
    }
}

