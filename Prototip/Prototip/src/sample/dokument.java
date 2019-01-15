package sample;

public class dokument {

    private int idDokument;
    private String VremeKreiranja;
    private String VremeIzmene;
    private String IzmenaKorisnik;
    private String Status;

    public dokument(int idDokument, String vremeKreiranja, String vremeIzmene, String izmenaKorisnik, String status) {
        this.idDokument = idDokument;
        VremeKreiranja = vremeKreiranja;
        VremeIzmene = vremeIzmene;
        IzmenaKorisnik = izmenaKorisnik;
        Status = status;
    }

    public int getIdDokument() {
        return idDokument;
    }

    public void setIdDokument(int idDokument) {
        this.idDokument = idDokument;
    }

    public String getVremeKreiranja() {
        return VremeKreiranja;
    }

    public void setVremeKreiranja(String vremeKreiranja) {
        VremeKreiranja = vremeKreiranja;
    }

    public String getVremeIzmene() {
        return VremeIzmene;
    }

    public void setVremeIzmene(String vremeIzmene) {
        VremeIzmene = vremeIzmene;
    }

    public String getIzmenaKorisnik() {
        return IzmenaKorisnik;
    }

    public void setIzmenaKorisnik(String izmenaKorisnik) {
        IzmenaKorisnik = izmenaKorisnik;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
