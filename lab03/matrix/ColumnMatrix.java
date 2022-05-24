package lab03.matrix;

import lab03.exception.MyException;
import lab03.matrix.Matrix;

public class ColumnMatrix extends Matrix {
    int rows;
    int columns;
    public ColumnMatrix(int row, int column) {
        super(1, column);
        this.rows = row;
        this.columns = column;
    }

    public int get(int row, int column) {
        if (row > rows || column > columns) {
            throw new MyException("You cannot get this element");
        } else {
            return matrix[0][column];
        }
    }

    public void set(int row, int column, int value) {
        if (row > rows || column > columns) {
            throw new MyException("You cannot set this element");
        } else {
            matrix[0][column] = value;
        }
    }

    public int getColumns(){
        return columns;
    }

    public int getRows() {
        return rows;
    }
}
