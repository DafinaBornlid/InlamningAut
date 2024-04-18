package InlamningAut;

import java.util.Scanner;

public class MainConverter {
    public static void main(String[] args) {
        Converter converter = new Converter();
        Scanner scan = new Scanner(System.in);

        System.out.println("Please choose from the menu which input you would like to type in:\n1. Morse letters or characters \n2. English letters or characters \n3. Morse numbers \n4. English numbers");

        int selectionMenu = Integer.parseInt(scan.nextLine());

        switch (selectionMenu) {
            case 1:
                System.out.println("Please type in a morse letter or character using the signs - or/and *:");
                System.out.println(converter.getEngLetter(scan.nextLine()));
                break;
            case 2:
                System.out.println("Please type in a english letter or character");
                System.out.println(converter.getMorse(scan.nextLine()));
                break;
            case 3:
                System.out.println("Please type in a morse number using the signs - or/and *:");
                System.out.println(converter.getEnglishNumber(scan.nextLine()));
                break;
            case 4:
                System.out.println("Please type in a english number");
                System.out.println(converter.getMorseNumber(scan.nextLine()));


        }

    }
}
