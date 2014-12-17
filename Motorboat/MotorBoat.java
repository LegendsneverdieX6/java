//Group #2
//MAC190
//Department of Computer Science
//10/12/2014
//Made by: Anastassiya Neznanova, Andrew Cruz, Mamadou Diallo, Lybacker Roussel,Gabriel Rubio Alvarado, Meltem Yildirim
//MotorBoat
//This program simulates motor boat by calculating distance, current speed, and fuel usage
//The max speed of this boat 25m/h, tank capacity 6 gallons, motor efficiency 20hp, and max 5 hours of operation

import java.util.Scanner;
public class MotorBoat {
	private double capacityOfTheFuelTank;
	private double amountOfFuelInTheTank;
	private double maximumSpeedOfTheBoat;
	private double currentSpeedOfTheBoat;
	private double EfficiencyOfTheBoatMotor;
	private double DistanceTraveled;
	
	
	public MotorBoat(double maximumSpeed, double fuelCapacity, double efficiency)
	{
	System.out.println("WE HAVE A BOAT WITH MOTOR EFFICIENCY 20 HP,TANK MAX CAPACITY 6 GALLONS, 5 HOURS MAX OPERATION, AND MAX SPEED 25M/H");
	System.out.println("if you enter value bigger than max, your number will be ignored and will be equal to max!");
	System.out.println();
	Scanner input = new Scanner(System.in);
		
     maximumSpeedOfTheBoat = maximumSpeed;
     capacityOfTheFuelTank = fuelCapacity;
     EfficiencyOfTheBoatMotor = efficiency;
     
     System.out.println("Enter the speed of your boat");
     currentSpeedOfTheBoat = input.nextDouble();
     if(currentSpeedOfTheBoat>25){
    	System.out.println("Wrong input, this boat cannot run more than 25m/h");
    	System.out.println("Enter your speed again");
    	currentSpeedOfTheBoat = input.nextDouble();
     }
     
     DistanceTraveled = 0.0;
     
     System.out.println("Enter the amount of the fuel");
     amountOfFuelInTheTank = input.nextDouble();
     if(amountOfFuelInTheTank>6){
     	System.out.println("Wrong input, this boat cannot hold more than 6 gallons");
     	System.out.println("Enter your amount of fuel again");
     	amountOfFuelInTheTank = input.nextDouble();
      }
     }
	
//implements method operate the boat for an amount of time
	  public void operateTheBoatForAmountOfTime(double time){// pass 1 as a time
		  if(time > 0.0 && time <= 5.0 ){
        	double fuelUsage =  EfficiencyOfTheBoatMotor*currentSpeedOfTheBoat*currentSpeedOfTheBoat*time;
        	fuelUsage = fuelUsage/10000;//since we have hp, and miles we have to divide by 10000 to get result in gallons 
            double realTime; 
            // Determine if we run out of fuel
	        if(fuelUsage > amountOfFuelInTheTank){ 
	        realTime = time * (amountOfFuelInTheTank/fuelUsage); 
	                amountOfFuelInTheTank=0.0 ;
	            }else{
	            	amountOfFuelInTheTank-=fuelUsage; 
	                realTime = time;
	            }
	            DistanceTraveled +=currentSpeedOfTheBoat * realTime; 
	        }
	    }
	  
		//This method changes the speed of the boat
	  public void changeCurrentSpeed( double newSpeed)
	  {	
		if(newSpeed + currentSpeedOfTheBoat > 25.0)
			currentSpeedOfTheBoat-=newSpeed;
    	if(newSpeed < 0.0)
    		currentSpeedOfTheBoat =currentSpeedOfTheBoat + newSpeed ;//decrease the speed if users enters negative number 
    	else if (newSpeed >maximumSpeedOfTheBoat)
        	currentSpeedOfTheBoat=maximumSpeedOfTheBoat;
        else
        	currentSpeedOfTheBoat =currentSpeedOfTheBoat+ newSpeed;//increase the speed
    	 }

	//Method for refuel the tank
	  public void refuelBoat(double amount){
	        if(amount > 0.0 && amount < 6.0){
	            if (amount + amountOfFuelInTheTank > capacityOfTheFuelTank)
	            	amountOfFuelInTheTank = capacityOfTheFuelTank;
	            else
	            	amountOfFuelInTheTank += amount;
	        }
	    }
	  
    //Method for the amount of the fuel in the tank
    //returns amount of the fuel
    public double FuelRemaining()
    {
    	return amountOfFuelInTheTank;
    }
    
   //Method returns distance traveled
    public double distance(){
        return DistanceTraveled;
    }
    
   //returns current speed 
    public double speed()
    {    	
    	return currentSpeedOfTheBoat;
    }
 
   
    //Method to test the program 
    public static void main(String[] args){
    	
    	Scanner input = new Scanner(System.in);
    	MotorBoat m = new MotorBoat(25,6,20);// maxpotential:25 speed miles per hour, 6 gallon tank, 20hp motor power
    	System.out.println("Enter how long you want to operate your boat in hours no more than 5 hours.");
    	
    	m.operateTheBoatForAmountOfTime(input.nextDouble());    
    	System.out.println();
    	System.out.println("Fuel left is " + m.FuelRemaining()
         + " and we have gone " + m.distance() + " at the speed "+ m.speed());
        System.out.println();
         
        System.out.println("Enter by how much do you want to change your speed, remember 25 is max speed of this boat!");
    	m.changeCurrentSpeed(input.nextDouble());
    	System.out.println();
        System.out.println("Now your speed is "+ m.speed());
    	System.out.println();    
        System.out.println("Enter how long more do you want to operate your boat");
    	m.operateTheBoatForAmountOfTime(input.nextDouble());
    	System.out.println(" and we have gone in total " + m.distance()+" Fuel left is " + m.FuelRemaining());
    	System.out.println();
    	
    	System.out.println("Enter how much you want to add to your fuel tank, remember this tank can hold 6 gallon max!");
    	m.refuelBoat(input.nextDouble());
    	System.out.println();   
    	System.out.println("After you refill your tank your fuel is " + m.FuelRemaining()+" and your speed is "+ m.speed());
    	System.out.println();
     	System.out.println("After refilling your boat for how many more hours do you want to operate your boat?");
     	m.operateTheBoatForAmountOfTime(input.nextDouble());
    	System.out.println();
    	System.out.println("Fuel left is " + m.FuelRemaining()
    	         + " and we have gone in total " + m.distance() + " with current speed "+ m.speed());
    	System.out.println();
        
     
    	}
    }
