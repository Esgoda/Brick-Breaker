package setUp.frames;

import setUp.panels.Panel;

import javax.swing.*;

public class MainFrame {
    private JFrame container;
    private String title;
    private int x, y, width, height;

    public MainFrame(String title, int x, int y, int width, int height) {
        this.title = title;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        container = new JFrame();

        createFrame(container, title, x, y, width, height);
    }

    private void createFrame(JFrame container, String title, int x, int y, int width, int height){
        container.setBounds(x, y, width, height);
        container.setTitle(title);
        container.setResizable(false);
        container.setVisible(true);
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addPanel(Panel panel){
        this.container.add(panel);
    }

    public JFrame getContainer() {
        return container;
    }

    public void setContainer(JFrame container) {
        this.container = container;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
