package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class konkretnaPonudaController implements Initializable {

    @FXML
    private TextField deleteStavkaId;

    @FXML
    private TextField idProizvoda;

    @FXML
    private TextField Kolicina;

    @FXML
    private TextField CenaAdd;

    @FXML
    private TextField Rok_placanja;

    @FXML
    private TextField Popust;

    @FXML
    private TextField Nacin_isporuke;

    @FXML
    private TextField idPN;

    @FXML
    private Button update;

    @FXML
    private TextField Cena;

    @FXML
    private Label idPonude;

    @FXML
    private TextField DatumPonude;

    @FXML
    private TextField Kontinuitet_broj_isporuka;

    @FXML
    private TextField Prodajna_cena;

    @FXML
    private Label informacije;

    @FXML
    private TableView<stavka> tableStavke;

    @FXML
    private TableColumn<?, ?> kol2;

    @FXML
    private TableColumn<?, ?> kol3;

    @FXML
    private TableColumn<?, ?> kol1;

    @FXML
    private TableColumn<?, ?> kol4;

    private ObservableList<stavka> data;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inicijalizuj();
    }

    @FXML
    void updatePonuda(ActionEvent event) {
        if( ponuda.IzdvojenaPonuda != null && ponuda.IzdvojenaPonuda != "" && !ponuda.IzdvojenaPonuda.isEmpty()) {

            int x = Integer.parseInt(Popust.getText());

            System.out.println(x);

            try {
                Connection conn = Connect();

                Statement stmt = null;

                stmt = conn.createStatement();
                String sql = "UPDATE Ponuda " +
                        "SET Popust = " + x + " WHERE idPonuda = " + Integer.parseInt(ponuda.IzdvojenaPonuda);
                stmt.executeUpdate(sql);


                ResultSet rs = null;

                rs = conn.createStatement().executeQuery("select * from Ponuda WHERE idPonuda = " + Integer.parseInt(ponuda.IzdvojenaPonuda));

                while (rs.next()) {

                    Popust.setText(Integer.toString(rs.getInt(8)));
                    Prodajna_cena.setText(Integer.toString(rs.getInt(9)));

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                Connection conn = Connect();

                Statement stmt = null;

                String id = idPN.getText();
                String Datum = DatumPonude.getText();

                stmt = conn.createStatement();
                String sql = "INSERT INTO Ponuda(idPN) " +
                        "VALUES(" + id + ")";
                stmt.executeUpdate(sql);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void delete(ActionEvent event) throws IOException {
        try {

            stavka selectedItem = tableStavke.getSelectionModel().getSelectedItem();

            //System.out.println(selectedItem.getIdDokumenta() + " " + selectedItem.getProizvodi_idPoizvodi());

            tableStavke.getItems().remove(selectedItem);

            Connection conn = Connect();

            Statement stmt = null;

            stmt = conn.createStatement();
            String sql = "DELETE FROM Stavka " +
                    "WHERE idDokumenta = " + selectedItem.getIdDokumenta() + " and Proizvodi_idProizvodi = " + selectedItem.getProizvodi_idProizvodi();
            stmt.executeUpdate(sql);

            inicijalizuj();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @FXML
    void dodaj(ActionEvent event) throws IOException {
        try {

            int idDok = Integer.parseInt(deleteStavkaId.getText());
            int idPro = Integer.parseInt(idProizvoda.getText());
            int Kol = Integer.parseInt(Kolicina.getText());
            //float Cena = Float.parseFloat(CenaAdd.getText());


            stavka selectedItem = tableStavke.getSelectionModel().getSelectedItem();

            //System.out.println(selectedItem.getIdDokumenta() + " " + selectedItem.getProizvodi_idPoizvodi());

            tableStavke.getItems().remove(selectedItem);

            Connection conn = Connect();

            Statement stmt = null;

            stmt = conn.createStatement();
            String sql = "INSERT INTO Stavka(idDokumenta,Proizvodi_idProizvodi,Kolicina) " +
                    "VALUES(" + idDok + "," + idPro + "," + Kol + ")";
            stmt.executeUpdate(sql);

            inicijalizuj();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void inicijalizuj(){
        if( ponuda.IzdvojenaPonuda != null && ponuda.IzdvojenaPonuda != "" && !ponuda.IzdvojenaPonuda.isEmpty()) {

            informacije.setText("Informacije o ponudi sa id:");

            idPonude.setText(ponuda.IzdvojenaPonuda);
            try {
                Connection conn = Connect();

                ResultSet rs = null;

                rs = conn.createStatement().executeQuery("select * from Ponuda where idPonuda = " + Integer.parseInt(ponuda.IzdvojenaPonuda));

                while (rs.next()) {

                    idPN.setText(Integer.toString(rs.getInt(2)));
                    DatumPonude.setText(rs.getString(3));
                    Kontinuitet_broj_isporuka.setText(rs.getString(4));
                    Nacin_isporuke.setText(rs.getString(5));
                    Rok_placanja.setText(rs.getString(6));
                    Cena.setText(Integer.toString(rs.getInt(7)));
                    Popust.setText(Integer.toString(rs.getInt(8)));
                    Prodajna_cena.setText(Integer.toString(rs.getInt(9)));

                    DatumPonude.setText("2018-12-12");
                    Rok_placanja.setText("2019-02-02");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                Connection conn = Connect();
                data = FXCollections.observableArrayList();

                ResultSet rs = null;

                rs = conn.createStatement().executeQuery("select * from Stavka WHERE idDokumenta = " + Integer.parseInt(ponuda.IzdvojenaPonuda));

                while (rs.next()){

                    data.add(new stavka(rs.getInt(1),rs.getInt(2)
                            ,rs.getInt(3),rs.getFloat(4)));

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            kol1.setCellValueFactory(new PropertyValueFactory<>("idDokumenta"));
            kol2.setCellValueFactory(new PropertyValueFactory<>("Proizvodi_idProizvodi"));
            kol3.setCellValueFactory(new PropertyValueFactory<>("Kolicina"));
            kol4.setCellValueFactory(new PropertyValueFactory<>("Cena"));

            tableStavke.setItems(null);
            tableStavke.setItems(data);

        }
        else {
            informacije.setText("Unesite informacije o novoj ponudi:");
            update.setText("Dodaj");

        }

    }


    public Connection Connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/veleprodaja","nikola","nikola");

            return con;
        }catch(Exception e){ System.out.println(e);}
        return null;
    }

}
