package abstract_factory.factory;

public abstract class Factory {
    public static Factory getFactory(String classname) {
        try {
            return (Factory) Class.forName(classname)
                    .getDeclaredConstructor()
                    .newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public abstract Link createLink(String caption, String url);
    public abstract Tray createTray(String caption);
    public abstract Page createPage(String title, String author);
}
