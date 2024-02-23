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
            collections.put(collectionName, collections.getOrDefault(collectionName, 0L) + totalSize);
        }

        // TODO print something

        List<CollectionMetadata> biggestCollections = collections.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(entry -> new CollectionMetadata(entry.getKey(), entry.getValue()))
                .limit(numberOfCollectionsToReport)
                .collect(Collectors.toList());
        biggestCollections.removeIf(el -> el.collectionName == null);


        return new Report(totalSize, biggestCollections);
    }
//public static Report generateReport(List<FileMetadata> files, int numberOfCollectionsToReport) {
//    long totalSize = 0;
//    Map<String, Long> collections = new HashMap<>();
//
//    // Calculate total size and collection sizes
//    for (FileMetadata file : files) {
//        totalSize += file.getSize();
//        collections.put(file.getName(), collections.getOrDefault(file.getName(), 0L) + file.getSize());
//    }
//
//    // Sort collections by size
//    List<CollectionMetadata> biggestCollections = new ArrayList<>();
//    collections.entrySet().stream()
//            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//            .limit(numberOfCollectionsToReport)
//            .forEach(entry -> biggestCollections.add(new CollectionMetadata(entry.getKey(), entry.getValue())));
//
//    return new Report(totalSize, biggestCollections);
//}
}
