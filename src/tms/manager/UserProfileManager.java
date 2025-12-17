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
    private static UserProfileManager instance;
    private List<User> users;
    
    private UserProfileManager(){
        users=new ArrayList<>();
    }
    
    public static UserProfileManager getInstance(){
        if(instance == null){
            instance=new UserProfileManager();
        }
        return instance;
    }
    
    public User addUser(User user){
        if (user == null){
            System.out.println("Sorry we can't add null user");
            return null;
        }
        if(getUserById(user.getId()) != null){
            System.err.println("user with Id "+ user.getId() + " already exist");
            return null;
        }
        users.add(user);
        System.out.println("we added user "+ user.getName()+" suceessfully");
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
        if (points <0){
            System.out.println("please add positive number");
            return ;
        }
        User u = getUserById(Id);
        if(u!=null){
            u.addPoints(points);
        }
    }
    public List<User> getUsers(){
        return new ArrayList<>(users);
    }
    public boolean deleteUser(int id){
        User user= getUserById(id);
        if (user!=null){
            users.remove(user);
            System.out.println("we deleted user "+user.getName()+ " successfully");
            return true;
        }
            System.err.println("user with id "+ id +" is not found");
        
        return false;
    }
}
