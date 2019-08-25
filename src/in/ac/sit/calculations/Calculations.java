package in.ac.sit.calculations;

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

}
