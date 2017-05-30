
package proyectoalgoritmos;

import Data.Archivo;
import Domain.Pelicula;
import GUI.VentanaPrincipal;

/**
 *
 * @author Pablo Castillo
 */
public class ProyectoAlgoritmos {

    public static void main(String[] args) {
 
        VentanaPrincipal ventana =new VentanaPrincipal();
        Archivo ar=new Archivo();
        Pelicula peli;
//        peli=new Pelicula("1", "hanzell"," 1"," 1"," 1","1");
//        peli=new Pelicula("1", "pablo"," 1"," 1"," 1","1");
             peli=new Pelicula("1", "pabaalo"," 1"," 1"," 1","1");
        ar.insertarArchivo(peli);
    ar.leerArchivo();
    }
    
}
