package ru.vsu.cs.fedoseev.math;

public abstract class Vector {

    protected float[] values;

    protected int size;

    static final float eps = 1e-7f;

    public static class VectorException extends Exception {

        public VectorException(String cause) {
            super(cause);
        }

    }

    public static Vector add(Vector vec1, Vector vec2) throws VectorException {
        if (vec1.size == vec2.size) {
            for(int i = 0; i < vec1.size; i++) {
                vec1.values[i] += vec2.values[i];
            }
        } else {
            throw new VectorException("vectors of different sizes");
        }
        return vec1;
    }

    public static Vector subtract(Vector vec1, Vector vec2) throws VectorException {
        if (vec1.size == vec2.size) {
            for(int i = 0; i < vec1.size; i++) {
                vec1.values[i] -= vec2.values[i];
            }
        } else {
            throw new VectorException("vectors of different sizes");
        }
        return vec1;
    }

    public static Vector multiplyByScalar(Vector vec, float v) {
        for(int i = 0; i < vec.size; i++) {
            vec.values[i] *= v;
        }
        return vec;
    }

    public static Vector divideByScalar(Vector vec, float v) throws VectorException {
        if(Math.abs(v) > eps) {
            for (int i = 0; i < vec.size; i++) {
                vec.values[i] *= v;
            }
        } else {
            throw new VectorException("zero division error");
        }
        return vec;
    }

    public static float length(Vector vec) {
        double temp = 0;
        for(int i = 0; i < vec.size; i++) {
            temp += Math.pow(vec.values[i], 2);
        }
        return (float) Math.sqrt(temp);
    }

    public static Vector normalize(Vector vec) {
        float length = length(vec);
        for(int i = 0; i < vec.size; i++) {
            vec.values[i] /= length;
        }
        return vec;
    }

    public static float dotProduct(Vector vec, Vector other) throws VectorException {
        double cos = 0;
        double sum = 0;
        double prod = 1;
        if(vec.size == other.size) {
            for (int i = 0; i < vec.size; i++) {
                sum += vec.values[i] + other.values[i];
                prod *= Math.pow(vec.values[i] * other.values[i], 2);
            }
            cos = sum / Math.sqrt(prod);
        } else {
            throw new VectorException("vectors of different sizes");
        }
        return length(vec) * length(other) * (float) cos;
    }

    public static Vector zero(Vector vec) {
        for(int i = 0; i < vec.size; i++) {
            vec.values[i] = 0;
        }
        return vec;
    }

    public float[] getValues() {
        return this.values;
    }

    public int getSize() {
        return this.size;
    }

    public static void printVector(Vector vector) {
        for(float i: vector.values) {
            System.out.print(i + " ");
        }
    }
}
