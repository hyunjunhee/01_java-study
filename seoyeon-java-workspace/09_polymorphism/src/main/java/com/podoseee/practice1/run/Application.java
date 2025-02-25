package com.podoseee.practice1.run;

import com.podoseee.practice1.dto.Animal;
import com.podoseee.practice1.dto.Dog;

public class Application {
    public static void main(String[] args) {
        // Animal 타입의 객체배열 크기 5로 생성
        Animal[] animal = new Animal[5];
        // 각 인덱스에 무작위로 Dog객체 또는 Cat객체로 생성
        // (이때, 매개변수 생성자를 이용하여 생성)
        Animal[0] = new Cat("Tom", "고양이", "")

        // 반복문을 통해서 해당 배열의 0번 인덱스부터 마지막 인덱스까지의
        // 객체의 speak() 메소드 호출
        for(int i=0; i<animal.length; i++){
            animal.speak();
        }
    }
}
