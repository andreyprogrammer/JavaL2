package lesson_2;

public class MainClass {
    public static void main(String[] args) {

        String[][] arr = new String[4][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = "" + i + j;
            }
        }

        arr[2][2] = "a";

//        for (int i = 0; i < arr1.length; i++) {
//            for (int j = 0; j < arr1[0].length; j++) {
//                System.out.print(arr1[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(sumArr(arr));


    }

    static int sumArr(String a[][]) {

        int result = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                result += Integer.parseInt(a[i][j]);
            }
        }
        return result;
    }



}
