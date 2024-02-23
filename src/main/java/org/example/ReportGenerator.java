package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class ReportGenerator {
    public  Report generateReport(List<FileMetadata> files, int numberOfCollectionsToReport){
        long totalSize = 0L;
        Map<String, Long> collections = new HashMap<>();

        for(FileMetadata file: files){
            totalSize += file.getSize();
            String collectionName = file.getCollectionName();
            if(!collections.containsKey(collectionName)){
                collections.put(collectionName, collections.getOrDefault(collectionName, 0L));
            }else{
                long l = collections.get(collectionName) + file.getSize();
                collections.put(collectionName, l);
            }

        }

        // TODO print something

        List<CollectionMetadata> biggestCollections = collections.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(entry -> new CollectionMetadata(entry.getKey(), entry.getValue()))
                .limit(numberOfCollectionsToReport)
                .collect(Collectors.toList());

        return new Report(totalSize, biggestCollections);
    }
}
