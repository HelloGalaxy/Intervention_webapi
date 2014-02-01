package fr.istic.mmm.domain.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable 
public class InterventionState implements Serializable {

	private static final long serialVersionUID = 5740256479293365636L;

	protected String state;

//	@OneToOne(mappedBy = "interventionState")
//	@JsonIgnore
//	protected Intervention intervention;

//	@Id
//	@PrimaryKey
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Key id;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

//	public Intervention getIntervention() {
//		return intervention;
//	}
//
//	public void setIntervention(Intervention intervention) {
//		this.intervention = intervention;
//	}

//	public Key getId() {
//		return id;
//	}
//
//	public void setId(Key id) {
//		this.id = id;
//	}

	// @JsonProperty(value = "id")
	// public long getIdFromKey() {
	// return this.id.getId();
	// }

	public InterventionState() {
	}
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void basicSetIntervention(Intervention myIntervention) {
	// if (this.intervention != myIntervention) {
	// if (myIntervention != null){
	// if (this.intervention != myIntervention) {
	// Intervention oldintervention = this.intervention;
	// this.intervention = myIntervention;
	// if (oldintervention != null)
	// oldintervention.unsetInterventionState();
	// }
	// }
	// }
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void getState() {
	// return this.state;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public Intervention getIntervention() {
	// return this.intervention;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public long getId() {
	// return this.id;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void setState( myState) {
	// this.state = myState;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void setIntervention(Intervention myIntervention) {
	// this.basicSetIntervention(myIntervention);
	// myIntervention.basicSetInterventionState(this);
	//
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void unsetState() {
	// this.state = ;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void unsetIntervention() {
	// if (this.intervention == null)
	// return;
	// Intervention oldintervention = this.intervention;
	// this.intervention = null;
	// oldintervention.unsetInterventionState();
	// }

}
