package base;

public class BasePresenter<V extends BaseView> {

    private V mView;

    public BasePresenter() {
    }

    /**
     * 绑定view，一般在初始化中调用该方法
     *
     * @param view view
     */
    public void attachView(V view) {
        this.mView = view;
    }

    /**
     * 解除绑定view，一般在onDestroy中调用
     */

    public void detachView() {
        this.mView = null;
    }

    public boolean isViewAttached() {
        return mView != null;
    }

    public V getView() {
        return mView;
    }
}
