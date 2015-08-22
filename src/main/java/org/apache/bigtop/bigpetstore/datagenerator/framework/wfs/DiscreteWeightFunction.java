package org.apache.bigtop.bigpetstore.datagenerator.framework.wfs;

import org.apache.bigtop.bigpetstore.datagenerator.framework.pdfs.ProbabilityDensityFunction;

public interface DiscreteWeightFunction<T, P extends ProbabilityDensityFunction<T>> extends WeightFunction<T>
{
	public P normalize();
}
