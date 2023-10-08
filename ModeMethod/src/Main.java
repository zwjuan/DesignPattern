public class Main {
    public static void main(String[] args) {
        SoyaMilk soyaMilk = new RedSoyaMilk();
        soyaMilk.make();

        SoyaMilk soyaMilk1 = new PeanutSoyamilk();
        soyaMilk1.make();

        PureSoyaMilk pureSoyaMilk = new PureSoyaMilk();
        pureSoyaMilk.make();
    }
}
