import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;

public class JMenu_Mouse_Listner extends MouseAdapter{
	
	@Override
	public void mousePressed(MouseEvent e) {
		JMenu menu = (JMenu)e.getSource();
		
		if(Main.Screenshot_Menu == menu) {
			ScreenShot.screenshot.takeScreenshot();	
		   }
		else if(Main.Assigned_Seat_Menu == menu) {
			if(Main.Assigned_Seat_Menu.isEnabled())
			  new Jmenu_Assigned_Seat_Function().Assigend_Seat();
		}
		else if(Main.Bring_Student_Info_Menu == menu) {
			if(Main.Bring_Student_Info_Menu.isEnabled())
			new Jmenu_Bring_Student_Info_Menu_Function().GetData();
		}else if(Main.goBackward_Menu == menu) {
			GoToFowardAndBackWard.BackWard();
		}else if(Main.goFowarRd_Menu == menu) {
			GoToFowardAndBackWard.Foward();
		}else if(Main.fontConfig_Menu == menu){
			ChangeFont.chfont.visbile();
		}
	}
}
