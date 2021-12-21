package com.vnvt.pojo;

import com.vnvt.pojo.Comment;
import com.vnvt.pojo.EmployerTag;
import com.vnvt.pojo.Post;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-12-22T01:03:31")
@StaticMetamodel(Employer.class)
public class Employer_ { 

    public static volatile SingularAttribute<Employer, String> address;
    public static volatile CollectionAttribute<Employer, EmployerTag> employerTagCollection;
    public static volatile SingularAttribute<Employer, String> contactEmail;
    public static volatile SingularAttribute<Employer, String> contactName;
    public static volatile SingularAttribute<Employer, String> infoEmployer;
    public static volatile CollectionAttribute<Employer, Comment> commentCollection;
    public static volatile SingularAttribute<Employer, Boolean> active;
    public static volatile SingularAttribute<Employer, Date> updatedDate;
    public static volatile SingularAttribute<Employer, Date> createdDate;
    public static volatile CollectionAttribute<Employer, Post> postCollection;
    public static volatile SingularAttribute<Employer, String> name;
    public static volatile SingularAttribute<Employer, String> logo;
    public static volatile SingularAttribute<Employer, String> location;
    public static volatile SingularAttribute<Employer, Integer> id;

}