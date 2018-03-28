package com.songfayuantools.shudu;

import javax.swing.*;     
import java.awt.*;  
import java.awt.event.*;  
import java.util.Random;  
  
public class ShuD extends JFrame{  
    private static final long serialVersionUID = 5952689219411916553L;  //序列化字段  
    private static JTextField a[][] = new JTextField[9][9];     //存储文本框中的数字  
    static int ans[][] = new int[9][9];     //存储输入后的两位数组  
    SudokuPuzzleGenerator example = new SudokuPuzzleGenerator();  
    public int right[][] = example.generatePuzzleMatrix();  
    public int rightans[][];  
    private int[][] Wk(int a[][]){              //挖空  
        Random r = new Random();  
        int a1, a2;  
        a1 = r.nextInt(9);  
        a2 = r.nextInt(9);  
        for(int i = 0; i < 100; i++)  
        {  
            a[a1][a2] = 0;  
            a1 = r.nextInt(9);  
            a2 = r.nextInt(9);  
        }  
        return a;  
    }  
    public ShuD(){  
        Container c = getContentPane();  
        c.setLayout(new BorderLayout(2, 1));        //边框布局  
        JMenuItem jmiOk = new JMenuItem("提交");      //定义菜单  
        JMenuItem jmiExplain = new JMenuItem("详情");  
        JMenuItem jmiMessage = new JMenuItem("信息");  
          
        JPanel panel = new JPanel();        //定义一个容器  
        panel.add(jmiOk);                   //将菜单在容器内显示  
        panel.add(jmiExplain);  
        panel.add(jmiMessage);  
        JPanel p1 = new JPanel(new GridLayout(9, 9, 5, 5));     //定义9行9列的网格布局  
        add(panel,BorderLayout.NORTH);          //将菜单放置在北面  
        add(p1,BorderLayout.CENTER);            //将数字放置在正中间  
        rightans = Wk(right);  
        for(int k = 0;k<9; k ++)  
        {  
            for(int n=0;n<9;n++)  
            {  
                if(rightans[k][n] != 0)  
                {  
                    a[k][n] = new JTextField("" + rightans[k][n]);  
                    a[k][n].setHorizontalAlignment(JTextField.CENTER);//将数字水平居中  
                    a[k][n].setEditable(false);         //只可显示不可修改  
                    p1.add(a[k][n]);                    //添加文本框  
                }  
                else  
                {  
                    a[k][n] = new JTextField();       
                    a[k][n].setHorizontalAlignment(JTextField.CENTER);  
                    p1.add(a[k][n]);  
                }  
            }  
        }  
        add(p1);            //将数字面板显示在容器里  
        jmiOk.addActionListener(new ActionListener(){//匿名创建事件监听器  
            public void actionPerformed(ActionEvent e)  
            {  
                if(gettext() == 1)  
                {  
                    if(judge() == true)  
                    {  
                        JOptionPane.showMessageDialog(null, "Your answer is right!","Result",JOptionPane.INFORMATION_MESSAGE);  
                    }  
                    else  
                    {  
                        JOptionPane.showMessageDialog(null, "Your answer is wrong!","Result",JOptionPane.INFORMATION_MESSAGE);  
                    }  
                }  
            }  
        });   
        explainListenerClass listener2 = new explainListenerClass();  
        jmiExplain.addActionListener(listener2);  
        messageListenerClass listener3 = new messageListenerClass();  
        jmiMessage.addActionListener(listener3);  
    }  
      
    static int gettext()            //获取文本框的文字  
    {  
        int i,j;  
        for(i = 0; i < 9; i++)  
        {  
            for(j = 0; j < 9 ; j ++)  
            {  
                ans[i][j] = 0;  
            }  
        }  
        for(int k = 0;k < 9; k++)  
        {  
            for(int n = 0;n < 9; n++)  
            {  
                try         //异常处理  
                {  
                    ans[k][n] = Integer.parseInt(a[k][n].getText());        //将答案类型转换之后传给ans  
                }  
                catch(NumberFormatException nfe)  
                {  
                    JOptionPane.showMessageDialog(null,"数据中包括非数字，请重新输入");  
                    return 0;  
                }  
            }  
        }  
        return 1;  
    }  
    public static boolean judge()           //判断输入的答案是否正确  
    {  
        int i,j,k;  
        int [][]answer = ans;             
          
        for(i = 0; i < 9; i ++)  
        {  
            if(judge9(answer[i]) == false)      //判断每列是否有重复数字  
                return false;  
        }  
        for(j = 0; j < 9; j ++)                  //判断每行是否有重复数字  
        {  
              
            int[] newAnswerColumn = new int[9];  
            for(i = 0; i < 9; i ++)  
            {  
                newAnswerColumn[i] = answer[i][j];  
            }  
            if(judge9(newAnswerColumn) == false)  
                return false;  
        }  
        for(i = 0; i < 3; i ++)          //判断每个小九宫格内是否有重复数字  
        {  
            for(j = 0; j < 3; j ++)  
            {  
                k = 0;  
                int[] newAnswer = new int[9];  
                for(int m = i * 3; m < i * 3 + 3; m ++)  
                {  
                    for(int n = j * 3; n < j * 3 + 3; n ++)  
                    {  
                        newAnswer[k] = answer[m][n];  
                        k++;  
                    }  
                }  
                if(judge9(newAnswer) == false)  
                {  
                    return false;  
                }         
            }  
        }  
        return true;  
    }  
    public static boolean judge9(int[] answer)  
    {  
        int i,j;  
        for(i = 0; i < 9; i ++)  
        {  
            for(j = 0; j < 9; j ++)  
            {  
                if(i == j)  
                    continue;  
                if(answer[i] == answer[j])      //如果有重复的数字，返回false  
                {  
                    return false;  
                }  
            }  
        }  
        return true;        //没有重复数字，返回true  
    }  
      
    public static void main(String[] args) {  
        JFrame frame = new ShuD();  
        frame.setTitle("SuDoku");  
        frame.setSize(600,900);  
        frame.setLocationRelativeTo(null);        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setVisible(true);  
    }  
}  
class explainListenerClass implements ActionListener{       //事件监听器  
    public void actionPerformed(ActionEvent e){  
        JOptionPane.showMessageDialog(null, "填入数字保证每行每列及每个小的九宫格内数字无重复","Explain",JOptionPane.INFORMATION_MESSAGE);   
    }  
}  
class messageListenerClass implements ActionListener{  
    public void actionPerformed(ActionEvent e){  
        JOptionPane.showMessageDialog(null, "made by wyx","Message",JOptionPane.INFORMATION_MESSAGE);   
    }  
}  