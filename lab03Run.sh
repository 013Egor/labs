#!/bin/sh

javac lab03/Main.java lab03/exception/MyException.java lab03/matrix/Matrix.java lab03/matrix/SquareMatrix.java -d  outLab03;
cd outLab03 && java lab03.Main
