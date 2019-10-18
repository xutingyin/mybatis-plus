package cn.xutingyin.mybatisplus;

import net.coobird.thumbnailator.Thumbnails;

import java.io.IOException;

/**
* @Description: 图片压缩工具类
* @Author: xuty
* @Date: 2019/9/17 14:04
*/
public class ImageZooTest {

    public static void main(String[] args) throws IOException {
        String sourcePath = "C:\\Users\\WST\\Desktop\\极简世界\\mworld_bg.jpg";
        String destnationPath = "C:\\Users\\WST\\Desktop\\极简世界\\mworld_bg_new.jpg";
        Thumbnails.of(sourcePath)
                .scale(1f)
                .outputQuality(0.5f)
                .toFile(destnationPath);

    }
}
