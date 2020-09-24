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
import javax.persistence.JoinTable;
import javax.persistence.Lob;
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
@Table(name = "candidatsalarie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Candidatsalarie.findAll", query = "SELECT c FROM Candidatsalarie c"),
    @NamedQuery(name = "Candidatsalarie.findById", query = "SELECT c FROM Candidatsalarie c WHERE c.id = :id"),
    @NamedQuery(name = "Candidatsalarie.findByCivilite", query = "SELECT c FROM Candidatsalarie c WHERE c.civilite = :civilite"),
    @NamedQuery(name = "Candidatsalarie.findByNom", query = "SELECT c FROM Candidatsalarie c WHERE c.nom = :nom"),
    @NamedQuery(name = "Candidatsalarie.findByPrenom", query = "SELECT c FROM Candidatsalarie c WHERE c.prenom = :prenom"),
    @NamedQuery(name = "Candidatsalarie.findBySalarie", query = "SELECT c FROM Candidatsalarie c WHERE c.salarie = :salarie"),
    @NamedQuery(name = "Candidatsalarie.findByActif", query = "SELECT c FROM Candidatsalarie c WHERE c.actif = :actif"),
    @NamedQuery(name = "Candidatsalarie.findByDateFin", query = "SELECT c FROM Candidatsalarie c WHERE c.dateFin = :dateFin"),
    @NamedQuery(name = "Candidatsalarie.findByAccepteEmails", query = "SELECT c FROM Candidatsalarie c WHERE c.accepteEmails = :accepteEmails"),
    @NamedQuery(name = "Candidatsalarie.findByAdresseSuite", query = "SELECT c FROM Candidatsalarie c WHERE c.adresseSuite = :adresseSuite"),
    @NamedQuery(name = "Candidatsalarie.findByAutreEmployeur", query = "SELECT c FROM Candidatsalarie c WHERE c.autreEmployeur = :autreEmployeur"),
    @NamedQuery(name = "Candidatsalarie.findByBic", query = "SELECT c FROM Candidatsalarie c WHERE c.bic = :bic"),
    @NamedQuery(name = "Candidatsalarie.findByCasierVierge", query = "SELECT c FROM Candidatsalarie c WHERE c.casierVierge = :casierVierge"),
    @NamedQuery(name = "Candidatsalarie.findByCodePostal", query = "SELECT c FROM Candidatsalarie c WHERE c.codePostal = :codePostal"),
    @NamedQuery(name = "Candidatsalarie.findByCoefficient", query = "SELECT c FROM Candidatsalarie c WHERE c.coefficient = :coefficient"),
    @NamedQuery(name = "Candidatsalarie.findByDateCreation", query = "SELECT c FROM Candidatsalarie c WHERE c.dateCreation = :dateCreation"),
    @NamedQuery(name = "Candidatsalarie.findByDateDisponibilite", query = "SELECT c FROM Candidatsalarie c WHERE c.dateDisponibilite = :dateDisponibilite"),
    @NamedQuery(name = "Candidatsalarie.findByDateEntree", query = "SELECT c FROM Candidatsalarie c WHERE c.dateEntree = :dateEntree"),
    @NamedQuery(name = "Candidatsalarie.findByDateFinCarteIdentite", query = "SELECT c FROM Candidatsalarie c WHERE c.dateFinCarteIdentite = :dateFinCarteIdentite"),
    @NamedQuery(name = "Candidatsalarie.findByDateInscription", query = "SELECT c FROM Candidatsalarie c WHERE c.dateInscription = :dateInscription"),
    @NamedQuery(name = "Candidatsalarie.findByDateMaj", query = "SELECT c FROM Candidatsalarie c WHERE c.dateMaj = :dateMaj"),
    @NamedQuery(name = "Candidatsalarie.findByDateNaissance", query = "SELECT c FROM Candidatsalarie c WHERE c.dateNaissance = :dateNaissance"),
    @NamedQuery(name = "Candidatsalarie.findByDateNaissanceConjoint", query = "SELECT c FROM Candidatsalarie c WHERE c.dateNaissanceConjoint = :dateNaissanceConjoint"),
    @NamedQuery(name = "Candidatsalarie.findByDatePermis", query = "SELECT c FROM Candidatsalarie c WHERE c.datePermis = :datePermis"),
    @NamedQuery(name = "Candidatsalarie.findByDiplome", query = "SELECT c FROM Candidatsalarie c WHERE c.diplome = :diplome"),
    @NamedQuery(name = "Candidatsalarie.findByDispoMatin", query = "SELECT c FROM Candidatsalarie c WHERE c.dispoMatin = :dispoMatin"),
    @NamedQuery(name = "Candidatsalarie.findByDispoSoir", query = "SELECT c FROM Candidatsalarie c WHERE c.dispoSoir = :dispoSoir"),
    @NamedQuery(name = "Candidatsalarie.findByDue", query = "SELECT c FROM Candidatsalarie c WHERE c.due = :due"),
    @NamedQuery(name = "Candidatsalarie.findByEmail", query = "SELECT c FROM Candidatsalarie c WHERE c.email = :email"),
    @NamedQuery(name = "Candidatsalarie.findByEmailProfessionnel", query = "SELECT c FROM Candidatsalarie c WHERE c.emailProfessionnel = :emailProfessionnel"),
    @NamedQuery(name = "Candidatsalarie.findByEnfants", query = "SELECT c FROM Candidatsalarie c WHERE c.enfants = :enfants"),
    @NamedQuery(name = "Candidatsalarie.findByHeureDebutMatin", query = "SELECT c FROM Candidatsalarie c WHERE c.heureDebutMatin = :heureDebutMatin"),
    @NamedQuery(name = "Candidatsalarie.findByHeureDebutSoir", query = "SELECT c FROM Candidatsalarie c WHERE c.heureDebutSoir = :heureDebutSoir"),
    @NamedQuery(name = "Candidatsalarie.findByHeureFinMatin", query = "SELECT c FROM Candidatsalarie c WHERE c.heureFinMatin = :heureFinMatin"),
    @NamedQuery(name = "Candidatsalarie.findByHeureFinSoir", query = "SELECT c FROM Candidatsalarie c WHERE c.heureFinSoir = :heureFinSoir"),
    @NamedQuery(name = "Candidatsalarie.findByIban", query = "SELECT c FROM Candidatsalarie c WHERE c.iban = :iban"),
    @NamedQuery(name = "Candidatsalarie.findByJoursConges", query = "SELECT c FROM Candidatsalarie c WHERE c.joursConges = :joursConges"),
    @NamedQuery(name = "Candidatsalarie.findByLieuNaissance", query = "SELECT c FROM Candidatsalarie c WHERE c.lieuNaissance = :lieuNaissance"),
    @NamedQuery(name = "Candidatsalarie.findByMobile", query = "SELECT c FROM Candidatsalarie c WHERE c.mobile = :mobile"),
    @NamedQuery(name = "Candidatsalarie.findByMobileProfessionnel", query = "SELECT c FROM Candidatsalarie c WHERE c.mobileProfessionnel = :mobileProfessionnel"),
    @NamedQuery(name = "Candidatsalarie.findByModeReglement", query = "SELECT c FROM Candidatsalarie c WHERE c.modeReglement = :modeReglement"),
    @NamedQuery(name = "Candidatsalarie.findByNomConjoint", query = "SELECT c FROM Candidatsalarie c WHERE c.nomConjoint = :nomConjoint"),
    @NamedQuery(name = "Candidatsalarie.findByNomJeuneFille", query = "SELECT c FROM Candidatsalarie c WHERE c.nomJeuneFille = :nomJeuneFille"),
    @NamedQuery(name = "Candidatsalarie.findByNuitUniquement", query = "SELECT c FROM Candidatsalarie c WHERE c.nuitUniquement = :nuitUniquement"),
    @NamedQuery(name = "Candidatsalarie.findByNumPieceIdentite", query = "SELECT c FROM Candidatsalarie c WHERE c.numPieceIdentite = :numPieceIdentite"),
    @NamedQuery(name = "Candidatsalarie.findByNumeroEtVoie", query = "SELECT c FROM Candidatsalarie c WHERE c.numeroEtVoie = :numeroEtVoie"),
    @NamedQuery(name = "Candidatsalarie.findByNumeroMatricule", query = "SELECT c FROM Candidatsalarie c WHERE c.numeroMatricule = :numeroMatricule"),
    @NamedQuery(name = "Candidatsalarie.findByNumeroSecu", query = "SELECT c FROM Candidatsalarie c WHERE c.numeroSecu = :numeroSecu"),
    @NamedQuery(name = "Candidatsalarie.findByPermis", query = "SELECT c FROM Candidatsalarie c WHERE c.permis = :permis"),
    @NamedQuery(name = "Candidatsalarie.findByPosition", query = "SELECT c FROM Candidatsalarie c WHERE c.position = :position"),
    @NamedQuery(name = "Candidatsalarie.findByPrenomConjoint", query = "SELECT c FROM Candidatsalarie c WHERE c.prenomConjoint = :prenomConjoint"),
    @NamedQuery(name = "Candidatsalarie.findBySituation", query = "SELECT c FROM Candidatsalarie c WHERE c.situation = :situation"),
    @NamedQuery(name = "Candidatsalarie.findBySituationFamiliale", query = "SELECT c FROM Candidatsalarie c WHERE c.situationFamiliale = :situationFamiliale"),
    @NamedQuery(name = "Candidatsalarie.findByStatutCandidat", query = "SELECT c FROM Candidatsalarie c WHERE c.statutCandidat = :statutCandidat"),
    @NamedQuery(name = "Candidatsalarie.findBySupprime", query = "SELECT c FROM Candidatsalarie c WHERE c.supprime = :supprime"),
    @NamedQuery(name = "Candidatsalarie.findByTelephone", query = "SELECT c FROM Candidatsalarie c WHERE c.telephone = :telephone"),
    @NamedQuery(name = "Candidatsalarie.findByTypeJustifIdentite", query = "SELECT c FROM Candidatsalarie c WHERE c.typeJustifIdentite = :typeJustifIdentite"),
    @NamedQuery(name = "Candidatsalarie.findByValidationCandidat", query = "SELECT c FROM Candidatsalarie c WHERE c.validationCandidat = :validationCandidat"),
    @NamedQuery(name = "Candidatsalarie.findByVehicule", query = "SELECT c FROM Candidatsalarie c WHERE c.vehicule = :vehicule"),
    @NamedQuery(name = "Candidatsalarie.findByVille", query = "SELECT c FROM Candidatsalarie c WHERE c.ville = :ville"),
    @NamedQuery(name = "Candidatsalarie.findByDateEmission", query = "SELECT c FROM Candidatsalarie c WHERE c.dateEmission = :dateEmission"),
    @NamedQuery(name = "Candidatsalarie.findByDateAutorisation", query = "SELECT c FROM Candidatsalarie c WHERE c.dateAutorisation = :dateAutorisation"),
    @NamedQuery(name = "Candidatsalarie.findByNumeroAutorisation", query = "SELECT c FROM Candidatsalarie c WHERE c.numeroAutorisation = :numeroAutorisation"),
    @NamedQuery(name = "Candidatsalarie.findByAbbreviation", query = "SELECT c FROM Candidatsalarie c WHERE c.abbreviation = :abbreviation"),
    @NamedQuery(name = "Candidatsalarie.findByFond", query = "SELECT c FROM Candidatsalarie c WHERE c.fond = :fond"),
    @NamedQuery(name = "Candidatsalarie.findByTexte", query = "SELECT c FROM Candidatsalarie c WHERE c.texte = :texte"),
    @NamedQuery(name = "Candidatsalarie.findByInspecteur", query = "SELECT c FROM Candidatsalarie c WHERE c.inspecteur = :inspecteur"),
    @NamedQuery(name = "Candidatsalarie.findByResponsable", query = "SELECT c FROM Candidatsalarie c WHERE c.responsable = :responsable"),
    @NamedQuery(name = "Candidatsalarie.findByDateCompSante", query = "SELECT c FROM Candidatsalarie c WHERE c.dateCompSante = :dateCompSante"),
    @NamedQuery(name = "Candidatsalarie.findByMotifRefusCompSante", query = "SELECT c FROM Candidatsalarie c WHERE c.motifRefusCompSante = :motifRefusCompSante"),
    @NamedQuery(name = "Candidatsalarie.findByRefusCompSante", query = "SELECT c FROM Candidatsalarie c WHERE c.refusCompSante = :refusCompSante"),
    @NamedQuery(name = "Candidatsalarie.findByQuestionnaire", query = "SELECT c FROM Candidatsalarie c WHERE c.questionnaire = :questionnaire"),
    @NamedQuery(name = "Candidatsalarie.findByStatutValidation", query = "SELECT c FROM Candidatsalarie c WHERE c.statutValidation = :statutValidation"),
    @NamedQuery(name = "Candidatsalarie.findByDateRdv", query = "SELECT c FROM Candidatsalarie c WHERE c.dateRdv = :dateRdv"),
    @NamedQuery(name = "Candidatsalarie.findByDepartementNaissance", query = "SELECT c FROM Candidatsalarie c WHERE c.departementNaissance = :departementNaissance"),
    @NamedQuery(name = "Candidatsalarie.findByNumPermis", query = "SELECT c FROM Candidatsalarie c WHERE c.numPermis = :numPermis"),
    @NamedQuery(name = "Candidatsalarie.findByNumAuto", query = "SELECT c FROM Candidatsalarie c WHERE c.numAuto = :numAuto"),
    @NamedQuery(name = "Candidatsalarie.findByDateEmployeur", query = "SELECT c FROM Candidatsalarie c WHERE c.dateEmployeur = :dateEmployeur"),
    @NamedQuery(name = "Candidatsalarie.findByDateFinPermis", query = "SELECT c FROM Candidatsalarie c WHERE c.dateFinPermis = :dateFinPermis"),
    @NamedQuery(name = "Candidatsalarie.findByDateProchaineVisite", query = "SELECT c FROM Candidatsalarie c WHERE c.dateProchaineVisite = :dateProchaineVisite"),
    @NamedQuery(name = "Candidatsalarie.findByDateSuppression", query = "SELECT c FROM Candidatsalarie c WHERE c.dateSuppression = :dateSuppression"),
    @NamedQuery(name = "Candidatsalarie.findByCommercial", query = "SELECT c FROM Candidatsalarie c WHERE c.commercial = :commercial"),
    @NamedQuery(name = "Candidatsalarie.findByPushed", query = "SELECT c FROM Candidatsalarie c WHERE c.pushed = :pushed"),
    @NamedQuery(name = "Candidatsalarie.findByLatitudeAdresse", query = "SELECT c FROM Candidatsalarie c WHERE c.latitudeAdresse = :latitudeAdresse"),
    @NamedQuery(name = "Candidatsalarie.findByLongitudeAdresse", query = "SELECT c FROM Candidatsalarie c WHERE c.longitudeAdresse = :longitudeAdresse"),
    @NamedQuery(name = "Candidatsalarie.findByLoginPenbase", query = "SELECT c FROM Candidatsalarie c WHERE c.loginPenbase = :loginPenbase"),
    @NamedQuery(name = "Candidatsalarie.findByDateInscriptionAlpha", query = "SELECT c FROM Candidatsalarie c WHERE c.dateInscriptionAlpha = :dateInscriptionAlpha"),
    @NamedQuery(name = "Candidatsalarie.findByNumeroInscriAlpha", query = "SELECT c FROM Candidatsalarie c WHERE c.numeroInscriAlpha = :numeroInscriAlpha"),
    @NamedQuery(name = "Candidatsalarie.findByDateFinAssurance", query = "SELECT c FROM Candidatsalarie c WHERE c.dateFinAssurance = :dateFinAssurance"),
    @NamedQuery(name = "Candidatsalarie.findByDateFinCt", query = "SELECT c FROM Candidatsalarie c WHERE c.dateFinCt = :dateFinCt"),
    @NamedQuery(name = "Candidatsalarie.findByEmailConjoint", query = "SELECT c FROM Candidatsalarie c WHERE c.emailConjoint = :emailConjoint"),
    @NamedQuery(name = "Candidatsalarie.findByTelephoneConjoint", query = "SELECT c FROM Candidatsalarie c WHERE c.telephoneConjoint = :telephoneConjoint"),
    @NamedQuery(name = "Candidatsalarie.findByModeTransport", query = "SELECT c FROM Candidatsalarie c WHERE c.modeTransport = :modeTransport"),
    @NamedQuery(name = "Candidatsalarie.findByNonSilae", query = "SELECT c FROM Candidatsalarie c WHERE c.nonSilae = :nonSilae"),
    @NamedQuery(name = "Candidatsalarie.findByModulation", query = "SELECT c FROM Candidatsalarie c WHERE c.modulation = :modulation"),
    @NamedQuery(name = "Candidatsalarie.findByNonMobisap", query = "SELECT c FROM Candidatsalarie c WHERE c.nonMobisap = :nonMobisap"),
    @NamedQuery(name = "Candidatsalarie.findByAccepteEmail", query = "SELECT c FROM Candidatsalarie c WHERE c.accepteEmail = :accepteEmail"),
    @NamedQuery(name = "Candidatsalarie.findByAnnexe7", query = "SELECT c FROM Candidatsalarie c WHERE c.annexe7 = :annexe7"),
    @NamedQuery(name = "Candidatsalarie.findByChefEquipe", query = "SELECT c FROM Candidatsalarie c WHERE c.chefEquipe = :chefEquipe"),
    @NamedQuery(name = "Candidatsalarie.findByDateDerniereVisite", query = "SELECT c FROM Candidatsalarie c WHERE c.dateDerniereVisite = :dateDerniereVisite"),
    @NamedQuery(name = "Candidatsalarie.findByHandicape", query = "SELECT c FROM Candidatsalarie c WHERE c.handicape = :handicape"),
    @NamedQuery(name = "Candidatsalarie.findByModeValidationHeures", query = "SELECT c FROM Candidatsalarie c WHERE c.modeValidationHeures = :modeValidationHeures"),
    @NamedQuery(name = "Candidatsalarie.findByTravailleurNuit", query = "SELECT c FROM Candidatsalarie c WHERE c.travailleurNuit = :travailleurNuit"),
    @NamedQuery(name = "Candidatsalarie.findByTravailleurOccasionnel", query = "SELECT c FROM Candidatsalarie c WHERE c.travailleurOccasionnel = :travailleurOccasionnel"),
    @NamedQuery(name = "Candidatsalarie.findByImei", query = "SELECT c FROM Candidatsalarie c WHERE c.imei = :imei"),
    @NamedQuery(name = "Candidatsalarie.findByPushed2", query = "SELECT c FROM Candidatsalarie c WHERE c.pushed2 = :pushed2"),
    @NamedQuery(name = "Candidatsalarie.findByLieuJustifIdentite", query = "SELECT c FROM Candidatsalarie c WHERE c.lieuJustifIdentite = :lieuJustifIdentite"),
    @NamedQuery(name = "Candidatsalarie.findByAah", query = "SELECT c FROM Candidatsalarie c WHERE c.aah = :aah"),
    @NamedQuery(name = "Candidatsalarie.findByAutreCategoriePension", query = "SELECT c FROM Candidatsalarie c WHERE c.autreCategoriePension = :autreCategoriePension"),
    @NamedQuery(name = "Candidatsalarie.findByCarteInvalidite", query = "SELECT c FROM Candidatsalarie c WHERE c.carteInvalidite = :carteInvalidite"),
    @NamedQuery(name = "Candidatsalarie.findByCategoriePension", query = "SELECT c FROM Candidatsalarie c WHERE c.categoriePension = :categoriePension"),
    @NamedQuery(name = "Candidatsalarie.findByDateControleJustif", query = "SELECT c FROM Candidatsalarie c WHERE c.dateControleJustif = :dateControleJustif"),
    @NamedQuery(name = "Candidatsalarie.findByDateDebutCarteHandicap", query = "SELECT c FROM Candidatsalarie c WHERE c.dateDebutCarteHandicap = :dateDebutCarteHandicap"),
    @NamedQuery(name = "Candidatsalarie.findByDateDebutIncapacitePermanente", query = "SELECT c FROM Candidatsalarie c WHERE c.dateDebutIncapacitePermanente = :dateDebutIncapacitePermanente"),
    @NamedQuery(name = "Candidatsalarie.findByDateDebutPensionInvalidite", query = "SELECT c FROM Candidatsalarie c WHERE c.dateDebutPensionInvalidite = :dateDebutPensionInvalidite"),
    @NamedQuery(name = "Candidatsalarie.findByDateDepotRenouvellementHandicap", query = "SELECT c FROM Candidatsalarie c WHERE c.dateDepotRenouvellementHandicap = :dateDepotRenouvellementHandicap"),
    @NamedQuery(name = "Candidatsalarie.findByDateFinCarteHandicap", query = "SELECT c FROM Candidatsalarie c WHERE c.dateFinCarteHandicap = :dateFinCarteHandicap"),
    @NamedQuery(name = "Candidatsalarie.findByDateSalarieProtege", query = "SELECT c FROM Candidatsalarie c WHERE c.dateSalarieProtege = :dateSalarieProtege"),
    @NamedQuery(name = "Candidatsalarie.findByRqth", query = "SELECT c FROM Candidatsalarie c WHERE c.rqth = :rqth"),
    @NamedQuery(name = "Candidatsalarie.findBySalarieProtege", query = "SELECT c FROM Candidatsalarie c WHERE c.salarieProtege = :salarieProtege"),
    @NamedQuery(name = "Candidatsalarie.findByTauxIncapacite", query = "SELECT c FROM Candidatsalarie c WHERE c.tauxIncapacite = :tauxIncapacite"),
    @NamedQuery(name = "Candidatsalarie.findByTauxIpp", query = "SELECT c FROM Candidatsalarie c WHERE c.tauxIpp = :tauxIpp"),
    @NamedQuery(name = "Candidatsalarie.findByTypeIncapacite", query = "SELECT c FROM Candidatsalarie c WHERE c.typeIncapacite = :typeIncapacite")})
public class Candidatsalarie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "civilite")
    private Integer civilite;
    @Size(max = 255)
    @Column(name = "nom")
    private String nom;
    @Size(max = 255)
    @Column(name = "prenom")
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salarie")
    private boolean salarie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "actif")
    private boolean actif;
    @Column(name = "dateFin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "accepteEmails")
    private boolean accepteEmails;
    @Size(max = 255)
    @Column(name = "adresseSuite")
    private String adresseSuite;
    @Basic(optional = false)
    @NotNull
    @Column(name = "autreEmployeur")
    private boolean autreEmployeur;
    @Size(max = 255)
    @Column(name = "bic")
    private String bic;
    @Basic(optional = false)
    @NotNull
    @Column(name = "casierVierge")
    private boolean casierVierge;
    @Size(max = 7)
    @Column(name = "codePostal")
    private String codePostal;
    @Size(max = 255)
    @Column(name = "coefficient")
    private String coefficient;
    @Column(name = "dateCreation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "dateDisponibilite")
    @Temporal(TemporalType.DATE)
    private Date dateDisponibilite;
    @Column(name = "dateEntree")
    @Temporal(TemporalType.DATE)
    private Date dateEntree;
    @Column(name = "dateFinCarteIdentite")
    @Temporal(TemporalType.DATE)
    private Date dateFinCarteIdentite;
    @Column(name = "dateInscription")
    @Temporal(TemporalType.DATE)
    private Date dateInscription;
    @Column(name = "dateMaj")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateMaj;
    @Column(name = "dateNaissance")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Column(name = "dateNaissanceConjoint")
    @Temporal(TemporalType.DATE)
    private Date dateNaissanceConjoint;
    @Column(name = "datePermis")
    @Temporal(TemporalType.DATE)
    private Date datePermis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diplome")
    private boolean diplome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dispoMatin")
    private boolean dispoMatin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dispoSoir")
    private boolean dispoSoir;
    @Size(max = 255)
    @Column(name = "due")
    private String due;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "emailProfessionnel")
    private String emailProfessionnel;
    @Column(name = "enfants")
    private Integer enfants;
    @Size(max = 5)
    @Column(name = "heureDebutMatin")
    private String heureDebutMatin;
    @Size(max = 5)
    @Column(name = "heureDebutSoir")
    private String heureDebutSoir;
    @Size(max = 5)
    @Column(name = "heureFinMatin")
    private String heureFinMatin;
    @Size(max = 5)
    @Column(name = "heureFinSoir")
    private String heureFinSoir;
    @Size(max = 255)
    @Column(name = "iban")
    private String iban;
    @Column(name = "joursConges")
    private Integer joursConges;
    @Size(max = 255)
    @Column(name = "lieuNaissance")
    private String lieuNaissance;
    @Size(max = 30)
    @Column(name = "mobile")
    private String mobile;
    @Size(max = 30)
    @Column(name = "mobileProfessionnel")
    private String mobileProfessionnel;
    @Column(name = "modeReglement")
    private Integer modeReglement;
    @Size(max = 255)
    @Column(name = "nomConjoint")
    private String nomConjoint;
    @Size(max = 255)
    @Column(name = "nomJeuneFille")
    private String nomJeuneFille;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nuitUniquement")
    private boolean nuitUniquement;
    @Size(max = 255)
    @Column(name = "numPieceIdentite")
    private String numPieceIdentite;
    @Size(max = 255)
    @Column(name = "numeroEtVoie")
    private String numeroEtVoie;
    @Size(max = 255)
    @Column(name = "numeroMatricule")
    private String numeroMatricule;
    @Size(max = 16)
    @Column(name = "numeroSecu")
    private String numeroSecu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "permis")
    private boolean permis;
    @Size(max = 255)
    @Column(name = "position")
    private String position;
    @Size(max = 255)
    @Column(name = "prenomConjoint")
    private String prenomConjoint;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "qualitePersonnelles")
    private String qualitePersonnelles;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "qualiteProfessionnelles")
    private String qualiteProfessionnelles;
    @Column(name = "situation")
    private Integer situation;
    @Column(name = "situationFamiliale")
    private Integer situationFamiliale;
    @Column(name = "statutCandidat")
    private Integer statutCandidat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "supprime")
    private boolean supprime;
    @Size(max = 30)
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "typeJustifIdentite")
    private Integer typeJustifIdentite;
    @Column(name = "validationCandidat")
    private Short validationCandidat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vehicule")
    private boolean vehicule;
    @Size(max = 255)
    @Column(name = "ville")
    private String ville;
    @Column(name = "dateEmission")
    @Temporal(TemporalType.DATE)
    private Date dateEmission;
    @Column(name = "dateAutorisation")
    @Temporal(TemporalType.DATE)
    private Date dateAutorisation;
    @Size(max = 255)
    @Column(name = "numeroAutorisation")
    private String numeroAutorisation;
    @Size(max = 255)
    @Column(name = "abbreviation")
    private String abbreviation;
    @Size(max = 7)
    @Column(name = "fond")
    private String fond;
    @Size(max = 7)
    @Column(name = "texte")
    private String texte;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "commentaire")
    private String commentaire;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inspecteur")
    private boolean inspecteur;
    @Basic(optional = false)
    @NotNull
    @Column(name = "responsable")
    private boolean responsable;
    @Column(name = "dateCompSante")
    @Temporal(TemporalType.DATE)
    private Date dateCompSante;
    @Column(name = "motifRefusCompSante")
    private Integer motifRefusCompSante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "refusCompSante")
    private boolean refusCompSante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "questionnaire")
    private boolean questionnaire;
    @Column(name = "statutValidation")
    private Integer statutValidation;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "compteRendu")
    private String compteRendu;
    @Column(name = "dateRdv")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRdv;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "qualitesPerso")
    private String qualitesPerso;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "qualitesPro")
    private String qualitesPro;
    @Size(max = 255)
    @Column(name = "departementNaissance")
    private String departementNaissance;
    @Size(max = 255)
    @Column(name = "numPermis")
    private String numPermis;
    @Column(name = "numAuto")
    private BigInteger numAuto;
    @Column(name = "dateEmployeur")
    @Temporal(TemporalType.DATE)
    private Date dateEmployeur;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "noteInterne")
    private String noteInterne;
    @Column(name = "dateFinPermis")
    @Temporal(TemporalType.DATE)
    private Date dateFinPermis;
    @Column(name = "dateProchaineVisite")
    @Temporal(TemporalType.DATE)
    private Date dateProchaineVisite;
    @Column(name = "dateSuppression")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSuppression;
    @Basic(optional = false)
    @NotNull
    @Column(name = "commercial")
    private boolean commercial;
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
    @Size(max = 255)
    @Column(name = "loginPenbase")
    private String loginPenbase;
    @Column(name = "dateInscriptionAlpha")
    @Temporal(TemporalType.DATE)
    private Date dateInscriptionAlpha;
    @Size(max = 255)
    @Column(name = "numeroInscriAlpha")
    private String numeroInscriAlpha;
    @Column(name = "dateFinAssurance")
    @Temporal(TemporalType.DATE)
    private Date dateFinAssurance;
    @Column(name = "dateFinCt")
    @Temporal(TemporalType.DATE)
    private Date dateFinCt;
    @Size(max = 255)
    @Column(name = "emailConjoint")
    private String emailConjoint;
    @Size(max = 30)
    @Column(name = "telephoneConjoint")
    private String telephoneConjoint;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modeTransport")
    private int modeTransport;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nonSilae")
    private boolean nonSilae;
    @Column(name = "modulation")
    private Integer modulation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nonMobisap")
    private boolean nonMobisap;
    @Basic(optional = false)
    @NotNull
    @Column(name = "accepteEmail")
    private boolean accepteEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "annexe7")
    private boolean annexe7;
    @Basic(optional = false)
    @NotNull
    @Column(name = "chefEquipe")
    private boolean chefEquipe;
    @Column(name = "dateDerniereVisite")
    @Temporal(TemporalType.DATE)
    private Date dateDerniereVisite;
    @Basic(optional = false)
    @NotNull
    @Column(name = "handicape")
    private boolean handicape;
    @Column(name = "modeValidationHeures")
    private Integer modeValidationHeures;
    @Basic(optional = false)
    @NotNull
    @Column(name = "travailleurNuit")
    private boolean travailleurNuit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "travailleurOccasionnel")
    private boolean travailleurOccasionnel;
    @Size(max = 255)
    @Column(name = "imei")
    private String imei;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pushed2")
    private boolean pushed2;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "detailConnaissance")
    private String detailConnaissance;
    @Size(max = 255)
    @Column(name = "lieuJustifIdentite")
    private String lieuJustifIdentite;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aah")
    private boolean aah;
    @Column(name = "autreCategoriePension")
    private Integer autreCategoriePension;
    @Basic(optional = false)
    @NotNull
    @Column(name = "carteInvalidite")
    private boolean carteInvalidite;
    @Column(name = "categoriePension")
    private Integer categoriePension;
    @Column(name = "dateControleJustif")
    @Temporal(TemporalType.DATE)
    private Date dateControleJustif;
    @Column(name = "dateDebutCarteHandicap")
    @Temporal(TemporalType.DATE)
    private Date dateDebutCarteHandicap;
    @Column(name = "dateDebutIncapacitePermanente")
    @Temporal(TemporalType.DATE)
    private Date dateDebutIncapacitePermanente;
    @Column(name = "dateDebutPensionInvalidite")
    @Temporal(TemporalType.DATE)
    private Date dateDebutPensionInvalidite;
    @Column(name = "dateDepotRenouvellementHandicap")
    @Temporal(TemporalType.DATE)
    private Date dateDepotRenouvellementHandicap;
    @Column(name = "dateFinCarteHandicap")
    @Temporal(TemporalType.DATE)
    private Date dateFinCarteHandicap;
    @Column(name = "dateSalarieProtege")
    @Temporal(TemporalType.DATE)
    private Date dateSalarieProtege;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rqth")
    private boolean rqth;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salarieProtege")
    private boolean salarieProtege;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tauxIncapacite")
    private Double tauxIncapacite;
    @Column(name = "tauxIpp")
    private Double tauxIpp;
    @Column(name = "typeIncapacite")
    private Integer typeIncapacite;
    @JoinTable(name = "lnk_salarie_secteurs", joinColumns = {
        @JoinColumn(name = "candidatsalarie_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "listeSecteurs_id", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<SectGeo> sectGeoCollection;
    @JoinTable(name = "lnksalarielangues", joinColumns = {
        @JoinColumn(name = "candidatsalarie_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "listeLangues_id", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Langue> langueCollection;
    @OneToMany(mappedBy = "idCommercial", fetch = FetchType.LAZY)
    private Collection<Sc> scCollection;
    @OneToMany(mappedBy = "idResponsable", fetch = FetchType.LAZY)
    private Collection<Sc> scCollection1;
    @OneToMany(mappedBy = "idChefEquipe", fetch = FetchType.LAZY)
    private Collection<Sc> scCollection2;
    @OneToMany(mappedBy = "idInspecteur", fetch = FetchType.LAZY)
    private Collection<Sc> scCollection3;
    @OneToMany(mappedBy = "idOrigine", fetch = FetchType.LAZY)
    private Collection<Candidatsalarie> candidatsalarieCollection;
    @JoinColumn(name = "idOrigine", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Candidatsalarie idOrigine;
    @JoinColumn(name = "idAutorisation", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private At idAutorisation;
    @JoinColumn(name = "idCanton", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Canton idCanton;
    @JoinColumn(name = "idCatPro", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private CatPro idCatPro;
    @JoinColumn(name = "idSoc", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Soc idSoc;
    @JoinColumn(name = "idDept", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Dept idDept;
    @JoinColumn(name = "idExperience", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Experience idExperience;
    @JoinColumn(name = "idIntPoste", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Lstintituleposte idIntPoste;
    @JoinColumn(name = "idSituation", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Situation idSituation;
    @JoinColumn(name = "idConnaissance", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Mdc idConnaissance;
    @JoinColumn(name = "idNat", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Nation idNat;
    @JoinColumn(name = "idNivEtude", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private NivEtude idNivEtude;
    @JoinColumn(name = "idService", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Service idService;
    @JoinColumn(name = "idPays", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Nation idPays;
    @JoinColumn(name = "idPaysNaissance", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Nation idPaysNaissance;
    @OneToMany(mappedBy = "idSalarie", fetch = FetchType.LAZY)
    private Collection<Acompte> acompteCollection;
    @OneToMany(mappedBy = "idSalarie", fetch = FetchType.LAZY)
    private Collection<User> userCollection;

    public Candidatsalarie() {
    }

    public Candidatsalarie(Long id) {
        this.id = id;
    }

    public Candidatsalarie(Long id, boolean salarie, boolean actif, boolean accepteEmails, boolean autreEmployeur, boolean casierVierge, boolean diplome, boolean dispoMatin, boolean dispoSoir, boolean nuitUniquement, boolean permis, boolean supprime, boolean vehicule, boolean inspecteur, boolean responsable, boolean refusCompSante, boolean questionnaire, boolean commercial, boolean pushed, int modeTransport, boolean nonSilae, boolean nonMobisap, boolean accepteEmail, boolean annexe7, boolean chefEquipe, boolean handicape, boolean travailleurNuit, boolean travailleurOccasionnel, boolean pushed2, boolean aah, boolean carteInvalidite, boolean rqth, boolean salarieProtege) {
        this.id = id;
        this.salarie = salarie;
        this.actif = actif;
        this.accepteEmails = accepteEmails;
        this.autreEmployeur = autreEmployeur;
        this.casierVierge = casierVierge;
        this.diplome = diplome;
        this.dispoMatin = dispoMatin;
        this.dispoSoir = dispoSoir;
        this.nuitUniquement = nuitUniquement;
        this.permis = permis;
        this.supprime = supprime;
        this.vehicule = vehicule;
        this.inspecteur = inspecteur;
        this.responsable = responsable;
        this.refusCompSante = refusCompSante;
        this.questionnaire = questionnaire;
        this.commercial = commercial;
        this.pushed = pushed;
        this.modeTransport = modeTransport;
        this.nonSilae = nonSilae;
        this.nonMobisap = nonMobisap;
        this.accepteEmail = accepteEmail;
        this.annexe7 = annexe7;
        this.chefEquipe = chefEquipe;
        this.handicape = handicape;
        this.travailleurNuit = travailleurNuit;
        this.travailleurOccasionnel = travailleurOccasionnel;
        this.pushed2 = pushed2;
        this.aah = aah;
        this.carteInvalidite = carteInvalidite;
        this.rqth = rqth;
        this.salarieProtege = salarieProtege;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCivilite() {
        return civilite;
    }

    public void setCivilite(Integer civilite) {
        this.civilite = civilite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public boolean getSalarie() {
        return salarie;
    }

    public void setSalarie(boolean salarie) {
        this.salarie = salarie;
    }

    public boolean getActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public boolean getAccepteEmails() {
        return accepteEmails;
    }

    public void setAccepteEmails(boolean accepteEmails) {
        this.accepteEmails = accepteEmails;
    }

    public String getAdresseSuite() {
        return adresseSuite;
    }

    public void setAdresseSuite(String adresseSuite) {
        this.adresseSuite = adresseSuite;
    }

    public boolean getAutreEmployeur() {
        return autreEmployeur;
    }

    public void setAutreEmployeur(boolean autreEmployeur) {
        this.autreEmployeur = autreEmployeur;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public boolean getCasierVierge() {
        return casierVierge;
    }

    public void setCasierVierge(boolean casierVierge) {
        this.casierVierge = casierVierge;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(String coefficient) {
        this.coefficient = coefficient;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateDisponibilite() {
        return dateDisponibilite;
    }

    public void setDateDisponibilite(Date dateDisponibilite) {
        this.dateDisponibilite = dateDisponibilite;
    }

    public Date getDateEntree() {
        return dateEntree;
    }

    public void setDateEntree(Date dateEntree) {
        this.dateEntree = dateEntree;
    }

    public Date getDateFinCarteIdentite() {
        return dateFinCarteIdentite;
    }

    public void setDateFinCarteIdentite(Date dateFinCarteIdentite) {
        this.dateFinCarteIdentite = dateFinCarteIdentite;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public Date getDateMaj() {
        return dateMaj;
    }

    public void setDateMaj(Date dateMaj) {
        this.dateMaj = dateMaj;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Date getDateNaissanceConjoint() {
        return dateNaissanceConjoint;
    }

    public void setDateNaissanceConjoint(Date dateNaissanceConjoint) {
        this.dateNaissanceConjoint = dateNaissanceConjoint;
    }

    public Date getDatePermis() {
        return datePermis;
    }

    public void setDatePermis(Date datePermis) {
        this.datePermis = datePermis;
    }

    public boolean getDiplome() {
        return diplome;
    }

    public void setDiplome(boolean diplome) {
        this.diplome = diplome;
    }

    public boolean getDispoMatin() {
        return dispoMatin;
    }

    public void setDispoMatin(boolean dispoMatin) {
        this.dispoMatin = dispoMatin;
    }

    public boolean getDispoSoir() {
        return dispoSoir;
    }

    public void setDispoSoir(boolean dispoSoir) {
        this.dispoSoir = dispoSoir;
    }

    public String getDue() {
        return due;
    }

    public void setDue(String due) {
        this.due = due;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailProfessionnel() {
        return emailProfessionnel;
    }

    public void setEmailProfessionnel(String emailProfessionnel) {
        this.emailProfessionnel = emailProfessionnel;
    }

    public Integer getEnfants() {
        return enfants;
    }

    public void setEnfants(Integer enfants) {
        this.enfants = enfants;
    }

    public String getHeureDebutMatin() {
        return heureDebutMatin;
    }

    public void setHeureDebutMatin(String heureDebutMatin) {
        this.heureDebutMatin = heureDebutMatin;
    }

    public String getHeureDebutSoir() {
        return heureDebutSoir;
    }

    public void setHeureDebutSoir(String heureDebutSoir) {
        this.heureDebutSoir = heureDebutSoir;
    }

    public String getHeureFinMatin() {
        return heureFinMatin;
    }

    public void setHeureFinMatin(String heureFinMatin) {
        this.heureFinMatin = heureFinMatin;
    }

    public String getHeureFinSoir() {
        return heureFinSoir;
    }

    public void setHeureFinSoir(String heureFinSoir) {
        this.heureFinSoir = heureFinSoir;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Integer getJoursConges() {
        return joursConges;
    }

    public void setJoursConges(Integer joursConges) {
        this.joursConges = joursConges;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobileProfessionnel() {
        return mobileProfessionnel;
    }

    public void setMobileProfessionnel(String mobileProfessionnel) {
        this.mobileProfessionnel = mobileProfessionnel;
    }

    public Integer getModeReglement() {
        return modeReglement;
    }

    public void setModeReglement(Integer modeReglement) {
        this.modeReglement = modeReglement;
    }

    public String getNomConjoint() {
        return nomConjoint;
    }

    public void setNomConjoint(String nomConjoint) {
        this.nomConjoint = nomConjoint;
    }

    public String getNomJeuneFille() {
        return nomJeuneFille;
    }

    public void setNomJeuneFille(String nomJeuneFille) {
        this.nomJeuneFille = nomJeuneFille;
    }

    public boolean getNuitUniquement() {
        return nuitUniquement;
    }

    public void setNuitUniquement(boolean nuitUniquement) {
        this.nuitUniquement = nuitUniquement;
    }

    public String getNumPieceIdentite() {
        return numPieceIdentite;
    }

    public void setNumPieceIdentite(String numPieceIdentite) {
        this.numPieceIdentite = numPieceIdentite;
    }

    public String getNumeroEtVoie() {
        return numeroEtVoie;
    }

    public void setNumeroEtVoie(String numeroEtVoie) {
        this.numeroEtVoie = numeroEtVoie;
    }

    public String getNumeroMatricule() {
        return numeroMatricule;
    }

    public void setNumeroMatricule(String numeroMatricule) {
        this.numeroMatricule = numeroMatricule;
    }

    public String getNumeroSecu() {
        return numeroSecu;
    }

    public void setNumeroSecu(String numeroSecu) {
        this.numeroSecu = numeroSecu;
    }

    public boolean getPermis() {
        return permis;
    }

    public void setPermis(boolean permis) {
        this.permis = permis;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPrenomConjoint() {
        return prenomConjoint;
    }

    public void setPrenomConjoint(String prenomConjoint) {
        this.prenomConjoint = prenomConjoint;
    }

    public String getQualitePersonnelles() {
        return qualitePersonnelles;
    }

    public void setQualitePersonnelles(String qualitePersonnelles) {
        this.qualitePersonnelles = qualitePersonnelles;
    }

    public String getQualiteProfessionnelles() {
        return qualiteProfessionnelles;
    }

    public void setQualiteProfessionnelles(String qualiteProfessionnelles) {
        this.qualiteProfessionnelles = qualiteProfessionnelles;
    }

    public Integer getSituation() {
        return situation;
    }

    public void setSituation(Integer situation) {
        this.situation = situation;
    }

    public Integer getSituationFamiliale() {
        return situationFamiliale;
    }

    public void setSituationFamiliale(Integer situationFamiliale) {
        this.situationFamiliale = situationFamiliale;
    }

    public Integer getStatutCandidat() {
        return statutCandidat;
    }

    public void setStatutCandidat(Integer statutCandidat) {
        this.statutCandidat = statutCandidat;
    }

    public boolean getSupprime() {
        return supprime;
    }

    public void setSupprime(boolean supprime) {
        this.supprime = supprime;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getTypeJustifIdentite() {
        return typeJustifIdentite;
    }

    public void setTypeJustifIdentite(Integer typeJustifIdentite) {
        this.typeJustifIdentite = typeJustifIdentite;
    }

    public Short getValidationCandidat() {
        return validationCandidat;
    }

    public void setValidationCandidat(Short validationCandidat) {
        this.validationCandidat = validationCandidat;
    }

    public boolean getVehicule() {
        return vehicule;
    }

    public void setVehicule(boolean vehicule) {
        this.vehicule = vehicule;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Date getDateEmission() {
        return dateEmission;
    }

    public void setDateEmission(Date dateEmission) {
        this.dateEmission = dateEmission;
    }

    public Date getDateAutorisation() {
        return dateAutorisation;
    }

    public void setDateAutorisation(Date dateAutorisation) {
        this.dateAutorisation = dateAutorisation;
    }

    public String getNumeroAutorisation() {
        return numeroAutorisation;
    }

    public void setNumeroAutorisation(String numeroAutorisation) {
        this.numeroAutorisation = numeroAutorisation;
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

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public boolean getInspecteur() {
        return inspecteur;
    }

    public void setInspecteur(boolean inspecteur) {
        this.inspecteur = inspecteur;
    }

    public boolean getResponsable() {
        return responsable;
    }

    public void setResponsable(boolean responsable) {
        this.responsable = responsable;
    }

    public Date getDateCompSante() {
        return dateCompSante;
    }

    public void setDateCompSante(Date dateCompSante) {
        this.dateCompSante = dateCompSante;
    }

    public Integer getMotifRefusCompSante() {
        return motifRefusCompSante;
    }

    public void setMotifRefusCompSante(Integer motifRefusCompSante) {
        this.motifRefusCompSante = motifRefusCompSante;
    }

    public boolean getRefusCompSante() {
        return refusCompSante;
    }

    public void setRefusCompSante(boolean refusCompSante) {
        this.refusCompSante = refusCompSante;
    }

    public boolean getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(boolean questionnaire) {
        this.questionnaire = questionnaire;
    }

    public Integer getStatutValidation() {
        return statutValidation;
    }

    public void setStatutValidation(Integer statutValidation) {
        this.statutValidation = statutValidation;
    }

    public String getCompteRendu() {
        return compteRendu;
    }

    public void setCompteRendu(String compteRendu) {
        this.compteRendu = compteRendu;
    }

    public Date getDateRdv() {
        return dateRdv;
    }

    public void setDateRdv(Date dateRdv) {
        this.dateRdv = dateRdv;
    }

    public String getQualitesPerso() {
        return qualitesPerso;
    }

    public void setQualitesPerso(String qualitesPerso) {
        this.qualitesPerso = qualitesPerso;
    }

    public String getQualitesPro() {
        return qualitesPro;
    }

    public void setQualitesPro(String qualitesPro) {
        this.qualitesPro = qualitesPro;
    }

    public String getDepartementNaissance() {
        return departementNaissance;
    }

    public void setDepartementNaissance(String departementNaissance) {
        this.departementNaissance = departementNaissance;
    }

    public String getNumPermis() {
        return numPermis;
    }

    public void setNumPermis(String numPermis) {
        this.numPermis = numPermis;
    }

    public BigInteger getNumAuto() {
        return numAuto;
    }

    public void setNumAuto(BigInteger numAuto) {
        this.numAuto = numAuto;
    }

    public Date getDateEmployeur() {
        return dateEmployeur;
    }

    public void setDateEmployeur(Date dateEmployeur) {
        this.dateEmployeur = dateEmployeur;
    }

    public String getNoteInterne() {
        return noteInterne;
    }

    public void setNoteInterne(String noteInterne) {
        this.noteInterne = noteInterne;
    }

    public Date getDateFinPermis() {
        return dateFinPermis;
    }

    public void setDateFinPermis(Date dateFinPermis) {
        this.dateFinPermis = dateFinPermis;
    }

    public Date getDateProchaineVisite() {
        return dateProchaineVisite;
    }

    public void setDateProchaineVisite(Date dateProchaineVisite) {
        this.dateProchaineVisite = dateProchaineVisite;
    }

    public Date getDateSuppression() {
        return dateSuppression;
    }

    public void setDateSuppression(Date dateSuppression) {
        this.dateSuppression = dateSuppression;
    }

    public boolean getCommercial() {
        return commercial;
    }

    public void setCommercial(boolean commercial) {
        this.commercial = commercial;
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

    public String getLoginPenbase() {
        return loginPenbase;
    }

    public void setLoginPenbase(String loginPenbase) {
        this.loginPenbase = loginPenbase;
    }

    public Date getDateInscriptionAlpha() {
        return dateInscriptionAlpha;
    }

    public void setDateInscriptionAlpha(Date dateInscriptionAlpha) {
        this.dateInscriptionAlpha = dateInscriptionAlpha;
    }

    public String getNumeroInscriAlpha() {
        return numeroInscriAlpha;
    }

    public void setNumeroInscriAlpha(String numeroInscriAlpha) {
        this.numeroInscriAlpha = numeroInscriAlpha;
    }

    public Date getDateFinAssurance() {
        return dateFinAssurance;
    }

    public void setDateFinAssurance(Date dateFinAssurance) {
        this.dateFinAssurance = dateFinAssurance;
    }

    public Date getDateFinCt() {
        return dateFinCt;
    }

    public void setDateFinCt(Date dateFinCt) {
        this.dateFinCt = dateFinCt;
    }

    public String getEmailConjoint() {
        return emailConjoint;
    }

    public void setEmailConjoint(String emailConjoint) {
        this.emailConjoint = emailConjoint;
    }

    public String getTelephoneConjoint() {
        return telephoneConjoint;
    }

    public void setTelephoneConjoint(String telephoneConjoint) {
        this.telephoneConjoint = telephoneConjoint;
    }

    public int getModeTransport() {
        return modeTransport;
    }

    public void setModeTransport(int modeTransport) {
        this.modeTransport = modeTransport;
    }

    public boolean getNonSilae() {
        return nonSilae;
    }

    public void setNonSilae(boolean nonSilae) {
        this.nonSilae = nonSilae;
    }

    public Integer getModulation() {
        return modulation;
    }

    public void setModulation(Integer modulation) {
        this.modulation = modulation;
    }

    public boolean getNonMobisap() {
        return nonMobisap;
    }

    public void setNonMobisap(boolean nonMobisap) {
        this.nonMobisap = nonMobisap;
    }

    public boolean getAccepteEmail() {
        return accepteEmail;
    }

    public void setAccepteEmail(boolean accepteEmail) {
        this.accepteEmail = accepteEmail;
    }

    public boolean getAnnexe7() {
        return annexe7;
    }

    public void setAnnexe7(boolean annexe7) {
        this.annexe7 = annexe7;
    }

    public boolean getChefEquipe() {
        return chefEquipe;
    }

    public void setChefEquipe(boolean chefEquipe) {
        this.chefEquipe = chefEquipe;
    }

    public Date getDateDerniereVisite() {
        return dateDerniereVisite;
    }

    public void setDateDerniereVisite(Date dateDerniereVisite) {
        this.dateDerniereVisite = dateDerniereVisite;
    }

    public boolean getHandicape() {
        return handicape;
    }

    public void setHandicape(boolean handicape) {
        this.handicape = handicape;
    }

    public Integer getModeValidationHeures() {
        return modeValidationHeures;
    }

    public void setModeValidationHeures(Integer modeValidationHeures) {
        this.modeValidationHeures = modeValidationHeures;
    }

    public boolean getTravailleurNuit() {
        return travailleurNuit;
    }

    public void setTravailleurNuit(boolean travailleurNuit) {
        this.travailleurNuit = travailleurNuit;
    }

    public boolean getTravailleurOccasionnel() {
        return travailleurOccasionnel;
    }

    public void setTravailleurOccasionnel(boolean travailleurOccasionnel) {
        this.travailleurOccasionnel = travailleurOccasionnel;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public boolean getPushed2() {
        return pushed2;
    }

    public void setPushed2(boolean pushed2) {
        this.pushed2 = pushed2;
    }

    public String getDetailConnaissance() {
        return detailConnaissance;
    }

    public void setDetailConnaissance(String detailConnaissance) {
        this.detailConnaissance = detailConnaissance;
    }

    public String getLieuJustifIdentite() {
        return lieuJustifIdentite;
    }

    public void setLieuJustifIdentite(String lieuJustifIdentite) {
        this.lieuJustifIdentite = lieuJustifIdentite;
    }

    public boolean getAah() {
        return aah;
    }

    public void setAah(boolean aah) {
        this.aah = aah;
    }

    public Integer getAutreCategoriePension() {
        return autreCategoriePension;
    }

    public void setAutreCategoriePension(Integer autreCategoriePension) {
        this.autreCategoriePension = autreCategoriePension;
    }

    public boolean getCarteInvalidite() {
        return carteInvalidite;
    }

    public void setCarteInvalidite(boolean carteInvalidite) {
        this.carteInvalidite = carteInvalidite;
    }

    public Integer getCategoriePension() {
        return categoriePension;
    }

    public void setCategoriePension(Integer categoriePension) {
        this.categoriePension = categoriePension;
    }

    public Date getDateControleJustif() {
        return dateControleJustif;
    }

    public void setDateControleJustif(Date dateControleJustif) {
        this.dateControleJustif = dateControleJustif;
    }

    public Date getDateDebutCarteHandicap() {
        return dateDebutCarteHandicap;
    }

    public void setDateDebutCarteHandicap(Date dateDebutCarteHandicap) {
        this.dateDebutCarteHandicap = dateDebutCarteHandicap;
    }

    public Date getDateDebutIncapacitePermanente() {
        return dateDebutIncapacitePermanente;
    }

    public void setDateDebutIncapacitePermanente(Date dateDebutIncapacitePermanente) {
        this.dateDebutIncapacitePermanente = dateDebutIncapacitePermanente;
    }

    public Date getDateDebutPensionInvalidite() {
        return dateDebutPensionInvalidite;
    }

    public void setDateDebutPensionInvalidite(Date dateDebutPensionInvalidite) {
        this.dateDebutPensionInvalidite = dateDebutPensionInvalidite;
    }

    public Date getDateDepotRenouvellementHandicap() {
        return dateDepotRenouvellementHandicap;
    }

    public void setDateDepotRenouvellementHandicap(Date dateDepotRenouvellementHandicap) {
        this.dateDepotRenouvellementHandicap = dateDepotRenouvellementHandicap;
    }

    public Date getDateFinCarteHandicap() {
        return dateFinCarteHandicap;
    }

    public void setDateFinCarteHandicap(Date dateFinCarteHandicap) {
        this.dateFinCarteHandicap = dateFinCarteHandicap;
    }

    public Date getDateSalarieProtege() {
        return dateSalarieProtege;
    }

    public void setDateSalarieProtege(Date dateSalarieProtege) {
        this.dateSalarieProtege = dateSalarieProtege;
    }

    public boolean getRqth() {
        return rqth;
    }

    public void setRqth(boolean rqth) {
        this.rqth = rqth;
    }

    public boolean getSalarieProtege() {
        return salarieProtege;
    }

    public void setSalarieProtege(boolean salarieProtege) {
        this.salarieProtege = salarieProtege;
    }

    public Double getTauxIncapacite() {
        return tauxIncapacite;
    }

    public void setTauxIncapacite(Double tauxIncapacite) {
        this.tauxIncapacite = tauxIncapacite;
    }

    public Double getTauxIpp() {
        return tauxIpp;
    }

    public void setTauxIpp(Double tauxIpp) {
        this.tauxIpp = tauxIpp;
    }

    public Integer getTypeIncapacite() {
        return typeIncapacite;
    }

    public void setTypeIncapacite(Integer typeIncapacite) {
        this.typeIncapacite = typeIncapacite;
    }

    @XmlTransient
    public Collection<SectGeo> getSectGeoCollection() {
        return sectGeoCollection;
    }

    public void setSectGeoCollection(Collection<SectGeo> sectGeoCollection) {
        this.sectGeoCollection = sectGeoCollection;
    }

    @XmlTransient
    public Collection<Langue> getLangueCollection() {
        return langueCollection;
    }

    public void setLangueCollection(Collection<Langue> langueCollection) {
        this.langueCollection = langueCollection;
    }

    @XmlTransient
    public Collection<Sc> getScCollection() {
        return scCollection;
    }

    public void setScCollection(Collection<Sc> scCollection) {
        this.scCollection = scCollection;
    }

    @XmlTransient
    public Collection<Sc> getScCollection1() {
        return scCollection1;
    }

    public void setScCollection1(Collection<Sc> scCollection1) {
        this.scCollection1 = scCollection1;
    }

    @XmlTransient
    public Collection<Sc> getScCollection2() {
        return scCollection2;
    }

    public void setScCollection2(Collection<Sc> scCollection2) {
        this.scCollection2 = scCollection2;
    }

    @XmlTransient
    public Collection<Sc> getScCollection3() {
        return scCollection3;
    }

    public void setScCollection3(Collection<Sc> scCollection3) {
        this.scCollection3 = scCollection3;
    }

    @XmlTransient
    public Collection<Candidatsalarie> getCandidatsalarieCollection() {
        return candidatsalarieCollection;
    }

    public void setCandidatsalarieCollection(Collection<Candidatsalarie> candidatsalarieCollection) {
        this.candidatsalarieCollection = candidatsalarieCollection;
    }

    public Candidatsalarie getIdOrigine() {
        return idOrigine;
    }

    public void setIdOrigine(Candidatsalarie idOrigine) {
        this.idOrigine = idOrigine;
    }

    public At getIdAutorisation() {
        return idAutorisation;
    }

    public void setIdAutorisation(At idAutorisation) {
        this.idAutorisation = idAutorisation;
    }

    public Canton getIdCanton() {
        return idCanton;
    }

    public void setIdCanton(Canton idCanton) {
        this.idCanton = idCanton;
    }

    public CatPro getIdCatPro() {
        return idCatPro;
    }

    public void setIdCatPro(CatPro idCatPro) {
        this.idCatPro = idCatPro;
    }

    public Soc getIdSoc() {
        return idSoc;
    }

    public void setIdSoc(Soc idSoc) {
        this.idSoc = idSoc;
    }

    public Dept getIdDept() {
        return idDept;
    }

    public void setIdDept(Dept idDept) {
        this.idDept = idDept;
    }

    public Experience getIdExperience() {
        return idExperience;
    }

    public void setIdExperience(Experience idExperience) {
        this.idExperience = idExperience;
    }

    public Lstintituleposte getIdIntPoste() {
        return idIntPoste;
    }

    public void setIdIntPoste(Lstintituleposte idIntPoste) {
        this.idIntPoste = idIntPoste;
    }

    public Situation getIdSituation() {
        return idSituation;
    }

    public void setIdSituation(Situation idSituation) {
        this.idSituation = idSituation;
    }

    public Mdc getIdConnaissance() {
        return idConnaissance;
    }

    public void setIdConnaissance(Mdc idConnaissance) {
        this.idConnaissance = idConnaissance;
    }

    public Nation getIdNat() {
        return idNat;
    }

    public void setIdNat(Nation idNat) {
        this.idNat = idNat;
    }

    public NivEtude getIdNivEtude() {
        return idNivEtude;
    }

    public void setIdNivEtude(NivEtude idNivEtude) {
        this.idNivEtude = idNivEtude;
    }

    public Service getIdService() {
        return idService;
    }

    public void setIdService(Service idService) {
        this.idService = idService;
    }

    public Nation getIdPays() {
        return idPays;
    }

    public void setIdPays(Nation idPays) {
        this.idPays = idPays;
    }

    public Nation getIdPaysNaissance() {
        return idPaysNaissance;
    }

    public void setIdPaysNaissance(Nation idPaysNaissance) {
        this.idPaysNaissance = idPaysNaissance;
    }

    @XmlTransient
    public Collection<Acompte> getAcompteCollection() {
        return acompteCollection;
    }

    public void setAcompteCollection(Collection<Acompte> acompteCollection) {
        this.acompteCollection = acompteCollection;
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
        if (!(object instanceof Candidatsalarie)) {
            return false;
        }
        Candidatsalarie other = (Candidatsalarie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.Candidatsalarie[ id=" + id + " ]";
    }
    
}
