package toss2021;

public class P3 {

    public boolean solution(String amountText) {
        return check(amountText);
    }
    boolean check(String amountText) {
        if(amountText.length() != 1 && amountText.charAt(0) == '0')
            return false;
        for(int i = 0 ; i < amountText.length(); i++) {
            char now = amountText.charAt(amountText.length()-1-i);
            if(now != ',' && ('0'>now || '9' < now ))
                return false;
            if(now == ',')
                if((i+1)%4 != 0||i==amountText.length()-1)
                return false;
        }
        return true;
    }

}