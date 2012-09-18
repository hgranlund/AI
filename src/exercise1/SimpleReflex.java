package exercise1;

import robocode.*;

public class SimpleReflex extends AdvancedRobot {

	//Ruboten scanner etter den andre roboten
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
		turnLeft(180);
		ahead(200);
	}

	// Når den andre roboten blir scannet avgjør den avstand, deretter skyter den og posisjonerer seg godt i forhold til den andre roboten
	public void onScannedRobot(ScannedRobotEvent e) {	
		if ( e.getDistance()< 20) fire(Rules.MAX_BULLET_POWER);
		
		if (e.getDistance() > 100) {
			setTurnRight(e.getBearing() + 90 - 30 );
			fire(2);
		} else {
			setTurnRight(e.getBearing() * -1 );
			fire(4);
		}
		setAhead((e.getDistance() / 4 + 25));
		setTurnGunRight(99999);

	}
}
