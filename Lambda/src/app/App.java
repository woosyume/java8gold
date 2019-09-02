package app;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

public class App {
    public static void main(String[] args) throws Exception {
        // Predicate으로 대체 가능
        // Foo foo = new Foo(){
        
        //     @Override
        //     public boolean check(String str) {
        //         return str.equals("Hello");
        //     }
        // };
        // System.out.println(foo.check(args[0]));

        // 아 이렇게 정의를 해두고 쓰는구나.
        BiFunction<Double, Integer, Double> val = (t1, t2) -> t1 + t2;
        System.out.println(val.apply(10.0, 10));

        System.out.println("************************");

        List<Integer> codes = Arrays.asList(10, 20);
        UnaryOperator<Double> uo = s -> s + 10.0;
        // codes.replaceAll(uo); compile error... Integer != Double

        System.out.println("************************");

        
    }
}