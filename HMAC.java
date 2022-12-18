package Assignment_6;

import Assignment_5.DSSha1Elgmal;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Scanner;

// key  => 
public class HMAC {
    public static Scanner cin = new Scanner(System.in);

    public static String KeyGeneration(String xx) {

        String keyplus = xx.repeat(20);

        return keyplus;
    }

    public static String inputMassege() {
        System.out.println("Enter Your Massege.. ");
        String myMessage = cin.nextLine();

        return myMessage;
    }

    public static String convertStringToBinary(String input) {

        StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            result.append(
                    String.format("%8s", Integer.toBinaryString(aChar)) // char -> int, auto-cast
                            .replaceAll(" ", "0") // zero pads
            );
        }

        int Olength;
        Olength = result.length();
        result.append(1);
        int length;
        length = result.length();
        // System.out.println(length);
        int zAppend = 160 - length;
        for (int i = 0; i < zAppend; i++) {
            result.append(0);
        }
        length = result.length();

        return result.toString();
    }

    public static String convertStringToBinaryx(String input) {

        StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            result.append(
                    String.format("%8s", Integer.toBinaryString(aChar)) // char -> int, auto-cast
                            .replaceAll(" ", "0") // zero pads
            );
        }

        int Olength;
        Olength = result.length();
        result.append(1);
        int length;
        length = result.length();
        // System.out.println(length);
        int zAppend = 512 - length;
        for (int i = 0; i < zAppend; i++) {
            result.append(0);
        }
        length = result.length();

        return result.toString();
    }

    static void createHashMap(int arr[]) {
        // Creates an empty HashMap
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();

        // Traverse through the given array
        for (int i = 0; i < arr.length; i++) {

            // Get if the element is present
            Integer c = hmap.get(arr[i]);

            // If this is first occurrence of element
            // Insert the element
            if (hmap.get(arr[i]) == null) {
                hmap.put(arr[i], 1);
            }

            // If elements already exists in hash map
            // Increment the count of element by 1
            else {
                hmap.put(arr[i], ++c);
            }
        }

        // Print HashMap
        System.out.println(hmap);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {

        String Message = inputMassege();

        String keyplus = KeyGeneration("11110000");
        String ipad = KeyGeneration("00110111");
        String opad = KeyGeneration("01011100");

        String Massegebinarry = convertStringToBinary(Message);
        // System.out.println(Massegebinarry);

        String Si = DSSha1Elgmal.xoring(keyplus, ipad, 160);

        // System.out.println(Si);

        String S0 = DSSha1Elgmal.xoring(keyplus, opad, 160);
        // System.out.println(S0);

        String sx = Si + Massegebinarry;
        System.out.println(sx);

        System.out.println("code Generating.....");
        String result = convertStringToBinary(sx);
        // System.out.println(result);

        System.out.println(" ");

        String[] Words = DSSha1Elgmal.Words16(result);
        for (int i = 0; i < Words.length; i++) {
            System.out.println("Words " + i + " : " + Words[i]);
        }

        System.out.println(" ");

        String[] Words80 = DSSha1Elgmal.Words80(Words);
        for (int i = 0; i < Words80.length; i++) {
            System.out.println("Words80 " + i + " : " + Words80[i]);
        }
        System.out.println(" ");

        DSSha1Elgmal.Hashed = DSSha1Elgmal.CF(Words80);
        System.out.println(" ");
        System.out.println("Done ");
        // System.out.println("SHA-1 Value is : ");

        String digestx = sha1(sx);
        System.out.println("SHA-1 hash size: " + digestx.length());
        System.out.println(digestx);

        //////////////////////////////////////////////////////////////////////

        String sx0 = S0 + digestx;

        System.out.println("code Generating.....");
        String resultx2 = convertStringToBinary(sx0);

        System.out.println(" ");

        String[] Words2 = DSSha1Elgmal.Words16(result);
        for (int i = 0; i < Words2.length; i++) {
            System.out.println("Words " + i + " : " + Words[i]);
        }

        System.out.println(" ");

        String[] Words802 = DSSha1Elgmal.Words80(Words);
        for (int i = 0; i < Words802.length; i++) {
            System.out.println("Words80 " + i + " : " + Words80[i]);
        }
        System.out.println(" ");

        DSSha1Elgmal.Hashed = DSSha1Elgmal.CF(Words80);
        System.out.println(" ");
        System.out.println("Done ");
        // System.out.println("SHA-1 Value is : ");

        String digestx2 = sha1(Message);
        System.out.println("SHA-1 hash size: " + digestx2.length());
        System.out.println(digestx);

    }

    public static String sha1(String message) {
        String xdd = DSSha1Elgmal.Hashed;
        return xdd;
    }

}