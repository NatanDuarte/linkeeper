package com.natan.linkeeper.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

// simulated data base
// TO-DO: replace this class for a DataBase integration

public class DataBase {

    private static List<Link> links = new ArrayList<>();
    private static List<User> users = new ArrayList<>();
    private static int id = 0;

    // simulating pre-entered elements in the database
    static {
        Link link1 = new Link("Google", "https://google.com");
        Link link2 = new Link("Youtube", "https://youtube.com");
        Link link3 = new Link("Netflix", "https://netflix.com");
        Link link4 = new Link("Alura", "https://alura.com.br");
        Link link5 = new Link("Twitch", "https://twitch.tv");
        Link link6 = new Link("Kaggle", "https://kaggle.com");

        DataBase.links.add(0, link1);
        link1.setId(DataBase.id++);
        DataBase.links.add(0, link2);
        link2.setId(DataBase.id++);
        DataBase.links.add(0, link3);
        link3.setId(DataBase.id++);
        DataBase.links.add(0, link4);
        link4.setId(DataBase.id++);
        DataBase.links.add(0, link5);
        link5.setId(DataBase.id++);
        DataBase.links.add(0, link6);
        link6.setId(DataBase.id++);

        User admin1 = new User("admin", "admin");
        User admin2 = new User("admin2", "admin2");

        DataBase.users.add(admin1);
        DataBase.users.add(admin2);
    }

    public void INSERT(Link newLink) {
        newLink.setId(DataBase.id++);
        DataBase.links.add(0, newLink);
    }

    public List<Link> SELECT_ALL_LINKS() {
        return DataBase.links;
    }

    public void DELETE_WHERE_ID(int id) {
        for (Iterator<Link> iterator = DataBase.links.iterator(); iterator.hasNext();) {

            Link link = iterator.next();

            if (link.getId() == id)
                iterator.remove();
        }
    }

    public Link SELECT_WHERE_ID(int id) {
        for (Link link : DataBase.links)
            if (link.getId() == id)
                return link;

        return null;
    }

    public User SELECT_USER(String login, String password) {
        for (User user : DataBase.users)
            if (user.matches(login, password))
                return user;

        return null;
    }
}
