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
    
    }


   
        

    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static void validatePostalCode(String postalInput) throws Exception {
  
        FileReader fr= new FileReader("postal-codes.txt");
        BufferedReader br= new BufferedReader(fr);
        String csv;
      
    while ((csv=br.readLine())!=null){
       if(csv.contains(postalInput)){
        System.out.println("Postal code is valid.");
       }
       else{
           System.out.println("Postal code is not found in the database, please try again.");
       }
      br.close();
    }                                                                             
    }
    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static void validateCreditCard(){
    }
    
    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static void generateCustomerDataFile(String firstName, String lastName, String city, String postalInput, String creditCard){

        int num1 = 10000000;
        int num2 = 0;
        Random rand = new Random();
        int id = rand.nextInt(num1 - num2) + num2;
   
    String filepath = "customer.txt";
        try{
            FileWriter fw = new FileWriter(filepath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(id+","+firstName+","+lastName+","+city+","+postalInput+","+creditCard);
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

    public static int validatePostalCode2(String postalInput){
        int len = postalInput.length();
        for(int i = 0; i<len; i++){
        // If sattement to check for at least 3 characters
        if (postalInput.charAt(i) <= '2'){
            return i;
                }
        }
        // Base case for if there less than three characters
        return 0;
    }
}

