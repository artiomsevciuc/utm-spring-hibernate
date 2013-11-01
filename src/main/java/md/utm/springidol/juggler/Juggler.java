package md.utm.springidol.juggler;

import md.utm.springidol.exception.PerformanceException;
import md.utm.springidol.interfaces.Performer;

public class Juggler implements Performer {

	private int beanBags = 3;

	public Juggler() {
	}

	public Juggler(int beanBags) {
		this.beanBags = beanBags;
	}

	public void perform() throws PerformanceException {
		System.out.println("JUGGLING " + beanBags + " BEANBAGS");
	}

}
