package de.ods.ccd.kanban.contracts;

import java.util.List;

public interface ZettelspeicherProvider {
	public List<Zettel> zettelLesen();
}
