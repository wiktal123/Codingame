import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class AsciiArt {

    public static String build_text(String T, int width, int height, Map<Character, Vector<String>> letters) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (char chr : T.toCharArray()) {
                char c = Character.toUpperCase(chr);
                if(c<'A' || c>'Z') {
                    sb.append(letters.get('?').get(i));
                }
                else{
                    sb.append(letters.get(c).get(i));
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt();
        int H = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        String T = in.nextLine();
        Map<Character, Vector<String>> letters = new HashMap<>();

        for (int i = 0; i < H; i++) {
            String ROW = in.nextLine();
            if(ROW.length() == 0) continue;
            int idx = 0, letterIdx = 0;
            while(idx < ROW.length()) {
                char c = (char)('A' + letterIdx);
                if(c=='[') c = '?';
                String letter = ROW.substring(idx, idx + W);
                if(!letters.containsKey(c)) {
                    letters.put(c, new Vector<>());
                }
                letters.get(c).add(letter);
                idx += W;
                letterIdx++;
            }
        }
        System.out.println(build_text(T, W, H, letters));
    }
}