import java.util.*;
import java.util.HashMap;
import java.util.Map;


public class Itog_Java {
    public static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    public static void main(String[] args) {
        add("Anton", 123);
        add("Anton", 234);
        add("Anton", 345);
        add("Timur", 345);
        add("timur", 567);
        add("Anton", 567);
        add("Jon", 567);
        System.out.println(findName("timur"));
        getPhoneBook();
    }


    static void add(String name, Integer phoneNum) {
        name = name.substring(0, 1).toUpperCase() + name.substring(1);

        if (phoneBook.containsKey(name)) {
            ArrayList<Integer> list = phoneBook.get(name);
            list.add(phoneNum);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(phoneNum);
            phoneBook.put(name, list);
        }
    }

    static ArrayList<Integer> findName(String name) {
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        ArrayList<Integer> list = new ArrayList<>();
        if (phoneBook.containsKey(name)) {
            list = phoneBook.get(name);
            if (list.isEmpty()) {
                System.out.println("У контакта" + name + "есть такие номера :");
            }
            return list;
        } else {
            System.out.println("Такого контакта не существует");
        }
        return list;
    }

    public static void getPhoneBook() {

        ArrayList<Map.Entry<String, ArrayList>> entries = new ArrayList(phoneBook.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, ArrayList>>() {
            public int compare(Map.Entry<String, ArrayList> o1, Map.Entry<String, ArrayList> o2) {
                return o2.getValue().size() - o1.getValue().size();
            }
        });
        for (Map.Entry<String, ArrayList> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());


        }
    }
}

