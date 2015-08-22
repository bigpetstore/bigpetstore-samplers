package org.apache.bigtop.bigpetstore.datagenerator.framework.wfs;

import java.util.Map;

import org.apache.bigtop.bigpetstore.datagenerator.framework.pdfs.MultinomialPDF;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

public class MultinomialWF<T> implements DiscreteWeightFunction<T, MultinomialPDF<T>>
{
	private final ImmutableMap<T, Double> weights;
	
	public MultinomialWF(Map<T, Double> weights)
	{
		this.weights = ImmutableMap.copyOf(weights);
	}
	
	public double weight(T value)
	{
		return weights.get(value);
	}
	
	public MultinomialPDF<T> normalize()
	{
		double norm = 0.0;
		for(double w : weights.values())
		{
			norm += w;
		}
		
		Map<T, Double> prob = Maps.newHashMap();
		for(Map.Entry<T, Double> entry : weights.entrySet())
		{
			prob.put(entry.getKey(), entry.getValue() / norm);
		}
		
		return new MultinomialPDF<T>(prob);
	}
}
