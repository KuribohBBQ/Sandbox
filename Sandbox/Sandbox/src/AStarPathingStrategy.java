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

        Node current = new Node(start, null, Manhattan(start, end));
//        List<Point> neighbors = potentialNeighbors.apply(current.getPoint()).filter(canPassThrough).toList();


        ArrayList<Node> openlist = new ArrayList<>();
        ArrayList<Node> closedlist = new ArrayList<>();
        openlist.add(current);
        double g = 0;
        double h = 0;


        while (!openlist.isEmpty())
        {
            List<Point> neighbors = potentialNeighbors.apply(current.getPoint()).filter(canPassThrough).toList();
            //analyze valid adjacent nodes that are not on closed list
            for (Point n: neighbors)
            {
                Node PotentialNode = new Node(n, current, 0);
                //checks if node is already on openlist
                for (Node check: openlist)
                {
                    //checking if node in openlist is not already in closedlist
                    if (check.getPoint() == PotentialNode.getPoint() && checkIfInClosedlist(check, closedlist))
                    {
                        //checking if calculated g is better than previously calculated g
                        double calc_g = Manhattan(PotentialNode.getPoint(), current.getPoint());
                        if (calc_g < g)
                        {
                            g = calc_g;
                        }
                        //estimate distance of potential node to end point
                        h = Manhattan(PotentialNode.getPoint(), end);
                        PotentialNode.setf(g, h);


                    }
                    //determine distance from start node(g value)
                    else
                    {
                        double new_g = Manhattan(check.getPoint(), current.getPoint());
                        g = new_g;
                    }
                }


            }

            if (withinReach.test(current.getPoint(), end)) {
                // build path and return
            }

        } //end of while loop

        return path;
    }



    public double Manhattan(Point current, Point end)
    {
        return Math.abs(end.x - current.x) + Math.abs(end.y - current.y);
    }
    public boolean checkIfInClosedlist(Node c, ArrayList<Node> closedlist)
    {
        for (Node check: closedlist)
        {
            if (c.getPoint() == check.getPoint())
            {
                return false;
            }
        }
        return true;
    }
}


