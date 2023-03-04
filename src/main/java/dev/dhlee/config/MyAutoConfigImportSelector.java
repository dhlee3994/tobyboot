package dev.dhlee.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigImportSelector implements DeferredImportSelector {

    @Override
    public String[] selectImports(final AnnotationMetadata importingClassMetadata) {
        return new String[] {
                "dev.dhlee.config.autoconfig.DispatcherServletConfig",
                "dev.dhlee.config.autoconfig.TomcatWebServerConfig"
        };
    }
}
