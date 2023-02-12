package org.example;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.net.URI;
import java.nio.charset.StandardCharsets;

public class HttpClientUtils {
    public static void main(String[] args) {
        String post = HttpClientUtils.doPost("https://www.baidu.com");
        System.out.println(post);
    }

    public static String doPost(String url) {
        String result = "";
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            URIBuilder builder = new URIBuilder(url);
            builder.addParameter("aa", "bb");
            URI uri = builder.build();

            HttpPost request = new HttpPost(uri);
            response = client.execute(request);
            if (response.getStatusLine().getStatusCode() == 200) {
                result = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                client.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}