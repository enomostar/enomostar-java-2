import java.io.Serializable;
import java.util.Date;
public class Residential extends property implements Serializable{//to inherit property and  allow serialization 
    private int number_of_bedrooms;
    private int number_of_bathrooms;
    private boolean view;
    private int yearbuilt;
    //variables for option 2 rent
    private Date startDate;
    private Date endDate;
    private boolean rented;
    
    public Residential(String propertyID, String Description,Date date,String Postaladdress,int number_of_bedrooms,int number_of_bathrooms,boolean view,int yearbuilt){
        super(propertyID, Description, date, Postaladdress);
        this.number_of_bedrooms=number_of_bedrooms;
        this.number_of_bathrooms=number_of_bathrooms;
        this.view=view;
        this.yearbuilt=yearbuilt;
    }
    //optional constructors
    public Residential(String propertyID, String Description,Date date,String Postaladdress,int number_of_bedrooms,int number_of_bathrooms,boolean view,int yearbuilt,double Area){
        super(propertyID, Description, date, Postaladdress,Area);
        this.number_of_bedrooms=number_of_bedrooms;
        this.number_of_bathrooms=number_of_bathrooms;
        this.view=view;
        this.yearbuilt=yearbuilt;

     }
     public Residential(String propertyID, String Description,Date date,String Postaladdress,int number_of_bedrooms,int number_of_bathrooms,boolean view,int yearbuilt,double Area,double Rentalprice){
        super(propertyID, Description, date, Postaladdress,Area,Rentalprice);
        this.number_of_bedrooms=number_of_bedrooms;
        this.number_of_bathrooms=number_of_bathrooms;
        this.view=view;
        this.yearbuilt=yearbuilt;
     }

     //seters and getters 
     //for number_of_bedrooms
     public int getnumber_of_bedrooms(){
        return number_of_bedrooms;
    }
    public void setnumber_of_bedrooms(int number_of_bedrooms){
        this.number_of_bedrooms=number_of_bedrooms;
    
    }


     //for number_of_bathrooms
    public int getnumber_of_bathrooms(){
        return number_of_bathrooms;
    }
    public void setnumber_of_bathrooms(int number_of_bathrooms){
        this.number_of_bathrooms=number_of_bathrooms;
    
    }


    //for view
    public boolean getview(){
        return view;
    }
    public void setview(boolean view){
        this.view=view;
    
    }

    

     //for yearbuilt

    public int getyearbuilt(){
        return yearbuilt;
    }
    public void setyearbuilt(int yearbuilt){
        this.yearbuilt=yearbuilt;
    
    }

    //
    //setters and getters for option 2 rent
    public Date getstartDate(){
        return startDate;
    }
    public void setstartDate(Date startDate){
        this.startDate=startDate;
    }

    public Date getendDate(){
        return endDate;
    }
    public void setendDate(Date endDate){
        this.endDate=endDate;
    }

    public boolean getrented(){
        return rented;
    }
    public void setrented(boolean rented){
        this.rented=rented;
    
    }







}