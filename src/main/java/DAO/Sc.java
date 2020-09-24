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
@Table(name = "sc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sc.findAll", query = "SELECT s FROM Sc s"),
    @NamedQuery(name = "Sc.findById", query = "SELECT s FROM Sc s WHERE s.id = :id"),
    @NamedQuery(name = "Sc.findBySiege", query = "SELECT s FROM Sc s WHERE s.siege = :siege"),
    @NamedQuery(name = "Sc.findBySupprime", query = "SELECT s FROM Sc s WHERE s.supprime = :supprime"),
    @NamedQuery(name = "Sc.findByActif", query = "SELECT s FROM Sc s WHERE s.actif = :actif"),
    @NamedQuery(name = "Sc.findByDateFin", query = "SELECT s FROM Sc s WHERE s.dateFin = :dateFin"),
    @NamedQuery(name = "Sc.findByLibelle", query = "SELECT s FROM Sc s WHERE s.libelle = :libelle"),
    @NamedQuery(name = "Sc.findByAcces", query = "SELECT s FROM Sc s WHERE s.acces = :acces"),
    @NamedQuery(name = "Sc.findByAdresseSuite", query = "SELECT s FROM Sc s WHERE s.adresseSuite = :adresseSuite"),
    @NamedQuery(name = "Sc.findByCodePostal", query = "SELECT s FROM Sc s WHERE s.codePostal = :codePostal"),
    @NamedQuery(name = "Sc.findByDateCreation", query = "SELECT s FROM Sc s WHERE s.dateCreation = :dateCreation"),
    @NamedQuery(name = "Sc.findByDateMaj", query = "SELECT s FROM Sc s WHERE s.dateMaj = :dateMaj"),
    @NamedQuery(name = "Sc.findByDateSuppression", query = "SELECT s FROM Sc s WHERE s.dateSuppression = :dateSuppression"),
    @NamedQuery(name = "Sc.findByEmail", query = "SELECT s FROM Sc s WHERE s.email = :email"),
    @NamedQuery(name = "Sc.findByMobile", query = "SELECT s FROM Sc s WHERE s.mobile = :mobile"),
    @NamedQuery(name = "Sc.findByNumeroEtVoie", query = "SELECT s FROM Sc s WHERE s.numeroEtVoie = :numeroEtVoie"),
    @NamedQuery(name = "Sc.findByTelephone", query = "SELECT s FROM Sc s WHERE s.telephone = :telephone"),
    @NamedQuery(name = "Sc.findByVille", query = "SELECT s FROM Sc s WHERE s.ville = :ville"),
    @NamedQuery(name = "Sc.findByAdresseSuiteLiv", query = "SELECT s FROM Sc s WHERE s.adresseSuiteLiv = :adresseSuiteLiv"),
    @NamedQuery(name = "Sc.findByCodePostalLiv", query = "SELECT s FROM Sc s WHERE s.codePostalLiv = :codePostalLiv"),
    @NamedQuery(name = "Sc.findByNumeroEtVoieLiv", query = "SELECT s FROM Sc s WHERE s.numeroEtVoieLiv = :numeroEtVoieLiv"),
    @NamedQuery(name = "Sc.findByVilleLiv", query = "SELECT s FROM Sc s WHERE s.villeLiv = :villeLiv"),
    @NamedQuery(name = "Sc.findByNumSite", query = "SELECT s FROM Sc s WHERE s.numSite = :numSite"),
    @NamedQuery(name = "Sc.findByAdresseSuiteCorr", query = "SELECT s FROM Sc s WHERE s.adresseSuiteCorr = :adresseSuiteCorr"),
    @NamedQuery(name = "Sc.findByCodePostalCorr", query = "SELECT s FROM Sc s WHERE s.codePostalCorr = :codePostalCorr"),
    @NamedQuery(name = "Sc.findByFax", query = "SELECT s FROM Sc s WHERE s.fax = :fax"),
    @NamedQuery(name = "Sc.findByNumeroEtVoieCorr", query = "SELECT s FROM Sc s WHERE s.numeroEtVoieCorr = :numeroEtVoieCorr"),
    @NamedQuery(name = "Sc.findByVilleCorr", query = "SELECT s FROM Sc s WHERE s.villeCorr = :villeCorr"),
    @NamedQuery(name = "Sc.findByAbbreviation", query = "SELECT s FROM Sc s WHERE s.abbreviation = :abbreviation"),
    @NamedQuery(name = "Sc.findByFond", query = "SELECT s FROM Sc s WHERE s.fond = :fond"),
    @NamedQuery(name = "Sc.findByTexte", query = "SELECT s FROM Sc s WHERE s.texte = :texte"),
    @NamedQuery(name = "Sc.findByCorrespondant", query = "SELECT s FROM Sc s WHERE s.correspondant = :correspondant"),
    @NamedQuery(name = "Sc.findByAccepteFacturesEmail", query = "SELECT s FROM Sc s WHERE s.accepteFacturesEmail = :accepteFacturesEmail"),
    @NamedQuery(name = "Sc.findBySurfaceTotale", query = "SELECT s FROM Sc s WHERE s.surfaceTotale = :surfaceTotale"),
    @NamedQuery(name = "Sc.findBySurfaceVitre", query = "SELECT s FROM Sc s WHERE s.surfaceVitre = :surfaceVitre"),
    @NamedQuery(name = "Sc.findByDirecteurOperationnel", query = "SELECT s FROM Sc s WHERE s.directeurOperationnel = :directeurOperationnel"),
    @NamedQuery(name = "Sc.findByDirecteurRegional", query = "SELECT s FROM Sc s WHERE s.directeurRegional = :directeurRegional"),
    @NamedQuery(name = "Sc.findByGroupe1", query = "SELECT s FROM Sc s WHERE s.groupe1 = :groupe1"),
    @NamedQuery(name = "Sc.findByGroupe2", query = "SELECT s FROM Sc s WHERE s.groupe2 = :groupe2"),
    @NamedQuery(name = "Sc.findByGroupe3", query = "SELECT s FROM Sc s WHERE s.groupe3 = :groupe3"),
    @NamedQuery(name = "Sc.findByTelephoneOperationnel", query = "SELECT s FROM Sc s WHERE s.telephoneOperationnel = :telephoneOperationnel"),
    @NamedQuery(name = "Sc.findByItineraire", query = "SELECT s FROM Sc s WHERE s.itineraire = :itineraire"),
    @NamedQuery(name = "Sc.findByPushed", query = "SELECT s FROM Sc s WHERE s.pushed = :pushed"),
    @NamedQuery(name = "Sc.findByLatitudeAdresse", query = "SELECT s FROM Sc s WHERE s.latitudeAdresse = :latitudeAdresse"),
    @NamedQuery(name = "Sc.findByLongitudeAdresse", query = "SELECT s FROM Sc s WHERE s.longitudeAdresse = :longitudeAdresse"),
    @NamedQuery(name = "Sc.findByNumAuto", query = "SELECT s FROM Sc s WHERE s.numAuto = :numAuto"),
    @NamedQuery(name = "Sc.findByRegion", query = "SELECT s FROM Sc s WHERE s.region = :region"),
    @NamedQuery(name = "Sc.findByCompteAuxiliaire", query = "SELECT s FROM Sc s WHERE s.compteAuxiliaire = :compteAuxiliaire"),
    @NamedQuery(name = "Sc.findByCompteComptable", query = "SELECT s FROM Sc s WHERE s.compteComptable = :compteComptable"),
    @NamedQuery(name = "Sc.findByFacturable", query = "SELECT s FROM Sc s WHERE s.facturable = :facturable"),
    @NamedQuery(name = "Sc.findBySoldeCourant", query = "SELECT s FROM Sc s WHERE s.soldeCourant = :soldeCourant"),
    @NamedQuery(name = "Sc.findBySoldeFacturation", query = "SELECT s FROM Sc s WHERE s.soldeFacturation = :soldeFacturation"),
    @NamedQuery(name = "Sc.findByCodeNfc", query = "SELECT s FROM Sc s WHERE s.codeNfc = :codeNfc"),
    @NamedQuery(name = "Sc.findByPushed2", query = "SELECT s FROM Sc s WHERE s.pushed2 = :pushed2"),
    @NamedQuery(name = "Sc.findByNumAutoCompta", query = "SELECT s FROM Sc s WHERE s.numAutoCompta = :numAutoCompta"),
    @NamedQuery(name = "Sc.findByInterdireJf", query = "SELECT s FROM Sc s WHERE s.interdireJf = :interdireJf"),
    @NamedQuery(name = "Sc.findByTypeRapportMobiclean", query = "SELECT s FROM Sc s WHERE s.typeRapportMobiclean = :typeRapportMobiclean"),
    @NamedQuery(name = "Sc.findByGroupeFacturation", query = "SELECT s FROM Sc s WHERE s.groupeFacturation = :groupeFacturation"),
    @NamedQuery(name = "Sc.findByCodeClef", query = "SELECT s FROM Sc s WHERE s.codeClef = :codeClef"),
    @NamedQuery(name = "Sc.findByLogement", query = "SELECT s FROM Sc s WHERE s.logement = :logement"),
    @NamedQuery(name = "Sc.findByNumAutoCodeClef", query = "SELECT s FROM Sc s WHERE s.numAutoCodeClef = :numAutoCodeClef"),
    @NamedQuery(name = "Sc.findByChorus", query = "SELECT s FROM Sc s WHERE s.chorus = :chorus"),
    @NamedQuery(name = "Sc.findByCodeService", query = "SELECT s FROM Sc s WHERE s.codeService = :codeService")})
public class Sc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "siege")
    private boolean siege;
    @Basic(optional = false)
    @NotNull
    @Column(name = "supprime")
    private boolean supprime;
    @Column(name = "actif")
    private Boolean actif;
    @Column(name = "dateFin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @Size(max = 255)
    @Column(name = "libelle")
    private String libelle;
    @Size(max = 255)
    @Column(name = "acces")
    private String acces;
    @Size(max = 255)
    @Column(name = "adresseSuite")
    private String adresseSuite;
    @Size(max = 7)
    @Column(name = "codePostal")
    private String codePostal;
    @Column(name = "dateCreation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "dateMaj")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateMaj;
    @Column(name = "dateSuppression")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSuppression;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 30)
    @Column(name = "mobile")
    private String mobile;
    @Size(max = 255)
    @Column(name = "numeroEtVoie")
    private String numeroEtVoie;
    @Size(max = 30)
    @Column(name = "telephone")
    private String telephone;
    @Size(max = 255)
    @Column(name = "ville")
    private String ville;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "commentaire")
    private String commentaire;
    @Size(max = 255)
    @Column(name = "adresseSuiteLiv")
    private String adresseSuiteLiv;
    @Size(max = 7)
    @Column(name = "codePostalLiv")
    private String codePostalLiv;
    @Size(max = 255)
    @Column(name = "numeroEtVoieLiv")
    private String numeroEtVoieLiv;
    @Size(max = 255)
    @Column(name = "villeLiv")
    private String villeLiv;
    @Size(max = 255)
    @Column(name = "numSite")
    private String numSite;
    @Size(max = 255)
    @Column(name = "adresseSuiteCorr")
    private String adresseSuiteCorr;
    @Size(max = 7)
    @Column(name = "codePostalCorr")
    private String codePostalCorr;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 30)
    @Column(name = "fax")
    private String fax;
    @Size(max = 255)
    @Column(name = "numeroEtVoieCorr")
    private String numeroEtVoieCorr;
    @Size(max = 255)
    @Column(name = "villeCorr")
    private String villeCorr;
    @Size(max = 255)
    @Column(name = "abbreviation")
    private String abbreviation;
    @Size(max = 7)
    @Column(name = "fond")
    private String fond;
    @Size(max = 7)
    @Column(name = "texte")
    private String texte;
    @Size(max = 255)
    @Column(name = "correspondant")
    private String correspondant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "accepteFacturesEmail")
    private boolean accepteFacturesEmail;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "surfaceTotale")
    private Double surfaceTotale;
    @Column(name = "surfaceVitre")
    private Double surfaceVitre;
    @Size(max = 255)
    @Column(name = "directeurOperationnel")
    private String directeurOperationnel;
    @Size(max = 255)
    @Column(name = "directeurRegional")
    private String directeurRegional;
    @Size(max = 255)
    @Column(name = "groupe1")
    private String groupe1;
    @Size(max = 255)
    @Column(name = "groupe2")
    private String groupe2;
    @Size(max = 255)
    @Column(name = "groupe3")
    private String groupe3;
    @Size(max = 255)
    @Column(name = "telephoneOperationnel")
    private String telephoneOperationnel;
    @Size(max = 255)
    @Column(name = "itineraire")
    private String itineraire;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "codeAlarme")
    private String codeAlarme;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "eau")
    private String eau;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "electricite")
    private String electricite;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "localMenage")
    private String localMenage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pushed")
    private boolean pushed;
    @Size(max = 255)
    @Column(name = "latitudeAdresse")
    private String latitudeAdresse;
    @Size(max = 255)
    @Column(name = "longitudeAdresse")
    private String longitudeAdresse;
    @Column(name = "numAuto")
    private BigInteger numAuto;
    @Size(max = 255)
    @Column(name = "region")
    private String region;
    @Size(max = 255)
    @Column(name = "compteAuxiliaire")
    private String compteAuxiliaire;
    @Size(max = 255)
    @Column(name = "compteComptable")
    private String compteComptable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "facturable")
    private boolean facturable;
    @Column(name = "soldeCourant")
    private Double soldeCourant;
    @Column(name = "soldeFacturation")
    private Double soldeFacturation;
    @Size(max = 255)
    @Column(name = "codeNfc")
    private String codeNfc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pushed2")
    private boolean pushed2;
    @Column(name = "numAutoCompta")
    private BigInteger numAutoCompta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "interdireJf")
    private boolean interdireJf;
    @Basic(optional = false)
    @NotNull
    @Column(name = "typeRapportMobiclean")
    private int typeRapportMobiclean;
    @Column(name = "groupeFacturation")
    private Integer groupeFacturation;
    @Size(max = 255)
    @Column(name = "codeClef")
    private String codeClef;
    @Basic(optional = false)
    @NotNull
    @Column(name = "logement")
    private boolean logement;
    @Column(name = "numAutoCodeClef")
    private BigInteger numAutoCodeClef;
    @Basic(optional = false)
    @NotNull
    @Column(name = "chorus")
    private boolean chorus;
    @Size(max = 255)
    @Column(name = "codeService")
    private String codeService;
    @JoinColumn(name = "idCommercial", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Candidatsalarie idCommercial;
    @JoinColumn(name = "idActivite", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Activite idActivite;
    @JoinColumn(name = "idSoc", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Soc idSoc;
    @JoinColumn(name = "idPaysCorr", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Nation idPaysCorr;
    @JoinColumn(name = "idPole", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Pole idPole;
    @JoinColumn(name = "idResponsable", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Candidatsalarie idResponsable;
    @JoinColumn(name = "idChefEquipe", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Candidatsalarie idChefEquipe;
    @JoinColumn(name = "idSection", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Section idSection;
    @JoinColumn(name = "idTva", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tva idTva;
    @JoinColumn(name = "idGrp3", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Grp1 idGrp3;
    @JoinColumn(name = "idPays", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Nation idPays;
    @JoinColumn(name = "idType", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Ts idType;
    @JoinColumn(name = "idModeleFacture", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ModeleGed idModeleFacture;
    @JoinColumn(name = "idGrp2", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Grp2 idGrp2;
    @JoinColumn(name = "idInspecteur", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Candidatsalarie idInspecteur;
    @JoinColumn(name = "idCantonCorr", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Canton idCantonCorr;
    @JoinColumn(name = "idCantonLiv", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Canton idCantonLiv;
    @JoinColumn(name = "idCanton", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Canton idCanton;
    @JoinColumn(name = "idClient", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Client idClient;
    @JoinColumn(name = "idPaysLiv", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Nation idPaysLiv;
    @JoinColumn(name = "idGroupe", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private GroupeRemise idGroupe;
    @JoinColumn(name = "idSecteur", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private SectGeo idSecteur;
    @JoinColumn(name = "idGrp1", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Grp1 idGrp1;
    @OneToMany(mappedBy = "idSite", fetch = FetchType.LAZY)
    private Collection<User> userCollection;

    public Sc() {
    }

    public Sc(Long id) {
        this.id = id;
    }

    public Sc(Long id, boolean siege, boolean supprime, boolean accepteFacturesEmail, boolean pushed, boolean facturable, boolean pushed2, boolean interdireJf, int typeRapportMobiclean, boolean logement, boolean chorus) {
        this.id = id;
        this.siege = siege;
        this.supprime = supprime;
        this.accepteFacturesEmail = accepteFacturesEmail;
        this.pushed = pushed;
        this.facturable = facturable;
        this.pushed2 = pushed2;
        this.interdireJf = interdireJf;
        this.typeRapportMobiclean = typeRapportMobiclean;
        this.logement = logement;
        this.chorus = chorus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getSiege() {
        return siege;
    }

    public void setSiege(boolean siege) {
        this.siege = siege;
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

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getAcces() {
        return acces;
    }

    public void setAcces(String acces) {
        this.acces = acces;
    }

    public String getAdresseSuite() {
        return adresseSuite;
    }

    public void setAdresseSuite(String adresseSuite) {
        this.adresseSuite = adresseSuite;
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

    public Date getDateSuppression() {
        return dateSuppression;
    }

    public void setDateSuppression(Date dateSuppression) {
        this.dateSuppression = dateSuppression;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNumeroEtVoie() {
        return numeroEtVoie;
    }

    public void setNumeroEtVoie(String numeroEtVoie) {
        this.numeroEtVoie = numeroEtVoie;
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

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getAdresseSuiteLiv() {
        return adresseSuiteLiv;
    }

    public void setAdresseSuiteLiv(String adresseSuiteLiv) {
        this.adresseSuiteLiv = adresseSuiteLiv;
    }

    public String getCodePostalLiv() {
        return codePostalLiv;
    }

    public void setCodePostalLiv(String codePostalLiv) {
        this.codePostalLiv = codePostalLiv;
    }

    public String getNumeroEtVoieLiv() {
        return numeroEtVoieLiv;
    }

    public void setNumeroEtVoieLiv(String numeroEtVoieLiv) {
        this.numeroEtVoieLiv = numeroEtVoieLiv;
    }

    public String getVilleLiv() {
        return villeLiv;
    }

    public void setVilleLiv(String villeLiv) {
        this.villeLiv = villeLiv;
    }

    public String getNumSite() {
        return numSite;
    }

    public void setNumSite(String numSite) {
        this.numSite = numSite;
    }

    public String getAdresseSuiteCorr() {
        return adresseSuiteCorr;
    }

    public void setAdresseSuiteCorr(String adresseSuiteCorr) {
        this.adresseSuiteCorr = adresseSuiteCorr;
    }

    public String getCodePostalCorr() {
        return codePostalCorr;
    }

    public void setCodePostalCorr(String codePostalCorr) {
        this.codePostalCorr = codePostalCorr;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getNumeroEtVoieCorr() {
        return numeroEtVoieCorr;
    }

    public void setNumeroEtVoieCorr(String numeroEtVoieCorr) {
        this.numeroEtVoieCorr = numeroEtVoieCorr;
    }

    public String getVilleCorr() {
        return villeCorr;
    }

    public void setVilleCorr(String villeCorr) {
        this.villeCorr = villeCorr;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
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

    public String getCorrespondant() {
        return correspondant;
    }

    public void setCorrespondant(String correspondant) {
        this.correspondant = correspondant;
    }

    public boolean getAccepteFacturesEmail() {
        return accepteFacturesEmail;
    }

    public void setAccepteFacturesEmail(boolean accepteFacturesEmail) {
        this.accepteFacturesEmail = accepteFacturesEmail;
    }

    public Double getSurfaceTotale() {
        return surfaceTotale;
    }

    public void setSurfaceTotale(Double surfaceTotale) {
        this.surfaceTotale = surfaceTotale;
    }

    public Double getSurfaceVitre() {
        return surfaceVitre;
    }

    public void setSurfaceVitre(Double surfaceVitre) {
        this.surfaceVitre = surfaceVitre;
    }

    public String getDirecteurOperationnel() {
        return directeurOperationnel;
    }

    public void setDirecteurOperationnel(String directeurOperationnel) {
        this.directeurOperationnel = directeurOperationnel;
    }

    public String getDirecteurRegional() {
        return directeurRegional;
    }

    public void setDirecteurRegional(String directeurRegional) {
        this.directeurRegional = directeurRegional;
    }

    public String getGroupe1() {
        return groupe1;
    }

    public void setGroupe1(String groupe1) {
        this.groupe1 = groupe1;
    }

    public String getGroupe2() {
        return groupe2;
    }

    public void setGroupe2(String groupe2) {
        this.groupe2 = groupe2;
    }

    public String getGroupe3() {
        return groupe3;
    }

    public void setGroupe3(String groupe3) {
        this.groupe3 = groupe3;
    }

    public String getTelephoneOperationnel() {
        return telephoneOperationnel;
    }

    public void setTelephoneOperationnel(String telephoneOperationnel) {
        this.telephoneOperationnel = telephoneOperationnel;
    }

    public String getItineraire() {
        return itineraire;
    }

    public void setItineraire(String itineraire) {
        this.itineraire = itineraire;
    }

    public String getCodeAlarme() {
        return codeAlarme;
    }

    public void setCodeAlarme(String codeAlarme) {
        this.codeAlarme = codeAlarme;
    }

    public String getEau() {
        return eau;
    }

    public void setEau(String eau) {
        this.eau = eau;
    }

    public String getElectricite() {
        return electricite;
    }

    public void setElectricite(String electricite) {
        this.electricite = electricite;
    }

    public String getLocalMenage() {
        return localMenage;
    }

    public void setLocalMenage(String localMenage) {
        this.localMenage = localMenage;
    }

    public boolean getPushed() {
        return pushed;
    }

    public void setPushed(boolean pushed) {
        this.pushed = pushed;
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

    public BigInteger getNumAuto() {
        return numAuto;
    }

    public void setNumAuto(BigInteger numAuto) {
        this.numAuto = numAuto;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCompteAuxiliaire() {
        return compteAuxiliaire;
    }

    public void setCompteAuxiliaire(String compteAuxiliaire) {
        this.compteAuxiliaire = compteAuxiliaire;
    }

    public String getCompteComptable() {
        return compteComptable;
    }

    public void setCompteComptable(String compteComptable) {
        this.compteComptable = compteComptable;
    }

    public boolean getFacturable() {
        return facturable;
    }

    public void setFacturable(boolean facturable) {
        this.facturable = facturable;
    }

    public Double getSoldeCourant() {
        return soldeCourant;
    }

    public void setSoldeCourant(Double soldeCourant) {
        this.soldeCourant = soldeCourant;
    }

    public Double getSoldeFacturation() {
        return soldeFacturation;
    }

    public void setSoldeFacturation(Double soldeFacturation) {
        this.soldeFacturation = soldeFacturation;
    }

    public String getCodeNfc() {
        return codeNfc;
    }

    public void setCodeNfc(String codeNfc) {
        this.codeNfc = codeNfc;
    }

    public boolean getPushed2() {
        return pushed2;
    }

    public void setPushed2(boolean pushed2) {
        this.pushed2 = pushed2;
    }

    public BigInteger getNumAutoCompta() {
        return numAutoCompta;
    }

    public void setNumAutoCompta(BigInteger numAutoCompta) {
        this.numAutoCompta = numAutoCompta;
    }

    public boolean getInterdireJf() {
        return interdireJf;
    }

    public void setInterdireJf(boolean interdireJf) {
        this.interdireJf = interdireJf;
    }

    public int getTypeRapportMobiclean() {
        return typeRapportMobiclean;
    }

    public void setTypeRapportMobiclean(int typeRapportMobiclean) {
        this.typeRapportMobiclean = typeRapportMobiclean;
    }

    public Integer getGroupeFacturation() {
        return groupeFacturation;
    }

    public void setGroupeFacturation(Integer groupeFacturation) {
        this.groupeFacturation = groupeFacturation;
    }

    public String getCodeClef() {
        return codeClef;
    }

    public void setCodeClef(String codeClef) {
        this.codeClef = codeClef;
    }

    public boolean getLogement() {
        return logement;
    }

    public void setLogement(boolean logement) {
        this.logement = logement;
    }

    public BigInteger getNumAutoCodeClef() {
        return numAutoCodeClef;
    }

    public void setNumAutoCodeClef(BigInteger numAutoCodeClef) {
        this.numAutoCodeClef = numAutoCodeClef;
    }

    public boolean getChorus() {
        return chorus;
    }

    public void setChorus(boolean chorus) {
        this.chorus = chorus;
    }

    public String getCodeService() {
        return codeService;
    }

    public void setCodeService(String codeService) {
        this.codeService = codeService;
    }

    public Candidatsalarie getIdCommercial() {
        return idCommercial;
    }

    public void setIdCommercial(Candidatsalarie idCommercial) {
        this.idCommercial = idCommercial;
    }

    public Activite getIdActivite() {
        return idActivite;
    }

    public void setIdActivite(Activite idActivite) {
        this.idActivite = idActivite;
    }

    public Soc getIdSoc() {
        return idSoc;
    }

    public void setIdSoc(Soc idSoc) {
        this.idSoc = idSoc;
    }

    public Nation getIdPaysCorr() {
        return idPaysCorr;
    }

    public void setIdPaysCorr(Nation idPaysCorr) {
        this.idPaysCorr = idPaysCorr;
    }

    public Pole getIdPole() {
        return idPole;
    }

    public void setIdPole(Pole idPole) {
        this.idPole = idPole;
    }

    public Candidatsalarie getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(Candidatsalarie idResponsable) {
        this.idResponsable = idResponsable;
    }

    public Candidatsalarie getIdChefEquipe() {
        return idChefEquipe;
    }

    public void setIdChefEquipe(Candidatsalarie idChefEquipe) {
        this.idChefEquipe = idChefEquipe;
    }

    public Section getIdSection() {
        return idSection;
    }

    public void setIdSection(Section idSection) {
        this.idSection = idSection;
    }

    public Tva getIdTva() {
        return idTva;
    }

    public void setIdTva(Tva idTva) {
        this.idTva = idTva;
    }

    public Grp1 getIdGrp3() {
        return idGrp3;
    }

    public void setIdGrp3(Grp1 idGrp3) {
        this.idGrp3 = idGrp3;
    }

    public Nation getIdPays() {
        return idPays;
    }

    public void setIdPays(Nation idPays) {
        this.idPays = idPays;
    }

    public Ts getIdType() {
        return idType;
    }

    public void setIdType(Ts idType) {
        this.idType = idType;
    }

    public ModeleGed getIdModeleFacture() {
        return idModeleFacture;
    }

    public void setIdModeleFacture(ModeleGed idModeleFacture) {
        this.idModeleFacture = idModeleFacture;
    }

    public Grp2 getIdGrp2() {
        return idGrp2;
    }

    public void setIdGrp2(Grp2 idGrp2) {
        this.idGrp2 = idGrp2;
    }

    public Candidatsalarie getIdInspecteur() {
        return idInspecteur;
    }

    public void setIdInspecteur(Candidatsalarie idInspecteur) {
        this.idInspecteur = idInspecteur;
    }

    public Canton getIdCantonCorr() {
        return idCantonCorr;
    }

    public void setIdCantonCorr(Canton idCantonCorr) {
        this.idCantonCorr = idCantonCorr;
    }

    public Canton getIdCantonLiv() {
        return idCantonLiv;
    }

    public void setIdCantonLiv(Canton idCantonLiv) {
        this.idCantonLiv = idCantonLiv;
    }

    public Canton getIdCanton() {
        return idCanton;
    }

    public void setIdCanton(Canton idCanton) {
        this.idCanton = idCanton;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    public Nation getIdPaysLiv() {
        return idPaysLiv;
    }

    public void setIdPaysLiv(Nation idPaysLiv) {
        this.idPaysLiv = idPaysLiv;
    }

    public GroupeRemise getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(GroupeRemise idGroupe) {
        this.idGroupe = idGroupe;
    }

    public SectGeo getIdSecteur() {
        return idSecteur;
    }

    public void setIdSecteur(SectGeo idSecteur) {
        this.idSecteur = idSecteur;
    }

    public Grp1 getIdGrp1() {
        return idGrp1;
    }

    public void setIdGrp1(Grp1 idGrp1) {
        this.idGrp1 = idGrp1;
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
        if (!(object instanceof Sc)) {
            return false;
        }
        Sc other = (Sc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.Sc[ id=" + id + " ]";
    }
    
}
