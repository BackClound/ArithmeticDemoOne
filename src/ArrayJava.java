public class ArrayJava<Election extends Comparable<Election>> implements Collection<Election> {


    int size = 0;
    int capacity = 10;

    Election[] data = (Election[]) new Object[capacity];
    @Override
    public void add(int index, Election e) {

    }

    @Override
    public void addFirst(Election e) {

    }

    @Override
    public void addLast(Election e) {

    }

    @Override
    public Election get(int index) {
        return null;
    }

    @Override
    public Election remove(int index) {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public Election removeFirst() {
        return null;
    }

    @Override
    public Election removeLast() {
        return null;
    }
}
