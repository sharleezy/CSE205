// Assignment #: 5
//         Name: Sharliz Reyes
//    StudentID: 1218634313
//      Lecture: MW 1:30-2:45
//  Description: construct the FighterJet class which has maximum speed abilities.

public class FighterJet extends AircraftEntity {
	private double maxSpeed;
	
	//default constructor
	public FighterJet(String entityName, int ammo, double range, double maxSpeed) {
		super(entityName, ammo, range);
		this.maxSpeed = maxSpeed;
	}
	
	public void computeAttackPower() {
		attackPower = (int) ((ammo + range) * (maxSpeed/10));
	}
	
	public String toString() {
		return "Fighter Jet:\n" + super.toString() + "Maximum Speed:\t" + maxSpeed + "%\n";
	}
}
