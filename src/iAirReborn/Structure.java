package iAirReborn;


import java.awt.Graphics;
import java.awt.Graphics2D;


import org.powerbot.event.PaintListener;

import org.powerbot.script.Manifest;
import org.powerbot.script.PollingScript;
import org.powerbot.script.methods.Skills;

@Manifest(authors = "Bavaria", name = "iAirReborn", description = "Runecrafts air rune for you.. Version V5.01")
public class Structure extends PollingScript implements PaintListener {

	private JobContainer container = null;


	public Structure() {
		getExecQueue(State.START).add(new Runnable() {
			@Override
			public void run() {
				if (container == null) {
					container = new JobContainer(new Job[] {
							new WalkToAltar(getContext()),
							new Banking(getContext()),
							new OpenAltar(getContext()),
							new OpenAltar(getContext()),
							new Crafting(getContext()), new WalkToBank(getContext()), new LeavingAltar(getContext()) });

				}
			}
		});
	}

	@Override
	public int poll() {
		final Job job = container.get();
		if (job != null) {
			job.execute();
			return job.delay();
		}
		return 250;
	}
	
	public void start() {
		Vars.startExp = ctx.skills.getExperience(Skills.RUNECRAFTING);
	}
	
	@Override
	public void repaint(Graphics g1) {
		Graphics2D g = (Graphics2D) g1;
		
		g.setFont(Vars.FONT_1);
		g.setColor(Vars.COLOR_1);
		g.drawString("Time running : " + Vars.runTime.toElapsedString(), 20, 54);
		g.drawString("Status : " + Vars.status, 20, 67);
		g.drawString("Trips made : " + Vars.tripsMade + " (" +getPerHour(Vars.tripsMade)+ " P/H)" , 20, 82);
		g.drawString("Essence Used : " + Vars.essUsed + " (" +getPerHour(Vars.essUsed)+ " P/H)", 20, 96);
		g.drawString("Experience gained : " + (ctx.skills.getExperience(Skills.RUNECRAFTING) - Vars.startExp) + " ("+getPerHour(ctx.skills.getExperience(Skills.RUNECRAFTING) - Vars.startExp)+" P/H)" ,20, 109);
		g.drawString("Version : " + Vars.version , 20, 140);
		
		
		
	}
	


private static int getPerHour(final int value) {
	if (Vars.runTime.getElapsed() > 0) {
		return (int) (value * 3600000d / Vars.runTime.getElapsed());
	} else {
		return 0;
	}
}
}