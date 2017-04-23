import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by yuval_edelman on 4/26/2015.
 */
public class Quinto extends JFrame implements MouseListener   {
    static Button matrix [][] ;//the game bord
    Container container;
    static Color color1,color2; //the colors of the user choice
    private GridLayout gridLayout;
    JPanel panel;
    JButton clear; //clear button


    public Quinto(int row,int column,Color color1,Color color2){
        super("Quinto");
        gridLayout=new GridLayout(row,column);
        container=getContentPane();
        this.color1=color1;
        this.color2=color2;
        matrix=new Button[row][column];
        panel=new JPanel();
        clear=new JButton("CLEAR");
        panel.setLayout(gridLayout);
        panel.setSize(600,600);
        setGrid();
        add(panel);
        add(clear,BorderLayout.SOUTH);
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearMatrix();
            }
        });
    }

    private void setGrid(){ //set the matrix to begin the game
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                Button button=new Button(color1,i,j); //the user color!!!
                matrix[i][j]=button;
                panel.add(matrix[i][j]);

            }
        }
    }
    public static void clickTheButton(int row,int column){ //paint the cells after the user click
        switch (inBound(row,column)){
            case 1:
                matrix[row-1][column].setColor(color1,color2);
                matrix[row][column-1].setColor(color1,color2);
                matrix[row][column+1].setColor(color1,color2);
                matrix[row+1][column].setColor(color1,color2);
                break;

            case 2:
                matrix[row][column-1].setColor(color1,color2);
                matrix[row][column+1].setColor(color1,color2);
                matrix[row+1][column].setColor(color1,color2);
                break;

            case 3:
                matrix[row-1][column].setColor(color1,color2);
                matrix[row][column-1].setColor(color1,color2);
                matrix[row][column+1].setColor(color1,color2);
                break;

            case 4:
                matrix[row-1][column].setColor(color1,color2);
                matrix[row][column+1].setColor(color1,color2);
                matrix[row+1][column].setColor(color1,color2);
                break;

            case 5:
                matrix[row-1][column].setColor(color1,color2);
                matrix[row][column-1].setColor(color1,color2);
                matrix[row+1][column].setColor(color1,color2);
                break;

            case 6:
                matrix[row][column+1].setColor(color1,color2);
                matrix[row+1][column].setColor(color1,color2);
                break;

            case 7:
                matrix[row-1][column].setColor(color1,color2);
                matrix[row][column-1].setColor(color1,color2);
                break;

            case 8:
                matrix[row][column-1].setColor(color1,color2);
                matrix[row+1][column].setColor(color1,color2);
                break;

            case 9:
                matrix[row-1][column].setColor(color1,color2);
                matrix[row][column+1].setColor(color1,color2);
                break;

            default:
                break;
        }

        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (!matrix[i][j].isOn){ //if even one button is "off" the the game continue
                    return;
                }
            }
        }
        JOptionPane.showMessageDialog(null,"WELL DONE");//the game is complete!
        System.exit(0); //exit the program
    }



    private static   void clearMatrix(){ //clearing the matrix
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                matrix[i][j].setBackground(color1);
                matrix[i][j].isOn=false;

            }
        }

    }

    private static int inBound(int row,int column){
        if (row>0 && row<matrix.length-1 && column>0 && column<matrix[0].length-1) { //all the buttons are in bound
            return 1;
        }
        if (row==0 && column>0 && column<matrix[0].length-1) { //the button is in the first upper row
            return 2;
        }
        if (row==matrix.length-1 && column>0 && column<matrix[0].length-1){ //the button is in the last lower rwo
            return 3;
        }
        if (column==0 && row>0 && row<matrix.length-1){//the button is in first column to the left
            return 4;
        }
        if (column==matrix[0].length-1 && row>0 && row<matrix.length-1){ //the button is in the last column to the right
            return 5;
        }
        if (row==0 && column==0){ //the button is in left upper coroner
            return 6;
        }
        if (row==matrix.length-1 && column==matrix[0].length-1){//the button is in right lower coroner
            return 7;
        }
        if (row==0 && column==matrix[0].length-1) {//the button is in right upper coroner
            return 8;
        }
        if (row==matrix.length-1 && column==0){//the button is in left lower coroner
            return 9;
        }
        return 0;//not in bound
    }







    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.print("clear");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


















}
