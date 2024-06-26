package az.edu.turing.MyProjects;

import java.util.Objects;

class Node<F> {
    private F data;
    private Node<F> next;

    public Node(F data, Node<F> next) {
        this.data = data;
        this.next = next;
    }

    public Node(F data) {
        this.data = data;
    }

    public F getData() {
        return data;
    }

    public Node<F> getNext() {
        return next;
    }

    public void setData(F data) {
        this.data = data;
    }

    public void setNext(Node<F> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "data=" + data + "-->";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return data == node.data && Objects.equals(next, node.next);
    }


    @Override
    public int hashCode() {
        return Objects.hash(data, next);
    }
}

public class LinkedList<T> {
    private int size;
    private Node head;
    private Node<T> tail;

    public LinkedList(T head) {
        this.head = new Node<>(head);
        size++;
    }

    public int getSize() {
        return size;
    }

    boolean isEmpty() {
        return head == null;
    }

    public void addHead(T data) {
        this.head = new Node<>(data, head);
        size++;

    }

    public void addTail(T data) {
        Node<T> tail = new Node<>(data);
        if (head == null) {
            head = tail;
        } else {
            Node<T> curr = head;
            while (curr.getNext() != null) {
                curr = curr.getNext();
            }
            curr.setNext(tail);
        }
        size++;
    }


    public T get(int index) {
        Node<T> current = head;
        int count = 0;
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        while (count < index) {
            current = current.getNext();
            count++;
        }
        return current.getData();
    }

    public void deleteIndex(int index) {
        if (head == null || index < 0) {
            return;
        }
        if (index == 0) {
            head = head.getNext();
            size--;
            return;
        }
        Node<T> temp = head;
        for (int i = 0; temp != null && i < index - 1; i++) {
            temp = temp.getNext();
        }
        if (temp == null || temp.getNext() == null) {
            return;
        }
        temp.setNext(temp.getNext().getNext());
        size--;
    }

    public void delete(T value) {
        if (head == null || value == null) {
            return;
        }
        if (head.getData().equals(value)) {
            head = head.getNext();
            size--;
            return;
        }
        Node<T> prev = null;
        Node<T> current = head;
        while (current != null && !current.getData().equals(value)) {
            prev = current;
            current = current.getNext();
        }
        if (current == null) {
            return;
        }
        if (prev != null) {
            prev.setNext(current.getNext());
        }
        size--;
    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        Node<T> curr = head;
        while (curr != null) {
            s.append(curr.toString());
            curr = curr.getNext();
        }
        return s.toString();
    }
    public void update(int index, T value) {
    if (head == null || index < 0) {
        return;
    }
    Node<T> current = head;
    for (int i = 0; current != null && i < index; i++) {
        current = current.getNext();
    }
    if (current == null) {
        return;
    }
    current.setData(value);
}
}
