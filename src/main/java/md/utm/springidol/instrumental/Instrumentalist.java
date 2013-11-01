package md.utm.springidol.instrumental;

import md.utm.springidol.exception.PerformanceException;
import md.utm.springidol.interfaces.Instrument;
import md.utm.springidol.interfaces.Performer;

public class Instrumentalist implements Performer {
	private int age;
	private String song;
	private Instrument instrument;

	public Instrumentalist() {
	}

	public void perform() throws PerformanceException {
		System.out.print("Playing " + song + " : ");
		System.out.print("Age " + age + " : ");
		if (instrument != null)
			instrument.play();
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public String getSong() {
		return song;
	}

	public String screamSong() {
		return song;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
}
