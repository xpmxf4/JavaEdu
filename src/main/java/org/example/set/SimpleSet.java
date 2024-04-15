package org.example.set;

import java.util.Optional;

public interface SimpleSet<E> {

    public boolean add(E e);
    public boolean contains(E e);
    public boolean remove(E e);
    Optional<E> getElement(E e);
    public int size();
    public void clear();
}
