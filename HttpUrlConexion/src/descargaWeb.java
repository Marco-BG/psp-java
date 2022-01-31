import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

public class descargaWeb {

	public static void main(String[] args) throws IOException {

		String url = "https://wikipedia.org/";
		URL objetoUrl = new URL(url);
		URLConnection conexionURL = objetoUrl.openConnection();
		HttpURLConnection httpURLConexion = (HttpURLConnection) objetoUrl.openConnection();
		
		System.out.println("El servidor devuelve el siguiente metodo => "+httpURLConexion.getResponseCode());
		
		BufferedInputStream lectorURL = new BufferedInputStream(objetoUrl.openStream());
		
		byte[] buffer = new byte[2048];
		int byteLeido = lectorURL.read(buffer);
		
		while(byteLeido != -1) {
			System.out.println(new String(buffer));
			byteLeido = lectorURL.read(buffer);
		}
	}
}
