package de.ods.ccd.kanban.contracts;

import java.util.UUID;

public class Zettel {
	private String text;
	private int spalte;
	private int position;
	private UUID id;

	public Zettel(UUID id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getSpalte() {
		return spalte;
	}

	public void setSpalte(int spalte) {
		this.spalte = spalte;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public UUID getId() {
		return this.id;
	}

}
