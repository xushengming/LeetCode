public class _6ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows <= 1 || s.length() == 0){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numRows; i++){
            int pos = 1;
            int lastOffset = i;
            int offset = i;
            sb.append(s.charAt(offset));
            while(lastOffset < s.length()){
                if(i == 0 || i == numRows - 1){
                    offset = offset + (numRows - 1) * 2;
                }else if((pos & 0x1) == 1){
                    offset = lastOffset + (numRows - 1 - i) * 2;
                }else{
                    offset = lastOffset + i * 2;
                }
                if(offset >= s.length()){
                    break;
                }
                pos++;
                sb.append(s.charAt(offset));
                lastOffset = offset;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        _6ZigZagConversion conversion = new _6ZigZagConversion();
        String input = "PAYPALISHIRING";
        int rows = 3;
        String result = conversion.convert(input, rows);
        System.out.println(result);
    }
}