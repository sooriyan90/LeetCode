class NSSolutionOne {
    public boolean backspaceCompare(String S, String T) {
        
        StringBuilder sbS = new StringBuilder();
        StringBuilder sbT = new StringBuilder();
        int hashCharCount = 0;
        
        for(int i = S.length() - 1; i >= 0; i--){
            if(S.charAt(i) == '#'){
                hashCharCount++;
            }else if(hashCharCount > 0){
                hashCharCount--;
            }else{
                sbS.append(S.charAt(i));
            }
        }
        
        hashCharCount = 0;
        
        for(int i = T.length() - 1; i >= 0; i--){
            if(T.charAt(i) == '#'){
                hashCharCount++;
            }else if(hashCharCount > 0){
                hashCharCount--;
            }else{
                sbT.append(T.charAt(i));   
            }
        }
        
        //System.out.println(sbS.toString());
        //System.out.println(sbT.toString());
        
        if(sbT.toString().equals(sbS.toString())){
            return true;
        }else{
            return false;
        }
    }
}
