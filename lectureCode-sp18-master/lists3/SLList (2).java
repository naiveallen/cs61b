public class SLList<Type>{
	private class stuffNode{
		public Type item;
		public stuffNode next;

		public stuffNode(Type item, stuffNode next){
			this.item = item;
			this.next = next;
		}
	}
	private stuffNode sentinel;  // set a sentinel node, to let a empty list and a non-empty list have a same structure. let the addLast method common 
	private int size;

	public SLList(){
		sentinel = new stuffNode(null, null);
		size = 0;
	}

	public SLList(Type x){
		sentinel = new stuffNode(null, null);
		sentinel.next = new stuffNode(x, null);
		size = 1;
	}

	public void addFirst(Type x){
		sentinel.next = new stuffNode(x, sentinel.next);
		size++;
	}

	public Type getFirst(){
		return sentinel.next.item;
	}

	public void addLast(Type x){
		stuffNode p = sentinel;     // Very important! Can not implement the first directly! 
		while(p.next != null){
			p = p.next;
		}
		p.next = new stuffNode(x, null);
		size++;
	}

	// private static int size(stuffNode p){    // helper method
	// 	if (p.next == null) {
	// 		return 1;
	// 	}
	// 	return 1 + size(p.next);
	// }
	public int size(){
		return size;
	}
	// public int size(){
	// 	int size = 0;  
	// 	stuffNode p = first;    // Very important! Can not implement the first directly! 
	// 	while(p != null){
	// 		p = p.next;
	// 		size++;
	// 	}
	// 	return size;
	// }

	public static void main(String[] args) {
		SLList<String> L = new SLList();
		L.addFirst("Hi");
		L.addFirst("yuanye");
		System.out.println(L.getFirst());
		//L.addLast(20);
		L.addLast("25");
		System.out.println(L.size());
	}
} 