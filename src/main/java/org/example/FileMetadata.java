package org.example;

public class FileMetadata {
    public int size;
    public String fileName;

    public String collectionName;

    public FileMetadata(String fileName, int size) {
        this.fileName = fileName;
        this.size = size;
    }

    public FileMetadata(String fileName, int size, String collectionName){
        this.fileName = fileName;
        this.size = size;
        this.collectionName = collectionName;
    }

    public String getName(){
        return this.fileName;
    }

    public long getSize() {
        return this.size;
    }

    public String getCollectionName(){
        return this.collectionName;
    }
}
