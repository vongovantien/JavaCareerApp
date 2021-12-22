/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnvt.repository.impl;

import com.vnvt.pojo.Post;
import com.vnvt.pojo.Comment;
import com.vnvt.repository.PostRepository;
import java.util.List;
import org.hibernate.query.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 18510
 */
@Repository
@Transactional
public class PostRepositoryImpl implements PostRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Post> getPosts(String kw, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Post> query = builder.createQuery(Post.class);
        Root root = query.from(Post.class);
        query = query.select(root);

        if (kw != null) {
            Predicate p = builder.like(root.get("name").as(String.class),
                    String.format("%%%s%%", kw));
            query = query.where(p);
        }

        query = query.orderBy(builder.desc(root.get("id")));

        Query q = session.createQuery(query);

        int max = 9;
        q.setMaxResults(max);
        q.setFirstResult((page - 1) * max);

        return q.getResultList();
    }

    @Override
    public boolean addOrUpdate(Post prdct) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(prdct);

            return true;
        } catch (Exception ex) {
            System.err.println("== ADD PRODUCT ERRPR ==" + ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public long countPost() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("Select Count(*) From Post");

        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public Post getPostById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Post.class, id);
    }

    @Override
    public List<Object[]> getHotPosts(int num) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root rootP = query.from(Post.class);


        query.multiselect(rootP.get("id"), rootP.get("name"),
                rootP.get("price"), rootP.get("image"),
                builder.count(rootP.get("id")));

        query = query.groupBy(rootP.get("id"));
        query = query.orderBy(builder.desc(builder.count(rootP.get("id"))));

        Query q = session.createQuery(query);
        q.setMaxResults(num);

        return q.getResultList();
    }

    @Override
    public List<Object[]> getMostDiscussPosts(int num) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root rootP = query.from(Post.class);
        Root rootC = query.from(Comment.class);

        query = query.where(builder.equal(rootC.get("product"), rootP.get("id")));
        query.multiselect(rootP.get("id"), rootP.get("name"),
                rootP.get("price"), rootP.get("image"),
                builder.count(rootP.get("id")));

        query = query.groupBy(rootP.get("id"));
        query = query.orderBy(builder.desc(builder.count(rootP.get("id"))),
                builder.desc(rootP.get("id")));

        Query q = session.createQuery(query);
        q.setMaxResults(num);

        return q.getResultList();
    }
}
