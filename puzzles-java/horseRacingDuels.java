import java.util.*;

class horseRacingDuels {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] horses = new int[N];
        for (int i = 0; i < N; i++) {
            int pi = in.nextInt();
            horses[i] = pi;
        }

        Arrays.sort(horses);
        int res = horses[1] - horses[0];

        for (int i = 0; i < N-1; i++){
            if(horses[i+1] - horses[i] < res) res = horses[i+1] - horses[i];
        }

        System.out.println(res);
    }
}
