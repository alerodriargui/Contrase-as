/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contraseñas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class Contraseñas {

    private String link;
    private String nomUsuario;
    private String contraseña;
    private int longitudContraseña;
    Web web = new Web();
    Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        new Contraseñas().inicio();
    }

    private void inicio() {
        System.out.println("*BIENVENIDO AL PROGRAMA DE SOTE, DESDE AQUÍ PODRÁS GENERAR UNA CONTRASEÑA RANDOM Y GUARDARLA EN UN ARCHIVO .TXT* \n");
        System.out.println("Introduce el link de la página que quieras que guarde: ");
        links();
        System.out.println("Introduce el nombre de usuario que quieras que guarde: ");
        usuarios();
        contraseñas();
        fichero();
    }

    private void links() {
        link = leer.nextLine();
        web.setLink(link);
    }

    private void usuarios() {
        nomUsuario = leer.nextLine();
        web.setUsuario(nomUsuario);
    }

    private void contraseñas() {
        System.out.println("Introduce la longitud de la contraseña: ");
        longitudContraseña = leer.nextInt();
        System.out.println("Aquí tienes tu contraseña: ");
        contraseña = web.generarContraseña(longitudContraseña);
        web.setContraseña(contraseña);
    }

    private void fichero() {
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            File file = new File("Contraseñas.txt");
            // Si el archivo no existe, se crea!
            if (!file.exists()) {
                file.createNewFile();
            }
            // flag true, indica adjuntar información al archivo.
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write("\n");
            bw.write("\n");
            bw.write(web.getLink());
            bw.write("\n");
            bw.write(web.getUsuario());
            bw.write("\n");
            bw.write(web.getContraseña());
            System.out.println("Información agregada!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //Cierra instancias de FileWriter y BufferedWriter
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
