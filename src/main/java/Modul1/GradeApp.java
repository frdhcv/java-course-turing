package Modul1;

public class GradeApp {
    public static void main(String[] args) {
        String[] name = {"Farid", "Vusal", "Ismayil", "Osman"};
        int[] grade = {20, 15, 8, 9};
        int[] age = {18, 19, 21, 27};
        for (int i = 0; i < grade.length; i++) {
            int max = 0;
            if (max < grade[i]) {
                System.out.println(grade[i]);
                System.out.println(name[i]);
                System.out.println(age[i]);
            }
            break;

        }
    }
}