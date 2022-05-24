public class Chars {
    
    Object[] elements;

    public Chars(int amount) {
        this.elements = new Object[amount];
    }

    public void set(int pos, Object value) {
        this.elements[pos] = value;
    }

    public String toString() {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < elements.length; i++) {
            temp.append(elements[i] + " ");
        }

        return temp.toString();
    }
}
