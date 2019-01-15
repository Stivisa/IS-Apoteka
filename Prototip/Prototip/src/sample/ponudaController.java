package sample;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import java.sql.*;

public class ponudaController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private Label natpis;
    @FXML
    private Button btnLoad;
    @FXML
    private Button btnIzdvoji;
    @FXML
    private TextField unetiID;
    @FXML
    private TableColumn<?, ?> kol2;
    @FXML
    private TableColumn<?, ?> kol3;
    @FXML
    private TableColumn<?, ?> kol1;
    @FXML
    private TableView<ponuda> tablePonuda;
    @FXML
    private TableColumn<?, ?> kol4;
    @FXML
    private TableColumn<?, ?> kol5;

    @FXML
    private TableColumn<?, ?> col2;
    @FXML
    private TableColumn<?, ?> col3;
    @FXML
    private TableColumn<?, ?> col1;
    @FXML
    private TableView<dokument> tableDokument;
    @FXML
    private TableColumn<?, ?> col4;
    @FXML
    private TableColumn<?, ?> col5;




    private ObservableList<dokument> dataDok;


    private ObservableList<ponuda> data;

    @FXML
    void loadPonuda(ActionEvent event) {
        try {
            Connection conn = Connect();
            data = FXCollections.observableArrayList();

            dataDok = FXCollections.observableArrayList();

            ResultSet rs = null;

                rs = conn.createStatement().executeQuery("select idPonuda,idPN,Cena,Popust,Prodajna_cena from Ponuda");

            ResultSet rsD = null;

                rsD = conn.createStatement().executeQuery("select * from Dokument");

            while (rs.next()){

                data.add(new ponuda(rs.getInt(1),rs.getInt(2)
                        ,rs.getFloat(3),rs.getFloat(4),rs.getFloat(5)));

                while (rsD.next()){


                    if(rsD.getInt(1) == rs.getInt(1)) {
                        dataDok.add(new dokument(rsD.getInt(1), rsD.getString(2)
                                , rsD.getString(3), rsD.getString(4), rsD.getString(5)));
                        break;
                    }
                }


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        kol1.setCellValueFactory(new PropertyValueFactory<>("idPonuda"));
        kol2.setCellValueFactory(new PropertyValueFactory<>("idPN"));
        kol3.setCellValueFactory(new PropertyValueFactory<>("Cena"));
        kol4.setCellValueFactory(new PropertyValueFactory<>("Popust"));
        kol5.setCellValueFactory(new PropertyValueFactory<>("Prodajna_cena"));

        tablePonuda.setItems(null);
        tablePonuda.setItems(data);

        col1.setCellValueFactory(new PropertyValueFactory<>("idDokument"));
        col2.setCellValueFactory(new PropertyValueFactory<>("VremeKreiranja"));
        col3.setCellValueFactory(new PropertyValueFactory<>("VremeIzmene"));
        col4.setCellValueFactory(new PropertyValueFactory<>("IzmenaKorisnik"));
        col5.setCellValueFactory(new PropertyValueFactory<>("Status"));

        tableDokument.setItems(null);
        tableDokument.setItems(dataDok);

    }

    public Connection Connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/veleprodaja","nikola","nikola");

            return con;
        }catch(Exception e){ System.out.println(e);}
        return null;
    }

    @FXML
    void izdvojiPonudu(ActionEvent event) throws IOException {
        ponuda.IzdvojenaPonuda = unetiID.getText();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("konkretnaPonuda.fxml"));

        Parent second = loader.load();

        Stage app_stage = new Stage();

        if( ponuda.IzdvojenaPonuda != null && ponuda.IzdvojenaPonuda != "" && !ponuda.IzdvojenaPonuda.isEmpty())
            app_stage.setTitle("Izmeni ponudu");
        else
            app_stage.setTitle("Dodaj ponudu");

        //app_stage.hide();
        app_stage.setScene(new Scene(second,600,550));
        app_stage.show();
    }

    @FXML
    void delete(ActionEvent event) throws IOException {
        try {
            ponuda.IzdvojenaPonuda = unetiID.getText();

            Connection conn = Connect();

            Statement stmt = null;

            stmt = conn.createStatement();
            String sql = "DELETE FROM Ponuda " +
                    "WHERE idPonuda = " + Integer.parseInt(ponuda.IzdvojenaPonuda) + "";
            stmt.executeUpdate(sql);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
