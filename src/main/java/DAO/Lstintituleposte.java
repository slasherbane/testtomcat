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
@Table(name = "lstintituleposte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lstintituleposte.findAll", query = "SELECT l FROM Lstintituleposte l"),
    @NamedQuery(name = "Lstintituleposte.findById", query = "SELECT l FROM Lstintituleposte l WHERE l.id = :id"),
    @NamedQuery(name = "Lstintituleposte.findByDateCreation", query = "SELECT l FROM Lstintituleposte l WHERE l.dateCreation = :dateCreation"),
    @NamedQuery(name = "Lstintituleposte.findByDateMaj", query = "SELECT l FROM Lstintituleposte l WHERE l.dateMaj = :dateMaj"),
    @NamedQuery(name = "Lstintituleposte.findByDateSuppressionLogique", query = "SELECT l FROM Lstintituleposte l WHERE l.dateSuppressionLogique = :dateSuppressionLogique"),
    @NamedQuery(name = "Lstintituleposte.findByLibelle", query = "SELECT l FROM Lstintituleposte l WHERE l.libelle = :libelle"),
    @NamedQuery(name = "Lstintituleposte.findBySupprime", query = "SELECT l FROM Lstintituleposte l WHERE l.supprime = :supprime")})
public class Lstintituleposte implements Serializable {

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
    @OneToMany(mappedBy = "idIntPoste", fetch = FetchType.LAZY)
    private Collection<Candidatsalarie> candidatsalarieCollection;
    @JoinColumn(name = "idDept", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Dept idDept;
    @JoinColumn(name = "idService", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Service idService;
    @JoinColumn(name = "idSoc", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Soc idSoc;

    public Lstintituleposte() {
    }

    public Lstintituleposte(Long id) {
        this.id = id;
    }

    public Lstintituleposte(Long id, boolean supprime) {
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

    @XmlTransient
    public Collection<Candidatsalarie> getCandidatsalarieCollection() {
        return candidatsalarieCollection;
    }

    public void setCandidatsalarieCollection(Collection<Candidatsalarie> candidatsalarieCollection) {
        this.candidatsalarieCollection = candidatsalarieCollection;
    }

    public Dept getIdDept() {
        return idDept;
    }

    public void setIdDept(Dept idDept) {
        this.idDept = idDept;
    }

    public Service getIdService() {
        return idService;
    }

    public void setIdService(Service idService) {
        this.idService = idService;
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
        if (!(object instanceof Lstintituleposte)) {
            return false;
        }
        Lstintituleposte other = (Lstintituleposte) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.Lstintituleposte[ id=" + id + " ]";
    }
    
}
