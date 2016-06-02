package de.ods.ccd.loc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class FileProviderTest {

	private FileProvider fileProvider = new FileProvider();

	@Test
	public void test_ob_ordnerpfad_ermittel_werdne_kann() throws Exception {
		String ordnerPfad = fileProvider.ermittleDateinamen("loc/eineDatei/");

		assertThat(ordnerPfad, containsString("target"));
	}
	
	@Test
	public void test_ob_dateinamen_gefunden_werden() throws Exception {
		String ordnerPfad = fileProvider.ermittleDateinamen("loc/eineDatei/");		
		
		ConsumerSpy consumer = new ConsumerSpy();
		fileProvider.leseCodedatei(ordnerPfad, consumer);

		assertThat(consumer.getConsumed(), hasSize(1));
		assertThat(consumer.getConsumed().get(0), containsString("Minenfeld.java"));

	}

}
