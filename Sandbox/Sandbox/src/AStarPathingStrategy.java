import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class AStarPathingStrategy
        implements PathingStrategy
{


    public List<Point> computePath(Point start, Point end,
                                   Predicate<Point> canPassThrough,
                                   BiPredicate<Point, Point> withinReach,
                                   Function<Point, Stream<Point>> potentialNeighbors)
    {
        List<Point> path = new LinkedList<Point>();

        Node current = new Node(start, null, 0, Manhattan(start, end), Manhattan(start, end));
//        List<Point> neighbors = potentialNeighbors.apply(current.getPoint()).filter(canPassThrough).toList();


        PriorityQueue<Node> openlist = new PriorityQueue<>(Comparator.comparing(Node :: getf));
        ArrayList<Node> closedlist = new ArrayList<>();
        openlist.add(current);



        while (!current.equals(null))
        {
            List<Point> neighbors = potentialNeighbors.apply(current.getPoint()).filter(canPassThrough).toList();
            //analyze valid adjacent nodes that are not on closed list
            for (Point n: neighbors) //n = potential neighbor
            {
                double g = current.getg() + 1;
                double h = Manhattan(n, end);
                double f = g + h;
                Node PotentialNode = new Node(n, current, g, h, f) ;
                //checks if node is already on openlist
                for (Node check: openlist)
                {
                    //checking if node in openlist and is not already in closedlist
                    if (check.getPoint().equals(PotentialNode.getPoint()) && checkIfInClosedlist(check, closedlist))
                    {
                        //checking if potentialNode's calculated g is better than previously calculated g



                        if (g < PotentialNode.getg())
                        {
                            // remove check from the open list
                            // use equals method to remove the old node and add the new one
                            // it looks like its doing nothing, but using location as identifier.
                            // reshuffles node into the queue

                            openlist.remove(PotentialNode);
                            openlist.add(PotentialNode);
                            // add Potential Node into open list
                        }



                    }
                    //determine distance from start node(g value)
                    else if (checkIfInClosedlist(check, closedlist))
                    {
                        // add to open list
                        openlist.add(check);

                    }
                }


            }//end of analyzing adjacent nodes
            closedlist.add(current);
            current = openlist.poll(); //removes first element from list

            if (withinReach.test(current.getPoint(), end)) {
                // build path and return
                path.add(current.getPoint());
                return path;
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
            if (c.getPoint().equals(check.getPoint()))
            {
                return false;
            }
        }
        return true;
    }
    public boolean equalsMethod(Node a, Node b)
    {
        if (a.getPoint().equals(b.getPoint()))
        {
            return true;
        }
        return false;
    }
}


