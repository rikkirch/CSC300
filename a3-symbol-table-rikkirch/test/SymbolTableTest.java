import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SymbolTableTest {

    SymbolTable<String, Integer> st;

    @BeforeEach
    void init(){
        st = new SymbolTable<>();
    }

    @Test
    void put(){
        st.put("f", 1);
        assertTrue(st.contains("f"));
        assertEquals(1, st.get("f"));
        assertTrue(st.check());

        st.put("a", 2);
        assertTrue(st.contains("a"));
        assertEquals(2, st.get("a"));
        assertTrue(st.check());

        st.put("z", 3);
        assertTrue(st.contains("z"));
        assertEquals(3, st.get("z"));
        assertTrue(st.check());

        assertTrue(st.contains("a"));
        assertTrue(st.contains("f"));
        assertTrue(st.check());
    }

    @Test
    void putNoValue(){
        assertThrows(InvalidParameterException.class, () -> st.put("a", null));
    }

    @Test
    void putDuplicate(){
        st.put("a", 1);
        assertTrue(st.check());
        assertThrows(InvalidParameterException.class, () -> {
            st.put("a", 1);
        });
    }

    @Test
    void putNoKey(){
        assertThrows(InvalidParameterException.class, () -> st.put(null, 1));
    }

    @Test
    void putAfterRemoval(){
        st.put("f", 1);
        assertTrue(st.contains("f"));
        assertEquals(1, st.get("f"));
        assertTrue(st.check());

        st.put("a", 2);
        assertTrue(st.contains("a"));
        assertEquals(2, st.get("a"));
        assertTrue(st.check());


        st.del("f");
        assertFalse(st.contains("f"));
        assertThrows(NoSuchElementException.class, () -> {
            st.get("f");
        });
        assertTrue(st.check());

        st.put("b", 5);
        assertTrue(st.contains("b"));
        assertEquals(5, st.get("b"));
        assertTrue(st.check());

    }

    @Test
    void getWhenEmpty() {
        assertThrows(NoSuchElementException.class, () -> {
            st.get("f");
        });
    }

    @Test
    void getAfterRemoval() {
        st.put("a", 1);
        st.put("b", 2);
        st.put("c", 3);
        assertTrue(st.check());

        st.del("a");
        assertThrows(NoSuchElementException.class, () -> {
            st.get("a");
        });
        assertTrue(st.check());

        assertEquals(2, st.get("b"));
        assertEquals(3, st.get("c"));
    }

    @Test
    void getWithNoKey(){
        assertThrows(InvalidParameterException.class, () -> {
            st.get(null);
        });
    }

    @Test
    void getAfterRemovalAndReinserted(){
        st.put("a", 1);
        st.put("b", 2);
        st.put("c", 3);
        assertTrue(st.check());

        st.del("a");
        assertThrows(NoSuchElementException.class, () -> {
            st.get("a");
        });
        assertTrue(st.check());

        assertEquals(2, st.get("b"));
        assertEquals(3, st.get("c"));

        st.put("a", 1);
        assertTrue(st.check());
        assertEquals(1, st.get("a"));
    }

    @Test
    void delKeyDoesntExist(){
        assertThrows(NoSuchElementException.class, () -> st.del("foo"));
    }

    @Test
    void delNoKey(){
        assertThrows(InvalidParameterException.class, () -> st.del(null));
    }

    @Test
    void delOneChildCase(){
        st.put("f", 1);
        st.put("c", 2);
        st.put("a", 3);
        assertTrue(st.check());
        st.del("c");
        assertTrue(st.check());
        assertThrows(NoSuchElementException.class, () -> st.del("c"));
    }

    @Test
    void delTwoChildCase(){
        st.put("f", 1);
        st.put("b", 2);
        st.put("a", 3);
        st.put("c", 4);
        assertTrue(st.check());
        st.del("b");
        assertTrue(st.check());
        assertThrows(NoSuchElementException.class, () -> st.del("b"));
    }

    @Test
    void delNoChildCase(){
        st.put("f", 1);
        st.put("b", 2);
        assertTrue(st.check());
        st.del("b");
        assertTrue(st.check());
        assertThrows(NoSuchElementException.class, () -> st.del("b"));
    }

    @Test
    void delRoot(){
        st.put("f", 1);
        st.put("b", 2);
        st.put("a", 3);
        st.put("c", 4);
        assertTrue(st.check());
        st.del("f");
        assertTrue(st.check());
        assertThrows(NoSuchElementException.class, () -> st.del("f"));
    }

    @Test
    void delAll(){
        st.put("f", 1);
        st.put("b", 2);
        st.put("a", 3);
        st.put("c", 4);
        for(String k : st.keys()){
            st.del(k);
            assertTrue(st.check());
            assertThrows(NoSuchElementException.class, () -> st.del(k));
        }
        assertTrue(st.isEmpty());
    }

    @Test
    void dellAllAndRefill(){
        st.put("f", 1);
        st.put("b", 2);
        st.put("a", 3);
        st.put("c", 4);
        for(String k : st.keys()){
            st.del(k);
            assertTrue(st.check());
            assertThrows(NoSuchElementException.class, () -> st.del(k));
        }
        assertTrue(st.isEmpty());
        st.put("f", 1);
        st.put("b", 2);
        st.put("a", 3);
        st.put("c", 4);
        assertTrue(st.check());
        assertFalse(st.isEmpty());
        for(String k : st.keys()){
            assertTrue(st.contains(k));
        }
    }

    @Test
    void contains() {
        st.put("f", 1);
        assertTrue(st.contains("f"));
    }

    @Test
    void containsNoKey(){
        assertThrows(InvalidParameterException.class, () -> st.contains(null));
    }

    @Test
    void containsKeyNotInTable(){
        assertFalse(st.contains("stuff"));
    }

    @Test
    void isEmpty() {
        assertTrue(st.isEmpty());
    }

    @Test
    void isEmptyWhenHasData() {
        st.put("f", 1);
        st.put("b", 2);
        st.put("a", 3);
        st.put("c", 4);
        assertFalse(st.isEmpty());
    }

    @Test
    void isEmptyAfterRemoveAll() {
        st.put("f", 1);
        st.put("b", 2);
        st.put("a", 3);
        st.put("c", 4);
        for(String k : st.keys()){
            st.del(k);
            assertTrue(st.check());
            assertThrows(NoSuchElementException.class, () -> st.del(k));
        }
        assertTrue(st.isEmpty());
    }

    @Test
    void isEmptyAfterRemoveAllAndRefill() {
        st.put("f", 1);
        st.put("b", 2);
        st.put("a", 3);
        st.put("c", 4);
        for(String k : st.keys()){
            st.del(k);
            assertTrue(st.check());
            assertThrows(NoSuchElementException.class, () -> st.del(k));
        }
        assertTrue(st.isEmpty());
        st.put("f", 1);
        st.put("b", 2);
        st.put("a", 3);
        st.put("c", 4);
        assertTrue(st.check());
        assertFalse(st.isEmpty());
        for(String k : st.keys()){
            assertTrue(st.contains(k));
        }
        assertFalse(st.isEmpty());
    }

    @Test
    void size() {
        assertEquals(0, st.size());
        st.put("f", 1);
        st.put("b", 2);
        st.put("a", 3);
        st.put("c", 4);
        assertEquals(4, st.size());
    }

    @Test
    void sizeAfterEmptying(){
        st.put("f", 1);
        st.put("b", 2);
        st.put("a", 3);
        st.put("c", 4);
        for(String k : st.keys()){
            st.del(k);
            assertTrue(st.check());
            assertThrows(NoSuchElementException.class, () -> st.del(k));
        }
        assertTrue(st.isEmpty());
        assertEquals(0, st.size());
    }

    @Test
    void sizeAfterEmptyingAndRefilling(){
        st.put("f", 1);
        st.put("b", 2);
        st.put("a", 3);
        st.put("c", 4);
        for(String k : st.keys()){
            st.del(k);
            assertTrue(st.check());
            assertThrows(NoSuchElementException.class, () -> st.del(k));
        }
        assertTrue(st.isEmpty());
        st.put("f", 1);
        st.put("b", 2);
        st.put("a", 3);
        st.put("c", 4);
        assertTrue(st.check());
        assertFalse(st.isEmpty());
        for(String k : st.keys()){
            assertTrue(st.contains(k));
        }
        assertFalse(st.isEmpty());
        assertEquals(4, st.size());
    }

    @Test
    void keys() {
        String[] insertionOrder = new String[] { "j", "e", "p", "c", "s", "a", "z"};
        String[] inOrder = new String[]        { "a", "c", "e", "j", "p", "s", "z"};

        int i = 0;
        for(String k : insertionOrder){
            st.put(k, i++);
        }

        i = 0;
        for(String k : st.keys()){
            assertEquals(inOrder[i++], k);
        }
    }

    @Test
    void keysAfterRemoving(){
        String[] insertionOrder = new String[] { "j", "e", "p", "c", "s", "a", "z"};

        int i = 0;
        for(String k : insertionOrder){
            st.put(k, i++);
        }
        for(String k : st.keys()){
            st.del(k);
        }
        LinkedList<String> keys = st.keys();
        assertEquals(0, keys.size());
    }

    @Test
    void keysAfterRemovingAndRefilling(){
        String[] insertionOrder = new String[] { "j", "e", "p", "c", "s", "a", "z"};
        String[] inOrder = new String[]        { "a", "c", "e", "j", "p", "s", "z"};

        int i = 0;
        for(String k : insertionOrder){
            StdOut.println("putting " + k);
            st.put(k, i++);
        }

        i = 0;
        for(String k : st.keys()){
            assertEquals(inOrder[i++], k);
            st.del(k);
        }

        i = 0;
        for(String k : insertionOrder){
            st.put(k, i++);
        }

        i = 0;
        for(String k : st.keys()){
            assertEquals(inOrder[i++], k);
        }
    }
}
