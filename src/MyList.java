import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MyList<T>{
	private T[] arr;
	private int size;
	
	@SuppressWarnings("unchecked")
	public MyList(){
		arr = (T[]) new Object[0];
		size = 0;
	}
	
	public T[] toArray() {
		return arr;
	}
	
	public List<T> toList(){
		List<T> listToReturn = new ArrayList<>();
		this.forEach(x -> listToReturn.add(x));
		return listToReturn;
	}
	
	public void add(T element) {
		if(arr.length < ++size) {
			arr = Arrays.copyOf(arr, size);
		}
		arr[size - 1] = element;
	}
	
	public void remove(int index) {
		MyList<T> listToConvert = new MyList<>();
		for(int i = 0; i < arr.length; i++) {
			if(i != index) {
				listToConvert.add(arr[i]);
			}
		}
		arr = listToConvert.toArray();
	}
	
	public T get(int index) {
		try {
			return arr[index];			
		}catch(ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public void clear() {
		arr = (T[]) new Object[0];
		size = 0;
	}
	
	public boolean containsAll(MyList<T> list) {
		return this.equals(list);
	}
	
	public void addAll(MyList<T> list) {
		list.forEach(x -> this.add(x));
	}
	
	public MyList<T> map(Coordinates<T> coords) {
		MyList<T> tempList = new MyList<>();
		for(T t : arr) {
			tempList.add(coords.apply(t));
		}
		return tempList;
	}
	
	public MyList<T> returnSorted() {
		MyList<T> listToReturn = new MyList<T>();
		listToReturn.addAll(this); listToReturn.sorted();
		return listToReturn;
	}
	
	public MyList<T> returnSorted(boolean positive) {
		MyList<T> listToReturn = new MyList<T>();
		if(positive) {
			listToReturn.addAll(this); listToReturn.sorted();
		}else {
			listToReturn.addAll(this); listToReturn.sorted(false);
		}
		return listToReturn;
	}
	
	public void sorted() {
		Comparator<T> comp;
		T t = arr[0];
		if(t instanceof String) {
			comp = (x, y) -> {
				if(x.toString().length() > y.toString().length()) {return 1;} 
				else{return -1;}
			};
		}else {
			comp = (x, y) -> {if((int)x > (int)y) {return 1;} else{return -1;}};
		}
		Arrays.sort(arr, comp);
	}
	
	public void sorted(boolean positive) {
		Comparator<T> comp;
		T t = arr[0];
		if(positive) {
			if(t instanceof String) {
				comp = (x, y) -> {
					if(x.toString().length() > y.toString().length()) {return 1;} 
					else{return -1;}
				};
			}else {
				comp = (x, y) -> {if((int)x > (int)y) {return 1;} else{return -1;}};
			}
		}else {
			if(t instanceof String) {
				comp = (x, y) -> {
					if(x.toString().length() > y.toString().length()) {return -1;} 
					else{return 1;}
				};
			}else {
				comp = (x, y) -> {if((int)x > (int)y) {return -1;} else{return 1;}};
			}
		}
		
		Arrays.sort(arr, comp);
	}
	
	public MyList<T> filter(Checker<T> isTrue) {
		MyList<T> tempList = new MyList<>();
		for(T t : arr) {
			if(isTrue.check(t)){
				tempList.add(t);
			}
		}
		return tempList;
	}
	
	public void forEach(Supplier<T> supplier) {
		for(T t : arr) {
			supplier.supply(t);
		}
	}

	@Override
	public String toString() {
		return Arrays.toString(arr);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(arr);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("unchecked")
		MyList<T> other = (MyList<T>) obj;
		return Arrays.deepEquals(arr, other.arr);
	}
}
