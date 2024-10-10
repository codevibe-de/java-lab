package io;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class CharsetDemo {

    public static void main(String[] args) throws IOException {
        String text = "50 €";
        var bytes = text.getBytes(StandardCharsets.UTF_8);
//        for (byte b : bytes) {
//            var binary = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
//            System.out.println(binary);
//        }

        FileOutputStream out = new FileOutputStream(new File("content.txt"));
        out.write(bytes);
        out.close();

        FileInputStream fileInputStream = new FileInputStream(new File("content.txt"));
        byte[] bytesRead = fileInputStream.readAllBytes();
        var s = new String(bytes, StandardCharsets.US_ASCII);
//        System.out.println(s);

        FileReader fileReader = new FileReader("content.txt", StandardCharsets.UTF_8);
        System.out.println(new BufferedReader(fileReader).readLine());
    }

}
