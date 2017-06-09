package Data;

import Domain.Pelicula;
import com.csvreader.CsvReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.csvreader.CsvWriter;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;

/**
 *
 * @author Pablo Castillo
 */
public class Archivo {

    ListaCircular listaGeneral;
    ListaCircular drama;
    ListaCircular comedia;
    ListaCircular chilldish;
    ListaCircular action;
    ListaCircular romance;
    ListaCircular fiction;
    String ruta = "";

    public Archivo() {
        listaGeneral = new ListaCircular();
        drama = new ListaCircular();
        comedia = new ListaCircular();
        chilldish = new ListaCircular();
        action = new ListaCircular();
        romance = new ListaCircular();
        fiction = new ListaCircular();
    }//constructor

    public String fileChoooserData() {
        JOptionPane.showMessageDialog(null, "selecciones el archivo a utilizar");
        boolean verifica = true;
        while (verifica == true) {
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(file);
            File abrir = file.getSelectedFile();
            if (abrir.getPath().indexOf(".csv") != -1) {
                this.ruta = String.valueOf(abrir);
                JOptionPane.showMessageDialog(null, "el archivo es valido");
                verifica = false;
            } else {
                JOptionPane.showMessageDialog(null, "el archivo es invalido");
                JOptionPane.showMessageDialog(null, "por favor cargue un archivo");
            }
        }
        return ruta;
    }//fileChoooserData()

    public void insertarArchivo(Pelicula pelicula, String ruta) {
        File file = new File(ruta);
        boolean alreadyExists = new File("datos").exists();
        if (alreadyExists) {
            File ArchivoPeliculas = new File("datos");
            ArchivoPeliculas.delete();
        }//if
        try {
            CsvWriter csvOutput = new CsvWriter(new FileWriter(file, true), ',');
            int cont = (int) file.length();
            cont = cont + 1;
            String codigo = "";
            codigo = codigo.valueOf(cont);
            pelicula.setCode(codigo);
            csvOutput.write((pelicula.getCode()));
            csvOutput.write(pelicula.getTitle());
            csvOutput.write(pelicula.getGendeer());
            csvOutput.write(pelicula.getTotal());
            csvOutput.write(pelicula.getSubtitle());
            csvOutput.write(pelicula.getPremier());
            csvOutput.endRecord();
            csvOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }//try-catch
    }//insertarArchivo

    public ListaCircular[] leerArchivo(String path) {
        ArrayList<Pelicula> lista1 = new ArrayList<>();
        try {
            CsvReader peliculas_import = new CsvReader(path);
            peliculas_import.readHeaders();
            while (peliculas_import.readRecord()) {
                Pelicula peliNueva = new Pelicula();
                String codigo = peliculas_import.get(0);
                String titulo = peliculas_import.get(1);
                String genero = peliculas_import.get(2);
                String total = peliculas_import.get(3);
                String subtitulo = peliculas_import.get(4);
                String premier = peliculas_import.get(5);
                peliNueva.setCode(codigo);
                peliNueva.setTitle(titulo);
                peliNueva.setGender(genero);
                peliNueva.setTotal(total);
                peliNueva.setSubtitle(subtitulo);
                peliNueva.setPremier(premier);
                if (peliNueva.getGendeer().equals("1000")) {
                    drama.insertInOrder(peliNueva);
                } else if (peliNueva.getGendeer().equals("2000")) {
                    comedia.insertInOrder(peliNueva);
                } else if (peliNueva.getGendeer().equals("3000")) {
                    chilldish.insertInOrder(peliNueva);
                } else if (peliNueva.getGendeer().equals("4000")) {
                    action.insertInOrder(peliNueva);
                } else if (peliNueva.getGendeer().equals("5000")) {
                    romance.insertInOrder(peliNueva);
                } else if (peliNueva.getGendeer().equals("6000")) {
                    fiction.insertInOrder(peliNueva);
                }//if-else/s
            }//while
            peliculas_import.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }//try-catch
        ListaCircular vector[] = new ListaCircular[6];
        vector[0] = drama;
        vector[1] = comedia;
        vector[2] = chilldish;
        vector[3] = action;
        vector[4] = romance;
        vector[5] = fiction;
        return vector;
    }//leerArchivo
}//fin clase
