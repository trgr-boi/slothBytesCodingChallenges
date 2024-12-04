import java.util.Arrays;

public class RgbInverse {
	public static void main(String[] args) {
		
//		>---------->Test Cases<----------<
//		int[] color = {255, 255, 255};
//		int[] color = {0, 0, 0};
		int[] color = {165, 170, 221};
//		>--------------------------------<
		
		System.out.printf("color_invert(%s)%n", Arrays.toString(color));
		for (int i = 0; i < 3; i++) color[i] = 255 - color[i];
		System.out.printf("output = %s", Arrays.toString(color));

	}
}
