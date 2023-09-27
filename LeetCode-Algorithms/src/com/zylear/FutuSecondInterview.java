package com.zylear;

public class FutuSecondInterview {

    public static void main(String[] args) {

        System.out.println(handle(3, 15));

    }

    public static double handle(int hours, int minutes) {

        double hoursIndex = hours * 5;
        double diff = 0;

        hoursIndex = hoursIndex + ((double) minutes / 60) * 5;

        diff = Math.abs(hoursIndex - minutes);

        if (diff > 30) {
            diff = 60 - diff;
        }
        return (diff / 60) * 360;
    }

}
