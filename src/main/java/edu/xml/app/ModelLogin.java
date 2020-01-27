package edu.xml.app;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import edu.xml.helpers.Users;
import edu.xml.helpers.Users.User;

public class ModelLogin {
    File userFile;
    Users userDB;
    List<User> users;
    User lastTry;
    String username;
    int level;

    public ModelLogin() {
        try {
            userFile = new File("Users.xml");
            JAXBContext jc = JAXBContext.newInstance("edu.xml.helpers");
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            userDB = (Users) unmarshaller.unmarshal(userFile);
            users = userDB.getUser();
            lastTry = new User();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean connect(String username, String password) {
        try {
            Thread.sleep(2000);
            if (!lastTry.getName().equals(username)) {
                for (User user : users) {
                    if (user.getName().equals(username)) {
                        lastTry = user;
                    }
                }
            }
            if (lastTry.getPassword().equals(password)) {
                username = lastTry.getName();
                level = lastTry.getLevel();
                return true;
            } else {
                return false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void createUser(String username, String password, int level) {
        User user = new User();
        user.setLevel((byte) level);
        user.setName(username);
        user.setPassword(password);
    }

    public int getLevel() {
        return new Integer(level);
    }

    public String getUsername() {
        return new String(username);
    }
}