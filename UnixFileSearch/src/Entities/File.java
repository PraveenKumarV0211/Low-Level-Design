package Entities;

public class File extends Unit{
    String extension;

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public File(String name, int size, String extension){
        super(name,size);
        this.extension = extension;
    }

}
