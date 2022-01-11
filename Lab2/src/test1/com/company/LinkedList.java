package test1.com.company;

import java.util.Iterator;

public class LinkedList<T> implements List<T> {
    Node<T> firstNode;
    int size;

    private class Node<T>
    {
        T element;
        Node<T> nextElement;

        Node(T elem){
            this.element = elem;
            nextElement=null;
        }
    }
    @Override
    public void Add(T obj) {
        Node<T> newNode = new Node<>(obj);
        if(firstNode == null)
        {
            firstNode = newNode;
        }
        else{
            getLastNode().nextElement = newNode;
        }
    }

    @Override
    public void Remove(T obj) {
        Iterator<T> iterator = iterator();
        T tempObj;

        while(iterator.hasNext()){
            tempObj = iterator.next();
            if(obj.equals(tempObj))
            {
                iterator.remove();
                --size;
                return;
            }
        }
    }

    public int Size() {
        return size;
    }

    private Node<T> getLastNode() {
        Node<T> node = firstNode;
        while (node.nextElement != null)
        {
            node = node.nextElement;
        }
        return node;
    }


    public Iterator<T> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<T> {
        Node<T> prevNode = null;
        Node<T> currentNode = null;

        public boolean hasNext() {
            if (currentNode == null)
                return firstNode != null;
            else
                return currentNode.nextElement != null;
        }

        public T next() {
            if (currentNode == null)
                currentNode = firstNode;
            else {
                prevNode = currentNode;
                currentNode = currentNode.nextElement;
            }
            return currentNode.element;
        }

        public void remove() {
            if (prevNode == null) {
                firstNode = firstNode.nextElement;
            } else
                prevNode.nextElement = currentNode.nextElement;
        }
    }
}
