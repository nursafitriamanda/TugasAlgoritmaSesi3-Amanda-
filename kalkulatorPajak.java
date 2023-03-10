import java.util.Scanner;

public class kalkulatorPajak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan jumlah penghasilan tahunan: ");
        double income = scanner.nextDouble();
        
        double ptkp = calculatePTKP(income);
        double pkp = calculatePKP(income, ptkp);
        double tax = calculateTax(pkp);
        
        System.out.println("Penghasilan Tidak Kena Pajak (PTKP): " + ptkp);
        System.out.println("Penghasilan Kena Pajak (PKP): " + pkp);
        System.out.println("Pajak yang harus dibayar: " + tax);
    }
    
    public static double calculatePTKP(double income) {
        double ptkp;
        if (income <= 54000000) {
            ptkp = 54000000;
        } else if (income <= 58500000) {
            ptkp = 58500000;
        } else if (income <= 63000000) {
            ptkp = 63000000;
        } else if (income <= 67500000) {
            ptkp = 67500000;
        } else {
            ptkp = 72000000;
        }
        return ptkp;
    }
    
    public static double calculatePKP(double income, double ptkp) {
        double pkp = income - ptkp;
        if (pkp < 0) {
            pkp = 0;
        }
        return pkp;
    }
    
    public static double calculateTax(double pkp) {
        double tax;
        if (pkp <= 50000000) {
            tax = pkp * 0.05;
        } else if (pkp <= 250000000) {
            tax = 2500000 + (pkp - 50000000) * 0.15;
        } else if (pkp <= 500000000) {
            tax = 32500000 + (pkp - 250000000) * 0.25;
        } else if (pkp <= 1000000000) {
            tax = 95000000 + (pkp - 500000000) * 0.3;
        } else {
            tax = 245000000 + (pkp - 1000000000) * 0.35;
        }
        return tax;
    }
}
