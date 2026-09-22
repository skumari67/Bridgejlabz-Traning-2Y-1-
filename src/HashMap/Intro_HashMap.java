package HashMap;

import java.util.HashMap;

public class Intro_HashMap {
    public static void main(String[] args) {
        HashMap<String,Integer> studentsAges = new HashMap<>();
        studentsAges.put("rahul",19);
        studentsAges.put("sanjana",20);
        studentsAges.put("sanjana",21);
        studentsAges.put("malay",22);
        System.out.println(studentsAges);
        System.out.println("sanjana age is :"+studentsAges.get("rahul"));
        boolean hassanjana = studentsAges.containsKey("sanjana");
        System.out.println(hassanjana);
        boolean hasage = studentsAges.containsValue(20);
    }
}
