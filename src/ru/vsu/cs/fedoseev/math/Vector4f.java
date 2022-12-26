package ru.vsu.cs.fedoseev.math;

public class Vector4f extends Vector {

    public Vector4f(float[] values) throws VectorException {
        if(values.length == 4) {
            super.values = values;
            super.size = 4;
        } else {
            throw new VectorException("wrong number of elements");
        }
    }

    public Vector4f(float x, float y, float z, float w) {
        super.values = new float[4];
        super.values[0] = x;
        super.values[1] = y;
        super.values[2] = z;
        super.values[3] = w;
        super.size = 4;
    }

}
