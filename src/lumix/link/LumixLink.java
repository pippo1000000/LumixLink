package lumix.link;
import java.awt.KeyboardFocusManager;
import java.io.IOException;

public class LumixLink  {  
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException
    {
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new Dispatcher());
        GUI gui = new GUI();
        gui.setVisible(true);
    }       
}