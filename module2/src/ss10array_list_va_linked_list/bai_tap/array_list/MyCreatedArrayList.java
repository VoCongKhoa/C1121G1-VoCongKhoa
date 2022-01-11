package ss10array_list_va_linked_list.bai_tap.array_list;

import java.util.Arrays;

public class MyCreatedArrayList<E> {
    private int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyCreatedArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyCreatedArrayList(int capacity) {
        elements = new Object[capacity];
    }

    //done
    public void add(int index, E element) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size());
        }else {
            if (size == elements.length) {
                ensureCapacity(size);
            }
            int numberLength = 0;
            for (Object o : elements) {
                if (o != null) {
                    numberLength++;
                }
            }
            if (index == numberLength) {
                elements = Arrays.copyOf(elements, index + 1);
                elements[index] = element;
            } else if (index < numberLength) {
                elements = Arrays.copyOf(elements, numberLength + 1);
                for (int i = elements.length - 1; i > 0; i--) {
                    if (i > index) {
                        elements[i] = elements[i - 1];
                    } else if (i == index) {
                        elements[i] = element;
                    }

                }
            }
            size++;
        }

    }

    //done
    public E remove(int index) {
        E result = null;
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Size = " + size() + " ,Index = " + index);
        } else {
            result = (E) elements[index];
            for (int i = index; i < elements.length-1; i++) {
                if (elements[i] == null){
                    break;
                }
                elements[i] = elements[i+1];
            }
            elements[elements.length-1] = null;
        }
        return result;
    }

    //done
    public int size() {
        return elements.length;
    }

    //done
    public E[] clone() {
        elements = Arrays.copyOf(elements,size());
        return (E[]) elements;
    }

    //done
    public boolean contains(Object o) {
        boolean isContain = false;
        for (Object element : elements) {
            if (element.equals(o)) {
                isContain = true;
                break;
            }
        }
        return isContain;
    }

    //done
    public int indexOf(E o) {
        int currentPosition = -1;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == null) {
                break;
            }
            if (elements[i].equals(o)) {
                currentPosition = i;
                break;
            }
        }
        return currentPosition;
    }

    //done
    public boolean add(E o) {
        if (size == elements.length) {
            ensureCapacity(size());
        }
//        elements = Arrays.copyOf(elements,size()+1);
        int numberLength = 0;
        for (Object element : elements) {
            if (element != null) {
                numberLength++;
            }
        }
        elements[numberLength] = o;
        size++;
        return true;
    }

    //done
    private void ensureCapacity(int minCapacity) {
        int newCapacity = minCapacity * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    //done
    public E get(int i) {
        if (i >= size() || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + size());
        }
        return (E) elements[i];
    }

    //done
    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
    }
}
