/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author josea
 */
import java.util.Random;
import java.util.Scanner;

class Colors {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
}

class Abilities {
    int skill1;
    int skill2;
    int skill3;

    Abilities(int skill1, int skill2, int skill3) {
        this.skill1 = skill1;
        this.skill2 = skill2;
        this.skill3 = skill3;
    }
}


public class GameMechanics {
    public void startGame() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        Colors color = new Colors();
        int chooseChar = 0;
        int choice = 0;
        CharInfo getChar = new CharInfo();
        boolean isChar = false;
        Characters mainChar = new Characters(0, 0, 0);
        
        OUTER:
        do {
            System.out.println("1. Fighter\n2. Wizard\n3. Tank\n4. Healer");
            System.out.println("Choose character: ");
            chooseChar = scanner.nextInt();
            switch (chooseChar) {
                case 1:
                    {
                        mainChar = getChar.getFirstChar();
                        System.out.println("You've Chosen Kent The Fighter!");
                        isChar = true;
                        break OUTER;
                    }
                case 2:
                    {
                        mainChar = getChar.getSecondChar();
                        System.out.println("You've Chosen Cedi The Wizard!");
                        isChar = true;
                        break OUTER;
                    }
                case 3:
                    {
                        mainChar = getChar.getThirdChar();
                        System.out.println("You've Chosen Axille The Tank!");
                        isChar = true;
                        break OUTER;
                    }
                default:
                    System.out.println("Invalid!");
                    break;
            }
        } while (!isChar);
        
        int bossHp = 100;

        while (mainChar.hp > 0) {
            if (bossHp <= 0) {
                System.out.println(color.GREEN + "YOU WON!" + color.RESET);
                break;
            }

            if (mainChar.hp <= 0 || mainChar.stamina <= 0) {
                System.out.println(color.RED + "You lost" + color.RESET);
                System.out.println(color.MAGENTA + "...And they chose you to play the hero..." + color.RESET);
                break;
            }
            
            if (mainChar.stamina <= 40) {
                System.out.println(color.RED + "WARNING: you have low Stamina!" + color.RESET);
            }
            if(mainChar.hp <= 40) {
                System.out.println(color.RED + "WARNING: you have low Health!" + color.RESET);
            } 

            if(mainChar.hp <= 40) {
                System.out.print(color.RED + "\nCharacter health: " + mainChar.hp + color.RESET);
            } else {
                System.out.print("\nCharacter health: " + mainChar.hp);
            }
            if(mainChar.stamina > 40) {
                System.out.println("\nCharacter Stamina: " + mainChar.stamina);
            } else {
                System.out.println(color.RED + "\nCharacter Stamina: " + mainChar.stamina + color.RESET);
            }
            System.out.print("Enter skill (1, 2, 3): ");
            choice = scanner.nextInt(); 

            if (choice < 1 || choice > 3) {
                System.out.println("\nCharacter does not have that skill!");
                continue;
            }

            int min, max;

            if (choice == 1) {
                if(mainChar.stamina < 10) {
                    System.out.print(color.RED + "Not enough Stamina!\n" + color.RESET);
                    continue;
                }
                min = (int) Math.floor(mainChar.abilities.skill1 * 0.8);
                max = (int) Math.ceil(mainChar.abilities.skill1 * 1.2);
                mainChar.stamina -= 10;
            } else if (choice == 2) {
                if(mainChar.stamina < 15) {
                    System.out.print(color.RED + "Not enough Stamina!\n" + color.RESET);
                    continue;
                }
                min = (int) Math.floor(mainChar.abilities.skill2 * 0.8);
                max = (int) Math.ceil(mainChar.abilities.skill2 * 1.2);
                mainChar.stamina -= 15;
            } else if (choice == 3) {
                if(mainChar.stamina < 20) {
                    System.out.print(color.RED + "Not enough Stamina!\n" + color.RESET);
                    continue;
                }
                min = (int) Math.floor(mainChar.abilities.skill3 * 0.8);
                max = (int) Math.ceil(mainChar.abilities.skill3 * 1.2);
                mainChar.stamina -= 20;
            } else {
                System.out.println(color.YELLOW + "\nCharacter does not have that skill!" + color.RESET);
                continue;
            }

            mainChar.attack = random.nextInt(max - min + 1) + min;

            int randomNumber = random.nextInt(10 - 0 + 1) + 0;
            if (randomNumber > 7) {
                System.out.println(color.RED + "\nAttack miss\nBoss hp: " + bossHp + color.RESET);
            } else {
                bossHp -= mainChar.attack;
                System.out.print(color.GREEN);
                System.out.printf("\nAttack hit, damaged %d to Boss. Boss hp: %d%n", mainChar.attack, bossHp);
                System.out.print(color.RESET);
                if(mainChar.stamina > 40) {
                    System.out.print(color.GREEN);
                    System.out.printf("Character's Stamina: %d\n", mainChar.stamina);
                    System.out.print(color.RESET);
                } else {
                    System.out.print(color.RED);
                    System.out.printf("Character's Stamina: %d\n", mainChar.stamina);
                    System.out.print(color.RESET);
                }

                if (bossHp <= 0) {
                    System.out.println("___________________________________");
                    System.out.println(color.GREEN + "YOU WON!" + color.RESET);
                    break;
                }
    
                if (mainChar.hp <= 0 || mainChar.stamina <= 0) {
                    System.out.println("___________________________________");
                    System.out.println(color.RED + "You lost" + color.RESET);
                    System.out.println(color.MAGENTA + "...And they chose you to play the hero..." + color.RESET);
                    break;
                }


                //boss dialogue
                if(bossHp < 50 && bossHp > 20) {
                    System.out.print(color.MAGENTA);
                    System.out.println("\nBoss: ARGHH Who are you to challenge me?");
                    System.out.print(color.RESET);
                } else if (bossHp <= 20) {
                    System.out.print(color.MAGENTA);
                    System.out.println("\nBoss: You're a mortal! How?!");
                    System.out.print(color.RESET);
                } else if (bossHp > 50) {
                    System.out.print(color.MAGENTA);
                    System.out.println("\nBoss: Lucky Hit!");
                    System.out.print(color.RESET);
                } else {
                    System.out.print(color.MAGENTA);
                    System.out.print(color.RESET);
                }
            }

            int attackChance = random.nextInt(100) + 1;
            if (attackChance <= 65) { 
                int bossDamage = random.nextInt(25) + 10;
                mainChar.hp -= bossDamage;
                System.out.print(color.RED);
                System.out.printf("\nBoss attacks, deals %d damage%n", bossDamage);
                if(mainChar.stamina < 40) {
                    System.out.println(color.MAGENTA + "Boss: Tired are we?" + color.RESET);
                } else if (attackChance % 3 == 0) {
                    System.out.println(color.MAGENTA + "Boss: Why do you fight?" + color.RESET);
                } else if (attackChance % 2 == 0) {
                    System.out.println(color.MAGENTA + "Boss: You cannot win, Give up!" + color.RESET);
                } else {
                    System.out.println(color.MAGENTA + "Boss: You will achieve nothing!" + color.RESET);
                }
                System.out.print(color.RESET);
            } else {
                System.out.println(color.BLUE + "\nBoss chose not to attack this turn." + color.RESET);
                System.out.println(color.MAGENTA + "I will spare you this time..." + color.RESET);
            }

            System.out.println("___________________________________");
        }
    }

    public static void main(String[] args) {
        GameMechanics game = new GameMechanics();
        game.startGame();
    }
}
