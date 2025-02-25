package com.homework.controller;


import com.homework.common.DateCalculator;
import com.homework.common.MathCalculator;
import com.homework.common.StringCalculator;
import com.homework.dto.FoodShop;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.StringTokenizer;

public class Calculator implements StringCalculator, MathCalculator, DateCalculator {

    // 해당 클래스안에 정의해야되는 메소드들은 현재
    // StringCalculator, MathCalculator, DateCalculator 인터페이스에 추상메소드로 정의되어있다.
    // 세 인터페이스를 구현하는 클래스로 완성하시오. 즉, implements 하여 해당 각 메소드를 완성하시오.


    @Override
    public void printNowDateTime() {
        LocalDateTime now = LocalDateTime.now();

        String dateTimeStr = now.toString();

        int tIndex = dateTimeStr.indexOf("T");

        String datePart = dateTimeStr.substring(0, tIndex); // "2024-01-04"
        String timePart = dateTimeStr.substring(tIndex + 1, tIndex + 9); // "17:30:05" (초까지)

        String formattedDateTime = datePart + " " + timePart;
        System.out.println(formattedDateTime);
    }

    @Override
    public Calendar makeCalendar(String year, String month, String date) {
        // 1. 문자열을 정수로 변환
        int y = Integer.parseInt(year);
        int m = Integer.parseInt(month) - 1;
        int d = Integer.parseInt(date);

        Calendar calendar = Calendar.getInstance();
        calendar.set(y, m, d);

        return calendar;
    }

    @Override
    public void printFormat(Calendar calc) {
        int year = calc.get(Calendar.YEAR);
        int month = calc.get(Calendar.MONTH) + 1;
        int day = calc.get(Calendar.DAY_OF_MONTH);
        String[] weekDays = {"일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"};
        String dayOfWeek = weekDays[calc.get(Calendar.DAY_OF_WEEK) - 1];

        System.out.printf("%d-%02d-%02d %s\n", year, month, day, dayOfWeek);
    }

    @Override
    public boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    @Override
    public long leapDate(int startYear, int endYear) {
        long totalDays = 0;
        for (int year = startYear; year <= endYear; year++) {
            totalDays += isLeapYear(year) ? 366 : 365;
        }
        return totalDays;
    }

    @Override
    public int sumString(String num1, String num2) {
        double sum = (Double.parseDouble(num1) + Double.parseDouble(num2));

        return (int) Math.round(sum);
    }

    @Override
    public int minusString(String num1, String num2) {
        if (num1.contains(".") || num2.contains(".")) {
            return -1;
        }

        double minus = (Double.parseDouble(num1) - Double.parseDouble(num2));

        return (int) Math.abs(minus);
    }

    @Override
    public int findCharCount(String str, char ch) {

        char[] charArray = str.toCharArray();
        int count = 0;
        for (char index : charArray) {

            if (index == ch) {
                count++;
            }

        }
        return count;
    }

    @Override
    public int selectTokenCount(String str) {
        StringTokenizer stn = new StringTokenizer(str, " ");

        return stn.countTokens();
    }

    @Override
    public String toSpaceUpper(String str) {
        StringTokenizer stn = new StringTokenizer(str, ",");
        StringBuilder result = new StringBuilder();

        while (stn.hasMoreTokens()) {
            String token = stn.nextToken();
            result.append(token.substring(0, 1).toUpperCase() + token.substring(1));
        }

        return result.toString();
    }

    @Override
    public FoodShop[] csvFormat() {
        String csvStr =  "1,맘스쿡,광주광역시 동구 동계천로143,062-233-1233,향토맛집,2022-01-11\n"
                + "2,옛날밥상,광주광역시 남구 용대로119번길 6,062-653-7337,향토맛집,2022-01-11\n"
                + "3,송정떡갈비,광주광역시 광산구 광산로29번길 1,062-944-1439,향토맛집,2022-01-11\n"
                + "4,홍춘이,광주광역시 북구 무등로180번길 9-18,062-521-7733,향토맛집,2022-01-11\n"
                + "5,종가집떡갈비,광주광역시 광산구 상무대로 226,062-943-8282,향토맛집,2022-01-11\n"
                + "6,광신보리밥,광주광역시 북구 두리봉길 2-1(두암동),062-264-1811,향토맛집,2022-01-11\n"
                + "7,조선옥,광주광역시 남구 효덕로 103,062-654-3322,한상맛집,2022-01-11\n"
                + "8,송원회관,광주광역시 북구 경양로135번길 29(신안동),062-529-3250,한상맛집,2022-01-11\n"
                + "9,만선당어부의밥상,광주광역시 광산구 수완로11번길 3,062-955-5595,한상맛집,2022-01-11\n"
                + "10,백년미가(유촌점),광주광역시 서구 유덕로28번길 18,062-946-3392,한상맛집,2022-01-11";

        String[] shops = csvStr.split("\n"); // {"1,맘스쿡,광주광역시 동구 동계천로143,062-233-1233,향토맛집,2022-01-11", "", ..}

        FoodShop[] shopArr = new FoodShop[shops.length];

        for(int i=0; i<shops.length; i++){ // shops[i] == "가게번호,상호명,주소,.."
            String[] arr = shops[i].split(","); // {"1", "맘스쿡", "광주광역시", ...}
            shopArr[i] = new FoodShop(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], arr[4], LocalDate.parse(arr[5]));
        }

        for(FoodShop s : shopArr){
            System.out.println(s);
        }

        return new FoodShop[0];
    }
}
