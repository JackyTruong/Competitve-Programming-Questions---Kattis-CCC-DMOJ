public class Main {

    public static void main(String[] args) {
        int count = 2;
        int a = 2;
        int b = 1;
        while(a < 4000000){
            int temp = a;
            a = a + b;
            b = temp;
            if(a % 2 == 0){
                count += a;
            }

        }
        System.out.println(count);

    }
}
