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
@Table(name = "cat_pro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatPro.findAll", query = "SELECT c FROM CatPro c"),
    @NamedQuery(name = "CatPro.findById", query = "SELECT c FROM CatPro c WHERE c.id = :id"),
    @NamedQuery(name = "CatPro.findByDateCreation", query = "SELECT c FROM CatPro c WHERE c.dateCreation = :dateCreation"),
    @NamedQuery(name = "CatPro.findByDateMaj", query = "SELECT c FROM CatPro c WHERE c.dateMaj = :dateMaj"),
    @NamedQuery(name = "CatPro.findByDateSuppressionLogique", query = "SELECT c FROM CatPro c WHERE c.dateSuppressionLogique = :dateSuppressionLogique"),
    @NamedQuery(name = "CatPro.findByLibelle", query = "SELECT c FROM CatPro c WHERE c.libelle = :libelle"),
    @NamedQuery(name = "CatPro.findByReglementation", query = "SELECT c FROM CatPro c WHERE c.reglementation = :reglementation"),
    @NamedQuery(name = "CatPro.findBySupprime", query = "SELECT c FROM CatPro c WHERE c.supprime = :supprime")})
public class CatPro implements Serializable {

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
    @Size(max = 255)
    @Column(name = "reglementation")
    private String reglementation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "supprime")
    private boolean supprime;
    @OneToMany(mappedBy = "idCatPro", fetch = FetchType.LAZY)
    private Collection<Candidatsalarie> candidatsalarieCollection;

    public CatPro() {
    }

    public CatPro(Long id) {
        this.id = id;
    }

    public CatPro(Long id, boolean supprime) {
        this.id = id;
        this.supprime = supprime;
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

    public String getReglementation() {
        return reglementation;
    }

    public void setReglementation(String reglementation) {
        this.reglementation = reglementation;
    }

    public boolean getSupprime() {
        return supprime;
    }

    public void setSupprime(boolean supprime) {
        this.supprime = supprime;
    }

    @XmlTransient
    public Collection<Candidatsalarie> getCandidatsalarieCollection() {
        return candidatsalarieCollection;
    }

    public void setCandidatsalarieCollection(Collection<Candidatsalarie> candidatsalarieCollection) {
        this.candidatsalarieCollection = candidatsalarieCollection;
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
        if (!(object instanceof CatPro)) {
            return false;
        }
        CatPro other = (CatPro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.CatPro[ id=" + id + " ]";
    }
    
}
