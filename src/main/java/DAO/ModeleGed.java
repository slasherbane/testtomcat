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
@Table(name = "modele_ged")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModeleGed.findAll", query = "SELECT m FROM ModeleGed m"),
    @NamedQuery(name = "ModeleGed.findById", query = "SELECT m FROM ModeleGed m WHERE m.id = :id"),
    @NamedQuery(name = "ModeleGed.findByContentType", query = "SELECT m FROM ModeleGed m WHERE m.contentType = :contentType"),
    @NamedQuery(name = "ModeleGed.findByDateCreation", query = "SELECT m FROM ModeleGed m WHERE m.dateCreation = :dateCreation"),
    @NamedQuery(name = "ModeleGed.findByDateMaj", query = "SELECT m FROM ModeleGed m WHERE m.dateMaj = :dateMaj"),
    @NamedQuery(name = "ModeleGed.findByDateSuppressionLogique", query = "SELECT m FROM ModeleGed m WHERE m.dateSuppressionLogique = :dateSuppressionLogique"),
    @NamedQuery(name = "ModeleGed.findByLibelle", query = "SELECT m FROM ModeleGed m WHERE m.libelle = :libelle"),
    @NamedQuery(name = "ModeleGed.findByNomPieceJointe", query = "SELECT m FROM ModeleGed m WHERE m.nomPieceJointe = :nomPieceJointe"),
    @NamedQuery(name = "ModeleGed.findBySupprime", query = "SELECT m FROM ModeleGed m WHERE m.supprime = :supprime"),
    @NamedQuery(name = "ModeleGed.findByType", query = "SELECT m FROM ModeleGed m WHERE m.type = :type"),
    @NamedQuery(name = "ModeleGed.findByFormat", query = "SELECT m FROM ModeleGed m WHERE m.format = :format"),
    @NamedQuery(name = "ModeleGed.findByCode", query = "SELECT m FROM ModeleGed m WHERE m.code = :code"),
    @NamedQuery(name = "ModeleGed.findByDefaut", query = "SELECT m FROM ModeleGed m WHERE m.defaut = :defaut")})
public class ModeleGed implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "contentType")
    private String contentType;
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
    @Size(max = 255)
    @Column(name = "nomPieceJointe")
    private String nomPieceJointe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "supprime")
    private boolean supprime;
    @Column(name = "type")
    private Integer type;
    @Column(name = "format")
    private Integer format;
    @Size(max = 255)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Column(name = "defaut")
    private boolean defaut;
    @OneToMany(mappedBy = "idModeleFacture", fetch = FetchType.LAZY)
    private Collection<Sc> scCollection;
    @JoinColumn(name = "idCatDevis", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private CatDevis idCatDevis;
    @JoinColumn(name = "idSoc", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Soc idSoc;
    @JoinColumn(name = "idTav", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private TavCt idTav;
    @JoinColumn(name = "idTct", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tct idTct;

    public ModeleGed() {
    }

    public ModeleGed(Long id) {
        this.id = id;
    }

    public ModeleGed(Long id, boolean supprime, boolean defaut) {
        this.id = id;
        this.supprime = supprime;
        this.defaut = defaut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
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

    public String getNomPieceJointe() {
        return nomPieceJointe;
    }

    public void setNomPieceJointe(String nomPieceJointe) {
        this.nomPieceJointe = nomPieceJointe;
    }

    public boolean getSupprime() {
        return supprime;
    }

    public void setSupprime(boolean supprime) {
        this.supprime = supprime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getFormat() {
        return format;
    }

    public void setFormat(Integer format) {
        this.format = format;
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

    @XmlTransient
    public Collection<Sc> getScCollection() {
        return scCollection;
    }

    public void setScCollection(Collection<Sc> scCollection) {
        this.scCollection = scCollection;
    }

    public CatDevis getIdCatDevis() {
        return idCatDevis;
    }

    public void setIdCatDevis(CatDevis idCatDevis) {
        this.idCatDevis = idCatDevis;
    }

    public Soc getIdSoc() {
        return idSoc;
    }

    public void setIdSoc(Soc idSoc) {
        this.idSoc = idSoc;
    }

    public TavCt getIdTav() {
        return idTav;
    }

    public void setIdTav(TavCt idTav) {
        this.idTav = idTav;
    }

    public Tct getIdTct() {
        return idTct;
    }

    public void setIdTct(Tct idTct) {
        this.idTct = idTct;
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
        if (!(object instanceof ModeleGed)) {
            return false;
        }
        ModeleGed other = (ModeleGed) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.ModeleGed[ id=" + id + " ]";
    }
    
}
