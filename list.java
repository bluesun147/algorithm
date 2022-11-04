import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class list {
    static List<String> listA = new ArrayList<>();

    public static void main(String[] args) {

        // 데이터 넣기
        listA.add("aaa");
        listA.add("bbb");
        listA.add("ccc");
        listA.add(1, "111"); // 인덱스 자리에 넣기


        System.out.println("listA is " + listA);
        System.out.println("listA.get(2) is " + listA.get(2)); // [2] 꺼내기

        // 모든 데이터 가져올때는 Iterator, for
        Iterator<String> iterator = listA.iterator();

        while(iterator.hasNext()) {
            String elem = iterator.next();
            System.out.println("(Iterator) elem = " + elem);
        }

        for (Object object : listA) {
            String elem = (String)object;
            System.out.println("(for) elem = " + elem);
        }

        /////////////
        // [[stream]] https://hbase.tistory.com/171
        // stream 사용하면 코드 단순해짐 (java 8)
        // 1. 스트림 생성 - 컬렉션
        // 컬렉션 객체에서 stream() 메소드 호출하면 스트림 객체 만들 수 있음
        Stream<String> stream = listA.stream();
        stream.forEach(System.out::println);

        // 생성안하고 바로 써도 됨.
        // listA.stream().forEach(System.out::println);

        // 1. 스트림 생성 - 배열
        // 배열의 경우 메소드 이용하면 됨.
        System.out.println("``````````");
        String[] array = new String[]{"a", "b", "c"};
        Stream<String> stream1 = Arrays.stream(array);
        stream1.forEach(System.out::println);
        System.out.println("``````````");
        // 빌더 사용도 가능

        // 삭제
        System.out.println(listA.remove("bbb")); // 있으면 true, 없으면 false 반환ㄴ
//        System.out.println(listA.remove(0));
        System.out.println("listA is " + listA);

        System.out.println("listA.contains(\"ccc\") is " + listA.contains("ccc"));

    }
}
