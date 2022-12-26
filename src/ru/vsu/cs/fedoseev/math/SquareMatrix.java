package ru.vsu.cs.fedoseev.math;

public abstract class SquareMatrix {

    float[] values;

    int size;

    public abstract void setZeroMatrix();

    public abstract void setIdentityMatrix();

    public static class MatrixException extends Exception {

        public MatrixException(String cause) {
            super(cause);
        }

    }

    public static SquareMatrix add(SquareMatrix mat1, SquareMatrix mat2) throws MatrixException {
        if(mat1.size == mat2.size) {
            for (int i = 0; i < mat1.values.length; i++) {
                mat1.values[i] += mat2.values[i];
            }
        } else {
            throw new MatrixException("matrices of different sizes");
        }
        return mat1;
    }

    public static SquareMatrix subtract(SquareMatrix mat1, SquareMatrix mat2) throws MatrixException {
        if(mat1.size == mat2.size) {
            for (int i = 0; i < mat1.values.length; i++) {
                mat1.values[i] -= mat2.values[i];
            }
        } else {
            throw new MatrixException("matrices of different sizes");
        }
        return mat1;
    }

    public static SquareMatrix multiplyByMatrix(SquareMatrix mat1, SquareMatrix mat2) throws MatrixException {
        float[][] result = new float[mat1.size][mat1.size];
        if(mat1.size == mat2.size) {
            float[][] matrix1 = getSquareMatrix(mat1);
            float[][] matrix2 = getSquareMatrix(mat2);
            for (int i = 0; i < mat1.size; i++) {
                for (int j = 0; j < mat1.size; j++) {
                    for (int k = 0; k < mat1.size; k++) {
                        result[i][j] += matrix1[i][k] * matrix2[k][j];
                    }
                }
            }
        } else {
            throw new MatrixException("matrices of different sizes");
        }
        mat1.values = toArray(result);
        return mat1;
    }

    public static SquareMatrix transpose(SquareMatrix mat) {
        float[][] tmp = new float[mat.size][mat.size];
        float[][] matrix = getSquareMatrix(mat);
        for (int i = 0; i < mat.size; i++) {
            for (int j = 0; j < mat.size; j++) {
                tmp[j][i] = matrix[i][j];
            }
        }
        mat.values = toArray(tmp);
        return mat;
    }

    protected static float[][] getSquareMatrix(SquareMatrix mat) {
        float[][] matrix = new float[mat.size][mat.size];
        int k = 0;
        for(int i = 0; i < mat.size; i++) {
            for(int j = 0; j < mat.size; j++, k++) {
                matrix[i][j] = mat.values[k];
            }
        }
        return matrix;
    }

    protected static boolean isSquareMatrix(float[][] matrix) {
        if(matrix.length == matrix[0].length) {
            return true;
        } else {
            return false;
        }
    }

    protected static float[] toArray(float[][] values) {
        float[] result = new float[values.length*values.length];
        int k = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[0].length; j++, k++) {
                result[k] = values[i][j];
            }
        }
        return result;
    }

    public float[] getValues() {
        return values;
    }

    public int getSize() {
        return size;
    }
}
