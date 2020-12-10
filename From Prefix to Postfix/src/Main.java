

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;

    private static boolean isDayWithin(int month, int day, int year){
        if(month == 1 && day <= 31){
            return true;
        }
        else if(month == 2 && year %4 == 0){
            if(day <=29){
                return true;
            }
        }
        else if(month == 2){
           if(day <= 28){
               return true;
           }
        }
        else if(month == 3 && day <= 31){
            return true;
        }
        else if(month == 4 && day <= 30){
            return true;
        }
        else if(month == 5 && day <= 31){
            return true;
        }
        else if(month == 6 && day <= 30){
            return true;
        }
        else if(month == 7 && day <= 31){
            return true;
        }
        else if(month == 8 && day <= 31){
            return true;
        }
        else if(month == 9 && day <= 30){
            return true;
        }
        else if(month == 10 && day <= 31){
            return true;
        }
        else if(month == 11 && day <= 30){
            return true;
        }
        else if(month == 12 && day <= 31){
            return true;
        }
        return false;
    }

    private static boolean isDate(String date){
        if(date.length() == 8){
            if(Character.isDigit(date.charAt(0)) && Character.isDigit(date.charAt(1)) && Character.isDigit(date.charAt(3)) && Character.isDigit(date.charAt(4)) && Character.isDigit(date.charAt(6)) && Character.isDigit(date.charAt(7))){
                int month = Character.getNumericValue(date.charAt(3))*10 + Character.getNumericValue(date.charAt(4));
                if(month <= 12 && month > 0){
                    if(date.charAt(2) == '/'){
                        int day = Character.getNumericValue(date.charAt(0))*10 + Character.getNumericValue(date.charAt(1));
                        int year = Character.getNumericValue(date.charAt(6)) * 10 + Character.getNumericValue(date.charAt(7));
                        if(isDayWithin(day, month, year)){
                            return true;
                        }
                    }
                    else{
                        int year = Character.getNumericValue(date.charAt(0))*10 + Character.getNumericValue(date.charAt(1));
                        int day = Character.getNumericValue(date.charAt(6)) * 10 + Character.getNumericValue(date.charAt(7));
                        if(isDayWithin(day, month, year)){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean isMonth(String month){
        if(month.equals("January") || month.equals("February") || month.equals("March") || month.equals("April") || month.equals("May") || month.equals("June") || month.equals("July") || month.equals("August") || month.equals("September") || month.equals("October") || month.equals("November") || month.equals("December")){
            return true;
        }
        return false;
    }

    private static int year(int num){
        if(num <=24){
            return 2000+num;
        }
        else{
            return 1900+num;
        }
    }

    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int lines = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < lines; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String entireLine = "";
            while(st.hasMoreTokens()){
                boolean did = false;
                String temp = st.nextToken();
                String other = temp.replace("," , "");
                boolean hadC = false;
                if(!temp.equals(other)){
                    hadC = true;
                }
                if(isDate(other)){
                    StringTokenizer inside;
                    String date = "";
                    if(temp.charAt(2) == '/'){
                        inside = new StringTokenizer(temp, "/");
                        date += inside.nextToken();
                        date+="/";
                        date += inside.nextToken();
                        date+="/";
                        String year = inside.nextToken();
                        year = year.replace(",", "");
                        date += year(Integer.parseInt(year));
                        if(hadC){
                            date+=',';
                        }
                        date += " ";
                    }
                    else{
                        inside = new StringTokenizer(temp, ".");
                        String year = inside.nextToken();
                        year = year.replace(",", "");
                        date += year(Integer.parseInt(year));
                        date += ".";
                        date += inside.nextToken();
                        date += ".";
                        date += inside.nextToken();
                        date += " ";
                    }
                    entireLine += date;
                    did = true;
                }
                else if(isMonth(other)){
                    if(st.countTokens() >= 2){
                        String date = "";
                        date += temp;
                        String temp2 = st.nextToken();
                        if(isMonth(temp2)){
                            date += " " + temp2 + " ";
                        }
                        else{


                        }

                        String year = st.nextToken();
                        String temp1 = year.replace(",", "");
                        boolean addC = false;
                        if(!temp1.equals(year)){
                            addC = true;
                        }
                        boolean num = isNumeric(temp1);
                        //System.out.println(num);
                        if(num){
                            date += year(Integer.parseInt(temp1));
                            if(addC){
                                date += ",";
                            }
                            entireLine += date;
                            did = true;
                        }
                        else{
                            entireLine += date;
                        }
                        entireLine += " ";
                    }
                }
                if(!did){
                    entireLine += temp + " ";
                }
            }
            out.println(entireLine);
        }


        out.close();
    }
}
