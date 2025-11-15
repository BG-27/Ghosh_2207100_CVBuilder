package com.example.ghosh_2207100_cvbuilder;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class PreviewCVController {

    @FXML private ImageView profileImageView;
    @FXML private Label nameLabel;
    @FXML private Label emailLabel;
    @FXML private Label phoneLabel;
    @FXML private Label addressLabel;

    @FXML private VBox educationVBox;
    @FXML private VBox skillsVBox;
    @FXML private VBox experienceVBox;
    @FXML private VBox projectsVBox;

    public void setData(String name, String email, String phone, String address,
                        String skills, String experience, String projects, Image profileImage, String education) {

        nameLabel.setText(name != null && !name.isEmpty() ? name : "No name provided");
        emailLabel.setText(email != null && !email.isEmpty() ? email : "No email provided");
        phoneLabel.setText(phone != null && !phone.isEmpty() ? phone : "No phone provided");
        addressLabel.setText(address != null && !address.isEmpty() ? address : "No address provided");

        if (profileImage != null) {
            profileImageView.setImage(profileImage);
        } else {
            profileImageView.setImage(null);
        }

        skillsVBox.getChildren().clear();
        if (skills != null && !skills.trim().isEmpty()) {
            String[] items = skills.split("[,\\n]+");
            for (String it : items) {
                Label l = new Label(it.trim());
                skillsVBox.getChildren().add(l);
            }
        } else {
            skillsVBox.getChildren().add(new Label("No skills provided."));
        }

        experienceVBox.getChildren().clear();
        if (experience != null && !experience.trim().isEmpty()) {
            String[] ex = experience.split("\\n+");
            for (String e : ex) {
                Label l = new Label(e.trim());
                experienceVBox.getChildren().add(l);
            }
        } else {
            experienceVBox.getChildren().add(new Label("No experience provided."));
        }

        projectsVBox.getChildren().clear();
        if (projects != null && !projects.trim().isEmpty()) {
            String[] pr = projects.split("\\n+");
            for (String p : pr) {
                Label l = new Label(p.trim());
                projectsVBox.getChildren().add(l);
            }
        } else {
            projectsVBox.getChildren().add(new Label("No projects provided."));
        }

        educationVBox.getChildren().clear();
        if (education != null && !education.trim().isEmpty()) {
            String[] eduItems = education.split("[,\\n]+"); // Assuming education details are separated by commas or new lines
            for (String edu : eduItems) {
                Label educationLabel = new Label(edu.trim());
                educationVBox.getChildren().add(educationLabel);
            }
        } else {
            educationVBox.getChildren().add(new Label("No education details provided."));
        }
    }
}
