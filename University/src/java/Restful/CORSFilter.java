/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restful;

import static com.google.common.net.HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS;
import static com.google.common.net.HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS;
import static com.google.common.net.HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS;
import static com.google.common.net.HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN;
import static com.google.common.net.HttpHeaders.ACCESS_CONTROL_MAX_AGE;
import javax.inject.Singleton;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Singleton
@Provider
public class CORSFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        final int ACCESS_CONTROL_MAX_AGE_IN_SECONDS = 12 * 60 * 60;
        MultivaluedMap<String, Object> headers = responseContext.getHeaders();

        headers.add(ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        headers.add(ACCESS_CONTROL_ALLOW_HEADERS, "origin, content-type, accept, authorization");
        headers.add(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
        headers.add(ACCESS_CONTROL_ALLOW_METHODS, "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        headers.add(ACCESS_CONTROL_MAX_AGE, ACCESS_CONTROL_MAX_AGE_IN_SECONDS);

    }
}
