package com.epam.izh.rd.online.service;

import java.util.Arrays;

public class SimpleMathService implements MathService {

    @Override
    public int compare(int value1, int value2) {
        if (value1 == value2) {
            return 0;
        } else if (value1 < value2) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public int maxFrom(int value1, int value2) {
        if (value1 > value2) {
            return value1;
        } else {
            return value2;
        }
    }

    @Override
    public int maxFrom(int[] values) {
        int max = values[0];
        for (int value : values) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    @Override
    public int sum(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }

    @Override
    public int[] getEvenDigits(int[] values) {
        int i = 0;
        int[] evenTempArray = new int[]{-1};
        for (int value : values) {
            if (value % 2 == 0) {
                int[] buf = evenTempArray;
                evenTempArray = new int[buf.length + 1];
                System.arraycopy(buf, 0, evenTempArray, 0, buf.length);
                evenTempArray[evenTempArray.length - 1] = value;
            }
        }
        int[] evenArray = new int[evenTempArray.length - 1];
        System.arraycopy(evenTempArray, 1, evenArray, 0, evenTempArray.length - 1);
        return evenArray;
    }

    @Override
    public long calcFactorial(int initialVal) {
        int factorial = 1;
        if (initialVal != 0) {
            for (int i = initialVal; i > 0; i--) {
                factorial *= i;
            }
        }
        return factorial;
    }

    @Override
    public long calcFibonacci(int number) {
        if (number == 0) {
            return 0;
        }
        int[] fibonacciArray = new int[number + 1];
        fibonacciArray[0] = 0;
        fibonacciArray[1] = 1;
        for (int i = 2; i <= number; i++) {
            fibonacciArray[i] = fibonacciArray[i - 2] + fibonacciArray[i - 1];
        }
        return fibonacciArray[number];
    }

    @Override
    public int[] sort(int[] values) {
        Arrays.sort(values);
        return values;
    }

    @Override
    public boolean isPrimary(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int[] reverseArray(int[] values) {
        if (values.length < 2) {
            return values;
        }
        int middleArray = values.length % 2 == 0 ? values.length / 2 : values.length / 2 - 1;
        for (int i = 0; i <= middleArray; i++) {
            int temp = values[i];
            values[i] = values[values.length - 1 - i];
            values[values.length - 1 - i] = temp;
        }
        return values;
    }
}
