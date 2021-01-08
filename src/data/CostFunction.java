package data;

public class CostFunction 
{
	public static double calculateCost(double[] theta, double[][] x, double[] y)
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
		return 0;
	}
}
