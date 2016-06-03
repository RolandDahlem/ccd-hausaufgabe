package de.ods.ccd.loc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class FileProviderTest {

	private FileProvider fileProvider = new FileProvider();

	@Test
	public void test_ob_ordnerpfad_ermittel_werdne_kann() throws Exception {
		String ordnerPfad = fileProvider.ermittleDateiname("loc/eineDatei/");

		assertThat(ordnerPfad, containsString("target"));
	}
	
	@Test
	public void test_ob_dateinamen_gefunden_werden() throws Exception {
		String ordnerPfad = fileProvider.ermittleDateiname("loc/eineDatei/");		
		
		ConsumerSpy consumer = new ConsumerSpy();
		fileProvider.leseCodedatei(ordnerPfad, consumer);

		assertThat(consumer.getConsumed(), hasSize(1));
		assertThat(consumer.getConsumed().get(0), containsString("Minenfeld.java"));
	}

	@Test
	public void test_ob_dateinamen_in_unterordnern_gefunden_werden() throws Exception {
		String ordnerPfad = fileProvider.ermittleDateiname("loc/dateienInUnterordnern/");		
		
		ConsumerSpy consumer = new ConsumerSpy();
		fileProvider.leseCodedatei(ordnerPfad, consumer);

		assertThat(consumer.getConsumed(), hasSize(3));
		assertThat(consumer.getConsumed().get(0), containsString("Oben.java"));
		assertThat(consumer.getConsumed().get(1), containsString("Unten1.java"));
		assertThat(consumer.getConsumed().get(2), containsString("Unten2.java"));
	}
	
}
