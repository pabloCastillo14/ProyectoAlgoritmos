package Domain;

/**
 *
 * @author Pablo Castillo
 */
public class Pelicula {

    private String code;
    private String title;
    private String gender;
    private String total;
    private String subtitle;
    private String premier;

    public Pelicula() {
        this.code = "";
        this.title = "";
        this.gender = "";
        this.total = "";
        this.subtitle = "";
        this.premier = "";

    }

    public Pelicula(String code, String title, String gender, String total, String subtitle, String premier) {
        this.code = code;
        this.title = title;
        this.gender = gender;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGendeer() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
        return "Pelicula{" + "code=" + code + ", title=" + title + ", gender=" + gender + ", total=" + total + ", subtitle=" + subtitle + ", premier=" + premier + '}';
    }
}//fin clase
