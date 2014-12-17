//*****************************************************************************************************************
//* Name: Anastassiya Neznanova                                                                                   *
//* Class: MAC190                                                                                                 *
//* Contact: anne55n@yahoo.com                                                                                    *
//* Department of Computer Science                                                                                *
//* Professor: Lawrence Muller                                                                                    *
//* Program name: Clinic's Billing Management                                                                     *
//* This program creates three classes Patient, Doctor and Billing, whose objects are records for a clinic        *
//* (patient's name and ID, doctor's name and specialization, visit fee)                                          *
//* and finds the total income from the billing records                                                           *
//*****************************************************************************************************************

public class Person { // class Person

	   private String name;
	   
	    public Person() //default constructor
	    {
	        name = "No name yet";
	    }
	    public Person(String initialName) //constructor to set initialName
	    {
	        name = initialName;
	    }
	    public void setName(String newName) //sets new name
	    {
	        name = newName;
	    }
	    public String getName() //returns person's name
	    {
	        return name;
	    }
	    public void writeOutput() //display person name on console
	    {
	        System.out.println("Name: " + name);
	    }
	    public boolean hasSameName(Person otherPerson) //returns true if names are the same otherwise false
	    {
	        return this.name.equalsIgnoreCase(otherPerson.name);
	    }
}
