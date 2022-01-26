package LinkedIn;

public class Bulb_Switcher {

    /* 1 = （1,1）                                       1次翻转，最终on
     * 2 = （1,2），（2,1）                      2次翻转，最终off
     * 3 = （1,3），（3,1）                      2次翻转，最终off
     * 4 = （1,4），（2,2），（4,1）    3次翻转，最终on
     * 5 = （1,5），（5,1）                      2次翻转，最终off
     *
     * 可以看出，最终为on的灯所在位置都是平方数
     */
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}
