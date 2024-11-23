import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class LogicGates {

    public static String perform_gate_operation(String gate, String input1, String input2) {
        String result = "";
        for (int i = 0; i < input1.length(); i++) {
            char a = input1.charAt(i);
            char b = input2.charAt(i);
            if (gate.equals("AND")) {
                result += (a == '-' && b == '-') ? "-" : "_";
            } 
            else if (gate.equals("OR")) {
                result += (a == '_' && b == '_') ? "_" : "-";
            } 
            else if (gate.equals("XOR")) {
                result += (a == b) ? "_" : "-";
            }
            else if (gate.equals("NAND")) {
                result += (a == '-' && b == '-') ? "_" : "-";
            }
            else if (gate.equals("NOR")) {
                result += (a == '_' && b == '_') ? "-" : "_";
            }
            else if (gate.equals("NXOR")) {
                result += (a == b) ? "-" : "_";
            }
        }
        return result;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Map<String, String> signals = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String inputName = in.next();
            String inputSignal = in.next();
            signals.put(inputName, inputSignal);
        }

        Vector<Pair> outputs = new Vector<>();
        for (int i = 0; i < m; i++) {
            String outputName = in.next();
            String type = in.next();
            String inputName1 = in.next();
            String inputName2 = in.next();
            String outputSignal = perform_gate_operation(type, signals.get(inputName1), signals.get(inputName2));
            outputs.add(new Pair(outputName, outputSignal));
        }
        for (int i = 0; i < m; i++) {
            System.out.println(outputs.get(i).outputName + " " + outputs.get(i).outputSignal);
        }
    }

    public static class Pair {
        public String outputName;
        public String outputSignal;

        public Pair(String outputName, String outputSignal) {
            this.outputName = outputName;
            this.outputSignal = outputSignal;
        }
    }

}