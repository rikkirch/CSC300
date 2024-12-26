/******************************************************************************
 *
 * ================================
 * WARNING: DO NOT MODIFY THIS FILE
 * ================================
 *
 *****************************************************************************/
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        SymbolTable<String, Integer> st = new SymbolTable<>();
        while(!StdIn.isEmpty()){
            String key;
            int val;
            String cmd = StdIn.readString();
            switch(cmd){
                case "put":
                    key = StdIn.readString();
                    val = StdIn.readInt();
                    try {
                        st.put(key, val);
                    }
                    catch(Exception e){
                        StdOut.println(e.toString());
                    }
                    break;
                case "get":
                    key = StdIn.readString();
                    try {
                        StdOut.println(key + " = " + st.get(key));
                    }
                    catch(Exception e){
                        StdOut.println(e.toString());
                    }
                    break;
                case "del":
                    key = StdIn.readString();
                    try {
                        st.del(key);
                    }
                    catch(Exception e){
                        StdOut.println(e.toString());
                    }
                    break;
                case "contains":
                    key = StdIn.readString();
                    StdOut.println(st.contains(key));
                    break;
                case "size":
                    StdOut.println(st.size());
                    break;
                case "keys":
                    for(String k : st.keys()){
                        StdOut.println(k);
                    }
                    break;
                case "print":
                    for(String k : st.keys()){
                        StdOut.println(k + " = " + st.get(k));
                    }
                    break;
                case "check":
                    StdOut.println(st.check());
                    break;
                default:
                    StdOut.println("unknown command: " + cmd);
            }
        }
    }
}
