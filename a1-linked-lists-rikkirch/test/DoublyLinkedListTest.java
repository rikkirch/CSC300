import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;

class DoublyLinkedLisRtTest {
    DoublyLinkedList<Integer> ll;

    /**
     * The setup method that is called before each function marked with @Test is executed. This ensures that each test
     * method has its own linked list instance to work with.
     */
    @BeforeEach
    void setup() {
        ll = new DoublyLinkedList<>();
    }

    @Test
    void getFrontWhenListIsEmpty() {
        assertThrows(NoSuchElementException.class, ll::getFront);
    }

    @Test
    void getRearWhenListIsEmpty() {
        assertThrows(NoSuchElementException.class, ll::getBack);
    }

    @Test
    void getFrontAfterInsertRear() {
        ll.insertBack(10);
        assertEquals(10, ll.getFront());
    }

    @Test
    void getRearAfterInsertRear() {
        ll.insertBack(10);
        assertEquals(10, ll.getBack());
    }

    @Test
    void getFrontAfterInsertFront() {
        ll.insertFront(10);
        assertEquals(10, ll.getFront());
    }

    @Test
    void getRearAfterInsertFront() {
        ll.insertFront(10);
        assertEquals(10, ll.getBack());
    }

    @Test
    void getLenWhenEmpty() {
        assertEquals(0, ll.len());
    }

    @Test
    void getLenAfterInsertFront() {
        ll.insertFront(1);
        assertEquals(1, ll.len());
        ll.insertFront(2);
        assertEquals(2, ll.len());
        ll.insertFront(3);
        assertEquals(3, ll.len());
    }

    @Test
    void getLenAfterInsertRear() {
        ll.insertBack(1);
        assertEquals(1, ll.len());
        ll.insertBack(2);
        assertEquals(2, ll.len());
        ll.insertBack(3);
        assertEquals(3, ll.len());
    }

    @Test
    void isEmptyWhenEmpty() {
        assertEquals(true, ll.isEmpty());
    }

    @Test
    void isEmptyAfterInsertFront() {
        assertEquals(true, ll.isEmpty());
        ll.insertFront(1);
        assertEquals(false, ll.isEmpty());
        ll.insertFront(2);
        assertEquals(false, ll.isEmpty());
        ll.insertFront(3);
        assertEquals(false, ll.isEmpty());
    }

    @Test
    void isEmptyAfterInsertRear() {
        assertEquals(true, ll.isEmpty());
        ll.insertBack(1);
        assertEquals(false, ll.isEmpty());
        ll.insertBack(2);
        assertEquals(false, ll.isEmpty());
        ll.insertBack(3);
        assertEquals(false, ll.isEmpty());
    }

    @Test
    void insertAtWhenEmpty() {
        ll.insertAt(10, 10);
        assertEquals(10, ll.getBack());
    }

    @Test
    void insertAtRear() {
        ll.insertBack(10);
        ll.insertBack(20);
        ll.insertAt(30, 2);
        assertEquals(30, ll.getBack());
    }

    @Test
    void insertAtFront() {
        ll.insertBack(10);
        ll.insertBack(20);
        ll.insertAt(30, 0);
        assertEquals(30, ll.getFront());
    }

    @Test
    void insertAtMiddle() {
        for (int i = 0; i < 10; i++) {
            ll.insertBack(i);
        }
        ll.insertAt(99, 5);
        assertEquals(11, ll.len());

        int i = 0;
        for (Integer val : ll) {
            if (i++ == 5) {
                assertEquals(99, val);
                break;
            }
        }
    }

    @Test
    void insertAtInvalidPosition() {
        for (int i = 0; i < 10; i++) {
            ll.insertBack(i);
        }
        ll.insertAt(99, 99);
        assertEquals(99, ll.getBack());
    }

    @Test
    void removeFront() {
        for (int i = 0; i < 10; i++) {
            ll.insertBack(i);
        }
        ll.removeFront();
        assertEquals(1, ll.getFront());
        assertEquals(9, ll.len());
    }

    @Test
    void removeBack() {
        for (int i = 0; i < 10; i++) {
            ll.insertBack(i);
        }
        ll.removeBack();
        assertEquals(8, ll.getBack());
        assertEquals(9, ll.len());
    }

    @Test
    void removeAtMiddle() {
        for (int i = 0; i < 10; i++) {
            ll.insertBack(i);
        }
        ll.removeAt(5);
        assertEquals(9, ll.len());
        int i = 0;
        for (Integer val : ll) {
            if (i++ == 5) {
                assertEquals(6, val);
                break;
            }
        }
    }

    @Test
    void fillAndRemoveFront() {
        for (int i = 0; i < 10; i++) {
            ll.insertBack(i);
        }
        for (int i = 0; i < 10; i++) {
            ll.removeFront();
        }
        assertEquals(true, ll.isEmpty());
        assertEquals(0, ll.len());
    }

    @Test
    void fillAndRemoveBack() {
        for (int i = 0; i < 10; i++) {
            ll.insertBack(i);
        }
        for (int i = 0; i < 10; i++) {
            ll.removeBack();
        }
        assertEquals(true, ll.isEmpty());
        assertEquals(0, ll.len());
    }

    @Test
    void fillAndRemoveFront2() {
        for (int i = 0; i < 10; i++) {
            ll.insertBack(i);
        }
        while (!ll.isEmpty()) {
            ll.removeFront();
        }
        assertEquals(0, ll.len());
    }

    @Test
    void fillAndRemoveBack2() {
        for (int i = 0; i < 10; i++) {
            ll.insertBack(i);
        }
        while (!ll.isEmpty()) {
            ll.removeBack();
        }
        assertEquals(0, ll.len());
    }

    @Test
    void fillAndRemoveFront3() {
        for (int i = 0; i < 10; i++) {
            ll.insertBack(i);
        }
        while (!ll.isEmpty()) {
            ll.removeFront();
        }
        assertEquals(0, ll.len());
        for (int i = 0; i < 10; i++) {
            ll.insertBack(i);
        }
        assertEquals(10, ll.len());
        assertEquals(0, ll.getFront());
        assertEquals(9, ll.getBack());
    }

    @Test
    void fillAndRemoveBack3() {
        for (int i = 0; i < 10; i++) {
            ll.insertBack(i);
        }
        while (!ll.isEmpty()) {
            ll.removeBack();
        }
        assertEquals(0, ll.len());
        for (int i = 0; i < 10; i++) {
            ll.insertBack(i);
        }
        assertEquals(10, ll.len());
        assertEquals(0, ll.getFront());
        assertEquals(9, ll.getBack());
    }

    @Test
    void removeAtInvalidPosition() {
        assertThrows(NoSuchElementException.class, () -> {
            ll.removeAt(10);
        });
    }

    @Test
    void removeAtInvalidPosition2() {
        for (int i = 0; i < 10; i++) {
            ll.insertBack(i);
        }
        assertThrows(NoSuchElementException.class, () -> {
            ll.removeAt(20);
        });
    }

    @Test
    void getAtInvalidPosition() {
        assertThrows(NoSuchElementException.class, () -> {
            ll.getAt(20);
        });
    }

    @Test
    void getAtInvalidPosition2() {
        for (int i = 0; i < 10; i++) {
            ll.insertBack(i);
        }
        assertThrows(NoSuchElementException.class, () -> {
            ll.getAt(20);
        });
    }

    @Test
    void getAt() {
        for (int i = 0; i < 10; i++) {
            ll.insertBack(i);
        }
        assertEquals(5, ll.getAt(5));
    }

    @Test
    void insertAtMultiple()
    {
        for (int i = 0; i < 10; i++) {
            ll.insertBack(i);
        }
        assertEquals(5,ll.getAt(5));
        ll.insertAt(99, 5);
        assertEquals(99,ll.getAt(5));
        assertEquals(11, ll.len());
        ll.insertAt(98, 5);
        assertEquals(98,ll.getAt(5));
        assertEquals(12, ll.len());
        ll.insertAt(97, 5);
        assertEquals(97,ll.getAt(5));
        assertEquals(13, ll.len());
    }

    @Test
    void removeAtMultiple()
    {
        for (int i = 0; i < 10; i++) {
            ll.insertBack(i);
        }
        assertEquals(5,ll.getAt(5));
        ll.removeAt(5);
        assertEquals(6,ll.getAt(5));
        assertEquals(9, ll.len());
        ll.removeAt(5);
        assertEquals(7,ll.getAt(5));
        assertEquals(8, ll.len());
        ll.removeAt(5);
        assertEquals(8,ll.getAt(5));
        assertEquals(7, ll.len());
    }

    @Test
    void print(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        String expectedOutput = "front -> 0 -> 1 -> 2 -> 3 -> 4 -> back\n";
        for (int i = 0; i < 5; i++) {
            ll.insertBack(i);
        }
        ll.print();
        assertEquals(expectedOutput, bos.toString());
        System.setOut(originalOut);
    }

    @Test
    void printReverse(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        String expectedOutput = "back -> 4 -> 3 -> 2 -> 1 -> 0 -> front\n";
        for (int i = 0; i < 5; i++) {
            ll.insertBack(i);
        }
        ll.printReverse();
        assertEquals(expectedOutput, bos.toString());
        System.setOut(originalOut);
    }

    @Test
    void printDataAt(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        String expectedOutput = "4\n";
        for (int i = 0; i < 5; i++) {
            ll.insertBack(i);
        }
        ll.printDataAt(4);
        assertEquals(expectedOutput, bos.toString());
        System.setOut(originalOut);
    }

    @Test
    void printDataAtInvalidPosition(){
        for (int i = 0; i < 5; i++) {
            ll.insertBack(i);
        }
        assertThrows(NoSuchElementException.class, () -> {
            ll.printDataAt(10);
        });
    }

    @Test
    void mixAndMatchInserts(){
        ll.insertBack(1);
        assertEquals(1, ll.getBack());
        assertEquals(1, ll.getFront());
        assertEquals(1, ll.len());

        ll.insertFront(2);
        assertEquals(1, ll.getBack());
        assertEquals(2, ll.getFront());
        assertEquals(2, ll.len());

        ll.insertAt(3, 0);
        assertEquals(1, ll.getBack());
        assertEquals(3, ll.getFront());
        assertEquals(3, ll.len());

        ll.insertBack(4);
        assertEquals(4, ll.getBack());
        assertEquals(3, ll.getFront());
        assertEquals(4, ll.len());

        ll.insertAt(5, 10);
        assertEquals(5, ll.getBack());
        assertEquals(3, ll.getFront());
        assertEquals(5, ll.len());
    }

    @Test
    void mixAndMatchRemovals(){
        for (int i = 0; i < 10; i++) {
            ll.insertBack(i);
        }
        assertEquals(10, ll.len());

        ll.removeBack();
        assertEquals(8, ll.getBack());
        assertEquals(9, ll.len());
        assertEquals(5, ll.getAt(5));

        ll.removeFront();
        assertEquals(1, ll.getFront());
        assertEquals(8, ll.getBack());
        assertEquals(8, ll.len());
        assertEquals(6, ll.getAt(5));

        ll.removeAt(5);
        assertEquals(1, ll.getFront());
        assertEquals(8, ll.getBack());
        assertEquals(7, ll.len());
        assertEquals(7, ll.getAt(5));

        ll.removeBack();
        assertEquals(7, ll.getBack());
        assertEquals(6, ll.len());
        assertEquals(7, ll.getAt(5));
    }

    @Test
    void mixAndMatchInsertAndRemovals(){
        ll.insertBack(1);
        assertEquals(1, ll.getBack());
        assertEquals(1, ll.getFront());
        assertEquals(1, ll.len());

        ll.insertFront(2);
        assertEquals(1, ll.getBack());
        assertEquals(2, ll.getFront());
        assertEquals(2, ll.len());

        ll.removeBack();
        assertEquals(2, ll.getBack());
        assertEquals(1, ll.len());
        assertEquals(2, ll.getAt(0));

        ll.insertAt(5, 10);
        assertEquals(5, ll.getBack());
        assertEquals(2, ll.getFront());
        assertEquals(2, ll.len());

        ll.removeBack();
        assertEquals(2, ll.getBack());
        assertEquals(1, ll.len());
        assertEquals(2, ll.getAt(0));

        ll.removeAt(0);
        assertEquals(0, ll.len());
        assertEquals(true, ll.isEmpty());
        assertThrows(NoSuchElementException.class, () -> {
            ll.getBack();
        });
        assertThrows(NoSuchElementException.class, () -> {
            ll.getFront();
        });
        assertThrows(NoSuchElementException.class, () -> {
            ll.getAt(0);
        });
    }
}
