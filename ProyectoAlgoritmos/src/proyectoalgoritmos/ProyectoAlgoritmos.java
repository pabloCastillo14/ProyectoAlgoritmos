
package proyectoalgoritmos;

import Data.Archivo;
import Data.Drama;
import Domain.Pelicula;
import GUI.MainWindow;


/**
 *
 * @author Pablo Castillo
 */
public class ProyectoAlgoritmos {

    public static void main(String[] args) {
 
        MainWindow principal=new MainWindow();
        principal.setVisible(true);
        Archivo ar=new Archivo();
        Pelicula peli;
//        peli=new Pelicula("1", "hanzell"," 1"," 1"," 1","1");
//      peli=new Pelicula("1", "pablo"," 1"," 1"," 1","1");
           //  peli=new Pelicula("1", "pabaalo"," 1"," 1"," 1","1");
//        ar.insertarArchivo(peli);
//    ar.leerArchivo();
//       Lista li =new Lista();
//       li.insertar(peli);
//       li.desplegar();
        
        ar.leerArchivo();
        
    }
    
}
