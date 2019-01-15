package sample;

public class stavka {
    private int idDokumenta;
    private int Proizvodi_idProizvodi;
    private int Kolicina;
    private float Cena;

    public stavka(int idDokumenta, int proizvodi_idProizvodi, int kolicina, float cena) {
        this.idDokumenta = idDokumenta;
        Proizvodi_idProizvodi = proizvodi_idProizvodi;
        Kolicina = kolicina;
        Cena = cena;
    }

    public int getIdDokumenta() {
        return idDokumenta;
    }

    public void setIdDokumenta(int idDokumenta) {
        this.idDokumenta = idDokumenta;
    }

    public int getProizvodi_idProizvodi() {
        return Proizvodi_idProizvodi;
    }

    public void setProizvodi_idProizvodi(int proizvodi_idPoizvodi) {
        Proizvodi_idProizvodi = proizvodi_idPoizvodi;
    }

    public int getKolicina() {
        return Kolicina;
    }

    public void setKolicina(int kolicina) {
        Kolicina = kolicina;
    }

    public float getCena() {
        return Cena;
    }

    public void setCena(float cena) {
        Cena = cena;
    }
}
