package de.seal.se;

import java.util.ArrayList;

/**
 * Note that Java console applications need to be run through the java runtime
 * by running "java -jar JarFile.jar" in the command line.
 * Java console applications can not be previewed in the Compilr IDE, only applets can.
 */
public class Program
{
    /**
     * This is the main entry point for the application
     */
    
    
    public static void main(String args[]) 
    {
        Program p = new Program();
        p.sayHello();
    	String result;
        Movie m1 = p.recordMovie("movie1", 1);
        Movie m2 = p.recordMovie("movie2", 2);
        
        Rental r1 = p.rentMovie(m1, 10);
        Rental r2 = p.rentMovie(m2, 5);
        Customer c1 = new Customer("joe");
        c1.addRental(r1);
        c1.addRental(r2);   
        p.sayStatement();
        result = c1.statement();
        p.sayResult(result);
    }
    
        
    public void sayHello()
    {
    	System.out.println("Welcome to the Movie Store");
    }
    
    public void sayStatement()
    {
    	System.out.println("Let's get the Statement");
    }
    
    public void sayResult(String result)
    {
    	System.out.println(result);
    }
    
    public Movie recordMovie(String title, int priceCode)
    {
    	return new Movie(title,priceCode);
    }
    
    public Rental rentMovie(Movie m, int daysRented)
    {
    	return new Rental(m,daysRented);
    }
}


