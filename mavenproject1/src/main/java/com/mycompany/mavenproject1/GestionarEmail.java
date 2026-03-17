/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;


/**
REFACTORIZACIÓN (Principio SRP):
 Clase encargada de la lógica de comunicación por correo electrónico.
 Lo separo de GestionUsuarios para que cada clase tenga una sola responsabilidad.
 Esta clase se encargará únicamente de las notificaciones.
 */
public class GestionarEmail {
    
    public void enviarBienvenida(String direccionEmail) {
        System.out.println("Enviando correo de bienvenida a: " + direccionEmail);
    }
}