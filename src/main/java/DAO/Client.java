/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findById", query = "SELECT c FROM Client c WHERE c.id = :id"),
    @NamedQuery(name = "Client.findByClient", query = "SELECT c FROM Client c WHERE c.client = :client"),
    @NamedQuery(name = "Client.findBySupprime", query = "SELECT c FROM Client c WHERE c.supprime = :supprime"),
    @NamedQuery(name = "Client.findByActif", query = "SELECT c FROM Client c WHERE c.actif = :actif"),
    @NamedQuery(name = "Client.findByRaisonSociale", query = "SELECT c FROM Client c WHERE c.raisonSociale = :raisonSociale"),
    @NamedQuery(name = "Client.findByPrenom", query = "SELECT c FROM Client c WHERE c.prenom = :prenom"),
    @NamedQuery(name = "Client.findByMobile", query = "SELECT c FROM Client c WHERE c.mobile = :mobile"),
    @NamedQuery(name = "Client.findByEmail", query = "SELECT c FROM Client c WHERE c.email = :email"),
    @NamedQuery(name = "Client.findByAdresseSuite", query = "SELECT c FROM Client c WHERE c.adresseSuite = :adresseSuite"),
    @NamedQuery(name = "Client.findByCodeApe", query = "SELECT c FROM Client c WHERE c.codeApe = :codeApe"),
    @NamedQuery(name = "Client.findByCodePostal", query = "SELECT c FROM Client c WHERE c.codePostal = :codePostal"),
    @NamedQuery(name = "Client.findByDateCreation", query = "SELECT c FROM Client c WHERE c.dateCreation = :dateCreation"),
    @NamedQuery(name = "Client.findByDateMaj", query = "SELECT c FROM Client c WHERE c.dateMaj = :dateMaj"),
    @NamedQuery(name = "Client.findByNumeroEtVoie", query = "SELECT c FROM Client c WHERE c.numeroEtVoie = :numeroEtVoie"),
    @NamedQuery(name = "Client.findByNumeroSiren", query = "SELECT c FROM Client c WHERE c.numeroSiren = :numeroSiren"),
    @NamedQuery(name = "Client.findByTelephone", query = "SELECT c FROM Client c WHERE c.telephone = :telephone"),
    @NamedQuery(name = "Client.findByVille", query = "SELECT c FROM Client c WHERE c.ville = :ville"),
    @NamedQuery(name = "Client.findByDateFin", query = "SELECT c FROM Client c WHERE c.dateFin = :dateFin"),
    @NamedQuery(name = "Client.findByTvaIntra", query = "SELECT c FROM Client c WHERE c.tvaIntra = :tvaIntra"),
    @NamedQuery(name = "Client.findByNumClient", query = "SELECT c FROM Client c WHERE c.numClient = :numClient"),
    @NamedQuery(name = "Client.findByFax", query = "SELECT c FROM Client c WHERE c.fax = :fax"),
    @NamedQuery(name = "Client.findByCivilite", query = "SELECT c FROM Client c WHERE c.civilite = :civilite"),
    @NamedQuery(name = "Client.findByDateNaissance", query = "SELECT c FROM Client c WHERE c.dateNaissance = :dateNaissance"),
    @NamedQuery(name = "Client.findByEnfants", query = "SELECT c FROM Client c WHERE c.enfants = :enfants"),
    @NamedQuery(name = "Client.findByLieuNaissance", query = "SELECT c FROM Client c WHERE c.lieuNaissance = :lieuNaissance"),
    @NamedQuery(name = "Client.findByNomJeuneFille", query = "SELECT c FROM Client c WHERE c.nomJeuneFille = :nomJeuneFille"),
    @NamedQuery(name = "Client.findByParticulier", query = "SELECT c FROM Client c WHERE c.particulier = :particulier"),
    @NamedQuery(name = "Client.findBySituationFamiliale", query = "SELECT c FROM Client c WHERE c.situationFamiliale = :situationFamiliale"),
    @NamedQuery(name = "Client.findByBureau", query = "SELECT c FROM Client c WHERE c.bureau = :bureau"),
    @NamedQuery(name = "Client.findByQuestionnaire", query = "SELECT c FROM Client c WHERE c.questionnaire = :questionnaire"),
    @NamedQuery(name = "Client.findByAcces", query = "SELECT c FROM Client c WHERE c.acces = :acces"),
    @NamedQuery(name = "Client.findBySoldeCourant", query = "SELECT c FROM Client c WHERE c.soldeCourant = :soldeCourant"),
    @NamedQuery(name = "Client.findByAccepteFacturesEmail", query = "SELECT c FROM Client c WHERE c.accepteFacturesEmail = :accepteFacturesEmail"),
    @NamedQuery(name = "Client.findByDateContact", query = "SELECT c FROM Client c WHERE c.dateContact = :dateContact"),
    @NamedQuery(name = "Client.findByDateRdv", query = "SELECT c FROM Client c WHERE c.dateRdv = :dateRdv"),
    @NamedQuery(name = "Client.findByDateReponse", query = "SELECT c FROM Client c WHERE c.dateReponse = :dateReponse"),
    @NamedQuery(name = "Client.findByActAlarme", query = "SELECT c FROM Client c WHERE c.actAlarme = :actAlarme"),
    @NamedQuery(name = "Client.findByAlarme", query = "SELECT c FROM Client c WHERE c.alarme = :alarme"),
    @NamedQuery(name = "Client.findByAnimaux", query = "SELECT c FROM Client c WHERE c.animaux = :animaux"),
    @NamedQuery(name = "Client.findByCleFournies", query = "SELECT c FROM Client c WHERE c.cleFournies = :cleFournies"),
    @NamedQuery(name = "Client.findByEmplacementAlarme", query = "SELECT c FROM Client c WHERE c.emplacementAlarme = :emplacementAlarme"),
    @NamedQuery(name = "Client.findByNbCles", query = "SELECT c FROM Client c WHERE c.nbCles = :nbCles"),
    @NamedQuery(name = "Client.findByNomsAnimaux", query = "SELECT c FROM Client c WHERE c.nomsAnimaux = :nomsAnimaux"),
    @NamedQuery(name = "Client.findByPresence", query = "SELECT c FROM Client c WHERE c.presence = :presence"),
    @NamedQuery(name = "Client.findByTypeAnimaux", query = "SELECT c FROM Client c WHERE c.typeAnimaux = :typeAnimaux"),
    @NamedQuery(name = "Client.findByCodeCles", query = "SELECT c FROM Client c WHERE c.codeCles = :codeCles"),
    @NamedQuery(name = "Client.findByDescCles", query = "SELECT c FROM Client c WHERE c.descCles = :descCles"),
    @NamedQuery(name = "Client.findByNumAuto", query = "SELECT c FROM Client c WHERE c.numAuto = :numAuto"),
    @NamedQuery(name = "Client.findByItineraire", query = "SELECT c FROM Client c WHERE c.itineraire = :itineraire"),
    @NamedQuery(name = "Client.findByCompteComptable", query = "SELECT c FROM Client c WHERE c.compteComptable = :compteComptable"),
    @NamedQuery(name = "Client.findBySoldeFacturation", query = "SELECT c FROM Client c WHERE c.soldeFacturation = :soldeFacturation"),
    @NamedQuery(name = "Client.findByNumAutoCompta", query = "SELECT c FROM Client c WHERE c.numAutoCompta = :numAutoCompta"),
    @NamedQuery(name = "Client.findByZone", query = "SELECT c FROM Client c WHERE c.zone = :zone"),
    @NamedQuery(name = "Client.findByNumCaf", query = "SELECT c FROM Client c WHERE c.numCaf = :numCaf"),
    @NamedQuery(name = "Client.findByNumMsa", query = "SELECT c FROM Client c WHERE c.numMsa = :numMsa"),
    @NamedQuery(name = "Client.findByLatitudeAdresse", query = "SELECT c FROM Client c WHERE c.latitudeAdresse = :latitudeAdresse"),
    @NamedQuery(name = "Client.findByLongitudeAdresse", query = "SELECT c FROM Client c WHERE c.longitudeAdresse = :longitudeAdresse"),
    @NamedQuery(name = "Client.findByCaf", query = "SELECT c FROM Client c WHERE c.caf = :caf"),
    @NamedQuery(name = "Client.findByClientWS", query = "SELECT c FROM Client c WHERE c.clientWS = :clientWS"),
    @NamedQuery(name = "Client.findByPonctuel", query = "SELECT c FROM Client c WHERE c.ponctuel = :ponctuel"),
    @NamedQuery(name = "Client.findByEmailConjoint", query = "SELECT c FROM Client c WHERE c.emailConjoint = :emailConjoint"),
    @NamedQuery(name = "Client.findByNomConjoint", query = "SELECT c FROM Client c WHERE c.nomConjoint = :nomConjoint"),
    @NamedQuery(name = "Client.findByPrenomConjoint", query = "SELECT c FROM Client c WHERE c.prenomConjoint = :prenomConjoint"),
    @NamedQuery(name = "Client.findByTelephoneConjoint", query = "SELECT c FROM Client c WHERE c.telephoneConjoint = :telephoneConjoint"),
    @NamedQuery(name = "Client.findByCompteAuxiliaire", query = "SELECT c FROM Client c WHERE c.compteAuxiliaire = :compteAuxiliaire"),
    @NamedQuery(name = "Client.findByClientGuestadom", query = "SELECT c FROM Client c WHERE c.clientGuestadom = :clientGuestadom")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "client")
    private boolean client;
    @Basic(optional = false)
    @NotNull
    @Column(name = "supprime")
    private boolean supprime;
    @Column(name = "actif")
    private Boolean actif;
    @Size(max = 255)
    @Column(name = "raisonSociale")
    private String raisonSociale;
    @Size(max = 255)
    @Column(name = "prenom")
    private String prenom;
    @Size(max = 255)
    @Column(name = "mobile")
    private String mobile;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "adresseSuite")
    private String adresseSuite;
    @Size(max = 255)
    @Column(name = "codeApe")
    private String codeApe;
    @Size(max = 7)
    @Column(name = "codePostal")
    private String codePostal;
    @Column(name = "dateCreation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "dateMaj")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateMaj;
    @Size(max = 255)
    @Column(name = "numeroEtVoie")
    private String numeroEtVoie;
    @Size(max = 255)
    @Column(name = "numeroSiren")
    private String numeroSiren;
    @Size(max = 255)
    @Column(name = "telephone")
    private String telephone;
    @Size(max = 255)
    @Column(name = "ville")
    private String ville;
    @Column(name = "dateFin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;
    @Size(max = 255)
    @Column(name = "tvaIntra")
    private String tvaIntra;
    @Size(max = 255)
    @Column(name = "numClient")
    private String numClient;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 30)
    @Column(name = "fax")
    private String fax;
    @Column(name = "civilite")
    private Integer civilite;
    @Column(name = "dateNaissance")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Column(name = "enfants")
    private Integer enfants;
    @Size(max = 255)
    @Column(name = "lieuNaissance")
    private String lieuNaissance;
    @Size(max = 255)
    @Column(name = "nomJeuneFille")
    private String nomJeuneFille;
    @Basic(optional = false)
    @NotNull
    @Column(name = "particulier")
    private boolean particulier;
    @Column(name = "situationFamiliale")
    private Integer situationFamiliale;
    @Size(max = 255)
    @Column(name = "bureau")
    private String bureau;
    @Basic(optional = false)
    @NotNull
    @Column(name = "questionnaire")
    private boolean questionnaire;
    @Size(max = 255)
    @Column(name = "acces")
    private String acces;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "commentaire")
    private String commentaire;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "soldeCourant")
    private Double soldeCourant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "accepteFacturesEmail")
    private boolean accepteFacturesEmail;
    @Column(name = "dateContact")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateContact;
    @Column(name = "dateRdv")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRdv;
    @Column(name = "dateReponse")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReponse;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "exigences")
    private String exigences;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "motifNonValidation")
    private String motifNonValidation;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "accesAnimaux")
    private String accesAnimaux;
    @Size(max = 255)
    @Column(name = "actAlarme")
    private String actAlarme;
    @Basic(optional = false)
    @NotNull
    @Column(name = "alarme")
    private boolean alarme;
    @Basic(optional = false)
    @NotNull
    @Column(name = "animaux")
    private boolean animaux;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cleFournies")
    private boolean cleFournies;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "desAlarme")
    private String desAlarme;
    @Size(max = 255)
    @Column(name = "emplacementAlarme")
    private String emplacementAlarme;
    @Column(name = "nbCles")
    private Integer nbCles;
    @Size(max = 255)
    @Column(name = "nomsAnimaux")
    private String nomsAnimaux;
    @Basic(optional = false)
    @NotNull
    @Column(name = "presence")
    private boolean presence;
    @Size(max = 255)
    @Column(name = "typeAnimaux")
    private String typeAnimaux;
    @Size(max = 255)
    @Column(name = "codeCles")
    private String codeCles;
    @Size(max = 255)
    @Column(name = "descCles")
    private String descCles;
    @Column(name = "numAuto")
    private BigInteger numAuto;
    @Size(max = 255)
    @Column(name = "itineraire")
    private String itineraire;
    @Size(max = 255)
    @Column(name = "compteComptable")
    private String compteComptable;
    @Column(name = "soldeFacturation")
    private Double soldeFacturation;
    @Column(name = "numAutoCompta")
    private BigInteger numAutoCompta;
    @Column(name = "zone")
    private Integer zone;
    @Size(max = 255)
    @Column(name = "numCaf")
    private String numCaf;
    @Size(max = 255)
    @Column(name = "numMsa")
    private String numMsa;
    @Size(max = 255)
    @Column(name = "latitudeAdresse")
    private String latitudeAdresse;
    @Size(max = 255)
    @Column(name = "longitudeAdresse")
    private String longitudeAdresse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "caf")
    private boolean caf;
    @Basic(optional = false)
    @NotNull
    @Column(name = "clientWS")
    private boolean clientWS;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ponctuel")
    private boolean ponctuel;
    @Size(max = 255)
    @Column(name = "emailConjoint")
    private String emailConjoint;
    @Size(max = 255)
    @Column(name = "nomConjoint")
    private String nomConjoint;
    @Size(max = 255)
    @Column(name = "prenomConjoint")
    private String prenomConjoint;
    @Size(max = 255)
    @Column(name = "telephoneConjoint")
    private String telephoneConjoint;
    @Size(max = 255)
    @Column(name = "compteAuxiliaire")
    private String compteAuxiliaire;
    @Basic(optional = false)
    @NotNull
    @Column(name = "clientGuestadom")
    private boolean clientGuestadom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClient", fetch = FetchType.LAZY)
    private Collection<Sc> scCollection;
    @JoinColumn(name = "idCanton", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Canton idCanton;
    @JoinColumn(name = "idLangue", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Langue idLangue;
    @JoinColumn(name = "idConnaissance", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Mdc idConnaissance;
    @JoinColumn(name = "idPays", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Nation idPays;
    @JoinColumn(name = "idSecteur", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private SectGeo idSecteur;
    @JoinColumn(name = "idSoc", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Soc idSoc;
    @JoinColumn(name = "idType", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Ts idType;
    @JoinColumn(name = "idColl", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User idColl;
    @OneToMany(mappedBy = "idClient", fetch = FetchType.LAZY)
    private Collection<Prestations> prestationsCollection;
    @OneToMany(mappedBy = "idClient", fetch = FetchType.LAZY)
    private Collection<User> userCollection;

    public Client() {
    }

    public Client(Long id) {
        this.id = id;
    }

    public Client(Long id, boolean client, boolean supprime, boolean particulier, boolean questionnaire, boolean accepteFacturesEmail, boolean alarme, boolean animaux, boolean cleFournies, boolean presence, boolean caf, boolean clientWS, boolean ponctuel, boolean clientGuestadom) {
        this.id = id;
        this.client = client;
        this.supprime = supprime;
        this.particulier = particulier;
        this.questionnaire = questionnaire;
        this.accepteFacturesEmail = accepteFacturesEmail;
        this.alarme = alarme;
        this.animaux = animaux;
        this.cleFournies = cleFournies;
        this.presence = presence;
        this.caf = caf;
        this.clientWS = clientWS;
        this.ponctuel = ponctuel;
        this.clientGuestadom = clientGuestadom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getClient() {
        return client;
    }

    public void setClient(boolean client) {
        this.client = client;
    }

    public boolean getSupprime() {
        return supprime;
    }

    public void setSupprime(boolean supprime) {
        this.supprime = supprime;
    }

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresseSuite() {
        return adresseSuite;
    }

    public void setAdresseSuite(String adresseSuite) {
        this.adresseSuite = adresseSuite;
    }

    public String getCodeApe() {
        return codeApe;
    }

    public void setCodeApe(String codeApe) {
        this.codeApe = codeApe;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
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

    public String getNumeroEtVoie() {
        return numeroEtVoie;
    }

    public void setNumeroEtVoie(String numeroEtVoie) {
        this.numeroEtVoie = numeroEtVoie;
    }

    public String getNumeroSiren() {
        return numeroSiren;
    }

    public void setNumeroSiren(String numeroSiren) {
        this.numeroSiren = numeroSiren;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getTvaIntra() {
        return tvaIntra;
    }

    public void setTvaIntra(String tvaIntra) {
        this.tvaIntra = tvaIntra;
    }

    public String getNumClient() {
        return numClient;
    }

    public void setNumClient(String numClient) {
        this.numClient = numClient;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Integer getCivilite() {
        return civilite;
    }

    public void setCivilite(Integer civilite) {
        this.civilite = civilite;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Integer getEnfants() {
        return enfants;
    }

    public void setEnfants(Integer enfants) {
        this.enfants = enfants;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getNomJeuneFille() {
        return nomJeuneFille;
    }

    public void setNomJeuneFille(String nomJeuneFille) {
        this.nomJeuneFille = nomJeuneFille;
    }

    public boolean getParticulier() {
        return particulier;
    }

    public void setParticulier(boolean particulier) {
        this.particulier = particulier;
    }

    public Integer getSituationFamiliale() {
        return situationFamiliale;
    }

    public void setSituationFamiliale(Integer situationFamiliale) {
        this.situationFamiliale = situationFamiliale;
    }

    public String getBureau() {
        return bureau;
    }

    public void setBureau(String bureau) {
        this.bureau = bureau;
    }

    public boolean getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(boolean questionnaire) {
        this.questionnaire = questionnaire;
    }

    public String getAcces() {
        return acces;
    }

    public void setAcces(String acces) {
        this.acces = acces;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Double getSoldeCourant() {
        return soldeCourant;
    }

    public void setSoldeCourant(Double soldeCourant) {
        this.soldeCourant = soldeCourant;
    }

    public boolean getAccepteFacturesEmail() {
        return accepteFacturesEmail;
    }

    public void setAccepteFacturesEmail(boolean accepteFacturesEmail) {
        this.accepteFacturesEmail = accepteFacturesEmail;
    }

    public Date getDateContact() {
        return dateContact;
    }

    public void setDateContact(Date dateContact) {
        this.dateContact = dateContact;
    }

    public Date getDateRdv() {
        return dateRdv;
    }

    public void setDateRdv(Date dateRdv) {
        this.dateRdv = dateRdv;
    }

    public Date getDateReponse() {
        return dateReponse;
    }

    public void setDateReponse(Date dateReponse) {
        this.dateReponse = dateReponse;
    }

    public String getExigences() {
        return exigences;
    }

    public void setExigences(String exigences) {
        this.exigences = exigences;
    }

    public String getMotifNonValidation() {
        return motifNonValidation;
    }

    public void setMotifNonValidation(String motifNonValidation) {
        this.motifNonValidation = motifNonValidation;
    }

    public String getAccesAnimaux() {
        return accesAnimaux;
    }

    public void setAccesAnimaux(String accesAnimaux) {
        this.accesAnimaux = accesAnimaux;
    }

    public String getActAlarme() {
        return actAlarme;
    }

    public void setActAlarme(String actAlarme) {
        this.actAlarme = actAlarme;
    }

    public boolean getAlarme() {
        return alarme;
    }

    public void setAlarme(boolean alarme) {
        this.alarme = alarme;
    }

    public boolean getAnimaux() {
        return animaux;
    }

    public void setAnimaux(boolean animaux) {
        this.animaux = animaux;
    }

    public boolean getCleFournies() {
        return cleFournies;
    }

    public void setCleFournies(boolean cleFournies) {
        this.cleFournies = cleFournies;
    }

    public String getDesAlarme() {
        return desAlarme;
    }

    public void setDesAlarme(String desAlarme) {
        this.desAlarme = desAlarme;
    }

    public String getEmplacementAlarme() {
        return emplacementAlarme;
    }

    public void setEmplacementAlarme(String emplacementAlarme) {
        this.emplacementAlarme = emplacementAlarme;
    }

    public Integer getNbCles() {
        return nbCles;
    }

    public void setNbCles(Integer nbCles) {
        this.nbCles = nbCles;
    }

    public String getNomsAnimaux() {
        return nomsAnimaux;
    }

    public void setNomsAnimaux(String nomsAnimaux) {
        this.nomsAnimaux = nomsAnimaux;
    }

    public boolean getPresence() {
        return presence;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }

    public String getTypeAnimaux() {
        return typeAnimaux;
    }

    public void setTypeAnimaux(String typeAnimaux) {
        this.typeAnimaux = typeAnimaux;
    }

    public String getCodeCles() {
        return codeCles;
    }

    public void setCodeCles(String codeCles) {
        this.codeCles = codeCles;
    }

    public String getDescCles() {
        return descCles;
    }

    public void setDescCles(String descCles) {
        this.descCles = descCles;
    }

    public BigInteger getNumAuto() {
        return numAuto;
    }

    public void setNumAuto(BigInteger numAuto) {
        this.numAuto = numAuto;
    }

    public String getItineraire() {
        return itineraire;
    }

    public void setItineraire(String itineraire) {
        this.itineraire = itineraire;
    }

    public String getCompteComptable() {
        return compteComptable;
    }

    public void setCompteComptable(String compteComptable) {
        this.compteComptable = compteComptable;
    }

    public Double getSoldeFacturation() {
        return soldeFacturation;
    }

    public void setSoldeFacturation(Double soldeFacturation) {
        this.soldeFacturation = soldeFacturation;
    }

    public BigInteger getNumAutoCompta() {
        return numAutoCompta;
    }

    public void setNumAutoCompta(BigInteger numAutoCompta) {
        this.numAutoCompta = numAutoCompta;
    }

    public Integer getZone() {
        return zone;
    }

    public void setZone(Integer zone) {
        this.zone = zone;
    }

    public String getNumCaf() {
        return numCaf;
    }

    public void setNumCaf(String numCaf) {
        this.numCaf = numCaf;
    }

    public String getNumMsa() {
        return numMsa;
    }

    public void setNumMsa(String numMsa) {
        this.numMsa = numMsa;
    }

    public String getLatitudeAdresse() {
        return latitudeAdresse;
    }

    public void setLatitudeAdresse(String latitudeAdresse) {
        this.latitudeAdresse = latitudeAdresse;
    }

    public String getLongitudeAdresse() {
        return longitudeAdresse;
    }

    public void setLongitudeAdresse(String longitudeAdresse) {
        this.longitudeAdresse = longitudeAdresse;
    }

    public boolean getCaf() {
        return caf;
    }

    public void setCaf(boolean caf) {
        this.caf = caf;
    }

    public boolean getClientWS() {
        return clientWS;
    }

    public void setClientWS(boolean clientWS) {
        this.clientWS = clientWS;
    }

    public boolean getPonctuel() {
        return ponctuel;
    }

    public void setPonctuel(boolean ponctuel) {
        this.ponctuel = ponctuel;
    }

    public String getEmailConjoint() {
        return emailConjoint;
    }

    public void setEmailConjoint(String emailConjoint) {
        this.emailConjoint = emailConjoint;
    }

    public String getNomConjoint() {
        return nomConjoint;
    }

    public void setNomConjoint(String nomConjoint) {
        this.nomConjoint = nomConjoint;
    }

    public String getPrenomConjoint() {
        return prenomConjoint;
    }

    public void setPrenomConjoint(String prenomConjoint) {
        this.prenomConjoint = prenomConjoint;
    }

    public String getTelephoneConjoint() {
        return telephoneConjoint;
    }

    public void setTelephoneConjoint(String telephoneConjoint) {
        this.telephoneConjoint = telephoneConjoint;
    }

    public String getCompteAuxiliaire() {
        return compteAuxiliaire;
    }

    public void setCompteAuxiliaire(String compteAuxiliaire) {
        this.compteAuxiliaire = compteAuxiliaire;
    }

    public boolean getClientGuestadom() {
        return clientGuestadom;
    }

    public void setClientGuestadom(boolean clientGuestadom) {
        this.clientGuestadom = clientGuestadom;
    }

    @XmlTransient
    public Collection<Sc> getScCollection() {
        return scCollection;
    }

    public void setScCollection(Collection<Sc> scCollection) {
        this.scCollection = scCollection;
    }

    public Canton getIdCanton() {
        return idCanton;
    }

    public void setIdCanton(Canton idCanton) {
        this.idCanton = idCanton;
    }

    public Langue getIdLangue() {
        return idLangue;
    }

    public void setIdLangue(Langue idLangue) {
        this.idLangue = idLangue;
    }

    public Mdc getIdConnaissance() {
        return idConnaissance;
    }

    public void setIdConnaissance(Mdc idConnaissance) {
        this.idConnaissance = idConnaissance;
    }

    public Nation getIdPays() {
        return idPays;
    }

    public void setIdPays(Nation idPays) {
        this.idPays = idPays;
    }

    public SectGeo getIdSecteur() {
        return idSecteur;
    }

    public void setIdSecteur(SectGeo idSecteur) {
        this.idSecteur = idSecteur;
    }

    public Soc getIdSoc() {
        return idSoc;
    }

    public void setIdSoc(Soc idSoc) {
        this.idSoc = idSoc;
    }

    public Ts getIdType() {
        return idType;
    }

    public void setIdType(Ts idType) {
        this.idType = idType;
    }

    public User getIdColl() {
        return idColl;
    }

    public void setIdColl(User idColl) {
        this.idColl = idColl;
    }

    @XmlTransient
    public Collection<Prestations> getPrestationsCollection() {
        return prestationsCollection;
    }

    public void setPrestationsCollection(Collection<Prestations> prestationsCollection) {
        this.prestationsCollection = prestationsCollection;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
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
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.Client[ id=" + id + " ]";
    }
    
}
