/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ent_Des;

/**
 *
 * @author inteltg
 */
public class Error_Des extends Exception{
//Heredo las funciones de la clase Exception para crear mi propia exception para controlar
    public Error_Des(String message) { //creo mi propio error para controlar la creacion de usuario
        super(message);
    }
    
}

