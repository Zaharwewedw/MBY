package com.example.Telegram_mby;
public class MainTestClass {

    public static void main(String[] args) {
        int[] a = new int[]{1};
        int[] b = a;
        b[0] = 2;
        System.out.println(a[0]);


    }
}
