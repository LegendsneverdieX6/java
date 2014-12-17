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
public class testBill { //to test Billing class

	public static void main (String [] args){
		
		Patient patientOne = new Patient("Lucy Lu", "N08765"); //first patient object
		Patient patientTwo = new Patient("David Eizenshtein", "N908765");// second patient object
		Doctor doctorOne = new Doctor("Dr. Paul Smith", "Obstetrician",200.0); //first doctor object
		Doctor doctorTwo = new Doctor("Dr. Suzuki Yukito", "Pediatrician",220.0);//second doctor object
		Billing billOne = new Billing(patientOne,doctorOne); //first billing object
		Billing billTwo = new Billing(patientTwo, doctorTwo); //second billing object
		
		System.out.println("Information about bill 1: "); //to display on the console
		billOne.writeOutput();
		System.out.println("Information about bill 2: ");
		billTwo.writeOutput();
		
		double billOneAmount = billOne.getDoctor().getFee(); // gets fee and the name of the first doctor
		double billTwoAmount =  billTwo.getDoctor().getFee();// gets fee and the name of second doctor
		double totalIncome = billOneAmount + billTwoAmount;//calculates total bill
		
		System.out.println("total income: " + totalIncome);//displays on the screen total bill
		System.out.println("The information about both bills are equal: " + billOne.equals(billTwo)); //tests if the bills' information is equivalent (name,fee,id)
	}
}
