/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Benjamin
 */
@Entity
@Table(name = "nation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nation.findAll", query = "SELECT n FROM Nation n"),
    @NamedQuery(name = "Nation.findById", query = "SELECT n FROM Nation n WHERE n.id = :id"),
    @NamedQuery(name = "Nation.findByCode", query = "SELECT n FROM Nation n WHERE n.code = :code"),
    @NamedQuery(name = "Nation.findByLibelle", query = "SELECT n FROM Nation n WHERE n.libelle = :libelle"),
    @NamedQuery(name = "Nation.findByNationalite", query = "SELECT n FROM Nation n WHERE n.nationalite = :nationalite")})
public class Nation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 5)
    @Column(name = "code")
    private String code;
    @Size(max = 255)
    @Column(name = "libelle")
    private String libelle;
    @Size(max = 255)
    @Column(name = "nationalite")
    private String nationalite;
    @OneToMany(mappedBy = "idPays", fetch = FetchType.LAZY)
    private Collection<Soc> socCollection;
    @OneToMany(mappedBy = "idPaysCorr", fetch = FetchType.LAZY)
    private Collection<Sc> scCollection;
    @OneToMany(mappedBy = "idPays", fetch = FetchType.LAZY)
    private Collection<Sc> scCollection1;
    @OneToMany(mappedBy = "idPaysLiv", fetch = FetchType.LAZY)
    private Collection<Sc> scCollection2;
    @OneToMany(mappedBy = "idNat", fetch = FetchType.LAZY)
    private Collection<Candidatsalarie> candidatsalarieCollection;
    @OneToMany(mappedBy = "idPays", fetch = FetchType.LAZY)
    private Collection<Candidatsalarie> candidatsalarieCollection1;
    @OneToMany(mappedBy = "idPaysNaissance", fetch = FetchType.LAZY)
    private Collection<Candidatsalarie> candidatsalarieCollection2;
    @OneToMany(mappedBy = "idPays", fetch = FetchType.LAZY)
    private Collection<Client> clientCollection;

    public Nation() {
    }

    public Nation(Long id) {
        this.id = id;
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

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    @XmlTransient
    public Collection<Soc> getSocCollection() {
        return socCollection;
    }

    public void setSocCollection(Collection<Soc> socCollection) {
        this.socCollection = socCollection;
    }

    @XmlTransient
    public Collection<Sc> getScCollection() {
        return scCollection;
    }

    public void setScCollection(Collection<Sc> scCollection) {
        this.scCollection = scCollection;
    }

    @XmlTransient
    public Collection<Sc> getScCollection1() {
        return scCollection1;
    }

    public void setScCollection1(Collection<Sc> scCollection1) {
        this.scCollection1 = scCollection1;
    }

    @XmlTransient
    public Collection<Sc> getScCollection2() {
        return scCollection2;
    }

    public void setScCollection2(Collection<Sc> scCollection2) {
        this.scCollection2 = scCollection2;
    }

    @XmlTransient
    public Collection<Candidatsalarie> getCandidatsalarieCollection() {
        return candidatsalarieCollection;
    }

    public void setCandidatsalarieCollection(Collection<Candidatsalarie> candidatsalarieCollection) {
        this.candidatsalarieCollection = candidatsalarieCollection;
    }

    @XmlTransient
    public Collection<Candidatsalarie> getCandidatsalarieCollection1() {
        return candidatsalarieCollection1;
    }

    public void setCandidatsalarieCollection1(Collection<Candidatsalarie> candidatsalarieCollection1) {
        this.candidatsalarieCollection1 = candidatsalarieCollection1;
    }

    @XmlTransient
    public Collection<Candidatsalarie> getCandidatsalarieCollection2() {
        return candidatsalarieCollection2;
    }

    public void setCandidatsalarieCollection2(Collection<Candidatsalarie> candidatsalarieCollection2) {
        this.candidatsalarieCollection2 = candidatsalarieCollection2;
    }

    @XmlTransient
    public Collection<Client> getClientCollection() {
        return clientCollection;
    }

    public void setClientCollection(Collection<Client> clientCollection) {
        this.clientCollection = clientCollection;
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
        if (!(object instanceof Nation)) {
            return false;
        }
        Nation other = (Nation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.Nation[ id=" + id + " ]";
    }
    
}
