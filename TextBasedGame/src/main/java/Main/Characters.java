/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author josea
 */
public class Characters {
    int hp;
    int attack;
    int stamina;
    Abilities abilities; 

    Characters(int hp, int attack, int stamina) {
        this.hp = hp;
        this.attack = attack;
        this.stamina = stamina;
        this.abilities = new Abilities(10, 15, 25); 
    }
}
