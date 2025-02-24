package com.jun.practice7.run;


import com.jun.practice7.controller.ProductManager;
import com.jun.practice7.controller.ProductManager_ArrayList;

public class Application {

    public static void main(String[] args) {
//		new ProductManager().mainMenu(); // 객체배열
        new ProductManager_ArrayList() .mainMenu(); // ArrayList 이용
    }

}
