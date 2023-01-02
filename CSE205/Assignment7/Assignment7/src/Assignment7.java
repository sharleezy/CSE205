/**
 * Assignment #7 
 * //Name: Sharliz Reyes
//StudentID: 1218634313
//Lecture time: MW 1:30-2:45
//Description: Draw triangles, ellipses, and rectangles on a canvas.
**/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Assignment7 extends Application
{
    public static final int WINSIZE_X = 800, WINSIZE_Y = 800;
    private final String WINTITLE = "Sketchy";
    @Override
    public void start(Stage stage) throws Exception
    {
        SketchPane rootPane = new SketchPane();
        rootPane.setPrefSize(WINSIZE_X, WINSIZE_Y);
        Scene scene = new Scene(rootPane, WINSIZE_X, WINSIZE_Y);
        stage.setTitle(WINTITLE);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Technically this is not needed for JavaFX applications. Added just in case.
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        launch(args);
    }
}