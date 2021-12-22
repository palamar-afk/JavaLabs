package test1.com.company;

public interface List<T> extends Iterable<T>{
    void Add(T obj);
    void Remove(T obj);
    int Size();

    default boolean Contains(T obj){
        for(T t : this)
        {
            if(t.equals(obj))
            {
                return true;
            }
        }
        return false;
    }
}
