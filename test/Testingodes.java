/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.File;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
/**
 *
 * @author lebog
 */
public class Testingodes { 
    
        public enum Months{
          january(1),february(2),march(3),april(4);
          
          private int value;
          private Months(int value){
              this.value = value;
          }
        
        };
    
    public static void main(String[] args) {
        
//               int input = JOptionPane.showConfirmDialog(null, 
//                "Click ok if you are ok", "Be ok!", JOptionPane.DEFAULT_OPTION);
//        // 0=ok
//        System.out.println(input);


        String key = "Mary has one cat1";
        File inputFile = new File("document.txt");
        File encryptedFile = new File("document.encrypted");
        File decryptedFile = new File("document.decrypted");
         
        try {
            CryptoUtils.encrypt(key, inputFile, encryptedFile);
            CryptoUtils.decrypt(key, encryptedFile, decryptedFile);
        } catch (CryptoException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

       
    }
    
}
