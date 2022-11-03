package com.botvin;

public class Main4 {
    public static void main(String[] args) {

        // 1-st task
        /*
        Створіть рядок "Hello world!"
        ● Виведіть перший символ
        ● Виведіть останній символ
        Важливо: Номер елемента повинен обчислювати динамічно залежно від рядка (не можна вказати 0 і 11, та не можно вказати “!”)
         */

        String str = "Hello world!";
        for (int i = 0; i <= str.length(); i++) {
            if (i == 0) {
                System.out.println(str.charAt(i) + " - is the first symbol");
            } else if (i == (str.length() - 1)) {
                System.out.println(str.charAt(i) + " - is the last symbol");
            }
        }

        System.out.println();


        // 2-nd task
        /*
        Напишіть програму на Java, щоб перевірити, чи закінчується дана строка вказаною підстрокою. Приклад:
        ● "Java Exercises" закінчується на "se"? // false
        ● "Java Exercise" закінчується на "se"? // true
         */

        String phrase = "Java Exercise";    // Java Exercises
        System.out.println(phrase.endsWith("se"));

        // OR

        String pieceOfWord = phrase.substring((phrase.length() - 2), phrase.length());
        System.out.println("se".equals(pieceOfWord));

        // OR

        final int lastIndexS = phrase.lastIndexOf('s');
        final int lastIndexE = phrase.lastIndexOf('e');
        boolean a = true;
        boolean b = false;
        if (lastIndexS < lastIndexE) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }

        System.out.println();


        // 3-rd task. Напишіть програму на Java, щоб перевірити, чи два об’єкти String містять однакові дані:

        String txt = "Stephen Edwin King";
        System.out.println(txt.contains("Walter Winchell"));
        System.out.println(txt.contains("Edwin"));

        System.out.println();


        // 4-th task. Напишіть програму Java для порівняння даного рядка з іншим рядком, ігноруючи регістр

        String firstText = "Walter Winchell";
        String secondText = "stephen edwin king";
        String firstComparison = String.valueOf(firstText.equalsIgnoreCase(txt));
        System.out.println(firstComparison);
        String secondComparison = String.valueOf(secondText.equalsIgnoreCase(txt));
        System.out.println(secondComparison);

        System.out.println();

        // 5-th. Напишіть програму Java, щоб перевірити, чи даний рядок починається з вмісту іншого рядка.

        String firstSentence = "Red is favorite color.";
        String secondSentence = "Orange is also my favorite color.";
        System.out.println(firstSentence.startsWith("Red"));
        System.out.println(secondSentence.startsWith("Red"));
    }
}
