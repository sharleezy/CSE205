//Sharliz Reyes
//1218634313
//MW 1:30-2:45
//The purpose of this class is to be able to invoke an empty Flight object that can be used by you to return if no flights are available to perform the action. 
public class EmptyFlight extends Flight{

    public EmptyFlight() {
        super("", "", -1);
    }
        
}