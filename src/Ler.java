import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Ler {
    public static void lerQrCode() {
        try {
            // Carrega a imagem do QR code
            File arquivoImagem = new File("qrcodes/qrcode1120250728103351.png");
            BufferedImage bufferedImage = ImageIO.read(arquivoImagem);

            // Converte a imagem em uma fonte de luminância, necessária para o ZXin
            BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            // Decodifica o Qr Code
            Result resultado = new MultiFormatReader().decode(bitmap);

            //Exibe o conteudo
            System.out.println("Conteudo do Qr code: " + resultado.getText());
        } catch (
                IOException e) {
            System.err.println("Erro ao carregar a imagem: " + e.getMessage());
        } catch (
                NotFoundException e) {
            System.err.println("Nenhum QR Code encontrado na imagem.");
        }
    }
}
