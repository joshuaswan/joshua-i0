package com.joshua.i0.gradle.facets.frameworks

import com.joshua.i0.gradle.core.ApplicationFacet
import org.gradle.api.Project

class Jersey implements ApplicationFacet {
    String version = "1.16"

    @Override
    void generateScaffold(Project project) {
    }

    @Override
    void configure(Project project) {
        I0 i0 = project.application.find(I0)
        project.application.stackAnnotations.add("@com.joshua.i0.jersey.RestApi")
        project.dependencies {
            compile("com.joshua.i0:i0-jersey:$i0.version") {
                transitive = false
            }

            compile "com.sun.jersey:jersey-core:$version"
            runtime "com.sun.jersey:jersey-server:$version"
            runtime "com.sun.jersey:jersey-json:$version"
            runtime "com.sun.jersey:jersey-servlet:$version"
            runtime "com.sun.jersey.contribs:jersey-guice:$version"

            runtime "com.fasterxml.jackson.jaxrs:jackson-jaxrs-json-provider:$i0.jackson"

            testCompile "com.sun.jersey:jersey-client:$version"
        }
    }
}
