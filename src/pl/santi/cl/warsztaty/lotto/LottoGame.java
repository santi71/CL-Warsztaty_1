package pl.santi.cl.warsztaty.lotto;

import java.util.*;

public class LottoGame {
    public static void main(String[] args) {

        List<Integer> typyGracza = new ArrayList<>();

        for(int i=0; i < 6; i ++) {
            int number;
            do {
                number = podajLiczbe();
                if (typyGracza.contains(number)) {
                    System.out.println("Juz podales taka liczbe, wybierz inna");
                }

            } while (typyGracza.contains(number));
            typyGracza.add(number);
        }


        List<Integer> losowanie = generateRandomNumbers(49, 6);

        int iloscTrafionych = 0;
        for(Integer numer : typyGracza) {
            if(losowanie.contains(numer)) {
                iloscTrafionych++;
            }
        }

        System.out.println("Losowanie: " + losowanie);
        System.out.println("twoje typy: " + typyGracza);
        System.out.println("trafionych liczb jest: " + iloscTrafionych);

    }

    static List<Integer> generateRandomNumbers(int maxNumbers, int numbersToTake) {
        if (maxNumbers <= 0 || numbersToTake <= 0 || numbersToTake > maxNumbers) {
            throw new IllegalArgumentException("Podaj poprawne argumenty");

        }
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < maxNumbers; i++) {
            numbers.add(i + 1);
        }

        Collections.shuffle(numbers);


        return numbers.subList(0, numbersToTake);


    }

    static int podajLiczbe() {
        System.out.println("Podaj liczbę :");
        int liczba;
        do {
            liczba = getInt();
            if (liczba < 1 || liczba > 49) {
                System.out.println("Podaj liczbę z zakresu od 1 - 49: ");
            }

        } while (liczba < 1 || liczba > 49);

        return liczba;
    }

    static int getInt() {
        do {
            try {
                Scanner scan = new Scanner(System.in);
                int num = scan.nextInt();
                return num;
            } catch (Exception e) {
                System.out.println("To nie jest liczba. Podaj jeszcze raz liczbę");
            }
        } while (true);
    }
}

