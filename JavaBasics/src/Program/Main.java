package Program;
import java.util.Scanner;

public class Main {
	//Exercice1
	public static void exercice1() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Entrez le premier nombre");
		int num1 = scan.nextInt();
		System.out.println("Entrez le second nombre");
		int num2 = scan.nextInt();
		System.out.println("La somme des deux nombres est : "+(num1 + num2));
		scan.close();
	}
	
	//Exercice2
	public static void exercice2(double prixUnitaire , int quantite ) {
		double prixGlobal = prixUnitaire * quantite;
		System.out.println("Le montant a payé est : " + prixGlobal + " Dirhams");
	}
	
	//Exercice3
	public static void exercice3() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Entrez le premier nombre");
		int num1 = scan.nextInt();
		System.out.println("Entrez le second nombre");
		int num2 = scan.nextInt();
		System.out.println("Entrez le toisième nombre");
		int num3 = scan.nextInt();
		System.out.println("La somme des trois nombres est : "+(num1 + num2 + num3));
		System.out.println("Le produit des trois nombres est : "+(num1 * num2 * num3 ));
		System.out.println("La moyenne des trois nombres est : "+(num1 * num2 * num3)/3);
		scan.close();
	}
	
	//Exercice4
	public static void exercice4() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Entrez le nombre");
		int num = scan.nextInt();
		if(num == 0) {
			System.out.println("Le nombre est nulle");
		}else {
			if(num > 0) {
				System.out.println("Le nombre est positif");
			}else {
				System.out.println("Le nombre est négatif");
			}
		}
		scan.close();
	}
	
	//Exercice5
	public static void  exercice5() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Entrez le premier nombre");
		int num1 = scan.nextInt();
		System.out.println("Entrez le second nombre");
		int num2 = scan.nextInt();
		if( num1 > num2) {
			System.out.println("Le maximum est : " + num1);
		}else {
			System.out.println("Le maximum est : " + num2);
		}
		scan.close();
	}
	
	//Exercice6
	public static void exercice6() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Entrez x :");
		int x = scan.nextInt();
		System.out.println("Entrez y :");
		int y = scan.nextInt();
		x = x + y;
		y = x - y;
		x = x - y;
		System.out.println("La nouvelle valeur de x est : " + x);
		System.out.println("La nouvelle valeur de y est : " + y);
		scan.close();
	}
	
	//Exercice7
	public static void exercice7(double a ,double b) {
		if(a == 0) {
			System.out.println("impossible car a = " + a);
		}else {
			System.out.println("La solution est : " + (-b/a));
		}
	}
	
	//Exercice8
	public static void exercice8(double a, double b,double c) {
		double delta = b*b - 4*a*c;
		System.out.println(delta);

		if(a == 0 & b == 0) {
			System.out.println("Solution impossible ");
		}else if(a == 0) {
			System.out.println("x : " + (-c/b));
		}else if(b == 0 & c < 0) {
			System.out.println("x1 : " + Math.sqrt(c)/a);
			System.out.println("x2 : " + -Math.sqrt(c)/a);
		}else if(delta == 0) {
			System.out.println("x0 : " + (-b/(2*a)));
		}else if(delta > 0) {
			System.out.println("Les solutions sont : ");
			System.out.println("x1 : " + (-b + Math.sqrt(delta))/(2*a));
			System.out.println("x2 : " + (-b - Math.sqrt(delta))/(2*a));
		}else {
			System.out.println("Solution impossible ");
		}
	}
	
	//Exercice9 
	public static void exercice9() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Entrez le montant");
		int montant = scan.nextInt();
		System.out.println("Entrez le taux de réduction");
		int tauReduction = scan.nextInt();
		System.out.println("Le montant réduit est : "+(montant - ((montant * tauReduction)/100)));
		scan.close();
	}
	
	//Exercice10
	public static void exercice10() {
		int compte = 0 ;
		while(compte < 100) {
			System.out.println("Bonjour");
			compte ++;
		}
	}
	
	//Exercice11
	public static void exercice11() {
		int s = 0;
		int compte = 1;
		while(compte < 31) {
			s += compte;
			compte ++;
		}
		System.out.println(s);
	}
	
	//Exercice12
	public static void exercice12() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Entrez la valeur de n :");
		int n = scan.nextInt();
		int s = 1;
		int compte = 1;
		while(compte < n+1) {
			s *= compte;
			compte ++;
		}
		System.out.println(s);
		scan.close();
	}
	
	//Exercice13
	/*
	public static void exercice13() {
		Scanner scan = new Scanner(System.in);
		System.out.println("saisissez un text terminé par un point :");
		String text = scan.nextLine();
		int i = 0;
		int compte = 0;
		while(i < text.length()) {
			char a = text.;
		}
	}
	*/
	public static void exercice15() {
		String text =" ";
		int i = 0;
		while(i<5) {
			text +="*";
			System.out.println(text);
			i++;
		}
	}
	public static void main(String[] arguments) {
		exercice15();
	}
}
