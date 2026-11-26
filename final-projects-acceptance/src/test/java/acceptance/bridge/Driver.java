package acceptance.bridge;

// chooses which implementation the tests get.
// default: the stub only.
// to connect the real system run with: -Dbridge.real=<full class name of the real bridge>
public class Driver {

    public static ProjectSystemBridge getBridge() {
        ProxyBridge proxy = new ProxyBridge();

        String realClassName = System.getProperty("bridge.real");
        if (realClassName != null && !realClassName.isBlank()) {
            try {
                Object real = Class.forName(realClassName).getDeclaredConstructor().newInstance();
                proxy.setRealBridge((ProjectSystemBridge) real);
            } catch (Exception e) {
                throw new RuntimeException("could not create real bridge: " + realClassName, e);
            }
        }
        return proxy;
    }
}
