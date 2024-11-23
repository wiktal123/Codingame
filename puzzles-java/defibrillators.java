import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class defibrillators {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String LON = in.next();
        String LAT = in.next();
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        LON = LON.replace(",", ".");    
        LAT = LAT.replace(",", ".");   

        double lonA = Math.toRadians(Double.parseDouble(LON));
        double latA = Math.toRadians(Double.parseDouble(LAT));

        double minDist = Double.POSITIVE_INFINITY;
        String bestAddress="";

        for (int i = 0; i < N; i++) {
            String DEFIB = in.nextLine();
            DEFIB = DEFIB.replace(",", ".");
            String[] defib = DEFIB.split(";");

            String name = defib[1];
            Double lonB = Math.toRadians(Double.parseDouble(defib[4]));
            Double latB = Math.toRadians(Double.parseDouble(defib[5]));

            Double horDist = (lonB - lonA) * Math.cos((latA + latB) / 2.0);
            Double verDist = latB - latA;
            Double dist = Math.sqrt(Math.pow(horDist, 2) + Math.pow(verDist, 2)) * 6371;

            if (dist < minDist) {
                minDist = dist;
                bestAddress = name;
            }
        }
        System.out.println(bestAddress);
    }
}