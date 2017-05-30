package Domain;

/**
 *
 * @author Pablo Castillo
 */
public class Pelicula {

    private String code;
    private String titulo;
    private String genero;
    private String total;
    private String subtitle;
    private String premier;

    public Pelicula() {
        this.code = "";
        this.titulo = "";
        this.genero = "";
        this.total = "";
        this.subtitle = "";
        this.premier = "";

    }

    public Pelicula(String code, String titulo, String genero, String total, String subtitle, String premier) {
        this.code = code;
        this.titulo = titulo;
        this.genero = genero;
        this.total = total;
        this.subtitle = subtitle;
        this.premier = premier;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPremier() {
        return premier;
    }

    public void setPremier(String premier) {
        this.premier = premier;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "code=" + code + ", titulo=" + titulo + ", genero=" + genero + ", total=" + total + ", subtitle=" + subtitle + ", premier=" + premier + '}';
    }

    

}//fin clase
