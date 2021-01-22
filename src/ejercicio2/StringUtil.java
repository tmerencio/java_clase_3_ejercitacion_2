package ejercicio2;

import java.util.ArrayList;
import java.util.Arrays;

public class StringUtil {
    // Convierte ArrayList<Integer> a ArrayList<String>
    public static ArrayList<String> intArrayToString(int[] array){
        String[] convertedArray = Arrays.stream(array)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        return new ArrayList<>(Arrays.asList(convertedArray));
    }

    // Devuelve el número de dígitos del número más grande
    public static int getLongestStringLength(ArrayList<String> array){
        int maxLength = 0;

        for (String s : array) {
            if (s.length() > maxLength) {
                maxLength = s.length();
            }
        }

        return maxLength;
    }

    // Agrega ceros a la izquierda según cantidad de dígitos
    public static String padLeftZeros(String inputString, int length) {
        StringBuilder sb = new StringBuilder();

        sb.append("0".repeat(Math.max(0, length)));

        return sb.substring(inputString.length()) + inputString;
    }
}
