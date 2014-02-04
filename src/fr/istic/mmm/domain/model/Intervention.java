package fr.istic.mmm.domain.model;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.google.appengine.api.datastore.Key;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true, value = { "id", "user" })
public class Intervention implements Serializable {

	private static final long serialVersionUID = -863671259274273059L;

	protected Date date;

	protected String remark;

	// @OneToOne
	// @JsonIgnore
	@Embedded
	protected InterventionState interventionState;

	@ManyToOne(fetch = FetchType.LAZY)
	// @JsonIgnore
	protected User user;

	// @ManyToOne(fetch = FetchType.LAZY)
	// @JsonIgnore
	@Embedded
	protected InterventionType interventionType;

	// @ManyToOne(fetch = FetchType.LAZY)
	// @JsonIgnore
	@Embedded
	protected Location location;

	@Id
	@PrimaryKey
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Key id;

	@JsonSerialize(include=Inclusion.NON_NULL)
	public long getUserId() {
		return user.getIdFromKey();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public InterventionState getInterventionState() {
		return interventionState;
	}

	public void setInterventionState(InterventionState interventionState) {
		this.interventionState = interventionState;
	}

	// public User getUser() {
	// return user;
	// }
	//
	// public void setUser(User user) {
	// this.user = user;
	// }
	//
	// public InterventionType getInterventionType() {
	// return interventionType;
	// }
	//
	// public void setInterventionType(InterventionType interventionType) {
	// this.interventionType = interventionType;
	// }

	// public Location getLocation() {
	// return location;
	// }
	//
	// public void setLocation(Location location) {
	// this.location = location;
	// }

	public Key getId() {
		return id;
	}

	public void setId(Key id) {
		this.id = id;
	}

	@JsonProperty(value = "key")
	@JsonSerialize(include=Inclusion.NON_NULL)
	public long getIdFromKey() {
		return this.id.getId();
	}

	public InterventionType getInterventionType() {
		return interventionType;
	}

	public void setInterventionType(InterventionType interventionType) {
		this.interventionType = interventionType;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Intervention() {

	}

	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void basicSetInterventionState(InterventionState
	// myInterventionState) {
	// if (this.interventionState != myInterventionState) {
	// if (myInterventionState != null){
	// if (this.interventionState != myInterventionState) {
	// InterventionState oldinterventionState = this.interventionState;
	// this.interventionState = myInterventionState;
	// if (oldinterventionState != null)
	// oldinterventionState.unsetIntervention();
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
	// public void basicSetUser(User myUser) {
	// if (this.user != myUser) {
	// if (myUser != null){
	// if (this.user != myUser) {
	// User olduser = this.user;
	// this.user = myUser;
	// if (olduser != null)
	// olduser.removeIntervention(this);
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
	// public void basicSetInterventionType(InterventionType myInterventionType)
	// {
	// if (this.interventionType != myInterventionType) {
	// if (myInterventionType != null){
	// if (this.interventionType != myInterventionType) {
	// InterventionType oldinterventionType = this.interventionType;
	// this.interventionType = myInterventionType;
	// if (oldinterventionType != null)
	// oldinterventionType.removeIntervention(this);
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
	// public void basicSetLocation(Location myLocation) {
	// if (this.location != myLocation) {
	// if (myLocation != null){
	// if (this.location != myLocation) {
	// Location oldlocation = this.location;
	// this.location = myLocation;
	// if (oldlocation != null)
	// oldlocation.removeIntervention(this);
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
	// public Date getDate() {
	// return this.date;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void getRemark() {
	// return this.remark;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public InterventionState getInterventionState() {
	// return this.interventionState;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public User getUser() {
	// return this.user;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public InterventionType getInterventionType() {
	// return this.interventionType;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public Location getLocation() {
	// return this.location;
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
	// public void setDate(Date myDate) {
	// this.date = myDate;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void setRemark( myRemark) {
	// this.remark = myRemark;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void setInterventionState(InterventionState myInterventionState) {
	// this.basicSetInterventionState(myInterventionState);
	// myInterventionState.basicSetIntervention(this);
	//
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void setUser(User myUser) {
	// this.basicSetUser(myUser);
	// myUser.addIntervention(this);
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void setInterventionType(InterventionType myInterventionType) {
	// this.basicSetInterventionType(myInterventionType);
	// myInterventionType.addIntervention(this);
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void setLocation(Location myLocation) {
	// this.basicSetLocation(myLocation);
	// myLocation.addIntervention(this);
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void unsetDate() {
	// this.date = new Date();
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void unsetRemark() {
	// this.remark = ;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void unsetInterventionState() {
	// if (this.interventionState == null)
	// return;
	// InterventionState oldinterventionState = this.interventionState;
	// this.interventionState = null;
	// oldinterventionState.unsetIntervention();
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void unsetUser() {
	// if (this.user == null)
	// return;
	// User olduser = this.user;
	// this.user = null;
	// olduser.removeIntervention(this);
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void unsetInterventionType() {
	// if (this.interventionType == null)
	// return;
	// InterventionType oldinterventionType = this.interventionType;
	// this.interventionType = null;
	// oldinterventionType.removeIntervention(this);
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void unsetLocation() {
	// if (this.location == null)
	// return;
	// Location oldlocation = this.location;
	// this.location = null;
	// oldlocation.removeIntervention(this);
	// }

}
