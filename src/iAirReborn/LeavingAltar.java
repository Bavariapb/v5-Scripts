package iAirReborn;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.util.Timer;
import org.powerbot.script.wrappers.GameObject;

public class LeavingAltar extends Job {

	public LeavingAltar(MethodContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	private Timer t = new Timer(2000);

	@Override
	public boolean activate() {
		return ctx.objects.select().id(2465).nearest().first() != null
				&& ctx.backpack.select().id(Vars.RUNE_ID).count() > 0;
	}

	@Override
	public void execute() {
		Vars.status = "Leaving altar...";
		for (GameObject Portal : ctx.objects.select().id(2465).nearest().first()) {
		if (Portal != null) {
			if (Portal.isOnScreen()) {
				if (Portal.interact("Enter")) {
					t.reset();
					while (t.isRunning() && Portal.isOnScreen()) {
						sleep(100, 150);
					}
				}
			} else {
				ctx.camera.turnTo(Portal);
			}

		}

	}
	}
}
