package application;

import javafx.scene.paint.Color;

public class Preferences {

	private static boolean modeNuit = false;
	
	public static boolean getModeNuit() {
		return modeNuit;
	}
	
	public static void setModeNuit(boolean input) {
		modeNuit = input;
	}
	
	public static Color getColorModeNuit() {
		if (modeNuit)
			return Color.BLACK;
		else
			return Color.WHITE;
	}
}
