//Assignment #7, CSE205, Arizona State University 
//Name: Sharliz Reyes
//StudentID: 1218634313
//Lecture time: MW 1:30-2:45
//Description: This class draws triangles, ellipses, and rectangles with user-defined stroke width, stroke color, and fill color.
import javafx.scene.layout.*;
import javafx.scene.shape.Shape;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Ellipse;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;

public class SketchPane extends BorderPane {
	
	//Task 1: Declare all instance variables listed in UML diagram
	private ArrayList<Shape> shapeList = new ArrayList<Shape>();
	private ArrayList<Shape> tempList = new ArrayList<Shape>();
	
	private Button undoButton = new Button("Undo");
	private Button eraseButton = new Button("Erase");
	
	private Label fillColorLabel = new Label();
	private Label strokeColorLabel = new Label();
	private Label strokeWidthLabel = new Label();
	
	private ComboBox<String> fillColorCombo = new ComboBox<String>();
	private ComboBox<String> strokeWidthCombo = new ComboBox<String>();
	private ComboBox<String> strokeColorCombo = new ComboBox<String>();
	
	private RadioButton radioButtonRectangle, radioButtonEllipse, radioButtonTriangle;
	
	private Pane sketchCanvas = new Pane();
	
	private Color[] colors;
	
	private String[] strokeWidth;
	private String[] colorLabels;
	
	private Color currentStrokeColor;
	private Color currentFillColor;
	
	private int currentStrokeWidth;
	
	private Rectangle rectangle;
	private Ellipse ellipse;
	private Polygon triangle;
	
	private double x1;
	private double y1;
	//Task 2: Implement the constructor
	
	public SketchPane() {
		// Define colors, labels, stroke widths that are available to the user
		colors = new Color[] {Color.BLACK, Color.GREY, Color.YELLOW, Color.GOLD, Color.ORANGE, Color.DARKRED, Color.PURPLE, Color.HOTPINK, Color.TEAL, Color.DEEPSKYBLUE, Color.LIME};
		colorLabels = new String[] {"black", "grey", "yellow", "gold", "orange", "dark red", "purple", "hot pink", "teal", "deep sky blue", "lime"};
		fillColorLabel = new Label("Fill Color:");
		strokeColorLabel = new Label("Stroke Color:");
		strokeWidthLabel = new Label("Stroke Width:");
		strokeWidth = new String[] {"1", "3", "5", "7", "9", "11", "13"};    
		
		//register the eraser and undo Buttons with the ButtonHandler
		undoButton.setOnAction(new ButtonHandler());
		eraseButton.setOnAction(new ButtonHandler());
		
		//add the available color choices and stroke width to the ComboBoxes;
		fillColorCombo.getItems().addAll(colorLabels);
		strokeColorCombo.getItems().addAll(colorLabels);
		strokeWidthCombo.getItems().addAll(strokeWidth);
		
		//set the default fill and stroke color to BLACK and the default stroke width to 1;
		fillColorCombo.setValue("black");
		strokeColorCombo.setValue("black");
		strokeWidthCombo.setValue("1");
		
		currentFillColor = Color.BLACK;
		currentStrokeColor = Color.BLACK;
		currentStrokeWidth = 1;
		
		
		//register the ComboBoxes with the corresponding handler 
		fillColorCombo.setOnAction(new ColorHandler());
		strokeColorCombo.setOnAction(new ColorHandler());
		strokeWidthCombo.setOnAction(new WidthHandler());
		
		//choose the shape to be drawn: Rectangle, Ellipse or Triangle.
		radioButtonRectangle = new RadioButton("Rectangle");
		radioButtonEllipse = new RadioButton("Ellipse");
		radioButtonTriangle = new RadioButton("Triangle");
		
		//3 Radio Buttons to select Rectangle, Ellipse, and Triangle arranged in a Toggle Group
		ToggleGroup group = new ToggleGroup();
        radioButtonRectangle.setToggleGroup(group);
        radioButtonEllipse.setToggleGroup(group);
        radioButtonTriangle.setToggleGroup(group);
        
        //select the Rectangle by default.
        radioButtonRectangle.setSelected(true);
        
        //Instantiate sketchCanvas and set its background color to WHITE
        sketchCanvas.setStyle("-fx-background-color: white;");
        
        //Instantiate an HBox to hold the ComboBoxes.
        HBox HBox1 = new HBox();
        
        //To achieve the given layout, instantiate the HBox 
        //with size 20 and set the minimum size to (20,40). 
        //Use pos.CENTER for alignment and set the background 
        //color of the HBox to LIGHTGREY. Then, add the Labels and ComboBoxes.
        HBox1.setMinSize(20,40);
        HBox1.setAlignment(Pos.CENTER);
        HBox1.setStyle("-fx-background-color: LIGHTGREY;");
        HBox1.getChildren().addAll(fillColorLabel, fillColorCombo, strokeColorLabel, strokeColorCombo, strokeWidthLabel, strokeWidthCombo);
        
        //Instantiate an HBox to hold the RadioButtons and Buttons. 
        //To achieve the given layout, instantiate the HBox with 
        //size 20 and set the minimum size to (20,40). 
        //Use pos.CENTER for alignment and set the background 
        //color of the HBox to LIGHTGREY. Then, add the 3 Radiobuttons and 2 Buttons.
        HBox HBox2 = new HBox();
        HBox2.setMinSize(20,40);
        HBox2.setAlignment(Pos.CENTER);
        HBox2.setStyle("-fx-background-color: LIGHTGREY;");
        HBox2.getChildren().addAll(radioButtonRectangle, radioButtonEllipse, radioButtonTriangle, undoButton, eraseButton);
        
        //Add the sketchCanvas Pane and the two HBox Panes 
        //to the BorderPane. The shapes drawn on the 
        //sketchCanvas Pane should not hide the controls/HBox Panes.
        this.setCenter(sketchCanvas);
        this.setTop(HBox1);
        this.setBottom(HBox2);
        
        
        //register the sketchCanvas Pane with the MouseHandler and 
        //set the default values for the remaining instance variables 
        //(x1 and y2 should be zero, current stroke and fill color 
        //should be black, current stroke width should be 1).
        sketchCanvas.setOnMousePressed(new MouseHandler());
        sketchCanvas.setOnMouseDragged(new MouseHandler());
        sketchCanvas.setOnMouseReleased(new MouseHandler());
        
        x1 = 0;
        y1 = 0;
        
        
	}
	
	private class MouseHandler implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent event) {
			// TASK 3: Implement the mouse handler for Triangle and Ellipse
			if(radioButtonTriangle.isSelected()) {
				
				//If the mouse is pressed, grab the x and 
				//y coordinates and instantiate a new Polygon 
				//that will be made up of the triangle's points; 
				//add the triangle to the shape array list; 
				//and add the triangle to sketchCanvas.
				if(event.getEventType() == MouseEvent.MOUSE_PRESSED) {
					x1 = event.getX();
				    y1 = event.getY();
				    triangle = new Polygon(x1, y1);
				    
				    shapeList.add(triangle);
				    sketchCanvas.getChildren().add(triangle);
				}
				
				//If the mouse is dragged, get the current x and y 
				//coordinates of the cursor, calculate distance 
				//between the current position and the position when 
				//the mouse was pressed and set the triangle’s coordinates 
				//such that it will have length of two sides equal to 
				//the calculated distance. IT is supposed to be an Isosceles Triangle.
				else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
					double x2 = event.getX();
				    double y2 = event.getY();
				    
				    
					triangle.getPoints().clear();
					triangle.getPoints().addAll(x1, y1, x1, (y1 + y2), (x1 + x2), (y1 + y2));
					
				}
				//If the mouse is released, set the filling and 
				//stroke and stroke width to the choices the user selected.
				else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
					triangle.setFill(currentFillColor);
					triangle.setStroke(currentStrokeColor);
					triangle.setStrokeWidth(currentStrokeWidth);
				}
			}
			//If Ellipse is selected
			if(radioButtonEllipse.isSelected()) {
				
				if(event.getEventType() == MouseEvent.MOUSE_PRESSED) {
					
					x1 = event.getX();
				    y1 = event.getY();
				    ellipse = new Ellipse();
				    ellipse.setCenterX(x1);
				    ellipse.setCenterY(y1);
				    // A non-finished circle has always the same color.
				    ellipse.setFill(Color.SNOW); // almost white color
				    ellipse.setStroke(Color.BLACK);
				    
				    shapeList.add(ellipse);
				    sketchCanvas.getChildren().add(ellipse);

				}
				
				else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
					
					double currentEndPointX = event.getX();
					double currentEndPointY = event.getY();
					
					double distance = getDistance(x1, y1, currentEndPointX, currentEndPointY);
					
					ellipse.setRadiusX(distance);
					ellipse.setRadiusY(distance / 2);
					
				}
				else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
					// Now the drawing of the new rectangle is finished.
					// Let's set the final color for the rectangle.
					ellipse.setFill(currentFillColor);
					ellipse.setStroke(currentStrokeColor);
					ellipse.setStrokeWidth(currentStrokeWidth);
				}
			}
			// Rectangle Example given!
			//If user chooses Rectangle

			else if (radioButtonRectangle.isSelected()) {
				//Mouse is pressed
				if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
					x1 = event.getX();
					y1 = event.getY();
					rectangle = new Rectangle();
					rectangle.setX(x1);
					rectangle.setY(y1);
					shapeList.add(rectangle);
					rectangle.setFill(Color.WHITE);
					rectangle.setStroke(Color.BLACK);
					sketchCanvas.getChildren().add(rectangle);
				}
				//Mouse is dragged
				else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
					rectangle.setWidth(Math.abs(event.getX() - x1));
					rectangle.setHeight(Math.abs(event.getY() - y1));
				}
				//If the Mouse is released
				else if (event.getEventType() == MouseEvent.MOUSE_RELEASED){
					rectangle.setFill(currentFillColor);
					rectangle.setStroke(currentStrokeColor);
					rectangle.setStrokeWidth(currentStrokeWidth);
				}
			}
		}
	}
	
	private class ButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			// TASK 4: Implement the button handler
			//
			Button undoButton = (Button) event.getSource();
			Button eraseButton = (Button) event.getSource();
			
			if(undoButton.isPressed() == true){
				
				//If the source of the event is the Undo Button 
				//and the array list with the shapes is not empty, 
				//remove the last element from the array list and 
				//also remove the last element that was drawn on sketchCanvas.
				if(shapeList.isEmpty() == false) {
					shapeList.remove(shapeList.size());
					
					int count = sketchCanvas.getChildren().size();
					sketchCanvas.getChildren().remove(count);
				} else {
					//Copy the elements from your temporary array list 
					//into the array list with the shapes, clear the 
					//temporary array list, and add all the shapes from 
					//the array list to sketchCanvas. 
					
					shapeList = tempList;
					tempList.clear();
					sketchCanvas.getChildren().addAll(shapeList);
					
				}
				
			} 
			
			if (eraseButton.isPressed() == true) {
				if(shapeList.isEmpty() == false) {
					tempList.clear();
					tempList.addAll(shapeList);
					shapeList.clear();
					sketchCanvas.getChildren().removeAll();
				
				}
				
			}
		}
	}
	
	private class ColorHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			// TASK 5: Implement the color handler
			//the color selected by the user for shape filling and 
			//stroke is assigned as color to be used for drawing.
			
			int fillColorIndex = fillColorCombo.getSelectionModel().getSelectedIndex();
			
			currentFillColor = colors[fillColorIndex];
			
			int strokeColorIndex = strokeColorCombo.getSelectionModel().getSelectedIndex();
			
			currentStrokeColor = colors[strokeColorIndex];
				
			
		}
	}
	
	private class WidthHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event){
			// TASK 6: Implement the stroke width handler
			//The stroke width selected by the user is parsed 
			//as Integer and assigned to the variable currentStrokeWidth.
			currentStrokeWidth = Integer.parseInt(strokeWidthCombo.getValue());
		}
	}
	
	// Get the Euclidean distance between (x1,y1) and (x2,y2)
	private double getDistance(double x1, double y1, double x2, double y2)  {
		
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
		
	}
}