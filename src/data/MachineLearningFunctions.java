package data;

public class MachineLearningFunctions 
{
	/**
	 * Calculating the cost for a linear function
	 * @param theta The coefficient vector [i x 1] sized
	 * @param x The input matrix [i x k] sized
	 * @param y The training output vector [k x 1] sized
	 * @return The cost of the given parameters
	 */
	public static double calculateLinearCost(double[] theta, double[][] x, double[] y)
	{
		assert x.length == y.length;
		assert x[0].length == theta.length;
		
		long sum = 0;
		
		for (int i = 0; i < y.length; ++i)
		{
			int prediction = 0;
			for (int j = 0; j < theta.length; ++j)
			{
				prediction += theta[j] * x[i][j];
			}
			sum += Math.pow(prediction - y[i], 2);
		}
		return sum / y.length;
	}
	
	/**
	 * Performing gradient descent on a linear function
	 * @param theta The coefficient vector [i x 1] sized
	 * @param x The input matrix [i x k] sized
	 * @param y The training output vector [k x 1] sized
	 * @param alpha The descent coefficient
	 * @param interations The number of times gradient descent is performed
	 */
	public static void linearGradientDescent(double[] theta, double[][] x, double[] y, double alpha, int interations)
	{
		assert x.length == y.length;
		assert x[0].length == theta.length;
		assert alpha != 0;
		
		for (int i = 0; i < interations; i++)
		{
			double[] temp = new double[theta.length];
			for (int j = 0; j < theta.length; j++)
			{
				theta[j] = 0; 				//TODO update theta[j]
			}
			theta = temp;
		}
	}
	
	/**
	 * Calculating the cost for a logistic function
	 * @param theta The coefficient vector [i x 1] sized
	 * @param x The input matrix [i x k] sized
	 * @param y The training output vector [k x 1] sized
	 * @return The cost of the given parameters
	 */
	public static double calculateLogisticCost(double[] theta, double[][] x, double[] y)
	{
		assert x.length == y.length;
		assert x[0].length == theta.length;
		return 0;
	}
	
	/**
	 * Performing gradient descent on a logistical function
	 * @param theta The coefficient vector [i x 1] sized
	 * @param x The input matrix [i x k] sized
	 * @param y The training output vector [k x 1] sized
	 * @param alpha The descent coefficient
	 * @param interations The number of times gradient descent is performed
	 * @post theta has new values
	 */
	public static void logisticalGradientDescent(double[] theta, double[][] x, double[] y, double alpha, int interations)
	{
		assert x.length == y.length;
		assert x[0].length == theta.length;
		assert alpha != 0;
		return;
	}
	
	/**
	 * Performing the sigmoidFunction on the input
	 * @param hx The number to get sigmoided
	 * @return A value between 0 and 1
	 */
	public static double sigmoidFuction(double hx)
	{
		assert hx > 0;
		return 1 / (1 + Math.pow(Math.E, -1 * hx));
	}
	
	/**
	 * Rounds a sigmoid output to a 0 or a 1
	 * @param x The value to get rounded
	 * @return 0 or 1, 
	 */
	public static int to1or0(double x)
	{
		assert (x > 0 && x < 1);
		return (int)(x + 0.5);
	}
	

}
