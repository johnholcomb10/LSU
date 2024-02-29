
public class looping {

		public static void main(String[] args) {
			short num_investors = 12;
			int num_years = 0;
			
			while(num_investors < 30000) {
				num_investors *= 2;
				num_years++;
				num_investors += (37281 % num_years);
				
			}
			
		num_years++;
		System.out.println("[*]My million dollar fortune will be complete in: " + num_years + " years! In fact I'll have " + num_investors + " investors by then!");
		
		}
}
