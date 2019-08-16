
public class Exam3 {
	public static void main(String[] args) {
		int source = 100; // =: 대입 연산자
		System.out.println("source= " + source);
		
		source = source + 100; // 200
		System.out.println("source= " + source);
		
		source += 100; // 300
		System.out.println("source= " + source);
		
		source = source - 50; // 250
		System.out.println("source= " + source);
		
		source -= 50; // 200
		System.out.println("source= " + source);

		source *= 2; // 400
		System.out.println("source= " + source);
		
		source /= 100; // 4
		System.out.println("source= "+ source);
		
		source %= 2; // 0
		System.out.println("source= "+ source);
	}
}
