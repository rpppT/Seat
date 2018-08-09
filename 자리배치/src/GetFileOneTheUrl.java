import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;


public class GetFileOneTheUrl {
	public void downloadFile() {

		OutputStream output = null;
		URLConnection con = null;
		InputStream input  = null;
		
		String fileName = System.getProperty("user.home")+"\\JavaAppData.zip";
		int data;
		final int size = 50000;
		try {
//			URL url = new URL("https://drive.google.com/uc?authuser=0&id=1XDqOVpfeJNTmZg9yhlRkywvXAZt7VYtt&export=download");
			URL url = new URL("https://drive.google.com/uc?export=download&id=1lsIZo6gdVLg_epNXWEf6V1QdJNkHn0_N");
			byte [] buf;

			
			output = new BufferedOutputStream(new FileOutputStream(fileName));
			con = url.openConnection();
			input = con.getInputStream();
			
			buf = new byte[size];
			
			
			while((data = input.read(buf)) != -1) {
				output.write(buf, 0, data);
			}
//			
			output.close();
			input.close();
			
			new DeCompressZipFileExample().Extract();
		}catch(Exception e) {
			
		}
	}
}
