package com.ichthyosaur.rts.core.util;

import java.util.Random;

public class rollChance {
    public static boolean roll (int denominator) {
        Random rand = new Random();
        int i = rand.nextInt(denominator);
        return i==0;
    }
}
