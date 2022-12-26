import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vsu.cs.fedoseev.math.*;

public class SquareMatrixTest {

    private final float exp = (float) 0.00001;

    @Test
    public void testAdd() throws SquareMatrix.MatrixException {
        SquareMatrix matrix1 = new Matrix3f(new float[]{3, 5, 9, 3, 56, 88, 0, -32.88888f, 909});
        SquareMatrix matrix2 = new Matrix3f(new float[]{23, 90, 1.22222f, 76, 0, 0, 0, 12, 101111});

        SquareMatrix result = SquareMatrix.add(matrix1, matrix2);
        SquareMatrix expectedResult1 = new Matrix3f(new float[]{26, 95, 10.222219f, 79, 56, 88, 0, -20.888882f, 102020});
        Assertions.assertArrayEquals(result.getValues(), expectedResult1.getValues());

        SquareMatrix.MatrixException thrown = Assertions.assertThrows(SquareMatrix.MatrixException.class, () -> {
            float[] valFirst = new float[]{-3.333f, 0.898f, 34.56f, -1.6666f, -3.333f, 0.898f, 34.56f, -1.6666f, 0.898f};
            float[] valSecond = new float[]{-3.333f, 0.898f, 34.56f, -1.6666f, -3.333f, 0.898f, 34.56f, -1.6666f, 0.898f, -3.333f, 0.898f, 34.56f, -1.6666f, -3.333f, 0.898f, 34.56f};
            SquareMatrix v1 = new Matrix3f(valFirst);
            SquareMatrix v2 = new Matrix4f(valSecond);
            v1.add(v1, v2);
        });
        Assertions.assertEquals("matrices of different sizes", thrown.getMessage());
    }

    @Test
    public void testSubtract() throws SquareMatrix.MatrixException {
        SquareMatrix matrix1 = new Matrix3f(new float[]{3, 5, 9, 3, 56, 88, 0, -32.88888f, 909});
        SquareMatrix matrix2 = new Matrix3f(new float[]{23, 90, 1.22222f, 76, 0, 0, 0, 12, 101111});

        SquareMatrix result = SquareMatrix.subtract(matrix1, matrix2);
        SquareMatrix expectedResult1 = new Matrix3f(new float[]{-20, -85, 7.77778f, -73, 56, 88, 0, -44.88888f, -100202});
        Assertions.assertArrayEquals(result.getValues(), expectedResult1.getValues());

        SquareMatrix.MatrixException thrown = Assertions.assertThrows(SquareMatrix.MatrixException.class, () -> {
            float[] valFirst = new float[]{-3.333f, 0.898f, 34.56f, -1.6666f, -3.333f, 0.898f, 34.56f, -1.6666f, 0.898f};
            float[] valSecond = new float[]{-3.333f, 0.898f, 34.56f, -1.6666f, -3.333f, 0.898f, 34.56f, -1.6666f, 0.898f, -3.333f, 0.898f, 34.56f, -1.6666f, -3.333f, 0.898f, 34.56f};
            SquareMatrix v1 = new Matrix3f(valFirst);
            SquareMatrix v2 = new Matrix4f(valSecond);
            v1.subtract(v1, v2);
        });
        Assertions.assertEquals("matrices of different sizes", thrown.getMessage());
    }

    @Test
    public void testMultiplyByVector() throws SquareMatrix.MatrixException, Vector.VectorException {
        SquareMatrix matrix = new Matrix3f(new float[]{3, 5, 9, 3, 56, 88, 0, -32.88888f, 909});
        Vector vector = new Vector3f(new float[]{1, 2, 4});

        Vector result = Matrix3f.multiplyByVector(matrix, vector);
        Vector expectedResult = new Vector3f(1,-30.888882f,913);
        Assertions.assertArrayEquals(result.getValues(), expectedResult.getValues());

        SquareMatrix.MatrixException thrown = Assertions.assertThrows(SquareMatrix.MatrixException.class, () -> {
            float[] valFirst = new float[]{-3.333f, 0.898f, 34.56f, -1.6666f, -3.333f, 0.898f, 34.56f, -1.6666f, 0.898f};
            float[] vec = new float[]{-3.333f, 0.898f, 34.56f, -1.6666f};
            SquareMatrix v1 = new Matrix3f(valFirst);
            Vector v2 = new Vector4f(vec);
            Vector res = Matrix3f.multiplyByVector(v1, v2);
        });
        Assertions.assertEquals("vector and matrix have different sizes", thrown.getMessage());
    }

    @Test
    public void testMultiplyByMatrix() throws SquareMatrix.MatrixException {
        SquareMatrix matrix1 = new Matrix3f(new float[]{3, 5, 9, 3, 56, 88, 0, -32.88888f, 909});
        SquareMatrix matrix2 = new Matrix3f(new float[]{67, 12, 9, -8.67676f, 0.00001f, 15, 0, 32.88888f, 999.999f});

        SquareMatrix result = SquareMatrix.multiplyByMatrix(matrix1, matrix2);
        SquareMatrix expectedResult = new Matrix3f(157.61621f, 332, 9101.991f, -284.89856f, 2930.2222f, 88866.914f, 285.36893f, 29895.994f, 908505.8f);
        Assertions.assertArrayEquals(result.getValues(), expectedResult.getValues());

        SquareMatrix.MatrixException thrown = Assertions.assertThrows(SquareMatrix.MatrixException.class, () -> {
            float[] valFirst = new float[]{-3.333f, 0.898f, 34.56f, -1.6666f, -3.333f, 0.898f, 34.56f, -1.6666f, 0.898f};
            float[] valSecond = new float[]{-3.333f, 0.898f, 34.56f, -1.6666f, -3.333f, 0.898f, 34.56f, -1.6666f, 0.898f, -3.333f, 0.898f, 34.56f, -1.6666f, -3.333f, 0.898f, 34.56f};
            SquareMatrix v1 = new Matrix3f(valFirst);
            SquareMatrix v2 = new Matrix4f(valSecond);
            SquareMatrix res = Matrix3f.multiplyByMatrix(v1, v2);
        });
        Assertions.assertEquals("matrices of different sizes", thrown.getMessage());
    }

    @Test
    public void testTranspose() throws SquareMatrix.MatrixException {
        SquareMatrix matrix = new Matrix3f(new float[]{1,2,3,4,5,6,7,8,9});

        SquareMatrix result = SquareMatrix.transpose(matrix);
        SquareMatrix expectedResult = new Matrix3f(1,4,7,2,5,8,3,6,9);
        Assertions.assertArrayEquals(result.getValues(), expectedResult.getValues());
    }

}
