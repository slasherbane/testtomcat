/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "soc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Soc.findAll", query = "SELECT s FROM Soc s"),
    @NamedQuery(name = "Soc.findById", query = "SELECT s FROM Soc s WHERE s.id = :id"),
    @NamedQuery(name = "Soc.findBySupprime", query = "SELECT s FROM Soc s WHERE s.supprime = :supprime"),
    @NamedQuery(name = "Soc.findByTypeSociete", query = "SELECT s FROM Soc s WHERE s.typeSociete = :typeSociete"),
    @NamedQuery(name = "Soc.findByAccepteEmails", query = "SELECT s FROM Soc s WHERE s.accepteEmails = :accepteEmails"),
    @NamedQuery(name = "Soc.findByEnseigne", query = "SELECT s FROM Soc s WHERE s.enseigne = :enseigne"),
    @NamedQuery(name = "Soc.findByRaisonSociale", query = "SELECT s FROM Soc s WHERE s.raisonSociale = :raisonSociale"),
    @NamedQuery(name = "Soc.findByLibelleCommercial", query = "SELECT s FROM Soc s WHERE s.libelleCommercial = :libelleCommercial"),
    @NamedQuery(name = "Soc.findByCodeLiaison", query = "SELECT s FROM Soc s WHERE s.codeLiaison = :codeLiaison"),
    @NamedQuery(name = "Soc.findBySap", query = "SELECT s FROM Soc s WHERE s.sap = :sap"),
    @NamedQuery(name = "Soc.findByGed", query = "SELECT s FROM Soc s WHERE s.ged = :ged"),
    @NamedQuery(name = "Soc.findByQualimobi", query = "SELECT s FROM Soc s WHERE s.qualimobi = :qualimobi"),
    @NamedQuery(name = "Soc.findByMobiclean", query = "SELECT s FROM Soc s WHERE s.mobiclean = :mobiclean"),
    @NamedQuery(name = "Soc.findByTournee", query = "SELECT s FROM Soc s WHERE s.tournee = :tournee"),
    @NamedQuery(name = "Soc.findBySaisieHoraire", query = "SELECT s FROM Soc s WHERE s.saisieHoraire = :saisieHoraire"),
    @NamedQuery(name = "Soc.findBySmsActif", query = "SELECT s FROM Soc s WHERE s.smsActif = :smsActif"),
    @NamedQuery(name = "Soc.findByEv", query = "SELECT s FROM Soc s WHERE s.ev = :ev"),
    @NamedQuery(name = "Soc.findByPenbase", query = "SELECT s FROM Soc s WHERE s.penbase = :penbase"),
    @NamedQuery(name = "Soc.findByCodeReseau", query = "SELECT s FROM Soc s WHERE s.codeReseau = :codeReseau"),
    @NamedQuery(name = "Soc.findByAdresseSuite", query = "SELECT s FROM Soc s WHERE s.adresseSuite = :adresseSuite"),
    @NamedQuery(name = "Soc.findByCodePostal", query = "SELECT s FROM Soc s WHERE s.codePostal = :codePostal"),
    @NamedQuery(name = "Soc.findByDateCreation", query = "SELECT s FROM Soc s WHERE s.dateCreation = :dateCreation"),
    @NamedQuery(name = "Soc.findByDateMaj", query = "SELECT s FROM Soc s WHERE s.dateMaj = :dateMaj"),
    @NamedQuery(name = "Soc.findByDateSuppressionLogique", query = "SELECT s FROM Soc s WHERE s.dateSuppressionLogique = :dateSuppressionLogique"),
    @NamedQuery(name = "Soc.findByEmail", query = "SELECT s FROM Soc s WHERE s.email = :email"),
    @NamedQuery(name = "Soc.findByFax", query = "SELECT s FROM Soc s WHERE s.fax = :fax"),
    @NamedQuery(name = "Soc.findByGroupe", query = "SELECT s FROM Soc s WHERE s.groupe = :groupe"),
    @NamedQuery(name = "Soc.findByNumeroEtVoie", query = "SELECT s FROM Soc s WHERE s.numeroEtVoie = :numeroEtVoie"),
    @NamedQuery(name = "Soc.findByReglementation", query = "SELECT s FROM Soc s WHERE s.reglementation = :reglementation"),
    @NamedQuery(name = "Soc.findBySiret", query = "SELECT s FROM Soc s WHERE s.siret = :siret"),
    @NamedQuery(name = "Soc.findBySiteWeb", query = "SELECT s FROM Soc s WHERE s.siteWeb = :siteWeb"),
    @NamedQuery(name = "Soc.findByTelephone", query = "SELECT s FROM Soc s WHERE s.telephone = :telephone"),
    @NamedQuery(name = "Soc.findByVille", query = "SELECT s FROM Soc s WHERE s.ville = :ville"),
    @NamedQuery(name = "Soc.findByAdressePrevoyance", query = "SELECT s FROM Soc s WHERE s.adressePrevoyance = :adressePrevoyance"),
    @NamedQuery(name = "Soc.findByAdresseRetraite", query = "SELECT s FROM Soc s WHERE s.adresseRetraite = :adresseRetraite"),
    @NamedQuery(name = "Soc.findByApe", query = "SELECT s FROM Soc s WHERE s.ape = :ape"),
    @NamedQuery(name = "Soc.findByCapital", query = "SELECT s FROM Soc s WHERE s.capital = :capital"),
    @NamedQuery(name = "Soc.findByCodePostalPrevoyance", query = "SELECT s FROM Soc s WHERE s.codePostalPrevoyance = :codePostalPrevoyance"),
    @NamedQuery(name = "Soc.findByCodePostalRetraite", query = "SELECT s FROM Soc s WHERE s.codePostalRetraite = :codePostalRetraite"),
    @NamedQuery(name = "Soc.findByFormeJuridique", query = "SELECT s FROM Soc s WHERE s.formeJuridique = :formeJuridique"),
    @NamedQuery(name = "Soc.findByNomGerant", query = "SELECT s FROM Soc s WHERE s.nomGerant = :nomGerant"),
    @NamedQuery(name = "Soc.findByNomPrevoyance", query = "SELECT s FROM Soc s WHERE s.nomPrevoyance = :nomPrevoyance"),
    @NamedQuery(name = "Soc.findByNomRetraite", query = "SELECT s FROM Soc s WHERE s.nomRetraite = :nomRetraite"),
    @NamedQuery(name = "Soc.findByNumRcs", query = "SELECT s FROM Soc s WHERE s.numRcs = :numRcs"),
    @NamedQuery(name = "Soc.findByNumUrssaf", query = "SELECT s FROM Soc s WHERE s.numUrssaf = :numUrssaf"),
    @NamedQuery(name = "Soc.findByPrenomGerant", query = "SELECT s FROM Soc s WHERE s.prenomGerant = :prenomGerant"),
    @NamedQuery(name = "Soc.findByRegionUrssaf", query = "SELECT s FROM Soc s WHERE s.regionUrssaf = :regionUrssaf"),
    @NamedQuery(name = "Soc.findBySecteur", query = "SELECT s FROM Soc s WHERE s.secteur = :secteur"),
    @NamedQuery(name = "Soc.findByTvaIntra", query = "SELECT s FROM Soc s WHERE s.tvaIntra = :tvaIntra"),
    @NamedQuery(name = "Soc.findByVillePrevoyance", query = "SELECT s FROM Soc s WHERE s.villePrevoyance = :villePrevoyance"),
    @NamedQuery(name = "Soc.findByVilleRcs", query = "SELECT s FROM Soc s WHERE s.villeRcs = :villeRcs"),
    @NamedQuery(name = "Soc.findByVilleRetraite", query = "SELECT s FROM Soc s WHERE s.villeRetraite = :villeRetraite"),
    @NamedQuery(name = "Soc.findByDateAgrement", query = "SELECT s FROM Soc s WHERE s.dateAgrement = :dateAgrement"),
    @NamedQuery(name = "Soc.findByNumeroAgrement", query = "SELECT s FROM Soc s WHERE s.numeroAgrement = :numeroAgrement"),
    @NamedQuery(name = "Soc.findByNumeroDeclaration", query = "SELECT s FROM Soc s WHERE s.numeroDeclaration = :numeroDeclaration"),
    @NamedQuery(name = "Soc.findByCivilite", query = "SELECT s FROM Soc s WHERE s.civilite = :civilite"),
    @NamedQuery(name = "Soc.findByAdresseSante", query = "SELECT s FROM Soc s WHERE s.adresseSante = :adresseSante"),
    @NamedQuery(name = "Soc.findByCodePostalSante", query = "SELECT s FROM Soc s WHERE s.codePostalSante = :codePostalSante"),
    @NamedQuery(name = "Soc.findByNomSante", query = "SELECT s FROM Soc s WHERE s.nomSante = :nomSante"),
    @NamedQuery(name = "Soc.findByVilleSante", query = "SELECT s FROM Soc s WHERE s.villeSante = :villeSante"),
    @NamedQuery(name = "Soc.findByNbLicences", query = "SELECT s FROM Soc s WHERE s.nbLicences = :nbLicences"),
    @NamedQuery(name = "Soc.findByAfficherEnMinutes", query = "SELECT s FROM Soc s WHERE s.afficherEnMinutes = :afficherEnMinutes"),
    @NamedQuery(name = "Soc.findByLatitude", query = "SELECT s FROM Soc s WHERE s.latitude = :latitude"),
    @NamedQuery(name = "Soc.findByLongitude", query = "SELECT s FROM Soc s WHERE s.longitude = :longitude"),
    @NamedQuery(name = "Soc.findByDateDeclaration", query = "SELECT s FROM Soc s WHERE s.dateDeclaration = :dateDeclaration"),
    @NamedQuery(name = "Soc.findByZone", query = "SELECT s FROM Soc s WHERE s.zone = :zone"),
    @NamedQuery(name = "Soc.findByTelephonie", query = "SELECT s FROM Soc s WHERE s.telephonie = :telephonie"),
    @NamedQuery(name = "Soc.findByCodePaysTel", query = "SELECT s FROM Soc s WHERE s.codePaysTel = :codePaysTel"),
    @NamedQuery(name = "Soc.findByGuestadomActif", query = "SELECT s FROM Soc s WHERE s.guestadomActif = :guestadomActif")})
public class Soc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "supprime")
    private boolean supprime;
    @Column(name = "typeSociete")
    private Integer typeSociete;
    @Basic(optional = false)
    @NotNull
    @Column(name = "accepteEmails")
    private boolean accepteEmails;
    @Size(max = 255)
    @Column(name = "enseigne")
    private String enseigne;
    @Size(max = 255)
    @Column(name = "raisonSociale")
    private String raisonSociale;
    @Size(max = 255)
    @Column(name = "libelleCommercial")
    private String libelleCommercial;
    @Size(max = 5)
    @Column(name = "codeLiaison")
    private String codeLiaison;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sap")
    private boolean sap;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ged")
    private boolean ged;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qualimobi")
    private boolean qualimobi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mobiclean")
    private boolean mobiclean;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tournee")
    private boolean tournee;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saisieHoraire")
    private boolean saisieHoraire;
    @Basic(optional = false)
    @NotNull
    @Column(name = "smsActif")
    private boolean smsActif;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ev")
    private boolean ev;
    @Basic(optional = false)
    @NotNull
    @Column(name = "penbase")
    private boolean penbase;
    @Size(max = 255)
    @Column(name = "codeReseau")
    private String codeReseau;
    @Size(max = 255)
    @Column(name = "adresseSuite")
    private String adresseSuite;
    @Size(max = 5)
    @Column(name = "codePostal")
    private String codePostal;
    @Column(name = "dateCreation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "dateMaj")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateMaj;
    @Column(name = "dateSuppressionLogique")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSuppressionLogique;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 15)
    @Column(name = "fax")
    private String fax;
    @Size(max = 255)
    @Column(name = "groupe")
    private String groupe;
    @Size(max = 255)
    @Column(name = "numeroEtVoie")
    private String numeroEtVoie;
    @Size(max = 255)
    @Column(name = "reglementation")
    private String reglementation;
    @Size(max = 14)
    @Column(name = "siret")
    private String siret;
    @Size(max = 255)
    @Column(name = "siteWeb")
    private String siteWeb;
    @Size(max = 15)
    @Column(name = "telephone")
    private String telephone;
    @Size(max = 255)
    @Column(name = "ville")
    private String ville;
    @Size(max = 255)
    @Column(name = "adressePrevoyance")
    private String adressePrevoyance;
    @Size(max = 255)
    @Column(name = "adresseRetraite")
    private String adresseRetraite;
    @Size(max = 255)
    @Column(name = "ape")
    private String ape;
    @Size(max = 255)
    @Column(name = "capital")
    private String capital;
    @Size(max = 255)
    @Column(name = "codePostalPrevoyance")
    private String codePostalPrevoyance;
    @Size(max = 255)
    @Column(name = "codePostalRetraite")
    private String codePostalRetraite;
    @Size(max = 255)
    @Column(name = "formeJuridique")
    private String formeJuridique;
    @Size(max = 255)
    @Column(name = "nomGerant")
    private String nomGerant;
    @Size(max = 255)
    @Column(name = "nomPrevoyance")
    private String nomPrevoyance;
    @Size(max = 255)
    @Column(name = "nomRetraite")
    private String nomRetraite;
    @Size(max = 255)
    @Column(name = "numRcs")
    private String numRcs;
    @Size(max = 255)
    @Column(name = "numUrssaf")
    private String numUrssaf;
    @Size(max = 255)
    @Column(name = "prenomGerant")
    private String prenomGerant;
    @Size(max = 255)
    @Column(name = "regionUrssaf")
    private String regionUrssaf;
    @Size(max = 255)
    @Column(name = "secteur")
    private String secteur;
    @Size(max = 255)
    @Column(name = "tvaIntra")
    private String tvaIntra;
    @Size(max = 255)
    @Column(name = "villePrevoyance")
    private String villePrevoyance;
    @Size(max = 255)
    @Column(name = "villeRcs")
    private String villeRcs;
    @Size(max = 255)
    @Column(name = "villeRetraite")
    private String villeRetraite;
    @Column(name = "dateAgrement")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAgrement;
    @Size(max = 255)
    @Column(name = "numeroAgrement")
    private String numeroAgrement;
    @Size(max = 255)
    @Column(name = "numeroDeclaration")
    private String numeroDeclaration;
    @Column(name = "civilite")
    private Integer civilite;
    @Size(max = 255)
    @Column(name = "adresseSante")
    private String adresseSante;
    @Size(max = 255)
    @Column(name = "codePostalSante")
    private String codePostalSante;
    @Size(max = 255)
    @Column(name = "nomSante")
    private String nomSante;
    @Size(max = 255)
    @Column(name = "villeSante")
    private String villeSante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nbLicences")
    private int nbLicences;
    @Basic(optional = false)
    @NotNull
    @Column(name = "afficherEnMinutes")
    private boolean afficherEnMinutes;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitude")
    private BigDecimal latitude;
    @Column(name = "longitude")
    private BigDecimal longitude;
    @Column(name = "dateDeclaration")
    @Temporal(TemporalType.DATE)
    private Date dateDeclaration;
    @Column(name = "zone")
    private Integer zone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telephonie")
    private boolean telephonie;
    @Size(max = 2)
    @Column(name = "codePaysTel")
    private String codePaysTel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "guestadomActif")
    private boolean guestadomActif;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoc", fetch = FetchType.LAZY)
    private Collection<FamilleCategorie> familleCategorieCollection;
    @JoinColumn(name = "idPays", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Nation idPays;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoc", fetch = FetchType.LAZY)
    private Collection<NivEtude> nivEtudeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoc", fetch = FetchType.LAZY)
    private Collection<TavCt> tavCtCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoc", fetch = FetchType.LAZY)
    private Collection<SousFamilleCategorie> sousFamilleCategorieCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoc", fetch = FetchType.LAZY)
    private Collection<Section> sectionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoc", fetch = FetchType.LAZY)
    private Collection<Experience> experienceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoc", fetch = FetchType.LAZY)
    private Collection<Pole> poleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoc", fetch = FetchType.LAZY)
    private Collection<Sc> scCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoc", fetch = FetchType.LAZY)
    private Collection<Candidatsalarie> candidatsalarieCollection;
    @OneToMany(mappedBy = "idSoc", fetch = FetchType.LAZY)
    private Collection<Client> clientCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoc", fetch = FetchType.LAZY)
    private Collection<Acompte> acompteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoc", fetch = FetchType.LAZY)
    private Collection<Grp1> grp1Collection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoc", fetch = FetchType.LAZY)
    private Collection<Grp2> grp2Collection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoc", fetch = FetchType.LAZY)
    private Collection<Situation> situationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoc", fetch = FetchType.LAZY)
    private Collection<Tva> tvaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoc", fetch = FetchType.LAZY)
    private Collection<ModeleGed> modeleGedCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoc", fetch = FetchType.LAZY)
    private Collection<FamillePrestation> famillePrestationCollection;
    @OneToMany(mappedBy = "idSoc", fetch = FetchType.LAZY)
    private Collection<Tct> tctCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoc", fetch = FetchType.LAZY)
    private Collection<Dept> deptCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoc", fetch = FetchType.LAZY)
    private Collection<Langue> langueCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoc", fetch = FetchType.LAZY)
    private Collection<Mdc> mdcCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoc", fetch = FetchType.LAZY)
    private Collection<SectGeo> sectGeoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoc", fetch = FetchType.LAZY)
    private Collection<Activite> activiteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoc", fetch = FetchType.LAZY)
    private Collection<At> atCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoc", fetch = FetchType.LAZY)
    private Collection<CategorieMateriel> categorieMaterielCollection;
    @OneToMany(mappedBy = "idSoc", fetch = FetchType.LAZY)
    private Collection<Prestations> prestationsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoc", fetch = FetchType.LAZY)
    private Collection<GroupeRemise> groupeRemiseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoc", fetch = FetchType.LAZY)
    private Collection<Lstintituleposte> lstintituleposteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoc", fetch = FetchType.LAZY)
    private Collection<Service> serviceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoc", fetch = FetchType.LAZY)
    private Collection<CompteComptable> compteComptableCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoc", fetch = FetchType.LAZY)
    private Collection<User> userCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoc", fetch = FetchType.LAZY)
    private Collection<CatDevis> catDevisCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoc", fetch = FetchType.LAZY)
    private Collection<Ts> tsCollection;

    public Soc() {
    }

    public Soc(Long id) {
        this.id = id;
    }

    public Soc(Long id, boolean supprime, boolean accepteEmails, boolean sap, boolean ged, boolean qualimobi, boolean mobiclean, boolean tournee, boolean saisieHoraire, boolean smsActif, boolean ev, boolean penbase, int nbLicences, boolean afficherEnMinutes, boolean telephonie, boolean guestadomActif) {
        this.id = id;
        this.supprime = supprime;
        this.accepteEmails = accepteEmails;
        this.sap = sap;
        this.ged = ged;
        this.qualimobi = qualimobi;
        this.mobiclean = mobiclean;
        this.tournee = tournee;
        this.saisieHoraire = saisieHoraire;
        this.smsActif = smsActif;
        this.ev = ev;
        this.penbase = penbase;
        this.nbLicences = nbLicences;
        this.afficherEnMinutes = afficherEnMinutes;
        this.telephonie = telephonie;
        this.guestadomActif = guestadomActif;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getSupprime() {
        return supprime;
    }

    public void setSupprime(boolean supprime) {
        this.supprime = supprime;
    }

    public Integer getTypeSociete() {
        return typeSociete;
    }

    public void setTypeSociete(Integer typeSociete) {
        this.typeSociete = typeSociete;
    }

    public boolean getAccepteEmails() {
        return accepteEmails;
    }

    public void setAccepteEmails(boolean accepteEmails) {
        this.accepteEmails = accepteEmails;
    }

    public String getEnseigne() {
        return enseigne;
    }

    public void setEnseigne(String enseigne) {
        this.enseigne = enseigne;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getLibelleCommercial() {
        return libelleCommercial;
    }

    public void setLibelleCommercial(String libelleCommercial) {
        this.libelleCommercial = libelleCommercial;
    }

    public String getCodeLiaison() {
        return codeLiaison;
    }

    public void setCodeLiaison(String codeLiaison) {
        this.codeLiaison = codeLiaison;
    }

    public boolean getSap() {
        return sap;
    }

    public void setSap(boolean sap) {
        this.sap = sap;
    }

    public boolean getGed() {
        return ged;
    }

    public void setGed(boolean ged) {
        this.ged = ged;
    }

    public boolean getQualimobi() {
        return qualimobi;
    }

    public void setQualimobi(boolean qualimobi) {
        this.qualimobi = qualimobi;
    }

    public boolean getMobiclean() {
        return mobiclean;
    }

    public void setMobiclean(boolean mobiclean) {
        this.mobiclean = mobiclean;
    }

    public boolean getTournee() {
        return tournee;
    }

    public void setTournee(boolean tournee) {
        this.tournee = tournee;
    }

    public boolean getSaisieHoraire() {
        return saisieHoraire;
    }

    public void setSaisieHoraire(boolean saisieHoraire) {
        this.saisieHoraire = saisieHoraire;
    }

    public boolean getSmsActif() {
        return smsActif;
    }

    public void setSmsActif(boolean smsActif) {
        this.smsActif = smsActif;
    }

    public boolean getEv() {
        return ev;
    }

    public void setEv(boolean ev) {
        this.ev = ev;
    }

    public boolean getPenbase() {
        return penbase;
    }

    public void setPenbase(boolean penbase) {
        this.penbase = penbase;
    }

    public String getCodeReseau() {
        return codeReseau;
    }

    public void setCodeReseau(String codeReseau) {
        this.codeReseau = codeReseau;
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

    public Date getDateSuppressionLogique() {
        return dateSuppressionLogique;
    }

    public void setDateSuppressionLogique(Date dateSuppressionLogique) {
        this.dateSuppressionLogique = dateSuppressionLogique;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public String getNumeroEtVoie() {
        return numeroEtVoie;
    }

    public void setNumeroEtVoie(String numeroEtVoie) {
        this.numeroEtVoie = numeroEtVoie;
    }

    public String getReglementation() {
        return reglementation;
    }

    public void setReglementation(String reglementation) {
        this.reglementation = reglementation;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
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

    public String getAdressePrevoyance() {
        return adressePrevoyance;
    }

    public void setAdressePrevoyance(String adressePrevoyance) {
        this.adressePrevoyance = adressePrevoyance;
    }

    public String getAdresseRetraite() {
        return adresseRetraite;
    }

    public void setAdresseRetraite(String adresseRetraite) {
        this.adresseRetraite = adresseRetraite;
    }

    public String getApe() {
        return ape;
    }

    public void setApe(String ape) {
        this.ape = ape;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCodePostalPrevoyance() {
        return codePostalPrevoyance;
    }

    public void setCodePostalPrevoyance(String codePostalPrevoyance) {
        this.codePostalPrevoyance = codePostalPrevoyance;
    }

    public String getCodePostalRetraite() {
        return codePostalRetraite;
    }

    public void setCodePostalRetraite(String codePostalRetraite) {
        this.codePostalRetraite = codePostalRetraite;
    }

    public String getFormeJuridique() {
        return formeJuridique;
    }

    public void setFormeJuridique(String formeJuridique) {
        this.formeJuridique = formeJuridique;
    }

    public String getNomGerant() {
        return nomGerant;
    }

    public void setNomGerant(String nomGerant) {
        this.nomGerant = nomGerant;
    }

    public String getNomPrevoyance() {
        return nomPrevoyance;
    }

    public void setNomPrevoyance(String nomPrevoyance) {
        this.nomPrevoyance = nomPrevoyance;
    }

    public String getNomRetraite() {
        return nomRetraite;
    }

    public void setNomRetraite(String nomRetraite) {
        this.nomRetraite = nomRetraite;
    }

    public String getNumRcs() {
        return numRcs;
    }

    public void setNumRcs(String numRcs) {
        this.numRcs = numRcs;
    }

    public String getNumUrssaf() {
        return numUrssaf;
    }

    public void setNumUrssaf(String numUrssaf) {
        this.numUrssaf = numUrssaf;
    }

    public String getPrenomGerant() {
        return prenomGerant;
    }

    public void setPrenomGerant(String prenomGerant) {
        this.prenomGerant = prenomGerant;
    }

    public String getRegionUrssaf() {
        return regionUrssaf;
    }

    public void setRegionUrssaf(String regionUrssaf) {
        this.regionUrssaf = regionUrssaf;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public String getTvaIntra() {
        return tvaIntra;
    }

    public void setTvaIntra(String tvaIntra) {
        this.tvaIntra = tvaIntra;
    }

    public String getVillePrevoyance() {
        return villePrevoyance;
    }

    public void setVillePrevoyance(String villePrevoyance) {
        this.villePrevoyance = villePrevoyance;
    }

    public String getVilleRcs() {
        return villeRcs;
    }

    public void setVilleRcs(String villeRcs) {
        this.villeRcs = villeRcs;
    }

    public String getVilleRetraite() {
        return villeRetraite;
    }

    public void setVilleRetraite(String villeRetraite) {
        this.villeRetraite = villeRetraite;
    }

    public Date getDateAgrement() {
        return dateAgrement;
    }

    public void setDateAgrement(Date dateAgrement) {
        this.dateAgrement = dateAgrement;
    }

    public String getNumeroAgrement() {
        return numeroAgrement;
    }

    public void setNumeroAgrement(String numeroAgrement) {
        this.numeroAgrement = numeroAgrement;
    }

    public String getNumeroDeclaration() {
        return numeroDeclaration;
    }

    public void setNumeroDeclaration(String numeroDeclaration) {
        this.numeroDeclaration = numeroDeclaration;
    }

    public Integer getCivilite() {
        return civilite;
    }

    public void setCivilite(Integer civilite) {
        this.civilite = civilite;
    }

    public String getAdresseSante() {
        return adresseSante;
    }

    public void setAdresseSante(String adresseSante) {
        this.adresseSante = adresseSante;
    }

    public String getCodePostalSante() {
        return codePostalSante;
    }

    public void setCodePostalSante(String codePostalSante) {
        this.codePostalSante = codePostalSante;
    }

    public String getNomSante() {
        return nomSante;
    }

    public void setNomSante(String nomSante) {
        this.nomSante = nomSante;
    }

    public String getVilleSante() {
        return villeSante;
    }

    public void setVilleSante(String villeSante) {
        this.villeSante = villeSante;
    }

    public int getNbLicences() {
        return nbLicences;
    }

    public void setNbLicences(int nbLicences) {
        this.nbLicences = nbLicences;
    }

    public boolean getAfficherEnMinutes() {
        return afficherEnMinutes;
    }

    public void setAfficherEnMinutes(boolean afficherEnMinutes) {
        this.afficherEnMinutes = afficherEnMinutes;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public Date getDateDeclaration() {
        return dateDeclaration;
    }

    public void setDateDeclaration(Date dateDeclaration) {
        this.dateDeclaration = dateDeclaration;
    }

    public Integer getZone() {
        return zone;
    }

    public void setZone(Integer zone) {
        this.zone = zone;
    }

    public boolean getTelephonie() {
        return telephonie;
    }

    public void setTelephonie(boolean telephonie) {
        this.telephonie = telephonie;
    }

    public String getCodePaysTel() {
        return codePaysTel;
    }

    public void setCodePaysTel(String codePaysTel) {
        this.codePaysTel = codePaysTel;
    }

    public boolean getGuestadomActif() {
        return guestadomActif;
    }

    public void setGuestadomActif(boolean guestadomActif) {
        this.guestadomActif = guestadomActif;
    }

    @XmlTransient
    public Collection<FamilleCategorie> getFamilleCategorieCollection() {
        return familleCategorieCollection;
    }

    public void setFamilleCategorieCollection(Collection<FamilleCategorie> familleCategorieCollection) {
        this.familleCategorieCollection = familleCategorieCollection;
    }

    public Nation getIdPays() {
        return idPays;
    }

    public void setIdPays(Nation idPays) {
        this.idPays = idPays;
    }

    @XmlTransient
    public Collection<NivEtude> getNivEtudeCollection() {
        return nivEtudeCollection;
    }

    public void setNivEtudeCollection(Collection<NivEtude> nivEtudeCollection) {
        this.nivEtudeCollection = nivEtudeCollection;
    }

    @XmlTransient
    public Collection<TavCt> getTavCtCollection() {
        return tavCtCollection;
    }

    public void setTavCtCollection(Collection<TavCt> tavCtCollection) {
        this.tavCtCollection = tavCtCollection;
    }

    @XmlTransient
    public Collection<SousFamilleCategorie> getSousFamilleCategorieCollection() {
        return sousFamilleCategorieCollection;
    }

    public void setSousFamilleCategorieCollection(Collection<SousFamilleCategorie> sousFamilleCategorieCollection) {
        this.sousFamilleCategorieCollection = sousFamilleCategorieCollection;
    }

    @XmlTransient
    public Collection<Section> getSectionCollection() {
        return sectionCollection;
    }

    public void setSectionCollection(Collection<Section> sectionCollection) {
        this.sectionCollection = sectionCollection;
    }

    @XmlTransient
    public Collection<Experience> getExperienceCollection() {
        return experienceCollection;
    }

    public void setExperienceCollection(Collection<Experience> experienceCollection) {
        this.experienceCollection = experienceCollection;
    }

    @XmlTransient
    public Collection<Pole> getPoleCollection() {
        return poleCollection;
    }

    public void setPoleCollection(Collection<Pole> poleCollection) {
        this.poleCollection = poleCollection;
    }

    @XmlTransient
    public Collection<Sc> getScCollection() {
        return scCollection;
    }

    public void setScCollection(Collection<Sc> scCollection) {
        this.scCollection = scCollection;
    }

    @XmlTransient
    public Collection<Candidatsalarie> getCandidatsalarieCollection() {
        return candidatsalarieCollection;
    }

    public void setCandidatsalarieCollection(Collection<Candidatsalarie> candidatsalarieCollection) {
        this.candidatsalarieCollection = candidatsalarieCollection;
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

    @XmlTransient
    public Collection<Grp1> getGrp1Collection() {
        return grp1Collection;
    }

    public void setGrp1Collection(Collection<Grp1> grp1Collection) {
        this.grp1Collection = grp1Collection;
    }

    @XmlTransient
    public Collection<Grp2> getGrp2Collection() {
        return grp2Collection;
    }

    public void setGrp2Collection(Collection<Grp2> grp2Collection) {
        this.grp2Collection = grp2Collection;
    }

    @XmlTransient
    public Collection<Situation> getSituationCollection() {
        return situationCollection;
    }

    public void setSituationCollection(Collection<Situation> situationCollection) {
        this.situationCollection = situationCollection;
    }

    @XmlTransient
    public Collection<Tva> getTvaCollection() {
        return tvaCollection;
    }

    public void setTvaCollection(Collection<Tva> tvaCollection) {
        this.tvaCollection = tvaCollection;
    }

    @XmlTransient
    public Collection<ModeleGed> getModeleGedCollection() {
        return modeleGedCollection;
    }

    public void setModeleGedCollection(Collection<ModeleGed> modeleGedCollection) {
        this.modeleGedCollection = modeleGedCollection;
    }

    @XmlTransient
    public Collection<FamillePrestation> getFamillePrestationCollection() {
        return famillePrestationCollection;
    }

    public void setFamillePrestationCollection(Collection<FamillePrestation> famillePrestationCollection) {
        this.famillePrestationCollection = famillePrestationCollection;
    }

    @XmlTransient
    public Collection<Tct> getTctCollection() {
        return tctCollection;
    }

    public void setTctCollection(Collection<Tct> tctCollection) {
        this.tctCollection = tctCollection;
    }

    @XmlTransient
    public Collection<Dept> getDeptCollection() {
        return deptCollection;
    }

    public void setDeptCollection(Collection<Dept> deptCollection) {
        this.deptCollection = deptCollection;
    }

    @XmlTransient
    public Collection<Langue> getLangueCollection() {
        return langueCollection;
    }

    public void setLangueCollection(Collection<Langue> langueCollection) {
        this.langueCollection = langueCollection;
    }

    @XmlTransient
    public Collection<Mdc> getMdcCollection() {
        return mdcCollection;
    }

    public void setMdcCollection(Collection<Mdc> mdcCollection) {
        this.mdcCollection = mdcCollection;
    }

    @XmlTransient
    public Collection<SectGeo> getSectGeoCollection() {
        return sectGeoCollection;
    }

    public void setSectGeoCollection(Collection<SectGeo> sectGeoCollection) {
        this.sectGeoCollection = sectGeoCollection;
    }

    @XmlTransient
    public Collection<Activite> getActiviteCollection() {
        return activiteCollection;
    }

    public void setActiviteCollection(Collection<Activite> activiteCollection) {
        this.activiteCollection = activiteCollection;
    }

    @XmlTransient
    public Collection<At> getAtCollection() {
        return atCollection;
    }

    public void setAtCollection(Collection<At> atCollection) {
        this.atCollection = atCollection;
    }

    @XmlTransient
    public Collection<CategorieMateriel> getCategorieMaterielCollection() {
        return categorieMaterielCollection;
    }

    public void setCategorieMaterielCollection(Collection<CategorieMateriel> categorieMaterielCollection) {
        this.categorieMaterielCollection = categorieMaterielCollection;
    }

    @XmlTransient
    public Collection<Prestations> getPrestationsCollection() {
        return prestationsCollection;
    }

    public void setPrestationsCollection(Collection<Prestations> prestationsCollection) {
        this.prestationsCollection = prestationsCollection;
    }

    @XmlTransient
    public Collection<GroupeRemise> getGroupeRemiseCollection() {
        return groupeRemiseCollection;
    }

    public void setGroupeRemiseCollection(Collection<GroupeRemise> groupeRemiseCollection) {
        this.groupeRemiseCollection = groupeRemiseCollection;
    }

    @XmlTransient
    public Collection<Lstintituleposte> getLstintituleposteCollection() {
        return lstintituleposteCollection;
    }

    public void setLstintituleposteCollection(Collection<Lstintituleposte> lstintituleposteCollection) {
        this.lstintituleposteCollection = lstintituleposteCollection;
    }

    @XmlTransient
    public Collection<Service> getServiceCollection() {
        return serviceCollection;
    }

    public void setServiceCollection(Collection<Service> serviceCollection) {
        this.serviceCollection = serviceCollection;
    }

    @XmlTransient
    public Collection<CompteComptable> getCompteComptableCollection() {
        return compteComptableCollection;
    }

    public void setCompteComptableCollection(Collection<CompteComptable> compteComptableCollection) {
        this.compteComptableCollection = compteComptableCollection;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @XmlTransient
    public Collection<CatDevis> getCatDevisCollection() {
        return catDevisCollection;
    }

    public void setCatDevisCollection(Collection<CatDevis> catDevisCollection) {
        this.catDevisCollection = catDevisCollection;
    }

    @XmlTransient
    public Collection<Ts> getTsCollection() {
        return tsCollection;
    }

    public void setTsCollection(Collection<Ts> tsCollection) {
        this.tsCollection = tsCollection;
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
        if (!(object instanceof Soc)) {
            return false;
        }
        Soc other = (Soc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.Soc[ id=" + id + " ]";
    }
    
}
