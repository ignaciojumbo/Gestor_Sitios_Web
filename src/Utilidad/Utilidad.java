/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidad;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Utilidad {

    //metodo para validar el link de la pagina
    public boolean urlValidator(String url) {
        boolean s = false;
        try {
            new URL(url).toURI();
            s = true;
            return s;
        } catch (URISyntaxException | MalformedURLException exception) {
            s = false;
            return s;
        }
    }

    public String fecha(Date fecha) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        return f.format(fecha);

    }
     //metodo para encriptar la clave 
    public String encriptadorclave(String clave){
        
        char array[] = clave.toCharArray(); // se crea un arreglo de caracteres
        for (int i = 0; i < array.length; i++) {//se lo recorre
            array[i] = (char) (array[i] + 5);
            
        }
        String encriptado = String.valueOf(array);
        return encriptado;
        
    }
    //metodo para desencriptar la clave 
        public String Desencriptadoclave(String clave){
        
        char arrayD[] = clave.toCharArray();
        for (int i = 0; i < arrayD.length; i++) {
            arrayD[i] = (char) (arrayD[i] -5);
            
        }
        String desencriptado = String.valueOf(arrayD);
        return desencriptado;
        
    }

}
