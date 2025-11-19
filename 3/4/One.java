public class One{

    static void SumSomeThingAndSay(int a, int b){
        System.err.println(a+b);
    }

    static void SumSomeThingAndSay(String a, String b){
        System.err.println(a+b);
    }

    public static void main(String[] args) {
        SumSomeThingAndSay(1, 2); //out: 3
        SumSomeThingAndSay("Hello ", "world!");// out: Hello world!
    }
}


