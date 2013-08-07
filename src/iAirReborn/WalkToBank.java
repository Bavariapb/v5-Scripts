package iAirReborn;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.Tile;

public class WalkToBank extends Job {

	public WalkToBank(MethodContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		return Vars.TO_BANK_AREA.contains(ctx.players.local())
				&& ctx.backpack.select().id(Vars.RUNE_ID).count() > 0;
	}

	@Override
	public void execute() {
		Vars.status = "Walking to bank...";
		ctx.movement.newTilePath(
				new Tile[] { new Tile(3135, 3406, 0), new Tile(3141, 3411, 0),
						new Tile(3149, 3415, 0), new Tile(3157, 3417, 0),
						new Tile(3167, 3421, 0), new Tile(3173, 3426, 0),
						new Tile(3183, 3428, 0), new Tile(3181, 3436, 0) })
				.traverse();

	}

}
