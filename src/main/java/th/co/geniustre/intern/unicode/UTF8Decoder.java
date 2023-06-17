package th.co.geniustre.intern.unicode;

public class UTF8Decoder {
    public String decode(byte[] utf8s){

        String result = "";

        for(int i = 0; i<utf8s.length; i++){
            String a = Integer.toBinaryString(utf8s[i]).substring(24);
            if(a.startsWith("1110")){
                String substring = a.substring(4);
                result += substring;
            } if(a.startsWith("10")){
                String substring = a.substring(2);
                result += substring;
            }
        }
        String t1 = result.substring(0,16);
        String t2 = result.substring(16,32);
        String t3 = result.substring(32,48);
        Unicode unicode = new Unicode();
        int a = Integer.parseInt(t1,2);
        int a1 = Integer.parseInt(t2,2);
        int a2 = Integer.parseInt(t3,2);

        String str = unicode.unicodeChars.get(a).toString();
        String str2 = unicode.unicodeChars.get(a1).toString();
        String str3 = unicode.unicodeChars.get(a2).toString();

        return str+str2+str3;
    }
}
