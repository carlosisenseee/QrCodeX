package util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Gerar {
    public static void gerarQrCode(int id_pedido, int id_fornecedor) {
        String conteudo = String.format("{\"id_pedido\": %d, \"id_fornecedor\": %d}", id_pedido, id_fornecedor);
        int largura = 150;
        int altura = 150;

        LocalDate hoje = LocalDate.now();
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatadorCompleto = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String dataHoraFormatada = agora.format(formatadorCompleto);

        String caminhoArquivo = "qrcodes/qrcode" + id_pedido + id_fornecedor + dataHoraFormatada + ".png";
        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        try {
            BitMatrix bitMatrix = qrCodeWriter.encode(conteudo, BarcodeFormat.QR_CODE, largura, altura);
            Path caminho = FileSystems.getDefault().getPath(caminhoArquivo);
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", caminho);
            System.out.println("gerado");
        } catch (WriterException | IOException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
