
import java.io.Serializable;
import java.util.Date;
public class commercial extends property implements Serializable{//to inherit property and  allow serialization 
    private String type_of_licence;
    private boolean accessibility;
    //variables for option 2 rent
    private Date startDate;
    private Date endDate;
    private boolean rented;
    public commercial(String propertyID, String Description,Date date,String Postaladdress,String type_of_licence,boolean accessibility){
        super(propertyID, Description, date, Postaladdress);
        this.type_of_licence=type_of_licence;
        this.accessibility=accessibility;
    }

    //optional constructors
    public commercial(String propertyID, String Description,Date date,String Postaladdress,String type_of_licence,boolean accessibility,double Area){
        super(propertyID, Description, date, Postaladdress,Area);
        this.type_of_licence=type_of_licence;
        this.accessibility=accessibility;
    }
    public commercial(String propertyID, String Description,Date date,String Postaladdress,String type_of_licence,boolean accessibility,double Area,double Rentalprice){
        super(propertyID, Description, date, Postaladdress,Area,Rentalprice);
        this.type_of_licence=type_of_licence;
        this.accessibility=accessibility;
    }

    public String gettype_of_licence(){
        return type_of_licence;
    }
    public void settype_of_licence(String type_of_licence){
        this.type_of_licence=type_of_licence;
    
    }

    public boolean getaccessibility(){
        return accessibility;
    }
    public void setaccessibility(boolean accessibility){
        this.accessibility=accessibility;
    
    }
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
