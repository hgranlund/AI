package exercise1;

import robocode.*;

public class ModelBased extends AdvancedRobot {

	double previousEnergy = 100;
	int movementDirection = 1;
	int gunDirection = 1;

	public void run() {
		setTurnGunRight(99999);
	}

	// Når roboten blir kræsjer kjører den 90 grader fra der den ble truffet
	public void onHitRobot(HitRobotEvent e) {
		turnRight(e.getBearing() + 90);
		ahead(200);
	}

	
	//Når roboten treffer veggen snur den 180 grader og kjører fremover
	public void onHitWall(HitWallEvent e) {
		setTurnLeft(e.getBearing()-180);
		ahead(200);

	}

	// Når den andre roboten blir scannet avgjør den avstand, deretter skyter den og posisjonerer seg godt i forhold til den andre roboten

	public void onScannedRobot(ScannedRobotEvent e) {

		if (e.getDistance() > 150) {
			setTurnRight(e.getBearing() + 90 - 30 * movementDirection);
		} else {
			setTurnRight(e.getBearing() * -1 * movementDirection);
		}

		// prøver å avgjøre om den andre roboten har skutt, om den har det bytter den rettning
		double changeInEnergy = previousEnergy - e.getEnergy();
		if (changeInEnergy > 0 && changeInEnergy <= 3) {
			movementDirection = -movementDirection;
		}
		setAhead((e.getDistance() / 4 + 25) * movementDirection);

		// har bytter den retting på kanonen
		gunDirection = -gunDirection;
		setTurnGunRight(99999 * gunDirection);

		//skytter rett mot mål
		fire ( 2 ) ;

		// Lager energinivået
		previousEnergy = e.getEnergy();
	}
}