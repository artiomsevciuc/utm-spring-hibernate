package md.utm.springidol;

import md.utm.springidol.exception.PerformanceException;
import md.utm.springidol.interfaces.Performer;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJugglerBean {
	@Test
	public void testJugglerConstructoParameter() throws PerformanceException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"md/utm/springidol/spring-idol.xml");
		Performer performer = (Performer) ctx.getBean("juggler15");
		performer.perform();
	}

	@Test
	public void testJuggler() throws PerformanceException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"md/utm/springidol/spring-idol.xml");
		Performer performer = (Performer) ctx.getBean("juggler");
		performer.perform();
	}

	@Test
	public void testPoeticJuggler() throws PerformanceException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"md/utm/springidol/spring-idol.xml");
		Performer performer = (Performer) ctx.getBean("poeticJuggler");
		performer.perform();
	}
}
