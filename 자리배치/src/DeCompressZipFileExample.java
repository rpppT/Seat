import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
 
public class DeCompressZipFileExample {
 
    public void Extract() throws Exception {
        String zipFile = System.getProperty("user.home")+"\\JavaAppData.zip";
        
        String outputFolder = System.getProperty("user.home");
 
        ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
        ZipEntry ze = zis.getNextEntry();
        while(ze!=null){
            String entryName = ze.getName();
            File f = new File(outputFolder + File.separator +  entryName);
            //create all folder needed to store in correct relative path.
            f.getParentFile().mkdirs();
            FileOutputStream fos = new FileOutputStream(f);
            int len;
            byte buffer[] = new byte[1024];
            while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
            fos.close();   
            ze = zis.getNextEntry();
        }
        zis.closeEntry();
        zis.close();


		try {
			Main.imagePanel.removeAll();
			Main.imagePanel.revalidate();
			Main.imagePanel.repaint();
			BufferedImage deskImage = ImageIO.read(new File(System.getProperty("user.home")+"//JavaAppData//교탁.png"));
			JLabel label = new JLabel(new ImageIcon(deskImage));
			Main.imagePanel.add(label);
			JButton button = new JButton("폰트 크기");
			button.addActionListener(new Change_Font_Malloc_ActionListener());
			button.setPreferredSize(new Dimension(100, 100));
			Main.imagePanel.add(button);
			Main.imagePanel.revalidate();
			Main.imagePanel.repaint();
		} catch (IOException ee) {
		 }
    }
}
