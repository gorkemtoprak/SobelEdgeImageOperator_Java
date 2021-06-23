//@AUTHOR: GORKEM TOPRAK
//DATE: JANUARY 23, 2021 SATURDAY
//TOPIC: JAVA-8 STREAMS

public class Customer {

    private String name;
    private String surname;
    private int year;
    private String city;
    private int purchase;

    public Customer(String name, String surname, int year, String city, int purchase){
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.city = city;
        this.purchase = purchase;
    }

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }

    public int getYear(){
        return this.year;
    }

    public String getCity(){
        return this.city;
    }

    public int getPurchase(){
        return this.purchase;
    }

    public void setCity(String newCity){
        this.city = newCity;
    }



    public String toString(){
        return "{" + "Customer Name: " + this.name + " Surname: " + this.surname + " Year: " + this.year + " City: " + this.city + " Amount of Purchase: " + this.purchase +"}";
    }
}
