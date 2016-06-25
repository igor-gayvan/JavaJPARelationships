/*
 * Copyright (C) 2016 CodeFireUA <edu@codefire.com.ua>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ua.com.codefire;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import ua.com.codefire.entity.Author;
import ua.com.codefire.entity.User;

/**
 *
 * @author CodeFireUA <edu@codefire.com.ua>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Connection
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MainPU");
        // Statement
        EntityManager manager = factory.createEntityManager();

        TypedQuery<User> query = manager.createQuery("SELECT u FROM User u", User.class);
        List<User> usersList = query.getResultList();

        for (User user : usersList) {
            System.out.printf("#%d %s\n", user.getId(), user.getName());
            
            Author author = user.getAuthor();
            
            if (author != null) {
                System.out.printf(" Author [%s (#%d)]\n", author.getName(), author.getId());
            }
        }
        
        System.out.println(" OTO: ");
        
        User foundUser = manager.find(User.class, 1);
        Author foundAuthor = manager.find(Author.class, 1);
        
        System.out.println(foundUser.getAuthor());
        
        manager.getTransaction().begin();
        
        // If author have author (release)
        if (foundUser.getAuthor() != null) {
            Author author = foundUser.getAuthor();
            author.setUser(null);
            
            manager.merge(author);
            manager.flush();
        }
        
        foundAuthor.setUser(foundUser);
        
        manager.merge(foundAuthor);
        
        manager.getTransaction().commit();
        
        manager.refresh(foundUser);
        
        System.out.println(foundUser.getAuthor());

        manager.close();

        factory.close();

    }

}
