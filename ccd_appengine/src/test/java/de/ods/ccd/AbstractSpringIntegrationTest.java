package de.ods.ccd;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(inheritLocations = true, locations = { "/WEB-INF/CCDWeb-servlet.xml" })
public abstract class AbstractSpringIntegrationTest {

//	@Test
//	public void testNamenskonvention() {
//		String clazzName = this.getClass().getSimpleName();
//		if (clazzName.endsWith("IntegrationTest") == false) {
//			throw new RuntimeException("Der IntegrationTest " + clazzName + " gibt sich als Unit-Test aus. Bitte umbenennen");
//		}
//	}

}