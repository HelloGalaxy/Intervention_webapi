package fr.istic.mmm.domain.response;

/***
 * 
 * State value: <br/>
 * 
 * <b> 0: success </b> <br/>
 * <b> 1: database error </b> <br/>
 * <b> 2: parameter error </b> <br/>
 * <b> 3: json error </b> <br/>
 * 
 */
public class ExeReport {

	private int state;

	private String remark;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public ExeReport() {
	}

	public ExeReport(int state) {
		this.state = state;
	}

}
