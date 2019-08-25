package in.ac.sit.calculations;

import in.ac.sit.entity.Equation;

public class Calculations {
	
	public int[][] getAddnTable(int n)
	{
		int[][] a = new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				a[i][j] = (i+j)%n;
			}
		}
		return a;
	}
	
	public int[][] getMultTable(int n)
	{
		int[][] m = new int[n-1][n-1];
		for(int i=0;i<n-1;i++)
		{
			for(int j=0;j<n-1;j++)
			{
				m[i][j] = ((i+1)*(j+1))%n;
			}
		}
		return m;
	}
	
	public int computeDeterminantValue(int a1,int a2,int a3,int b1,int b2, int b3, int c1,int c2,int c3, int m)
	{
		int v;
		v=sum( mult(a1,sum(mult(b2,c3,m),-mult(b3,c2,m),m),m), -mult(b1,sum(mult(a2,c3,m),-mult(a3,c2,m),m),m), mult(c1,sum(mult(a2,b3,m),-mult(a3,b2,m),m),m),m);
		if(v<0)
			v = additiveInverse(v, m);
		return v;
	}
	
	public int sum(int p,int q,int m)
	{
		return ((p+q)%m);
	}
	
	public int sum(int p,int q,int r, int m)
	{
		return ((p+q+r)%m);
	}
	
	public int mult(int p,int q,int m)
	{
		return ((p*q)%m);
	}	
	
	public int multiplicativeInverse(int a, int m)
	{
		a = a % m;
		for(int x = 1; x<m;x++)
		{
			if((a*x)%m==1)
				return x;
		}
		return 1;
	}
	
	public int additiveInverse(int a, int m)
	{
		a = a % 5;
		a = Math.abs(a);
		for(int x = 0; x < m; x++)
		{
			if(( a + x ) % m == 0)
			{
				return x;
			}
		}
		return 0;
	}
	
	void findSolution(Equation e1,Equation e2, Equation e3, int m) 
	{ 
	    // Matrix d using coeff as given in cramer's rule 
	    // Calculating Determinant of Matrices d, d1, d2, d3 
	    	    
	    int D = computeDeterminantValue(e1.getA(), e2.getA(), e3.getA(), e1.getB(), e2.getB(), e3.getB(), e1.getC(), e2.getC(), e3.getC(), m); 
	    int D1 = computeDeterminantValue(e1.getS(), e2.getS(), e3.getS(), e1.getB(), e2.getB(), e3.getB(), e1.getC(), e2.getC(), e3.getC(), m); 
	    int D2 = computeDeterminantValue(e1.getA(), e2.getA(), e3.getA(), e1.getS(), e2.getS(), e3.getS(), e1.getC(), e2.getC(), e3.getC(), m); 
	    int D3 = computeDeterminantValue(e1.getA(), e2.getA(), e3.getA(), e1.getB(), e2.getB(), e3.getB(), e1.getS(), e2.getS(), e3.getS(), m); 

	    System.out.printf("D is : %d \n", D); 
	    System.out.printf("D1 is : %d \n", D1); 
	    System.out.printf("D2 is : %d \n", D2); 
	    System.out.printf("D3 is : %d \n", D3); 
	  
	    // Case 1 
	    if (D != 0)  
	    { 
	        //Apply Cramer's Rule 
	        int x = mult(D1 , multiplicativeInverse(D, m),m); 
	        int y = mult(D2 , multiplicativeInverse(D, m),m);
	        int z = mult(D3 , multiplicativeInverse(D, m),m);// calculating z using cramer's rule 
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

}
