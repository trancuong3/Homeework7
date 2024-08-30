import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static float[] importData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = scanner.nextInt();

        float[] arrays = new float[n];
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            arrays[i] = scanner.nextFloat();
        }
        return arrays;
    }

    public static void printData(float[] arrays) {
        System.out.println("Các phần tử của mảng là:");
        for (float num : arrays) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static float findMax2(float[] arrays) {
        if (arrays.length < 2) {
            throw new IllegalArgumentException("Mảng phải có ít nhất 2 phần tử.");
        }
        float max1 = Float.NEGATIVE_INFINITY;
        float max2 = Float.NEGATIVE_INFINITY;
        for (float num : arrays) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2 && num < max1) {
                max2 = num;
            }
        }

        if (max2 == Float.NEGATIVE_INFINITY) {
            throw new IllegalArgumentException("Không có phần tử lớn thứ 2 trong mảng.");
        }

        return max2;
    }
    public static void deleteOddNumber(float[] arrays) {
        ArrayList<Float> result = new ArrayList<>();
        for (float num : arrays) {
            if (num % 2 == 0) {
                result.add(num);
            }
        }
        arrays = new float[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arrays[i] = result.get(i);
        }
        System.out.println("Mảng sau khi xoá các phần tử lẻ:");
        printData(arrays);
    }

    public static void main(String[] args) {
        float[] arrays = importData();
        printData(arrays);

        try {
            float max2 = findMax2(arrays);
            System.out.println("Giá trị phần tử lớn thứ 2 là: " + max2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        deleteOddNumber(arrays);
    }
}
