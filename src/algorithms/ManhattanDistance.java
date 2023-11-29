public class ManhattanDistance {

    /**
     *  The distance between two points in Manhattan geometry is the sum of the absolute differences of their Cartesian coordinates.
     *  @see <a href="https://en.wikipedia.org/wiki/Taxicab_geometry">Taxicab geometry</a>
     */
    int distance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
