package com.fbj.test;


import com.fbj.pojo.Answer;
import until.ExecUtil;

import java.io.FileWriter;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        String DIR="d:/javaTest/";
        String javaFile=DIR+"Main.java";
        String javaClass="Main";
        String compileCmd=String.format("javac -encoding utf8 %s -d %s",javaFile,DIR);
        String runningCmd=String.format("java -classpath %s %s", DIR, javaClass);
        String doc="public class Main {\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(\"hello world\");\n" +
                "    }\n" +
                "}";
        //将代码写入到定义路径下特定的java源文件中
        FileWriter writer=new FileWriter(javaFile);
        writer.write(doc);
        writer.close();
        //编译源文件为class文件
        Answer answer= ExecUtil.run(compileCmd,false,true);
        System.out.println(answer.getStderr());
        //若编译成功即可开始运行
        if(answer.getError()==0) {
            answer = ExecUtil.run(runningCmd, true, true);
            if(answer.getError()!=0)
                answer.setReason(Answer.Success);
            else
                answer.setReason(Answer.RuntimeError);
            System.out.println(answer.getStdout());
        }
        else
            answer.setReason(Answer.Error);
    }
}


