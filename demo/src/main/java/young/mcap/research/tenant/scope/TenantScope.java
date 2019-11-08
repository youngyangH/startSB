package young.mcap.research.tenant.scope;


import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import young.mcap.research.tenant.TenantScopeInstance;

public class TenantScope implements Scope {

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        return new TenantScopeInstance();
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
