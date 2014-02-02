package fr.istic.mmm.domain.logexecution;

import fr.istic.mmm.domain.model.OperationType;
import fr.istic.mmm.domain.response.ExeReport;

public interface LogCommand {
	public ExeReport execute(String target, String[] keys, OperationType optType);
}
