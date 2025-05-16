package me.choicore.samples.monorepo.test.context.container;

import jakarta.annotation.Nonnull;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.io.InputStream;
import java.net.URL;
import java.util.*;

public class ContainerTestImportSelector implements ImportSelector {
    private static final String CONTAINER_PROPS = "META-INF/containers.properties";

    @Nonnull
    @Override
    public String[] selectImports(@Nonnull final AnnotationMetadata importingClassMetadata) {
        Map<String, Object> attributes = Optional.ofNullable(
                importingClassMetadata.getAnnotationAttributes(ContainerTest.class.getName())
        ).orElse(Collections.emptyMap());

        ContainerType[] requested = (ContainerType[]) attributes.get("containers");
        if (requested == null || requested.length == 0) {
            requested = ContainerType.values(); // fallback to all
        }

        Map<String, String> mappings = loadContainerTestProperties();

        List<String> imports = new ArrayList<>();
        for (ContainerType container : requested) {
            String fqcn = mappings.get(container.name());
            if (fqcn != null) {
                imports.add(fqcn);
            }
        }

        return imports.toArray(new String[0]);
    }

    private Map<String, String> loadContainerTestProperties() {
        Map<String, String> results = new HashMap<>();

        try {
            Enumeration<URL> resources = Thread.currentThread()
                    .getContextClassLoader()
                    .getResources(CONTAINER_PROPS);

            while (resources.hasMoreElements()) {
                URL url = resources.nextElement();
                try (InputStream input = url.openStream()) {
                    Properties props = new Properties();
                    props.load(input);
                    for (String key : props.stringPropertyNames()) {
                        results.put(key, props.getProperty(key));
                    }
                }
            }

        } catch (Exception e) {
            throw new IllegalStateException("Failed to load container-test mappings", e);
        }

        return results;
    }
}