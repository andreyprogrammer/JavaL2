public class Cat {
    private int lengthMax = 50;
    private int heightMax = 3;
    private String name;
    private boolean canGo = false;

    public Cat(String name) {
        this.name = "Кот " + name;
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

    public void setCanGo(boolean canGo) {
        this.canGo = canGo;
    }

    public String getName() {
        return name;
    }

    public boolean isCanGo() {
        return canGo;
    }
}
