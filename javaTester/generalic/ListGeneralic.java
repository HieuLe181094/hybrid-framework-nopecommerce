package generalic;

import java.util.ArrayList;
import java.util.List;

public class ListGeneralic {
    public static void main(String[] args){
        // Non-Generalic
        ArrayList student = new ArrayList<>();

        // String
        student.add("Nguyen Van B");

//        // Boolean
//        student.add(true);
//
//        // Integer
//        student.add(50);
//
//        // Char
//        student.add('A');

        for (int i = 0; i < student.size(); i++){
            System.out.println(student.get(i));
        }

        // Genelic
        ArrayList<String> students = new ArrayList<String>();
    }
}
