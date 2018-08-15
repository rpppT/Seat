import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Notepad 
{

	public void OpenManualFile() {
		try {
			File file  = new File(System.getProperty("user.home")+"\\JavaAppData\\manual.txt");
			
			if(file.exists())
			Desktop.getDesktop().edit(file);
			else
			 JOptionPane.showMessageDialog(null, "Maual 파일이 존재하지 않음.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
