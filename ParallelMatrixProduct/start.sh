#!/bin/sh

javac src/Main.java src/ParallelMatrixProduct.java src/Product.java -d bin;
cd bin && java src.Main;
