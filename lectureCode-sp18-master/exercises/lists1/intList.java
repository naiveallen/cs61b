public class intList{
	public int first;
	public intList rest;

	public intList(int first, intList rest){
		this.first = first;
		this.rest = rest;
	}

	// Return the size of the intList using recursion! 
	public int size(){
		if(this.rest == null){
			return 1;
		}
		return 1 + this.rest.size();
	}

	// Return the size of the intList using no recursion! 
	public int size(){
		int size = 0;
		intList p = this;
		while(p != null){
			size++;
			p = p.rest;
		}
		return size;
	}

	// Return the ith item of the intList using recursion! 
	public int get(int i){
		if(i == 0){
			return this.first;
		}
		return this.rest.get(i - 1);
	}

	// Return the ith item of the intList using no recursion! 
	public int get(int i){
		int item = 0;
		intList p = this;
		while(item < i){
			p = p.rest;
			item++;
		}
		return p.first;
	}

	/** Returns an IntList identical to L, but with
      * each element incremented by x. L is not allowed
      * to change. */
    public static intList incrList(intList L, int x) {
    	int size = L.size();
        intList Q = new intList(L.get(size - 1) + x, null);
        for(int i = size - 2; i >= 0; i--){   
        	Q = new intList(L.get(i) + x, Q);
        }
        return Q;        
    }

    /** Returns an IntList identical to L, but with
      * each element incremented by x. Not allowed to use
      * the 'new' keyword. */
    public static intList dincrList(intList L, int x) {
    	intList head = L;
    	while(L != null){
    		L.first += x;
    		L = L.rest;
    	}
        return head;
    }

	public static void main(String[] args) {
		intList L = new intList(15, null);
		L = new intList(10, L);
		L = new intList(5, L);
		//System.out.println(L.size());
		//System.out.println(L.get(0));
		
		intList Q = incrList(L, 3);
		for(int i = 0; i < Q.size(); i++){
			System.out.println(Q.get(i)); // Q: 8 -> 13 -> 18
		}
		for(int i = 0; i < L.size(); i++){
			System.out.println(L.get(i));  // L: 5 -> 10 -> 15
		}

		intList P = dincrList(L, 1);
		for(int i = 0; i < P.size(); i++){
			System.out.println(P.get(i));  // P: 6 -> 11 -> 16
		}
		for(int i = 0; i < L.size(); i++){
			System.out.println(L.get(i));  // L: 6 -> 11 -> 16
		}
	}
}