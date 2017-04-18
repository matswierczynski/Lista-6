package com.company;

import java.lang.annotation.ElementType;

/**
 * Created by Mati on 2017-04-17.
 */
public interface LinkedListInterface<E> {
    enum INSERT {REPLACE, ADD}
    boolean isEmpty();
    int getSize();
    void set (int row, int col, int o, INSERT insert) throws IndexOutOfBoundsException;
    E get(int row, int col) throws IndexOutOfBoundsException;
    E remove (int row, int col) throws IndexOutOfBoundsException;
    void add (LinkedList<E> linlist);
}

