public class Main{

	public static void main ( String[] argv ) {

		int size = 2;
		int arrayAmount = 10;
		Matrix matrix = new Matrix(size);
		Matrix[] temp = new Matrix [arrayAmount];

		for (int i = 0; i < arrayAmount; i++) {
			temp[i] = new Matrix(size);
		}

		System.out.println(matrix);

		matrix.setElement(0, 0, 1);
		matrix.setElement(0, 1, 1);
		matrix.setElement(1, 0, 1);
		matrix.setElement(1, 1, 1);

		System.out.println(matrix);

		for (int i = 0; i < arrayAmount; i++) {
			temp[i].setElement(0, 0, 1);
			temp[i].setElement(0, 1, 1);
			temp[i].setElement(1, 0, 1);
			temp[i].setElement(1, 1, 1);
		}

		matrix.productArray(temp);

		System.out.println(matrix);
		for ( int i =0 ; i < 10 ; i++ ) {
			System.out.println(matrix);

		}
	}
}
