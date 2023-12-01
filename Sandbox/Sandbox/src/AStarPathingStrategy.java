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
//        List<Point> neighbors = potentialNeighbors.apply(current.getPoint()).filter(canPassThrough).toList();


        ArrayList<Node> openlist = new ArrayList<>();
        ArrayList<Node> closedlist = new ArrayList<>();
        openlist.add(current);
        double g = 0;
        double h = 0;
        double f = 0;

        while (!openlist.isEmpty())
        {
            List<Point> neighbors = potentialNeighbors.apply(current.getPoint()).filter(canPassThrough).toList();
            //analyze valid adjacent nodes that are not on closed list
            for (Point n: neighbors)
            {
                Node PotentialNode = new Node(n, current);
                //checks if node is already on openlist
                for (Node check: openlist)
                {
                    if (check.getPoint() == PotentialNode.getPoint())
                    {
                        //checking if calculated g is better than previously calculated g
                        double calc_g = Manhattan(PotentialNode, current);
                        if (calc_g > g)
                        {
                            g = calc_g;
                        }
                        //estimate distance of potential node to end point
                        h = Manhattan(PotentialNode, end);
                    }
                    //determine distance from start node(g value)
                    else
                    {
                       double new_g = Manhattan
                    }
                }


            }

        if (withinReach.test(current.getPoint(), end)) {
            // build path and return
        }

        } //end of while loop

        return path;
    }



    public double Manhattan(Node current, Node end)
    {
        return Math.abs(end.getPoint().x - current.getPoint().x) + Math.abs(end.getPoint().y - current.getPoint().y);
    }
}


