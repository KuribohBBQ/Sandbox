public class Node
{
    private Point point;

    private Node prior;

    private Node up;

    private Node right;

    private Node down;

    private Node left;

    private double f;

    public Node(Point point, Node prior, double f)
    {
        this.point = point;
        this.prior = prior;
        this.up = up;
        this.right = right;
        this.down = down;
        this.left = left;
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

    public Node getUp()
    {
        return this.up;
    }

    public Node getRight()
    {
        return this.right;
    }

    public Node getDown()
    {
        return this.down;
    }

    public Node getLeft()
    {
        return this.left;
    }

    public double getf(){return this.f;}

    public void setf(double g, double h){this.f = g + h;}



}
