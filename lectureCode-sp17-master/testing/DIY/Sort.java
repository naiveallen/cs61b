public class Sort {
	/** Sorts strings destructively. */
	public static void sort(String[] x) {
		sort(x, 0);
	}

	private static void sort(String[] x, int start){
		if(start == x.length){
			return;
		}
		int smallIndex = findSmallst(x, start);
		swap(x, start, smallIndex);
		sort(x, start + 1);
	}

	private static int findSmallst(String[] x, int start){
		int smallIndex = start;
		for (int i = smallIndex; i < x.length; i++) {
			if(x[i].charAt(0) < x[smallIndex].charAt(0)){
				smallIndex = i;
			}
		}
		return smallIndex;
	}

	private static void swap(String[] x, int a, int b){
		String temp = x[a];
		x[a] = x[b];
		x[b] = temp;
	}


	/** Prints out all strings in x. */
	public static void print(String[] x) {
		for(String str : x){
			System.out.print(str + " ");
		}
	}

	/** Outputs the command line arguments
	 * in alphabetical order. */
	public static void main(String[] args) {
		sort(args);
		print(args);
	}
}