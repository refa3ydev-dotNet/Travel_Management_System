/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tms.manager;

import java.util.ArrayList;
import java.util.List;
import tms.model.User;

/**
 *
 * @author 3mora
 */
public class UserProfileManager {
    private static UserProfileManager Instance;
    private List<User> users;
    
    private UserProfileManager(){
        users=new ArrayList<>();
    }
    
    public static UserProfileManager getInstance(){
        if(Instance == null){
            Instance=new UserProfileManager();
        }
        return Instance;
    }
    
    public User addUser(User user){
        if (user == null){
            return null;
        }
        users.add(user);
        return user;
    }
    
    public User getUserById(int Id){
        for (User u: users){
            if (u.getId()==Id) {
                return u;
            }
        }
        return null;
    }
    public void addPointsToUser(int Id, int points)
    {
        User u = getUserById(Id);
        if(u!=null){
            u.AddPoints(points);
        }
    }
    public List<User> getUsers(){
        return users;
    }
}
