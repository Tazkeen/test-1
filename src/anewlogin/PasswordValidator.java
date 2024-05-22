/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package anewlogin;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author admin
 */
public class PasswordValidator {
    
    public static String validatePassword(String password) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#\\$%\\^&*+=])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
    
        if (matcher.matches()) {
            return "Password successfully captured";
        }else{
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.";
        }
    }
}