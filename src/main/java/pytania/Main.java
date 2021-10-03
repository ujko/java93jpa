package pytania;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        System.out.println(intToBinaryString(488));
    }

    private static String intToBinaryString(int s) {
        System.out.println("Powinno być: " + Integer.toBinaryString(s));
        String result = "";
        while(s > 0) {
            result = (s % 2) + result;
            s /= 2;
        }
        return result;
    }




/*
* metoda przyjmująca int, zwracająca int
* zmienia int na liczbę binarną ręcznie zakaz Integer.toBinaryString
* zwraca największą liczbę zer pomiędzy jedynkami
* */

    /*      input
    *     int[] a = {2,5,2,6,4};
//        int[] b = {3,6,7};
//        //return
//        int[] c = {2,3,5,6,2,7,6,4};
    * */



    //        String s = "jakis sobie sttring";
//        String dd = "ska";
    //bez pattern

    //metoda zwracająca boolean a przyjmująca string informująca czy

}
