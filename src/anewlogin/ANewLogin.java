/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package anewlogin;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
/**
 * Main class for EasyKanban application.
 * @author admin
 */
public class ANewLogin {

    // Constants for registered username and password
    private static final String registeredUsername = "kyl_1";
    private static final String registeredPassword = "Ch&&sec@ke99!";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //Declaring variables for first name and surname
        String firstName;
        String surname;
        
        // Variable to track login success
        boolean loginSuccess = false;
        
        // Loop until successful login
        while (!loginSuccess) {
            // Prompt for username and password
            
            System.out.println("Enter Username:");
            String username = scanner.nextLine();
            
            System.out.println("Enter Password:");
            String password = scanner.nextLine();
            
            // Validate username and password
            String usernameValidationMessage = UsernameValidator.validateUsername(username);
            String passwordValidationMessage = PasswordValidator.validatePassword(password);
            
            // Check validation messages and login credentials
            if (usernameValidationMessage.equals("Username successfully captured") && passwordValidationMessage.equals("Password successfully captured")) {
                if (username.equals(registeredUsername) && password.equals(registeredPassword)){
                    
                    System.out.println("Login successful!");
                    
                    // Prompt the user to enter their first name and surname after successful login
                    
                    System.out.println("Please enter your first name:");
                    firstName = scanner.nextLine();
                    
                    System.out.println("Please enter your surname:");
                    surname = scanner.nextLine();
                    
                    // Welcome the user
                    
                    WelcomeUser.welcomeUser(firstName, surname);
                    loginSuccess = true; // Set loginSuccess to true to exit loop
                    
                    //Display the Kanban menu
                    
                    displayKanbanMenu(scanner);
                }else{
                
                System.out.println("Incorrect username or password. Please try again."); 
                }
            
            }else{
                
                System.out.println(usernameValidationMessage);
                
                System.out.println(passwordValidationMessage);
                }
            }
        
        scanner.close();
        }
    /**
     * Displays the Kanban menu and handles user choices.
     */
    
    private static void displayKanbanMenu(Scanner scanner) {
        System.out.println("Welcome to EasyKanban");
        boolean running = true;
        
        // Loop until the user chooses to quit
        while (running) {
            // Display menu options
            
            System.out.println("Please choose an option: ");
            System.out.println("1) Add tasks");
            System.out.println("2) Show report");
            System.out.println("3) Quit");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            // Handle menu choices
            switch (choice) {
                case 1:
                    
                    addTasks(scanner);
                    break;
                            case 2:
                                System.out.println("Coming Soon. ");
                                break;
                            case 3:
                                running = false;
                                System.out.println("Exiting application. ");
                                break;
                            default:
                                System.out.println("Invalid option. Please try again. ");
            }
        }
    }
    
    /**
     * Prompts the user to enter task details and displays them in a dialog.
     */
    private static void addTasks(Scanner scanner) {
        System.out.println("How many tasks do you wish to enter?");
        int numTasks = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        // Array to hold tasks
        Task[] tasks = new Task[numTasks];
        
        // Loop to gather task details
        for (int i = 0; i < numTasks; i++) {
            
            System.out.println("Enter details for Task " + (i + 1) + ":");
            
            // Prompt for task name
            
            System.out.println("Task Name:");
            String taskName = scanner.nextLine();
            
            // Prompt for task description
            
            System.out.println("Task Description:");
            String taskDescription = scanner.nextLine();
        while (taskDescription.length() > 50) {
            
            System.out.println("Please enter a task description of less than 50 characters:");
            taskDescription = scanner.nextLine();
        }
        
        System.out.println("Task successfully captured");
        
        // Prompt for developer details
        
        System.out.println("Developer Details (First and Last Name):");
        String developerDetails = scanner.nextLine();
        
        // Prompt for task duration
        
        System.out.println("Task Duration (in hours):");
        int taskDuration = scanner.nextInt();
        scanner.nextLine(); //consume newline
        
        // Prompt for task status
        
        System.out.println("Select Task Status: 1) To Do 2) Doing 3) Done");
        int statusChoice = scanner.nextInt();
                scanner.nextLine(); //consume newline
                
                // Determine task status based on user choice
                
                String taskStatus;
                switch (statusChoice){
                    case 1:
                        taskStatus = "To Do";
                        break;
                    case 2:
                        taskStatus = "Doing";
                        break;
                    case 3:
                        taskStatus = "Done";
                        break;
                    default:
                        taskStatus = "To Do";
                        
        System.out.println("Invalid status. Default to 'To Do'.");                
                }
                // Create a new task and store it in the array
                tasks[i] = new Task(taskName, i, taskDescription, developerDetails, taskDuration, taskStatus);
                
                // Created a JFrame to ensure the dialog appears on top
                JFrame frame = new JFrame();
                
                frame.setAlwaysOnTop(true);
                
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                frame.setVisible(false); // No need to display the frame
                
                // Display task details in a dialog box
                String taskDetails = tasks[i].printTaskDetails();
                
                JOptionPane.showMessageDialog(frame, taskDetails);
                
                // Dispose of the frame after use
                frame.dispose();
                
                // Print task details to the console
                
                System.out.println(taskDetails);
        }
        
        // Calculate and display total task duration
        int totalHours = Task.returnTotalHours(tasks);
        System.out.println("Total task duration: " + totalHours + " hours.");
     }
    }