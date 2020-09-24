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
@Table(name = "prestations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestations.findAll", query = "SELECT p FROM Prestations p"),
    @NamedQuery(name = "Prestations.findById", query = "SELECT p FROM Prestations p WHERE p.id = :id"),
    @NamedQuery(name = "Prestations.findByLibelle", query = "SELECT p FROM Prestations p WHERE p.libelle = :libelle"),
    @NamedQuery(name = "Prestations.findBySupprime", query = "SELECT p FROM Prestations p WHERE p.supprime = :supprime"),
    @NamedQuery(name = "Prestations.findByFond", query = "SELECT p FROM Prestations p WHERE p.fond = :fond"),
    @NamedQuery(name = "Prestations.findByTexte", query = "SELECT p FROM Prestations p WHERE p.texte = :texte"),
    @NamedQuery(name = "Prestations.findByCode", query = "SELECT p FROM Prestations p WHERE p.code = :code"),
    @NamedQuery(name = "Prestations.findByType", query = "SELECT p FROM Prestations p WHERE p.type = :type"),
    @NamedQuery(name = "Prestations.findByLibelleFacturation", query = "SELECT p FROM Prestations p WHERE p.libelleFacturation = :libelleFacturation"),
    @NamedQuery(name = "Prestations.findByTarifHt", query = "SELECT p FROM Prestations p WHERE p.tarifHt = :tarifHt"),
    @NamedQuery(name = "Prestations.findByDateCreation", query = "SELECT p FROM Prestations p WHERE p.dateCreation = :dateCreation"),
    @NamedQuery(name = "Prestations.findByDateMaj", query = "SELECT p FROM Prestations p WHERE p.dateMaj = :dateMaj"),
    @NamedQuery(name = "Prestations.findByBt", query = "SELECT p FROM Prestations p WHERE p.bt = :bt"),
    @NamedQuery(name = "Prestations.findByPushed", query = "SELECT p FROM Prestations p WHERE p.pushed = :pushed"),
    @NamedQuery(name = "Prestations.findByTournee", query = "SELECT p FROM Prestations p WHERE p.tournee = :tournee"),
    @NamedQuery(name = "Prestations.findByMajorable", query = "SELECT p FROM Prestations p WHERE p.majorable = :majorable"),
    @NamedQuery(name = "Prestations.findByModeleEv", query = "SELECT p FROM Prestations p WHERE p.modeleEv = :modeleEv"),
    @NamedQuery(name = "Prestations.findByPrestationCaf", query = "SELECT p FROM Prestations p WHERE p.prestationCaf = :prestationCaf"),
    @NamedQuery(name = "Prestations.findByPushed2", query = "SELECT p FROM Prestations p WHERE p.pushed2 = :pushed2"),
    @NamedQuery(name = "Prestations.findByRubriquePaie", query = "SELECT p FROM Prestations p WHERE p.rubriquePaie = :rubriquePaie"),
    @NamedQuery(name = "Prestations.findByAutoriseEnAjout", query = "SELECT p FROM Prestations p WHERE p.autoriseEnAjout = :autoriseEnAjout"),
    @NamedQuery(name = "Prestations.findByTypePrestationGuestadom", query = "SELECT p FROM Prestations p WHERE p.typePrestationGuestadom = :typePrestationGuestadom")})
public class Prestations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "libelle")
    private String libelle;
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
    @Size(max = 255)
    @Column(name = "code")
    private String code;
    @Column(name = "type")
    private Integer type;
    @Size(max = 255)
    @Column(name = "libelleFacturation")
    private String libelleFacturation;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tarifHt")
    private Double tarifHt;
    @Column(name = "dateCreation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "dateMaj")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateMaj;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bt")
    private boolean bt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pushed")
    private boolean pushed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tournee")
    private boolean tournee;
    @Basic(optional = false)
    @NotNull
    @Column(name = "majorable")
    private boolean majorable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modeleEv")
    private boolean modeleEv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prestationCaf")
    private boolean prestationCaf;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pushed2")
    private boolean pushed2;
    @Size(max = 255)
    @Column(name = "rubriquePaie")
    private String rubriquePaie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "autoriseEnAjout")
    private boolean autoriseEnAjout;
    @Column(name = "typePrestationGuestadom")
    private Integer typePrestationGuestadom;
    @JoinColumn(name = "idCat", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private CategorieMateriel idCat;
    @JoinColumn(name = "idClient", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Client idClient;
    @JoinColumn(name = "idCompteComptable", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private CompteComptable idCompteComptable;
    @JoinColumn(name = "idFam", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private FamilleCategorie idFam;
    @JoinColumn(name = "idFamille", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private FamillePrestation idFamille;
    @JoinColumn(name = "idSoc", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Soc idSoc;
    @JoinColumn(name = "idSousFam", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private SousFamilleCategorie idSousFam;
    @OneToMany(mappedBy = "idPrestation", fetch = FetchType.LAZY)
    private Collection<CatDevis> catDevisCollection;

    public Prestations() {
    }

    public Prestations(Long id) {
        this.id = id;
    }

    public Prestations(Long id, boolean supprime, boolean bt, boolean pushed, boolean tournee, boolean majorable, boolean modeleEv, boolean prestationCaf, boolean pushed2, boolean autoriseEnAjout) {
        this.id = id;
        this.supprime = supprime;
        this.bt = bt;
        this.pushed = pushed;
        this.tournee = tournee;
        this.majorable = majorable;
        this.modeleEv = modeleEv;
        this.prestationCaf = prestationCaf;
        this.pushed2 = pushed2;
        this.autoriseEnAjout = autoriseEnAjout;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getLibelleFacturation() {
        return libelleFacturation;
    }

    public void setLibelleFacturation(String libelleFacturation) {
        this.libelleFacturation = libelleFacturation;
    }

    public Double getTarifHt() {
        return tarifHt;
    }

    public void setTarifHt(Double tarifHt) {
        this.tarifHt = tarifHt;
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

    public boolean getBt() {
        return bt;
    }

    public void setBt(boolean bt) {
        this.bt = bt;
    }

    public boolean getPushed() {
        return pushed;
    }

    public void setPushed(boolean pushed) {
        this.pushed = pushed;
    }

    public boolean getTournee() {
        return tournee;
    }

    public void setTournee(boolean tournee) {
        this.tournee = tournee;
    }

    public boolean getMajorable() {
        return majorable;
    }

    public void setMajorable(boolean majorable) {
        this.majorable = majorable;
    }

    public boolean getModeleEv() {
        return modeleEv;
    }

    public void setModeleEv(boolean modeleEv) {
        this.modeleEv = modeleEv;
    }

    public boolean getPrestationCaf() {
        return prestationCaf;
    }

    public void setPrestationCaf(boolean prestationCaf) {
        this.prestationCaf = prestationCaf;
    }

    public boolean getPushed2() {
        return pushed2;
    }

    public void setPushed2(boolean pushed2) {
        this.pushed2 = pushed2;
    }

    public String getRubriquePaie() {
        return rubriquePaie;
    }

    public void setRubriquePaie(String rubriquePaie) {
        this.rubriquePaie = rubriquePaie;
    }

    public boolean getAutoriseEnAjout() {
        return autoriseEnAjout;
    }

    public void setAutoriseEnAjout(boolean autoriseEnAjout) {
        this.autoriseEnAjout = autoriseEnAjout;
    }

    public Integer getTypePrestationGuestadom() {
        return typePrestationGuestadom;
    }

    public void setTypePrestationGuestadom(Integer typePrestationGuestadom) {
        this.typePrestationGuestadom = typePrestationGuestadom;
    }

    public CategorieMateriel getIdCat() {
        return idCat;
    }

    public void setIdCat(CategorieMateriel idCat) {
        this.idCat = idCat;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    public CompteComptable getIdCompteComptable() {
        return idCompteComptable;
    }

    public void setIdCompteComptable(CompteComptable idCompteComptable) {
        this.idCompteComptable = idCompteComptable;
    }

    public FamilleCategorie getIdFam() {
        return idFam;
    }

    public void setIdFam(FamilleCategorie idFam) {
        this.idFam = idFam;
    }

    public FamillePrestation getIdFamille() {
        return idFamille;
    }

    public void setIdFamille(FamillePrestation idFamille) {
        this.idFamille = idFamille;
    }

    public Soc getIdSoc() {
        return idSoc;
    }

    public void setIdSoc(Soc idSoc) {
        this.idSoc = idSoc;
    }

    public SousFamilleCategorie getIdSousFam() {
        return idSousFam;
    }

    public void setIdSousFam(SousFamilleCategorie idSousFam) {
        this.idSousFam = idSousFam;
    }

    @XmlTransient
    public Collection<CatDevis> getCatDevisCollection() {
        return catDevisCollection;
    }

    public void setCatDevisCollection(Collection<CatDevis> catDevisCollection) {
        this.catDevisCollection = catDevisCollection;
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
        if (!(object instanceof Prestations)) {
            return false;
        }
        Prestations other = (Prestations) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.Prestations[ id=" + id + " ]";
    }
    
}
