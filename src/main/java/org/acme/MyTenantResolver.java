package org.acme;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import io.quarkus.arc.Unremovable;
import io.quarkus.hibernate.orm.runtime.tenant.TenantResolver;
import io.vertx.ext.web.RoutingContext;

@RequestScoped
@Unremovable
public class MyTenantResolver implements TenantResolver {

    private static final Logger LOG = Logger.getLogger(MyTenantResolver.class);

    @Inject
    RoutingContext context;
    
    @Override
    public String getDefaultTenantId() {
        return "base";
    }

    @Override
    public String resolveTenantId() {
        String path = context.request().path();
        final String tenantId;
        if (path.startsWith("/mycompany")) {
            tenantId = "mycompany";
        } else {
            tenantId = getDefaultTenantId();
        }
        LOG.debugv("TenantId = {0}", tenantId);
        return tenantId;
    }

}
