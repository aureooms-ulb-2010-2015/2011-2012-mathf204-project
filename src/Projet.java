public class Projet {
	
	public static void main(String [] args){
		int j = 0;
		while (j<10){
			int i = 0;
			int successes = 0;
			while (i<1000000){
				Snake snake = new Snake();
				if(snake.success(23)){
					successes++;
				}
				i++;
			}
			float delta = (float)(0.1376-successes/(i*1.0));
			System.out.println(delta+", "+successes/(i*1.0));
			j++;
		}
	}
}
