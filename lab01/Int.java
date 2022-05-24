public class Int {

	private int num;

	public int increment () {
		this.num += 1;
		return this.num;
	}

	public int decrement () {
		this.num -= 1;
		return this.num;
	}

	public int add ( Int numToAdd ) {
		this.num += numToAdd.num;
		return this.num;
	}

	public int substract ( Int numToSub ) {
		this.num -= numToSub.num;
		return this.num;
	}

	public String toString () {
		return "" + this.num;
	}
}
