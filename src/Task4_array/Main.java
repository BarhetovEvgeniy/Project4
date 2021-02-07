package Task4;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        // Буду переделывать, т.к. все сделал в одном классе. (((
        String[][] array = new String[10][10];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                // делаем числа
                double n = (Math.random()*10);
                String doubles = String.valueOf(n);
                StringBuilder sb = new StringBuilder(doubles);
                String sb2 = sb.substring(0, 6);
                // делаем 6 символов
                String text = new String("abcdefghijklmnopqrstuvwxyz");
                StringBuilder insertChar = new StringBuilder();
                String insertText;
                insertText = null;

                for (int c = 0; c < 6; c++) {
                    Random r = new Random();
                    int x = r.nextInt(25) + 1;
                    char a = text.charAt(x);
                    insertChar.append(a);
                    insertText = insertChar.toString();
                }
                if ((i + j) % 3 == 0){
                    array[i][j] = sb2;
                } else {
                    array[i][j] = insertText;
                }
            }
        }
        // Main diagonal
        String[] diagonal1 = new String[array.length];
        int i = 0; int j = 0;
        System.out.print("Main diagonal: ");
        for(i = 0; i < 10; i++, j++) {
            diagonal1[i] = array[i][j];
            System.out.print(diagonal1[i] + "\t");
        }
        System.out.println();

        // Side diagonal
        String[] diagonal2 = new String[10];
        i = 0; j = array.length-1;
        System.out.print("Side diagonal: ");
        for(i = 0; i < 10; i++, j--) {
            diagonal2[i] = array[i][j];
            System.out.print(diagonal2[i] + "\t");
        }
        System.out.println();

        //The diagonals are equal?
        Boolean result = Arrays.equals(diagonal1,diagonal2);
        System.out.print("The diagonals are equal: " + result);

        //Arrays of all diagonals
        System.out.println();
        System.out.println("Arrays of all diagonals: ");
        String[] allDiag = new String[diagonal1.length+ diagonal2.length];
        int count = 0;
        for(i = 0; i<diagonal1.length; i++) {
            allDiag[i] = diagonal1[i];
            count++;
        }
        for(i = 0;i<diagonal2.length;i++) {
            allDiag[count++] = diagonal2[i];
        }
        for(i = 0;i<allDiag.length;i++){
            System.out.print(allDiag[i]+"\t");
        }
        System.out.println();

        //Strings & digits
        String symbols = new String();
        //StringBuilder letters = new StringBuilder();
        //String letters2 = new String(letters);
        double digits;
        double resultLow;
        double resultHi;
        int countLetter = 0;
        System.out.println("String (2-4 chars): ");
        for (i = 0; i < allDiag.length-1; i++) {
            symbols = allDiag[i];
            char firstSymbol = symbols.charAt(0);
            if (Character.isLetter(firstSymbol)==true){
                StringBuilder letters = new StringBuilder(symbols);
                System.out.print(letters.substring(1, 4) + ", ");
                countLetter ++;
            }
        }
        double[] allDigits = new double[allDiag.length - countLetter];
        int c = 0;
        for (i = 0; i < allDiag.length; i++) {
            symbols = allDiag[i];
            char firstSymbol = symbols.charAt(0);

            if (Character.isDigit(firstSymbol)==true){
                digits = Double.parseDouble(symbols);
                if (digits < 1.7) {
                    resultLow = Math.floor(digits);
                    allDigits[c] = resultLow;
                }else {
                    resultHi = Math.ceil(digits);
                    allDigits[c] = resultHi;
                }
                c++;
            }
        }
        System.out.println();
        System.out.println("Doubles: ");
        for (i=0;i< allDigits.length;i++){
            System.out.print(allDigits[i] + "_");
            // почему то выводит больше чисел чем надо ???
        }
        System.out.println();
        System.out.println();
        // Выводим массив в консоль
        for (i = 0; i < array.length; i++) {
            for (j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();

    }

}