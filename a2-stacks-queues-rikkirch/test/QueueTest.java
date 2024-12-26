import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    Queue<Integer> q;

    @BeforeEach
    void setup(){
        q = new Queue<>();
    }

    @Test
    void push() {
        for(int i = 0; i < 1000; i++){
            q.push(i);
        }
    }

    @Test
    void pop() {
        for(int i = 0; i < 1000; i++){
            q.push(i);
        }
        for(int i = 0; i < 1000; i++){
            int v = q.pop();
            assertEquals(v, i);
        }
    }

    @Test
    void peek() {
        for(int i = 0; i < 1000; i++){
            q.push(i);
        }
        for(int i = 0; i < 1000; i++){
            int v = q.peek();
            q.pop();
            assertEquals(v, i);
        }
    }

    @Test
    void size() {
        for(int i = 1; i <= 10; i++){
            q.push(i);
            assertEquals(i, q.size());
        }
        for(int i = 10; i > 0; i--){
            assertEquals(i, q.size());
            q.pop();
        }
    }

    @Test
    void totalCapacity() {
        assertEquals(1, q.totalCapactiy());
        q.push(1);
        q.push(2);  // <--- doubles to 2
        assertEquals(2, q.totalCapactiy());
        q.push(3);  // <--- doubles to 4
        assertEquals(4, q.totalCapactiy());
        q.push(4);
        q.push(5);  // <--- doubles to 8
        assertEquals(8, q.totalCapactiy());
        while(q.size() != 16){ q.push(1); } // fill the array to a size of 8
        while(q.size() != 3){ q.pop(); }   // drop it to 25% capacity which should half the size of the array
        assertEquals(8, q.totalCapactiy());
    }

    @Test
    void isEmptyWhenEmpty() {
        assertEquals(true, q.isEmpty());
    }

    @Test
    void isEmptyWhenNotEmpty() {
        q.push(10);
        assertEquals(false, q.isEmpty());
    }

    @Test
    void isEmptyAfterEmptying() {
        for(int i = 0; i < 10; i++){
            q.push(i);
        }
        assertEquals(false, q.isEmpty());
        for(int i = 0; i < 10; i++){
            q.pop();
        }
        assertEquals(true, q.isEmpty());
    }

    @Test
    void popWhenEmpty(){
        assertThrows(NoSuchElementException.class, () -> {
            q.pop();
        });
    }

    @Test
    void popWhenEmpty2(){
        for(int i = 0; i < 100; i++){
            q.push(i);
        }
        while(!q.isEmpty()){
            q.pop();
        }
        assertThrows(NoSuchElementException.class, () -> {
            q.pop();
        });
    }

    @Test
    void peekWhenEmpty(){
        assertThrows(NoSuchElementException.class, () -> {
            q.peek();
        });
    }

    @Test
    void peekWhenEmpty2(){
        for(int i = 0; i < 100; i++){
            q.push(i);
        }
        while(!q.isEmpty()){
            q.pop();
        }
        assertThrows(NoSuchElementException.class, () -> {
            q.peek();
        });
    }

    @Test
    void checkArraySizeAfterEmptying(){
        for(int i = 0; i < 100; i++){
            q.push(i);
        }
        while(!q.isEmpty()){
            q.pop();
        }
        assertEquals(2, q.totalCapactiy());
    }

    @Test
    void walkFrontAndBack(){
        for(int i = 0; i < 9; i++){
            q.push(i);
        }

        // after 9 pushes the array should be of size 16
        assertEquals(16, q.totalCapactiy());

        // alternate between pushing and popping, the array size should not change as there will always be open slots.
        // the front and back of the queue should walk towards the end of the array and then wrap back around to the
        // front
        for(int i = 0; i < 10000; i++){
            if(i%2 == 0) q.pop();
            else q.push(i);
        }

        // double check that the array wasn't resized
        assertEquals(16, q.totalCapactiy());
    }

    @Test
    void testPeekAfterResize(){
        // fill up an entire array of size 8
        for(int i = 0; i < 8; i++){
            q.push(i);
        }

        assertEquals(0, q.peek());

        // force the array resize by pushing a new element
        q.push(9);
        assertEquals(16, q.totalCapactiy());

        // make sure that front is still the same
        assertEquals(0, q.peek());
    }

    @Test
    void testPopAfterResize(){
        // generate an array of size 16
        for(int i = 0; i < 9; i++){
            q.push(i);
        }

        assertEquals(16, q.totalCapactiy());
        assertEquals(0, q.pop());

        // make sure that the pop didn't resize the array
        assertEquals(16, q.totalCapactiy());
    }

    @Test
    void largeDataTest(){
        for(int i = 0; i < Integer.MAX_VALUE / 50; i++){
            q.push(i);
        }
        assertEquals(0, q.peek());
    }
}
