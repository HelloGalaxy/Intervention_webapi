package fr.istic.mmm.domain.model;

import javax.persistence.Embeddable;

@Embeddable
public class OperationType {
	// /*READ, READALL,*/ CREATE, UPDATE, DELETE;

	protected String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public OperationType() {
	}

	public OperationType(String text) {
		this.text = text;
	}

}
