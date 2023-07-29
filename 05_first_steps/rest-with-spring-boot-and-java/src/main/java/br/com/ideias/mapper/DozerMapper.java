package br.com.ideias.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;



public class DozerMapper {

	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	private static ModelMapper modelMapper = new ModelMapper();

	public static <O, D> D parseObject(O origin, Class<D> destination) {
		return mapper.map(origin, destination);
	}

	public static <O, D> List<D> parseListObject(List<O> origin, Class<D> destination) {
		List<D> destinationObjects = new ArrayList<D>();

		for (O o : origin) {
			destinationObjects.add(mapper.map(o, destination));
		}

		return destinationObjects;
	}
	
	public static <O, D> List<D> parseListMapper(List<O> origin, Class<D> destination) {
		List<D> destinationObjects = new ArrayList<D>();

		for (O o : origin) {
			destinationObjects.add(modelMapper.map(o, destination));
		}

		return destinationObjects;
	}

}
