import java.util.*;
import java.util.stream.Stream;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

//@AUTHOR: GORKEM TOPRAK
//DATE: JANUARY 23, 2021 SATURDAY
//TOPIC: JAVA-8 STREAMS

public class Main {

    public static void main(String[] args) {

        Customer cust1 = new Customer("Gorkem", "Toprak",2011, "Istanbul", 10);
        Customer cust2 = new Customer("Mert","Toprak",2011, "Istanbul", 24);
        Customer cust3 = new Customer("Volkan","Ozer",2012, "Ankara", 34);
        Customer cust4 = new Customer("Tolga","Ozer",2016, "Erzincan", 120);
        Customer cust5 = new Customer("Baris","Manco",1999, "Tekirdag", 900);
        Customer cust6 = new Customer("Cem","Karaca",2008, "Mersin", 530);
        Customer cust7 = new Customer("Ahmet","Mehmet",2018, "Yozgat", 1);
        Customer cust8 = new Customer("John", "Snow",2000, "Manisa", 65);
        Customer cust9 = new Customer("Snoop", "Dogg",2010, "Los Angeles", 90);
        Customer cust10 = new Customer("Marie","Plassard",2011, "San Francisco", 650);

        List<Customer> newCustomerList = Arrays.asList(cust1,cust2,cust3,cust4,cust5,cust6,cust7,cust8, cust9, cust10);
        //This is optional, i can use also this one.. (Just for try)
//        Stream<NewCustomer> customerStream = customerList.stream();

        //THIS IS FOR QUESTION 1
        //1. Find all transactions in the year 2011 and sort them by value (small to high).
        List<Customer> sortYear = newCustomerList.stream().filter(transaction -> transaction.getYear() == 2011).sorted(comparing(Customer::getPurchase)).collect(toList());
        System.out.println("1. " + sortYear + "\n");
        System.out.println("************************************************************************************ \n");

        //THIS IS FOR QUESTION 2
        //2. What are all the unique cities where the customers live?
        List<String> cities = newCustomerList.stream().map(transaction -> transaction.getCity()).distinct().collect(toList());
        System.out.println("2. " + cities + "\n");
        System.out.println("************************************************************************************ \n");

        //THIS IS FOR QUESTION 3
        //3: Find all customers from Istanbul and sort them by name.
        List<Customer> customersList = newCustomerList.stream().filter(trader -> trader.getCity().equals("Istanbul")).distinct().sorted(comparing(Customer::getName)).collect(toList());
        System.out.println("3. " + customersList + "\n");
        System.out.println("************************************************************************************ \n");

        //THIS IS FOR QUESTION 4
        //4: Return a string of all customers’ names sorted alphabetically.
        String namesSorted = newCustomerList.stream().map(transaction -> transaction.getName()).distinct().sorted().reduce("Sorted:", (n1 , n2) -> n1 + " " + n2);
        System.out.println("4. " + namesSorted + "\n");
        System.out.println("************************************************************************************ \n");

        //THIS IS FOR QUESTION 5 [I used boolean type for this question]
        //5: Are any customers living in Ankara?
        boolean isLivingAnkara = newCustomerList.stream().anyMatch(transaction -> transaction.getCity().equals("Ankara"));
        System.out.println("5. " + isLivingAnkara + "\n");
        System.out.println("************************************************************************************ \n");

        //THIS IS FOR QUESTION 6
        //6: Print all transactions’ values from the customers living in Istanbul.
        Predicate<Customer> Condition = customer -> customer.getCity().equals("Istanbul");
        newCustomerList.stream().filter(Condition).sorted(comparing(Customer::getPurchase)).forEach(customer -> System.out.println("6. " + customer + "\n"));
        System.out.println("************************************************************************************ \n");

        //THIS IS FOR QUESTION 7
        //7: What’s the highest value of all the transactions?
        int highestValue = newCustomerList.stream().map(Customer::getPurchase).reduce(0, Integer::max);
        System.out.println("7. Max Value: " + highestValue + "\n");
        System.out.println("************************************************************************************ \n");

        //THIS IS FOR QUESTION 8
        //8. Find the transaction with the smallest value.
        Customer smallestValue = newCustomerList.stream().min(comparing(Customer::getPurchase)).orElseThrow(NoSuchElementException::new);
//                        .map(Transaction::getValue)
//                        .reduce(0, Integer::min);
        System.out.println("8. " + smallestValue + "\n");
        System.out.println("************************************************************************************ \n");

        //THIS IS FOR QUESTION 9 [Is there any value less than 5 here? I checked it. If there is, it prints the element.]
        //9. Is there any transaction less than a certain value?
        Customer isCertainValue = newCustomerList.stream().filter(customer -> customer.getPurchase() < 5).reduce((a, b) -> { throw new IllegalStateException("Multiple elements: " + a + ", " + b); }).get();
        System.out.println("9. " + isCertainValue + "\n");
        System.out.println("************************************************************************************ \n");

        //THIS IS FOR QUESTION 10
        Predicate<Customer> mypred = new Filter<>();
        Stream<Object> str2 = newCustomerList.stream().filter(mypred).map(d-> d.getCity().equals("Ankara"));
//        System.out.println("10. " + str2 + "\n");
    }
}