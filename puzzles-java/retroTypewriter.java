import java.util.*;

class retroTypewriter {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String T = in.nextLine();
        int i = 0;

        while (i < T.length()) {
            if (T.charAt(i) == ' ') {
                i++; 
            } else {
                int j = i;
                int k = 0;
                StringBuilder res = new StringBuilder();

                while (j < T.length() && T.charAt(j) != ' ') {
                    if (T.charAt(j) >= '0' && T.charAt(j) <= '9') {
                        k = k * 10 + (T.charAt(j++) - '0'); 
                    } else {
                        res.append(T.charAt(j++)); 
                    }
                }

                String resString = res.toString();

                if (resString.equals("nl") && k == 0) {
                    System.out.print("\n"); 
                } else {
                    if (resString.equals("")) {
                        char cur_res = (char) (k % 10 + '0'); 
                        k /= 10;
                        for (int l = 0; l < k; ++l) {
                            System.out.print(cur_res);
                        }
                    } else {
                        if (resString.equals("sp")) {
                            resString = " ";
                        } else if (resString.equals("bS")) {
                            resString = "\\";
                        } else if (resString.equals("sQ")) {
                            resString = "'";
                        } else if (resString.equals("nl")) {
                            resString = "\n";
                        }

                        for (int l = 0; l < k; ++l) {
                            System.out.print(resString);
                        }
                    }
                }
                i = j; 
            }
        }
    }
}
