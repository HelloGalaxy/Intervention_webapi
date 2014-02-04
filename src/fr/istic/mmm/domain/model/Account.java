package fr.istic.mmm.domain.model;

import java.io.Serializable;

import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.google.appengine.api.datastore.Key;

@Entity
@JsonIgnoreProperties({ "id" })
public class Account implements Serializable {

	private static final long serialVersionUID = -5695666409882437720L;

	protected String login;

	protected String password;

	@ManyToOne(fetch = FetchType.LAZY)
	protected User user;

	@Id
	@PrimaryKey
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Key id;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getUserId() {
		return user.getIdFromKey();
	}

	//
	// public User getUser() {
	// return user;
	// }
	//
	// public void setUser(User user) {
	// this.user = user;
	// }

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

	public Account() {
	}

	// public void basicSetUser(User myUser) {
	// if (this.user != myUser) {
	// if (myUser != null) {
	// if (this.user != myUser) {
	// User olduser = this.user;
	// this.user = myUser;
	// if (olduser != null)
	// olduser.removeAccount(this);
	// }
	// }
	// }
	// }

	// public String getLogin() {
	// return this.login;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void getPasword() {
	// return this.pasword;
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
	// public void setLogin( myLogin) {
	// this.login = myLogin;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void setPasword( myPasword) {
	// this.pasword = myPasword;
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
	// myUser.addAccount(this);
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void unsetLogin() {
	// this.login = ;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void unsetPasword() {
	// this.pasword = ;
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
	// olduser.removeAccount(this);
	// }
	//
}
