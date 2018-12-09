package com.hepexta.refactoring.simplification.compositmethod;

public class ListObjects {
    private boolean readOnly;
    private int size;
    private Object[] elements;
    private static final int GROWN_INCREMENT = 10;

    public ListObjects() {
        this.elements = new Object[0];
        this.size = 0;
        this.readOnly = false;
    }

    public ListObjects(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public void add(Object element) {
        if (readOnly) return;
        if (isGrow()) {
            grow();
        }
        addElement(element);
    }

    public int size() {
        return size;
    }

    private boolean isGrow() {
        return size + 1 > elements.length;
    }

    private void grow() {
        Object[] newElements = new Object[elements.length + GROWN_INCREMENT];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    private void addElement(Object element) {
        elements[size++] = element;
    }
}
