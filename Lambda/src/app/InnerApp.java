package app;

/**
 * InnerApp
 */
@FunctionalInterface
public interface InnerApp {
    public void func(); // 이 줄만 정의되어 있다면 static, default 등 다른 무엇이 정의되어 있어도 함수형 인터페이스로서 인정.
    public static void test() {}
}