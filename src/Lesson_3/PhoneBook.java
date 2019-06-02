package Lesson_3;

import java.util.*;

public class PhoneBook extends HashMap {
    public void add(String name, String phone) {
        this.put(phone, name);
    }

    public List<String> get(String fam) {
        Iterator<Map.Entry<String, String>> iter = this.entrySet().iterator();
        List<String> phoneNumbers = new ArrayList<>();
        while (iter.hasNext()) {
            Map.Entry<String, String> num = iter.next();
            if (num.getValue() == fam) {
                phoneNumbers.add(num.getKey());
            }
        }
        return phoneNumbers;
    }
}