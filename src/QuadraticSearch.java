
public class QuadraticSearch {

	public static void main(String[] args) {
		int[] data = new int[5];
		data[0] = 1;
		data[1] = 3;
		data[2] = 4;
		data[3] = 8;
		data[4] = 13;
		
		System.out.println("search 5: " + quadraticSearch(data, 5));
		System.out.println("search 13: " + quadraticSearch(data, 13));
		System.out.println("search 22: " + quadraticSearch(data, 22));		
	}

	public static int quadraticSearch(int[] data, int num) {
		final int FOUND = 0, ABSENT = 1, SEARCHING = 2, CLOSE_ENOUGH = 3;
		int state = SEARCHING, position = 0, jumpSize;
		jumpSize = (int) (Math.sqrt(data.length));
		
		do {
			if( (position + jumpSize) >= data.length ) {
				state = CLOSE_ENOUGH;
			} else if ( (data[position + jumpSize]) > num ) {
				state = CLOSE_ENOUGH;
			} else {
				position += jumpSize;
			}
		} while(state != CLOSE_ENOUGH);
		
		state = SEARCHING;
		do {
			if(position >= data.length) {
				state = ABSENT;
			} else if (data[position] > num) {
				state = ABSENT;
			} else if (data[position] == num) {
				state =  FOUND;
			} else {
				position++;
			}
		} while (state == SEARCHING);
		
		if(state == ABSENT) {
			return -1;
		} else {
			return position;
		}
	}
}
