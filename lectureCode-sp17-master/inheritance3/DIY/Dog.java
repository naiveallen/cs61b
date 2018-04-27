public class Dog implements Comparable<Dog>{
    private String name;
    private int size;

    public Dog(String n, int s) {
        name = n;
        size = s;
    }

    public void bark() {
        System.out.println(name + " says: bark");
    }

    // 如果当前对象比参数大，返回正数；一样大返回0；比参数小返回负数。
    @Override
    public int compareTo(Dog that) {
        return this.size - that.size;
    }
}