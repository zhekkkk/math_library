package ru.vsu.cs.fedoseev.math;

public interface IVector {

    Vector add(Vector vec1, Vector vec2) throws Vector.VectorException;

    Vector subtract(Vector vec1, Vector vec2) throws Vector.VectorException;

    Vector multiplyByScalar(float v);

    Vector divideByScalar(float v) throws Vector.VectorException;

    float length();

    Vector normalize();

    float dotProduct(Vector other) throws Vector.VectorException;

    float[] getValues();

    int getSize();

}
