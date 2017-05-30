/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Domain.Pelicula;
import com.csvreader.CsvReader;
import java.awt.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.csvreader.CsvWriter;
import java.io.FileNotFoundException;

/**
 *
 * @author Pablo Castillo
 */
public class Archivo {

    File file = new File("datos.csv");

    public void insertarArchivo(Pelicula pelicula) {

        //String outputFile = "Empleados3.csv";
        boolean alreadyExists = new File("datos").exists();

        if (alreadyExists) {
            File ArchivoEmpleados = new File("datos");
            ArchivoEmpleados.delete();
        }

        try {

            CsvWriter csvOutput = new CsvWriter(new FileWriter(file, true), ',');

            csvOutput.write((pelicula.getCode()));
            csvOutput.write(pelicula.getTitulo());
            csvOutput.write(pelicula.getGenero());
            csvOutput.write(pelicula.getTotal());
            csvOutput.write(pelicula.getSubtitle());
            csvOutput.write(pelicula.getPremier());
            csvOutput.endRecord();
            csvOutput.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void leerArchivo() {
        try {
           // List<Pelicula> usuarios = new ArrayList<Pelicula>();
            // List<Pelicula>peli=new ArrayList<Pelicula>;
            CsvReader empleados_import = new CsvReader("datos.csv");
            empleados_import.readHeaders();
            Pelicula peliNueva = new Pelicula();
            while (empleados_import.readRecord()) {

//   peliNueva.setCode(empleados_import.get(0));
                String codigo = empleados_import.get(0);
                String titulo = empleados_import.get(1);
                String genero = empleados_import.get(2);
                String total = empleados_import.get(3);
                String subtitulo = empleados_import.get(4);
                String premier = empleados_import.get(5);
          peliNueva.setCode(codigo);
          peliNueva.setTitulo(titulo);
          peliNueva.setGenero(genero);
          peliNueva.setTotal(total);
          peliNueva.setSubtitle(subtitulo);
          peliNueva.setPremier(premier);
                JOptionPane.showMessageDialog(null, peliNueva);
            }

            empleados_import.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
