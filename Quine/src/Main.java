public class Main {
    public static void main(String[] args) {
        char q = 34;
        String[] temp = {
"public class Main {",
"    public static void main(String[] args) {",
"        char q = 34;",
"        String[] temp = {",
"        };",
"        for(int i = 0 ; i < 4; i++){",
"            System.out.println(temp[i]);",
"        }",
"        for(int i = 0; i < temp.length; i++){",
"            System.out.println(q + temp[i] + q + ',');",
"        }",
"        for(int i = 4; i < temp.length; i++){",
"            System.out.println(temp[i]);",
"        }",
"    }",
"}",
        };
        for(int i = 0 ; i < 4; i++){
            System.out.println(temp[i]);
        }
        for(int i = 0; i < temp.length; i++){
            System.out.println(q + temp[i] + q + ',');
        }
        for(int i = 4; i < temp.length; i++){
            System.out.println(temp[i]);
        }
    }
}
