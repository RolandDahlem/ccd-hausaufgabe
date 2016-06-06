package de.ods.ccd.vorbereitung;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RolandsQueueTest {

	@Test
	public void test_ob_ein_element_hinzugefuegt_werden_kann() throws Exception {
		RolandsQueue<String> stack = new RolandsQueue<String>();
		String element = "value";
		
		stack.enque(element);
		assertThat(stack.count(), is(1));
	}
	
	@Test
	public void test_ob_ein_element_entfernt_werden_kann() throws Exception {
		RolandsQueue<String> stack = new RolandsQueue<String>();
		String element = "value";
		stack.enque(element);
		
		stack.dequeue();
		assertThat(stack.count(), is(0));
	}
	
	@Test
	public void test_ob_das_erste_element_geholt_werden_kann() throws Exception {
		RolandsQueue<String> stack = new RolandsQueue<String>();
		stack.enque("value1");
		stack.enque("value2");
		
		String rueckgabe = stack.dequeue();
		assertThat(rueckgabe, is("value1"));
	}
	
	@Test
	public void test_ob_die_anzahl_bei_mehreren_elementen_stimmt() throws Exception {
		RolandsQueue<String> stack = new RolandsQueue<String>();
		stack.enque("value1");
		stack.enque("value2");
		
		assertThat(stack.count(), is(2));
	}
	
	@Test
	public void test_ob_die_anzahl_bei_leerem_stack_stimmt() throws Exception {
		RolandsQueue<String> stack = new RolandsQueue<String>();
		
		assertThat(stack.count(), is(0));
	}
	
	@Test
	public void test_ob_das_erste_element_gezeigt_werden_kann_ohne_den_stack_zu_vereandern() throws Exception {
		RolandsQueue<String> stack = new RolandsQueue<String>();
		String element = "value";
		stack.enque(element);
		
		String rueckgabe = stack.peek();
		assertThat(rueckgabe, is(element));
		assertThat(stack.count(), is(1));
	}

	@Test
	public void test_ob_erkannt_wird_das_die_moeglichkeit_fuer_queue_besteht() throws Exception {
		RolandsQueue<String> stack = new RolandsQueue<String>();
		String element = "value";
		stack.enque(element);
		
		assertThat(stack.tryDequeue(), is(true));
	}
	
	@Test
	public void test_ob_erkannt_wird_das_die_moeglichkeit_fuer_queue_nicht_besteht() throws Exception {
		RolandsQueue<String> stack = new RolandsQueue<String>();
		
		assertThat(stack.tryDequeue(), is(false));
	}
	

}
