package com.i2soft.util;

import java.io.*;

public class IOHelper {
    public static StringMap readJsonFile(File file) throws IOException {
        return Json.decode(readFile(file));
    }

    public static void saveJsonFile(File file, StringMap map) throws IOException {
        saveFile(file, Json.encode(map));
    }

    public static String readFile(File file) throws IOException {
        if (file == null || !file.canRead()) {
            return "";
        }
        Reader in = new FileReader(file);
        StringWriter out = new StringWriter();
        copy(in, out);
        return out.toString();
    }

    public static void saveFile(File file, String content) throws IOException {
        if (file == null) {
            System.out.println("Waring: Cache file save failed");
            return;
        }
        File fileParent = file.getParentFile();
        if (!fileParent.exists()) {
            fileParent.mkdirs();
            file.createNewFile();
        }
        Writer writer = new FileWriter(file);
        writer.write(content);
        writer.close();
    }

    private static void copy(Reader in, Writer out) throws IOException {
        int c;
        while ((c = in.read()) != -1) {
            out.write(c);
        }
    }

    /**
     * 删除文件夹（强制删除）
     */
    public static boolean deleteAllFilesOfDir(File path) {
        if (path == null || !path.exists()) {
            return false;
        }

        if (path.isFile()) {
            boolean result = path.delete();
            int tryCount = 0;
            while (!result && tryCount++ < 10) {
                System.gc(); // 回收资源
                result = path.delete();
            }
        }
        File[] files = path.listFiles();
        if (null != files) {
            for (File file : files) {
                deleteAllFilesOfDir(file);
            }
        }
        return path.delete();
    }
}