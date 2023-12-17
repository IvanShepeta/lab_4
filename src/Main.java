import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array1 = {5, -8, 2, -3, 9, -7, 1};
        int[] array2 = {4, -8, 2, 7, 9, -3, 1, 12, -6};
        int[] originalArray = {4, -8, 2, 7, 0, -3, 1, 12, -6};

        int secondMin = findSecondMin(array1);
        int count = countPositiveElementsAtMultipleOf4(array2);
        int[] modifiedArray = modifyArray(originalArray);
        System.out.println("Другий мінімальний за модулем елемент масиву: " + secondMin);
        System.out.println("Кількість додатних елементів з індексами, кратними 4: " + count);
        System.out.println("Оригінальний масив: " + Arrays.toString(originalArray));
        System.out.println("Модифікований масив: " + Arrays.toString(modifiedArray));
    }

    public static int findSecondMin(int[] arr) {
        if (arr.length < 2) {
            throw new IllegalArgumentException("Масив повинен містити принаймні два елементи");
        }

        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int num : arr) {
            int absValue = Math.abs(num);

            if (absValue < min) {
                secondMin = min;
                min = absValue;
            } else if (absValue < secondMin && absValue != min) {
                secondMin = absValue;
            }
        }

        return secondMin;
    }

    public static int countPositiveElementsAtMultipleOf4(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Масив не може бути порожнім");
        }

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i % 4 == 0 && arr[i] > 0) {
                count++;
            }
        }

        return count;
    }

    static int[] modifyArray(int[] arr) {
        int[] modifiedArray = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                modifiedArray[i] = arr[i] * -1;
            } else if (arr[i] > 0) {
                modifiedArray[i] = arr[i] - 3;
            } else {
                modifiedArray[i] = -2;
            }
        }

        return modifiedArray;
    }
}