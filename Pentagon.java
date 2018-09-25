/**************************************************
*Pentagon.java
***************************************************
*__________________________________________________
*Allen Payne
*September 24 2018
*CSMC 255 003
*/

import java.util.Scanner;

public class Pentagon{
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args){
		System.out.println("Nathaniel Payne");
		System.out.println("Project2 - Pentagon");
		System.out.println("This project displays the area and costs of building");
		System.out.println("a model pentagon based on user input from the size of the");
		System.out.println("pentagon.");
		System.out.println("September 25, 2018");
		System.out.println("CSMC 255 Section 003");
		/////////////////////////////////////////////////////
		String name = getString(); //gets the name
		int outerWall = getOuterWall(); //gets the outer wall length
		int innerWall = getInnerWall(); //gets the inner wall length
		int height = getWallHeight(); //get the wall height
		int surfaceAreaOuter = getSurfaceArea(outerWall, height); // calculates the surface area
		//System.out.println(surfaceAreaOuter + " outer SA");
		int surfaceAreaInner = getSurfaceArea(innerWall, height); 
		//System.out.println(surfaceAreaInner + " inner SA");
		int wallsSurfaceArea = surfaceAreaOuter + surfaceAreaInner; //adds the surface areas together
		//System.out.println(wallsSurfaceArea + " total surface area");
		///////////////////////////////////////////////////////////
		double apothemOuter = getApothem(outerWall); //gets the apothem of the outer wall
		//System.out.println(apothemOuter + " apothem outer");
		double apothemInner = getApothem(innerWall); //gets the apothem of the inner wall
		//System.out.println(apothemInner + " apothem inner");
		double areaOuter = getArea(outerWall, apothemOuter); //gets the area of the outer pentagon
		//System.out.println(areaOuter + " outer area");
		double areaInner = getArea(innerWall, apothemInner); //gets the area of the inner pentagon
		//System.out.println(areaInner + " inner area");
		double floor = getFloorAndRoof(areaOuter, areaInner); //gets the area of the floor
		//System.out.println((2 * floor) + " floor and ceiling area");
		double outerCost = getCost(surfaceAreaOuter); //gets the cost of the outer walls
		double innerCost = getCost(surfaceAreaInner); //gets the cost of the inner walls
		double floorCeilingCost = 2 * getCost(floor); // finds the cost of floor, then multiplies by 2 to account for the ceiling
		double totalSurfaceArea = (2*floor) + wallsSurfaceArea; // adds the surface areas together
		//System.out.println(totalSurfaceArea + " total SA");
		double totalCost = outerCost + innerCost + floorCeilingCost; // gets the total cost of the pentagon
		//System.out.println(totalCost + " total cost");
		//////////////////////////////////////////////////////////////
		printResults(name,wallsSurfaceArea, floor, totalSurfaceArea, totalCost); //prints the results

		//area of Pentagon = 5/2 * sideLength * apothem
		//apothem = sideLength/(2*tan(PI/numSides))
		//surface area of a side = sideLength * height
		//cost of material = 2.35 per inch, times the area, we need all sides, and a floor and roof
	}
	/*
		getString() will ask the user for a name for their pentagon and return it to the main method
	*/
	public static String getString(){
		System.out.print("Enter the name of the pentagon: ");
		String name = scan.nextLine();
		System.out.println("");
		return name;
	}
	/*
		getOuterWall() will get the input from the user as an int
		will return this number to the main method. It also has a built in 
		type-validation system so the user cannot enter anything other than an int.
	*/
	public static int getOuterWall(){
		System.out.print("Enter the length of the outer pentagon wall (inches): ");
		while(!scan.hasNextInt()){
			System.out.print("Please enter a valid number without a decimal: ");
			scan.next();
		}
		int outer = scan.nextInt();
		System.out.println("");
		return outer;
	}
	/*
		getInnerWall() will get the input from the user as an int
		will return this number to the main method. It also has a built in 
		type-validation system so the user cannot enter anything other than an int.
	*/
	public static int getInnerWall(){
		System.out.print("Enter the length of the inner pentagon wall (inches): ");
		while(!scan.hasNextInt()){
			System.out.print("Please enter a valid number without a decimal: ");
			scan.next();
		}
		int inner = scan.nextInt();
		System.out.println("");
		return inner;
	}
	/*
		getWallHeight() will get the input from the user as an int
		will return this number to the main method. It also has a built in 
		type-validation system so the user cannot enter anything other than an int.
	*/
	public static int getWallHeight(){
		System.out.print("Enter the height of the pentagon walls (inches): ");
		while(!scan.hasNextInt()){
			System.out.print("Please enter a valid number without a decimal: ");
			scan.next();
		}
		int height = scan.nextInt();
		System.out.println("");
		return height;
	}
	/*
		getSurfaceArea is passed the length of the wall and the height and calculates
		the surface area of it, and multiplies it by 5 to account for all of the walls.
		returns the surface area to the main method.
	*/
	public static int getSurfaceArea(int wall, int height){
		int surfaceArea = 5 * (wall * height);
		return surfaceArea;
	}
	/*
		getApothem() takes the wall length of the pentagon, and divides it by a formula that
		i replaced the number of sides with 5, since the user will always be using the program
		to find a pentagon.
	*/
	public static double getApothem(int wallLength){
		double apothem = wallLength/(2* Math.tan(Math.PI/5));
		return apothem;
	}
	/*
		getArea() receives the wall length and the apothem and multiples them together,
		and then by the result of 5.0/2.0. Make sure that the 5.0 and 2.0 contain the decimal,
		or integer divison will occur and cause a logical error.
	*/
	public static double getArea(int wallLength, double apothem){
		double area = (5.0/2.0) * wallLength * apothem;
		return area;
	}
	/*
		getFloorAndRoof receives outerArea and innerArea and subtracts them to find the area 
		between the two, which will be the floor and roof's surface area
	*/
	public static double getFloorAndRoof(double outerArea, double innerArea){
		double floorAndCeiling = (outerArea - innerArea);
		return floorAndCeiling;
	}
	/*
		getCost receives an amount of material, and multiples it by 2.35 to get the 
		cost of the amount of material.
	*/
	public static double getCost(double amount){
		double cost = amount * 2.35;
		return cost;
	}
	/*
		printResults receives the necessary values from the main method and prints off the
		results in the order required by the assignment.
	*/
	public static void printResults(String name, double wallsSurfaceArea, double floor, double totalSurfaceArea, double totalCost){
		System.out.println("The " + name + " area calculations are: ");
		System.out.println("	Surface area of the walls of the pentagon: " + wallsSurfaceArea + " square inches");
		System.out.println("	Floor and roof area: " + floor + " square inches each");
		System.out.println("	Total surface area: " + totalSurfaceArea + " square inches");
		System.out.println("The total cost of the material to build the " + name + " is " + totalCost);

	}
}