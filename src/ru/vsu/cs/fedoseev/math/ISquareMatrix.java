package ru.vsu.cs.fedoseev.math;

public interface ISquareMatrix {

    SquareMatrix add(SquareMatrix other) throws SquareMatrix.MatrixException;

    SquareMatrix subtract(SquareMatrix other) throws SquareMatrix.MatrixException;

    SquareMatrix multiplyByMatrix(SquareMatrix other) throws SquareMatrix.MatrixException;

    SquareMatrix transpose();



}
