class Solution {
    public boolean backspaceCompare(String S, String T) {
        String sFinal = finalString(S);
        String tFinal = finalString(T);
        return sFinal.equals(tFinal);
    }
    
    public String finalString(String str){
        StringBuilder strFinal = new StringBuilder();
        for(int i = 0; i< str.length(); i++){
            char c = str.charAt(i);
            if(c != '#')
                strFinal.append(c);
            else{
                if(strFinal.length() > 0)
                    strFinal.deleteCharAt(strFinal.length() - 1);
            }   
        }
        return strFinal.toString();
    }
}
