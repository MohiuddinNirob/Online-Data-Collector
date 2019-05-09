/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ftdca;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Mehedi Hasan
 */
public class GetCredentials {
     //Credentials
    private static String Email, Password;  //user
    private static String ConsumerKey, ConsumerKeySecret, AccessToken, AccessTokenSecret; //Twitter
    private static String AppId, AppSecret; //Facebook
    
    //for database
    Connection cn=null;
    Statement stmt=null;
    ResultSet res=null;
    String driver="com.mysql.jdbc.Driver";
    String url="jdbc:mysql://localhost:3306/ftdca";
    
    
    public boolean Get(String Mail, String Pass){
        try{
            //creating connection
            cn=DriverManager.getConnection(url,"root","");         
            //create statement
            stmt=cn.createStatement();

            String query="SELECT *  FROM `registration` WHERE `Email` = '"+Mail+"' AND `Password` = '"+Pass+"'";
            res=stmt.executeQuery(query);
            
            while(res.next()) {
                Email=res.getString("Email");
                Password=res.getString("Password");
                ConsumerKey = res.getString("ConsumerKey");
                ConsumerKeySecret = res.getString("ConsumerKeySecret");
                AccessToken = res.getString("AccessToken");
                AccessTokenSecret = res.getString("AccessTokenSecret");
                AppId = res.getString("AppId");
                AppSecret = res.getString("AppSecret");
            }
            
            if(Email.equals(Mail) && Password.equals(Pass)){
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public static String GetEmail(){
        return Email;
    }
    public static String GetPassword(){
        return Password;
    }
    public static String GetConsumerKey(){
        return ConsumerKey;
    }
    public static String GetConsumerKeySecret(){
        return ConsumerKeySecret;
    }
    public static String GetAccessToken(){
        return AccessToken;
    }
    public static String GetAccessTokenSecret(){
        return AccessTokenSecret;
    }
    public static String GetAppId(){
        return AppId;
    }
    public static String GetAppSecret(){
        return AppSecret;
    } 
}
