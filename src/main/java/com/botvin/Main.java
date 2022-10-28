package com.botvin;

public class Main {
    public static void main(String[] args) {

        // 1-st task
        String name = "Maksym";
        String surname = "Botvin";
        System.out.println(name + " " + surname);

        // 2-nd task
        int y = 5;
        for(int i = 0; i <= 10; i++){
            System.out.println("Step " + i + ", value " + y);
            y += 2;
        }

        // 3-rd task
        for(int i = 0; i <= 10; i++){
            if(i == 3){
                continue;
            }
            if (i == 6){
                break;
            }
            System.out.println("Step " + i);
        }
    }
}
