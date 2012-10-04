package exercise3;



public class run {

	public static void main(String[] args) {
		LocalSearchEggCarton eggPuzzle= new LocalSearchEggCarton(10, 10, 3, 100000000);
		System.out.println("Det er mulig å plasere " + eggPuzzle.startLocalSearch()+ " brikker på brettet");
	}
}
