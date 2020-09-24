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
@Table(name = "sous_famille_categorie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SousFamilleCategorie.findAll", query = "SELECT s FROM SousFamilleCategorie s"),
    @NamedQuery(name = "SousFamilleCategorie.findById", query = "SELECT s FROM SousFamilleCategorie s WHERE s.id = :id"),
    @NamedQuery(name = "SousFamilleCategorie.findByDateCreation", query = "SELECT s FROM SousFamilleCategorie s WHERE s.dateCreation = :dateCreation"),
    @NamedQuery(name = "SousFamilleCategorie.findByDateMaj", query = "SELECT s FROM SousFamilleCategorie s WHERE s.dateMaj = :dateMaj"),
    @NamedQuery(name = "SousFamilleCategorie.findByDateSuppressionLogique", query = "SELECT s FROM SousFamilleCategorie s WHERE s.dateSuppressionLogique = :dateSuppressionLogique"),
    @NamedQuery(name = "SousFamilleCategorie.findByLibelle", query = "SELECT s FROM SousFamilleCategorie s WHERE s.libelle = :libelle"),
    @NamedQuery(name = "SousFamilleCategorie.findBySupprime", query = "SELECT s FROM SousFamilleCategorie s WHERE s.supprime = :supprime")})
public class SousFamilleCategorie implements Serializable {

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
    @JoinColumn(name = "idFamille", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private FamilleCategorie idFamille;
    @JoinColumn(name = "idSoc", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Soc idSoc;
    @OneToMany(mappedBy = "idSousFam", fetch = FetchType.LAZY)
    private Collection<Prestations> prestationsCollection;

    public SousFamilleCategorie() {
    }

    public SousFamilleCategorie(Long id) {
        this.id = id;
    }

    public SousFamilleCategorie(Long id, boolean supprime) {
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

    public FamilleCategorie getIdFamille() {
        return idFamille;
    }

    public void setIdFamille(FamilleCategorie idFamille) {
        this.idFamille = idFamille;
    }

    public Soc getIdSoc() {
        return idSoc;
    }

    public void setIdSoc(Soc idSoc) {
        this.idSoc = idSoc;
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
        if (!(object instanceof SousFamilleCategorie)) {
            return false;
        }
        SousFamilleCategorie other = (SousFamilleCategorie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.SousFamilleCategorie[ id=" + id + " ]";
    }
    
}
