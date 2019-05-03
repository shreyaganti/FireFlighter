

import java.awt.*;
import java.util.*;

import processing.core.PImage;

public class Mario extends Sprite {

	public static final int MARIO_WIDTH = 40;
	public static final int MARIO_HEIGHT = 60;

	public Mario(PImage img, int x, int y) {
		super(img, x, y, MARIO_WIDTH, MARIO_HEIGHT);
	}

	// METHODS
	public void walk(int dir) {
		
		//hello everyone
		moveByAmount(dir, 0);
		
		// WALK!
	}

	public void jump() {
		// JUMP!
		moveByAmount(0,-1);
	}

	public void act(ArrayList<Shape> obstacles) {
		super.moveByAmount(0, 0.5);
		// FALL (and stop when a platform is hit)
		moveByAmount(0,1);
	}


}