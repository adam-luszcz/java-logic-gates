public class App {
    private static boolean AND(boolean A, boolean B) {
        return A && B;
    }

    private static boolean NOT(boolean A) {
        return !A;
    }

    private static boolean NAND(boolean A, boolean B) {
        return NOT(AND(A, B));
    }

    private static boolean OR(boolean A, boolean B) {
        return NAND(NOT(A), NOT(B));
    }

    private static boolean XOR(boolean A, boolean B) {
        return AND(OR(A, B), NAND(A, B));
    }

    private static boolean[] ADDER(boolean A, boolean B, boolean carryInput) {
        return new boolean[]{XOR(XOR(A, B), carryInput), OR(AND(XOR(A, B), carryInput), AND(A, B))};
    }


    public static void main(String[] args) {
        System.out.printf("|0 0|%b %b\n", ADDER(false, false, false)[0], ADDER(false, false, false)[1]);
        System.out.printf("|0 1|%b %b\n", ADDER(false, true, false)[0], ADDER(false, true, false)[1]);
        System.out.printf("|1 0|%b %b\n", ADDER(true, false, false)[0], ADDER(true, false, false)[1]);
        System.out.printf("|1 1|%b %b", ADDER(true, true, false)[0], ADDER(true, true, false)[1]);
    }
}
