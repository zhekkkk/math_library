package ru.vsu.cs.fedoseev.math;

public class Vector3f extends Vector {

    public Vector3f(float[] values) throws VectorException {
        if(values.length == 3) {
            super.values = values;
            super.size = 3;
        } else {
            throw new VectorException("wrong number of elements");
        }
    }

    public Vector3f(float x, float y, float z) {
        super.values = new float[3];
        super.values[0] = x;
        super.values[1] = y;
        super.values[2] = z;
        super.size = 3;
    }

    public static Vector crossProduct(Vector3f vec1, Vector3f vec2) {
        Vector3f result = new Vector3f(0,0,0);
        result.values[0] = vec1.values[1] * vec2.values[2] - vec1.values[2] * vec2.values[1];
        result.values[1] = vec1.values[2] * vec2.values[0] - vec1.values[0] * vec2.values[2];
        result.values[2] = vec1.values[0] * vec2.values[1] - vec1.values[1] * vec2.values[0];
        return result;
    }
}
