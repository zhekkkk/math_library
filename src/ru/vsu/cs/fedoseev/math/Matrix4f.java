package ru.vsu.cs.fedoseev.math;

public class Matrix4f extends SquareMatrix {

    public Matrix4f(float[] values) throws MatrixException {
        if(values.length == 16) {
            super.values = values;
            super.size = 4;
        } else {
            throw new MatrixException("wrong number of elements");
        }
    }

    public Matrix4f(float[][] values) throws MatrixException {
        if(isSquareMatrix(values) && values.length == 4) {
            super.size = 16;
            int k = 0;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++, k++) {
                    super.values[k] = values[i][j];
                }
            }
        } else {
            throw new MatrixException("wrong number of elements");
        }
    }

    @Override
    public Vector multiplyByVector(SquareMatrix mat, Vector vec) throws MatrixException {
        Vector4f result = new Vector4f(0,0,0, 0);
        if(vec.size == 4) {
            float[][] matrix = getSquareMatrix(mat);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    result.values[j] = matrix[i][j] + vec.values[j];
                }
            }
        } else {
            throw new MatrixException("vector and matrix have different sizes");
        }
        return result;
    }

}
