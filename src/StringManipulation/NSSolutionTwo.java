class NSSolutionTwo {
    public boolean backspaceCompare(String S, String T) {
        
        int hashCharCount = 0;
        
        int len1 = S.length() - 1;
        int len2 = T.length() - 1;
        
        while(len1 >= 0 || len2 >= 0){
            for(int i = len1; i >= 0; i--){
                if(S.charAt(i) == '#'){
                    hashCharCount++;
                    len1--;
                }else if(hashCharCount > 0){
                    hashCharCount--;
                    len1--;
                }else{
                    break;
                }
            }
            
            for(int j = len2; j >= 0; j--){
                if(T.charAt(j) == '#'){
                    hashCharCount++;
                    len2--;
                }else if(hashCharCount > 0){
                    hashCharCount--;
                    len2--;
                }else{
                    break;  
                }
            }
            
            //checks the character
            if((len1 >= 0) && (len2 >= 0) && (S.charAt(len1) != T.charAt(len2))){
                return false;
            }
            
            //checks the string size. At the end they both have to be equal
            if((len1 != len2) && !((len1 >= 0) && (len2 >= 0))){
                return false;
            }
               
            len1--;
            len2--;
        }
        
        return true;
    }
}
