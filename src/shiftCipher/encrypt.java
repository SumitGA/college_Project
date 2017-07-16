package shiftCipher;

import java.io.File;
import javax.swing.JOptionPane;
import lsb.encode;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dipen
 */
public class encrypt {

    int xx, yy, mid;
    int key;// = 12345677;
    int shiftKey;
    String message;// = "helLo qllGooD MorNing everyoNe";
    String cipherText = "", operatedText = "";
    
    public encrypt(){}
    
    public encrypt(File f,String message,int key){
       String encryptedText="";
       encryptedText=encryptProcess(message,key);
       message = encryptedText;
       JOptionPane.showMessageDialog(null, message);
       new encode(f,message);
    }
    
    public String applyShift(String text, int shift) {
        char[] chars = text.toCharArray();
        for (int i = 0; i < text.length(); i++) {
            char c = chars[i];
            if (c >= 32 && c <= 126) {
                // Change base to make life easier, and use an
                // int explicitly to avoid worrying... cast later
                int x = c - 32;
                x = (x + shift) % 95;
                if (x < 0) {
                    x += 95; //java modulo can lead to negative values!
                }
                chars[i] = (char) (x + 32);
            }
        }
        return new String(chars);
    }

    public String performOperation(String text, int value) {
        char[] chars = text.toCharArray();

        for (int i = 0; i <= text.length() - 1; i++) {
            char c = chars[i];
            if (c >= 32 && c <= 126) {
                int ct = c - 32;

                ct = (ct + (value % (i + 2))) % 95;
                if (ct < 0) {
                    ct = ct + 95; //java modulo can lead to negative values!

                }
                chars[i] = (char) (ct + 32);
            }
        }

        return new String(chars);
    }

    public int calculateKey(int key, int iteration) {
        String keyString = Integer.toString(key);
        int keyLen = keyString.length();
        int breakIndex;
        String first, second;
        int x, y, shiftKey;

        if ((keyLen % 2) != 0) { //if key size is odd
            breakIndex = (keyLen / 2) + 1;

            first = keyString.substring(0, breakIndex);
            second = keyString.substring(breakIndex, keyLen);
        } else {
            breakIndex = (keyLen / 2);

            first = keyString.substring(0, breakIndex);
            second = keyString.substring(breakIndex, keyLen);
        }

        xx = Integer.parseInt(keyString.substring(0, 2));
        yy = Integer.parseInt(keyString.substring(keyLen - 2, keyLen));
        mid = Integer.parseInt(keyString.substring(breakIndex - 1, breakIndex + 1));

        switch (iteration) {
            case 1:
                x = Integer.parseInt(first);
                y = Integer.parseInt(second);
                shiftKey = x % y;
                break;
            case 2:
                x = Integer.parseInt(first);
                y = Integer.parseInt(second);
                shiftKey = x * y;
                break;
            case 3:
                // if(iteration==3){
                x = Integer.parseInt(first);
                y = Integer.parseInt(second);
                shiftKey = y % x;
                break;
            default:
                shiftKey = key;
                break;
        }
        return shiftKey;
    }

    private String encryptProcess(String message, int key) {
        shiftKey = calculateKey(key, 1);

        cipherText = applyShift(message, shiftKey);

        operatedText = performOperation(cipherText, xx);

        shiftKey = calculateKey(key, 2);

        cipherText = applyShift(operatedText, shiftKey);

        operatedText = performOperation(cipherText, mid);

        shiftKey = calculateKey(key, 3);

        cipherText = applyShift(operatedText, shiftKey);

        operatedText = performOperation(cipherText, yy);
        
        System.out.println(" Encrypted text: "+operatedText);
        return operatedText;

    }

    public static void main(String[] args) {
        //  encrypt oba = new encrypt();

    }

}
