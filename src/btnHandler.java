
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class btnHandler implements ActionListener
{
    GUI refg;
    double num1;//Double.parseDouble(string1);
    double num2;
    String str1,str2;
    String op;
    String input;
    String result;
    int pm;
    int equal;
    public btnHandler(GUI gg) {
        this.refg = gg;
        num1 = 0;
        num2 = 0;
        str1 = "";
        str2= "";
        op = "";
        input = "";
        result="";
        pm=0;
        equal = 0;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String btnText = e.getActionCommand();
        
        if(btnText.equals("1")||btnText.equals("2")||btnText.equals("3")||btnText.equals("4")||btnText.equals("5")
                ||btnText.equals("6")||btnText.equals("7")||btnText.equals("8")||btnText.equals("9")||btnText.equals("0")||(btnText.equals(".")))
        {
            if(refg.tfMain.getText().length() <= 14)
            {
              if(refg.tfSub.getText().contains("="))
              {
                  //donothing 
              }
              else if((refg.tfMain.getText().equals("Infinity!"))||(refg.tfMain.getText().equals("Undefind")))
              {
                  refg.tfSub.setText("");
                  refg.tfMain.setText(""+btnText);
              }
              else if((refg.tfMain.getText().equals("0")) && !(btnText.equals(".")))
                   refg.tfMain.setText(""+btnText);
              else if((!refg.tfMain.getText().isEmpty())&&(refg.tfMain.getText().contains("."))&&!(btnText.equals(".")))
                   refg.tfMain.setText(refg.tfMain.getText()+btnText);
              else if((btnText.equals(".")) && (refg.tfMain.getText().isEmpty()))
                   refg.tfMain.setText("0"+refg.tfMain.getText()+btnText);
              else if (!(refg.tfMain.getText().isEmpty())&&(refg.tfMain.getText().endsWith("."))&&!(btnText.equals(".")))
                   refg.tfMain.setText(refg.tfMain.getText()+btnText);
              else if(!(refg.tfMain.getText().isEmpty())&&(!(refg.tfMain.getText().contains("."))) && (btnText.equals(".")))
                   refg.tfMain.setText(refg.tfMain.getText()+btnText);
              else if ((!btnText.equals(".")))
                   refg.tfMain.setText(refg.tfMain.getText()+btnText);
            }
          
        }
        else if(btnText.equals("+")||btnText.equals("-")||btnText.equals("÷")||btnText.equals("×"))
        {
            if((refg.tfMain.getText().equals("Infinity!"))||(refg.tfMain.getText().equals("Undefind")))
            {
                //donothing
            }
            else if(!(refg.tfMain.getText().isEmpty())&&(refg.tfMain.getText().charAt(refg.tfMain.getText().length()-1) == '.'))
            {
                //donothing
            }
            else if(!(refg.tfMain.getText().isEmpty()) && (refg.tfSub.getText().isEmpty()))
            {
                input = refg.tfMain.getText();  
                str1 =input;
                num1 = Double.parseDouble(input);
                refg.tfSub.setText(refg.tfMain.getText() + btnText);
                refg.tfMain.setText("0");
                op = btnText;
            }
            else if(!(refg.tfMain.getText().isEmpty()) && (refg.tfSub.getText().charAt(refg.tfSub.getText().length()-1) == '='))
            {
                input = refg.tfMain.getText();    
                str1 =input;
                num1 = Double.parseDouble(input);
                refg.tfSub.setText(refg.tfMain.getText() + btnText);
                refg.tfMain.setText("0");
                op = btnText;
            }
             else if((!refg.tfSub.getText().isEmpty())&&(refg.tfMain.getText().equals("0"))&& 
                     ((refg.tfSub.getText().charAt(refg.tfSub.getText().length()-1) == '+')||(refg.tfSub.getText().charAt(refg.tfSub.getText().length()-1) == '-')||(refg.tfSub.getText().charAt(refg.tfSub.getText().length()-1) == '×')||(refg.tfSub.getText().charAt(refg.tfSub.getText().length()-1) == '÷')))
            {
                refg.tfSub.setText(str1+btnText);
                op = btnText;
            }
        }
         else if(btnText.equals("+/-"))
        {
            String s = refg.tfMain.getText();
            if((refg.tfMain.getText().equals("Infinity!"))||(refg.tfMain.getText().equals("Undefind")))
            {
                //donothing
            }
            else if(s.isEmpty()||s.equals("0"))
            {
                //donothing
            }
            else if(refg.tfSub.getText().contains("="))
            {
                //donothing
            }
            else if(!(s.isEmpty()) && (s.charAt(0) == '-')){
                 s = s.substring(1);
                 pm = 1;
            }
            else 
            {
                s = "-" + s;
                pm = 1;
            }
            refg.tfMain.setText(s);
        }
        else if(btnText.equals("="))
        { 
           
            if(refg.tfMain.getText().equals("Infinity!") || refg.tfMain.getText().equals("Undefind"))
            {
                //donothing
            }
            else 
            {
                 double val = Double.parseDouble(refg.tfMain.getText());
                 if(!(refg.tfSub.getText().isEmpty()) && num1 != 0)
                {
                   input = refg.tfMain.getText();
                   str2 =input;
                   num2 = Double.parseDouble(input);
                   if(pm==1)
                        refg.tfSub.setText(str1 + op +"(" +refg.tfMain.getText()+")"+ btnText);
                   else
                    refg.tfSub.setText(str1 + op +refg.tfMain.getText()+ btnText);
                    operation();
                    equal = 1;
                }
                else if(refg.tfSub.getText().isEmpty() && Double.parseDouble(refg.tfMain.getText()) == 0 && refg.tfMain.getText().contains(".")  ) 
                {
                      //donothing
                }
                else if(!(refg.tfSub.getText().isEmpty()) && num1 == 0)
                {
                   input = refg.tfMain.getText();
                   str2 =input;
                   num2 = Double.parseDouble(input);
                   if(pm==1)
                        refg.tfSub.setText(str1 + op +"(" +refg.tfMain.getText()+")"+ btnText);
                   else
                    refg.tfSub.setText(str1 + op +refg.tfMain.getText()+ btnText);
                    operation();
                    equal = 1;
                }
                else if(refg.tfMain.getText().isEmpty())
                {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
                   if(pm==1)
                        refg.tfSub.setText(str1 + op +"(" +refg.tfMain.getText()+")"+ btnText);
                   else
                       refg.tfSub.setText(str1 + op +refg.tfMain.getText()+ btnText);
                    operation();
                    equal = 1;
                }
                else if(refg.tfMain.getText().equals("0")&& refg.tfSub.getText().isEmpty() || val == 0)
                    refg.tfSub.setText(0+ btnText);
                else if((refg.tfSub.getText().isEmpty()&& (!refg.tfMain.getText().equals("0"))&&(refg.tfMain.getText().charAt(refg.tfMain.getText().length()-1) != '.')))
                    refg.tfSub.setText(refg.tfMain.getText()+ btnText);
               else if (!refg.tfSub.getText().isEmpty()&& refg.tfMain.getText().equals("0")&& (!refg.tfSub.getText().contains("=")))
                {
                    num2 = num1;
                    refg.tfSub.setText(str1 + op +refg.tfMain.getText()+ btnText);
                    operation();
                    equal = 1;
                }
                if(!(refg.tfMain.getText().isEmpty())&&(refg.tfMain.getText().charAt(refg.tfMain.getText().length()-1) == '.'))
                {
                    //donothing
                }

            }
        }
            else if(btnText.equals("C"))
            {
                 refg.tfMain.setText("" + "0");
                 refg.tfSub.setText("");
            }

            else if(btnText.equals("CE"))
            {
                if(!refg.tfSub.getText().contains("=")&&(refg.tfSub.getText().contains("+")||refg.tfSub.getText().contains("-")||refg.tfSub.getText().contains("×")||refg.tfSub.getText().contains("÷")))
                {
                    refg.tfMain.setText("" + "0");
                }
                else if(refg.tfSub.getText().isEmpty())
                {
                    refg.tfMain.setText("" + "0");
                }
                else if(refg.tfSub.getText().contains("="))
                {
                    refg.tfMain.setText("" + "0");
                    refg.tfSub.setText("");
                }
            }
        else if(btnText.equals("←"))
        {
            if(refg.tfMain.getText().equals("0"))
            {
                //doNothing
            }
            else if((!refg.tfSub.getText().isEmpty())&&(!refg.tfMain.getText().equals("0"))&&(equal==1))
            {
                //doNothing
            }
            else if(refg.tfMain.getText().length()!=0 && equal == 1)
                refg.tfSub.setText("");
            else if((refg.tfMain.getText().length()!=0 && equal == 1 && refg.tfSub.getText().isEmpty()) 
                    ||((refg.tfMain.getText().isEmpty())&&((refg.tfSub.getText().isEmpty())||
                    ((refg.tfSub.getText().charAt(refg.tfSub.getText().length()-1) == '+')||
                    (refg.tfSub.getText().charAt(refg.tfSub.getText().length()-1) == '-')||(refg.tfSub.getText().charAt(refg.tfSub.getText().length()-1) == '×')||(refg.tfSub.getText().charAt(refg.tfSub.getText().length()-1) == '÷')))))
            {
                //doNothing
            }
            else if(refg.tfMain.getText().length() !=0 && Double.parseDouble(refg.tfMain.getText()) < 0 )
            {
                if(refg.tfMain.getText().length()==2)
                    refg.tfMain.setText(""+refg.tfMain.getText().substring(0, refg.tfMain.getText().length() - 2));
                else
                    refg.tfMain.setText(""+refg.tfMain.getText().substring(0, refg.tfMain.getText().length() - 1));
            }
            else
                refg.tfMain.setText(""+refg.tfMain.getText().substring(0, refg.tfMain.getText().length() - 1));
            if(refg.tfMain.getText().isEmpty())
                   refg.tfMain.setText("0");
        }
       
    }
    
    public void operation()
    {
        switch(op)
        {
            case "+":
                if((num1+num2) == (int)(num1+num2))
                    result = String.valueOf((int)(num1+num2));
                else if((num1+num2) == (double)(num1+num2))
                    result = String.valueOf((double)(num1+num2));
                    refg.tfMain.setText(result);
                break;
            case "-":
                if((num1-num2) == (int)(num1-num2))
                    result = String.valueOf((int)(num1-num2));
                else if((num1-num2) == (double)(num1-num2))
                    result = String.valueOf((double)(num1-num2));
                refg.tfMain.setText(result);
                break;
            case "÷":
               if(num2 == 0 && num1!=0)
               {
                    refg.tfMain.setText("Infinity!");
               }
               else if(num2==0&&num1==0)
               {
                   refg.tfMain.setText("Undefind");
               }
               else
               {
                   if((num1/num2) == (int)(num1/num2))
                       result = String.valueOf((int)(num1/num2));
                   else if((num1/num2) == (double)(num1/num2))
                       result = String.valueOf((double)(num1/num2));
                   refg.tfMain.setText(result);
               }
                break;
            case "×":
                 if((num1*num2) == (int)(num1*num2))
                    result = String.valueOf((int)(num1*num2));
                else if((num1*num2) == (double)(num1*num2))
                    result = String.valueOf((double)(num1*num2));
                refg.tfMain.setText(result);
                break;
        }
    }
}
