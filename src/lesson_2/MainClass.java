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

        try {
            System.out.println(sumArr(arr));
        } catch (MyArraySizeException e1) {
            System.out.println(e1.getMessage());
        } catch (MyArrayDataException e2) {
            System.out.println(e2.getMessage());
        }
    }

    static int sumArr(String ar[][]) throws MyArraySizeException, MyArrayDataException {
        if (ar.length != 4 || ar[0].length != 4) {
            throw new MyArraySizeException("Размерность массива не соответствует 4х4");
        }

        int result = 0;
        int a = -1;
        int b = -1;

        try {
            for (int i = 0; i < ar.length; i++) {
                for (int j = 0; j < ar[0].length; j++) {
                    a = i;
                    b = j;
                    result += Integer.parseInt(ar[i][j]);
                }
            }
        } catch (NumberFormatException e) {
            throw new MyArraySizeException("В ячейке [" + a + "][" + b + "] несоответствующий тип данных");
        }
        return result;
    }



}
