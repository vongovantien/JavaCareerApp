package com.vnvt.pojo;

import com.vnvt.pojo.EmployerTag;
import com.vnvt.pojo.PostTag;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-12-22T23:39:04")
@StaticMetamodel(Tag.class)
public class Tag_ { 

    public static volatile CollectionAttribute<Tag, PostTag> postTagCollection;
    public static volatile CollectionAttribute<Tag, EmployerTag> employerTagCollection;
    public static volatile SingularAttribute<Tag, String> name;
    public static volatile SingularAttribute<Tag, Integer> id;

}