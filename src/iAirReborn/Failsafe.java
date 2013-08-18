package iAirReborn;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.Area;
import org.powerbot.script.wrappers.GameObject;
import org.powerbot.script.wrappers.Tile;

public class Failsafe extends Job {

	public Failsafe(MethodContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	private final Area deadArea = new Area(new Tile[] {
			new Tile(3083, 3432, 0), new Tile(3117, 3425, 0),
			new Tile(3116, 3378, 0), new Tile(3080, 3378, 0) });

	@Override
	public boolean activate() {
		return deadArea.contains(ctx.players.local());
	}

	@Override
	public void execute() {
		Vars.status = "Walking back from dead spot";
		for (GameObject Ruins : ctx.objects.select().id(2452).nearest().first()) {
			ctx.movement.stepTowards(Ruins);

		}
	}

}
