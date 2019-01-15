package sample;

public class ponuda {
    private int idPonuda;
    private int idPN;
    private float Cena;
    private float Popust;
    private float Prodajna_cena;

    private String DatumPonude;
    private String Kontinuitet_broj_iskopuraka;
    private String Nacin_isporuke;
    private String Rok_placanja;

    public static String IzdvojenaPonuda = null;


    public ponuda(int idPonuda, int idPN, float cena, float popust, float prodajna_cena, String datumPonude, String kontinuitet_broj_iskopuraka, String nacin_isporuke, String rok_placanja) {
        this.idPonuda = idPonuda;
        this.idPN = idPN;
        Cena = cena;
        Popust = popust;
        Prodajna_cena = prodajna_cena;
        DatumPonude = datumPonude;
        Kontinuitet_broj_iskopuraka = kontinuitet_broj_iskopuraka;
        Nacin_isporuke = nacin_isporuke;
        Rok_placanja = rok_placanja;
    }

    public ponuda(int idPonuda, int idPN, float cena, float popust, float prodajna_cena) {
        this.idPonuda = idPonuda;
        this.idPN = idPN;
        Cena = cena;
        Popust = popust;
        Prodajna_cena = prodajna_cena;
    }

    public int getIdPonuda() {
        return idPonuda;
    }

    public void setIdPonuda(int idPonuda) {
        this.idPonuda = idPonuda;
    }

    public int getIdPN() {
        return idPN;
    }

    public void setIdPN(int idPN) {
        this.idPN = idPN;
    }

    public float getCena() {
        return Cena;
    }

    public void setCena(float cena) {
        Cena = cena;
    }

    public float getPopust() {
        return Popust;
    }

    public void setPopust(float popust) {
        Popust = popust;
    }

    public float getProdajna_cena() {
        return Prodajna_cena;
    }

    public void setProdajna_cena(float prodajna_cena) {
        Prodajna_cena = prodajna_cena;
    }

    public String getDatumPonude() {
        return DatumPonude;
    }

    public void setDatumPonude(String datumPonude) {
        DatumPonude = datumPonude;
    }

    public String getKontinuitet_broj_iskopuraka() {
        return Kontinuitet_broj_iskopuraka;
    }

    public void setKontinuitet_broj_iskopuraka(String kontinuitet_broj_iskopuraka) {
        Kontinuitet_broj_iskopuraka = kontinuitet_broj_iskopuraka;
    }

    public String getNacin_isporuke() {
        return Nacin_isporuke;
    }

    public void setNacin_isporuke(String nacin_isporuke) {
        Nacin_isporuke = nacin_isporuke;
    }

    public String getRok_placanja() {
        return Rok_placanja;
    }

    public void setRok_placanja(String rok_placanja) {
        Rok_placanja = rok_placanja;
    }
}
