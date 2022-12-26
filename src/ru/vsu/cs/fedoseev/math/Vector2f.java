package ru.vsu.cs.fedoseev.math;

public class Vector2f extends Vector /*implements IVector*/{

    public Vector2f(float[] values) throws VectorException {
        if(values.length == 2) {
            super.values = values;
            super.size = 2;
        } else {
            throw new VectorException("wrong number of elements");
        }
    }

    public Vector2f(float x, float y) {
        super.values = new float[2];
        super.values[0] = x;
        super.values[1] = y;
        super.size = 2;
    }

}
