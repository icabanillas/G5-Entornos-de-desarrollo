/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ent_Des;

/**
 *
 * @author inteltg
 */
public class Usuario {

    private String nombre;
    private String email;
    private String pass;
    private int edad;
    
    /**
     * 
     * @param nombre
     * @param email
     * @param pass
     * @param edad
     * @throws Error_Des 
     * Este es el constructor de Usuario
     */
    public Usuario(String nombre, String email, String pass, int edad) throws Error_Des {
        //todos los datos que recibe se controlan desde su setter correspondiente
        //de lo contrario, tengo que crear la condicion individual de cada uno
        //si algo sufre un cambio lo tengo que cambiar aqui y en los setters
        //al usar los setters para crear el objeto de esta forma ya controlo los errores
        setNombre(nombre);
        setEmail(email);
        setPass(pass);
        setEdad(edad);
        enviarEmail(email, edad);
    }
    
    /**
     * 
     * @return 
     */
    public int getEdad() {
        return edad;
    }
    
    /**
     * 
     * @param edad
     * @throws Error_Des 
     * Setter de Edad
     */
    public void setEdad(int edad) throws Error_Des {
        if (edad >= 0 && edad < 130) { //limito la edad entre 0 y 129 (ya es muy raro que alguien viva mas de 130 anyos)
            this.edad = edad;
        } else {
            throw new Error_Des("Age is not valid");
        }

    }
    
    /**
     * 
     * @return 
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * 
     * @param nombre
     * @throws Error_Des 
     * Setter de Nombre
     */
    public void setNombre(String nombre) throws Error_Des {
        if (!nombre.isBlank()) { //si el nombre esta en blanco, salta error
            this.nombre = nombre;
        } else {
            throw new Error_Des("Name is invalid/empty");
        }

    }
    
    /**
     * 
     * @return 
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * 
     * @param email
     * @throws Error_Des 
     * Setter de Email
     */
    public void setEmail(String email) throws Error_Des {
        if (ValidadorEmail(email)) { //si la validacion es invalida salta error y nunca se registra el email
            this.email = email;
        } else {
            throw new Error_Des("Error, email is not valid");
        }
    }
    
    
    /**
     * 
     * @return 
     */
    public String getPass() {
        return pass;
    }
    
    /**
     * 
     * @param pass
     * @throws Error_Des 
     * Setter de Password
     */
    public void setPass(String pass) throws Error_Des {
        if (!pass.isBlank()) { //si la password esta en blanco, no es valido y salta un error
            this.pass = pass;
        } else {
            throw new Error_Des("Password is empty");
        }
    }
    
    /**
     * 
     * @param mail
     * @return
     * @throws Error_Des 
     * Metodo de validacion de Emails
     * Devuelve true si es valido
     * Salta error si es invalido
     */
    public boolean ValidadorEmail(String mail) throws Error_Des {
        if (mail.isBlank()) { //si el email esta en blanco
            throw new Error_Des("Email length under 8");
        } else {
            if (mail.contains(".") && mail.contains("@")) { //si el email carece de @ y de . salta error
                return true; //si cumple con la estructura de un email, devuelve verdadero y el correo es valido
            } else {
                throw new Error_Des("Email is not valid, miss '@' or '.'");
            }
        }
    }
    
    /**
     * 
     * @return 
     * toString para mostrar la informacion del usuario (nombre, email y edad)
     * No muestra la password por motivos de seguridad
     */
    @Override
    public String toString() { //nunca se mostrara la password por seguridad
        return "Usuario{" + "nombre=" + nombre + ", email=" + email + ", edad=" + edad + '}';
    }
    
    /**
     * 
     * @param data
     * @param edad 
     */
    private void enviarEmail(String email, int edad) { //me llevo este metodo de Metodos al objeto Usuarios
        if (edad >= 18) { //si la edad es 18 o mas, simula el envio de un email
            System.out.println("Enviando correo a " + email);
        } else { //si no es mayor de edad, si informa
            System.out.println("El usuario es demasiado joven (-18)");
        }
    }
    
    /**
     * 
     */
    public void extraerRegistro (){ //Introduzco un metodo para poder solicitar los registros
        Registros reg = new Registros();
        reg.exportarLogs();
    }
}
