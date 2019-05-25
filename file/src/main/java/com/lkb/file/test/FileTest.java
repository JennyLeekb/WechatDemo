package com.lkb.file.test;

import com.lkb.file.utils.FileUtils;

import java.util.List;

/**
 * @Description 文件测试
 * @Author lkb
 * @CreateDate: 2019/5/24
 */
public class FileTest {

    private static final String ROOT_PATH = "F:\\crm\\ld_crm_data\\src\\main\\java\\com\\laidian\\crm\\data\\dao";
    private static final String DES_PATH = "F:\\DAO";
    private static final String PATTERN = ".*String sql.*";

    public static void main(String[] args) {
        List<String> filePath = FileUtils.getPath(ROOT_PATH);
        filePath.stream().forEach(s->{
            String desPath = s.replaceAll(".java",".sql");
            desPath = DES_PATH + "\\"+ desPath;
            s = ROOT_PATH + "\\" + s;
            FileUtils.writeFile(s,desPath,PATTERN);
        });
    }

}
