package base;

/**
 * 基础契约：
 * MVP在实现代码简洁的同时，额外增加了大量的接口、类，不方便进行管理，于是Contract 就登场了。
 *
 * Contract 百度翻译 : 合同;契约;协议
 * Contract 如其名，是一个契约，将 Model、View、Presenter 进行约束管理，方便后期类的查找、维护。
 */
public interface BaseContract {

    interface View {
        /**
         * 视图 网络状况
         * @return
         */
        boolean isNetworkConnected();

        /**
         * 显示错误的 信息
         * @param message msg信息
         */
        void showError(String message);
    }

    interface Presenter<V extends BaseContract.View> {
        void attachView(V view);
        void detachView();
    }

}
