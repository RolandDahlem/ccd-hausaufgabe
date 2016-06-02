package de.ods.ccd.vorbereitung;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RolandsStackTest {

	@Test
	public void test_ob_ein_element_hinzugefuegt_werden_kann() throws Exception {
		RolandsStack<String> stack = new RolandsStack<String>();
		String element = "value";
		
		stack.push(element);
		assertThat(stack.count(), is(1));
	}
	
	@Test
	public void test_ob_ein_element_entfernt_werden_kann() throws Exception {
		RolandsStack<String> stack = new RolandsStack<String>();
		String element = "value";
		stack.push(element);
		
		stack.pop();
		assertThat(stack.count(), is(0));
	}
	
	@Test
	public void test_ob_das_letzte_element_geholt_werden_kann() throws Exception {
		RolandsStack<String> stack = new RolandsStack<String>();
		stack.push("value1");
		stack.push("value2");
		
		String rueckgabe = stack.pop();
		assertThat(rueckgabe, is("value2"));
	}
	
	@Test
	public void test_ob_die_anzahl_bei_mehreren_elementen_stimmt() throws Exception {
		RolandsStack<String> stack = new RolandsStack<String>();
		stack.push("value1");
		stack.push("value2");
		
		assertThat(stack.count(), is(2));
	}
	
	@Test
	public void test_ob_die_anzahl_bei_leerem_stack_stimmt() throws Exception {
		RolandsStack<String> stack = new RolandsStack<String>();
		
		assertThat(stack.count(), is(0));
	}
	
	@Test
	public void test_ob_das_erste_element_gezeigt_werden_kann_ohne_den_stack_zu_vereandern() throws Exception {
		RolandsStack<String> stack = new RolandsStack<String>();
		String element = "value";
		stack.push(element);
		
		String rueckgabe = stack.peek();
		assertThat(rueckgabe, is(element));
		assertThat(stack.count(), is(1));
	}
	
	@Test
	public void test_ob_der_stack_geleert_werden_kann() throws Exception {
		RolandsStack<String> stack = new RolandsStack<String>();
		String element = "value";
		stack.push(element);
		
		stack.clear();

		assertThat(stack.count(), is(0));
	}
}
