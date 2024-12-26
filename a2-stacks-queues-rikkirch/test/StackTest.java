import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    Stack<Integer> s;

    @BeforeEach
    void setup(){
        s = new Stack<>();
    }

    @Test
    void push() {
        for(int i = 0; i < 1000; i++){
            s.push(i);
        }
        assertEquals(999, s.pop());
    }

    @Test
    void pop() {
        for(int i = 0; i < 1000; i++){
            s.push(i);
        }
        for(int i = 999; i > 0; i--){
            int val = s.pop();
            assertEquals(i, val);
        }
    }

    @Test
    void peek() {
        for(int i = 0; i <= 1000; i++){
            s.push(i);
        }
        for(int i = 1000; i > 0; i--){
            int v = s.peek();
            s.pop();
            assertEquals(v, i);
        }
    }

    @Test
    void size() {
        for(int i = 0; i <= 9; i++){
            assertEquals(i, s.size());
            s.push(i);
        }

        for(int i = 10; i > 0; i--){
            assertEquals(i, s.size());
            s.pop();
        }

        for(int i = 0; i < 10; i++){
            assertEquals(i, s.size());
            s.push(i);
        }

    }

    @Test
    void isEmptyWhenEmpty() {
        assertEquals(true, s.isEmpty());
    }

    @Test
    void isEmptyWhenNotEmpty() {
        s.push(1);
        assertEquals(false, s.isEmpty());
    }

    @Test
    void isEmptyAfterFillingAndRemoving(){
        for(int i = 0; i < 10; i++){
            s.push(i);
        }
        assertEquals(false, s.isEmpty());
        for(int i = 0; i < 10; i++){
            s.pop();
        }
        assertEquals(true, s.isEmpty());
    }

    @Test
    void isEmptyAfterFillingRemovingAndRefilling(){
        for(int i = 0; i < 10; i++){
            s.push(i);
        }
        assertEquals(false, s.isEmpty());
        for(int i = 0; i < 10; i++){
            s.pop();
        }
        assertEquals(true, s.isEmpty());
        for(int i = 0; i < 10; i++){
            s.push(i);
        }
        assertEquals(false, s.isEmpty());
    }

    @Test
    void popWhenEmpty(){
        assertThrows(NoSuchElementException.class, () -> {
            s.pop();
        });
    }

    @Test
    void peekWhenEmpty(){
        assertThrows(NoSuchElementException.class, () -> {
            s.peek();
        });
    }

    @Test
    void testMultiplePeeks(){
        for(int i = 0; i < 10; i++){
            s.push(i);
        }
        assertEquals(9, s.peek());
        assertEquals(9, s.peek());
        assertEquals(9, s.peek());
        s.pop();
        assertEquals(8, s.peek());
        assertEquals(8, s.peek());
        assertEquals(8, s.peek());
    }

    @Test
    void largeDataTest(){
        for(int i = 0; i < 10000; i++){
            s.push(i);
        }
        assertEquals(9999, s.peek());
    }

    @Test
    void largeDataTest2(){
        for(int i = 0; i < 10000; i++){
            s.push(i);
        }
        assertEquals(9999, s.peek());
        assertEquals(10000, s.size());

        for(int i = 9999; !s.isEmpty(); i--){
            assertEquals(i, s.pop());
        }
        assertEquals(0, s.size());
        assertEquals(true, s.isEmpty());

    }
}
