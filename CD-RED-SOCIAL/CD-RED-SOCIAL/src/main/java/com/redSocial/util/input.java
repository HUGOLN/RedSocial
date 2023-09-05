package com.redSocial.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class input {


    /**
     * Method to initialize input data.
     * @return input Buffered string data.
     */
    public static String init() {
        String buffer = "";
        InputStreamReader stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(stream);
        try {
            buffer = reader.readLine();
        } catch (Exception e) {
            System.out.append("Invalid data.");
        }
        return buffer;
    }

    /**
     * Method to get an integer from input data.
     * @return integer entered by the user.
     */
    public static int integer() {
        return input.integer(null);
    }

    /**
     * Method to get an integer from input data with a custom message.
     * @param message custom message for the user.
     * @return integer entered by the user.
     */
    public static int integer(String message) {
        if (message != null) {
            System.out.print(message);
        }
        int value = Integer.parseInt(input.init());
        return value;
    }

    /**
     * Method to get a real number from input data.
     * @return real number entered by the user.
     */
    public static double real() {
        return input.real(null);
    }

    /**
     * Method to get a real number from input data with a custom message.
     * @param message custom message for the user.
     * @return real number entered by the user.
     */
    public static double real(String message) {
        if (message != null) {
            System.out.print(message);
        }
        double value = Double.parseDouble(input.init());
        return value;
    }

    /**
     * Method to get a text string from input data.
     * @return text string entered by the user.
     */
    public static String string() {
        return input.string(null);
    }

    /**
     * Method to get a text string from input data with a custom message.
     * @param message custom message for the user.
     * @return text string entered by the user.
     */
    public static String string(String message) {
        if (message != null) {
            System.out.print(message);
        }
        String value = input.init();
        return value;
    }

    /**
     * Method to get a character from input data.
     * @return character entered by the user.
     */
    public static char character() {
        return input.character(null);
    }

    /**
     * Method to get a character from input data with a custom message.
     * @param message custom message for the user.
     * @return character entered by the user.
     */
    public static char character(String message) {
        if (message != null) {
            System.out.print(message);
        }
        String valor = input.init();
        return valor.charAt(0);
    }

}
