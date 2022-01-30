package com.mengxin.finallshell_pj;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
public class FinalShell {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        System.out.println("FinalShell破解工具 MengXin优化版");
        System.out.println("萌新のBlog:https://blog.mengx.fun");
        System.out.print("请输入FinalShell显示的机器码：");
        Scanner reader = new Scanner(System.in);
        String machineCode = reader.nextLine();
        generateKey(machineCode);
    }
    public static void generateKey(String hardwareId) throws NoSuchAlgorithmException {
        String proKey = transform(61305 + hardwareId + 8552);
        String pfKey = transform(2356 + hardwareId + 13593);
        System.out.println("高级版激活码: " + proKey);
        System.out.print("专业版激活码: " + pfKey);
    }
    public static String transform(String str) throws NoSuchAlgorithmException {
        String md5 = hashMD5(str);
        return hashMD5(str).substring(8, 24);
    }
    public static String hashMD5(String str) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        byte[] hashed = digest.digest(str.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hashed) {
            int len = b & 0xFF;
            if (len < 16) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(len));
        }
        return sb.toString();
    }
}