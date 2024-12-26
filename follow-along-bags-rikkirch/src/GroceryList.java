import edu.princeton.cs.algs4.StdOut;

public class GroceryList {
    private static class Item {
        String name;
        boolean purchased;
        public Item(String name){
            this.name = name;
            this.purchased = false;
        }
    }

    Bag<Item> bag;

    public GroceryList(){
        bag = new Bag<>();
    }

    public void add(String name){
        Item item = new Item(name);
        bag.add(item);
    }

    public void bought(String name){
        for(Item i : bag){
            if(i.name.equals(name)){
               i.purchased = true;
               break;
            }
        }
    }

    public void print(){
        StdOut.print("List\n------\n");
        for(Item i : bag){
            StdOut.print("[");
            if(i.purchased){
                StdOut.print("X");
            }
            else{
                StdOut.print(" ");
            }
            StdOut.printf("] %s\n", i.name);
        }
    }
}
