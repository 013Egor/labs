public class Fraction {
	
	private int numerator;
	private int denominator;
	
	Fraction (int num, int denom) {
		
		this.numerator = num;
		
		if (denom == 0 && num != 0) {
			this.denominator = denom;
			
			System.out.println("You cannot set 0 to denominator. DEFALT VALUE : 1");	
		}
		else {
			this.denominator = denom;
		}
	}
	
	public void multiply (Fraction num) {
		
		this.numerator *= num.numerator;
		this.denominator *= num.denominator;
	
	}
	
	public void divide (Fraction num) {
		
		if (num.numerator == 0) {
			System.out.println("You cannot divide on 0 !!!");
		}
		else {
			this.numerator *= num.denominator;
			this.denominator *= num.numerator;
		}
	}
	
	public String toString () {
		
		if (this.numerator == 0) {
			return "" + this.numerator;
		}
		else {
			return "" + this.numerator + '/' + this.denominator; 
		}
		
	}
}
