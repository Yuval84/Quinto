import javax.swing.*;
import java.awt.*;

/**
 * Created by yuval_edelman on 4/26/2015.
 */
public class Main {
    public static void main(String[] args) {
        Container c=new Container();
        int row,column;

        row=Integer.parseInt(JOptionPane.showInputDialog("enter row value:"));
        column=Integer.parseInt(JOptionPane.showInputDialog("enter column value:"));
        Color initialcolor=Color.RED;
        Color color1=JColorChooser.showDialog(c,"FIRST COLOR",initialcolor);
        Color color2=JColorChooser.showDialog(c,"SECOND COLOR",initialcolor);
        Quinto q=new Quinto(row,column,color1,color2);
        q.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        q.setSize(800,800);
        q.setVisible(true);

    }
}
