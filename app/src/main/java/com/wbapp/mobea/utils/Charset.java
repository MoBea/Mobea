package com.wbapp.mobea.utils;

import java.io.UnsupportedEncodingException;
/**
 * @author BaiRuizhi
 * @date 2018/10/18
 * @description 转换字符串的编码
 */
public class Charset {
    /** 7位ASCII字符，也叫作ISO646-US、Unicode字符集的基本拉丁块 */
    public static final String US_ASCII = "US-ASCII";

    /** ISO 拉丁字母表 No.1，也叫作 ISO-LATIN-1 */
    public static final String ISO_8859_1 = "ISO-8859-1";

    /** 8 位 UCS 转换格式 */
    public static final String UTF_8 = "UTF-8";

    /** 16 位 UCS 转换格式，Big Endian（最低地址存放高位字节）字节顺序 */
    public static final String UTF_16BE = "UTF-16BE";

    /** 16 位 UCS 转换格式，Little-endian（最高地址存放低位字节）字节顺序 */
    public static final String UTF_16LE = "UTF-16LE";

    /** 16 位 UCS 转换格式，字节顺序由可选的字节顺序标记来标识 */
    public static final String UTF_16 = "UTF-16";

    /** 中文超大字符集 */
    public static final String GBK = "GBK";

    /**
     * 将字符编码转换成US-ASCII码
     */
    public static String toASCII(String str) throws UnsupportedEncodingException{
        return changeCharset(str, US_ASCII);
    }
    /**
     * 将字符编码转换成ISO-8859-1码
     */
    public static String toISO_8859_1(String str) throws UnsupportedEncodingException{
        return changeCharset(str, ISO_8859_1);
    }
    /**
     * 将字符编码转换成UTF-8码
     */
    public static String toUTF_8(String str) throws UnsupportedEncodingException{
        return changeCharset(str, UTF_8);
    }
    /**
     * 将字符编码转换成UTF-16BE码
     */
    public static String toUTF_16BE(String str) throws UnsupportedEncodingException{
        return changeCharset(str, UTF_16BE);
    }
    /**
     * 将字符编码转换成UTF-16LE码
     */
    public static String toUTF_16LE(String str) throws UnsupportedEncodingException{
        return changeCharset(str, UTF_16LE);
    }
    /**
     * 将字符编码转换成UTF-16码
     */
    public static String toUTF_16(String str) throws UnsupportedEncodingException{
        return changeCharset(str, UTF_16);
    }
    /**
     * 将字符编码转换成GBK码
     */
    public static String toGBK(String str) throws UnsupportedEncodingException{
        return changeCharset(str, GBK);
    }

    /**
     * 字符串编码转换的实现方法
     * @param str  待转换编码的字符串
     * @param newCharset 目标编码
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String changeCharset(String str, String newCharset)
            throws UnsupportedEncodingException {
        if (str != null) {
            //用默认字符编码解码字符串。
            byte[] bs = str.getBytes();
            //用新的字符编码生成字符串
            return new String(bs, newCharset);
        }
        return null;
    }
    /**
     * 字符串编码转换的实现方法
     * @param str  待转换编码的字符串
     * @param oldCharset 原编码
     * @param newCharset 目标编码
     * @return
     * @throws UnsupportedEncodingException
     */
    public String changeCharset(String str, String oldCharset, String newCharset)
            throws UnsupportedEncodingException {
        if (str != null) {
            //用旧的字符编码解码字符串。解码可能会出现异常。
            byte[] bs = str.getBytes(oldCharset);
            //用新的字符编码生成字符串
            return new String(bs, newCharset);
        }
        return null;
    }
    public static String toChineseHex(String s) {
        String ss = s;
        byte[] bt = new byte[0];
            bt = ss.getBytes();
        String s1 = "";
        for (int i = 0; i < bt.length; i++) {
            String tempStr = Integer.toHexString(bt[i]);
            if (tempStr.length() > 2)
                tempStr = tempStr.substring(tempStr.length() - 2);
            //s1 = s1 + tempStr + " ";
            s1 = s1 + tempStr;
        }
        return s1.toUpperCase();

    }

    public static String toUnicode(String s) {
        String as[] = new String[s.length()];
        String s1 = "";
        for (int i = 0; i < s.length(); i++) {
            as[i] = Integer.toHexString(s.charAt(i) & 0xffff);
            s1 = s1 + as[i] + "\t";
        }
        return s1;
    }

    //中文转换成UTF-8编码（16进制字符串)，每个汉字3个字节
    public static String Chinese2UTF_8(String chineseStr)throws Exception {
        StringBuffer utf8Str = new StringBuffer();
        byte[] utf8Decode = chineseStr.getBytes("utf-8");
        for (byte b : utf8Decode)
            utf8Str.append(Integer.toHexString(b&0xFF));
        return utf8Str.toString().toUpperCase();
    }

    //中文转换成GBK码(16进制字符串)，每个汉字2个字节
    public static String Chinese2GBK(String chineseStr)throws Exception {
        StringBuffer GBKStr = new StringBuffer();
        byte[] GBKDecode = chineseStr.getBytes("gbk");
        for (byte b : GBKDecode)
            GBKStr.append(Integer.toHexString(b&0xFF));
        return GBKStr.toString().toUpperCase();
    }


    //16进制GBK字符串转换成中文
    public static String GBK2Chinese(String GBKStr)throws Exception{
        byte[] b = HexString2Bytes(GBKStr);
        String chineseStr = new String(b, "gbk");//输入参数为字节数组
        return chineseStr;
    }

    //把16进制字符串转换成字节数组
    public static byte[] HexString2Bytes(String hexStr) {
        byte[] b = new byte[hexStr.length() / 2];
        for (int i = 0; i < b.length; i++)
            b[i]=(byte) Integer.parseInt(hexStr.substring(2*i,2*i+2),16);
        return b;
    }


    //把字节数组转换成16进制字符串
    public  static final String bytesToHexString(byte[] byteArray){
        StringBuffer hexStr = new StringBuffer(byteArray.length*2);
        for (int i = 0; i < byteArray.length; i++) {
            String sTemp= Integer.toHexString(0xFF& byteArray[i]);
            int j=0;
            while(j<2-sTemp.length())
            {sTemp="0"+sTemp;j++;}
            hexStr.append(sTemp.toUpperCase());
        }
        return hexStr.toString();
    }

}
