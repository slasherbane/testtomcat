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
@Table(name = "tav_ct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TavCt.findAll", query = "SELECT t FROM TavCt t"),
    @NamedQuery(name = "TavCt.findById", query = "SELECT t FROM TavCt t WHERE t.id = :id"),
    @NamedQuery(name = "TavCt.findByCode", query = "SELECT t FROM TavCt t WHERE t.code = :code"),
    @NamedQuery(name = "TavCt.findByDateCreation", query = "SELECT t FROM TavCt t WHERE t.dateCreation = :dateCreation"),
    @NamedQuery(name = "TavCt.findByDateMaj", query = "SELECT t FROM TavCt t WHERE t.dateMaj = :dateMaj"),
    @NamedQuery(name = "TavCt.findByDateSuppression", query = "SELECT t FROM TavCt t WHERE t.dateSuppression = :dateSuppression"),
    @NamedQuery(name = "TavCt.findByLibelle", query = "SELECT t FROM TavCt t WHERE t.libelle = :libelle"),
    @NamedQuery(name = "TavCt.findBySupprime", query = "SELECT t FROM TavCt t WHERE t.supprime = :supprime"),
    @NamedQuery(name = "TavCt.findByType", query = "SELECT t FROM TavCt t WHERE t.type = :type")})
public class TavCt implements Serializable {

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
    @JoinColumn(name = "idSoc", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Soc idSoc;
    @JoinColumn(name = "idTypeContrat", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tct idTypeContrat;
    @OneToMany(mappedBy = "idTav", fetch = FetchType.LAZY)
    private Collection<ModeleGed> modeleGedCollection;

    public TavCt() {
    }

    public TavCt(Long id) {
        this.id = id;
    }

    public TavCt(Long id, boolean supprime, int type) {
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

    public Soc getIdSoc() {
        return idSoc;
    }

    public void setIdSoc(Soc idSoc) {
        this.idSoc = idSoc;
    }

    public Tct getIdTypeContrat() {
        return idTypeContrat;
    }

    public void setIdTypeContrat(Tct idTypeContrat) {
        this.idTypeContrat = idTypeContrat;
    }

    @XmlTransient
    public Collection<ModeleGed> getModeleGedCollection() {
        return modeleGedCollection;
    }

    public void setModeleGedCollection(Collection<ModeleGed> modeleGedCollection) {
        this.modeleGedCollection = modeleGedCollection;
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
        if (!(object instanceof TavCt)) {
            return false;
        }
        TavCt other = (TavCt) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.TavCt[ id=" + id + " ]";
    }
    
}