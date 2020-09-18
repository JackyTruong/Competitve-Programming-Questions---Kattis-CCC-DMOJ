import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[3];
        for(int i = 0 ; i < 3; i++){
            nums[i] = sc.nextInt();
        }
        if(nums[0] + nums[1] == nums[2]){
            System.out.println(nums[0] + "+" + nums[1] + "=" + nums[2]);
        }
        else if(nums[0] - nums[1] == nums[2]){
            System.out.println(nums[0] + "-" + nums[1] + "=" + nums[2]);
        }
        else if(nums[0] / nums[1] == nums[2]){
            System.out.println(nums[0] + "/" + nums[1] + "=" + nums[2]);
        }
        else if(nums[0] * nums[1] == nums[2]){
            System.out.println(nums[0] + "*" + nums[1] + "=" + nums[2]);
        }
        else if(nums[1] - nums[2] == nums[0]){
            System.out.println(nums[0] + "=" + nums[1] + "-" + nums[2]);
        }
        else if(nums[1] + nums[2] == nums[0]){
            System.out.println(nums[0] + "=" + nums[1] + "+" + nums[2]);
        }
        else if(nums[1] * nums[2] == nums[0]){
            System.out.println(nums[0] + "=" + nums[1] + "*" + nums[2]);
        }
        else if(nums[1] / nums[2] == nums[0]){
            System.out.println(nums[0] + "=" + nums[1] + "/" + nums[2]);
        }
    }
}
