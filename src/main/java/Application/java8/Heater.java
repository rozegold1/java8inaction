package Application.java8;

public class Heater {


    public static void main(String[] args) {
//        System.out.println("0 : " + solution(new int[]{}));
//        System.out.println("6 : " + solution(new int[]{100, -5, -6, -9, 0, -1}));
//        System.out.println("1 : " + solution(new int[]{2, 5}));
//        System.out.println("2 : " + solution(new int[]{5, 2}));
//        System.out.println("0 : " + solution(new int[]{2}));
//        System.out.println("4 : " + solution(new int[]{-5, -5, -5, -42, 6, 8}));
//        System.out.println("3 : " + solution(new int[]{5, -2, 3, 8, 6}));
//        System.out.println("7 : " + solution(new int[]{5, -2, 3, 6, 5, 8, 5, 10}));
//        System.out.println("7 : " + solution(new int[]{-5, -5, -5, -42, 6, -5, 6, 7, 7}));
//        System.out.println("10 : " + solution(new int[]{-5, -5, -5, -42, 6, -5, 6, 7, 6, 7}));
//        System.out.println("162 : " + solution(new int[]{-5, -5, -5, -42, 6, -5, 6, 7, 7, -5, -5, -5, -42, 6, -5, 6, 7, 7, -5, -5, -5, -42, 6, -5, 6, 7, 7, -5, -5, -5, -42, 6, -5, 6, 7, 7, -5, -5, -5, -42, 6, -5, 6, 7, 7, -5, -5, -5, -42, 6, -5, 6, 7, 7, -5, -5, -5, -42, 6, -5, 6, 7, 7, -5, -5, -5, -42, 6, -5, 6, 7, 7, -5, -5, -5, -42, 6, -5, 6, 7, 7, -5, -5, -5, -42, 6, -5, 6, 7, 7, -5, -5, -5, -42, 6, -5, 6, 7, 7, -5, -5, -5, -42, 6, -5, 6, 7, 7, -5, -5, -5, -42, 6, -5, 6, 7, 7, -5, -5, -5, -42, 6, -5, 6, 7, 7, -5, -5, -5, -42, 6, -5, 6, 7, 7, -5, -5, -5, -42, 6, -5, 6, 7, 7, -5, -5, -5, -42, 6, -5, 6, 7, 7, -5, -5, -5, -42, 6, -5, 6, 7, 7, 8}));

        System.out.println("1 : " + solution(new int[1000000000]));
    }

    private static int solution(int[] T) {


        if (T.length == 0 || T.length == 1)
            return 0;

        int currWinterDays = 1;


        int currWinterMax = T[0];
        int currSummerMin = Integer.MIN_VALUE;
        boolean summerStarted = false;


        for (int i = 1; i < T.length; i++) {

            if (currWinterMax >= T[i] && !summerStarted) {
                currWinterDays++;
                continue;
            }

            if (currWinterMax < T[i] && !summerStarted) {
                currSummerMin = T[i];
                summerStarted = true;
                currWinterDays = i;
            } else if (summerStarted && T[i] < currSummerMin && T[i] <= currWinterMax) {
                summerStarted = false;
                currWinterMax = currSummerMin;
                currWinterDays = i + 1;
                currSummerMin = Integer.MIN_VALUE;
            }

        }
        return currWinterDays;
    }


}