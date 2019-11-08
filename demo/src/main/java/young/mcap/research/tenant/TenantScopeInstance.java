package young.mcap.research.tenant;

import org.springframework.stereotype.Component;
import young.mcap.research.tenant.scope.annotation.TenantScope;

@TenantScope
@Component
public class TenantScopeInstance {
    public void getTenantScopes() {

    }
}
