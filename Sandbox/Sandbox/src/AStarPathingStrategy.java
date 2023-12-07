import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class AStarPathingStrategy
        implements PathingStrategy {


    public List<Point> computePath(Point start, Point end,
                                   Predicate<Point> canPassThrough,
                                   BiPredicate<Point, Point> withinReach,
                                   Function<Point, Stream<Point>> potentialNeighbors) {
        List<Point> path = new LinkedList<Point>();

        Node current = new Node(start, null, 0, Manhattan(start, end), Manhattan(start, end));
//        List<Point> neighbors = potentialNeighbors.apply(current.getPoint()).filter(canPassThrough).toList();


        PriorityQueue<Node> openlist = new PriorityQueue<>(Comparator.comparing(Node::getf));
        ArrayList<Node> closedlist = new ArrayList<>();
        //openlist.add(current);


        while (current != null) {
            if (withinReach.test(current.getPoint(), end)) {

                // build path and return
              while (current.getg() != 0)
              {
                 path.add(0, current.getPoint());
                 current = current.getPrior();
              }
              return path; //make sure it doeesnt include start and end nodes
            }
            List<Point> neighbors = potentialNeighbors.apply(current.getPoint()).filter(canPassThrough).toList();
            //analyze valid adjacent nodes that are not on closed list
            for (Point n : neighbors) //n = potential neighbor
            {
                double g = current.getg() + 1;
                double h = Manhattan(n, end);
                double f = g + h;
                Node PotentialNode = new Node(n, current, g, h, f);

                //checking if node in openlist and is not already in closedlist
                if (openlist.contains(PotentialNode) && !closedlist.contains(PotentialNode)) {
                    //checking if potentialNode's calculated g is better than previously calculated g


                    if (g < openlist.poll().getg()) { // get g out of openList version
                        // remove check from the open list
                        // use equals method to remove the old node and add the new one
                        // it looks like its doing nothing, but using location as identifier.
                        // reshuffles node into the queue

                        openlist.remove(PotentialNode);
                        openlist.add(PotentialNode);
                        // add Potential Node into open list
                    }



                }

                else if (!closedlist.contains(PotentialNode)) {
                    // add to open list
                    openlist.add(PotentialNode);

                }
            }


        //end of analyzing adjacent nodes
        closedlist.add(current);

        current = openlist.poll(); //removes first element from list



    }//end of while loop


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
    public boolean checkIfInOpenList(Node c, PriorityQueue<Node> openlist)
    {
        for (Node check: openlist)
        {
            if (c.getPoint().equals(check.getPoint()))
            {
                return false;
            }
        }
        return true;
    }

    }



