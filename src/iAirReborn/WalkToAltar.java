package iAirReborn;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.Tile;

public class WalkToAltar extends Job {

	public WalkToAltar(MethodContext ctx) {
		super(ctx);
	}

	@Override
	public boolean activate() {
		return Vars.TO_ALTAR_AREA.contains(ctx.players.local())
				&& ctx.backpack.select().id(Vars.essence).count() > 0;
	}

	@Override
	public void execute() {
		Vars.status = "Walking to altar";
		ctx.movement.newTilePath(
				new Tile[] { new Tile(3182, 3428, 0), new Tile(3176, 3428, 0),
						new Tile(3169, 3427, 0), new Tile(3164, 3423, 0),
						new Tile(3159, 3419, 0), new Tile(3151, 3415, 0),
						new Tile(3146, 3415, 0), new Tile(3140, 3411, 0),
						new Tile(3135, 3405, 0), new Tile(3130, 3402, 0) })
				.traverse();

	}

}
