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
@Table(name = "famille_categorie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FamilleCategorie.findAll", query = "SELECT f FROM FamilleCategorie f"),
    @NamedQuery(name = "FamilleCategorie.findById", query = "SELECT f FROM FamilleCategorie f WHERE f.id = :id"),
    @NamedQuery(name = "FamilleCategorie.findByDateCreation", query = "SELECT f FROM FamilleCategorie f WHERE f.dateCreation = :dateCreation"),
    @NamedQuery(name = "FamilleCategorie.findByDateMaj", query = "SELECT f FROM FamilleCategorie f WHERE f.dateMaj = :dateMaj"),
    @NamedQuery(name = "FamilleCategorie.findByDateSuppressionLogique", query = "SELECT f FROM FamilleCategorie f WHERE f.dateSuppressionLogique = :dateSuppressionLogique"),
    @NamedQuery(name = "FamilleCategorie.findByLibelle", query = "SELECT f FROM FamilleCategorie f WHERE f.libelle = :libelle"),
    @NamedQuery(name = "FamilleCategorie.findBySupprime", query = "SELECT f FROM FamilleCategorie f WHERE f.supprime = :supprime")})
public class FamilleCategorie implements Serializable {

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
    @JoinColumn(name = "idCategorie", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CategorieMateriel idCategorie;
    @JoinColumn(name = "idSoc", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Soc idSoc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFamille", fetch = FetchType.LAZY)
    private Collection<SousFamilleCategorie> sousFamilleCategorieCollection;
    @OneToMany(mappedBy = "idFam", fetch = FetchType.LAZY)
    private Collection<Prestations> prestationsCollection;

    public FamilleCategorie() {
    }

    public FamilleCategorie(Long id) {
        this.id = id;
    }

    public FamilleCategorie(Long id, boolean supprime) {
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

    public boolean getSupprime() {
        return supprime;
    }

    public void setSupprime(boolean supprime) {
        this.supprime = supprime;
    }

    public CategorieMateriel getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(CategorieMateriel idCategorie) {
        this.idCategorie = idCategorie;
    }

    public Soc getIdSoc() {
        return idSoc;
    }

    public void setIdSoc(Soc idSoc) {
        this.idSoc = idSoc;
    }

    @XmlTransient
    public Collection<SousFamilleCategorie> getSousFamilleCategorieCollection() {
        return sousFamilleCategorieCollection;
    }

    public void setSousFamilleCategorieCollection(Collection<SousFamilleCategorie> sousFamilleCategorieCollection) {
        this.sousFamilleCategorieCollection = sousFamilleCategorieCollection;
    }

    @XmlTransient
    public Collection<Prestations> getPrestationsCollection() {
        return prestationsCollection;
    }

    public void setPrestationsCollection(Collection<Prestations> prestationsCollection) {
        this.prestationsCollection = prestationsCollection;
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
        if (!(object instanceof FamilleCategorie)) {
            return false;
        }
        FamilleCategorie other = (FamilleCategorie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.FamilleCategorie[ id=" + id + " ]";
    }
    
}
