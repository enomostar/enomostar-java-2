import java.io.Serializable;
import java.util.Date;
public class property  implements Serializable {
    //all the variables are made privite so it can be changed only from this class
    private String propertyID;
    private String Description;
    private Date date;
    private String Postaladdress;
    private double Area;
    private double Rentalprice; 
    public property(String propertyID, String Description,Date date,String Postaladdress){ 
        // I didnt want to use letters here because it will be really confusing 
        this.propertyID=propertyID;
        this.Description=Description;
        this.date=date;
        this.Postaladdress=Postaladdress;

    }
    // for the optional attributes i made another two constructors 
    public property(String propertyID, String Description,Date date,String Postaladdress,double Area){ 
        // I didnt want to use letters here because it will be really confusing 
        this.propertyID=propertyID;
        this.Description=Description;
        this.date=date;
        this.Postaladdress=Postaladdress;
        this.Area=Area;
    }
    public property(String propertyID, String Description,Date date,String Postaladdress,double Area,double Rentalprice){ 
        // I didnt want to use letters here because it will be really confusing 
        this.propertyID=propertyID;
        this.Description=Description;
        this.date=date;
        this.Postaladdress=Postaladdress;
        this.Area=Area;
        this.Rentalprice=Rentalprice;
    }

// seters and geters for each attribute 
// for propertyID
public String getpropertyID(){
    return propertyID;
}
public void setpropertyID(String propertyID ){
    this.propertyID=propertyID;

}

// for Description
public String getDescription(){
    return Description;
}
public void setDescription(String Description ){
    this.Description=Description;
}
// for date
public Date date(){
    return date;
}
public void setdate(Date date){
    this.date=date;
}

// for Postaladdress
public String getPostaladdress(){
    return Postaladdress;
}
public void setPostaladdress(String Postaladdress){
    this.Postaladdress=Postaladdress;
}

// for Area
public double getArea(){
    return Area;
}
public void setArea(double Area){
    this.Area=Area;
}
// for Rentalprice
public double getRentalprice(){
    return Rentalprice;
}
public void setRentalprice(double Rentalprice){
    this.Rentalprice=Rentalprice;
}



}
