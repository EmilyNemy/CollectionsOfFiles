package org.example;

import java.util.List;

public class Report {
    public long totalSize;
    public List<CollectionMetadata> collectionNames;

    public Report(long totalSize, List<CollectionMetadata> biggestCollections) {
        this.totalSize = totalSize;
        this.collectionNames = biggestCollections;
    }
}
