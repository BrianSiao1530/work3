import java.awt.*;
//這個projct 主要是要做出與老師給的圖示一樣的圖
public class work3 {
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(650  , 400);
        panel.setBackground(Color.GRAY);
        Graphics g = panel.getGraphics();

        blackwhite(g,0,0,20,20,4,1,10,2);//左上
        blackwhite(g,50,70 ,30 ,30, 5, 1,0,2);//左2
        blackwhite(g,10, 150, 25, 25 ,4, 8,0,2);//lower left
        blackwhite(g, 250, 200,25, 25, 3, 6,10,2 );//lower middle
        blackwhite(g,425, 180, 20, 20,5, 10, 10,2);//lower right
        blackwhite(g,400, 20,35, 35, 2, 4,35,2);//upper right
    }
    //start point (x,y)座標, width & height w(寬) h(高) , l :long(長度 決定重複次數)
    //row 列(橫行): 縱列有無分岔 collum:c
    //deviation 與下一行有無偏差 between 列與列之間的空格
    public static void blackwhite(Graphics g, int x, int y, int w, int h, int l, int r, int deviation, int between){
        int x1 = x, y1 = y, h1 = h, w1 = w, t = 0, q1 = 0;
            for(int q = 0; q < r; q++) {
                q1 = q % 2;
                q1 = q1 * deviation;
                x1 = x1 + q1;
                for (int i = 0; i < l; i++) {
                    g.setColor(Color.black);
                    g.fillRect(x1, y1, w, h); //在x,y位置做出寬w 高h的方形
                    g.setColor(Color.blue);
                    g.drawLine(x1, y1, x1 + w, y1 + h); // 在方形上面畫線
                    g.drawLine(x1, y1 + h, x1 + w, y1);
                    x1 = x1 + w;
                    g.setColor(Color.white);
                    g.fillRect(x1, y1, w, h);
                    x1 = x1 + w;
                }
                x1 = x1 - q1;
                for (int i = 0; i < l; i++)
                    x1 = x1 - 2 * w;
               y1 = y1 + h + between;
            }
    }
}
