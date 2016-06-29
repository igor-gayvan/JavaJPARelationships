package ua.com.codefire.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ua.com.codefire.entity.Author;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-30T00:29:01")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, Author> author;
    public static volatile SingularAttribute<User, String> name;
    public static volatile SingularAttribute<User, Integer> id;

}