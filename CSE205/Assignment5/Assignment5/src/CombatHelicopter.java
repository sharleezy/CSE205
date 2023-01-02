// Assignment #: 5
//         Name: Sharliz Reyes
//    StudentID: 1218634313
//      Lecture: MW 1:30-2:45
//  Description: constructs the Combat Helicopter class which has minimum flying altitude and stealth index.

public class CombatHelicopter extends AircraftEntity{
	private double minFlyingAltitude;
	private int stealthIndex;
	
	//default constructor
	public CombatHelicopter(String entityName, int ammo, double range, double minFlyingAltitude) {
		super(entityName, ammo, range);
		this.minFlyingAltitude = minFlyingAltitude;
		
		if (minFlyingAltitude < 5) {
			stealthIndex = 10;
		} else {
			stealthIndex = 7;
		}
	}
	
	public void computeAttackPower() {
		attackPower = (int) ((minFlyingAltitude + ammo + range) * (stealthIndex));
	}
	
	public String toString() {
		return "Combat Helicopter\n" + super.toString() + "Stealth Index:\t" + stealthIndex + "\n";
	}

}
