package visitor;

import java.util.ArrayList;
import java.util.List;

public class FileFindVisitor extends Visitor {
    private final List<File> files = new ArrayList<>();
    private final String fileExtension;

    public FileFindVisitor(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    @Override
    public void visit(File file) {
        String fileName = file.getName();

        if (fileName.endsWith(fileExtension)) {
            files.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        for (Entry entry : directory) {
            entry.accept(this);
        }
    }

    public List<File> getFiles() {
        return files;
    }
}
