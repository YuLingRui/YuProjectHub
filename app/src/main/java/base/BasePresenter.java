package base;

public class BasePresenter <V extends BaseContract.View> implements BaseContract.Presenter<V> {

    private V view;

    public BasePresenter(){}

    @Override
    public void attachView(V view) {

    }

    @Override
    public void detachView() {

    }

    public boolean isViewAttached() {
        return view != null;
    }

    public V getView() {
        return view;
    }
}
