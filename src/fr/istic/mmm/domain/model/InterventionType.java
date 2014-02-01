package fr.istic.mmm.domain.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable 
public class InterventionType implements Serializable {

	private static final long serialVersionUID = 858504805238598927L;

	protected String type;

//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "interventionType")
//	@JsonIgnore
//	protected Set<Intervention> intervention;

//	@Id
//	@PrimaryKey
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Key id;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

//	public Set<Intervention> getIntervention() {
//		return intervention;
//	}
//
//	public void setIntervention(Set<Intervention> intervention) {
//		this.intervention = intervention;
//	}
//
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

	public InterventionType() {

	}

	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void getType() {
	// return this.type;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public Set<Intervention> getIntervention() {
	// if(this.intervention == null) {
	// this.intervention = new HashSet<Intervention>();
	// }
	// return (Set<Intervention>) this.intervention;
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
	// public void addAllIntervention(Set<Intervention> newIntervention) {
	// if (this.intervention == null) {
	// this.intervention = new HashSet<Intervention>();
	// }
	// for (Intervention tmp : newIntervention)
	// tmp.setInterventionType(this);
	//
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void removeAllIntervention(Set<Intervention> newIntervention) {
	// if(this.intervention == null) {
	// return;
	// }
	//
	// this.intervention.removeAll(newIntervention);
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void setType( myType) {
	// this.type = myType;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void addIntervention(Intervention newIntervention) {
	// if(this.intervention == null) {
	// this.intervention = new HashSet<Intervention>();
	// }
	//
	// if (this.intervention.add(newIntervention))
	// newIntervention.basicSetInterventionType(this);
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void unsetType() {
	// this.type = ;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void removeIntervention(Intervention oldIntervention) {
	// if(this.intervention == null)
	// return;
	//
	// if (this.intervention.remove(oldIntervention))
	// oldIntervention.unsetInterventionType();
	//
	// }

}
