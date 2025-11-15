package com.example.ghosh_2207100_cvbuilder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

public class CreateCVController {

    @FXML private Button uploadButton;
    @FXML private ImageView profileImagePreview;

    @FXML private TextField fullNameField;
    @FXML private TextField emailField;
    @FXML private TextField phoneField;
    @FXML private TextField addressField;

    @FXML private TableView<?> educationTable;

    @FXML private TextArea skillsArea;
    @FXML private TextArea experienceArea;
    @FXML private TextArea projectsArea;

    @FXML private Button generateButton;

    @FXML
    private void handleUploadPhoto(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Profile Photo");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );

        File file = fileChooser.showOpenDialog(
                ((Node) event.getSource()).getScene().getWindow()
        );

        if (file != null) {
            Image img = new Image(file.toURI().toString());
            profileImagePreview.setImage(img);
        }
    }

    @FXML
    private void handleGenerateCV(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("PreviewCV.fxml"));
        Scene scene = new Scene(loader.load());

        PreviewCVController controller = loader.getController();
        controller.setData(
                safeText(fullNameField.getText()),
                safeText(emailField.getText()),
                safeText(phoneField.getText()),
                safeText(addressField.getText()),
                safeText(skillsArea.getText()),
                safeText(experienceArea.getText()),
                safeText(projectsArea.getText()),
                profileImagePreview.getImage() );

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Preview CV");
        stage.show();}

    private String safeText(String s) {
        return s == null ? "" : s;
    }}
