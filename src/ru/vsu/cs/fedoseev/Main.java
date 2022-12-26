package ru.vsu.cs.fedoseev;

import ru.vsu.cs.fedoseev.math.*;

public class Main {

    public static void main(String[] args) throws Vector.VectorException {
        Vector3f vec1 = new Vector3f(2,6,9);
        Vector3f vec2 = new Vector3f(8,9,6);

        Vector2f v2f1 = new Vector2f(new float[]{3, 5});
        Vector2f v2f2 = new Vector2f(new float[]{-3, 5});

        try {
            Vector result = Vector.add(v2f1, v2f2);
            Vector.printVector(result);
            System.out.println();
            Vector.printVector(v2f1);
            System.out.println();
            Vector.printVector(v2f2);
        } catch (Exception VectorException) {
            System.out.println("fkdsln");
        }
    }
}
