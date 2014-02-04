package fr.istic.mmm.domain.logexecution;

import org.codehaus.jackson.map.ObjectMapper;

import fr.istic.mmm.domain.model.Intervention;
import fr.istic.mmm.domain.model.OperationType;
import fr.istic.mmm.domain.response.ExeReport;
import fr.istic.mmm.domain.webapi.InterventionController;
import fr.istic.mmm.helper.ExeReportHelper;

public class InterventionLogCmd implements LogCommand {

	private InterventionController interventionctrl = new InterventionController();
	private ObjectMapper om = new ObjectMapper();

	@Override
	public ExeReport execute(String target, String[] keys, OperationType optType) {

		ExeReport report = null;
		long userid = 0l;
		long interventionid = 0l;
		Intervention intervention = null;

//		switch (optType) {
//		case CREATE:
//
//			try {
//				intervention = om.readValue(target, Intervention.class);
//				userid = Long.parseLong(keys[0]);
//				report = interventionctrl.createModel(userid, intervention);
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
//				interventionid = Long.parseLong(keys[0]);
//				report = interventionctrl.deleteModel(userid, interventionid);
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
//				intervention = om.readValue(target, Intervention.class);
//				userid = Long.parseLong(keys[0]);
//				interventionid = Long.parseLong(keys[0]);
//				report = interventionctrl.updateModel(userid, interventionid,
//						intervention);
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
