package com.lkb.file.utils;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description 文件帮助类
 * @Author lkb
 * @CreateDate: 2019/5/24
 */
public class FileUtils {

    private static final String ENCODING = "UTF-8";

    /**
     * 查找根路径下的文件路径
     * @author lkb
     * @date 2019/5/24
     * @param
     * @return java.util.List<java.lang.String>
     */
    public static List<String> getPath(String root){
        List<String> filePath = new LinkedList<>();
        File file = new File(root);
        if(file.isDirectory()){
            String[] paths = file.list();
            filePath = Arrays.asList(paths);
        }
        return filePath;
    }

    /**
     * 写文件
     * @author lkb
     * @date 2019/5/24
     * @param
     * @return void
     */
    public static void writeFile(String srcPath, String desPath, String pattern){
        File srcFile = new File(srcPath);
        if(!srcFile.exists() || !srcFile.isFile()){
            System.out.println("cannot find file through srcPath...");
            return;
        }

        if(!srcFile.getName().endsWith("Dao.java")){
            System.out.println("not dao file...");
            return;
        }

        File desFile = new File(desPath);
        if(!desFile.exists()){
            try{
                desFile.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        if(!desFile.exists() || !desFile.isFile()){
            System.out.println("cannot find file through desPath...");
            return;
        }

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try{
            InputStreamReader reader = new InputStreamReader(new FileInputStream(srcFile),ENCODING);
            bufferedReader = new BufferedReader(reader);

            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(desFile), ENCODING);
            bufferedWriter = new BufferedWriter(writer);
            String line = null;
            while((line = bufferedReader.readLine()) != null){
                if(line.matches(pattern)){
                    bufferedWriter.write(line);
                    if(line.endsWith(";")){
                        bufferedWriter.newLine();
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(bufferedReader != null){
                    bufferedReader.close();
                }
                if(bufferedWriter != null){
                    bufferedWriter.close();
                }

            }catch (IOException ex){
                ex.printStackTrace();
            }
        }

    }




}
