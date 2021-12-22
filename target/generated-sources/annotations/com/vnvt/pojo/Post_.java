package com.vnvt.pojo;

import com.vnvt.pojo.Category;
import com.vnvt.pojo.Employer;
import com.vnvt.pojo.PostTag;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-12-22T23:39:04")
@StaticMetamodel(Post.class)
public class Post_ { 

    public static volatile CollectionAttribute<Post, PostTag> postTagCollection;
    public static volatile SingularAttribute<Post, Integer> quantity;
    public static volatile SingularAttribute<Post, Date> hideBegin;
    public static volatile SingularAttribute<Post, Boolean> active;
    public static volatile SingularAttribute<Post, String> description;
    public static volatile SingularAttribute<Post, Date> updatedDate;
    public static volatile SingularAttribute<Post, String> requirement;
    public static volatile SingularAttribute<Post, String> salary;
    public static volatile SingularAttribute<Post, String> experience;
    public static volatile SingularAttribute<Post, String> benefit;
    public static volatile SingularAttribute<Post, Employer> employerId;
    public static volatile SingularAttribute<Post, Date> createdDate;
    public static volatile SingularAttribute<Post, String> name;
    public static volatile SingularAttribute<Post, String> location;
    public static volatile SingularAttribute<Post, Integer> id;
    public static volatile SingularAttribute<Post, String> position;
    public static volatile SingularAttribute<Post, Date> hideEnd;
    public static volatile SingularAttribute<Post, Category> categoryId;

}