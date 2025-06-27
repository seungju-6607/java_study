package chapter05;

/*
 [시작]
 *
 **
 ***
 ****
 *****
 [종료]
 */
public class ForOverlabStarTest {

	public static void main(String[] args) {
		System.out.println("[시작]");
		for(int k = 1; k <= 5; k++) {
		   for(int j = 1; j<=5; j++)
	    if(k >= j)
		   System.out.print("*");
		   System.out.println();
		}
		System.out.println("[종료]");

	}

}
