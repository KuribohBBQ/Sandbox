import java.util.Objects;

public class Node
{
    private Point point;

    private Node prior;

    private double g;


    private double h;
    private double f;

    public Node(Point point, Node prior, double g, double h, double f)
    {
        this.point = point;
        this.prior = prior;
        this.g = g;
        this.h = h;
        this.f = f;

    }

    public Point getPoint()
    {
        return this.point;
    }
    public Node getPrior()
    {
        return this.prior;
    }
    public double getg(){return this.g;}

    public double geth(){return this.h;}

    public double getf(){return this.f;}



    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        Node n = (Node) o;

        return Objects.equals(point, n.point);
    }
}
