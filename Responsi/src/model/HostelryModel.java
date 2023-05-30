/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

        
/**
 *
 * @author User
 */
public class HostelryModel {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/librarymanagementsystem";
    static final String USER = "root";
    static final String PASS = ""; 
    public Connection connection;
    public Statement statement;
    public HostelryModel() {
        try{
            Class.forName(JDBC_DRIVER);
            connection = (java.sql.Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected successfully!");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Failed to connect!");
        }}
    
   public boolean loginAdmin(String username, String password){
        try{
            String query = "Select COUNT(*) as total from admin WHERE username='"+username+"' and password=BINARY '"+password+"'";
            statement = connection.createStatement();
            ResultSet result=statement.executeQuery(query);
            while(result.next())
            {
                if(result.getString("total").equals("1"))
                {
                    return true;
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }
    public boolean loginUser(String username, String password){
        try{
            String query = "Select COUNT(*) as total from user WHERE username='"+username+"' and password=BINARY '"+password+"'";
            statement = connection.createStatement();
            ResultSet result=statement.executeQuery(query);
            while(result.next())
            {
                if(result.getString("total").equals("1"))
                {
                    return true;
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }
    public boolean usernameCheck(String username){
        try{
            String query = "Select COUNT(*) as total from user WHERE username='"+username+"'";
            statement = connection.createStatement();
            ResultSet result=statement.executeQuery(query);
            while(result.next())
            {
                if(result.getString("total").equals("1"))
                {
                    return false;
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return true;
    }
  
 
   
    public void deleteRenter(int id){
        try{
            String query = "DELETE from user WHERE renter_id='"+id+"'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Delete user success");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public void updateRenter (int id){
        try {
            String query1 = "UPDATE status SET available="+1+" WHERE renter_id="+id;
            statement = connection.createStatement();
            statement.executeUpdate(query1);
            JOptionPane.showMessageDialog(null,"Success!");
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } 
    }
  public int numOfUserRenter(String username){
        int totaldata=0;
        try{
            String query = "Select * from renter";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query); 
            while(resultSet.next()){
                totaldata++; 
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return totaldata;
    }
    public String[][] readAllRenter(){
        String[][] data=new String[numOfAllRent()][7];
        try{
            int totaldata = 0;
            String query = "Select * from renter";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                data[totaldata][0] = resultSet.getString("renter_id"); 
                data[totaldata][1] = resultSet.getString("name"); 
                data[totaldata][2] = resultSet.getString("contact"); 
                data[totaldata][3] = resultSet.getString("duration"); 
                data[totaldata][4] = resultSet.getString("bill"); 
                data[totaldata][5] = resultSet.getString("room");
                if(resultSet.getString("status").equals("1")){
                    data[totaldata][5] = "Paid";
                }
                else{
                    data[totaldata][5] = "notPaid";
                }
                totaldata++; 
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return data;
    }
    public int numOfAllRenter(){
        int totaldata=0;
        try{
            String query = "Select * from renter";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query); 
            while(resultSet.next()){
                totaldata++; 
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return totaldata;
    }

    private int numOfAllRent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
  
}
