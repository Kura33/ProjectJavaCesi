package com.shield.projectJavaCesi.entity.being;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import com.shield.projectJavaCesi.entity.event.Incident;
import com.shield.projectJavaCesi.entity.multipleConnection.Comment;
import com.shield.projectJavaCesi.entity.multipleConnection.Media;
import com.shield.projectJavaCesi.entity.superbeing.Superbeing;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "being")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="organisation", discriminatorType = DiscriminatorType.INTEGER)
public abstract class Being {

		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "native")
		@GenericGenerator(name = "native", strategy = "native")
		private int id;
		private String ref;
		private Boolean malevolant;
		private Date birthdate;
		private Date deathdate;
		private String address;
		private String city;
		private String state;
		private String zipcode;
		private String country;
		private String mobilePhone;
		private Date addedAt;
		private Date updatedAt;
		private int howManyDeclaredIncident;
		private int victimOfHowManyMission;
		private Boolean archive;
		private String email;
		private String password;
		private Boolean active;

		@OneToMany(mappedBy = "being")
	    private List<Comment> comment;

	    @OneToMany(mappedBy = "media")
	    private List<Media> media;

	    @ManyToOne
		@JoinColumn(name = "superbeing_id", referencedColumnName = "id")
	    private Superbeing superbeing;
	    
	    @ManyToMany
		@JoinTable(name = "incident_linked_entity", joinColumns = @JoinColumn(name = "being_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "incident_id", referencedColumnName = "id"))
		private List<Incident> incident = new ArrayList<>();
	    
	    public void addIncident(Incident incident) {
			this.incident.add(incident);
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getRef() {
			return ref;
		}
		public void setRef(String ref) {
			this.ref = ref;
		}
		public Boolean isMalevolant() {
			return malevolant;
		}
		public void setMalevolant(Boolean malevolant) {
			this.malevolant = malevolant;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Date getBirthdate() {
			return birthdate;
		}
		public void setBirthdate(Date birthdate) {
			this.birthdate = birthdate;
		}
		public Date getDeathdate() {
			return deathdate;
		}
		public void setDeathdate(Date deathdate) {
			this.deathdate = deathdate;
		}
		public String getAddress() {
			return address;
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
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getZipcode() {
			return zipcode;
		}
		public void setZipcode(String zipcode) {
			this.zipcode = zipcode;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getMobilePhone() {
			return mobilePhone;
		}
		public void setMobilePhone(String mobilePhone) {
			this.mobilePhone = mobilePhone;
		}
		public Date getAddedAt() {
			return addedAt;
		}
		public void setAddedAt(Date addedAt) {
			this.addedAt = addedAt;
		}
		public Date getUpdatedAt() {
			return updatedAt;
		}
		public void setUpdatedAt(Date updateAt) {
			this.updatedAt = updateAt;
		}
		public int getHowManyDeclaredIncident() {
			return howManyDeclaredIncident;
		}
		public void setHowManyDeclaredIncident(int howManyDeclaredIncident) {
			this.howManyDeclaredIncident = howManyDeclaredIncident;
		}
		public int getVictimOfHowManyMission() {
			return victimOfHowManyMission;
		}
		public List<Comment> getComment() {
			return comment;
		}
		public void setComment(List<Comment> comment) {
			this.comment = comment;
		}
		public List<Media> getMedia() {
			return media;
		}
		public void setMedia(List<Media> media) {
			this.media = media;
		}
		public void setVictimOfHowManyMission(int victimOfHowManyMission) {
			this.victimOfHowManyMission = victimOfHowManyMission;
		}
		public Boolean isArchive() {
			return archive;
		}
		public void setArchive(Boolean archive) {
			this.archive = archive;
		}
		public Boolean isActive() {
		return active;
	}
		public void setActive(Boolean active) {
		this.active = active;
	}
		public Superbeing getSuperbeing() { return superbeing; }
		public void setSuperbeing(Superbeing superbeing) { this.superbeing = superbeing; }
}
