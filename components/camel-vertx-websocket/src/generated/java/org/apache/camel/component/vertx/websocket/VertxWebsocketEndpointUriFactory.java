/* Generated by camel build tools - do NOT edit this file! */
package org.apache.camel.component.vertx.websocket;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.camel.spi.EndpointUriFactory;

/**
 * Generated by camel build tools - do NOT edit this file!
 */
public class VertxWebsocketEndpointUriFactory extends org.apache.camel.support.component.EndpointUriFactorySupport implements EndpointUriFactory {

    private static final String BASE = ":host:port/path";

    @Override
    public boolean isEnabled(String scheme) {
        return "vertx-websocket".equals(scheme);
    }

    @Override
    public String buildUri(String scheme, Map<String, Object> parameters) throws URISyntaxException {
        String syntax = scheme + BASE;
        String uri = syntax;

        Map<String, Object> copy = new HashMap<>(parameters);

        uri = buildPathParameter(syntax, uri, "host", "0.0.0.0", false, copy);
        uri = buildPathParameter(syntax, uri, "port", "0", false, copy);
        uri = buildPathParameter(syntax, uri, "path", "/", true, copy);
        uri = buildQueryParameters(uri, copy);
        return uri;
    }
}
