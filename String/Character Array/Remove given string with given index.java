    static String replaceFromIndex(String str,int x  , int y,String str2){
        String target = str.substring(x,y);
        str = str.replace(target,str2);
        return str;
    }

	