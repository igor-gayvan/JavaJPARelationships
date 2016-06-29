package ua.com.codefire.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ua.com.codefire.entity.Article;
import ua.com.codefire.entity.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-30T00:29:01")
@StaticMetamodel(Author.class)
public class Author_ { 

    public static volatile SingularAttribute<Author, String> name;
    public static volatile SingularAttribute<Author, Integer> id;
    public static volatile SingularAttribute<Author, User> user;
    public static volatile ListAttribute<Author, Article> articles;

}