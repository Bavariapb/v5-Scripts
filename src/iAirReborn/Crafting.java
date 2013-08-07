package iAirReborn;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.util.Timer;
import org.powerbot.script.wrappers.GameObject;

public class Crafting extends Job {

	public Crafting(MethodContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	private Timer t = new Timer(4000);
	private int temp1 = 0;
	private int temp2 = 0;

	@Override
	public boolean activate() {
		return ctx.objects.select().id(2478).nearest().first() != null
				&& ctx.backpack.select().id(Vars.essence).count() > 0 ;
	}

	@Override
	public void execute() {
		Vars.status = "Crafting air runes...";
		for (GameObject Altar : ctx.objects.select().id(2478).nearest().first()) {
		if (Altar != null) {
			temp1 = ctx.backpack.id(556).count(true);
			if (Altar.isOnScreen()) {
				if (Altar.interact("Craft-rune")) {
					temp2 = ctx.backpack.select().id(1436).count(true);
					t.reset();
					while (t.isRunning() && Altar.isOnScreen()) {
						sleep(100, 150);
					}
					temp2 = ctx.backpack.id(1436).count(true);
					Vars.essUsed += (temp1 - temp2);
				}
			} else {
				ctx.camera.turnTo(Altar);
			}
		}

	}
	}
}
