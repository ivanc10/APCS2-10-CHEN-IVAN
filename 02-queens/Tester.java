public class Tester {
	public static void main(String[] args) {
		// QueenBoard x = new QueenBoard(5);
		// for (int i=0; i<5; i++) {
		// 	System.out.println(x + "\n");
		// 	x.addQueen(i, (i+2)%5);
		// }
		// System.out.println(x);
		// System.out.println("Function Call: x.removeQueen(0,2)");
		// x.removeQueen(0,2);
		// System.out.println(x);
		
		QueenBoard test = new QueenBoard(8);

		test.solve(0, 0);
		System.out.println(test);
	}
}