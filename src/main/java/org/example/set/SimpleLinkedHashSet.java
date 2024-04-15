package org.example.set;

import java.util.LinkedHashMap;
import java.util.Optional;

public class SimpleLinkedHashSet<E> implements SimpleSet<E>{

    private LinkedHashMap<E, Object> map;
    private static final Object PRESENT = new Object();

    public SimpleLinkedHashSet() {
        map = new LinkedHashMap<>();
    }

    public Optional<E> getElement(E e) {
        return map.containsKey(e) ? Optional.of(e) : Optional.empty();
    }

    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }

    public boolean contains(E e) {
        return map.containsKey(e);
    }

    public boolean remove(E e) {
        return map.remove(e) == PRESENT;
    }

    public int size() {
        return map.size();
    }

    public void clear() {
        map.clear();
    }
}
