package Module_11;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WoldegiorgisGradeBookApp  extends Application {

    private Stage primaryStage;
    private TextField firstNameField;
    private TextField lastNameField;
    private TextField courseField;
    private ComboBox<String> gradeComboBox;
    private TextArea resultArea;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Login");

        GridPane loginGrid = new GridPane();
        loginGrid.setPadding(new Insets(10, 10, 10, 10));
        loginGrid.setVgap(8);
        loginGrid.setHgap(10);

        // Username Label - Constraints use (child, column, row)
        Label userLabel = new Label("Username:");
        GridPane.setConstraints(userLabel, 0, 0);

        // Username Input
        TextField userInput = new TextField();
        GridPane.setConstraints(userInput, 1, 0);

        // Password Label
        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel, 0, 1);

        // Password Input
        PasswordField passInput = new PasswordField();
        GridPane.setConstraints(passInput, 1, 1);

        // Login Button
        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 1, 2);

        loginButton.setOnAction(e -> {
            if (userInput.getText().equals("user") && passInput.getText().equals("password")) {
                showGradeBookApp();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login Error");
                alert.setHeaderText(null);
                alert.setContentText("Invalid username or password.");
                alert.showAndWait();
            }
        });

        loginGrid.getChildren().addAll(userLabel, userInput, passLabel, passInput, loginButton);

        Scene loginScene = new Scene(loginGrid, 300, 200);
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    private void showGradeBookApp() {
        primaryStage.setTitle("Grade Book App");

        GridPane gradeBookGrid = new GridPane();
        gradeBookGrid.setPadding(new Insets(10, 10, 10, 10));
        gradeBookGrid.setVgap(10);
        gradeBookGrid.setHgap(10);

        Label firstNameLabel = new Label("First Name:");
        firstNameField = new TextField();
        Label lastNameLabel = new Label("Last Name:");
        lastNameField = new TextField();
        Label courseLabel = new Label("Course:");
        courseField = new TextField();
        Label gradeLabel = new Label("Grade:");
        gradeComboBox = new ComboBox<>();
        gradeComboBox.getItems().addAll("A", "B", "C", "D", "F");

        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> saveGrade());
        Button clearButton = new Button("Clear");
        clearButton.setOnAction(e -> clearForm());
        Button viewButton = new Button("View Grades");
        viewButton.setOnAction(e -> viewGrades());

        resultArea = new TextArea();
        resultArea.setEditable(false);

        gradeBookGrid.add(firstNameLabel, 0, 0);
        gradeBookGrid.add(firstNameField, 1, 0);
        gradeBookGrid.add(lastNameLabel, 0, 1);
        gradeBookGrid.add(lastNameField, 1, 1);
        gradeBookGrid.add(courseLabel, 0, 2);
        gradeBookGrid.add(courseField, 1, 2);
        gradeBookGrid.add(gradeLabel, 0, 3);
        gradeBookGrid.add(gradeComboBox, 1, 3);
        gradeBookGrid.add(saveButton, 0, 4);
        gradeBookGrid.add(clearButton, 1, 4);
        gradeBookGrid.add(viewButton, 2, 4);
        gradeBookGrid.add(resultArea, 0, 5, 3, 1);

        Scene gradeBookScene = new Scene(gradeBookGrid, 400, 300);
        primaryStage.setScene(gradeBookScene);
    }

    private void saveGrade() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String course = courseField.getText();
        String grade = gradeComboBox.getValue();

        if (firstName.isEmpty() || lastName.isEmpty() || course.isEmpty() || grade == null) {
            showAlert("Error", "Please fill in all fields.");
            return;
        }

        try (FileWriter writer = new FileWriter("grades.csv", true)) {
            writer.write(firstName + "," + lastName + "," + course + "," + grade + "\n");
        } catch (IOException e) {
            showAlert("Error", "Failed to save grade.");
        }

        clearForm();
    }

    private void clearForm() {
        firstNameField.clear();
        lastNameField.clear();
        courseField.clear();
        gradeComboBox.setValue(null);
    }

    private void viewGrades() {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("grades.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            showAlert("Error", "Failed to load grades.");
        }
        resultArea.setText(content.toString());
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

