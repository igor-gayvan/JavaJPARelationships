package ua.com.codefire.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ua.com.codefire.entity.Author;
import ua.com.codefire.entity.Category;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-26T00:41:41")
@StaticMetamodel(Article.class)
public class Article_ { 

    public static volatile SingularAttribute<Article, Author> author;
    public static volatile SingularAttribute<Article, Integer> id;
    public static volatile ListAttribute<Article, Category> categories;
    public static volatile SingularAttribute<Article, String> title;
    public static volatile SingularAttribute<Article, String> content;
    public static volatile SingularAttribute<Article, Date> timestamp;

}