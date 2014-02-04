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
import org.codehaus.jackson.annotate.JsonProperty;

import com.google.appengine.api.datastore.Key;

@Entity
public class Log implements Serializable {

	private static final long serialVersionUID = 4993812753849560807L;

	protected String data;

	protected String modelTarget;

	protected String keyList;

	@Embedded
	protected OperationType operationType;

	protected Date date;

//	protected boolean persisted = false;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	protected User user;

	@Id
	@PrimaryKey
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key id;

	public String getKeyList() {
		return keyList;
	}

	public void setKeyList(String keyList) {
		this.keyList = keyList;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public OperationType getOperationType() {
		return operationType;
	}

	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	// public User getUser() {
	// return user;
	// }
	//
	// public void setUser(User user) {
	// this.user = user;
	// }

	public String getTarget() {
		return modelTarget;
	}

//	public boolean hasPersisted() {
//		return persisted;
//	}
//
//	public void setPersisted(boolean persisted) {
//		this.persisted = persisted;
//	}

	public void setTarget(String target) {
		this.modelTarget = target;
	}

	public Key getId() {
		return id;
	}

	public void setId(Key id) {
		this.id = id;
	}

	@JsonProperty(value = "key")
	public long getIdFromKey() {
		return this.id.getId();
	}

	public Log() {

	}

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
	// olduser.removeLog(this);
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
	// public void getData() {
	// return this.data;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public OperationType getOperationType() {
	// return this.operationType;
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
	// public void setData( myData) {
	// this.data = myData;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void setOperationType(OperationType myOperationType) {
	// this.operationType = myOperationType;
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
	// public void setUser(User myUser) {
	// this.basicSetUser(myUser);
	// myUser.addLog(this);
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void unsetData() {
	// this.data = ;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void unsetOperationType() {
	// this.operationType = null;
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
	// public void unsetUser() {
	// if (this.user == null)
	// return;
	// User olduser = this.user;
	// this.user = null;
	// olduser.removeLog(this);
	// }

}
