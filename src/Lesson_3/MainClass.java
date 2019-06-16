package Lesson_3;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        ///////////
        //задание 1
        String[] arr = new String[]{"береза", "вишня", "груша", "дуб",
                "ель", "ива", "клен", "липа",
                "ольха", "пихта", "рябина", "сосна",
                "тополь", "ясень", "береза", "клен",
                "пихта", "клен", "береза", "ель",};

        Set<String> uniqueNames = new HashSet<>(Arrays.asList(arr));
        System.out.println(uniqueNames);

        List<String> arrList = new ArrayList<>(Arrays.asList(arr));

        Iterator<String> iteratorUniqueNames = uniqueNames.iterator();
        while (iteratorUniqueNames.hasNext()) {
            int count = 0;
            String strUN = iteratorUniqueNames.next();
            Iterator<String> iteratorArrList = arrList.iterator();
            while (iteratorArrList.hasNext()) {
                String strAL = iteratorArrList.next();
                if (strUN.equals(strAL)) {
                    count++;
                }
            }
            System.out.println(strUN + ": " + count);
        }

        ///////////
        //задание 2
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "111111");
        phoneBook.add("Петров", "222222");
        phoneBook.add("Федоров", "333333");
        phoneBook.add("Иванов", "999999");

        System.out.println("Иванов: " + phoneBook.get("Иванов"));
    }
}
