import java.util.Scanner;

public class Case2 {
    public static void main(String[] args) {
        Integer numberOfFamilies = inputInt("Input number of families");
        int[] intArr = inputValidation("Input members of families", numberOfFamilies);

        int minimumBus = 0;

        //Place family members exceeding 4 onto the buss
        for (int i = 0; i < intArr.length; i++) {
            if (intArr[i] > 4) {
                minimumBus += intArr[i]/4;
                intArr[i] = intArr[i]%4;
            }
        }

        //Sorting Descending
        int n = intArr.length;

        for (int i = 1; i < n; i++) {
            int x = intArr[i];
            int j = i - 1;

            while (j >= 0 && intArr[j] < x) {
                intArr[j + 1] = intArr[j];
                j--;
            }
            intArr[j + 1] = x;
        }

        //Combine Family
        for (int i = 0; i < intArr.length; i++) {
            if (intArr[i] == 3) {
                for (int j = i + 1; j < intArr.length; j++) {
                    if (intArr[j] == 1) {
                        intArr[i] = 4;
                        intArr[j] = 0;
                        break;
                    }
                }
            } else if (intArr[i] == 2) {
                for (int j = i + 1; j < intArr.length; j++) {
                    if (intArr[j] == 2) {
                        intArr[i] = 4;
                        intArr[j] = 0;
                        break;
                    } else if (intArr[j] == 1) {
                        intArr[i] = 3;
                        intArr[j] = 0;
                        break;
                    }
                }
            } else if (intArr[i] == 1) {
                for (int j = i + 1; j < intArr.length; j++) {
                    if (intArr[j] == 1) {
                        intArr[i] = 2;
                        intArr[j] = 0;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < intArr.length; i++) {
            if (intArr[i] != 0) {
                minimumBus++;
            }
        }

        System.out.println("Minimum Bus Required is : " + minimumBus);
    }


    public static int inputInt(String info){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.printf("%s: ", info);
            try {
                return Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.out.println("Input must be number");
            }
        }
    }
    public static int[] inputValidation(String info, int numberOfFamilies){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            boolean isValid = true;
            System.out.printf("%s: ", info);
            String input = scanner.nextLine();

            if(input.isBlank() || input.isEmpty()) continue;

            String[] stringArr = input.split(" ");
            int[] intArr = new int[stringArr.length];

            for (int i = 0; i < stringArr.length; i++) {
                try {
                    intArr[i] = Integer.parseInt(stringArr[i]);
                } catch (NumberFormatException e) {
                    System.out.println("Input number of members must be number");
                    isValid = false;
                    break;
                }
            }
            if(!isValid) continue;

            if (intArr.length != numberOfFamilies) {
                System.out.println("Input must be equal with count of family");
                continue;
            }

            return intArr;
        }
    }
}