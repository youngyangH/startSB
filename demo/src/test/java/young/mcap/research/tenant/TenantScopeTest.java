package young.mcap.research.tenant;

import com.example.demo.configuration.H2Configuration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TenantScopeInstance.class)
@Import({H2Configuration.class})
public class TenantScopeTest {

    @Autowired
    private TenantScopeInstance tenantScopeInstance;

    @Test
    public void testTenantScope() {
        Assert.assertNotNull(tenantScopeInstance);
    }
}
