package br.udemy.andre.person.mapper;


import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class PersonMapper {

    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <O, D> D parseObject(O origin, Class<D> destinationClass) {
        return mapper.map(origin, destinationClass);
    }
    public static <O, D> List<D> parseListObject(List<O> origin, Class<D> destinationClass) {
        List<D> destination = new ArrayList<D>();
        for (O o : origin) {
            destination.add(mapper.map(o, destinationClass));
        }
        return destination;
    }
}
