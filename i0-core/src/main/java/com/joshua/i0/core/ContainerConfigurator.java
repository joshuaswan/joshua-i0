package com.joshua.i0.core;

import com.joshua.i0.config.Configuration;

import java.lang.annotation.Annotation;

public interface ContainerConfigurator<AnnotationType extends Annotation, ConfigurationType extends Configuration, ContainerType extends ServletContainer> extends FacetEnabler {
    void configure(ContainerType container, AnnotationType annotation, ApplicationModule<ConfigurationType> module) throws Exception;
}
