package com.example.android_related.practices;

public class CustomArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public CustomArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            Object[] newArray = new Object[elements.length * 2];
            for(int i = 0; i < elements.length; i++) {
                newArray[i] = elements[i];
            }
            elements = newArray;
        }
    }

    public E get(int index) {
        rangeCheck(index);
        return (E) elements[index];
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("");
        }
    }

    public E remove(int index) {
        E val = (E) elements[index];
        transformArray(index);
        size--;
        return val;
    }

    private void transformArray(int index) {
        for(int i = index; i < size-1; i++) {
            Object temp = elements[index];
            elements[index] = elements[index + 1];
            elements[index + 1] = temp;
        }
        elements[size - 1] = null;
    }

    public E remove(E e) {
        Object result = null;
        for(int i = 0; i < size; i++) {
            if (elements[i].equals(e)) {
                result = elements[i];
                remove(i);
                break;
            }
        }
        return (E) result;
    }

    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
    }
}
