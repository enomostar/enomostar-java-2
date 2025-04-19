//I made this code to minimize the crashes as much as possible enjoy ;)
import java.util.Date;
import java.util.InputMismatchException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.ArrayList;
public class main{
    public static void main (String[]args){
        Scanner sc=new Scanner(System.in);
        //lists to store data temporarily 
        ArrayList<property> properties = new ArrayList<>();
        ArrayList<commercial>  commercials= new ArrayList<>();
        ArrayList<Residential>  Residentials= new ArrayList<>();
        while(true){
            //options
            System.out.println("press 1: to add property");
            System.out.println("press 2: to add rental agreements");
            System.out.println("press 3: to show all the properties");
            System.out.println("press 4: Summary of total rent collected from all properties rented");
            System.out.println("press 5:Save properties and rents to a file through serialisation");
            System.out.println("press 6: Read properties and rents from a file through deserialisation");
            System.out.println("press 7: change rental price for a property");
            System.out.println("press 8: to Exit");
            int options1= intgerchecker();
            if (options1==1){
                //options to choose between commercial and Residential propeties
                System.out.println("press 1: to add commercial property");
                System.out.println("press 2: to add Residential property");
                int options2= intgerchecker();
                if (options2==1){
                    System.out.println("please input propertyID ");
                    String propertyID=stringchecker();
                    while(propertyID.length()<10){
                        System.out.println("the id should be atleast 10 characters please input again");
                        propertyID=stringchecker();

                    }
                    System.out.println("please input Description ");
                    String Description=stringchecker();
                    Date storedDate = null;
                    while (storedDate == null) {
                        System.out.print("please Enter a date of acquisition in this format (yyyy-MM-dd): ");
                        String userInput = sc.nextLine();
                        storedDate = getDate(userInput);
                    }
                    System.out.println("please input the Postal address");
                    String Postaladdress=stringchecker();
                    System.out.println("please input the type of licence");
                    String type_of_licence=stringchecker();
                    System.out.println("please input the accessibility measures(yes/no) ");
                    boolean accessibility = booleanconverter(sc.next());
                    System.out.println("please input the area of the property in square meters(optional input,to skip input -1)");
                    double Area=double_negativechecker(sc.nextDouble());
                    if (Area==-1){
                        commercial c1= new commercial(propertyID,Description,storedDate,Postaladdress,type_of_licence,accessibility);
                        commercials.add(c1);

                    }
                    else{
                        System.out.println("please input the price of the monthly rent of the property in euro (optional input,to skip input -1)");
                        double Rentalprice=double_negativechecker(sc.nextDouble());
                        if (Rentalprice==-1) {
                            commercial c1= new commercial(propertyID,Description,storedDate,Postaladdress,type_of_licence,accessibility,Area);
                            commercials.add(c1);
                            
                        }
                        else{
                            commercial c1= new commercial(propertyID,Description,storedDate,Postaladdress,type_of_licence,accessibility,Area,Rentalprice);
                            commercials.add(c1);

                        }
                    }
                }
                if (options2==2){
                    System.out.println("please input propertyID ");
                    String propertyID=stringchecker();
                    while(propertyID.length()<10){
                        System.out.println("the id should be atleast 10 characters please input again");
                        propertyID=stringchecker();

                    }
                    System.out.println("please input Description ");
                    String Description=stringchecker();
                    Date storedDate = null;
                    while (storedDate == null) {
                        System.out.print("please Enter a date of acquisition in this format (yyyy-MM-dd): ");
                        String userInput = sc.nextLine();
                        storedDate = getDate(userInput);
                    }
                    System.out.println("please input the Postal address");
                    String Postaladdress=stringchecker();
                    System.out.println("please input the number of bedrooms");
                    int number_of_bedrooms=int_negativechecker(intgerchecker());
                    System.out.println("please input the number of bathrooms");
                    int number_of_bathrooms=int_negativechecker(intgerchecker());
                    System.out.println("please input if there is a view (yes/no) ");
                    boolean view = booleanconverter(sc.next());
                    System.out.println("please input the year built");
                    int yearbuilt=int_negativechecker(intgerchecker());
                    System.out.println("please input the area of the property in square meters(optional input,to skip input -1)");
                    double Area=double_negativechecker(sc.nextDouble());
                    if (Area==-1){
                        Residential r1= new Residential(propertyID,Description,storedDate,Postaladdress,number_of_bedrooms,number_of_bathrooms,view,yearbuilt);
                        Residentials.add(r1);

                    }
                    else{
                        System.out.println("please input the price of the monthly rent of the property in euro (optional input,to skip input -1)");
                        double Rentalprice=double_negativechecker(sc.nextDouble());
                        if (Rentalprice==-1) {
                            Residential r1= new Residential(propertyID,Description,storedDate,Postaladdress,number_of_bedrooms,number_of_bathrooms,view,yearbuilt,Area);
                            Residentials.add(r1);
    
                        }
                        else{
                            Residential r1= new Residential(propertyID,Description,storedDate,Postaladdress,number_of_bedrooms,number_of_bathrooms,view,yearbuilt,Area,Rentalprice);
                            Residentials.add(r1);
                        }
                    }
                }  
            }
            if (options1==2){
                System.out.println("Please choose a category property you want add for rent from the following :");
                System.out.println("press 1 for commercial:");
                System.out.println("press 2 for residenial:");


                int choice= intgerchecker();
                if (choice==1){

                    System.out.println("These are the  commercial properties which are currently not rented :");
                    for(int i=0;i<commercials.size();i++){
                        if (commercials.get(i).getrented()==false && commercials.get(i).getRentalprice()!=0.0){//checks if it is rented or no and the rent shouldent be unknown ie 0.0
                        System.out.println("commercial property "+(i+1)+" ID:"+commercials.get(i).getpropertyID()+", address:"+commercials.get(i).getPostaladdress()+" rental price:"+unknownchecker(commercials.get(i).getRentalprice())+" euro");
                        }
                    
                    }
                    System.out.print("Please choose one by entering the number of the property:");
                    int choice2= intgerchecker();
                    commercials.get(choice2-1).setrented(true);
                    Date storedDate4 = null;
                    while (storedDate4 == null) {
                        System.out.print("please Enter the start  date of the rent in this format (yyyy-MM-dd): ");
                        String userInput4 = sc.nextLine();
                        storedDate4 = rentDate(userInput4);
                    }
                    commercials.get(choice2-1).setstartDate(storedDate4);
                    Date storedDate5 = null;
                    while (storedDate5 == null) {
                        System.out.print("please Enter the end  date of the rent in this format (yyyy-MM-dd): ");
                        String userInput5 = sc.nextLine();
                        storedDate5= rentDate(userInput5);
                    }
                    commercials.get(choice2-1).setendDate(storedDate5);
                }   
                if (choice==2){

                    System.out.println("These are the  Residential properties which are currently not rented :");
                    for(int i=0;i<Residentials.size();i++){
                        if (Residentials.get(i).getrented()==false && Residentials.get(i).getRentalprice()!=0.0){//checks if it is rented or no and the rent shouldent be unknown ie 0.0
                        System.out.println("Residential property "+(i+1)+" ID:"+Residentials.get(i).getpropertyID()+", address:"+Residentials.get(i).getPostaladdress()+" rental price:"+unknownchecker(Residentials.get(i).getRentalprice()));
                        }
                    
                    }
                    System.out.print("Please choose one by entering the number of the property:");
                    int choice2= intgerchecker();
                    Residentials.get(choice2-1).setrented(true);
                    Date storedDate2 = null;
                    while (storedDate2 == null) {
                        System.out.print("please Enter the start  date of the rent in this format (yyyy-MM-dd): ");
                        String userInput2 = sc.nextLine();
                        storedDate2 = rentDate(userInput2);
                    }
                    Residentials.get(choice2-1).setstartDate(storedDate2);
                    Date storedDate3 = null;
                    while (storedDate3 == null) {
                        System.out.print("please Enter the end  date of the rent in this format (yyyy-MM-dd): ");
                        String userInput3 = sc.nextLine();
                        storedDate3 = rentDate(userInput3);
                    }
                    Residentials.get(choice2-1).setendDate(storedDate3);
                } 
            }
            if (options1==3){
                System.out.println("There are "+Residentials.size()+" Residential properties :");
                for(int i=0;i<Residentials.size();i++){
                    //since there is no type of licence in Residential properties i had to replace it with view 
                    System.out.println("Residential property "+(i+1)+" ID:"+Residentials.get(i).getpropertyID()+", address:"+Residentials.get(i).getPostaladdress()+ " view:"+Residentials.get(i).getview()+" rental price:"+unknownchecker(Residentials.get(i).getRentalprice())+" euro");
                }
                System.out.println("There are "+commercials.size()+" commercial properties :");
                for(int i=0;i<commercials.size();i++){
                    System.out.println("commercial property "+(i+1)+" ID:"+commercials.get(i).getpropertyID()+", address:"+commercials.get(i).getPostaladdress()+ " type:"+commercials.get(i).gettype_of_licence()+" rental price:"+unknownchecker(commercials.get(i).getRentalprice())+" euro");
                }

            }
            if (options1==4){
                System.out.println("Money collected from :");
                double sum1=0;
                for(int i=0;i<Residentials.size();i++){
                    if (Residentials.get(i).getrented()==true && Residentials.get(i).getRentalprice()!=0.0){//choosing rented properties
                        long timediffinmillie =Residentials.get(i).getendDate().getTime()-Residentials.get(i).getstartDate().getTime();//to find the difference in time in millie seconed
                        long diffInDays = timediffinmillie / (1000 * 60 * 60 * 24);//converting it to days
                        double rentalpriceperday=(Residentials.get(i).getRentalprice()/30);//getting the rental rate per day
                        sum1=(rentalpriceperday*diffInDays)+sum1;//adding the money eraned from a specific rent to the total for Residentials 
                    }

            }
                System.out.println("Residentials: "+sum1+" euro");
                 double sum2=0;
                for(int i=0;i<commercials.size();i++){
                    if (commercials.get(i).getrented()==true && commercials.get(i).getRentalprice()!=0.0){//choosing rented properties
                        long timediffinmillie =commercials.get(i).getendDate().getTime()-commercials.get(i).getstartDate().getTime();//to find the difference in time in millie seconed
                        long diffInDays = timediffinmillie / (1000 * 60 * 60 * 24);//converting it to days
                        double rentalpriceperday=(commercials.get(i).getRentalprice()/30);//getting the rental rate per day
                        sum2=(rentalpriceperday*diffInDays)+sum2;//adding the money eraned from a specific rent to the total for Residentials 
                    }

                }
                System.out.println("commercials: "+sum2+" euro");
                System.out.println("Total: "+(sum1+sum2)+" euro");

            }
            if(options1 == 5) {
                //for commercial
                try { 
                    ObjectOutputStream os =new ObjectOutputStream(new FileOutputStream("commercialsavefile.dat"));
                    os.writeObject(commercials);
                    os.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                //for residensial
                try { 
                    ObjectOutputStream os =new ObjectOutputStream(new FileOutputStream("Residentialsavefile.dat"));
                    os.writeObject(Residentials);
                    os.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("your Properties has been saved ");

            }
            
            if(options1 == 6) {
                //for commercial
                commercials = null;// to empty the list 
                try{
                    ObjectInputStream is = new ObjectInputStream(new FileInputStream("commercialsavefile.dat"));
                    commercials= (ArrayList<commercial>) is.readObject();

                }
                catch (Exception ioe) { 
                }
                //for residensial
                Residentials= null;// to empty the list 
                try{
                    ObjectInputStream is = new ObjectInputStream(new FileInputStream("Residentialsavefile.dat"));
                    Residentials= (ArrayList<Residential>) is.readObject();

                }
                catch (Exception ioe) { 
                }
                System.out.println("All properties in files has been read");

            }
            if(options1==7){
                System.out.println("choose which type of property");
                System.out.println("press 1 for commercial");
                System.out.println("press 2 for Residential");
                int options3 = intgerchecker();
                if (options3==1){
                    System.out.println("These are the commercial properties:");
                    for(int i=0;i<commercials.size();i++){
                        if (commercials.get(i).getrented()==false){//checks if it is rented or no and the rent shouldent be unknown ie 0.0
                        System.out.println("commercials property "+(i+1)+" ID:"+commercials.get(i).getpropertyID()+", address:"+commercials.get(i).getPostaladdress()+" rental price:"+unknownchecker(commercials.get(i).getRentalprice())+" euro");
                        }
                    
                    }
                    System.out.print("Please choose one by entering the number of the property you  want to change :");
                    int decision= intgerchecker();
                    System.out.print("Please input the new rental price:");
                    double newretalprice=double_negativechecker(sc.nextDouble());
                    commercials.get(decision-1).setRentalprice(newretalprice); 
                }            
                if (options3==2){
                    System.out.println("These are the  Residential properties:");
                    for(int i=0;i<Residentials.size();i++){
                        if (Residentials.get(i).getrented()==false){//checks if it is rented or no and the rent shouldent be unknown ie 0.0
                        System.out.println("Residential property "+(i+1)+" ID:"+Residentials.get(i).getpropertyID()+", address:"+Residentials.get(i).getPostaladdress()+" rental price:"+unknownchecker(Residentials.get(i).getRentalprice())+" euro");
                        }
                    
                    }
                    System.out.print("Please choose one by entering the number of the property you  want to change :");
                    int decision= intgerchecker();
                    System.out.print("Please input the new rental price:");
                    double newretalprice=double_negativechecker(sc.nextDouble());
                    Residentials.get(decision-1).setRentalprice(newretalprice); 
                }               
                
            } 
            if(options1==8){
                break;
            }



        }
        

    }



























    //---------------------------------------------------------------------------------------------------------------------------------------------------------//
    //this part is for the additional methods, the additional methods job is to remove redundent tasks from the main method 

    public static boolean booleanconverter(String input) {// this transforms the y input to true and the n input to false and checks for the input
        Scanner sc1= new Scanner(System.in);
        String validInput = input;
        
        while (true) {
            if (validInput.equals("yes")) {
                return true;  
            } 
            if (validInput.equals("no")) {
                return false; 
            } else {
                System.out.println("Your input is invalid. Please input again (yes or no).");
                validInput = sc1.next();  
            }
    }
}


    public static String unknownchecker(double input) {//checks if there is no value in the rental price and outputs unknown
        if (input == 0.0){
            return "unknown";
        }
        String value=""+input;
        return value;
    }
    
    public static String stringchecker(){//this has a job of checking if the input is a string or not 
        Scanner sc2=new Scanner(System.in);
        boolean x=true;
        String validString="";

        while(x==true){
        try {
            validString = sc2.nextLine();  

            x = false; // Exit the loop if input is valid
            if (validString.equals("")){
                System.out.println("invalid input:Please input a String ");
                x = true; 
            }

        } catch (Exception e) {
            System.out.println("invalid input:Please input a String ");
            x = true; 
        }
    }
        return validString;

    }


    public static int intgerchecker(){//this has a job of checking if the input is an integer or not 
        Scanner sc3 = new Scanner(System.in);
        int validInteger = 0;

        while (true) { 
            try {
                validInteger = sc3.nextInt();  
                break;  
            } catch (InputMismatchException e) {  
                System.out.println("Invalid input: Please input an integer.");
                sc3.nextLine();  
            }
        }

        return validInteger;  // Return the valid integer
    }


    public static int int_negativechecker(int input){
        int validintger=input;
        Scanner sc4=new Scanner(System.in);
        while(true){
            if(validintger<0){
                System.out.println("invalid input:Please input a positive intger ");
                validintger = sc4.nextInt();  
            }
            else{
                validintger=input;
                break;
            }
        }
        return validintger;

    }

    public static double double_negativechecker(double input){
        double validintger=input;
        Scanner sc4=new Scanner(System.in);
        while(true){
            if(validintger<-1){
                System.out.println("invalid input:Please input a positive intger ");
                validintger = sc4.nextDouble();  
            }
            else{
                validintger=input;
                break;
            }
        }
        return validintger;
    }

    public static Date getDate(String dateInput) {
        // this method's job is to make the date inputed in the correct format where the date data type could except 
        SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat.setLenient(false); // Strict parsing this makes sure that the format is correct meaning it will reject something like this 2024-02-30

        try {
            Date inputDate = DateFormat.parse(dateInput);
            Date currentDate = new Date();

            //checks if the date inputed is in the future 
            if (inputDate.after(currentDate)) {
                System.out.println("Error: The date cannot be in the future.");
                return null;
            }

            return inputDate;
        } catch (ParseException e) {
            System.out.println("Error: Invalid date format. Please use yyyy-MM-dd.");//checks if the format is correct 
            return null;
        }
    }
    public static Date rentDate(String dateInput) {
        // this method's job is to make the date inputed in the correct format where the date data type could except for the rent in option 2 
        SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat.setLenient(false); // Strict parsing this makes sure that the format is correct meaning it will reject something like this 2024-02-30

        try {
            Date inputDate = DateFormat.parse(dateInput);
            Date currentDate = new Date();

            //checks if the date inputed is in the future 
            if (inputDate.before(currentDate)) {
                System.out.println("Error: The date cannot be in the past.");
                return null;
            }

            return inputDate;
        } catch (ParseException e) {
            System.out.println("Error: Invalid date format. Please use yyyy-MM-dd.");//checks if the format is correct 
            return null;
        }
    }

}