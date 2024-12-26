import java.lang.reflect.Array;
import java.util.Iterator;

	public class Bag<T> implements IBag<T> {
GenericList<T> list;

public Bag(){
this.list  = new GenericList<>();
}


		public void add(T item){ 
list.addToBack(item);
}

		public boolean isEmpty(){
return list.isEmpty();

}
		public int size(){
return list.size(();
}

public Iterator<T> iterator(){
	return list.iterator();
}

}


