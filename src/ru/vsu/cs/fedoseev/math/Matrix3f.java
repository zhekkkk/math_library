package ru.vsu.cs.fedoseev.math;

public class Matrix3f extends SquareMatrix {

    public Matrix3f(float[] values) throws MatrixException {
        if(values.length == 9) {
            super.values = values;
            super.size = 3;
        } else {
            throw new MatrixException("wrong number of elements");
        }
    }

    public Matrix3f(float[][] values) throws MatrixException {
        if(isSquareMatrix(values) && values.length == 3) {
            super.size = 9;
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

    public Matrix3f(float e1, float e2, float e3, float e4, float e5, float e6, float e7, float e8, float e9) {
        super.values = new float[9];
        super.values[0] = e1;
        super.values[1] = e2;
        super.values[2] = e3;
        super.values[3] = e4;
        super.values[4] = e5;
        super.values[5] = e6;
        super.values[6] = e7;
        super.values[7] = e8;
        super.values[8] = e9;
        super.size = 3;
    }

    @Override
    public void setZeroMatrix() {
        super.size = 3;
        super.values = new float[]{0,0,0,0,0,0,0,0,0};
    }

    @Override
    public void setIdentityMatrix() {
        super.size = 3;
        super.values = new float[]{1,0,0,0,1,0,0,0,1};
    }

    public static Vector multiplyByVector(SquareMatrix mat, Vector vec) throws MatrixException {
        Vector3f result = new Vector3f(0,0,0);
        if(vec.size == 3) {
            float[][] matrix = getSquareMatrix(mat);
            for (int i = 0; i < mat.size; i++) {
                for (int j = 0; j < mat.size; j++) {
                    result.values[j] = matrix[i][j] + vec.values[j];
                }
            }
        } else {
            throw new MatrixException("vector and matrix have different sizes");
        }
        return result;
    }

}
