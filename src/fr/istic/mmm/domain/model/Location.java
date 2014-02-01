package fr.istic.mmm.domain.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Location implements Serializable {

	private static final long serialVersionUID = 3157250876312120705L;

	protected long latitude;

	protected long longitude;

	// protected GeoPt geopoint;

	protected String address;

	protected String city;

	protected String country;

	protected String postCode;

	// @OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
	// @JsonIgnore
	// protected Set<Intervention> intervention;

	// @Id
	// @PrimaryKey
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// private Key id;

	// public GeoPt getGeopoint() {
	// return geopoint;
	// }
	//
	public void setGeopoint(long latitude, long longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getAddress() {
		return address;
	}

	public long getLatitude() {
		return latitude;
	}

	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}

	public long getLongitude() {
		return longitude;
	}

	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	// public Set<Intervention> getIntervention() {
	// return intervention;
	// }
	//
	// public void setIntervention(Set<Intervention> intervention) {
	// this.intervention = intervention;
	// }

	// public Key getId() {
	// return id;
	// }
	//
	// public void setId(Key id) {
	// this.id = id;
	// }

	//
	// @JsonProperty(value = "id")
	// public long getIdFromKey() {
	// return this.id.getId();
	// }

	public Location() {

	}

	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void getLatitude() {
	// return this.latitude;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void getLongitude() {
	// return this.longitude;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void getAddress() {
	// return this.address;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void getCity() {
	// return this.city;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void getCountry() {
	// return this.country;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void getPostCode() {
	// return this.postCode;
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
	// tmp.setLocation(this);
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
	// public void setLatitude( myLatitude) {
	// this.latitude = myLatitude;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void setLongitude( myLongitude) {
	// this.longitude = myLongitude;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void setAddress( myAddress) {
	// this.address = myAddress;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void setCity( myCity) {
	// this.city = myCity;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void setCountry( myCountry) {
	// this.country = myCountry;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void setPostCode( myPostCode) {
	// this.postCode = myPostCode;
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
	// newIntervention.basicSetLocation(this);
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void unsetLatitude() {
	// this.latitude = ;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void unsetLongitude() {
	// this.longitude = ;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void unsetAddress() {
	// this.address = ;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void unsetCity() {
	// this.city = ;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void unsetCountry() {
	// this.country = ;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// * @ordered
	// */
	// public void unsetPostCode() {
	// this.postCode = ;
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
	// oldIntervention.unsetLocation();
	//
	// }
	//
}
