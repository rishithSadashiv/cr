package in.ac.sit.entity;

public class Equation {
	
	int a,b,c,s;

	public Equation(int a, int b, int c, int s) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.s = s;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getS() {
		return s;
	}

	public void setS(int s) {
		this.s = s;
	}

	@Override
	public String toString() {
		return "Equation [a=" + a + ", b=" + b + ", c=" + c + ", s=" + s + "]";
	}
	
	

}
