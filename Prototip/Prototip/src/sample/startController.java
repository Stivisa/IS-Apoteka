package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class startController {


    @FXML
    void ponuda(ActionEvent event) throws IOException {
        //System.out.println("Prodaja");
        Parent second = FXMLLoader.load(getClass().getResource("ponuda.fxml"));
        Scene second_scene = new Scene(second,1120,450);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //app_stage.hide();
        app_stage.setTitle("Ponude");
        app_stage.setScene(second_scene);
        app_stage.show();

    }

    @FXML
    void login(ActionEvent event) throws IOException {
        //System.out.println("Prodaja");
        Parent second = FXMLLoader.load(getClass().getResource("sekcije.fxml"));
        Scene second_scene = new Scene(second,450,350);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //app_stage.hide();
        app_stage.setTitle("Moduli");
        app_stage.setScene(second_scene);
        app_stage.show();

    }

    @FXML
    void sekcijeProdaja(ActionEvent event) throws IOException {
        //System.out.println("Prodaja");
        Parent second = FXMLLoader.load(getClass().getResource("prodaja.fxml"));
        Scene second_scene = new Scene(second,500,300);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //app_stage.hide();
        app_stage.setTitle("Prodaja");
        app_stage.setScene(second_scene);
        app_stage.show();

    }

}
