// Assignment #: 5
//         Name: Sharliz Reyes
//    StudentID: 1218634313
//      Lecture: MW 1:30-2:45
//  Description: constructs the Bomber Jet class which has bomb carrying capacity.

public class Bomber extends AircraftEntity {
	private int bombCarryingCapacity;
	private double maxFlyingAltitude;
	private boolean isJet;
	
	//default constructor
	public Bomber(String entityName, int ammo, double range, boolean isJet) {
		super(entityName, ammo, range);
		this.isJet = isJet;
		
		//if the bomber is a jet, assign bomb carrying capacity and max flying altitude the following values
		if(isJet == true) {
			bombCarryingCapacity = 100;
			maxFlyingAltitude = 45.5;
		} else {
			bombCarryingCapacity = 75;
			maxFlyingAltitude = 34.0;
		}
	}
	
	//calculate attack power
	public void computeAttackPower() {
		if (maxFlyingAltitude >= 40.0) {
			attackPower = (int) ((maxFlyingAltitude + ammo) * (bombCarryingCapacity/100));
		} else {
			attackPower = (int) ((ammo + range) * (bombCarryingCapacity/100));
		}
	}
	
	//print list depending on if the bomber is a jet
	public String toString() {
		if(isJet == true) {
			return "Bomber:\tJet Type\n" + super.toString() + "Bomb Carrying Capacity:\t" + bombCarryingCapacity + "%\n";

		} else {
			return "Bomber:\tPropeller Type\n" + super.toString() + "Bomb Carrying Capacity:\t" + bombCarryingCapacity + "%\n";
		}
	}
		
		
	

}
