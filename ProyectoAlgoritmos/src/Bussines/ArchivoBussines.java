/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussines;

import Data.Archivo;
import Data.ListaCircular;
import Domain.Pelicula;

/**
 *
 * @author hanse
 */
public class ArchivoBussines {
    Archivo archivoData;

    public ArchivoBussines() {
        archivoData = new Archivo();
    }//constructor

    public void insertarArchivoBussiness(Pelicula pelicula, String ruta) {
        this.archivoData.insertarArchivo(pelicula, ruta);
    }//insertarArchivoBussiness

    public ListaCircular[] leerArchivoBussiness(String ruta) {
        return this.archivoData.leerArchivo(ruta);
    }//leerArchivoBussiness
}//fin clase
