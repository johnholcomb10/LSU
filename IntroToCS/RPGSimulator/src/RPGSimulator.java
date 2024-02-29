import java.util.Scanner;
import java.util.Random;

public class RPGSimulator {

	public static void main(String[] args) {
		
		Scanner playerInput = new Scanner(System.in);
		Random rand = new Random();
		int playerHP = 100;
		int playerMP = 50;
		int goblinHP = 80;
		int empower = 0;
		int damage;
		boolean gameOver = false;
		System.out.println("Start fight!");
		do {
			boolean playerTurn = true;
			
			while(playerTurn == true) {
				System.out.printf("Player HP: %d/100, MP: %d/50\nGoblin HP: %d/80\nWhat is your next move?:\nAttack\nFireball(costs 12 MP)\nHeal (costs 8 MP)\nEmpower (costs 6 MP)\nFlee\n", playerHP, playerMP, goblinHP);
				String playerMove = playerInput.nextLine().toLowerCase();	
				if(playerMove.equals("flee")) {
					System.out.println("You fled the encounter! Game over.");
					playerInput.close();
					return;
				} else if(playerMove.equals("attack")) {
					int chanceHitting = rand.nextInt(100);
					if (chanceHitting > 19) {
						damage = (rand.nextInt(6+empower)+(5+empower));
						goblinHP -= damage;
						System.out.printf("Player used Attack! It did %d damage to the goblin!\n", damage);
						playerTurn = false;
					} else {
						System.out.println("Player used Attack! The attack missed the goblin and did no damage!");
						playerTurn = false;
					}
				} else if(playerMove.equals("fireball")) {
					if(playerMP < 12) {
						System.out.println("Fireball requires 12 MP! Pick new action!");
					} else {
						playerMP -= 12;
						damage = rand.nextInt(6+empower)+(10+empower);
						goblinHP -= damage;
						System.out.printf("Player used Fireball! It did %d damage to the goblin!\n", damage);
						playerTurn = false;
					}
				} else if(playerMove.equals("heal")) {
					if(playerMP < 8) {
						System.out.println("Heal requires 8 MP! Pick new action!");
					} else {
						playerMP -= 8;
						int playerHeal = (rand.nextInt(11+empower)+(15+empower));
						playerHP += playerHeal;
						System.out.printf("Player used Heal! Player HP has increased by %d to %d.\n", playerHeal, playerHP);
						playerTurn = false;
					}
				} else if(playerMove.equals("empower")) {
					if(playerMP < 6) {
						System.out.println("Empower requires 6 MP! Pick new action!");
					} else {
						playerMP -= 6;
						empower++;
						System.out.printf("Player used Empower. Empower multiplier is now %d.\n", empower);
						playerTurn = false;
					}
				} else {
					System.out.println("Input unrecognized! Try again.");
				}
			}
			if(goblinHP <= 0) {
				System.out.println("The Goblin died! You win!");
				gameOver = true;
			} else {
				int i;
				int goblinAttacks = 0;
				int goblinDamage = 0;
				for(i=0; i<2; i++) {
					int goblinChance = rand.nextInt(100);
					if(goblinChance > 49) {
						goblinDamage += rand.nextInt(5)+8;
						goblinAttacks++;
					}
				}
				playerHP -= goblinDamage;
				System.out.printf("Goblin attacked Player! He hit Player %d times for %d damage!\n", goblinAttacks, goblinDamage);
			}
			
			if(playerHP <= 0) {
				System.out.println("You died! Game over.");
				gameOver = true;
			}
	}while(gameOver == false);
		
	playerInput.close();
	return;
	}
	
}
