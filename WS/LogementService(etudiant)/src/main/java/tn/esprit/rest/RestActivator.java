package tn.esprit.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

@ApplicationPath("api")

public class RestActivator extends Application {
	
	public RestActivator() {
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setVersion("1.0.2");
		beanConfig.setSchemes(new String[]{"http"});
		beanConfig.setHost("localhost:8080");
		beanConfig.setBasePath("LogementService/api");
		beanConfig.setPrettyPrint(true);
		beanConfig.setResourcePackage("io.swagger.resources");
		beanConfig.setResourcePackage("tn.esprit.rest");
		beanConfig.setScan(true);
		}

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet<Class<?>>();
		resources.add(RendezVousRessource.class);
		resources.add(LogementRessource.class);
		resources.add(ApiListingResource.class);
		resources.add(SwaggerSerializers.class);
		return resources;

	}

}
