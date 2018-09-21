package pl.santi.cl.warsztaty.random_numbers;

import java.util.Random;
import java.util.Scanner;

public class RandomNumbers {
    public static void main(String[] args) {
        boolean play = true;
        Random generator = new Random();
        int liczba = generator.nextInt(101);


        do {
            System.out.print("Podaj liczbę: ");
            Scanner scan = new Scanner(System.in);


            while (!scan.hasNextInt()) {
                scan.nextLine();
                System.out.println("To nie jest liczba! Podaj liczbę!: ");
            }
            int userNumber = scan.nextInt();

            if (userNumber == liczba) {
                System.out.println("Brawo, znalazłeś szukaną liczbę!");
                play = false;
            }
            else if(userNumber > liczba) {
                System.out.println("Za duża liczba!");
            }
            else if(userNumber < liczba) {
                System.out.println("Za mała liczba!");

            }

        } while (play);
        System.out.println("Dzięki za grę!");
    }
        }



