class Solution {
    public boolean isNumber(String s) {
        boolean  digit = false, dotseen=false,  eseen=false;
      int countplusminus =0;
        for(int i =0; i <s.length(); i++){
            char ch = s.charAt(i);

            //digit
            if(Character.isDigit(ch)){
                digit = true;
            }
            //plusmoimus

        else if(ch == '+' || ch == '-'){
                if(countplusminus ==2){
                    return false;
                }

                if(i>0 && (s.charAt(i-1)!='e') &&  (s.charAt(i-1)!='E')){
                    return false;
                }

                if(i==s.length()-1){
                    return false;
                }
                countplusminus++;
            }
            //fordot

        else if(ch == '.'){
                if(eseen || dotseen){
                    return false;
                }
                if(i == s.length()-1 && !digit){
                    return false;
                }
                dotseen = true;
            }

            //e/E
         else if(ch == 'e' || ch == 'E'){
                if(eseen || !digit || i == s.length()-1){
                    return false;
                }
                eseen = true;
            }
            
      else{
        return false;
         }
        }
        return true;
    }
}
