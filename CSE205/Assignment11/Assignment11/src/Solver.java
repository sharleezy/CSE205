//Sharliz Reyes
//1218634313
//MW 1:30-2:45
//systematically search a graph or tree data structure 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solver {

	// ********************** ADD YOUR CODE HERE **********************
	
	private Stack<Node> stack;
	private int[][] grid;
	private int height;
	private int width;
	private int increment;
	private ArrayList<Node> visited;
	
	
	public Solver() {
		stack = new Stack<Node>();
		visited = new ArrayList<Node>();
		
	}

	public void depthFirstSearch() {
		
		Node newNode = new Node(0, 0);
		stack.push(newNode);
		
		while(stack.isEmpty() == false) {
			
			//pop node from stack
			Node node = stack.pop();
			
			//add the increment factor to the node
			if(isVisited(node) == false) {
				grid[node.getY()][node.getX()] += increment;
			}
			
			
			//add the node to the ArrayList
			visited.add(node);
			
			/////////////////////////////////////////////////////////////////////////
			
			//find coordinates of the adjacent node to the south
			int xSouth = node.getX();
			int ySouth = node.getY();
			
			//calculate coordinate of the south
			ySouth += 1;
			
			//Check if the adjacent node is not yet visited
            //Create a new node from that coordinate and push it into the stack
			if(ySouth < height) {
				Node southNode = new Node(xSouth, ySouth);
				if(isVisited(southNode) == false) {
					stack.push(southNode);
				}
			}
			
			//////////////////////////////////////////////////////////////////////////
			
			//find coordinates of the adjacent node to the east
			int xEast = node.getX();
			int yEast = node.getY();
			
			//calculate coordinate of the east
			xEast += 1;
			
			//Check if the adjacent node is not yet visited
            //Create a new node from that coordinate and push it into the stack
			if(xEast < width) {
				Node eastNode = new Node(xEast, yEast);
				if(isVisited(eastNode) == false) {
					stack.push(eastNode);
				}
			}
			
			
			/////////////////////////////////////////////////////////////////////////
			
			//find coordinates of the adjacent node to the north
			int xNorth = node.getX();
			int yNorth = node.getY();
			
			//calculate coordinate of the north
			yNorth -= 1;
			
			//Check if the adjacent node is not yet visited
            //Create a new node from that coordinate and push it into the stack
			if(yNorth >= 0) {
				Node northNode = new Node(xNorth, yNorth);
				if(isVisited(northNode) == false) {
					stack.push(northNode);
				}
			}
			
			/////////////////////////////////////////////////////////////////////////
			
			//find coordinates of the adjacent node to the west
			int xWest = node.getX();
			int yWest = node.getY();
			
			//calculate coordinate of the west
			xWest -= 1;

			//Check if the adjacent node is not yet visited
            //Create a new node from that coordinate and push it into the stack
			if(xWest >= 0) {
				Node westNode = new Node(xWest, yWest);
				if(isVisited(westNode) == false) {
					stack.push(westNode);
				}
			}
			
			
			
		}
	}
	
	public boolean isVisited(Node node) {
		for(int i = 0; i < visited.size(); i++) {
			
			
			if(visited.get(i).getX() == node.getX() && visited.get(i).getY() == node.getY()) {
				return true;
			}
		}
		return false;
	}
	
	



	// ************************************************************************************
	// ************** Utility method to read grid from user input *************************
	// ************************************************************************************
	public void readGrid() {

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Height of the grid: ");
			String line = reader.readLine();
			height = Integer.parseInt(line);

			System.out.println("Width of the grid: ");
			line = reader.readLine();
			width = Integer.parseInt(line);
			grid = new int[height][width];

			System.out.println("Increment Factor: ");
			line = reader.readLine();
			increment = Integer.parseInt(line);

			System.out.println("Now enter the grid row by row:");

			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					line = reader.readLine();
					grid[i][j] = Integer.parseInt(line);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// ************************************************************************************
	// ************** Utility method to print grid ****************************************
	// ************************************************************************************
	public void printGrid() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {

				System.out.print(grid[i][j]);
				System.out.print('	');
			}
			System.out.println();
		}

		System.out.println();
	}

}
