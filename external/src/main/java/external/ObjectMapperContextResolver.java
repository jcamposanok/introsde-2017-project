package external;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import external.entity.fatsecret.Month;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;


@Provider
public class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {

    final ObjectMapper listMapper = new ObjectMapper();
    final ObjectMapper defaultMapper = new ObjectMapper();

    public ObjectMapperContextResolver() {
        listMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);

        listMapper.registerModule(new JaxbAnnotationModule());
        defaultMapper.registerModule(new JaxbAnnotationModule());
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        if (type == Month.class) {
            return listMapper;
        }
        return defaultMapper;
    }
}
