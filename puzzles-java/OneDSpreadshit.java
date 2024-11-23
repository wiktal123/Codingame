import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class OneDSpreadshit {
    public class Cell {
        public String operation;
        public String arg1;
        public String arg2;
        }

    public static int getValue( Vector<Cell> cells, String arg, Map<Integer, Integer> memo) {
        if(arg.charAt(0) == '$') {
            int refIndex = Integer.parseInt(arg.substring(1));
            return resolveValue(cells, refIndex, memo);
        }
        else {
            return Integer.parseInt(arg);
        }
    }

    public static int resolveValue( Vector<Cell> cells, int index, Map<Integer, Integer> memo){
        if (memo.containsKey(index) == false) {
            return memo.get(index);
        }
        Cell cell = cells.get(index);
        int value = 0;
        if(cell.operation.equals("VALUE")) {
            value = getValue(cells, cell.arg1, memo);
        }
        else if(cell.operation.equals("ADD")) {
            value = getValue(cells, cell.arg1, memo) + getValue(cells, cell.arg2, memo);
        }
        else if(cell.operation.equals("SUB")) {
            value = getValue(cells, cell.arg1, memo) - getValue(cells, cell.arg2, memo);
        }
        else if(cell.operation.equals("MULT")) {
            value = getValue(cells, cell.arg1, memo) * getValue(cells, cell.arg2, memo);
        }

        memo.put(index, value);
        return value;
    }
   
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Cell[] cells = new Cell[N]; // Replace Vector<Cell> with Cell[]
        for (int i = 0; i < N; i++) {
            String operation = in.next();
            String arg1 = in.next();
            String arg2 = in.next();
            cells[i].operation = operation;
            cells[i].arg1 = arg1;
            cells[i].arg2 = arg2;
        }

        Vector<Cell> cellsVector = new Vector<>();
        Collections.addAll(cellsVector, cells);
        Map<Integer, Integer> memo = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int value = 0;
            value = resolveValue(cellsVector, i, memo);
            System.out.println(value);
        }
    }
}