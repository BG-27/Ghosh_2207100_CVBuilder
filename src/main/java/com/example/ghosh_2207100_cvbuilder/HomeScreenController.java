package com.example.ghosh_2207100_cvbuilder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;

public class HomeScreenController {

    @FXML
    private void handleCreateCV(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CreateCV.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Create Your CV");
        stage.show();
    }
}
