package ejercicio2;

import java.util.ArrayList;
import java.util.Arrays;

public class Ejercicio {

    /*
        1. convertir array de ints a array de strings

        2. funcion filler de 0s, primero obtener número más grande y luego rellenar a la izquierda los demás para que tengan la misma cantidad de dígitos

        3. crear 10 listas Li para los elementos que terminan en i, con i de 0-9.

        4. rellenamos las listas con los números correspondientes

        5. rearmamos el array
     */

    public static ArrayList<String> intArrayToString(int[] array){
        String[] convertedArray = Arrays.stream(array)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        return new ArrayList<>(Arrays.asList(convertedArray));
    }

    public static int getLongestStringLength(ArrayList<String> array){
        int maxLength = 0;

        for (String s : array) {
            if (s.length() > maxLength) {
                maxLength = s.length();
            }
        }

        return maxLength;
    }

    public static String padLeftZeros(String inputString, int length) {
        StringBuilder sb = new StringBuilder();

        sb.append("0".repeat(Math.max(0, length)));

        return sb.substring(inputString.length()) + inputString;
    }
    
    public static void radixSort(int[] array){
        ArrayList<String> convertedArray = intArrayToString(array);

        int numberOfDigits = getLongestStringLength(convertedArray);

        for (int i = 0; i < convertedArray.size(); i++) {
            String padLeftZerosString = padLeftZeros(convertedArray.get(i), numberOfDigits);
            convertedArray.set(i, padLeftZerosString);
        }

        ArrayList<ArrayList<String>> lists = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lists.add(new ArrayList<>());
        }

        for (int j = numberOfDigits - 1; j>=0; j--){
            for (String s : convertedArray) {
                int x = Character.getNumericValue(s.charAt(j));
                lists.get(x).add(s);
            }

            convertedArray.clear();

            for (ArrayList<String> arrayList : lists) {
                convertedArray.addAll(arrayList);
            }

            for (ArrayList<String> arrayList : lists) {
                arrayList.clear();
            }

            System.out.println(j + ": " + convertedArray.toString());
        }

        int i = 0;
        for(String value : convertedArray){
            array[i] = Integer.parseInt(value);
            i++;
        }
    }

    public static void main(String[] argsv) {
        int[] arr={3, 673, 106, 45, 2,23 };

        System.out.println(Arrays.toString(arr));

        radixSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
