/**
*Esercizio 4.1
*Legge una array di numeri e individua i numeri primi e quanti sono
*
* @author Giada Rusconi
* @version 10.02.2025
*/

public class ArrayPrimi {
    public static void main(String[] args) {
		int[] array = {2, 3, 4, 5, 6, 7, 8, 8}; 
		int conta = 0;
		int[] arrayFiltrato = 
		for (String num : array) {
			for (int i = 2; i <= Math.sqrt(num); i++) {
				if (num % i != 0) {
					conta++;
					System.out.print(num + " ");  
				}
			}
		}
		System.out.println("Quantità primi: " + conta);  
    }
}






