import com.google.inject.AbstractModule;
import play.api.Configuration;
import play.api.Environment;
import services.OnStartupService;


public class GlobalConfigurationModule extends AbstractModule {

    private final Environment environment;
    private final Configuration configuration;

    public GlobalConfigurationModule(Environment environment, Configuration configuration) {
        this.environment = environment;
        this.configuration = configuration;
    }

    @Override
    protected void configure() {

        // load this after the server starts only once
        bind(OnStartupService.class).asEagerSingleton();
    }

    //public Seq<Binding<?>> bindings(Environment environment, Configuration configuration) {
    //    return seq(
    //            bind(MyComponent.class).to(MyComponentImpl.class)
    //    );
    //}

}
