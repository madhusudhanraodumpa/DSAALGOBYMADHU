import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Test {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s= sc.next();
        Integer i =Integer.parseInt(s);
        System.out.println(i);
       // I/*nteger value= new Integer(s.getBytes(StandardCharsets.UTF_8));
       // value=value.add(BigInteger.ONE);
        /*String x= new String(value.toByteArray(),StandardCharsets.UTF_8);
        System.out.println(x);
        i=value.intValue();
        System.out.println(i);
        BigInteger b=BigInteger.valueOf((long)i);
        System.out.println(b);*/

    }
}
