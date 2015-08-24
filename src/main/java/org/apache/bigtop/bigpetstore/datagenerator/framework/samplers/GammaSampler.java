package org.apache.bigtop.bigpetstore.datagenerator.framework.samplers;

import org.apache.bigtop.bigpetstore.datagenerator.framework.SeedFactory;
import org.apache.commons.math3.distribution.GammaDistribution;

public class GammaSampler implements Sampler<Double>
{
	private final GammaDistribution gamma;
	
	public GammaSampler(double k, double theta, SeedFactory seedFactory)
	{
		gamma = new GammaDistribution(k, theta);
		gamma.reseedRandomGenerator(seedFactory.getNextSeed());
	}
	
	public Double sample()
	{
		return gamma.sample();
	}
}
