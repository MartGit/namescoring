package com.occ.namescoringapplication.loaddata;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class LoadDataServiceImpl implements LoadDataService {

    public  String loadData(String filePath) {
        String fileContent = null;
        try {
            Path path = FileSystems.getDefault().getPath(filePath);
            fileContent = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        }
        catch (IOException e) {
            //Handle a potential exception
        }
        System.out.println("Args here is " + filePath);

        return fileContent;
    }
}
