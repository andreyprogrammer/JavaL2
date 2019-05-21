public class Human {
    private int lengthMax = 500;
    private int heightMax = 2;
    private String name;
    private boolean canGo = false;

    public Human(String name) {
        this.name = "Человек " + name;
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

    public int getLengthMax() {
        return lengthMax;
    }

    public int getHeightMax() {
        return heightMax;
    }

    public void setCanGo(boolean canRun) {
        this.canGo = canRun;
    }

    public String getName() {
        return name;
    }

    public boolean isCanGo() {
        return canGo;
    }
}
