import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DoublyLinkedListTest {

    @Test
    public void givenEmptyList_whenInsertAtEnd_thenListContainsOneElement() {
        // Given
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        // When
        list.insertAtEnd(42);

        // Then
        assertEquals("Doubly Linked List: 42", list.toString());
    }

    @Test
    public void givenListWithElements_whenInsertInMiddle_thenElementInsertedCorrectly() {
        // Given
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insertAtEnd(1);
        list.insertAtEnd(3);

        // When
        list.insertInMiddle(2, 2);

        // Then
        assertEquals("Doubly Linked List: 1 2 3", list.toString());
    }

    @Test
    public void givenListWithElements_whenInsertInMiddleAtBeginning_thenElementInsertedCorrectly() {
        // Given
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insertAtEnd(2);
        list.insertAtEnd(3);

        // When
        list.insertInMiddle(1, 1);

        // Then
        assertEquals("Doubly Linked List: 1 2 3", list.toString());
    }

    @Test
    public void givenUnsortedList_whenSort_thenListIsSorted() {
        // Given
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insertAtEnd(5);
        list.insertAtEnd(2);
        list.insertAtEnd(7);

        // When
        list.sort();

        // Then
        assertEquals("Doubly Linked List: 2 5 7", list.toString());
    }

    @Test
    public void givenSortedList_whenSort_thenListRemainsSorted() {
        // Given
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insertAtEnd(1);
        list.insertAtEnd(3);
        list.insertAtEnd(5);

        // When
        list.sort();

        // Then
        assertEquals("Doubly Linked List: 1 3 5", list.toString());
    }
}
