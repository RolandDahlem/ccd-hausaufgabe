package de.ods.ccd.kanban.boars;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import de.ods.ccd.kanban.contracts.Board;

public class KanbanServiceTest {

	
	private KanbanService kanbanService = new KanbanService();
	
	@Before
	public void setUp(){
		kanbanService.init();
	}
	
	@Test
	public void test_ob_ein_leeres_board_angelegt_wird() {
		Board board = kanbanService.getBoard();
		assertThat(board.getListeZettel().size(), is(0));
	}

	@Test
	public void test_ob_ein_zettel_hinzugefuegt_werden_kann() {
		kanbanService.neuerZettel();
		Board board = kanbanService.getBoard();
		assertThat(board.getListeZettel().size(), is(1));
	}
	
}
