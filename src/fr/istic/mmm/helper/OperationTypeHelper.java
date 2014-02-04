package fr.istic.mmm.helper;

import fr.istic.mmm.domain.model.OperationType;

public class OperationTypeHelper {

	private static OperationType create;

	private static OperationType update;

	private static OperationType delete;

	public static OperationType getCreate() {

		if (create == null)
			create = new OperationType("Create");

		return create;
	}

	public static OperationType getUpdate() {

		if (update == null)
			update = new OperationType("Update");
		return update;
	}

	public static OperationType getDelete() {
		if (delete == null)
			delete = new OperationType("Delete");
		return delete;
	}

}
