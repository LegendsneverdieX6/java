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

public class Patient extends Person { // class Patient derived from class Person
    //data
	private String ID;

	public Patient(){ //default constructor
		ID = null;
	}
	public Patient (String name, String number){//constructor with 2 parameters
		super(name);//calls the name from class person
		ID = number;
	}
	public void setID(String number){ //sets ID number
		ID=number;
	}
	public String getID(){ //returns ID number 
		return ID;
	}
	public void writeOutput(){ //displays patient name and ID to the screen
		System.out.println("Patient name: " + getName());
		System.out.println("Patient ID: " + ID);
	}
	// if 2 patient objects the same returns true
	//otherwise returns false
	public boolean equals(Patient patient1){
		return this.hasSameName(patient1)&&this.ID.equalsIgnoreCase(patient1.ID);
	}
}
