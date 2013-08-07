package iAirReborn;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.util.Timer;

public class Banking extends Job {

	public Banking(MethodContext ctx) {
		super(ctx);
		
	}
	private Timer t = new Timer(10);

	@Override
	public boolean activate() {
		return ctx.backpack.select().count() < 28 && Vars.BANK_AREA.contains(ctx.players.local());
	}

	@Override
	public void execute() {
		Vars.status = "Opening bank...";
		
			if (ctx.bank.open()) {
				t.reset();
				while (t.isRunning() && !ctx.bank.isOpen()) {
					ctx.game.sleep(15);
				}
				Vars.status = "Depositing backpack...";
				if (ctx.bank.isOpen()) {
					if (ctx.bank.depositInventory()) {
						t.reset();
						while (t.isRunning() && ctx.backpack.isEmpty()) {
							ctx.game.sleep(50);
						}
						Vars.status = "Withdrawing essence...";
						if (ctx.bank.withdraw(Vars.ess, 28) || ctx.bank.withdraw(Vars.pureEss, 28)) {
							t.reset();
							while (t.isRunning() && !ctx.backpack.isEmpty()) {
								ctx.game.sleep(50);
							}
							Vars.status = "Closing bank...";
							if (ctx.bank.close());
						}
					}
				}
			}
		}

	}


