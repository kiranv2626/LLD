package momento;

public class ConfigOriginator {
    int height;
    int width;
    public ConfigOriginator(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    public ConfigMomento createMemento(){
        ConfigMomento memento = new ConfigMomento(this.height, this.width);
        return memento;
    }
    public void restoreMemento(ConfigMomento memento){
        this.height = memento.getHeight();
        this.width = memento.getWidth();
    }
}
