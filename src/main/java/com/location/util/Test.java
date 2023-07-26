package com.location.util;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

public class Test {

    public static void main(String[] args) {
        byte[] bytes = new byte[]{25, 65, 66, 67};
        char[] chars = new char[] {'Z', 65, 66, 67};
        /*for (byte b: bytes) {
            System.out.println(b);
        }

        for (char c: chars) {
            System.out.println(c);
        }*/

        String value = "dogs are better than cats";
        char[] literals = value.toCharArray();

        int i = 0;
        byte[] byteRepresentation = new byte[literals.length];
        for (char literal: literals) {
            byteRepresentation[i++] = (byte) literal;
        }

        /*for (byte b : byteRepresentation) {
            System.out.println(b);
        }*/
        //System.out.println(byteRepresentation);
        //convertByteToCharacter2(byteRepresentation);
        writeToByteArray(value);
    }

    public static void convertByteToCharacter(byte[] bytes){
        for (byte b : bytes) {
            System.out.print((char)b);
        }

        System.out.println();
        System.out.println(new String(bytes, StandardCharsets.UTF_8));
    }

    public static void convertByteToCharacter2(byte[] bytes){
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        int curr;
        while((curr = byteArrayInputStream.read()) != -1){
            System.out.print(curr);
        }
    }

    public static void writeToByteArray(String value){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for(char c : value.toCharArray()){
            byteArrayOutputStream.write(c);
        }

        System.out.println("writeToByteArray:: "+ byteArrayOutputStream.toByteArray());
    }
}
