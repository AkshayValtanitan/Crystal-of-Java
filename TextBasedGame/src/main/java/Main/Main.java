/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author josea
 */
import javax.swing.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Menu menu = new MainMenu();
        boolean run = true;

        while (run) {
            menu.tellFirstStory();
            int choice = menu.printMenu();
            
            switch (choice) {
                case 1:
                    System.out.println("Starting the game...");
                    GameMechanics gameMechanics = new GameMechanics();
                    gameMechanics.startGame();
                    while (true) {
                    try {
                        System.out.print("Continue? (Y/N): ");
                        char decision = scan.next().charAt(0);

                        if (decision == 'Y' || decision == 'y') {
                            System.out.println("Continuing...");
                            break; 
                        } else if (decision == 'N' || decision == 'n') {
                            System.out.println("Exiting...");
                            run = false;
                            break; 
                        } else {
                            System.out.println("Invalid choice. Please enter 'Y' or 'N'.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a character.");
                        scan.nextLine(); 
                    }
                }
                    break;
                case 2:
                    System.out.println("Exiting the game...");
                    run = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        }

        

    }
}

