public class TaxCalculator {

    public static void main(String[] args) {
        double amount = 640;

        double totalTax = calculateTax(amount);

        System.out.println("Total Tax Amount: ₹" + totalTax);
        printTaxBreakdown(amount);
    }

    public static double calculateTax(double amount) {
        double totalTax = 0;
        int[] slabs = {300, 600, 1000};
        double[] rates = {0.1, 0.2, 0.4};

        for (int i = 0; i < slabs.length; i++) {
            if (amount <= slabs[i]) {
                totalTax += amount * rates[i];
                break;
            } else {
                totalTax += slabs[i] * rates[i];
                amount -= slabs[i];
            }
        }

        return totalTax;
    }

    public static void printTaxBreakdown(double amount) {
        int[] slabs = {300, 600, 1000};
        double[] rates = {0.1, 0.2, 0.4};

        System.out.println("\nTax Breakdown:");
        for (int i = 0; i < slabs.length; i++) {
            double taxableAmount = Math.min(amount, slabs[i]);
            double tax = taxableAmount * rates[i];
            amount -= taxableAmount;

            if (tax > 0) {
                System.out.printf("  Up to ₹%-6d: Tax: ₹%.2f\n", slabs[i], tax);
            }
        }
    }
}
