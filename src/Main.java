class Node<T> {
    T data;
    Node<T> next;
    Node<T> prev;

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList<T> {
    Node<T> head;

    public void insertAtEnd(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    public void insertInMiddle(int data, int position) {
        Node newNode = new Node(data);

        if (position < 1) {
            System.out.println("Position sollte größer oder gleich 1 sein.");
            return;
        }

        if (position == 1) {
            // Füge am Anfang ein
            if (head != null) {
                newNode.next = head;
                head.prev = newNode;
            }
            head = newNode;
        } else {
            // Füge in der Mitte oder am Ende ein
            Node current = head;
            int currentPosition = 1;

            while (currentPosition < position - 1 && current != null) {
                current = current.next;
                currentPosition++;
            }

            if (current == null) {
                System.out.println("Ungültige Position. Liste ist zu kurz.");
                return;
            }

            newNode.next = current.next;
            if (current.next != null) {
                current.next.prev = newNode;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    public void display() {
        Node current = head;
        System.out.print("Doubly Linked List: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void sort() {
        if (head == null || head.next == null) return;

        boolean swapped;
        Node<T> last;

        do {
            swapped = false;
            last = null;
            Node<T> current = head;

            while (current.next != last) {
                if (((Comparable<T>) current.data).compareTo(current.next.data) > 0) {
                    T temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }

                current = current.next;
            }

            last = current;
        } while (swapped);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Doubly Linked List: ");
        Node<T> current = head;
        while (current != null) {
            result.append(current.data).append(" ");
            current = current.next;
        }
        return result.toString().trim();
    }
}

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();

        doublyLinkedList.insertAtEnd(1);
        doublyLinkedList.insertAtEnd(4);
        doublyLinkedList.insertAtEnd(3);

        doublyLinkedList.display();
        doublyLinkedList.insertInMiddle(2, 4);
        doublyLinkedList.display();
        doublyLinkedList.sort();
        doublyLinkedList.display();
    }
}

