package Module_10;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.*;

public class WoldegiorgisGradeBookApp extends Application {

    private Stage stage;

    @Override
    public void start(Stage primaryStage) {
        this.stage = primaryStage;
        showLoginScreen();
    }

    private void showLoginScreen() {
        // Create labels and text fields
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        // Create login button
        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            if (authenticate(username, password)) {
                showGradeBookScreen();
            } else {
                showAlert(Alert.AlertType.ERROR, "Login Error", "Invalid username or password");
            }
        });

        // Layout using GridPane
        GridPane loginGrid = new GridPane();
        loginGrid.setPadding(new Insets(10, 10, 10, 10));
        loginGrid.setVgap(8);
        loginGrid.setHgap(10);

        loginGrid.add(usernameLabel, 0, 0);
        loginGrid.add(usernameField, 1, 0);
        loginGrid.add(passwordLabel, 0, 1);
        loginGrid.add(passwordField, 1, 1);
        loginGrid.add(loginButton, 1, 2);

        Scene loginScene = new Scene(loginGrid, 300, 200);
        stage.setScene(loginScene);
        stage.setTitle("Login");
        stage.show();
    }

    private void showGradeBookScreen() {
        // Create labels
        Label firstNameLabel = new Label("First Name:");
        Label lastNameLabel = new Label("Last Name:");
        Label courseLabel = new Label("Course:");
        Label gradeLabel = new Label("Grade:");

        // Create text fields
        TextField firstNameField = new TextField();
        TextField lastNameField = new TextField();
        TextField courseField = new TextField();

        // Create ComboBox for grade
        ComboBox<String> gradeComboBox = new ComboBox<>();
        gradeComboBox.getItems().addAll("A", "B", "C", "D", "F");

        // Create buttons
        Button clearButton = new Button("Clear");
        Button viewGradesButton = new Button("View Grades");
        Button saveButton = new Button("Save");

        // Clear form action
        clearButton.setOnAction(e -> {
            firstNameField.clear();
            lastNameField.clear();
            courseField.clear();
            gradeComboBox.getSelectionModel().clearSelection();
        });

        // View grades action
        viewGradesButton.setOnAction(e -> {
            viewGrades();
        });

        // Save grade action
        saveButton.setOnAction(e -> {
            saveGrade(firstNameField.getText(), lastNameField.getText(), courseField.getText(), gradeComboBox.getValue());
        });

        // Layout using GridPane
        GridPane gradeBookGrid = new GridPane();
        gradeBookGrid.setPadding(new Insets(10, 10, 10, 10));
        gradeBookGrid.setVgap(8);
        gradeBookGrid.setHgap(10);

        gradeBookGrid.add(firstNameLabel, 0, 0);
        gradeBookGrid.add(firstNameField, 1, 0);
        gradeBookGrid.add(lastNameLabel, 0, 1);
        gradeBookGrid.add(lastNameField, 1, 1);
        gradeBookGrid.add(courseLabel, 0, 2);
        gradeBookGrid.add(courseField, 1, 2);
        gradeBookGrid.add(gradeLabel, 0, 3);
        gradeBookGrid.add(gradeComboBox, 1, 3);
        gradeBookGrid.add(clearButton, 0, 4);
        gradeBookGrid.add(viewGradesButton, 1, 4);
        gradeBookGrid.add(saveButton, 2, 4);

        Scene gradeBookScene = new Scene(gradeBookGrid, 400, 250);
        stage.setScene(gradeBookScene);
        stage.setTitle("Grade Book App");
        stage.show();
    }

    private boolean authenticate(String username, String password) {
        // Simple hardcoded authentication logic for demonstration
        return "user".equals(username) && "password".equals(password);
    }

    private void saveGrade(String firstName, String lastName, String course, String grade) {
        if (firstName.isEmpty() || lastName.isEmpty() || course.isEmpty() || grade == null) {
            showAlert(Alert.AlertType.ERROR, "Form Error", "Please fill all fields");
            return;
        }

        Student student = new Student(firstName, lastName, course, grade);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/grades.csv", true))) {
            writer.write(student.getFirstName() + "," + student.getLastName() + "," + student.getCourse() + "," + student.getGrade());
            writer.newLine();
            showAlert(Alert.AlertType.INFORMATION, "Success", "Grade saved successfully!");
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "File Error", "Error saving grade!");
        }
    }

    private void viewGrades() {
        try (BufferedReader reader = new BufferedReader(new FileReader("data/grades.csv"))) {
            StringBuilder gradesContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                gradesContent.append(line).append("\n");
            }
            showAlert(Alert.AlertType.INFORMATION, "Grades", gradesContent.toString());
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "File Error", "Error reading grades!");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

    