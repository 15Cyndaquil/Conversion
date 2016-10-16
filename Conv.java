import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;


public class Conv extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		GridPane grid = new GridPane();
		for (int col=0; col<11; col++) {
			ColumnConstraints column = new ColumnConstraints(50);
			grid.getColumnConstraints().add(column);
		}
		for (int ro=0; ro<10; ro++) {
			RowConstraints row = new RowConstraints(25);
			grid.getRowConstraints().add(row);
		}
		
		Label prompt = new Label("Choose units to convert");
		prompt.setStyle("-fx-font-size: 50px;");
		grid.add(prompt, 0, 0);
		GridPane.setColumnSpan(prompt, 11);
		GridPane.setRowSpan(prompt, 2);
		GridPane.setHalignment(prompt, HPos.CENTER);
		
		List<String> units = new ArrayList<>();
		units.add("Kilometer"); units.add("Meter"); units.add("Centimeter"); 
		units.add("Millimeter"); units.add("Micrometer"); units.add("Nanometer"); 
		units.add("Mile"); units.add("Yard"); units.add("Foot"); 
		units.add("Inch"); units.add("Nautical Mile");
		
		ComboBox<String> units1 = new ComboBox<>();
		units1.getItems().addAll(units);
		units1.setPromptText("Input    Units");
		units1.setStyle("-fx-font-size: 16px;");
		grid.add(units1, 1, 3);
		GridPane.setColumnSpan(units1, 4);
		
		ComboBox<String> units2 = new ComboBox<>();
		units2.getItems().addAll(units);
		units2.setPromptText("Output Units");
		units2.setStyle("-fx-font-size: 16px;");
		grid.add(units2, 7, 3);
		GridPane.setColumnSpan(units2, 4);
		
		TextField input = new TextField();
		input.setText("Put your input Units here");
		input.setStyle("-fx-font-size: 16px;");
		grid.add(input, 1, 5);
		GridPane.setColumnSpan(input, 4);
		GridPane.setRowSpan(input, 2);
		
		Label output = new Label();
		output.setText("Output Goes Here");
		output.setStyle("-fx-font-size: 16px;");
		grid.add(output, 6, 5);
		GridPane.setColumnSpan(output, 4);
		GridPane.setRowSpan(output, 2);
		
		Label equals = new Label();
		equals.setText("=");
		equals.setStyle("-fx-font-size: 50px;");
		grid.add(equals, 5, 5);
		GridPane.setRowSpan(equals, 2);
		GridPane.setHalignment(equals, HPos.CENTER);
		
		Button cancel = new Button("Cancel");
		cancel.setStyle("-fx-font-size: 20px;");
		grid.add(cancel, 4, 8);
		GridPane.setColumnSpan(cancel, 3);
		GridPane.setRowSpan(cancel, 2);
		GridPane.setHalignment(cancel, HPos.CENTER);
		
		ChangeListener<String> calculate = (observable, oldValue, newValue) -> {
			double output1 = 0;
			double outputf;
			DecimalFormat two = new DecimalFormat("#.##");
			try{
				double input1 = Double.parseDouble(input.getText());
				if(units1.getValue().equalsIgnoreCase("Kilometer")){
					output1 = input1*1000;
					}
				if(units1.getValue().equals("Meter")){
					output1 = input1;					}
				if(units1.getValue().equals("Centimeter")){
					output1 = input1*0.01;
					}
				if(units1.getValue().equals("Millimeter")){
					output1 = input1*0.001;
					}
				if(units1.getValue().equals("Micrometer")){
					output1 = input1*1e-6;
					}
				if(units1.getValue().equals("Nanometer")){
					output1 = input1*1e-9;
					}
				if(units1.getValue().equals("Mile")){
					output1 = input1*1609.34;
					}
				if(units1.getValue().equals("Yard")){
					output1 = input1*0.9144;
					}
				if(units1.getValue().equals("Foot")){
					output1 = input1*0.3048;
					}
				if(units1.getValue().equals("Inch")){
					output1 = input1*0.0254;
					}
				if(units1.getValue().equals("Nautical Mile")){
					output1 = input1*1852;
					}
				if(units2.getValue().equals("Kilometer")){
					outputf = output1/1000;
					output.setText("You have " + two.format(outputf) + " kilometers");
					}
				if(units2.getValue().equals("Meter")){
					outputf = output1/1;
					output.setText("You have " + two.format(outputf) + " meters");
					}
				if(units2.getValue().equals("Centimeter")){
					outputf = output1/0.01;
					output.setText("You have " + two.format(outputf) + " centimeters");
					}
				if(units2.getValue().equals("Millimeter")){
					outputf = output1/0.001;
					output.setText("You have " + two.format(outputf) + " millimeters");
					}
				if(units2.getValue().equals("Micrometer")){
					outputf = output1/1e-6;
					output.setText("You have " + two.format(outputf) + " micrometers");
					}
				if(units2.getValue().equals("Nanometer")){
					outputf = output1/1e-9;
					output.setText("You have " + two.format(outputf) + " nanometers");
					}
				if(units2.getValue().equals("Mile")){
					outputf = output1/1609.34;
					output.setText("You have " + two.format(outputf) + " miles");
					}
				if(units2.getValue().equals("Yard")){
					outputf = output1/0.9144;
					output.setText("You have " + two.format(outputf) + " yards");
					}
				if(units2.getValue().equals("Foot")){
					outputf = output1/0.3048;
					output.setText("You have " + two.format(outputf) + " feet");
					}
				if(units2.getValue().equals("Inch")){
					outputf = output1/0.0254;
					output.setText("You have " + two.format(outputf) + " inches");
					}
				if(units2.getValue().equals("Nautical Mile")){
					outputf = output1/1852;
					output.setText("You have " + two.format(outputf) + " nautical miles");
					}
				}
			catch(NumberFormatException f){
			}
		};
		input.textProperty().addListener(calculate);
		units1.valueProperty().addListener(calculate);
		units2.valueProperty().addListener(calculate);
		
		cancel.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent cancela){
				System.exit(0);
			}
		});
		
		grid.setGridLinesVisible(false);
		Scene scene = new Scene(grid, 550, 250);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
}