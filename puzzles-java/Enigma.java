import java.util.*;

class Enigma {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String operation = in.nextLine();
        int pseudoRandomNumber = in.nextInt();
        in.nextLine(); // Consume the newline

        String[] rotors = new String[3];
        for (int i = 0; i < 3; i++) {
            rotors[i] = in.nextLine();
        }
        char[] message = in.nextLine().toCharArray();

        if (operation.equals("ENCODE")) {
            char[] encodedMessage = new char[message.length];

            for (int i = 0; i < message.length; i++) {
                if (message[i] == ' ') {
                    encodedMessage[i] = ' ';
                } else {
                    char c = (char) ((message[i] - 'A' + pseudoRandomNumber++) % 26 + 'A');
                    for (int j = 0; j < 3; j++) {
                        c = rotors[j].charAt(c - 'A');
                    }
                    encodedMessage[i] = c;
                }
            }
            System.out.println(new String(encodedMessage));
        } else { // Decode
            char[] decodedMessage = new char[message.length];

            for (int i = 0; i < message.length; i++) {
                if (message[i] == ' ') {
                    decodedMessage[i] = ' ';
                } else {
                    char c = message[i];
                    for (int j = 2; j >= 0; j--) {
                        c = (char) (rotors[j].indexOf(c) + 'A');
                    }
                    c = (char) ((c - 'A' - (pseudoRandomNumber++) % 26 + 26) % 26 + 'A');
                    decodedMessage[i] = c;
                }
            }
            System.out.println(new String(decodedMessage));
        }
    }
}
