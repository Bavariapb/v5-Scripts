package iAirReborn;

import org.powerbot.script.util.Timer;

import org.powerbot.script.wrappers.GameObject;

import org.powerbot.script.methods.MethodContext;

public class OpenAltar extends Job {

	public OpenAltar(MethodContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	public int ruinsId = 2452;

	private Timer t = new Timer(2000);

	@Override
	public boolean activate() {
		return Vars.RUINS_AREA.contains(ctx.players.local())
				&& ctx.backpack.select().id(Vars.essence).count() > 0
				&& ctx.objects.select().id(Vars.RUINS) != null;
	}

	@Override
	public void execute() {
		Vars.status = "Opening altar...";
		for (GameObject Ruins : ctx.objects.select().id(2452).nearest().first()){
		if (Ruins != null) {
			if (Ruins.isOnScreen()) {
				if (Ruins.interact("Enter")) {
					t.reset();
					while (t.isRunning() && Ruins.isOnScreen()) {
						sleep(100, 150);
					}
				}

			} else {
				ctx.camera.turnTo(Ruins);
			}

		}
	}
	}
}
