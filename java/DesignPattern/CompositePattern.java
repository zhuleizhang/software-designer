package DesignPattern;

import java.util.*;

public class CompositePattern {
    public static void main(String[] args) {
        System.out.println("DesignPattern CompositePattern start");

        AbstractCompositeFile root = new CompositeFolder("root");
        AbstractCompositeFile folderA = new CompositeFolder("folderA");
        AbstractCompositeFile folderB = new CompositeFolder("folderB");
        AbstractCompositeFile file1 = new CompositeFile("file1");
        AbstractCompositeFile file2 = new CompositeFile("file2");
        AbstractCompositeFile file3 = new CompositeFile("file3");
        AbstractCompositeFile file4 = new CompositeFile("file4");

        root.Add(file1);
        root.Add(file2);
        root.Add(folderA);
        root.Add(folderB);
        folderB.Add(file3);
        folderB.Add(file4);

        printFileTree(root);

    }

    public static void printFileTree(AbstractCompositeFile file) {
        file.Operation();
        if (file.GetChildren() != null) {
            for (AbstractCompositeFile child : file.GetChildren()) {
                printFileTree(child);
            }
        }
    }
}

abstract class AbstractCompositeFile {
    protected String name;

    public void Operation() {
        System.out.println(this.name);
    }

    abstract Boolean Add(AbstractCompositeFile file);

    abstract Boolean Remove(AbstractCompositeFile file);

    abstract List<AbstractCompositeFile> GetChildren();
}

class CompositeFolder extends AbstractCompositeFile {
    private List<AbstractCompositeFile> children = new ArrayList<AbstractCompositeFile>();

    public CompositeFolder(String name) {
        this.name = name;
    }

    public Boolean Add(AbstractCompositeFile file) {
        return children.add(file);
    }

    public Boolean Remove(AbstractCompositeFile file) {
        return children.remove(file);
    }

    public List<AbstractCompositeFile> GetChildren() {
        return children;
    }
}

class CompositeFile extends AbstractCompositeFile {
    public CompositeFile(String name) {
        this.name = name;
    }

    public Boolean Add(AbstractCompositeFile file) {
        return false;
    }

    public Boolean Remove(AbstractCompositeFile file) {
        return false;
    }

    public List<AbstractCompositeFile> GetChildren() {
        return null;
    }
}
