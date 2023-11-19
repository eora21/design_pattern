package chain_of_responsibility;

import java.util.Objects;

public abstract class Support {
    private final String name;
    private Support next;

    public Support(String name) {
        this.name = name;
    }

    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    public void support(Trouble trouble) {
        if (resolve(trouble)) {
            done(trouble);
            return;
        }

        if (Objects.nonNull(next)) {
            next.support(trouble);
            return;
        }

        fail(trouble);
    }

    protected abstract boolean resolve(Trouble trouble);

    private void done(Trouble trouble) {
        System.out.println(trouble + " is resolved by [" + this.name + "].");
    }

    private void fail(Trouble trouble) {
        System.out.println(trouble + " cannot be resolved.");
    }
}
