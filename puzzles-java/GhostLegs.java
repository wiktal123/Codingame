import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class GhostLegs {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt();
        int H = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        String[] diagram = new String[H];

        for (int i = 0; i < H; i++) {
            diagram[i] = in.nextLine();
        }

        String top_labels = diagram[0];
        String bottom_labels = diagram[H - 1];

        for (int i = 0; i < W; ++i) {
            if(top_labels.charAt(i) != ' '){
                int x = i;
                for(int y = 1; y<H-1; y++){
                    if(x>0 && diagram[y].charAt(x-1) == '-'){
                        x-=3;
                    }else if(x<W-1 && diagram[y].charAt(x+1) == '-'){
                        x+=3;
                    }
                }
                System.out.println("" + top_labels.charAt(i) + bottom_labels.charAt(x));
            }
        }
    }
}