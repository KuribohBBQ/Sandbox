import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.HashMap;

class AStarPathingStrategy
        implements PathingStrategy
{


    public List<Point> computePath(Point start, Point end,
                                   Predicate<Point> canPassThrough,
                                   BiPredicate<Point, Point> withinReach,
                                   Function<Point, Stream<Point>> potentialNeighbors)
    {
        List<Point> path = new LinkedList<Point>();

        Node current = new Node(start, null);
        List<Point> neighbors = potentialNeighbors.apply(current.getPoint()).filter(canPassThrough).toList();


        ArrayList<Node> openlist = new ArrayList<>();
        ArrayList<Node> closedlist = new ArrayList<>();
        openlist.add(current);

        }
//        while (!withinR)
//        {
//        if (withinReach.test(current.getPoint(), end)) {
//            // build path and return
//        }
//        }

        return path;
    }



    public double Manhattan(Node current, Node end)
    {
        return Math.abs(end.getPoint().x - current.getPoint().x) + Math.abs(end.getPoint().y - current.getPoint().y);
    }
}


