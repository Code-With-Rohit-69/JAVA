public class DecimalToBinary {

    public static void decToBin(int n){
        int bin = 0;
        int power = 0;

        while (n > 0) {
            int r = n % 2;
            bin = bin + r * (int) Math.pow(10, power);
            n = n / 2;
            power++ ;
        }

        System.out.println("To binary is: " + bin);
    }

    public static void main(String[] args) {
        decToBin(10);
    }
}
