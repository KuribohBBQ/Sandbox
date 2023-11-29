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

        Node current = new Node(start);

        ArrayList<Node> openlist = new ArrayList<>();
        ArrayList<Node> closedlist = new ArrayList<>();
        openlist.add(current);
        if (validitycheck(current.getUp()))
        {
            openlist.add(current.getUp());
        }
        if (validitycheck(current.getRight()))
        {
            openlist.add(current.getRight());
        }
        if (validitycheck(current.getDown()))
        {
            openlist.add(current.getDown());
        }
        if (validitycheck(current.getUp()))
        {
            openlist.add(current.getUp());
        }

        return path;
    }

    public boolean validitycheck(Node n)
    {
    }
    public boolean withinbounds(Point p, grid)
    {

    }
    public double Manhattan(Node current, Node end)
    {
        return Math.abs(end.getPoint().x - current.getPoint().x) + Math.abs(end.getPoint().y - current.getPoint().y);
    }
}


