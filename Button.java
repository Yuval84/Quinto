import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by yuval_edelman on 4/26/2015.
 */
public class Button extends JButton implements MouseListener  {
    Color color;
    boolean isOn; //  on/of for the button
    int x,y; //place in the matrix



    public Button(Color c,int x,int y){
        color=c;
        isOn=false;
        this.x=x;
        this.y=y;
        setBackground(color);
        addMouseListener(this);
        setBackground(c);

    }

    public void setColor(Color a,Color b){
        if(!isOn) { //if the button is "off"
            isOn=true;
            setBackground(b);
            color = b;
        }else{       //if the button is "on"
            isOn=false;
            setBackground(a);
            color = a;
        }
    }

    public boolean isColor(Color c){
        if (c==color){
            return true;
        }
        return false;
    }

     @Override
     public void mouseClicked(MouseEvent e) {
          Quinto.clickTheButton(x, y);
        }
     @Override
     public void mousePressed(MouseEvent e) {}
     @Override
     public void mouseReleased(MouseEvent e) {}
     @Override
     public void mouseEntered(MouseEvent e) {}
     @Override
     public void mouseExited(MouseEvent e) {}




}
