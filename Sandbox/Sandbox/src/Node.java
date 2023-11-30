public class Node
{
    private Point point;

    private Node prior;

    private Node up;

    private Node right;

    private Node down;

    private Node left;

    public Node(Point point, Node prior)
    {
        this.point = point;
        this.prior = prior;
        this.up = up;
        this.right = right;
        this.down = down;
        this.left = left;

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



}
