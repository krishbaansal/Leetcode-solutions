class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0 , ten=0;
        int n = bills.length;
        for(int i=0;i<n;i++){
            int money= bills[i];
        
        if(money==5){
            five++;
        }
        if(money==10){
            if(five==0){
                return false;
            }
            five--;
            ten++;
        }
        if(money==20){
            if(ten>0){
                ten--;
                if(five==0){
                    return false;
                }
                five--;
            }
            else{
                if(five<3){
                    return false;
                }
                five=five-3;
            }
        }
        }
        return true;
    }
}