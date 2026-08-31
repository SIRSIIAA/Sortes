package magisterzuo.disciplina;

public class Disciplina32 {
    public static class BitSet {
        public int[] set;

        public BitSet(int size) {
            // ceiling: (a + b - 1) / b; a > 0 && b > 0
            set = new int[(size + 31) / 32];
        }

        public void add(int num) {

        }

        public void remove(int num) {
        }

        public void reverse(int num) {
        }

        public boolean contains(int num) {
            return false;
        }
    }
}
