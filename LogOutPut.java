/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Yusuke
 */
public class LogOutPut {

    static public void writeLog(Member m) {
        try {
            File file = new File("C:\\android\\Log.txt");
            FileWriter filewriter = new FileWriter(file,true);
            filewriter.write(m.name + ":" + String.valueOf(m.isThisLoop) + "\r\n");
            filewriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    static public void writeLog(ArrayList<Member> m, int x) {
        try {
            String tmpS1 = "";

            for (int i = 0; i < m.size(); i++) {
                Member tmpM = m.get(i);
                tmpS1 += tmpM.name +":";

                if (!tmpM.ecsperiencedTasks.isEmpty()) {
                    for (int j = 0; j < tmpM.ecsperiencedTasks.size(); j++) {
                        tmpS1 += tmpM.ecsperiencedTasks.get(j) + ",";
                    }
                }

                tmpS1 += "\r\n";
                tmpS1 += String.valueOf(tmpM.isThisLoop) + "\r\n \r\n";
            }

            File file = new File("C:\\android\\Log.txt");
            FileWriter filewriter = new FileWriter(file,true);
            filewriter.write("\r\n---------------"+ x +"---------------------\r\n" + tmpS1);
            filewriter.close();
        } catch (IOException e) {
            System.out.println(e);

        }
    }

       static public void writeLog(String s) {
        try {
            File file = new File("C:\\android\\Log.txt");
            FileWriter filewriter = new FileWriter(file,true);
            filewriter.write(s + "\r\n");
            filewriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

       static public void deleteLog() {
               File file = new File("C:\\android\\Log.txt");
               file.delete();
       }

}
