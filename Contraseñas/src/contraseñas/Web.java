/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contraseñas;

import java.util.Random;

/**
 *
 * @author Alex
 */
public class Web {

    private String link;
    private String usuario;
    private String contraseña;

    public Web(String link, String usuario, String contraseña) {
        this.link = link;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public Web() {
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String generarContraseña(int longitud) {
        final char[] caracteres
                = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
                    'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                    'a', 'b', 'c', 'd', 'e', 'f', 'g', 'e', 'h', 'i', 'j', 'l', 'k', 'm',
                    'n', 'o', 'p', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                    '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
                    '@', '#', '!', '$', '€', '&', '[', ']', '%', '/', '(', ')', '=',
                    '?', '¿', '¡', '-', '_', ',', ';', '¬', '<', '>', '·', '+', '`',
                    '^', '{', '}', 'ç', 'Ñ', 'ñ', 'ª', 'º', '|', '*', '¨', '´'};

        // Esta cadena guardará al final del método la contraseña generada aleatoriamente
        String temporal = "";
        Random aleatorio = new Random();
        // Iteramos tantas veces como longitud de caracteres debe tener la contraseña
        for (int i = 0; i < longitud; i++) {
            // En cada iteracción a la cadena temporal le asignamos el carácter
            // asociado a la posición (generada aleatoriamente) del array caracteres
            temporal = temporal + caracteres[aleatorio.nextInt(caracteres.length)];
        }
        System.out.println(temporal);
        return temporal;
    }

}
