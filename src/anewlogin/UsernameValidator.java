package anewlogin;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class UsernameValidator {
   
    public static String validateUsername(String username) {
        if (username.contains("_") && username.length() <= 5){
            return "Username successfully captured";
        }else{
            return "Username is not correctly formatted, please ensure that username contains an underscore and is no more than 5 characters in length";
        }
    }
}
