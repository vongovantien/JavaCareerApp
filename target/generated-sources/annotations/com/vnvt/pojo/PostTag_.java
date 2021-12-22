package com.vnvt.pojo;

import com.vnvt.pojo.Post;
import com.vnvt.pojo.Tag;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-12-22T23:39:04")
@StaticMetamodel(PostTag.class)
public class PostTag_ { 

    public static volatile SingularAttribute<PostTag, Tag> tagId;
    public static volatile SingularAttribute<PostTag, Integer> id;
    public static volatile SingularAttribute<PostTag, Post> postId;

}