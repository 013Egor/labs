public class Matrix {

	private int size;

	private int[][] matrix;

	public Matrix ( int size ) {

		this.size = size;
		this.matrix = new int [size][size];

		for ( int i = 0 ; i < size ; i++ ) {
			for ( int j = 0 ; j < size; j++ ) {
				if(i == j){
					this.matrix[i][j] = 1;
				} else {
					this.matrix[i][j] = 0;
				}
			}
		}
	}

	public Matrix sum ( Matrix matrix ) {

		if ( this.size != matrix.size ) {
			System.out.println("You cannot sum those matrices");
			return this;
		}

		for ( int i = 0; i < this.size; i++ ) {
			for ( int j = 0; j < this.size; j++ ) {
				this.matrix[i][j] += matrix.matrix[i][j];
			}
		}

		return this;
	}

	public Matrix product ( Matrix matrix ) {
		if ( this.size != matrix.size ) {
			System.out.println("You cannot product those matrices");
			return this;
		}

		int[][] temp = new int [this.size][this.size];

		for ( int i = 0; i < this.size; i++ ) {
			for ( int j = 0; j < this.size; j++ ) {
				for ( int t = 0; t < this.size; t++ ) {
					temp[i][j] += matrix.matrix[i][t] * this.matrix[t][j];
				}
			}
		}
		this.matrix = temp;

		return this;
	}

	public Matrix productArray ( Matrix[] array ) {

		for (int i = 0; i < array.length; i++) {
			this.product(array[i]);
			System.out.println(this);
		}

		return this;
	}

	public void setElement ( int row, int column, int value ) {

		if ( row < this.size && column < this.size ) {
			this.matrix[row][column] = value;
		} else {
			System.out.println("You cannot set vaule on this position.");
		}
	}

	public int getElement ( int row, int column ) {
		if ( row  >= this.size || column >= this.size ) {
			System.out.println("You cannot get element from this position");
			return 0;
		}

		return this.matrix[row][column];
	}

	public String toString () {

		StringBuilder temp = new StringBuilder ();

		for ( int i = 0; i < this.size ; i++) {
			temp.append("| ");
			for ( int j = 0; j < this.size; j++ ) {
				temp.append(matrix[i][j]);
				temp.append(' ');
			}
			temp.append("|\n");
		}

		return temp.toString();
	}
}
