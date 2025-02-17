/**
*Esercizio 2.14
*Calcola la nota finale tramite 4 note inserite dall'utente
*
* @author Giada Rusconi
* @version 07.02.2025
*/

public class NotaModuloGiada {
    public static void main(String[] args) {
		float num1 = Float.parseFloat(args[0]);
		float num2 = Float.parseFloat(args[1]);
		float num3 = Float.parseFloat(args[2]);
		float num4 = Float.parseFloat(args[3]);
		float notaFinale = (num1*0.1f + num2*0.3f + num3*0.3f + num4*0.3f);
		System.out.println("Nota finale: " + notaFinale);
	}
}