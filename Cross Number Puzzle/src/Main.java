public class Main {

    public static void main(String[] args) {
        for(int i = 1000 ; i <= 9999;i++){
            int sum = 1;
            for(int o = 2; o < Math.sqrt(i);o++){
                if(i%o == 0){
                    sum+=o;
                    sum+= i/o;
                }
            }
            if(sum == i){
                System.out.print(i + " ");
            }
        }
        System.out.println("");
        for(int i = 100; i <= 999; i++){
            int sum = 0;
            int temp = i;
            while(temp != 0){
                int dif = temp%10;
                temp /= 10;
                sum += dif*dif*dif;
            }
            if(sum == i){
                System.out.print(i + " ");
            }
        }
    }
}
