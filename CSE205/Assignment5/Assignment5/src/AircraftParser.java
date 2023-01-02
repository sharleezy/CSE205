// Assignment #: 5
//         Name: Sharliz Reyes
//    StudentID: 1218634313
//      Lecture: MW 1:30-2:45
//  Description: creates an aircraft object (FighterJet or Bomber or CombatHelicopter) from a parsable string

public final class AircraftParser {
	
	public static AircraftEntity parseNewAircraft(String lineToParse) {
		
		//split the user input at the comma
		String[] input = lineToParse.split(",");
		
		//take the first element in index 0, 1, 2, and 3 which is what type of aircraft entity, name, ammo, and range it is respectively
		String aircraftType = input[0];
		String name = input[1];
		String ammo = input[2];
		String range = input[3];
		
		//determine what aircraft entity the input is and assign it to the object of that kind
		if(aircraftType.equalsIgnoreCase("FighterJet")) {
			String maxSpeed = input[4];
			
			FighterJet fighterJet = new FighterJet(name, Integer.parseInt(ammo), Double.parseDouble(range), Double.parseDouble(maxSpeed));
			return fighterJet;
		
		} else if(aircraftType.equalsIgnoreCase("Bomber")) {
			String bomberType = input[4];
			
			if(bomberType.equalsIgnoreCase("Jet")) {
				boolean jet = true;
				Bomber bomber = new Bomber(name, Integer.parseInt(ammo), Double.parseDouble(range), jet);
				return bomber;
			} else {
				boolean jet = false;
				Bomber bomber = new Bomber(name, Integer.parseInt(ammo), Double.parseDouble(range), jet);
				return bomber;
			}	
			
		} else if(aircraftType.equalsIgnoreCase("CombatHelicopter")) {
			String minFlyingAltitude = input[4];
			
			CombatHelicopter combatHelicopter = new CombatHelicopter(name, Integer.parseInt(ammo), Double.parseDouble(range), Double.parseDouble(minFlyingAltitude));
			return combatHelicopter;
		}
		
			
		return null;
	}
	

}
