import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vsu.cs.fedoseev.math.Vector;
import ru.vsu.cs.fedoseev.math.Vector2f;
import ru.vsu.cs.fedoseev.math.Vector3f;
import ru.vsu.cs.fedoseev.math.Vector4f;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class VectorTest {

    private final float exp = (float) 0.00001;

    @Test
    public void testAdd() throws Vector.VectorException {
        Vector2f vector2f1 = new Vector2f(new float[]{3, 5});
        Vector2f vector2f2 = new Vector2f(new float[]{-3, 5});

        Vector result1 = Vector.add(vector2f1, vector2f2);
        Vector expectedResult1 = new Vector2f(new float[]{0, 10});
        Assertions.assertArrayEquals(result1.getValues(), expectedResult1.getValues());

        Vector3f vector3f1 = new Vector3f(new float[]{1, 2, 3});
        Vector3f vector3f2 = new Vector3f(new float[]{1, 2, 4});

        Vector result2 = Vector.add(vector3f1, vector3f2);
        Vector expectedResult2 = new Vector3f(new float[]{2, 4, 7});
        Assertions.assertArrayEquals(result2.getValues(), expectedResult2.getValues());

        Vector.VectorException thrown = Assertions.assertThrows(Vector.VectorException.class, () -> {
            float[] vectorFirst = new float[]{-3.333f, 0.898f};
            float[] vectorSecond = new float[]{-4.21f, 2.34f, 1};
            Vector v1 = new Vector2f(vectorFirst);
            Vector v2 = new Vector3f(vectorSecond);
            v1.add(v1, v2);
        });
        Assertions.assertEquals("vectors of different sizes", thrown.getMessage());
    }

    @Test
    public void testSubtract() throws Vector.VectorException {
        Vector2f vector2f1 = new Vector2f(new float[]{3, 5});
        Vector2f vector2f2 = new Vector2f(new float[]{-3, 5});

        Vector result1 = Vector.subtract(vector2f1, vector2f2);
        Vector expectedResult1 = new Vector2f(new float[]{6, 0});
        Assertions.assertArrayEquals(result1.getValues(), expectedResult1.getValues());

        Vector3f vector3f1 = new Vector3f(new float[]{1, 2, 3});
        Vector3f vector3f2 = new Vector3f(new float[]{1, 2, 4});

        Vector result2 = Vector.subtract(vector3f1, vector3f2);
        Vector expectedResult2 = new Vector3f(new float[]{0, 0, -1});
        Assertions.assertArrayEquals(result2.getValues(), expectedResult2.getValues());

        Vector.VectorException thrown = Assertions.assertThrows(Vector.VectorException.class, () -> {
            float[] vectorFirst = new float[]{-3.333f, 0.898f};
            float[] vectorSecond = new float[]{-4.21f, 2.34f, 1};
            Vector v1 = new Vector2f(vectorFirst);
            Vector v2 = new Vector3f(vectorSecond);
            v1.subtract(v1, v2);
        });
        Assertions.assertEquals("vectors of different sizes", thrown.getMessage());
    }

    @Test
    public void testMultiplyByScalar() throws Vector.VectorException {
        Vector2f vector2f1 = new Vector2f(new float[]{3, 5});
        float scalar1 = (float) 43.89;

        Vector result1 = Vector.multiplyByScalar(vector2f1, scalar1);
        Vector expectedResult1 = new Vector2f(new float[]{(float)131.67, (float)219.45});
        Assertions.assertArrayEquals(result1.getValues(), expectedResult1.getValues());
    }

    @Test
    public void testDivideByScalar() throws Vector.VectorException {
        Vector.VectorException thrown = Assertions.assertThrows(Vector.VectorException.class, () -> {
            float[] vectorFirst = new float[]{-3.333f, 0.898f};
            float scalar = 0;
            Vector v1 = new Vector2f(vectorFirst);
            v1.divideByScalar(v1, scalar);
        });

        float[] vectorValueFirst = new float[]{3.333f, 0.898f};
        Vector vector1 = new Vector2f(vectorValueFirst);
        float scalar = -0.18f;

        float[] expected = new float[]{-18.516666f, -4.98889f};
        vector1 = Vector.divideByScalar(vector1, scalar);
        assertArrayEquals(expected, vector1.getValues(), exp);
    }

    @Test
    public void testLength() throws Vector.VectorException {
        float[] vectorValue = new float[]{-3.3f, 0.89f};
        Vector vector = new Vector2f(vectorValue);
        Assertions.assertEquals(3.41790, Vector.length(vector), exp);

        vectorValue = new float[]{-3.3f, 0.89f, 2};
        vector = new Vector3f(vectorValue);
        Assertions.assertEquals(3.96006, Vector.length(vector), exp);

        vectorValue = new float[]{-3.3f, 0.89f, 2, -3};
        vector = new Vector4f(vectorValue);
        Assertions.assertEquals(4.96810, Vector.length(vector), exp);

        vectorValue = new float[]{0,0};
        vector = new Vector2f(vectorValue);
        Assertions.assertEquals(0, Vector.length(vector), exp);
    }

    @Test
    public void testNormalize() throws Vector.VectorException {
        Vector3f vector3f = new Vector3f(new float[]{8, 6, 0});

        Vector result = Vector.normalize(vector3f);
        Vector expectedResult = new Vector3f(new float[]{(float)0.8, (float)0.6, 0});
        Assertions.assertArrayEquals(result.getValues(), expectedResult.getValues());
    }
}

