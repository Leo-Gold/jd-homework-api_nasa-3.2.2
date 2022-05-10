import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        CloseableHttpResponse nasaResponse = httpClient(Const.URL.getItem());
        ObjectMapper mapper = new ObjectMapper();
        Nasa nasaData = mapper.readValue(nasaResponse.getEntity().getContent(), Nasa.class);
        CloseableHttpResponse urlResponse = httpClient(nasaData.getUrl());

        System.out.println("The response is saved in a file " + saveResponse(nasaData.getUrl(), urlResponse));
        if (nasaData.getMedia_type().equals(Const.TYPEFILEIMAGE.getItem())) {
            System.out.println("The image is saved in a file " + saveImage(nasaData.getUrl()));
        }
    }

    private static CloseableHttpResponse httpClient(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build();
        HttpGet request = new HttpGet(url);
        return httpClient.execute(request);
    }

    private static String saveResponse(String url, CloseableHttpResponse text) {
        String result = null;
        byte[] byteText = String.valueOf(text).getBytes();
        File fileUrl = new File(url);
        String[] arrayName = fileUrl.getName().split("\\.");
        String name = arrayName[arrayName.length - 2] + Const.FILEEXTENSIONTXT.getItem();
        File file = new File(name);
        checkFiles(fileUrl);
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write(byteText);
            result = file.getName();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return result;
    }

    private static String saveImage(String url) {
        String result = null;
        File fileUrl = new File(url);
        try (InputStream input = new URL(url).openStream()) {
            Files.copy(input, Paths.get(fileUrl.getName()));
            result = fileUrl.getName();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static boolean checkFiles(File url) {
        boolean result = false;
        File file = new File(url.getName());
        if (file.isFile()) {
            file.delete();
            result = true;
        }
        return result;
    }
}
