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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
 * @author 18510
 */
@Entity
@Table(name = "post")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Post.findAll", query = "SELECT p FROM Post p"),
    @NamedQuery(name = "Post.findById", query = "SELECT p FROM Post p WHERE p.id = :id"),
    @NamedQuery(name = "Post.findByName", query = "SELECT p FROM Post p WHERE p.name = :name"),
    @NamedQuery(name = "Post.findByActive", query = "SELECT p FROM Post p WHERE p.active = :active"),
    @NamedQuery(name = "Post.findByCreatedDate", query = "SELECT p FROM Post p WHERE p.createdDate = :createdDate"),
    @NamedQuery(name = "Post.findByUpdatedDate", query = "SELECT p FROM Post p WHERE p.updatedDate = :updatedDate"),
    @NamedQuery(name = "Post.findByPosition", query = "SELECT p FROM Post p WHERE p.position = :position"),
    @NamedQuery(name = "Post.findByLocation", query = "SELECT p FROM Post p WHERE p.location = :location"),
    @NamedQuery(name = "Post.findBySalary", query = "SELECT p FROM Post p WHERE p.salary = :salary"),
    @NamedQuery(name = "Post.findByExperience", query = "SELECT p FROM Post p WHERE p.experience = :experience"),
    @NamedQuery(name = "Post.findByQuantity", query = "SELECT p FROM Post p WHERE p.quantity = :quantity"),
    @NamedQuery(name = "Post.findByHideBegin", query = "SELECT p FROM Post p WHERE p.hideBegin = :hideBegin"),
    @NamedQuery(name = "Post.findByHideEnd", query = "SELECT p FROM Post p WHERE p.hideEnd = :hideEnd")})
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;
    @Size(max = 100)
    @Column(name = "position")
    private String position;
    @Size(max = 100)
    @Column(name = "location")
    private String location;
    @Size(max = 100)
    @Column(name = "salary")
    private String salary;
    @Size(max = 100)
    @Column(name = "experience")
    private String experience;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "hide_begin")
    @Temporal(TemporalType.DATE)
    private Date hideBegin;
    @Column(name = "hide_end")
    @Temporal(TemporalType.DATE)
    private Date hideEnd;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "benefit")
    private String benefit;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "requirement")
    private String requirement;
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Category categoryId;
    @JoinColumn(name = "employer_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employer employerId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postId")
    private Collection<PostTag> postTagCollection;

    public Post() {
    }

    public Post(Integer id) {
        this.id = id;
    }

    public Post(Integer id, String name, boolean active, Date createdDate, Date updatedDate) {
        this.id = id;
        this.name = name;
        this.active = active;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
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

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getHideBegin() {
        return hideBegin;
    }

    public void setHideBegin(Date hideBegin) {
        this.hideBegin = hideBegin;
    }

    public Date getHideEnd() {
        return hideEnd;
    }

    public void setHideEnd(Date hideEnd) {
        this.hideEnd = hideEnd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBenefit() {
        return benefit;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    @XmlTransient
    public Collection<PostTag> getPostTagCollection() {
        return postTagCollection;
    }

    public void setPostTagCollection(Collection<PostTag> postTagCollection) {
        this.postTagCollection = postTagCollection;
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
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vnvt.pojo.Post[ id=" + id + " ]";
    }

    /**
     * @return the categoryId
     */
    public Category getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return the employerId
     */
    public Employer getEmployerId() {
        return employerId;
    }

    /**
     * @param employerId the employerId to set
     */
    public void setEmployerId(Employer employerId) {
        this.employerId = employerId;
    }

}
