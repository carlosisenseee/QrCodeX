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
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.nio.file.FileSystems;
import java.nio.file.Path;


public class Main {
    public static void main(String[] args) {
        String conteudo = "https://youtube.com.br";
        int largura = 300;
        int altura = 300;
        String caminhoArquivo = "qrcode.png";

        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        try {
            BitMatrix bitMatrix = qrCodeWriter.encode(conteudo, BarcodeFormat.QR_CODE, largura, altura);
            Path caminho = FileSystems.getDefault().getPath(caminhoArquivo);
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", caminho);
            System.out.println("gerado");
        } catch (WriterException | IOException e) {
            System.err.println("Erro: " + e.getMessage());
        }

        try {
            // Carrega a imagem do QR code
            File arquivoImagem = new File("qrcode.png");
            BufferedImage bufferedImage = ImageIO.read(arquivoImagem);

            // Converte a imagem em uma fonte de luminância, necessária para o ZXin
            BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            // Decodifica o Qr Code
            Result resultado = new MultiFormatReader().decode(bitmap);

            //Exibe o conteudo
            System.out.println("Conteudo do Qr code: " + resultado.getText());
        } catch (IOException e) {
            System.err.println("Erro ao carregar a imagem: " + e.getMessage());
        } catch (NotFoundException e) {
            System.err.println("Nenhum QR Code encontrado na imagem.");
        }
    }
}