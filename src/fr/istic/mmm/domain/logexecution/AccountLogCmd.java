package fr.istic.mmm.domain.logexecution;

import org.codehaus.jackson.map.ObjectMapper;

import fr.istic.mmm.domain.model.Account;
import fr.istic.mmm.domain.model.OperationType;
import fr.istic.mmm.domain.response.ExeReport;
import fr.istic.mmm.domain.webapi.AccountController;
import fr.istic.mmm.helper.ExeReportHelper;

public class AccountLogCmd implements LogCommand {

	private AccountController accountctrl = new AccountController();
	private ObjectMapper om = new ObjectMapper();

	@Override
	public ExeReport execute(String target, String[] keys, OperationType optType) {

		ExeReport report = null;
		long userid = 0l;
		long accountid = 0l;
		Account account = null;

//		switch (optType) {
//		case CREATE:
//
//			try {
//				account = om.readValue(target, Account.class);
//				userid = Long.parseLong(keys[0]);
//				report = accountctrl.createModel(userid, account);
//			} catch (Exception e) {
//				e.printStackTrace();
//				report = ExeReportHelper.getParamterError(e.getMessage());
//			}
//
//			break;
//
//		case DELETE:
//
//			try {
//				userid = Long.parseLong(keys[0]);
//				accountid = Long.parseLong(keys[0]);
//				report = accountctrl.deleteModel(userid, accountid);
//			} catch (Exception e) {
//				e.printStackTrace();
//				report = ExeReportHelper.getParamterError(e.getMessage());
//			}
//
//			break;
//
//		case UPDATE:
//
//			try {
//				account = om.readValue(target, Account.class);
//				userid = Long.parseLong(keys[0]);
//				accountid = Long.parseLong(keys[0]);
//				report = accountctrl.updateModel(userid, accountid, account);
//
//			} catch (Exception e) {
//				e.printStackTrace();
//				report = ExeReportHelper.getParamterError(e.getMessage());
//			}
//
//			break;
//		default:
//			break;
//		}

		return report;
	}
}
