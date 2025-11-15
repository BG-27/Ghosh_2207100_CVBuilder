package com.example.ghosh_2207100_cvbuilder;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CreateCVController {

    @FXML private TextField fullNameField;
    @FXML private TextField emailField;
    @FXML private TextField phoneField;
    @FXML private TextField addressField;

    @FXML private TextArea educationArea;
    @FXML private TextArea skillsArea;
    @FXML private TextArea experienceArea;
    @FXML private TextArea projectsArea;

    @FXML
    private void handleGenerateCV() {
        System.out.println("Generate CV Clicked!");
        System.out.println("Name: " + fullNameField.getText());

    }
}
