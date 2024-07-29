package net.media.training.designpattern.decorator;

public class BaseCriteriaEval implements Criteria{
    public final Criteria wrapped;
    BaseCriteriaEval(Criteria wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public boolean evaluate(Application theApp) {
        return this.wrapped.evaluate(theApp);
    }
}
