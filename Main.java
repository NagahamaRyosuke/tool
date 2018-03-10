/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//resetInfoToReselectを実装していないのでまだ繰り返し再振り分け処理が最後までできません


package tool;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Yusuke
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Member> memberList = new ArrayList<>();
        ArrayList<Task> taskList = new ArrayList<>();

        registerMembers(memberList);
        registerTasks(taskList);

//        LogOutPut.deleteLog();

//        while (true) {
        for(int j=0; j<7; j++) {

            decideDuty(memberList, taskList);

//            結果出力
            for (int i = 0; i < taskList.size(); i++) {
                String task = taskList.get(i).name;
                String name = taskList.get(i).currentPerson;
                System.out.println(task + ":" + name);
            }

            System.out.println("------------------------");

//            LogOutPut.writeLog(memberList,j);

//            次の繰り返しのためのmemberとtaskの変数整理
            setInfo(memberList, taskList);
        }
    }

    static public void registerMembers(ArrayList<Member> memberList) {
        memberList.add(new Member("小杉"));
        memberList.add(new Member("富沢"));
        memberList.add(new Member("長濱"));
        memberList.add(new Member("脇田"));
        memberList.add(new Member("森藤"));
        memberList.add(new Member("鮮"));
        memberList.add(new Member("揚"));
    }

    static public void registerTasks(ArrayList<Task> taskList) {
        taskList.add(new Task("トイレ　"));
        taskList.add(new Task("ゴミ出し"));
        taskList.add(new Task("床　　　"));
        taskList.add(new Task("郵便　　"));
    }

//    振り分ける大元、振り分け処理系の各メソッドはここで呼び出し
    static public boolean decideDuty(ArrayList<Member> memberList, ArrayList<Task> taskList) {
        Task selectedTask;
        boolean reselectFlg = false;

        int counter = 0;
        while (counter != taskList.size()) {
//            memberList格納数未満の乱数
            int rnd = new Random().nextInt(memberList.size());
            Member selectedMember = memberList.get(rnd);

//            MemberListの中で未選択かつ今回の担当にも選ばれていない場合
            if (!selectedMember.isThisLoop) {
                selectedTask = decideTask(selectedMember, taskList, counter);

                if(!selectedTask.currentPerson.isEmpty()) {
                	selectedMember.isThisLoop = true;
                    counter++;
                }
            }
        }
        return reselectFlg;
    }

//    selectedMemberに仕事を割り振る
    static public Task decideTask(Member selectedMember, ArrayList<Task> taskList, int num) {
        Task selectedTask = new Task();

        //Taskの初期化処理
        if(selectedMember.ecsperiencedTasks.size() == taskList.size()) {
        	selectedMember.resetList();
        }

        selectedTask = taskList.get(num);

//      selectedMemberが未経験かつ前回未担当
	    if (selectedMember.isExperiencedTasks(selectedTask.name) && selectedTask.isExperiencedMember(selectedMember.name)) {
	        selectedMember.ecsperiencedTasks.add(selectedTask.name);
	        selectedTask.currentPerson = selectedMember.name;
	    }
        return selectedTask;
    }

//    Taskの担当者変数の移動など
    static public void setInfo(ArrayList<Member> memberList, ArrayList<Task> taskList) {
        for (int i = 0; i < taskList.size(); i++) {
            taskList.get(i).chengePersonInfo();
        }

      for(int i = 0; i < memberList.size(); i ++){
          memberList.get(i).isThisLoop = false;
      }
    }

}
