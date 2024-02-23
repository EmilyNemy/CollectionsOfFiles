import org.example.CollectionMetadata;
import org.example.FileMetadata;
import org.example.Report;
import org.example.ReportGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FileTest {
    @Test
    public void testGenerateReport(){
        FileMetadata file = new FileMetadata("file1.txt", 100);
        FileMetadata file1 = new FileMetadata("file2.txt", 200, "collection1");
        FileMetadata file2 = new FileMetadata("file3.txt", 200, "collection1");
        FileMetadata file3 = new FileMetadata("file4.txt", 300, "collection2");
        FileMetadata file4 = new FileMetadata("file5.txt", 10);

        List<FileMetadata> files = new ArrayList<>();
        files.add(file);
        files.add(file1);
        files.add(file2);
        files.add(file3);
        files.add(file4);

        ReportGenerator reportGenerator = new ReportGenerator();
        Report actual = reportGenerator.generateReport(files, 3);
        Report expected = new Report(810,
                Arrays.asList(new CollectionMetadata("collections2", 300),
                        new CollectionMetadata("collection1", 400)));
        Assertions.assertEquals(expected.totalSize, actual.totalSize);
        Assertions.assertEquals(expected.collectionNames, actual.collectionNames);
    }
}
