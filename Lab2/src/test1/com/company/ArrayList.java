package test1. com.company;

import java.util.Iterator;

public class ArrayList<T> implements MyCollection<T>{
    private Object[] items;
    private int size = 0;

    ArrayList(){
        items = new Object[10];
    }

    ArrayList(int capacity){
        items = new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean removeLast() {
        if(size > 0)
            size--;

        return size > 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<T> {
        private int currentIndex = -1;

        @Override
        public boolean hasNext() {
            return currentIndex != size-1;
        }

        @Override
        public T next() {
            currentIndex++;
            return (T) items[currentIndex];
        }

        @Override
        public void remove(){
            ArrayList.this.remove(currentIndex);
        }
    }

    @Override
    public void add(Object element) {
        checkCapacity();
        items[size] = element;
        size++;
    }

    private void checkCapacity(){
        if(size == items.length){
            Object[] tempArray = new Object[items.length+(items.length/2)];
            System.arraycopy(items, 0, tempArray, 0, items.length);
            items = tempArray;
        }
    }

    @Override
    public boolean remove(Object element) {
        return remove(getIndexOf(element));
    }

    public boolean remove(int index) {
        if(!(index <= size - 1 && index >= 0)){
            return false;
        }

        Object[] tempArray = new Object[items.length];

        if (index >= 0)
            System.arraycopy(items, 0, tempArray, 0, index);
        if (size - 1 - index > 0)
            System.arraycopy(items, index + 1, tempArray, index, size - 1 - index);
        --size;
        items = tempArray;
        return true;
    }

    public int getIndexOf(Object element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(items[i]))
                return i;
        }
        return -1;
    }
}