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

public class Doctor extends Person {// class Doctor derived from class Person
    //data
	private String specialty;
	private double fee;
	
	public Doctor(String name, String profession, double fee1){ //constructor with 3 parameters
		setName(name); //calls the name from class Person
		specialty=profession;
		fee=fee1;
	}
	public void setOccupation(String newOccupation){// sets the doctor's occupation
		specialty=newOccupation;
	}
	public void setFee( double fee2){ //set's the doctor's fee
		fee=fee2;
	}
	public String getOccupation(){//returns the doctor's occupation
		return specialty;
	}
	public double getFee(){ //returns doctor's fee
		return fee;
	}
	// if names the same returns true
	//otherwise returns false
	public boolean equals(Doctor doctor1){
		return this.hasSameName(doctor1)&& this.specialty == doctor1.specialty
				&&this.fee == doctor1.fee;
	}
	public void writeOutput(){ //displays output on the screen
		System.out.println("Doctor name: " + getName());
		System.out.println("Specialization: " + specialty);
		System.out.println("Visit fee: " + fee);
		System.out.println();
		
	}
}
