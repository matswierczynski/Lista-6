package com.company;

import java.lang.annotation.ElementType;

/**
 * Created by Mati on 2017-04-17.
 */
public interface LinkedListInterface<E> {
    boolean isEmpty();
    int getSize();
    void set (int row, int col, int o) throws IndexOutOfBoundsException;
    int get(int row, int col) throws IndexOutOfBoundsException;
}

