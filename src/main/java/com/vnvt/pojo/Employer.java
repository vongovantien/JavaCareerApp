/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnvt.pojo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 18510
 */
@Entity
@Table(name = "employer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employer.findAll", query = "SELECT e FROM Employer e"),
    @NamedQuery(name = "Employer.findById", query = "SELECT e FROM Employer e WHERE e.id = :id"),
    @NamedQuery(name = "Employer.findByName", query = "SELECT e FROM Employer e WHERE e.name = :name"),
    @NamedQuery(name = "Employer.findByCreatedDate", query = "SELECT e FROM Employer e WHERE e.createdDate = :createdDate"),
    @NamedQuery(name = "Employer.findByUpdatedDate", query = "SELECT e FROM Employer e WHERE e.updatedDate = :updatedDate"),
    @NamedQuery(name = "Employer.findByLocation", query = "SELECT e FROM Employer e WHERE e.location = :location"),
    @NamedQuery(name = "Employer.findByAddress", query = "SELECT e FROM Employer e WHERE e.address = :address"),
    @NamedQuery(name = "Employer.findByContactName", query = "SELECT e FROM Employer e WHERE e.contactName = :contactName"),
    @NamedQuery(name = "Employer.findByContactEmail", query = "SELECT e FROM Employer e WHERE e.contactEmail = :contactEmail"),
    @NamedQuery(name = "Employer.findByLogo", query = "SELECT e FROM Employer e WHERE e.logo = :logo"),
    @NamedQuery(name = "Employer.findByActive", query = "SELECT e FROM Employer e WHERE e.active = :active")})
public class Employer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;
    @Size(max = 100)
    @Column(name = "location")
    private String location;
    @Size(max = 100)
    @Column(name = "address")
    private String address;
    @Size(max = 50)
    @Column(name = "contact_name")
    private String contactName;
    @Size(max = 50)
    @Column(name = "contact_email")
    private String contactEmail;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "info_employer")
    private String infoEmployer;
    @Size(max = 100)
    @Column(name = "logo")
    private String logo;
    @Column(name = "active")
    private Boolean active;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employerId")
    private Collection<Post> postCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employerId")
    private Collection<Comment> commentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employerId")
    private Collection<EmployerTag> employerTagCollection;

    public Employer() {
    }

    public Employer(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getInfoEmployer() {
        return infoEmployer;
    }

    public void setInfoEmployer(String infoEmployer) {
        this.infoEmployer = infoEmployer;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @XmlTransient
    public Collection<Post> getPostCollection() {
        return postCollection;
    }

    public void setPostCollection(Collection<Post> postCollection) {
        this.postCollection = postCollection;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    @XmlTransient
    public Collection<EmployerTag> getEmployerTagCollection() {
        return employerTagCollection;
    }

    public void setEmployerTagCollection(Collection<EmployerTag> employerTagCollection) {
        this.employerTagCollection = employerTagCollection;
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
        if (!(object instanceof Employer)) {
            return false;
        }
        Employer other = (Employer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vnvt.pojo.Employer[ id=" + id + " ]";
    }
    
}
