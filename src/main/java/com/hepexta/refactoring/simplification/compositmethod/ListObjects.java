package com.hepexta.refactoring.simplification.compositmethod;

public class ListObjects {
    private boolean readOnly;
    private int size;
    private Object[] elements;

    public ListObjects() {
        this.elements = new Object[0];
        this.size = 0;
        this.readOnly = false;
    }

    public ListObjects(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public void add(Object element) {
        if (!readOnly) {
            int newSize = size + 1;
            if (newSize > elements.length) {
                Object[] newElements = new Object[elements.length + 10];
                for (int i = 0; i < size; i++)
                    newElements[i] = elements[i];
                elements = newElements;
            }
            elements[size++] = element;
        }
    }


    public int size() {
        return size;
    }
}
