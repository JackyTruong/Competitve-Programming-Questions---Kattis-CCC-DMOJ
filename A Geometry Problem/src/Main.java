import java.math.BigDecimal;
        import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigDecimal l = sc.nextBigDecimal();
        BigDecimal w = sc.nextBigDecimal();
        BigDecimal area = l.multiply(w).divide(BigDecimal.valueOf(4));
        area = area.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(area);
    }
}
