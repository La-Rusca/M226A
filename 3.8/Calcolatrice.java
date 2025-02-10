/**
*Esercizio 3.8
*Con due numeri e un operatore si calcola il risultato dell'operazione
*
* @author Giada Rusconi
* @version 10.02.2025
*/

public class Calcolatrice {
    public static void main(String[] args) {
        int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		String operatore = args[2];
		int risultato = 0;
		
		if (operatore.equals("+")) {
			risultato = num1 + num2;
		}
		
		else if (operatore.equals("-")) {
			risultato = num1 - num2;
		}
		
		else if (operatore.equals("/")) {
			risultato = num1 / num2;
		}
		
		else if (operatore.equals("x")) {
			risultato = num1 * num2;
		}
		
		else {
			System.out.println("Errore, operatore non valido");
		}
		
		System.out.println(num1 + " " + operatore + " " + num2 + " = " + risultato);
    }
}





