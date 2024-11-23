import java.util.*;

class Temperatures {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        if (n == 0) {
            System.out.println("0");
            return;
        }
        int result = 5527;

        for (int i = 0; i < n; i++) {
            int t = in.nextInt(); 
            if (Math.abs(t) < Math.abs(result) || (Math.abs(t) == Math.abs(result) && t > result)) {
                result = t;
            }
        }
        System.out.println(result);
    }
}