import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Classe utilitária para geração de hash SHA-1
public class HashUtils {

    // Construtor privado para impedir instanciação
    private HashUtils() {
    }

    // Gera SHA-1 de uma string
    public static String sha1(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Algoritmo SHA-1 não disponível.", e);
        }
    }

    // Converte array de bytes em hexadecimal
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();

        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);

            // Se tiver apenas 1 caractere, completa com zero à esquerda
            if (hex.length() == 1) {
                hexString.append('0');
            }

            hexString.append(hex);
        }

        return hexString.toString();
    }
}