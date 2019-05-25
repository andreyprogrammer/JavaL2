public class Robot {
    private int lengthMax = 3000;
    private int heightMax = 1;
    private String name;
    private boolean canGo = false;

    public Robot(String name) {
        this.name = "Робот " + name;
    }

    public void run(int length) {
        if (length <= lengthMax) {
            System.out.println(name + " пробежал " + length + " м.");
        } else {
            System.out.println(name + " не может пробежать " + length + " м.");
        }
    }

    public void jump(int heigh) {
        if (heigh <= heightMax) {
            System.out.println(name + " прыгнул на " + heigh + " м.");
        } else {
            System.out.println(name + " не может прыгнуть на " + heigh + " м.");
        }
    }

    public void setCanGo(boolean canGo) {
        this.canGo = canGo;
    }

    public int getLengthMax() {
        return lengthMax;
    }

    public int getHeightMax() {
        return heightMax;
    }

    public String getName() {
        return name;
    }

    public boolean isCanGo() {
        return canGo;
    }
}
