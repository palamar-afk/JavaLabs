package test1.com.company;

public interface MyCollection<T> extends Iterable<T> {
    void add(T element);
    boolean remove(T element);
    int size();
    boolean removeLast();

    default boolean contains(T element){
        for(T T : this){
            if (element.equals(T)) {
                return true;
            }
        }
        return false;
    };
}
