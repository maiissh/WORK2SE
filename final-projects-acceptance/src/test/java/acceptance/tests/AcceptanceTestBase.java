package acceptance.tests;

import acceptance.bridge.Driver;
import acceptance.bridge.ProjectSystemBridge;
import org.junit.Before;

// every test class gets an object that implements the bridge interface.
// the tests don't know if it is the stub or the real system.
public abstract class AcceptanceTestBase {

    protected ProjectSystemBridge bridge;

    @Before
    public void connectToSystem() {
        bridge = Driver.getBridge();
    }
}
