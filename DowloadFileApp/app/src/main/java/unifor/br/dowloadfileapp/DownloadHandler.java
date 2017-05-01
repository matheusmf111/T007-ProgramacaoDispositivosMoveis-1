package unifor.br.dowloadfileapp;

import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DowloadHandler {

    private static final int EOF = -1;

    public boolean downloadFile(String urlToDownload){

        boolean result = false;

        try {

            // Realiza a conexão com o servidor que contém o arquivo
            URL url = new URL(urlToDownload);
            URLConnection connection = url.openConnection();
            connection.connect();

            // Recupera o tamanho do arquivo a ser baixado
            int fileLength = connection.getContentLength();

            // Recuperando as streams de dados
            InputStream in = connection.getInputStream();

            // Criando um nome genérico para o arquivo
            StringBuilder fileName = new StringBuilder();
            fileName.append(Environment.DIRECTORY_DOWNLOADS);
            fileName.append("/");
            fileName.append(System.currentTimeMillis());

            OutputStream out = new FileOutputStream(fileName.toString(), false);

            // Criando o buffer de armazenamento temporário, o contador do total
            // de bytes baixados e o contador parcial de bytes baixados
            byte[] buffer = new byte[1024];
            int total = 0;
            int count;

            while((count = in.read(buffer)) != EOF){

                // Atualiza o contador do total de bytes baixados
                total += count;

                //TODO: Enviar para a activty a porcentagem do progresso do download

                out.write(buffer);

            }

            out.flush();
            out.close();
            in.close();

            result = true;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return result;
    }

}
