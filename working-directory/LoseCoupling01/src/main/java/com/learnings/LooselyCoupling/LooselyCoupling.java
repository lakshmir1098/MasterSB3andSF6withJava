
import com.learnings.MasteringSpring.LooselyCoupling.GamingConsole.GameRunner;
import com.learnings.MasteringSpring.LooselyCoupling01.GamingConsole.Game01;
import com.learnings.MasteringSpring.LooselyCoupling01.GamingConsole.Game02;


public class LooselyCoupling {
    public static  void main(String[] args){
        var g1 = new Game01();
        var g2 = new Game02();
        var gameRunner = new GameRunner((com.learnings.MasteringSpring.LooselyCoupling01.GamingConsole.GameConsole) g2);

        gameRunner.run();
        g2.jump();
    }
}
