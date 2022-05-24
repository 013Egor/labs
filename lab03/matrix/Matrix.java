package lab03.matrix;

import lab03.exception.*;
import lab03.matrix.ColumnMatrix;

public class Matrix {

    protected int[][] matrix;
    int rows;
    int columns;

    public Matrix(int row, int column) {
        rows = row;
        columns = column;
        matrix = new int[row][column];
    }

    public Matrix sum(Matrix term) {
        if (rows != term.rows || columns != term.columns) {
            throw new MyException("You cannot sum this matrixes");
        }

        int value;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                value = this.get(i, j) + term.get(i, j);
                this.set(i, j, value);
            }
        }

        return this;
    }

    public Matrix product(Matrix term) {
        if (columns != term.rows) {
            throw new MyException("You cannot product this matrixes");
        }

        int[][] temp = new int[rows][term.columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < term.columns; j++) {
                for (int t = 0; t < columns; t++) {
                    temp[i][j] += matrix[i][t] * term.matrix[t][j];
                }
            }
        }

        matrix = temp;

        return this;
    }

    public int get(int row, int column) {
        if (row > rows || column > columns) {
            throw new MyException("You cannot get this element");
        } else {
            return matrix[row][column];
        }
    }

    public void set(int row, int column, int value) {
        if (row > rows || column > columns) {
            throw new MyException("You cannot set this element");
        } else {
            matrix[row][column] = value;
        }
    }

    public boolean equals(Object o) {
        if (o instanceof Matrix) {
            Matrix obj = (Matrix) o;
            if (this.getColumns() != obj.getColumns() || this.getRows() != obj.getRows()) {
                return false;
            }

            for (int i = 0; i < this.getRows(); i++) {
                for (int j = 0;j < this.getColumns(); j++) {
                    if (this.get(i, j) != obj.get(i, j)) {
                        return false;
                    }
                }
            }

            return true;
        } else if (o instanceof SquareMatrix) {
            SquareMatrix obj = (SquareMatrix) o;
            if (this.getColumns() != obj.getColumns() || this.getRows() != obj.getRows()) {
                return false;
            }

            for (int i = 0; i < this.getRows(); i++) {
                for (int j = 0;j < this.getColumns(); j++) {
                    if (this.get(i, j) != obj.get(i, j)) {
                        return false;
                    }
                }
            }

            return true;
        } else if (o instanceof ColumnMatrix) {
            ColumnMatrix obj = (ColumnMatrix) o;
            if (this.getColumns() != obj.getColumns() || this.getRows() != obj.getRows()) {
                return false;
            }

            for (int i = 0; i < this.getRows(); i++) {
                for (int j = 0;j < this.getColumns(); j++) {
                    if (this.get(i, j) != obj.get(i, j)) {
                        return false;
                    }
                }
            }

            return true;
        } else {
            return false;
        }
    }

    public int getColumns(){
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public String toString() {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < this.getRows(); i++) {
            temp.append("| ");
            for (int j = 0;j < this.getColumns(); j++) {
                temp.append(this.get(i, j) + " ");
            }
            temp.append(" |\n");
        }

        return temp.toString();
    }
}