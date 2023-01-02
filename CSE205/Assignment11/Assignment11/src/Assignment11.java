//Sharliz Reyes
//1218634313
//MW 1:30-2:45
//The main method reads the grid from user input. readGrid() takes in the height of the grid (height) and width of the grid (width) and reads the integers to be stored in each grid cell row by row.
public class Assignment11 {

	public static void main(String[] args) {
		Solver solver = new Solver();
		solver.readGrid();

		System.out.println("Original grid: ");
		solver.printGrid();

		solver.depthFirstSearch();

		System.out.println("Grid after increment: ");
		solver.printGrid();
	}
}