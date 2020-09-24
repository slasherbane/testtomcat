/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Benjamin
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByActif", query = "SELECT u FROM User u WHERE u.actif = :actif"),
    @NamedQuery(name = "User.findByDateCreation", query = "SELECT u FROM User u WHERE u.dateCreation = :dateCreation"),
    @NamedQuery(name = "User.findByDateMaj", query = "SELECT u FROM User u WHERE u.dateMaj = :dateMaj"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByFichierPhoto", query = "SELECT u FROM User u WHERE u.fichierPhoto = :fichierPhoto"),
    @NamedQuery(name = "User.findByLogin", query = "SELECT u FROM User u WHERE u.login = :login"),
    @NamedQuery(name = "User.findByNom", query = "SELECT u FROM User u WHERE u.nom = :nom"),
    @NamedQuery(name = "User.findByNumeroMobile", query = "SELECT u FROM User u WHERE u.numeroMobile = :numeroMobile"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByPrenom", query = "SELECT u FROM User u WHERE u.prenom = :prenom"),
    @NamedQuery(name = "User.findByProfile", query = "SELECT u FROM User u WHERE u.profile = :profile"),
    @NamedQuery(name = "User.findByDateSuppressionLogique", query = "SELECT u FROM User u WHERE u.dateSuppressionLogique = :dateSuppressionLogique"),
    @NamedQuery(name = "User.findBySupprime", query = "SELECT u FROM User u WHERE u.supprime = :supprime"),
    @NamedQuery(name = "User.findByFond", query = "SELECT u FROM User u WHERE u.fond = :fond"),
    @NamedQuery(name = "User.findByTexte", query = "SELECT u FROM User u WHERE u.texte = :texte"),
    @NamedQuery(name = "User.findByGenereEnMasse", query = "SELECT u FROM User u WHERE u.genereEnMasse = :genereEnMasse"),
    @NamedQuery(name = "User.findByNumTelAliase", query = "SELECT u FROM User u WHERE u.numTelAliase = :numTelAliase"),
    @NamedQuery(name = "User.findByNumTelLigne", query = "SELECT u FROM User u WHERE u.numTelLigne = :numTelLigne")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "actif")
    private boolean actif;
    @Column(name = "dateCreation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "dateMaj")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateMaj;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "fichierPhoto")
    private String fichierPhoto;
    @Size(max = 255)
    @Column(name = "login")
    private String login;
    @Size(max = 255)
    @Column(name = "nom")
    private String nom;
    @Size(max = 15)
    @Column(name = "numeroMobile")
    private String numeroMobile;
    @Size(max = 255)
    @Column(name = "password")
    private String password;
    @Size(max = 255)
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "profile")
    private Integer profile;
    @Column(name = "dateSuppressionLogique")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSuppressionLogique;
    @Basic(optional = false)
    @NotNull
    @Column(name = "supprime")
    private boolean supprime;
    @Size(max = 7)
    @Column(name = "fond")
    private String fond;
    @Size(max = 7)
    @Column(name = "texte")
    private String texte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "genereEnMasse")
    private boolean genereEnMasse;
    @Size(max = 255)
    @Column(name = "numTelAliase")
    private String numTelAliase;
    @Size(max = 255)
    @Column(name = "numTelLigne")
    private String numTelLigne;
    @ManyToMany(mappedBy = "userCollection", fetch = FetchType.LAZY)
    private Collection<SectGeo> sectGeoCollection;
    @OneToMany(mappedBy = "idColl", fetch = FetchType.LAZY)
    private Collection<Client> clientCollection;
    @OneToMany(mappedBy = "idValideur", fetch = FetchType.LAZY)
    private Collection<Acompte> acompteCollection;
    @JoinColumn(name = "idSalarie", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Candidatsalarie idSalarie;
    @JoinColumn(name = "idClient", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Client idClient;
    @JoinColumn(name = "idSite", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Sc idSite;
    @JoinColumn(name = "idSoc", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Soc idSoc;

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public User(Long id, boolean actif, boolean supprime, boolean genereEnMasse) {
        this.id = id;
        this.actif = actif;
        this.supprime = supprime;
        this.genereEnMasse = genereEnMasse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateMaj() {
        return dateMaj;
    }

    public void setDateMaj(Date dateMaj) {
        this.dateMaj = dateMaj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFichierPhoto() {
        return fichierPhoto;
    }

    public void setFichierPhoto(String fichierPhoto) {
        this.fichierPhoto = fichierPhoto;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumeroMobile() {
        return numeroMobile;
    }

    public void setNumeroMobile(String numeroMobile) {
        this.numeroMobile = numeroMobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getProfile() {
        return profile;
    }

    public void setProfile(Integer profile) {
        this.profile = profile;
    }

    public Date getDateSuppressionLogique() {
        return dateSuppressionLogique;
    }

    public void setDateSuppressionLogique(Date dateSuppressionLogique) {
        this.dateSuppressionLogique = dateSuppressionLogique;
    }

    public boolean getSupprime() {
        return supprime;
    }

    public void setSupprime(boolean supprime) {
        this.supprime = supprime;
    }

    public String getFond() {
        return fond;
    }

    public void setFond(String fond) {
        this.fond = fond;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public boolean getGenereEnMasse() {
        return genereEnMasse;
    }

    public void setGenereEnMasse(boolean genereEnMasse) {
        this.genereEnMasse = genereEnMasse;
    }

    public String getNumTelAliase() {
        return numTelAliase;
    }

    public void setNumTelAliase(String numTelAliase) {
        this.numTelAliase = numTelAliase;
    }

    public String getNumTelLigne() {
        return numTelLigne;
    }

    public void setNumTelLigne(String numTelLigne) {
        this.numTelLigne = numTelLigne;
    }

    @XmlTransient
    public Collection<SectGeo> getSectGeoCollection() {
        return sectGeoCollection;
    }

    public void setSectGeoCollection(Collection<SectGeo> sectGeoCollection) {
        this.sectGeoCollection = sectGeoCollection;
    }

    @XmlTransient
    public Collection<Client> getClientCollection() {
        return clientCollection;
    }

    public void setClientCollection(Collection<Client> clientCollection) {
        this.clientCollection = clientCollection;
    }

    @XmlTransient
    public Collection<Acompte> getAcompteCollection() {
        return acompteCollection;
    }

    public void setAcompteCollection(Collection<Acompte> acompteCollection) {
        this.acompteCollection = acompteCollection;
    }

    public Candidatsalarie getIdSalarie() {
        return idSalarie;
    }

    public void setIdSalarie(Candidatsalarie idSalarie) {
        this.idSalarie = idSalarie;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    public Sc getIdSite() {
        return idSite;
    }

    public void setIdSite(Sc idSite) {
        this.idSite = idSite;
    }

    public Soc getIdSoc() {
        return idSoc;
    }

    public void setIdSoc(Soc idSoc) {
        this.idSoc = idSoc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.User[ id=" + id + " ]";
    }
    
}
