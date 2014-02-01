package fr.istic.mmm.domain.model;

import java.io.Serializable;
import java.util.Set;

import javax.jdo.annotations.PrimaryKey;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.google.appengine.api.datastore.Key;

@Entity
@JsonIgnoreProperties(value = { "id", "intervention", "log" })
public class User implements Serializable {

	private static final long serialVersionUID = -3753596757350963693L;

	@Id
	@PrimaryKey
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Key id;

	protected String firstName;

	protected String lastName;

	protected int age;

	protected String mail;

	protected String phoneNumber;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	@JsonIgnore
	protected Set<Intervention> intervention;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	@JsonIgnore
	protected Set<Log> log;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	protected Set<Account> account;

	public Key getId() {
		return id;
	}

	public void setId(Key id) {
		this.id = id;
	}

	@JsonProperty("key")
	public long getIdFromKey() {
		return this.id.getId();
	}

	// @JsonProperty("key")
	// public void setIdToKey(long id) {
	// System.out.println("ID " + id);
	// this.id = KeyFactory.createKey("", id);
	// }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Set<Intervention> getIntervention() {
		return intervention;
	}

	public void setIntervention(Set<Intervention> intervention) {
		this.intervention = intervention;
	}

	public Set<Log> getLog() {
		return log;
	}

	public void setLog(Set<Log> log) {
		this.log = log;
	}

	public Set<Account> getAccount() {
		return account;
	}

	public void setAccount(Set<Account> account) {
		this.account = account;
	}

	public User() {
	}

	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	//

	//
	// @Id
	// @PrimaryKey
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// private Key id;
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// */
	// public User(){
	// super();
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void getFirstName() {
	// return this.firstName;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void getLastName() {
	// return this.lastName;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public int getAge() {
	// return this.age;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void getMail() {
	// return this.mail;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public int getPhoneNumber() {
	// return this.phoneNumber;
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
	// public Set<Log> getLog() {
	// if(this.log == null) {
	// this.log = new HashSet<Log>();
	// }
	// return (Set<Log>) this.log;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public Set<Account> getAccount() {
	// if(this.account == null) {
	// this.account = new HashSet<Account>();
	// }
	// return (Set<Account>) this.account;
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
	// tmp.setUser(this);
	//
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void addAllLog(Set<Log> newLog) {
	// if (this.log == null) {
	// this.log = new HashSet<Log>();
	// }
	// for (Log tmp : newLog)
	// tmp.setUser(this);
	//
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void addAllAccount(Set<Account> newAccount) {
	// if (this.account == null) {
	// this.account = new HashSet<Account>();
	// }
	// for (Account tmp : newAccount)
	// tmp.setUser(this);
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
	// public void removeAllLog(Set<Log> newLog) {
	// if(this.log == null) {
	// return;
	// }
	//
	// this.log.removeAll(newLog);
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void removeAllAccount(Set<Account> newAccount) {
	// if(this.account == null) {
	// return;
	// }
	//
	// this.account.removeAll(newAccount);
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void setFirstName( myFirstName) {
	// this.firstName = myFirstName;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void setLastName( myLastName) {
	// this.lastName = myLastName;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void setAge(int myAge) {
	// this.age = myAge;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void setMail( myMail) {
	// this.mail = myMail;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void setPhoneNumber(int myPhoneNumber) {
	// this.phoneNumber = myPhoneNumber;
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
	// newIntervention.basicSetUser(this);
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void addLog(Log newLog) {
	// if(this.log == null) {
	// this.log = new HashSet<Log>();
	// }
	//
	// if (this.log.add(newLog))
	// newLog.basicSetUser(this);
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void addAccount(Account newAccount) {
	// if(this.account == null) {
	// this.account = new HashSet<Account>();
	// }
	//
	// if (this.account.add(newAccount))
	// newAccount.basicSetUser(this);
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void unsetFirstName() {
	// this.firstName = ;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void unsetLastName() {
	// this.lastName = ;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void unsetAge() {
	// this.age = 0;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void unsetMail() {
	// this.mail = ;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void unsetPhoneNumber() {
	// this.phoneNumber = 0;
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
	// oldIntervention.unsetUser();
	//
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void removeLog(Log oldLog) {
	// if(this.log == null)
	// return;
	//
	// if (this.log.remove(oldLog))
	// oldLog.unsetUser();
	//
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void removeAccount(Account oldAccount) {
	// if(this.account == null)
	// return;
	//
	// if (this.account.remove(oldAccount))
	// oldAccount.unsetUser();
	//
	// }
	//
}
