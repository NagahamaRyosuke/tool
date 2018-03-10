/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

import java.util.ArrayList;

/**
 *
 * @author Yusuke
 */
public class Member {

    static int numOfMember = 0;
    String name;

    boolean isThisLoop = false;
    ArrayList<String> ecsperiencedTasks = new ArrayList<>();

    Member(String name) {
        this.name = name;
        numOfMember++;
    }

//    引数のTaskを経験してるか確認
    boolean isExperiencedTasks(String task) {
        boolean check = false;

//        スタート時の空のListを拾う処理
        if (ecsperiencedTasks.isEmpty()) {
            check = true;
        }
//        担当してないタスクか確認する処理
        else {
            for (int i = 0; i < ecsperiencedTasks.size(); i++) {
                if (ecsperiencedTasks.get(i).equals(task)) {
                    check = false;
                    break;
                } else {
                    check = true;
                }
            }
        }
        return check;
    }

    void resetList() {
    	ecsperiencedTasks = new ArrayList<>();
    }
}
