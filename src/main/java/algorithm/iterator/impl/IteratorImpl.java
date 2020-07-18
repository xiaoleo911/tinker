package algorithm.iterator.impl;

import algorithm.iterator.Iterator;

import java.util.List;

/**
 * author: fupeng
 * time: 2020-07-18 23:32
 */
public class IteratorImpl<E> implements Iterator<E> {

    private List<E> list;
    private int cursor;

    IteratorImpl(List<E> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        if (cursor < list.size()) {
            return true;
        }
        return false;
    }

    @Override
    public E next() {
        return list.get(cursor++);
    }
}
