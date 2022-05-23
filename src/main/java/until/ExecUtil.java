package until;

/**
 * @Author deng
 * @Date 2022/3/1 0:52
 */

import com.fbj.pojo.Answer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

;

public class ExecUtil {
    //1.通过Runtime类得到实例，执行exec方法
    //2.希望获取到标准输出，并写入到指定的文件中
    //3.获取到标准的错误，并写入到指定文件中
    //4.等待子进程结束，拿到状态码，并返回。

    //防止不小心实例化工具类
    private ExecUtil(){}
    public static Answer run(String cmd, Boolean stdoutB, Boolean stderrB){
        //System.out.println(cmd);
        Answer answer=new Answer();
        try {
            //1.通过Runtime类得到实例，执行exec方法
            Process process=Runtime.getRuntime().exec(cmd);
            //2.获取到标准输出，并写入到指定文件中
            String line="",re="",stdout="";
            if(stdoutB){
                //windows上指定GBK中文才能正常显示，Linux还没试明先不管
                //也会自动阻塞
                BufferedReader stdoutFrom=new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
                while((line=stdoutFrom.readLine())!=null)
                    stdout+=line+"\n";
                stdoutFrom.close();;
            }
            if(stderrB){
                BufferedReader stdoutFrom=new BufferedReader(new InputStreamReader(process.getErrorStream(), "GBK"));
                while((line=stdoutFrom.readLine())!=null) {
                    re+=line+"\n";
                }
                stdoutFrom.close();
            }
            //exec 执行过程是异步的,waitfor会阻塞主进程，直到子进程完毕
            int exitCode=process.waitFor();
            answer.setError(exitCode);
            answer.setStderr(re);
            answer.setStdout(stdout);
            return answer;
        }catch (IOException |InterruptedException e){
            e.printStackTrace();
        }
        answer.setError(2);
        return answer;
    }
}
