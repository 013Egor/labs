public class Main {

	public static void main ( String[] arg ) {

		Int myInt = new Int();
		Int myInt_temp = new Int();

		System.out.println(myInt);
		myInt.increment();
		myInt_temp.increment();
		for ( int i = 0; i < 10; i++ ) {
			myInt.add(myInt);

			if ( i < 5 ) {
				myInt_temp.add(myInt_temp);
			} else {
				myInt_temp.decrement();
			}
			if ( i >= 7 ) {
				myInt_temp.decrement();
			}
		}
		myInt.substract(myInt_temp);
		System.out.println(myInt);

		Fraction firstFraction = new Fraction (-3, 7);
		Fraction secondFraction = new Fraction (0, 5);
		Fraction thirdFraction = new Fraction (6, 5);

		System.out.println("Первая дробь: " + firstFraction);
		System.out.println("Вторая дробь: " + secondFraction);
		System.out.println("Третья дробь: " + thirdFraction);

		firstFraction.multiply(secondFraction);
		System.out.println("Первая дробь * вторая дробь(ответ заносится в первую дробь): " + firstFraction);
		firstFraction.divide(thirdFraction);
		System.out.println("Первая дробь / вторая дробь(ответ заносится в первую дробь): " + firstFraction);
	}
}
