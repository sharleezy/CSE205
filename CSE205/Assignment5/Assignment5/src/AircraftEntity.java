

//abstract class
public abstract class AircraftEntity {
	protected String entityName;
	protected int ammo;
	protected double range;
	protected int attackPower;
	
	//default constructor
	public AircraftEntity(String entityName, int ammo, double range) {
		this.entityName = entityName;
		this.ammo = ammo;
		this.range = range;
		
		attackPower = 0;
	}
	
	//when this is called, it returns an integer that is attack power
	public int getAttackPower() {
		return attackPower;
	}
	
	//abstract method will calculate the attack power for children depending on what Aircraft Entity the user inputs
	public abstract void computeAttackPower();
	
	
	public String toString() {
		return "Aircraft name:\t" + entityName + "\nCurrent Ammo:\t" + ammo + "\nRange:\t" + range + "\nCurrent Attack Power:\t" + attackPower + "\n";
	}
	
	
}
