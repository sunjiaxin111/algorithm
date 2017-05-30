package chapterOne.two;

import stdlib.StdDraw;
import stdlib.StdRandom;

import java.util.Arrays;

/**
 * Created by sunjiaxin on 2017/5/3.
 */
public class Ex_1_2_01 {

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        Point2D[] point2Ds = new Point2D[N];
        for(int i = 0; i < N; i++){
            point2Ds[i] = new Point2D(StdRandom.uniform(),StdRandom.uniform());
        }

        Arrays.sort(point2Ds);
        StdDraw.setPenColor(StdDraw.BLUE);
        for(int i = 0; i < N; i++){
            point2Ds[i].draw();
        }

        double minDis = (point2Ds[0].x() - point2Ds[N - 1].x()) * (point2Ds[0].x() - point2Ds[N - 1].x())
                + (point2Ds[0].y() - point2Ds[N - 1].y()) * (point2Ds[0].y() - point2Ds[N - 1].y());

        int minIndex = N;

        for (int i = 0; i < N - 1; i ++)
        {
            double dis = (point2Ds[i].x() - point2Ds[i+1].x()) * (point2Ds[i].x() - point2Ds[i+1].x())
                    + (point2Ds[i].y() - point2Ds[i+1].y()) * (point2Ds[i].y() - point2Ds[i+1].y());
            if (minDis > dis)
            {
                minDis = dis;
                minIndex = i;
            }
        }
        System.out.println(Math.sqrt(minDis));
        StdDraw.setPenColor(StdDraw.RED);
        if (minIndex == N)
        {
            System.out.println(point2Ds[0]);
            System.out.println(point2Ds[N-1]);
            StdDraw.line(point2Ds[N-1].x(), point2Ds[N-1].y(), point2Ds[0].x(), point2Ds[0].y());
        }
        else
        {
            System.out.println(point2Ds[minIndex]);
            System.out.println(point2Ds[minIndex + 1]);
            StdDraw.line(point2Ds[minIndex].x(), point2Ds[minIndex].y(),
                    point2Ds[minIndex+1].x(), point2Ds[minIndex+1].y());

        }


    }
}
