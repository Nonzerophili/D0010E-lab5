package lab5.random;
import java.util.Random;

/**
 * This class is used for computing the washing time of an event.
 */
public class UniformRandomStream {

	private Random rand;
	private double lower, width;
	
	public UniformRandomStream(double lower, double upper, long seed) {
		rand = new Random(seed);
		this.lower = lower;
		this.width = upper-lower;
	}
	
	public UniformRandomStream(double lower, double upper) {
		rand = new Random();
	    this.lower = lower;
	    this.width = upper-lower;
	}
	
	/**
	 * @return Returns the double value that is needed for the events washtime.
	 */
	public double next() {
	    return lower+rand.nextDouble()*width;
	}
}