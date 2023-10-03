public class Client {
    public static void main(String[] args) {
        HanFeizi hanFeizi = new HanFeizi();
        hanFeizi.addObserver(new LiSi());
        hanFeizi.addObserver(new ZhangSi());

        hanFeizi.haveBreadfase();
    }
}
