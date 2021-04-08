// Throughout this project, the use of data structures are not permitted such as methods like .split and .toCharArray




import java.util.Scanner;
// More packages may be imported in the space below
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;

class CustomerSystem{
    public static void main(String[] args){
        // Please do not edit any of these variables
        Scanner reader = new Scanner(System.in);
        String userInput, enterCustomerOption, generateCustomerOption, exitCondition;
        enterCustomerOption = "1";
        generateCustomerOption = "2";
        exitCondition = "9";

        // More variables for the main may be declared in the space below


        do{
            printMenu();                                    // Printing out the main menu
            userInput = reader.nextLine();                  // User selection from the menu

            if (userInput.equals(enterCustomerOption)){
                // Only the line below may be editted based on the parameter list and how you design the method return
		        // Any necessary variables may be added to this if section, but nowhere else in the code
                enterCustomerInfo(reader);
            }
            else if (userInput.equals(generateCustomerOption)) {
                // Only the line below may be editted based on the parameter list and how you design the method return
                generateCustomerDataFile(exitCondition, exitCondition, exitCondition, exitCondition, exitCondition);
            }
            else{
                System.out.println("Please type in a valid option (A number from 1-9)");
            }

        } while (!userInput.equals(exitCondition));         // Exits once the user types 
        
        reader.close();
        System.out.println("Program Terminated");
    
    }
    public static void printMenu(){
        System.out.println("Customer and Sales System\n"
        .concat("1. Enter Customer Information\n")
        .concat("2. Generate Customer data file\n")
        .concat("3. Report on total Sales (Not done in this part)\n")
        .concat("4. Check for fraud in sales data (Not done in this part)\n")
        .concat("9. Quit\n")
        .concat("Enter menu option (1-9)\n")
        );
    }
    
   /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static void enterCustomerInfo(Scanner reader){
    // ask the user for their information
	String firstName;
        System.out.println("Enter your first name:");
        firstName = reader.nextLine();
        String lastName;
        System.out.println("Enter your last name:");
        lastName = reader.nextLine();
        String city;
        System.out.println("Enter the city you live in:");
        city = reader.nextLine();
        String postalCode;
        System.out.println("Enter your postal code:");
        postalCode = reader.nextLine();
        String creditCard;
        System.out.println("Enter your credit card number:");
        creditCard = reader.nextLine();
	// when the customer enters a card number that is not valid
        while (!validateCreditCard(creditCard)){
            System.out.println("Your card is invalid. Please enter a valid credit card");
            creditCard = reader.nextLine();
        }

    }    

    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static void validatePostalCode(String postalCode) throws Exception {
        // Initialise necessary packages
        FileReader fr= new FileReader("postal_codes(1).csv");
        BufferedReader br= new BufferedReader(fr);
        // Add needed varaible of the postal code file
        String csv;
    // Allows system to check the desired file
    while ((csv=br.readLine())!=null){
       // Statement to check if the postal code given by the user is in the file
        if(csv.contains(postalCode)){
        System.out.println("Postal code is valid.");
       }
       // Situation when it is not found in file
       else{
           System.out.println("Postal code is not found in the database, please try again.");
       }
      // Close bufferedreader
       br.close();
    }                                                                             
    }
	
    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static boolean validateCreditCard(String creditCard){
	if (creditCard.length() < 9){
        return false;
            }
	// reverse the credit card numbers
        String creditCardReversed = "";
        for (int i = creditCard.length()-1; i>=0; i--){
            creditCardReversed += creditCard.charAt(i);
        }
	// calculates sum 1 (ever other number)
        int sum1 = 0; 
        for(int i = 0; i< creditCardReversed.length(); i +=2){
            sum1 += Character.getNumericValue(creditCardReversed.charAt(i));
        }
	// caluculates left over numbers and subtracts 9 from double digits
        int sum2 = 0;
        for(int i = 1; i< creditCardReversed.length(); i +=2){
            int digit = Character.getNumericValue(creditCardReversed.charAt(i) *2);
            if(digit > 9){
                sum2 += digit - 9;
            } else{
                sum2 += digit;
            }
        }
	// the sums last digit should end with a zero 
        return (sum1 + sum2) % 10 == 0; 
    }
    
    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static void generateCustomerDataFile(String firstName, String lastName, String city, String postalCode, String creditCard){
        // Necessary varaibles to generate id 
        int num1 = 99999999;
        int num2 = 10000000;
        // Initalise package
        Random rand = new Random();
        // Allows the system to generate a randumber number (8 digit id number)
        int id = rand.nextInt(num1 - num2) + num2;
   // Varaiable of the customer data file
    String filepath = "customer.txt";
        try{
            // Initalise packages
            FileWriter fw = new FileWriter(filepath);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            // Prints desired information into file
            pw.println(id+","+firstName+","+lastName+","+city+","+postalCode+","+creditCard);
            // Close print writer
            pw.close();
            System.out.println("File has been saved:"+filepath);
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally{
            System.out.println("Code within finally block");
        }
}

    /*******************************************************************
    *       ADDITIONAL METHODS MAY BE ADDED BELOW IF NECESSARY         *
    *******************************************************************/

    public static int validatePostalCode2(String postalCode){
        int len = postalCode.length();
        for(int i = 0; i<len; i++){
        // If stateement to check for at least 3 characters
        if (postalCode.charAt(i) <= '2'){
            return i;
                }
        }
        // Base case for if there less than three characters
        return 0;
    }
}

