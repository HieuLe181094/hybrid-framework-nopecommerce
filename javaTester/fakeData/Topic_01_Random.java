package fakeData;

import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.SplittableRandom;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Topic_01_Random {
    public static void main(String[] args) throws InterruptedException {
     int min = 10;
     int max = 100;
     int randomNumber = (int) (Math.random() * (max + 1 - min) + min);
     System.out.println(randomNumber);

     // Đa luồng
        int randomInt = ThreadLocalRandom.current().nextInt(1000,10000);
        System.out.println(randomInt);

        List<Integer> intList = new SplittableRandom().ints(5,1,100000)
                .boxed().collect(Collectors.toList());

        System.out.println(intList);
    }

    public static int getRandomNumber() {
        int uLimit = 999;
        int lLimit = 100;
        Random rand = new Random();
        return lLimit + rand.nextInt(uLimit - lLimit);
    }

    public static int getRandomNumber(int minimum, int maximum) {
        Random rand = new Random();
        return minimum + rand.nextInt(maximum - minimum);
    }

    public static String getRandomEmail() {
        return "automation" + getRandomNumberByDateTime() + "@live.com";
    }

    // Get random number by date time minute second (no duplicate)
    public static long getRandomNumberByDateTime() {
        return Calendar.getInstance().getTimeInMillis() % 100000;
    }
}
