/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 REFACTORIZACIÓN (Principio SRP):
 Clase especializada en el registro de actividad.
 Dejamos la clase GestionUsuarios más limpia y enfocada en su tarea principal.
 */
public class GestionarLogs {
    
    public void exportarLogs() {
        System.out.println("Historial de actividad exportado correctamente.");
    }
}