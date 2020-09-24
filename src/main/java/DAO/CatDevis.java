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
@Table(name = "cat_devis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatDevis.findAll", query = "SELECT c FROM CatDevis c"),
    @NamedQuery(name = "CatDevis.findById", query = "SELECT c FROM CatDevis c WHERE c.id = :id"),
    @NamedQuery(name = "CatDevis.findByCode", query = "SELECT c FROM CatDevis c WHERE c.code = :code"),
    @NamedQuery(name = "CatDevis.findByDateCreation", query = "SELECT c FROM CatDevis c WHERE c.dateCreation = :dateCreation"),
    @NamedQuery(name = "CatDevis.findByDateMaj", query = "SELECT c FROM CatDevis c WHERE c.dateMaj = :dateMaj"),
    @NamedQuery(name = "CatDevis.findByDateSuppression", query = "SELECT c FROM CatDevis c WHERE c.dateSuppression = :dateSuppression"),
    @NamedQuery(name = "CatDevis.findByLibelle", query = "SELECT c FROM CatDevis c WHERE c.libelle = :libelle"),
    @NamedQuery(name = "CatDevis.findBySupprime", query = "SELECT c FROM CatDevis c WHERE c.supprime = :supprime"),
    @NamedQuery(name = "CatDevis.findByType", query = "SELECT c FROM CatDevis c WHERE c.type = :type"),
    @NamedQuery(name = "CatDevis.findByIdBaseCalcul", query = "SELECT c FROM CatDevis c WHERE c.idBaseCalcul = :idBaseCalcul"),
    @NamedQuery(name = "CatDevis.findByPreavisChatel", query = "SELECT c FROM CatDevis c WHERE c.preavisChatel = :preavisChatel")})
public class CatDevis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "code")
    private String code;
    @Column(name = "dateCreation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "dateMaj")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateMaj;
    @Column(name = "dateSuppression")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSuppression;
    @Size(max = 255)
    @Column(name = "libelle")
    private String libelle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "supprime")
    private boolean supprime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "type")
    private int type;
    @Column(name = "idBaseCalcul")
    private Integer idBaseCalcul;
    @Column(name = "preavisChatel")
    private Integer preavisChatel;
    @OneToMany(mappedBy = "idCatDevis", fetch = FetchType.LAZY)
    private Collection<ModeleGed> modeleGedCollection;
    @JoinColumn(name = "idPrestation", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Prestations idPrestation;
    @JoinColumn(name = "idSoc", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Soc idSoc;

    public CatDevis() {
    }

    public CatDevis(Long id) {
        this.id = id;
    }

    public CatDevis(Long id, boolean supprime, int type) {
        this.id = id;
        this.supprime = supprime;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Integer getIdBaseCalcul() {
        return idBaseCalcul;
    }

    public void setIdBaseCalcul(Integer idBaseCalcul) {
        this.idBaseCalcul = idBaseCalcul;
    }

    public Integer getPreavisChatel() {
        return preavisChatel;
    }

    public void setPreavisChatel(Integer preavisChatel) {
        this.preavisChatel = preavisChatel;
    }

    @XmlTransient
    public Collection<ModeleGed> getModeleGedCollection() {
        return modeleGedCollection;
    }

    public void setModeleGedCollection(Collection<ModeleGed> modeleGedCollection) {
        this.modeleGedCollection = modeleGedCollection;
    }

    public Prestations getIdPrestation() {
        return idPrestation;
    }

    public void setIdPrestation(Prestations idPrestation) {
        this.idPrestation = idPrestation;
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
        if (!(object instanceof CatDevis)) {
            return false;
        }
        CatDevis other = (CatDevis) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.CatDevis[ id=" + id + " ]";
    }
    
}
