package com.practice.java8;

import java.io.File;
import java.io.FileFilter;

public class FirstLamda {

    public static void main(String[] args) {
        FileFilter fileFilter = new FileFilter() {

            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }

        };

        File dir = new File(
                "C://Users//vikas//java8//java//pluralsight//java8//src//main//java//com//practice//java8//");

        File[] files = dir.listFiles(fileFilter);
        for (File file : files) {
            System.out.println(file.getName());
        }

        final FileFilter lambFileFilter =
                (final File pathName) -> pathName.getName().endsWith(".java");

        System.out.println("output with lambda");

        files = dir.listFiles(lambFileFilter);
        for (final File file : files) {
            System.out.println(file.getName());
        }
    }
}
