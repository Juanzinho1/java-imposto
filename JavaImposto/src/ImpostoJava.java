import java.util.Locale;
import java.util.Scanner;

public class ImpostoJava {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		double rendasalario, rendaservico, rendacapital, rendatotal, gastomedico, gastoescola, imposto, impostocobrado, impostoservico, impostocapital, abatimentoo, impostobruto, impostodevido, maxded,gastded;
		
		System.out.print("Renda anual com salário: "); rendasalario = sc.nextDouble();
		System.out.print("Renda anual com prestação de serviço: "); rendaservico = sc.nextDouble();
		System.out.print("Renda anual com ganho de capital: "); rendacapital = sc.nextDouble();
		System.out.print("Gastos médicos: "); gastomedico = sc.nextDouble();
		System.out.print("Gastos educacionais: "); gastoescola = sc.nextDouble();
		imposto = 0;
		impostoservico = 0.15;
		impostocapital = 0.2;
		impostoservico *= rendaservico;
		impostocapital *= rendacapital;
		rendatotal = rendasalario/12;
		
		if (rendatotal < 3000) {
			impostocobrado = imposto*rendasalario;
		} else if (rendatotal < 5000) {
			imposto = 0.1;
			impostocobrado = imposto*rendasalario;
		} else {
			imposto = 0.2;
			impostocobrado = imposto*rendasalario;
		}
		
		impostobruto = impostocobrado + impostocapital + impostoservico;
		
		System.out.printf("%n");
		System.out.printf("RELATÓRIO DE IMPOSTO DE RENDA %n%n");
		System.out.println("CONSOLIDADO DE RENDA: ");
		System.out.printf("Imposto sobre salário: %.2f%n", impostocobrado);
		System.out.printf("Imposto sobre serviço: %.2f%n", impostoservico);
		System.out.printf("Imposto sobre ganho de capital: %.2f%n%n", impostocapital);
		
		
		if (gastoescola + gastomedico < impostobruto*0.3) {
			abatimentoo = gastomedico + gastoescola;
		} else {
			abatimentoo = impostobruto*0.3;
		}
		
		impostodevido = impostobruto - abatimentoo;
		maxded = impostobruto * 0.3;
		gastded = gastoescola + gastomedico;
		
		
		System.out.println("DEDUÇÕES: ");
		System.out.printf("Máximo dedutível: %.2f%n", maxded);
		System.out.printf("Gastos dedutíveis: %.2f%n%n", gastded);
		
		System.out.printf("RESUMO: %n");
		System.out.printf("Imposto bruto total: %.2f%n", impostobruto);
		System.out.printf("Abatimento: %.2f%n", abatimentoo);
		System.out.printf("Imposto devido: %.2f%n%n", impostodevido);
		
		sc.close();
	}

}