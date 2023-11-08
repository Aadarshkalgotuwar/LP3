import java.util.Arrays;
import java.util.Comparator;

public class Fractional {
    public static void main(String[] args) {
        int val[] = { 60, 100, 120 };
        int wt[] = { 10, 20, 30 };
        int W = 50;

        double ratio[][] = new double[val.length][2]; // 0th column for index, 1st column for ratio

        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = (double) val[i] / wt[i];
        }

        // Sorting based on the ratios in descending order
        Arrays.sort(ratio, Comparator.comparingDouble(row -> -row[1]));

        int capacity = W;
        double finalVal = 0;

        for (int i = 0; i < ratio.length; i++) {
            int idx = (int) ratio[i][0];
            if (capacity >= wt[idx]) {
                finalVal += val[idx];
                capacity -= wt[idx];
            } else {
                finalVal += (ratio[i][1] * capacity);
                break;
            }
        }
        System.out.println(finalVal);
    }
}
