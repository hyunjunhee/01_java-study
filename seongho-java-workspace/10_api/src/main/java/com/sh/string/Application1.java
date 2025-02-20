package com.sh.string;

public class Application1 {
    public static void main(String[] args) {
        // length() 문자열 길이(글자수) 반환
        String str1="hello";
        System.out.println(str1.length());
        // charAt(int) : 문자열로부터 인자로 전달된 인덱스 자리의 문자 반환
        System.out.println("charAt(): " +str1.charAt(2));

        String str2 ="java";
        String str3 ="java";
        String str4 ="JAVA";
        String str5 ="oracle";

        /*
        compareTo(String) 인자로 전달된 문자열과 사전순으로  (대소문자 구분)하여 정수 반환
                            기준이 되는 문자열 - 인자로 전달되는 문자열
                            =>두 문자열이 같으면 0 반환
                            >인자 문자열이 더 클 경우 음수 반환
                            >인자 문자열이 더 작을 경우 양수 반환
         */

        System.out.println("compareTo(): " + str2.compareTo(str3));

        System.out.println("compareTo(): " + str2.compareTo(str4)); // 32 인자로 전달된 문자열이 더 작다
        System.out.println("compareTo(): " + str4.compareTo(str2)); // -32 반대

        System.out.println("compareTo(): " +str2.compareTo(str5)); //-5
        System.out.println("compareTo(): " +str5.compareTo(str2)); //5

        //compareToIgnoreCase :동일한데 대소문자 무시
        System.out.println("compareToIgnoreCase:" +str2.compareToIgnoreCase(str4));

        // equals(object): 기존 문자열과 인자로 전달된 문자열이 일치하는지 비교 후 반환(대소문자 구분함)
        // equalsIgnoreCase(String) : 위와 동일하나 대소문자 구분없이 구분
        System.out.println("equals :"+ str2.equals(str4));
        System.out.println("equals :"+ str2.equalsIgnoreCase(str4));

        //concat(String) : 기준 문자열에 인자로 전달된 문자열을 합쳐 새로운 문자열로 만들어 반환
        System.out.println("concat()"+ str2.concat(str5));//javaoracle
        System.out.println(str2);

        //indexOf(String): 인자로 전달된 문자열을 앞에서부터 탐색해서 처음으로 일치하는 인덱스 위치 반환(없으면 -1)
        //lastindexOf(String): 인자로 전달된 문자열을 뒤에서부터 탑색해서 처음으로 일치하는 인덱스 위치 반환(없으면 -1)
        String idxStr="hello world";
        System.out.println("indexOf(l):" + idxStr.indexOf("l"));//2
        System.out.println("lastindexOf(l):" + idxStr.lastIndexOf("l"));//9
        System.out.println("indexOf(lo): " +idxStr.indexOf("lo"));//3
        System.out.println("indexOf(a): " +idxStr.indexOf("a"));//-1

        //substring: 문자열의 특정 범위 문자열을 반환(원본 영향 x)
        //substring(int beginIndex) 시작인덱스에서부터 문자열의 끝까지 반환
        //substring(int beginIndex  ,int endIndex) 시작인덱스 부터 끝인덱스 이전까지를 반환
        System.out.println("substring(6):" + idxStr.substring(6));
        System.out.println("substring(0,4):" + idxStr.substring(0,4)); // 0<= <

        //toUpperCase(): 대문자로 변경해서 반환
        //toLowerCase(): 소문자로 변경해서 반환
        System.out.println("toUpperCase:" + idxStr.toUpperCase());
        System.out.println("toLowerCase:" + str4.toLowerCase());


        //>CharSequence : String 클래스가 구현하고 있는 부모 인터페이스
        // contains(CharSequence) :인자로 전달된 문자열이 포함되어 있을 경우 true 반환
        // startWith(String): 인자로 전달된 문자열로 시작할경우 true
        // endsWith(String): 인자로 전달된 문자열로 끝날경우 true
        String email = "user01@naver.com";
        System.out.println("startWith(user):" + email.startsWith("user"));
        System.out.println("startWith(admin):" + email.startsWith("admin"));

        System.out.println("endsWith(.com)"+ email.endsWith(".com"));
        System.out.println("endsWith(.kr)"+ email.endsWith(".kr"));

        System.out.println("contains(@):" + email.contains("@"));

        //replace(CharSequence, CharSequence) :첫번째 인자 문자열을 찾아 두번째 문자열로 변환시킨 새 문자열 반환
        String ip = "192.168.0.202";
        System.out.println("replace(. , _):"+ip.replace(".","_"));

        //trim(): 문자열의 앞과 뒤의 공백 제거한 새로운 문자열 반환
        String content = "\n  반갑소. 김성호입니다. \n";
        System.out.println("trim():#" + content.trim()+"#");

        //isEmpty(): 문자열이 빈문자열일경우 true
        //isBlank(): 문자열이 빈문자열"",공백 문자열 "  "일경우 true ) java11이상 부터
        System.out.println("".isEmpty());
        System.out.println("  ".isEmpty());

        System.out.println("".isBlank());
        System.out.println("  ".isBlank());

        //split(String) : 인자로 전달된 문자열을 기준으로 분리시켜 String[] 배열에 담아 반환
        // static join(CharSequence, CharSequence...)
        // : 인자로 전달된 String[] 배열의 요소들을 특정 구분자와 함께 하나의 문자열로 연결시켜 반환
        String lectures = "Java,MySQL,MyBatis,Front,Spring";
        String[] lecarr = lectures.split(","); //{"Java", "MySQL", "MyBatis","Front","Spring"}
        System.out.println("분리된 문자열 수 :"+lecarr.length);
        System.out.println(lecarr[1]);
        for (String lec :lecarr){
            System.out.println(lec);
        }
        String newStr = String.join("-",lecarr);
        System.out.println(newStr);

        //toCharArray(): 문자열 각 문자들을 char[]에 담아 반환
        char[] charArr = newStr.toCharArray();
        System.out.println("char[]길이"+charArr.length);
        System.out.println("1번 인덱스"+charArr[1]);


    }
}
