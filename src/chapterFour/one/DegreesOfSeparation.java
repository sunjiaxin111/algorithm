package chapterFour.one;

import stdlib.StdIn;

/**
 * Created by sunjiaxin on 2017/7/18.
 */
public class DegreesOfSeparation {

    public static void main(String[] args) {
        SymbolGraph sg = new SymbolGraph(args[0], args[1]);

        Graph G = sg.G();

        String source = args[2];
        if (!sg.contains(source)) {
            System.out.println(source + " not in database.");
            return;
        }

        int s = sg.index(source);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);

        while(StdIn.hasNextLine()) {
            String sink = StdIn.readLine();
            if (sg.contains(sink)) {
                int t = sg.index(sink);
                if (bfs.hasPathTo(t)) {
                    for (int v : bfs.pathTo(t)) {
                        System.out.println(" " + sg.name(v));
                    }
                } else {
                    System.out.println(sink + " and " + source + " not connected");
                }
            } else {
                System.out.println(sink + " not in database.");
            }
        }
    }
}
