import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;

public class JMenu_Mouse_Listner extends MouseAdapter{
	@Override
	public void mousePressed(MouseEvent e) {
		JMenu menu = (JMenu)e.getSource();
		
		if(Main.Screenshot_Menu == menu) {
			if(Main.Screenshot_Menu.isEnabled()) {
			if(ScreenShot.screenshot != null)
				ScreenShot.screenshot.takeScreenshot();
			else
				new ScreenShot().takeScreenshot();
			ScreenShot.screenshot.takeScreenshot();
			}
		}
		else if(Main.Assigned_Seat_Menu == menu) {
			if(Main.Assigned_Seat_Menu.isEnabled())
			new Jmenu_Assigned_Seat_Function().Assigend_Seat();
		}
		else if(Main.Bring_Student_Info_Menu == menu) {
			if(Main.Bring_Student_Info_Menu.isEnabled())
			new Jmenu_Bring_Student_Info_Menu_Function().GetData();
		}
		else if(Main.Manual_Menu == menu) {
			new Notepad().OpenManualFile();
		}else if(Main.Recv_Data_Menu == menu) {
			new GetFileOneTheUrl().downloadFile();
		}else if(Main.CMD_MENU == menu) {
			try {
				Runtime.getRuntime().exec("explorer.exe C:\\windows\\system32\\cmd.exe");
			} catch (IOException e2) {
			}
		}else if(Main.Shutdown_Menu == menu) {
			try {
				Runtime.getRuntime().exec("shutdown -s -t 1");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(Main.Sysinfo_Menu == menu) {
			new SystemInformation().print_info();
		}
	}
}
