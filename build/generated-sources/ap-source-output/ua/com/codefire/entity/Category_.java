package ua.com.codefire.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ua.com.codefire.entity.Article;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-25T17:05:31")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile SingularAttribute<Category, String> name;
    public static volatile SingularAttribute<Category, Integer> id;
    public static volatile ListAttribute<Category, Article> articles;

}