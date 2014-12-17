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

public class Billing {//class Billing
    //data
	private Patient patient;
	private Doctor doctor;
	
	public Billing(){ // Default constructor
		patient = null;
		doctor =  null;
	}
	public Billing(Patient newPatient, Doctor newDoctor){ //constructor with 2 parameters
		patient = newPatient;
		doctor = newDoctor;
	}
	public Patient getPatient(){ //returns Patient's object
		return patient;
	}
	public Doctor getDoctor(){//returns Doctor's object
		return doctor;
	}
	public void setDoctor(Doctor modifyDoctor){ //sets Doctor's details
		doctor = modifyDoctor;
	}
	public void setPatient(Patient modifyPatient){ //sets patient's details
		patient = modifyPatient;
	}
	public void writeOutput(){ //displays Billing details on the screen
		patient.writeOutput();
		doctor.writeOutput();
	}//compares 2 bills, returns true if they are equal
	//otherwise returns falls
	public boolean equals(Billing bill1){
		return patient.equals(bill1.patient)&&doctor.equals(bill1.doctor);
	}
}
