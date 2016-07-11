package de.ods.ccd.kanban.contracts;

import java.util.List;

public interface BoardConfigProvider {

	public List<String> konfigDateiEinlesen();

	public List<Spalte> spaltenParsen(List<String> zeilen);
}
