//Name: Sharliz Reyes
//Student ID: 1218634313
//Lecture Time: MW 1:30-2:45pm
//Class description: Create the fleet pane

import java.util.ArrayList;

import AircraftPane.RandomButtonHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class FleetPane extends BorderPane {
	// COMPLETED: contains a list of aircrafts
	ArrayList<Aircraft> aircraftList;
	
	// COMPLETED: Variables containing fleet Stealth Index, Bomb Carrying Capacity, and Attack Power
	int totalStealthIndex;
	int totalBombCarryingCapacity;
	int totalAttackPower;
	
	// TODO 5. a) "Declare" (Do not "initialize" them yet!!!)
	// ONE Label to display Fleet information
	// ONE VBox to contain CheckBoxes
	// ONE "Load Aircrafts/Clear Selection" Button
	// vvvvvv 5. a) vvvvvv (about 3 lines)
	Label fleetInfo;
	VBox vBox;
	Button loadClearButton;
	// ^^^^^^ 5. a) ^^^^^^
	
	public FleetPane(ArrayList<Aircraft> aircraftList) {
		
		this.aircraftList = aircraftList;
		// TODO 5. a) Initialize the instance variables
		// This is where you use the "new" keyword
		// vvvvvv 5. a) vvvvvv (about 3 lines)
		fleetInfo = new Label("Select aircrafts to add to your fleet");
		vBox = new VBox();
		loadClearButton = new Button("Load Aircrafts/Clear Selection");
		// ^^^^^^ 5. a) ^^^^
		// TODO: 5. b) Bind "Load Aircrafts/Clear Selection" Button to its handler
		// vvvvvv 5. b) vvvvvv (1 line)
		loadClearButton.setOnAction(new LoadAircraftsButtonHandler());
		// ^^^^^^ 5. b) ^^^^^^
		// TODO: 5. c) Organize components to their positions on BorderPane
		// Remember that THIS class "is"/extends BorderPane, use BorderPane syntax to add components
		// vvvvvv 5. c) vvvvvv (1 line)
		
		//this organizes the components onto the BorderPane
		this.setTop(fleetInfo);
		this.setCenter(vBox);
		this.setBottom(loadClearButton);
		// ^^^^^^ 5. c) ^^^^^^
	}
	
	private class LoadAircraftsButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			
			//this resets the stats to 0 when a new checkBox is checked
			totalAttackPower = 0;
			totalBombCarryingCapacity = 0;
			totalStealthIndex = 0;
			
			fleetInfo.setText("Total Stealth Index: " + totalStealthIndex + "\t\tTotal Bomb Carrying Capacity: " + totalBombCarryingCapacity + "\tTotal Attack Power: " + totalAttackPower);
			// TODO: 6. Clear the VBox (1 line)
			// vvvvvv 6. a) vvvvvv (1 line)
			vBox.getChildren().clear();
			// ^^^^^^ 6. a) ^^^^^^
			// TODO: 6. b), c), d)  
			// vvvvvv 6. b), c), d) vvvvvv (about 5-8 lines)
			
			// this prints a checkBox with the aircraft's data
			for(int i = 0; i < aircraftList.size(); i++) {
				
				Aircraft aircraft = aircraftList.get(i);
				aircraft.toString();
				
				
				CheckBox checkBox = new CheckBox(aircraft.toString());
				checkBox.setOnAction(new CheckBoxHandler(aircraft));
				vBox.getChildren().add(checkBox);
				
			}
			// ^^^^^^ 6. b), c), d) ^^^^^^
		}
	}
	private class CheckBoxHandler implements EventHandler<ActionEvent> {
		Aircraft aircraft;
		
		// When creating a new CheckBoxHandler, pass in a Aircraft object so it can be accessed later
		public CheckBoxHandler(Aircraft aircraft) {
			this.aircraft = aircraft;
	}
	
		@Override
	public void handle(ActionEvent event) {
	
		// TODO: 7. a) Use event.getSource() to get the CheckBox that triggered the event, cast it to CheckBox
			// vvvvvv 7. a) vvvvvv (1 line)
			CheckBox checkBox = (CheckBox) event.getSource();
			// ^^^^^^ 7. a) ^^^^^^
			// TODO: 7. b) If the CheckBox was selected, add the current aircraft scores to totalBombCarryingCapacity, 
			//  totalAttackPower, and totalStealthIndex. Otherwise, subtract the current aircraft scores
			// vvvvvv 7. b) vvvvvv (about 8-12 lines)
			if(checkBox.isSelected()) {
				
				
				int attackPower = aircraft.getAttackPower();
				totalAttackPower += attackPower;
				
				int bombCarryingCapacity = aircraft.getBombCarryingCapacity();
				totalBombCarryingCapacity += bombCarryingCapacity;
				
				double stealthIndex = aircraft.getStealthIndex();
				totalStealthIndex += stealthIndex;
				
			} else {
				
				int attackPower = aircraft.getAttackPower();
				totalAttackPower -= attackPower;
				
				int bombCarryingCapacity = aircraft.getBombCarryingCapacity();
				totalBombCarryingCapacity -= bombCarryingCapacity;
				
				double stealthIndex = aircraft.getStealthIndex();
				totalStealthIndex -= stealthIndex;
				
			}
			// ^^^^^^ 7. b) ^^^^^^
			// TODO: 7. c) Set the Label to 
			// "Total Stealth Index: " + totalStealthIndex + "\t\tTotal Bomb Carrying Capacity: " + totalBombCarryingCapacity + "\tTotal Attack Power: " + totalAttackPower
			// vvvvvv 7. c) vvvvvv (1 line)
			fleetInfo.setText("Total Stealth Index: " + totalStealthIndex + "\t\tTotal Bomb Carrying Capacity: " + totalBombCarryingCapacity + "\tTotal Attack Power: " + totalAttackPower);
			// ^^^^^^ 7. c) ^^^^^^
		}
	}
}