package net.liangbo.java.tools.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: LiangBo mailto:liangbo1180@gmail.com
 * Date: 15/3/11
 * Time: 下午5:39
 */
public class StringUtil {



    /**
     * 判断一个字符是Ascill字符还是其它字符（如汉，日，韩文字符）
     */
    public static boolean isLetter(char c) {
        int k = 0x80;
        return c / k == 0 ? true : false;
    }

    /**
     * 得到一个字符串的长度,显示的长度,一个汉字或日韩文长度为2,英文字符长度为1
     *
     * @param
     *            s ,需要得到长度的字符串
     * @return int, 得到的字符串长度
     */
    public static int byteLength(String s) {
        if (s == null)
            return 0;
        char[] c = s.toCharArray();
        int len = 0;
        for (int i = 0; i < c.length; i++) {
            len++;
            if (!isLetter(c[i])) {
                len++;
            }
        }
        return len;
    }

    /**
     * 截取一段字符的长度,不区分中英文,如果数字不正好，则少取一个字符位
     *
     * @author patriotlml
     * @param
     *            origin, 原始字符串
     * @param
     *            len, 截取长度(一个汉字长度按2算的)
     * @return String, 返回的字符串
     */
    public static String subString(String origin, int len) {
        if (origin == null || origin.equals("")||len<1)
            return "";
        byte[] strByte = new byte[len];
        if (len > byteLength(origin)){
            return origin;}
        System.arraycopy(origin.getBytes(), 0, strByte, 0, len);
        int count = 0;
        for (int i = 0; i < len; i++) {
            int value = (int) strByte[i];
            if (value < 0) {
                count++;
            }
        }
        if (count % 2 != 0) {
            len = (len == 1) ? ++len : --len;
        }
        return new String(strByte, 0, len);
    }


    /**
     * 根据正则匹配字符串，并进行替换操作，常用于搜索高亮显示
     * 例如：
     *     将 "abcd1bcda2cdma3a" 里面的数字用<font>$0</font>替换
     *     结果为:
     *     abcd<font>1</font>bcda<font>2</font>cdma<font>3</font>a
     * @param originString
     * @param pattern
     * @param replaceStr
     * @return
     */
    public static String replaceWithPattern(String originString,String pattern,String replaceStr){
        if(originString==null || originString.length()==0) return null;
        if(pattern==null || pattern.length()==0) return null;
        if(replaceStr==null || replaceStr.length()==0) return null;

        Pattern  p = Pattern.compile(pattern);

        Matcher matcher = p.matcher(originString);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()){
            matcher.appendReplacement(sb,replaceStr);//replaceStr 可以使用<font>$0<font>种的$0来表示匹配到的字符
        }

        return sb.toString();

    }


    public static void main(String[] args){
        System.out.println(subString("abcd你好abcd", 5));
        System.out.println(subString("abcd你好abcd",10));
        System.out.println("你好");


        String origin = "abcd1bcd2dds389";

        String pattern = "[0-9]";

        String replaceStr = "N";

        System.out.println(replaceWithPattern(origin,pattern,replaceStr));


    }





}
