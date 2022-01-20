package com.learning.leetcode;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class EatBananas {
    public static void main(String[] args) throws IOException {
        InputStream in = new FileInputStream(Objects.requireNonNull(EatBananas.class.getResource("eatBananas.txt")).getPath());
        byte[] buf = new byte[1024];
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        int read;
        while ((read = in.read(buf, 0, 1024)) > -1) {
            byteOut.write(buf, 0, read);
        }
        String s = byteOut.toString(StandardCharsets.UTF_8);
        String[] strNumbers = s.split(",");
        int[] piles = new int[strNumbers.length];
        for(int i = 0; i < strNumbers.length; i++){
            piles[i] = Integer.parseInt(strNumbers[i]);
        }
        long start = System.currentTimeMillis();
        System.out.println("Min Eating speed is " + minEatingSpeed(piles, 63939633) + " Time cost is " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        System.out.println("Min Eating speed is " + minEatingSpeedTwo(piles, 63939633) + " Time cost is " + (System.currentTimeMillis() - start));
    }

    public static int minEatingSpeed(int[] piles, int h){
        int speed = 1;
        while(true){
            int currentH = 0;
            for (int count: piles) {
                currentH += Math.ceil((double) count/speed);
            }
            if(currentH > h){
                speed++;
            }else{
                return speed;
            }
        }
    }

    public static int minEatingSpeedTwo(int[] piles, int h){

        // Initialize the left and right boundaries
        int left = 1, right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            // Get the middle index between left and right boundary indexes.
            // hourSpent stands for the total hour Koko spends.
            int middle = (left + right) / 2;
            int hourSpent = 0;

            // Iterate over the piles and calculate hourSpent.
            // We increase the hourSpent by ceil(pile / middle)
            for (int pile : piles) {
                hourSpent += Math.ceil((double) pile / middle);
            }

            // Check if middle is a workable speed, and cut the search space by half.
            if (hourSpent <= h) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        // Once the left and right boundaries coincide, we find the target value,
        // that is, the minimum workable eating speed.
        return right;
    }
}
