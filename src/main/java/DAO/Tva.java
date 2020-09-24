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
@Table(name = "tva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tva.findAll", query = "SELECT t FROM Tva t"),
    @NamedQuery(name = "Tva.findById", query = "SELECT t FROM Tva t WHERE t.id = :id"),
    @NamedQuery(name = "Tva.findByDateCreation", query = "SELECT t FROM Tva t WHERE t.dateCreation = :dateCreation"),
    @NamedQuery(name = "Tva.findByDateMaj", query = "SELECT t FROM Tva t WHERE t.dateMaj = :dateMaj"),
    @NamedQuery(name = "Tva.findByDateSuppressionLogique", query = "SELECT t FROM Tva t WHERE t.dateSuppressionLogique = :dateSuppressionLogique"),
    @NamedQuery(name = "Tva.findByLibelle", query = "SELECT t FROM Tva t WHERE t.libelle = :libelle"),
    @NamedQuery(name = "Tva.findBySupprime", query = "SELECT t FROM Tva t WHERE t.supprime = :supprime"),
    @NamedQuery(name = "Tva.findByValeur", query = "SELECT t FROM Tva t WHERE t.valeur = :valeur"),
    @NamedQuery(name = "Tva.findByCode", query = "SELECT t FROM Tva t WHERE t.code = :code"),
    @NamedQuery(name = "Tva.findByDefaut", query = "SELECT t FROM Tva t WHERE t.defaut = :defaut"),
    @NamedQuery(name = "Tva.findByComptePresta", query = "SELECT t FROM Tva t WHERE t.comptePresta = :comptePresta"),
    @NamedQuery(name = "Tva.findByCompteTiers", query = "SELECT t FROM Tva t WHERE t.compteTiers = :compteTiers"),
    @NamedQuery(name = "Tva.findByDoubleTva", query = "SELECT t FROM Tva t WHERE t.doubleTva = :doubleTva"),
    @NamedQuery(name = "Tva.findByLibelleTva1", query = "SELECT t FROM Tva t WHERE t.libelleTva1 = :libelleTva1"),
    @NamedQuery(name = "Tva.findByLibelleTva2", query = "SELECT t FROM Tva t WHERE t.libelleTva2 = :libelleTva2"),
    @NamedQuery(name = "Tva.findByValeur2", query = "SELECT t FROM Tva t WHERE t.valeur2 = :valeur2"),
    @NamedQuery(name = "Tva.findByCode2", query = "SELECT t FROM Tva t WHERE t.code2 = :code2")})
public class Tva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "dateCreation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "dateMaj")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateMaj;
    @Column(name = "dateSuppressionLogique")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSuppressionLogique;
    @Size(max = 255)
    @Column(name = "libelle")
    private String libelle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "supprime")
    private boolean supprime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valeur")
    private double valeur;
    @Size(max = 255)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Column(name = "defaut")
    private boolean defaut;
    @Size(max = 255)
    @Column(name = "comptePresta")
    private String comptePresta;
    @Size(max = 255)
    @Column(name = "compteTiers")
    private String compteTiers;
    @Basic(optional = false)
    @NotNull
    @Column(name = "doubleTva")
    private boolean doubleTva;
    @Size(max = 255)
    @Column(name = "libelleTva1")
    private String libelleTva1;
    @Size(max = 255)
    @Column(name = "libelleTva2")
    private String libelleTva2;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valeur2")
    private Double valeur2;
    @Size(max = 255)
    @Column(name = "code2")
    private String code2;
    @OneToMany(mappedBy = "idTva", fetch = FetchType.LAZY)
    private Collection<Sc> scCollection;
    @JoinColumn(name = "idSoc", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Soc idSoc;

    public Tva() {
    }

    public Tva(Long id) {
        this.id = id;
    }

    public Tva(Long id, boolean supprime, double valeur, boolean defaut, boolean doubleTva) {
        this.id = id;
        this.supprime = supprime;
        this.valeur = valeur;
        this.defaut = defaut;
        this.doubleTva = doubleTva;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean getDefaut() {
        return defaut;
    }

    public void setDefaut(boolean defaut) {
        this.defaut = defaut;
    }

    public String getComptePresta() {
        return comptePresta;
    }

    public void setComptePresta(String comptePresta) {
        this.comptePresta = comptePresta;
    }

    public String getCompteTiers() {
        return compteTiers;
    }

    public void setCompteTiers(String compteTiers) {
        this.compteTiers = compteTiers;
    }

    public boolean getDoubleTva() {
        return doubleTva;
    }

    public void setDoubleTva(boolean doubleTva) {
        this.doubleTva = doubleTva;
    }

    public String getLibelleTva1() {
        return libelleTva1;
    }

    public void setLibelleTva1(String libelleTva1) {
        this.libelleTva1 = libelleTva1;
    }

    public String getLibelleTva2() {
        return libelleTva2;
    }

    public void setLibelleTva2(String libelleTva2) {
        this.libelleTva2 = libelleTva2;
    }

    public Double getValeur2() {
        return valeur2;
    }

    public void setValeur2(Double valeur2) {
        this.valeur2 = valeur2;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    @XmlTransient
    public Collection<Sc> getScCollection() {
        return scCollection;
    }

    public void setScCollection(Collection<Sc> scCollection) {
        this.scCollection = scCollection;
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
        if (!(object instanceof Tva)) {
            return false;
        }
        Tva other = (Tva) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.Tva[ id=" + id + " ]";
    }
    
}
