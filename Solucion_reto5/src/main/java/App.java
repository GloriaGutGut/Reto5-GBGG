import vista.VistaRequerimientos;
import java.awt.EventQueue;

/* Esta clase solo se debe usar para hacer pruebas locales, no se debe subir en iMaster */
public class App {
    public static void main( String[] args )
    {
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                try{
                    VistaRequerimientos frame = new VistaRequerimientos();
                    frame.setVisible(true);
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
