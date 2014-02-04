package fr.istic.mmm.helper;

import fr.istic.mmm.domain.response.ExeReport;

public class ExeReportHelper {

	private static ExeReport valideAccount;
	private static ExeReport unvalideAccount;

	private static ExeReport success;

	private static ExeReport databaseError;

	private static ExeReport paramterError;

	private static ExeReport jsonError;

	private static ExeReport notUniqueValue;

	public static ExeReport getValideAccount() {

		if (valideAccount == null) {
			valideAccount = new ExeReport(9999);
		}
		valideAccount.setRemark("Your account is valided.");
		return valideAccount;
	}

	public static ExeReport getValideAccount(String userid) {
		if (valideAccount == null) {
			valideAccount = new ExeReport(9999);
		}
		valideAccount.setRemark(userid);
		return valideAccount;
	}

	public static ExeReport getUnvalideAccount() {

		if (unvalideAccount == null) {
			unvalideAccount = new ExeReport(-9999);
			unvalideAccount.setRemark("Your account isn't valided.");
		}

		return unvalideAccount;
	}

	public static ExeReport getSuccess() {

		if (success == null)
			success = new ExeReport(0);

		success.setRemark("");

		return success;
	}

	public static ExeReport getSuccess(String remark) {
		if (success == null)
			success = new ExeReport(0);
		success.setRemark(remark);
		return success;
	}

	public static ExeReport getDataBaseError() {
		if (databaseError == null)
			databaseError = new ExeReport(1);

		databaseError.setRemark("");
		return databaseError;
	}

	public static ExeReport getDataBaseError(String remark) {
		if (databaseError == null)
			databaseError = new ExeReport(1);

		databaseError.setRemark(remark);
		return databaseError;
	}

	public static ExeReport getParamterError() {
		if (paramterError == null) {
			paramterError = new ExeReport(2);
		}

		paramterError.setRemark("");
		return paramterError;
	}

	public static ExeReport getParamterError(String remark) {
		if (paramterError == null) {
			paramterError = new ExeReport(2);
		}

		paramterError.setRemark(remark);
		return paramterError;
	}

	public static ExeReport getJsonError() {
		if (jsonError == null) {
			jsonError = new ExeReport(3);
		}
		jsonError.setRemark("");
		return jsonError;
	}

	public static ExeReport getJsonError(String remark) {
		if (jsonError == null) {
			jsonError = new ExeReport(3);
		}
		jsonError.setRemark(remark);
		return jsonError;
	}

	public static ExeReport getNotUniqueValue() {
		
		if( notUniqueValue ==null)
			 notUniqueValue = new ExeReport(4);
		
		 notUniqueValue.setRemark("Filed is not unique.");
		
		return notUniqueValue;
	}


	
	

}
