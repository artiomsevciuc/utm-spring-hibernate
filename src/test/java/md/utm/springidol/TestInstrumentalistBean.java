package md.utm.springidol;

import md.utm.springidol.exception.PerformanceException;
import md.utm.springidol.interfaces.Performer;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestInstrumentalistBean {
	@Test
	public void testInstrumentalistPrimitiveAttributes()
			throws PerformanceException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"md/utm/springidol/spring-idol.xml");
		Performer performer = (Performer) ctx.getBean("kenny");
		performer.perform();
	}

	@Test
	public void testInstrumentalistReferenceAttribute()
			throws PerformanceException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"md/utm/springidol/spring-idol.xml");
		Performer performer = (Performer) ctx.getBean("kennyInstrument");
		performer.perform();
	}

}
