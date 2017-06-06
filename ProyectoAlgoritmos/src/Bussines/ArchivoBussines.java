/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussines;

import Data.Archivo;
import Domain.Pelicula;

/**
 *
 * @author Pablo Castillo
 */
public class ArchivoBussines {
    Archivo archivoData;

    public ArchivoBussines() {
        archivoData=new Archivo();
    }
    
    
    public void insertarArchivoBussiness(Pelicula pelicula) {


        this.archivoData.insertarArchivo(pelicula);
    }
    
    public void leerArchivoBussiness() {
        archivoData.leerArchivo();
    }
    
}
