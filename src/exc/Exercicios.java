package exc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Exercicios {

	private static String Telefone(File F){
		String res = "";
		try (Scanner filesc = new Scanner(F);) {
			Scanner sc;
			char[] arr;
			while(filesc.hasNextLine()){
				sc = new Scanner(filesc.nextLine());
				arr = sc.next().toCharArray();
				for(char ch: arr) {
					if(ch >= '0' && ch <= '9')
						res = res.concat(String.valueOf(ch));
					else
						switch(String.valueOf(ch).toUpperCase()){
							case "A": case "B": case "C":
								res = res.concat(String.valueOf('2'));
								break;
							case "D": case "E": case "F":
								res = res.concat(String.valueOf('3'));
								break;
							case "G": case "H": case "I":
								res = res.concat(String.valueOf('4'));
								break;
							case "J": case "K": case "L":
								res = res.concat(String.valueOf('5'));
								break;
							case "M": case "N": case "O":
								res = res.concat(String.valueOf('6'));
								break;
							case "P": case "Q": case "R": case "S":
								res = res.concat(String.valueOf('7'));
								break;
							case "T": case "U": case "V":
								res = res.concat(String.valueOf('8'));
								break;
							case "W": case "X": case "Y": case "Z":
								res = res.concat(String.valueOf('9'));
								break;
							case "-":
								res = res.concat(String.valueOf('-'));
								break;
							default:
								return "A função encontrou uma entrada inválida e foi terminada.";
						}
				}
				res = res.concat(String.valueOf('\n'));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	private static String Palavra(File F){
		// ASCII a = 97 z = 122 A = 65 Z = 90
		String res = "";
		try (Scanner filesc = new Scanner(F);) {
			Scanner sc;
			char[] arr;
			int val = 0;
			int div;
			while(filesc.hasNextLine()){
				sc = new Scanner(filesc.nextLine());
				arr = sc.next().toCharArray();
				for(char ch: arr) {
					if(ch >= 'a' && ch <= 'z')
						val += ch - 96;
					else if(ch >= 'A' && ch <= 'Z')
						val += ch - 38;
					else {
						sc.close();
						return "A função encontrou uma entrada inválida e foi terminada.";
					}
				}
				div = 0;
				for(int i = 1; i <= val/2; i++)			
					if(val % i == 0)
						div++;
				if(div > 1)
					res = res.concat("It is not a prime word.");
				else
					res = res.concat("It is a prime word.");
				res = res.concat(String.valueOf('\n'));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	private static String Reprovado(File F){
		String res = "";
		try (Scanner filesc = new Scanner(F);) {
			Scanner sc;
			int size;
			int instanceN = 0;
			while(filesc.hasNextLine()){
				instanceN++;
				size = Integer.parseInt(filesc.nextLine().toString());
				HashMap<String,Integer> Instancia_unsorted = new HashMap<String,Integer>();
				ValueComparator compare = new ValueComparator(Instancia_unsorted);
				TreeMap<String,Integer> Instancia_sorted = new TreeMap<String,Integer>(compare);
				for(int i = 0; i < size; i++) {
					if(filesc.hasNextLine()) {
						sc = new Scanner(filesc.nextLine());
						Instancia_unsorted.put(sc.next(), sc.nextInt());
					} else {
						return "A função encontrou uma entrada inválida e foi terminada.";
					}
				}				
				Instancia_sorted.putAll(Instancia_unsorted);
				
				System.out.println("Instancia " + instanceN);
				System.out.println(Instancia_sorted.lastKey() + '\n');
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public static void main(String[] args) {
		String filename = "EntradaEx";
		String entrada = "";
		Scanner sc = new Scanner(System.in);
		System.out.print("Entre com o exercício o qual deseja executar (1,2 ou 3): ");
		entrada = sc.nextLine();
		File F = new File("EntradaEx"+entrada+".txt");
		switch(entrada){
			case "1": System.out.println(Telefone(F)); break;
			case "2": System.out.println(Palavra(F)); break;
			case "3": System.out.println(Reprovado(F)); break;
		}
		
	}
	
}
