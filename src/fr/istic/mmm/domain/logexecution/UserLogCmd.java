package fr.istic.mmm.domain.logexecution;

import org.codehaus.jackson.map.ObjectMapper;

import fr.istic.mmm.domain.model.OperationType;
import fr.istic.mmm.domain.model.User;
import fr.istic.mmm.domain.response.ExeReport;
import fr.istic.mmm.domain.webapi.UserController;
import fr.istic.mmm.helper.ExeReportHelper;

public class UserLogCmd implements LogCommand {

	private UserController userctrl = new UserController();
	private ObjectMapper om = new ObjectMapper();

	@Override
	public ExeReport execute(String target, String[] keys, OperationType optType) {

		ExeReport report = null;
		long userid = 0l;
		User user = null;

		switch (optType) {
		case CREATE:

			try {
				user = om.readValue(target, User.class);
				report = userctrl.createModel(user);
			} catch (Exception e) {
				e.printStackTrace();
				report = ExeReportHelper.getParamterError(e.getMessage());
			}
			
			break;

		case DELETE:

			try {
				userid = Long.parseLong(keys[0]);
				report = userctrl.deleteModel(userid);
			} catch (Exception e) {
				e.printStackTrace();
				report = ExeReportHelper.getParamterError(e.getMessage());
			}

			break;

		case UPDATE:

			try {
				user = om.readValue(target, User.class);
				userid = Long.parseLong(keys[0]);

				report = userctrl.updateModel(userid, user);

			} catch (Exception e) {
				e.printStackTrace();
				report = ExeReportHelper.getParamterError(e.getMessage());
			}
			
			break;
		default:
			break;
		}

		return report;
	}

}
