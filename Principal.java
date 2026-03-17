/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ent_Des;

import java.util.ArrayList;

/**
 *
 * @author teamg
 */
public class Principal {
    /**
     * Aqui voy a realizar las pruebas para la parte practica
     * 
     * @param args 
     */
    public static void main(String[] args) {
        Metodos user = new Metodos();
        System.out.println("INICIANDO\n");
        //Registro a los usuarios, solo dos son validos
        user.registrarUsuario("Pepe", "pepe@test.com", "Vives2013", 10); //menor de edad
        user.registrarUsuario("Juan", "JohnJohnatan@test.com", "Vives2013", 30); //mayor de edad
        user.registrarUsuario("ITG", "intel@test.com", "Vives2013", -10); //edad negativa
        user.registrarUsuario("David", "davidis@test.com", "Vives2013", 1000); //edad imposible
        
        System.out.println("\n---------------------------------\n"); //pongo aqui un separador
        //muestro los usuarios por pantalla
        for (Usuario usuario : user.usuarios) {
            System.out.println(usuario);
        }
        
        user.actualizarEmail(user.usuarios, "Juan", "Juan@test.com"); //actualizo el email de Juan
        
        System.out.println("\n---------------------------------\n"); //pongo aqui otro separador
        for (Usuario usuario : user.usuarios) { //vuelvo a mostrar los usuarios para revisar si se cambio el correo
            System.out.println(usuario);
        }
        System.out.println("\n---------------------------------\n"); //pongo aqui un nuevo separador
        
        user.extraerRegistro(); //uso el metodo de exportarRegistro
        
        System.out.println("\nFINALIZANDO");
    }
}
