/**
 * 豆浆制作
 * make
 *
 * select  - 选材料
 *
 * add - 添加配料
 *
 * soak - 侵泡
 */
public abstract class SoyaMilk {
    // 模版方法定义为final, 进制子类去继承
    public final void make() {
        select();
        if (cutstomerWant()) {
            add();
        }
        soak();
        beat();
    }

    void select() {
        System.out.println("第一步：选择好的新鲜黄豆");
    }

    // 添加黄豆 - 抽象方法由子类实现
    abstract  void add() ;

    void soak() {
        System.out.println("第三步：开始侵泡");
    }

    void beat() {
        System.out.println("第四步：放到豆浆机");
    }

    // 钩子方法 - 决定是否添加配料
    boolean cutstomerWant() {
        return true;
    }

}
