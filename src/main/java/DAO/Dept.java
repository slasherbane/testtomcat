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
@Table(name = "dept")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dept.findAll", query = "SELECT d FROM Dept d"),
    @NamedQuery(name = "Dept.findById", query = "SELECT d FROM Dept d WHERE d.id = :id"),
    @NamedQuery(name = "Dept.findByDateCreation", query = "SELECT d FROM Dept d WHERE d.dateCreation = :dateCreation"),
    @NamedQuery(name = "Dept.findByDateMaj", query = "SELECT d FROM Dept d WHERE d.dateMaj = :dateMaj"),
    @NamedQuery(name = "Dept.findByDateSuppressionLogique", query = "SELECT d FROM Dept d WHERE d.dateSuppressionLogique = :dateSuppressionLogique"),
    @NamedQuery(name = "Dept.findByLibelle", query = "SELECT d FROM Dept d WHERE d.libelle = :libelle"),
    @NamedQuery(name = "Dept.findBySupprime", query = "SELECT d FROM Dept d WHERE d.supprime = :supprime")})
public class Dept implements Serializable {

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
    @OneToMany(mappedBy = "idDept", fetch = FetchType.LAZY)
    private Collection<Candidatsalarie> candidatsalarieCollection;
    @JoinColumn(name = "idSoc", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Soc idSoc;
    @OneToMany(mappedBy = "idDept", fetch = FetchType.LAZY)
    private Collection<Lstintituleposte> lstintituleposteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDept", fetch = FetchType.LAZY)
    private Collection<Service> serviceCollection;

    public Dept() {
    }

    public Dept(Long id) {
        this.id = id;
    }

    public Dept(Long id, boolean supprime) {
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

    public Soc getIdSoc() {
        return idSoc;
    }

    public void setIdSoc(Soc idSoc) {
        this.idSoc = idSoc;
    }

    @XmlTransient
    public Collection<Lstintituleposte> getLstintituleposteCollection() {
        return lstintituleposteCollection;
    }

    public void setLstintituleposteCollection(Collection<Lstintituleposte> lstintituleposteCollection) {
        this.lstintituleposteCollection = lstintituleposteCollection;
    }

    @XmlTransient
    public Collection<Service> getServiceCollection() {
        return serviceCollection;
    }

    public void setServiceCollection(Collection<Service> serviceCollection) {
        this.serviceCollection = serviceCollection;
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
        if (!(object instanceof Dept)) {
            return false;
        }
        Dept other = (Dept) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.Dept[ id=" + id + " ]";
    }
    
}
