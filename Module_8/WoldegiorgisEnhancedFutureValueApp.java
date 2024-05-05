package Module_8;
	
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WoldegiorgisEnhancedFutureValueApp extends Application {
	   private TextField txtMonthlyPayment = new TextField();
	    private TextField txtInterestRate = new TextField();
	    private ComboBox<Integer> cboYears = new ComboBox<>();
	    private TextArea txtResult = new TextArea();
	    private Label lblFutureValueDate = new Label();

	    private Button btnCalculate = new Button("Calculate");
	    private Button btnClear = new Button("Clear");

	    private static final int MONTHS_IN_YEAR = 12;

	    @Override
	    public void start(Stage primaryStage) {
	        primaryStage.initStyle(javafx.stage.StageStyle.UNDECORATED); // Remove default window decorations
	        primaryStage.setTitle("Woldegiorgis Future Value App");

	        // Custom title bar
	        HBox titleBar = new HBox();
	        titleBar.setPadding(new Insets(5));
	        titleBar.setAlignment(Pos.CENTER_LEFT);
	        titleBar.setStyle("-fx-background-color: #DDDDDD;");

	        // Close button
	        Button closeButton = createWindowControlButton("Close", "#FF5733");
	        closeButton.setOnAction(e -> primaryStage.close());

	        // Minimize button
	        Button minimizeButton = createWindowControlButton("Minimize", "#F9C74F");
	        minimizeButton.setOnAction(e -> primaryStage.setIconified(true));

	        // Maximize button
	        Button maximizeButton = createWindowControlButton("Maximize", "#90BE6D");
	        maximizeButton.setOnAction(e -> {
	            primaryStage.setMaximized(!primaryStage.isMaximized());
	            maximizeButton.setText(primaryStage.isMaximized() ? "Restore" : "Maximize");
	        });

	        // Title label
	        Label titleLabel = new Label("Woldegiorgis Future Value App");
	        titleLabel.setPadding(new Insets(0, 20, 0, 20));
	        titleLabel.setAlignment(Pos.CENTER_RIGHT);

	        titleBar.getChildren().addAll(closeButton, minimizeButton, maximizeButton, titleLabel);

	        GridPane pane = new GridPane();
	        pane.setAlignment(Pos.CENTER);
	        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
	        pane.setHgap(5.5);
	        pane.setVgap(5.5);

	        Label lblMonthlyPayment = new Label("Monthly Payment:");
	        Label lblInterestRate = new Label("Interest Rate:");
	        Label lblYears = new Label("Years:");

	        Label lblInterestRateFormat = new Label();
	        lblInterestRateFormat.setTextFill(Color.RED);
	        lblInterestRateFormat.setText("Enter 11.1% as 11.1");
	        GridPane.setHalignment(lblInterestRateFormat, HPos.RIGHT);
	        pane.add(lblInterestRateFormat, 1, 2);

	        cboYears.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

	        HBox actionBtnContainer = new HBox();
	        actionBtnContainer.setSpacing(10);
	        actionBtnContainer.setPadding(new Insets(15, 0, 15, 30));
	        actionBtnContainer.getChildren().addAll(btnClear, btnCalculate);
	        pane.add(actionBtnContainer, 1, 4);

	        pane.add(lblMonthlyPayment, 0, 0);
	        pane.add(txtMonthlyPayment, 1, 0);
	        pane.add(lblInterestRate, 0, 1);
	        pane.add(txtInterestRate, 1, 1);
	        pane.add(lblYears, 0, 3);
	        pane.add(cboYears, 1, 3);
	        pane.add(txtResult, 0, 5, 2, 1);

	        VBox root = new VBox();
	        root.getChildren().addAll(titleBar, pane);

	        Scene scene = new Scene(root, 400, 300);
	        primaryStage.setScene(scene);
	        primaryStage.show();

	        // Set event handlers
	        btnClear.setOnAction(e -> clearFormFields());
	        btnCalculate.setOnAction(e -> calculateResults());
	    }

	    private Button createWindowControlButton(String text, String color) {
	        Button button = new Button(text);
	        button.setStyle("-fx-background-color: " + color + "; -fx-text-fill: white;");
	        button.setPrefSize(50, 20);
	        return button;
	    }

	    private void clearFormFields() {
	        txtMonthlyPayment.clear();
	        txtInterestRate.clear();
	        txtResult.clear();
	        cboYears.getSelectionModel().clearSelection();
	        lblFutureValueDate.setText("");
	    }

	    private void calculateResults() {
	        try {
	            double monthlyPayment = Double.parseDouble(txtMonthlyPayment.getText());
	            double interestRate = Double.parseDouble(txtInterestRate.getText());
	            int years = cboYears.getValue();

	            double futureValue = FinanceCalculator.calculateFutureValue(monthlyPayment, interestRate, years);


	        	 // Get current date
	               SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	               String currentDate = dateFormat.format(new Date());

	             // Set text on lblFutureValueDate
	               lblFutureValueDate.setText("Calculation as of " + currentDate);
	            // Set result text
	            txtResult.setText("The future value is " + futureValue);
	        } catch (NumberFormatException e) {
	            // Handle invalid input
	            txtResult.setText("Invalid input. Please enter valid numbers.");
	        }
	    }

	    public static void main(String[] args) {
	        launch(args);
	        
	    }

		public static int getMonthsInYear() {
			return MONTHS_IN_YEAR;
		}
	 }
