/** An Integer tester created by Flik Enterprises. */
public class Flik {
    public static boolean isSameNumber(Integer a, Integer b) {
        // 形参使用的是Integer，是两个对象，只有在小于128的时候，才会自动拆箱。
        // 故而a = 128，b = 128 时，比较的是两个对象，返回false。
        return a == b;
    }
}
