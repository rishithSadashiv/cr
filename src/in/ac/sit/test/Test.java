package in.ac.sit.test;

import java.util.Scanner;

import in.ac.sit.calculations.Calculations;
import in.ac.sit.entity.Equation;

public class Test {
	
	
	static void findSolution(Equation e1,Equation e2, Equation e3, int m) 
	{ 
	    // Matrix d using coeff as given in cramer's rule 
	    // Calculating Determinant of Matrices d, d1, d2, d3 
	    Calculations cal = new Calculations();
	    
	    int D = cal.computeDeterminantValue(e1.getA(), e2.getA(), e3.getA(), e1.getB(), e2.getB(), e3.getB(), e1.getC(), e2.getC(), e3.getC(), m); 
	    int D1 = cal.computeDeterminantValue(e1.getS(), e2.getS(), e3.getS(), e1.getB(), e2.getB(), e3.getB(), e1.getC(), e2.getC(), e3.getC(), m); 
	    int D2 = cal.computeDeterminantValue(e1.getA(), e2.getA(), e3.getA(), e1.getS(), e2.getS(), e3.getS(), e1.getC(), e2.getC(), e3.getC(), m); 
	    int D3 = cal.computeDeterminantValue(e1.getA(), e2.getA(), e3.getA(), e1.getB(), e2.getB(), e3.getB(), e1.getS(), e2.getS(), e3.getS(), m); 

	    System.out.printf("D is : %d \n", D); 
	    System.out.printf("D1 is : %d \n", D1); 
	    System.out.printf("D2 is : %d \n", D2); 
	    System.out.printf("D3 is : %d \n", D3); 
	  
	    // Case 1 
	    if (D != 0)  
	    { 
	        //Apply Cramer's Rule 
	        int x = cal.mult(D1 , cal.multiplicativeInverse(D, m),m); 
	        int y = cal.mult(D2 , cal.multiplicativeInverse(D, m),m);
	        int z = cal.mult(D3 , cal.multiplicativeInverse(D, m),m);// calculating z using cramer's rule 
	        System.out.printf("Value of x is : %d\n", x); 
	        System.out.printf("Value of y is : %d\n", y); 
	        System.out.printf("Value of z is : %d\n", z); 
	    } 
	      
	    // Case 2 
	    else 
	    { 
	        if (D1 == 0 && D2 == 0 && D3 == 0) 
	            System.out.printf("Infinite solutions\n"); 
	        else if (D1 != 0 || D2 != 0 || D3 != 0) 
	            System.out.printf("No solutions\n"); 
	    } 
	}

	public static void main(String[] args) {
		
		System.out.println("Enter the prime number: \n");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();sc.nextLine();
		int v[]= new int[n];
		System.out.println("\nEnter the coefficients of the equations: ");
		
			for(int j=0;j<4;j++)
			{
				System.out.println("Eqn 1: coeff: "+(j+1));
				v[j] = sc.nextInt();sc.nextLine();
			}
			Equation e1 = new Equation(v[0], v[1], v[2], v[3]);
			for(int j=0;j<4;j++)
			{
				System.out.println("Eqn 2: coeff: "+(j+1));
				v[j] = sc.nextInt();sc.nextLine();
			}
			Equation e2 = new Equation(v[0], v[1], v[2], v[3]);
			for(int j=0;j<4;j++)
			{
				System.out.println("Eqn 3: coeff: "+(j+1));
				v[j] = sc.nextInt();sc.nextLine();
			}
			Equation e3 = new Equation(v[0], v[1], v[2], v[3]);

			findSolution(e1,e2,e3,n); 

		
		sc.close();
	}

}
