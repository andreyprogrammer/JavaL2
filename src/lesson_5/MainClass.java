package lesson_5;

public class MainClass {
    public static void method1() {
        final int SIZE = 10_000_000;
        float[] arr = new float[SIZE];

        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);
    }

    public static void methodParallelsTread() {
        final int SIZE = 10_000_000;
        final int H = SIZE / 2;
        float[] arr = new float[SIZE];
        float[] a1 = new float[H];
        float[] a2 = new float[H];

        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, H);
        System.arraycopy(arr, H, a2, 0, H);

        MyThread t1 = new MyThread(a1);
        t1.start();

        MyThread t2 = new MyThread(a2);
        t2.start();

        try {
            t1.join();
            t2.join();

            System.arraycopy(a1, 0, arr, 0, H);
            System.arraycopy(a2, 0, arr, H, H);

            System.out.println(System.currentTimeMillis() - a);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        method1();
        methodParallelsTread();
    }
}