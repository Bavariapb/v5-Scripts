package iAirReborn;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;

import org.powerbot.script.util.Timer;
import org.powerbot.script.wrappers.Area;
import org.powerbot.script.wrappers.Tile;


public class Vars {
	
	//Areas
	public static final Area ALTAR_AREA = new Area(new Tile[] { new Tile(3187, 3473, 0), new Tile(3217, 3424, 0), new Tile(3167, 3384, 0), 
			new Tile(3123, 3340, 0), new Tile(3061, 3374, 0), new Tile(3061, 3449, 0) });
	public static final Area RUINS_AREA = new Area(new Tile[] { new Tile(3114, 3418, 0), new Tile(3117, 3388, 0), new Tile(3133, 3389, 0), 
			new Tile(3135, 3416, 0) });
	public static final Area BANK_AREA = new Area(new Tile[] {
			new Tile(3177, 3440, 0), new Tile(3186, 3440, 0),
			new Tile(3186, 3429, 0), new Tile(3177, 3429, 0),
			new Tile(3177, 3440, 0) });
	public static final Area TO_ALTAR_AREA = new Area(new Tile[] { new Tile(3122, 3446, 0), new Tile(3143, 3388, 0), new Tile(3183, 3363, 0), 
			new Tile(3268, 3396, 0), new Tile(3216, 3497, 0) });
	public static final Area TO_BANK_AREA = new Area(new Tile[] { new Tile(3112, 3427, 0), new Tile(3108, 3393, 0), new Tile(3141, 3377, 0), 
			new Tile(3214, 3419, 0), new Tile(3211, 3469, 0) });
	
	//TilePaths
	
	
	//Id's
	public static final int AIR_ALTAR = 2478;
	public static final int RUNE_ID = 556;
	public static final int PORTAL_ID = 2465;
	public static int ess  = 1436;
	public static int pureEss = 7936;
	public static int essence[] = {1436, 7936};
	public static int RUINS = 2452;
	
	//Paint
	public static String version = "V5.01";
	public static Timer runTime = new Timer(0);
	public static final Color COLOR_1 = new Color(0, 255, 51);
	public static final Font FONT_1 = new Font("Arial", 1, 15);
	public  static final Color COLOR_2 = new Color(21, 118, 236, 101);
	public static final Color COLOR_3 = new Color(0, 0, 0);
	public static  final BasicStroke STROKE_1 = new BasicStroke(1);
	public static int startExp = 0;
	public static int startLevel = 0;
	public static String status;
	public static int tripsMade, essUsed, runesMade;
	
}
