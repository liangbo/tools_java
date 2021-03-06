package net.liangbo.java.tools.util;


/**
 * 提供十进制数字转换64进制，以达到压缩字符串长度的目的
 *
 * 
 */
public class Num64RadixUtil {


    final static char[] digits = {
            '0' , '1' , '2' , '3' , '4' , '5' ,
            '6' , '7' , '8' , '9' , 'a' , 'b' ,
            'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
            'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
            'o' , 'p' , 'q' , 'r' , 's' , 't' ,
            'u' , 'v' , 'w' , 'x' , 'y' , 'z' ,
            'A' , 'B' , 'C' , 'D' , 'E' , 'F' ,
            'G' , 'H' , 'I' , 'J' , 'K' , 'L' ,
            'M' , 'N' , 'O' , 'P' , 'Q' , 'R' ,
            'S' , 'T' , 'U' , 'V' , 'W' , 'X' ,
            'Y' , 'Z' , '+' , '/'  ,
    };





    public static void main(String[] args){
        System.out.println(1<<6);
        System.out.println(1>>>6);

        System.out.println(compressNumber(1000000000000L));
        System.out.println(unCompressNumber("ezkFh00"));


    }


    /**
     * 把10进制的数字转换成64进制
     * @param number
     * @return
     */
    private static String compressNumber(long number) {
        char[] buf = new char[64];
        int charPos = 64;
        int radix = 1 << 6;
        long mask = radix - 1;
        do {
            buf[--charPos] = digits[(int)(number & mask)];
            number =number>>>6;
        } while (number != 0);
        return new String(buf, charPos, (64 - charPos));
    }


    /**
     * 把64进制的字符串转换成10进制
     * @param decompStr
     * @return
     */
    private static long unCompressNumber(String decompStr)
    {
        long result=0;
        for (int i =  decompStr.length()-1; i >=0; i--) {
            if(i==decompStr.length()-1)
            {
                result+=getCharIndexNum(decompStr.charAt(i));
                continue;
            }
            for (int j = 0; j < digits.length; j++) {
                if(decompStr.charAt(i)==digits[j])
                {
                    result+=((long)j)<<6*(decompStr.length()-1-i);
                }
            }
        }
        return result;
    }

    /**
     *
     * @param ch
     * @return
     */
    private static long getCharIndexNum(char ch)
    {
        int num=((int)ch);
        if(num>=48&&num<=57)
        {
            return num-48;
        }
        else if(num>=97&&num<=122)
        {
            return num-87;
        }else if(num>=65&&num<=90)
        {
            return num-29;
        }else if(num==43)
        {
            return 62;
        }
        else if (num == 47)
        {
            return 63;
        }
        return 0;
    }







}
