package data;

public class Data 
{
	/**
	 * 
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
	 * 
	 * @param theta The coefficient vector [i x 1] sized
	 * @param x The input matrix [i x k] sized
	 * @param y The training output vector [k x 1] sized
	 * @param alpha The descent coefficent
	 */
	public static void linearGradientDescent(double[] theta, double[][] x, double[] y, double alpha)
	{
		return;
	}
	
	public static double calculateLogisticCost(double[] theta, double[][] x, double[] y)
	{
		return 0;
	}
	
	public static void logisticalGradientDescent(double[] theta, double[][] x, double[] y, double alpha)
	{
		return;
	}
	

}
