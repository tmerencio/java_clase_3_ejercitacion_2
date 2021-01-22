package ejercicio2;

import java.util.ArrayList;
import java.util.Arrays;

public class Ejercicio {

    
    public static void radixSort(int[] array){
        ArrayList<String> convertedArray = StringUtil.intArrayToString(array);

        int numberOfDigits = StringUtil.getLongestStringLength(convertedArray);

        // Agrega ceros a la izquierda en todos los elementos del Array
        for (int i = 0; i < convertedArray.size(); i++) {
            String padLeftZerosString = StringUtil.padLeftZeros(convertedArray.get(i), numberOfDigits);
            convertedArray.set(i, padLeftZerosString);
        }

        // Creo las 10 listas vacías
        ArrayList<ArrayList<String>> lists = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lists.add(new ArrayList<>());
        }

        // Recorro las posiciones de los dígitos de derecha a izquierda
        for (int j = numberOfDigits - 1; j>=0; j--){
            // Agrego elementos a listas según su caracter en la posición j
            for (String s : convertedArray) {
                int x = Character.getNumericValue(s.charAt(j));
                lists.get(x).add(s);
            }

            // Vacío el Array
            convertedArray.clear();

            // Junto todos los elementos de las listas en el Array
            for (ArrayList<String> arrayList : lists) {
                convertedArray.addAll(arrayList);
            }

            // Vacío todas las listas L0-L9
            for (ArrayList<String> arrayList : lists) {
                arrayList.clear();
            }

            System.out.println(j + ": " + convertedArray.toString());
        }

        // Reordeno el Array de ints original
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
