/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.carols_boutique.models;

/**
 *
 * @author Mustafaa Osman
 */
public class CardPayment implements Payment{
	
	@Override
	public boolean verify(int price) {
		if (price < 10000) {
			return true;
		} else {
			int ran = (int) (Math.random() * 10 + 1);
			if (ran > 7) {
				return false;
			}
		}
		return true;
	}
}
